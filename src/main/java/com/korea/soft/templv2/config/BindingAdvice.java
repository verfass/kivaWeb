package com.korea.soft.templv2.config;

import com.korea.soft.templv2.domain.common.CommonDto;
import io.sentry.Sentry;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

//    - 용어정리
//    Aspect : 공통 기능
//    Advice : Aspect의 기능 자체
//    Aspect를 공통 기능이라고 크게 묶었으면 Advice는 그 안의 세부적인, 주요 기능이라고 생각하시면 됩니다.
//    Joinpoint : Advice를 적용해야 되는 부분(ex 필드, 메소드 - 스프링에서는 메소드만 해당)
//    Pointcut : Joinpoint의 부분으로 실제로 Advice가 적용된 부분
//    Weaving : Advice를 핵심 기능에 적용 하는 행위

// AOP는 메서드 전의 전처리 기능이다... 전체 전처리 기능이 아니다.. 전체 전처리는 Filter를 사용하면된다.
@Slf4j
@Component
@Aspect
public class BindingAdvice {

    // before와 after의 경우 ProceedingJoinPoint를 얻을수 없다, HttpServletRequest 사용하면 얻을수 있다.
    @Before("execution(* com.korea.soft.templv2.web..*Controller.*(..))")
    public Object testCheck() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        log.info("요청 주소       ========================> {}", request.getRequestURI());


        return "1";
    }

    //@Before
    //@After
    // @Arount : 함수 앞,뒤 모두 제어
    @Around("execution(* com.korea.soft.templv2.web..*Controller.*(..))") // Controller 안에 모든 인자값(파라미터값을 검사하겠다)
    public Object validCheck(ProceedingJoinPoint proceedingJoinPoint) throws Throwable { // 값을 체크하기위한 공통기능 만들기
        String type = proceedingJoinPoint.getSignature().getDeclaringTypeName();
        String method = proceedingJoinPoint.getSignature().getName();
        log.info("호출 컨트롤러 ========================> {}", type);
        log.info("호출 메서드명 ========================> {}", method);

        Object[] args = proceedingJoinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof BindingResult) {
                BindingResult bindingResult = (BindingResult) arg;

                if (bindingResult.hasErrors()) {
//                    Map<String, String> errorMap = new HashMap<>();
                    String errorMsg = "";

                    for (FieldError error : bindingResult.getFieldErrors()) {
//                        errorMap.put(error.getField(), error.getDefaultMessage());
                        errorMsg = error.getDefaultMessage();
                        log.warn(type + "." + method + "() => 필드:" + error.getField() + ", 메시지:" + error.getDefaultMessage());
                        Sentry.captureMessage(type + "." + method + "() => 필드:" + error.getField() + ", 메시지:" + error.getDefaultMessage());
                    }
                    return new CommonDto<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), errorMsg);
                }
            }
        }
        return proceedingJoinPoint.proceed(); // 함수의 스택을 실행해라
    }
}
