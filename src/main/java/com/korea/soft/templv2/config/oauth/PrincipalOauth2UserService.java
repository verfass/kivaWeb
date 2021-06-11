package com.korea.soft.templv2.config.oauth;


import com.korea.soft.templv2.common.ClientIpResolver;
import com.korea.soft.templv2.config.auth.PrincipalDetails;
import com.korea.soft.templv2.config.oauth.provider.FacebookUserInfo;
import com.korea.soft.templv2.config.oauth.provider.GoogleUserInfo;
import com.korea.soft.templv2.config.oauth.provider.NaverUserInfo;
import com.korea.soft.templv2.config.oauth.provider.OAuth2UserInfo;
import com.korea.soft.templv2.domain.common.RoleType;
import com.korea.soft.templv2.domain.entity.User;
import com.korea.soft.templv2.repository.UserRepository;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
@Slf4j
@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClientIpResolver clientIpResolver;


    // 구글로 부터 받은 userRequest 데이터에 대한 후처리되는 함수
    // !! 중요 : 함수종료시 @ AuthenticationPrincipal 어노테이션이 만들어진다
//
//    @SneakyThrows
//    @Override
//    @Transactional
//    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
//
//
//        log.info("getClientRegistration ? : " + userRequest.getClientRegistration());
//
//        //회원가입 시키기
//        OAuth2User oauth2User = super.loadUser(userRequest); // 구글로부터 회원 프로필 받기
//        log.info("oauth2User ? : " + oauth2User.getAttributes());
//        OAuth2UserInfo oauth2UserInfo = null;
//        if(userRequest.getClientRegistration().getRegistrationId().equals("google")){
//            log.info("구글 로그인 요청");
//            oauth2UserInfo = new GoogleUserInfo(oauth2User.getAttributes());
//        } else if (userRequest.getClientRegistration().getRegistrationId().equals("facebook")){
//            log.info("페이스북 로그인 요청");
//            oauth2UserInfo = new FacebookUserInfo(oauth2User.getAttributes());
//        } else if (userRequest.getClientRegistration().getRegistrationId().equals("naver")){
//            log.info("네이버 로그인 요청");
//            oauth2UserInfo = new NaverUserInfo((Map) oauth2User.getAttributes().get("response"));
//        } else{
//            log.info("페이스북, 구글, 네이버 만 지원");
//        }
//
//        String provider = oauth2UserInfo.getProvider();
//        String providerId = oauth2UserInfo.getProviderId();
//        String username = provider + "_" + providerId;
//        String email = oauth2UserInfo.getEmail();
//        String password = bCryptPasswordEncoder.encode("(보안)랜덤패스워드");
//
//
//        User userEntity = userRepository.findByUsername(username).orElseGet(() -> {
//            return null;
//        });
//
//        if(userEntity == null){
//            userEntity = User.builder()
//                    .username(username)
//                    .password(password)
//                    .role(RoleType.USER)
//                    .email(email)
//                    .firstAccessIp(clientIpResolver.getUserIp())
//                    .build();
//            userRepository.save(userEntity); // 회원가입
//        } else {
//            userEntity.setLastAccessIp(clientIpResolver.getUserIp()); // 최종 접속 아이피로 업데이트
//        }
//
//        return new PrincipalDetails(userEntity,oauth2User.getAttributes()); // 시큐리티의 세션에 유저 정보가 저장되는 타이밍
//    }
}
