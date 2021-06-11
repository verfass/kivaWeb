package com.korea.soft.templv2.web.api;


import com.korea.soft.templv2.domain.common.CommonDto;
import com.korea.soft.templv2.domain.dto.user.*;
import com.korea.soft.templv2.domain.entity.User;
import com.korea.soft.templv2.service.SmsService;
import com.korea.soft.templv2.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RestController
public class UserApiController {
    private final UserService userService;
    private final SmsService smsService;
    private final AuthenticationManager authenticationManager;


    @PostMapping("/auth/user/join")
    public CommonDto<?> join(@Valid @RequestBody UserJoinReqDto userJoinReqDto, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response){
        log.info("파라미터 확인 ==============> {}",userJoinReqDto);
        userService.회원가입(userJoinReqDto, request, response);
        return new CommonDto<String>(HttpStatus.OK.value(), "회원가입이 신청이 완료되었습니다.\n관리자 승인후 이용가능합니다.");
    }

    @GetMapping("/auth/user/id")
    public CommonDto<?> findById(@Valid FindByIdReqDto findByIdReqDto, BindingResult bindingResult){
        userService.findById(findByIdReqDto);
        return new CommonDto<String>(HttpStatus.OK.value(), "사용가능한 아이디 입니다.");
    }

    @PostMapping("/auth/user/find/Id")
    public CommonDto<?> findId(@Valid @RequestBody UserFindIdDto userFindIdDto, BindingResult bindingResult, HttpServletRequest request){
        log.info("파라미터 확인 ==============> {}",userFindIdDto);
        userService.아이디찾기(userFindIdDto);
        return new CommonDto<String>(HttpStatus.OK.value(), "회원가입시 입력하신 연락처로 아이디가 발송되었습니다.");
    }
    @PostMapping("/auth/user/find/password")
    public CommonDto<?> findPassword(@Valid @RequestBody UserFindPasswordDto userFindPasswordDto, BindingResult bindingResult, HttpServletRequest request){
        log.info("파라미터 확인 ==============> {}",userFindPasswordDto);
        userService.비밀번호찾기(userFindPasswordDto);
        return new CommonDto<String>(HttpStatus.OK.value(), "회원가입시 입력하신 연락처로 임시비밀번호가 발송되었습니다.");
    }


    @PutMapping("/auth/user")
    public CommonDto<?> changePassword(@Valid @RequestBody UserChangePasswordReqDto userChangePasswordReqDto, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response){
        log.info("파라미터 확인 ==============> {}",userChangePasswordReqDto);
        userService.비밀번호변경(userChangePasswordReqDto);
        return new CommonDto<String>(HttpStatus.OK.value(), "비밀번호가 정상적으로 변경되었습니다.");
    }

}
