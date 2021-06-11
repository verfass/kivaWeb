package com.korea.soft.templv2.config;

import com.korea.soft.templv2.config.auth.PrincipalDetails;
import com.korea.soft.templv2.domain.common.RoleType;
import com.korea.soft.templv2.domain.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Slf4j
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
        
    private RequestCache requestCache = new HttpSessionRequestCache();
    private RedirectStrategy redirectStratgy = new DefaultRedirectStrategy();


    //region [로그인 성공 작업 나열]
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        // 1. 에러 세션 지우기
        clearAuthenticationAttributes(request);
        // 2. 로그인 성공후 이동 경로
        resultRedirectStrategy(request, response, authentication);
        
    }
    //endregion

    //region [로그인 에러세션 지우기]
//    로그인을 하는 과정에서 한번만에 로그인에 성공할 수도 있지만, 실패를 한 후 로그인에 성공하는 경우도 있다.
//    이처럼 로그인에 실패하는 상황이 한번이라도 발생한다면, 에러가 세션에 저장되어 남아있게 된다.
//    로그인에 성공했다고 하지만 이렇게 세션에 에러가 남겨진 채로 넘어갈 수는 없다.
//    따라서 로그인 성공 핸들러에서 에러 세션을 지우는 작업을 해줘야 한다.
    protected void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session==null) return;
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }
    //endregion

    //region [로그인 성공시 이동 경로]
    protected void resultRedirectStrategy(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
        User user = principal.getUser();
        RoleType roleType= user.getRole().getRoleType();
        log.info("로그인 성공 룰 확인===================> {}", roleType);

        SavedRequest savedRequest = requestCache.getRequest(request, response);
        if(savedRequest!=null) { //- 인증 권한이 필요한 페이지에 접근했을 때
            String targetUrl = savedRequest.getRedirectUrl(); //getRedirectUrl (로그인화면을 보기 전에 갔던 url)을 가져온다.
            redirectStratgy.sendRedirect(request, response, targetUrl);
        } else { // - 직접 로그인 페이지로 접근했을 때
            String redirectUrl = "/";
//            switch (roleType){
//                case ADMIN: redirectUrl = "";
//                            break;
//                case MANAGER: redirectUrl = "";
//            }

            redirectStratgy.sendRedirect(request, response, redirectUrl);
        }
    }
    //endregion

}