package com.korea.soft.templv2.web.api;


import com.korea.soft.templv2.domain.common.CommonDto;
import com.korea.soft.templv2.domain.dto.sms.AuthCkReqDto;
import com.korea.soft.templv2.domain.dto.sms.SmsSendDto;
import com.korea.soft.templv2.service.SmsService;
import com.korea.soft.templv2.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RestController
public class SmsApiController {
    private final UserService userService;
    private final SmsService smsService;
    private final AuthenticationManager authenticationManager;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @PostMapping("/auth/smsSend")
    public CommonDto<?> authSmsSend(@Valid @RequestBody SmsSendDto smsSendDto, BindingResult bindingResult, HttpServletResponse response){

        log.info("파라미터 =====> {}",smsSendDto);
        smsService.인증번호요청(smsSendDto, response);

        return new CommonDto<String>(HttpStatus.OK.value(),"문자가 발송 되었습니다. 인증번호를 확인해주세요");
    }

    @PostMapping("/auth/authKeyCk")
    public CommonDto<?> authKeyCk(@Valid @RequestBody AuthCkReqDto authCkReqDto, HttpServletRequest request, HttpServletResponse response){
        log.info("파라미터 =====> {}",authCkReqDto);
        smsService.인증번호확인(authCkReqDto, request, response);
        return new CommonDto<String>(HttpStatus.OK.value(),"인증성공");
    }
}
