package com.korea.soft.templv2.service;

import com.korea.soft.templv2.common.ClientIpResolver;
import com.korea.soft.templv2.config.auth.PrincipalDetails;
import com.korea.soft.templv2.domain.common.RoleType;
import com.korea.soft.templv2.domain.common.TableStatus;
import com.korea.soft.templv2.domain.dto.sms.SmsSendDto;
import com.korea.soft.templv2.domain.dto.user.*;
import com.korea.soft.templv2.domain.entity.*;
import com.korea.soft.templv2.repository.ClassRoomRepository;
import com.korea.soft.templv2.repository.RoleRepository;
import com.korea.soft.templv2.repository.UserDynamicQuery;
import com.korea.soft.templv2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.ThreadLocalRandom;

// 서비스를 하는 이유
// 1. 트랜잭션 관리를 위해
// 2. 서비스 의미 때문에


// 스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해줌. IOC를 해준다.
@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserDynamicQuery userDynamicQuery;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;
    private final ClientIpResolver clientIpResolver;
    private final RoleRepository roleRepository;
    private final ClassRoomRepository classRoomRepository;
    private final SmsService smsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @SneakyThrows
    @Transactional
    public void 회원가입(UserJoinReqDto joinReqDto, HttpServletRequest request, HttpServletResponse response){

        User userEntity = userRepository.findByUserId(joinReqDto.getUserId()).orElseGet(() -> {
            return null;
        });
        if(userEntity != null){
            throw new IllegalArgumentException("아이디가 중복됩니다.");
        }

        String rawPassword = joinReqDto.getPassword();
        String encPassword = encoder.encode(rawPassword);
        Role role = roleRepository.findById(RoleType.KID.getRoleInt()).orElseThrow(()->{
            return new IllegalArgumentException("권한 에러");
        });
        log.info("role =========> {}",role);
        ClassRoom classRoom = classRoomRepository.findById(joinReqDto.getClassId()).orElseThrow(()->{
            return new IllegalArgumentException("기관이 존재하지 않습니다.");
        });
        Kindergarten kindergarten = classRoom.getKindergarten();
        Manager manager = kindergarten.getManager();


        User user = User.builder()
                .UserId(joinReqDto.getUserId())
                .Password(encPassword)
                .UserName(joinReqDto.getUserName())
                .CellPhone(joinReqDto.getCellPhone())
                .UseYn(TableStatus.N)
                .role(role)
                .FirstAccessIp(clientIpResolver.getUserIp())
                .classRoom(classRoom)
                .kindergarten(kindergarten)
                .manager(manager)
                .build();
        userRepository.save(user);
        smsService.인증여부확인(request, response);
    }


    @Transactional
    public User 회원찾기(String username) {
        User user = new User();
//        User user = userRepository.findByUsername(username).orElseGet(()->{
//                        return null;
//                    });
        return user;
    }

    @Transactional
    public void findById(FindByIdReqDto findByIdReqDto) {
        User user = userRepository.findByUserId(findByIdReqDto.getUserId()).orElseGet(()->{
                    return null;
        });
        if( user != null){
            throw new IllegalArgumentException("중복된 아이디가 존재합니다.");
        }
    }

    @Transactional
    public void 아이디찾기(UserFindIdDto userFindIdDto) {
        User user = userDynamicQuery.findByUsernameAndCellPhone(userFindIdDto);
        if( user == null){
            throw new IllegalArgumentException("존재하지 않는 사용자입니다.");
        }
        SmsSendDto smsSendDto = SmsSendDto.builder()
                .CellPhone(userFindIdDto.getCellPhone())
                .Msg("고객님의 아이디는 ["+user.getUserId()+"]입니다.")
                .build();
        smsService.문자전송(smsSendDto);
    }
    @Transactional
    public void 비밀번호찾기(UserFindPasswordDto userFindPasswordDto) {
        log.info("비밀번호 확인");
        User user = userDynamicQuery.findByUsernameAndCellPhoneAndUserId(userFindPasswordDto);
        if( user == null){
            throw new IllegalArgumentException("존재하지 않는 사용자입니다.");
        }
        String tempPassword = 임시비밀번호생성();
        log.info(tempPassword);
        String encryPassword = encoder.encode(tempPassword);
        user.setPassword(encryPassword);
        SmsSendDto smsSendDto = SmsSendDto.builder()
                .CellPhone(userFindPasswordDto.getCellPhone())
                .Msg("고객님의 임시비밀번호는 ["+tempPassword+"]입니다.")
                .build();
        smsService.문자전송(smsSendDto);


    }

    private String 임시비밀번호생성() {
        int preFix= ThreadLocalRandom.current().nextInt(10, 1000);
        log.info(preFix+"");
        int subFix = ThreadLocalRandom.current().nextInt(10, 1000);
        log.info(subFix+"");
        String tempPass = "$"+preFix+"meta"+subFix;
        return tempPass;

    }

    @Transactional
    public void 비밀번호변경(UserChangePasswordReqDto userChangePasswordReqDto) {
        PrincipalDetails principal = (PrincipalDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = principal.getUser();
        boolean isPasswordOk = bCryptPasswordEncoder.matches(userChangePasswordReqDto.getPassword(),user.getPassword());
        if (!isPasswordOk){
            throw new IllegalArgumentException("비밀번호가 틀립니다.");
        }
        String encPassword = bCryptPasswordEncoder.encode(userChangePasswordReqDto.getChangePassword());
        user.setPassword(encPassword);
        userRepository.save(user);

    }
}
