package com.korea.soft.templv2.common;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Component
public class HttpRequestService {
    public ResponseEntity<String> callBack(String url, Map<String, String> bodyData){
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        RestTemplate rt = new RestTemplate();
        
        // 1) 헤더정보 생성
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/json;charset=utf-8");

        // 2) body 정보 생성
        MultiValueMap<String, Pageable> params = new LinkedMultiValueMap<>();
//        params.add("grant_type", pageable);


        // 3) 헤더, 바디 정보 하나의 오브젝트에 담기
        HttpEntity<MultiValueMap<String, String>> commonRequest = new HttpEntity<>(null, headers);

        // 4) Http 요청하기 - Post방식으로 - 그리고 response 변수로 응답 받음.
        ResponseEntity<String> response = rt.exchange(
                url,
                HttpMethod.GET,
                commonRequest,
                String.class
        );

        return response;

    }

//    @GetMapping("/auth/kakao/callback")
//    public String kakaoCallback(String code) {
//        // POST방식으로 KEY = VALUE 방식으로 데이터 요청(카카오쪽으로)
//        // - 요청하는 방식 3가지
//        // 1. Retrofit2
//        // 2. OkHttp
//        // 3. RestTemplate
//        RestTemplate rt = new RestTemplate();
//
//        // 1) 헤더정보 생성
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
//
//        // 2) body 정보 생성
//        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
//        params.add("grant_type", "authorization_code");
//        params.add("client_id", "ea19b90e1568b2d72f36c1ce4d1cd964");
//        params.add("redirect_uri", "http://localhost:8085/auth/kakao/callback");
//        params.add("code", code);
//
//        // 3) 헤더, 바디 정보 하나의 오브젝트에 담기
//        HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = new HttpEntity<>(params, headers);
//
//        // 4) Http 요청하기 - Post방식으로 - 그리고 response 변수로 응답 받음.
//        ResponseEntity<String> response = rt.exchange(
//                "https://kauth.kakao.com/oauth/token",
//                HttpMethod.POST,
//                kakaoTokenRequest,
//                String.class
//        );
//        // 5) reponse 데이터 파싱하여 accessToken 가져오기 - Gson, JsonSimple, ObjectMapper
//        ObjectMapper objectMapper = new ObjectMapper();
//        OauthToken oauthToken = null;
//        try {
//            oauthToken = objectMapper.readValue(response.getBody(), OauthToken.class);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        logger.info("oauth 토큰 데이터 : "+oauthToken.getAccess_token());
//
//        // 2. 유저 프로필 정보 가져오기
//        RestTemplate rt2 = new RestTemplate();
//        // 1) 헤더정보 생성
//        HttpHeaders headers2 = new HttpHeaders();
//        headers2.add("Authorization", "Bearer "+oauthToken.getAccess_token());
//        headers2.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
//
//        // 2) 헤더, 바디 정보 하나의 오브젝트에 담기
//        HttpEntity<MultiValueMap<String, String>> kakaoProfileRequest = new HttpEntity<>(headers2);
//
//        // 4) Http 요청하기 - Post방식으로 - 그리고 response 변수로 응답 받음.
//        ResponseEntity<String> response2 = rt2.exchange(
//                "https://kapi.kakao.com/v2/user/me",
//                HttpMethod.POST,
//                kakaoProfileRequest,
//                String.class
//        );
//        ObjectMapper objectMapper2 = new ObjectMapper();
//        KakaProfile kakaProfile = null;
//        try {
//            kakaProfile = objectMapper2.readValue(response2.getBody(), KakaProfile.class);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//
//        //  3. User 오브젝트: username, password, email를 우리 데이터 베이스에 넣는 과정
//
//        logger.info("우리서버 유저네임:"+kakaProfile.getKakao_account().getEmail()+"_"+kakaProfile.getId());
//        logger.info("우리서버 email : "+kakaProfile.getKakao_account().getEmail());
//        logger.info("우리서버 패스워드 : "+koreaSoftKey);
//
//        User kakaoUser = User.builder()
//                .username(kakaProfile.getKakao_account().getEmail()+"_"+kakaProfile.getId())
//                .password(koreaSoftKey)
//                .email(kakaProfile.getKakao_account().getEmail())
//                .oauth("kakao")
//                .build();
//
//        // 가입자 혹은 비가입자 체크해서 insert
//        User orginUser = userService.회원찾기(kakaoUser.getUsername());
//        if(orginUser == null){
//            logger.info("기존회원이 아닙니다.");
//            userService.회원가입(kakaoUser);
//        }
//
//        // 자동 로그인 처리
//        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(kakaoUser.getUsername(), koreaSoftKey));
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//
//
//        return "redirect:/";
//    }


}
