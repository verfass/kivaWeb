package com.korea.soft.templv2.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/* 로그인 실패 대응 로직 */
@Slf4j
@Component
public class LoginFailHandler implements AuthenticationFailureHandler {
	@Value("${custom.loginPath}")
	private String loginPath;

	@Override
	public void onAuthenticationFailure(HttpServletRequest request,
										HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {

		String failMsg = "";
		if (exception instanceof AuthenticationServiceException) {
//			request.setAttribute("loginFailMsg", "존재하지 않는 사용자입니다.");
			failMsg = exception.getMessage();
		} else if (exception instanceof BadCredentialsException) {
//			request.setAttribute("loginFailMsg", "아이디 또는 비밀번호가 틀립니다.");
			failMsg = "아이디 또는 비밀번호가 틀립니다.";

		} else if (exception instanceof AccountStatusException){

		} else if (exception instanceof LockedException) {
//			request.setAttribute("loginFailMsg", "잠긴 계정입니다..");
			failMsg = "잠긴 계정입니다..";
		} else if (exception instanceof DisabledException) {
//			request.setAttribute("loginFailMsg", "비활성화된 계정입니다..");
			failMsg = "비활성화된 계정입니다..";
		} else if (exception instanceof AccountExpiredException) {
//			request.setAttribute("loginFailMsg", "만료된 계정입니다..");
			failMsg = "만료된 계정입니다..";
		} else if (exception instanceof CredentialsExpiredException) {
//			request.setAttribute("loginFailMsg", "비밀번호가 만료되었습니다.");
			failMsg = "비밀번호가 만료되었습니다.";
		}


		// 로그인 페이지로 다시 포워딩
		log.info("로그인 fail 호출 ==========================> {}", loginPath);
		String encodingParam = URLEncoder.encode(failMsg, "UTF-8");
		response.sendRedirect(loginPath+"?failMsg="+encodingParam );
//		- 아래는 security lib 사용이 불가능 하다...
//		request.setAttribute("failMsg", failMsg);
//		request.getRequestDispatcher(loginPath).forward(request, response);


	}
}