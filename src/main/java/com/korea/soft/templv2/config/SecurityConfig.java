package com.korea.soft.templv2.config;
import com.korea.soft.templv2.config.auth.PrincipalDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RequiredArgsConstructor
@Configuration // 빈 등록 : 스프링 컨테이너에서 객체를 관리할 수 있게 하는 것
@EnableWebSecurity //스프링 시큐리티 필터에 등록하는 어노테이션
@EnableGlobalMethodSecurity(securedEnabled = true) // Controller에 @Secure어노테이션 활성화 : 권한별 접근을 설정할 수 있다.(나중에 검색 ㄱㄱ)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${custom.loginPath}")
    private String loginPath;


    private final PrincipalDetailService principalDetailService;
    private final LoginFailHandler loginFailHandler;
    private final LoginSuccessHandler loginSuccessHandler;

    // 1. Bean 어노테이션은 메서드에 붙여서 객체 생성시 사용
    @Bean
    public BCryptPasswordEncoder encodePWD() {
        return new BCryptPasswordEncoder();
    }

    // 시큐리티가 대신 로그인 해주는데 password를 가로채기를 하는데
    // 해당 password가 뭘로 해쉬가 되어 회원가입이 되었는지 알아야
    // 같은 해쉬로 암호화해서 DB에 있는 해쉬랑 비교할 수 있음.
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(principalDetailService).passwordEncoder(encodePWD());
    }


    @Bean // 회원 정보가 수정될때 세션의 값을 변환해주기위한 메서드를 Bean으로 등록해준다 (회원정보 수정에서 처리 하려고..)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // xss 공격 => lucy 필터 적용
        http.csrf().disable(); //csrf 토큰값 비교 비활성화 (테스트시 걸어두는게 좋음)
//        http.cors().disable();
        http.authorizeRequests()
                .antMatchers("/","/auth/**","/js/**","/css/**","/images/**","/form","/outer/**", "/usr/**", "/download/**")
                .permitAll()
//                .antMatchers("/user/**").authenticated() // 로그인 한사람만 (기본값이 로그인 한사람만이다..)
                .antMatchers("/manager/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')")
                .antMatchers("/language/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER') or hasRole('ROLE_TEACHER') or hasRole('ROLE_KINDERGARTEN')")
                .antMatchers("/study/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER') or hasRole('ROLE_TEACHER') or hasRole('ROLE_KINDERGARTEN')")
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .anyRequest()
                .authenticated()
            .and()
                .formLogin()
                .loginPage(loginPath)
                .failureHandler(loginFailHandler)
                .usernameParameter("userId")
                .loginProcessingUrl("/auth/login.do") // 1. 스프링 시큐리티가 해당 주소로 요청오는 로그인을 가로채서 대신 로그인 해준다.
                .successHandler(loginSuccessHandler);
//                .defaultSuccessUrl("/");
//        ${requestScope.loginFailMsg}
    }
}