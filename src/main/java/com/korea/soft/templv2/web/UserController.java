package com.korea.soft.templv2.web;

import com.korea.soft.templv2.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// 인증이 안된 사용자들이 출입할 수 있는 경로를 /auth/** 허용
// 그냥 주소가 / 이면 index.jsp 허용
// static 이하에 있는 /js/**,/css/**,/image/**

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {

    @Value("${koreaSoft.key}")
    private String koreaSoftKey;

    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    @GetMapping("/auth/user/join")
    public String join() {
        return "user/join";
    }

    @RequestMapping(value = "/auth/user/login" , method = {RequestMethod.GET, RequestMethod.POST})
    public String login() {
        return "user/login";
    }

    @GetMapping("/auth/user/find_id")
    public String find_id() {
        return "user/find_id";
    }

    @GetMapping("/auth/user/find_password")
    public String find_password() {
        return "user/find_password";
    }


    @RequestMapping(value = "/auth/loginForm", method = {RequestMethod.GET, RequestMethod.POST})
    public String loginForm() {

        return "user/loginForm";
    }

    @GetMapping("/user/updateForm")
    public String updateForm() {
        return "user/updateForm";
    }

    @GetMapping("/user/updatePassForm")
    public String updatePassForm() {
        return "user/update_password";
    }

}
