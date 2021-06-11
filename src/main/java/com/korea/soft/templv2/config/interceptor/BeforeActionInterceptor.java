package com.korea.soft.templv2.config.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.korea.soft.templv2.config.auth.PrincipalDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;


@Slf4j
@RequiredArgsConstructor
@Component("beforeActionInterceptor") // 컴포넌트 이름 설정
public class BeforeActionInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("===============================> 인터셉터 호출 preHandle url : {}",request.getRequestURI());
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        log.info("로그인 됬는지 여부 {}", authentication.getPrincipal() instanceof PrincipalDetails);
//        if ( authentication.getPrincipal() instanceof PrincipalDetails){
//            PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
//            log.info("로그인 정보 = {}", principal.getUser());
//        }
//        Cookie authKeyCookie = WebUtils.getCookie(request, "authKey");
//        if(authKeyCookie != null){
//            log.info("쿠키 테스트 1==============================> {}", authKeyCookie); //$2a$10$UjUuWQn/MzCzVPs0LWGgVu35PcWUhgXjbXH811PYk.biyc/UA.oWa
//            String authKey = authKeyCookie.getValue();
//            log.info("쿠키 테스트 2==============================> {}", authKey);
//        }

        Map<String, Object> param = new HashMap<>();

        Enumeration<String> parameterNames = request.getParameterNames();

        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            Object paramValue = request.getParameter(paramName);

            param.put(paramName, paramValue);
        }

        ObjectMapper mapper = new ObjectMapper();
        String paramJson = mapper.writeValueAsString(param);

        String requestUri = request.getRequestURI();
        String queryString = request.getQueryString();

        String requestUriQueryString = requestUri;
        if (queryString != null && queryString.length() > 0) {
            requestUriQueryString += "?" + queryString;
        }

        String urlEncodedRequestUriQueryString = URLEncoder.encode(requestUriQueryString, "UTF-8");
        // 1. 작업의 편의성
        request.setAttribute("requestUriQueryString", requestUriQueryString); //현재 URL 위치
        request.setAttribute("urlEncodedRequestUriQueryString", urlEncodedRequestUriQueryString); // 현재 url 인코딩
        request.setAttribute("param", param); // ${param.} 으로 모든 파라미터를 접근가능 하게 설정
        request.setAttribute("paramJson", paramJson); // ${param.} 로 모든 파라미터를 접근가능 하게 설정 JSON 버전으로

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("===============================> 인터셉터 호출 postHandle url : {}", request.getRequestURI());

        // 구매수량
//        int orderTotalCnt = 0;
//        int LOGIN_MEM_SQ = 0;
//
//        if (session.getAttribute("LOGIN_MEM_SQ") != null) {
//            LOGIN_MEM_SQ = (int) session.getAttribute("LOGIN_MEM_SQ");
//            // 누적 구매수량 체크
//            orderTotalCnt = orderService.getOrderTotalCnt(LOGIN_MEM_SQ);
//        }
//        request.setAttribute("orderTotalCnt", orderTotalCnt);
    }
}
