package com.korea.soft.templv2.service;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.korea.soft.templv2.common.AligoSMS;
import com.korea.soft.templv2.domain.dto.sms.AuthCkReqDto;
import com.korea.soft.templv2.domain.dto.sms.SmsSendDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@RequiredArgsConstructor
@Service
public class SmsService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Value("${koreaSoft.key}")
    private String authSuccessKey;

    /**
     * 6자리 인증키 생성, int 반환
     * @return
     */
    private int 인증번호생성() {
        return ThreadLocalRandom.current().nextInt(100000, 1000000);
    }

    @Transactional
    public void 인증번호요청(SmsSendDto smsSendDto, HttpServletResponse response) {
        Map<String, String> smsInfo = new HashMap<>();
        String receiver = smsSendDto.getCellPhone();

        int authKey = 인증번호생성();
        log.info("인증번호 확인 ==================> {}", authKey);
        String sendText = "[메타에듀]\n인증번호 ["+authKey+"]를 입력해주세요";

        smsInfo.put("msg", sendText); // 메세지 내용
        smsInfo.put("receiver", receiver); // 수신번호
//        smsInfo.put("destination", "01111111111|담당자,01111111112|홍길동"); // 수신인 %고객명% 치환

        //   api 호출
        String resultMsg = "";
        try {
            AligoSMS sms = new AligoSMS();
            resultMsg = sms.send(smsInfo);
            Gson gson = new Gson();
            Map<String, Object> resultJson = gson.fromJson(resultMsg,
                    new TypeToken<Map<String, Object>>(){}.getType());

            if(! resultJson.get("result_code").equals("1")) {
                throw new IllegalArgumentException("메세지 발송에 실패하였습니다. 번호를 다시 확인해주세요");
            }
        } catch (Exception e){
            throw new IllegalArgumentException("메세지 발송에 실패하였습니다. 번호를 다시 확인해주세요");
        }

        String encryptAuthKey = bCryptPasswordEncoder.encode(String.valueOf(authKey));
        Cookie cookie = new Cookie("encryptAuthKey", encryptAuthKey );
        cookie.setPath("/");
        cookie.setMaxAge(120); // 단위는 (초)임으로 120초로 유효시간을 설정해 준다.
        response.addCookie(cookie);
        smsSendDto.setMsg(resultMsg);
    }

    @Transactional
    public void 인증번호확인(AuthCkReqDto authCkReqDto, HttpServletRequest request, HttpServletResponse response) {
        Cookie encryptAuthKeyCookie = WebUtils.getCookie(request, "encryptAuthKey");
        if(encryptAuthKeyCookie != null){
            String encryptAuthKey = encryptAuthKeyCookie.getValue();
            boolean isMached = bCryptPasswordEncoder.matches(authCkReqDto.getAuthKey(),encryptAuthKey);

            log.info("암호화된 인증키 값은 ? ==============================> {}", encryptAuthKey);
            log.info("인증키가 맞는가 ? =======================> {}", isMached);

            if (isMached){
                // 2. 인증성공시 서버 비밀번호로 authSuccess 키를 발급해준다.
                String encryptAuthSuccessKey =  bCryptPasswordEncoder.encode(authSuccessKey);
                Cookie cookie = new Cookie("encryptAuthSuccessKey", encryptAuthSuccessKey);
                cookie.setPath("/");
                cookie.setMaxAge(60*5); // 인증 확인시간은 10분의 유효시간을 설정해 준다.
                response.addCookie(cookie);
            } else {
                throw new IllegalArgumentException("인증번호가 일치하지 않습니다.");
            }
        }
    }
    @Transactional
    public void 인증여부확인(HttpServletRequest request, HttpServletResponse response) {
        boolean isMached = false;
        Cookie encryptauthSuccessKeyCookie = WebUtils.getCookie(request, "encryptAuthSuccessKey");
        if(encryptauthSuccessKeyCookie != null){
            String encryptAuthSuccessKey = encryptauthSuccessKeyCookie.getValue();
            isMached = bCryptPasswordEncoder.matches(authSuccessKey, encryptAuthSuccessKey);

            if (isMached) { // 인증성공시 쿠키를 꼭 초기화 해주어야한다.
                encryptauthSuccessKeyCookie.setPath("/");
                encryptauthSuccessKeyCookie.setMaxAge(0);
                response.addCookie(encryptauthSuccessKeyCookie);
            } else{
                throw new IllegalArgumentException("전화번호를 인증 해주세요.");
            }
        } else { // 쿠키값이 없으면 그냥 실패
            throw new IllegalArgumentException("전화번호를 인증 해주세요.");
        }
    }
    @Transactional
    public void 문자전송(SmsSendDto smsSendDto) {
        Map<String, String> smsInfo = new HashMap<>();

        smsInfo.put("msg", "[메타에듀]\n"+smsSendDto.getMsg()); // 메세지 내용
        smsInfo.put("receiver", smsSendDto.getCellPhone()); // 수신번호

        //   api 호출
        String resultMsg = "";
        try {
            AligoSMS sms = new AligoSMS();
            resultMsg = sms.send(smsInfo);
            Gson gson = new Gson();
            Map<String, Object> resultJson = gson.fromJson(resultMsg, new TypeToken<Map<String, Object>>(){}.getType());

            if(! resultJson.get("result_code").equals("1")) {
                throw new IllegalArgumentException("메세지 발송에 실패하였습니다. 번호를 다시 확인해주세요");
            }
        } catch (Exception e){
            throw new IllegalArgumentException("메세지 발송에 실패하였습니다. 번호를 다시 확인해주세요");
        }
    }


}