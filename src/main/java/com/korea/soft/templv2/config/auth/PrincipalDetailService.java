package com.korea.soft.templv2.config.auth;


import com.korea.soft.templv2.common.ClientIpResolver;
import com.korea.soft.templv2.domain.common.TableStatus;
import com.korea.soft.templv2.domain.entity.User;
import com.korea.soft.templv2.repository.UserDynamicQuery;
import com.korea.soft.templv2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service // Bean 등록
public class PrincipalDetailService implements UserDetailsService {


    private final UserRepository userRepository;
    private final UserDynamicQuery userDynamicQuery;

    private final ClientIpResolver clientIpResolver;



    // 스프링이 로그인 요청을 가로챌 때, username,password 변수 2개를 가로채는데
    // password 부분 처리는 알아서 함.
    // username이 DB에 있는지만 확인해주면 됨.
    // !! 중요 : 함수종료시 @ AuthenticationPrincipal 어노테이션이 만들어진다 (Oauth도 동일하다)
    @SneakyThrows
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException { // 2. user 로그인 정보가 맞는지 비교
        log.info("유저 정보 ========================>  {}", userId);
        User principal = userRepository.findByUserId(userId).orElseThrow(()->{
            return new BadCredentialsException("아이디 또는 비밀번호가 틀립니다.");
        });
        if(principal.getUseYn() != TableStatus.Y) throw new AuthenticationServiceException("관리자 승인대기중인 아이디입니다.");


        // 접속시 마지막 접속 아이피로 업데이트
        principal.setLastAccessIp(clientIpResolver.getUserIp());

        return new PrincipalDetails(principal); // 시큐리티의 세션에 유저 정보가 저장되는 타이밍
    }





}
