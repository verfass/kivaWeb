package com.korea.soft.templv2.common;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map;

public class AligoSMS {
    // 문자전송 고정값 세팅
    final String user_id = "soda2779"; // SMS 아이디
    final String key = "luu91b1r6wtlwglmkdf722u51t2n3vl2"; //인증키
    final String testmode_yn = "N";  // Y 인경우 실제문자 전송X , 자동취소(환불) 처리
    final String title = "[메타에듀]";  // 타이틀
    final String sender = "1577-3047";  // 발신번호

    final String encodingType = "utf-8";
    final String boundary = "____boundary____";
    final String sms_url = "https://apis.aligo.in/send/"; // 전송요청 URL



    public String send(Map<String, String> sms) {
        String rs = "";
        try {

            String image = "";
            sms.put("user_id", user_id);
            sms.put("key", key);
            sms.put("testmode_yn", testmode_yn);
            sms.put("title", title); //  LMS, MMS 제목 (미입력시 본문중 44Byte 또는 엔터 구분자 첫라인)
            sms.put("sender", sender); // 발신번호
            /******************** 전송정보 ********************/

            MultipartEntityBuilder builder = MultipartEntityBuilder.create();

            builder.setBoundary(boundary);
            builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
            builder.setCharset(Charset.forName(encodingType));

            for (Iterator<String> i = sms.keySet().iterator(); i.hasNext(); ) {
                String key = i.next();
                builder.addTextBody(key, sms.get(key)
                        , ContentType.create("Multipart/related", encodingType));
            }

            File imageFile = new File(image);
            if (image != null && image.length() > 0 && imageFile.exists()) {
                builder.addPart("image",
                        new FileBody(imageFile, ContentType.create("application/octet-stream"),
                                URLEncoder.encode(imageFile.getName(), encodingType)));
            }

            HttpEntity entity = builder.build();

            HttpClient client = HttpClients.createDefault();
            HttpPost post = new HttpPost(sms_url);
            post.setEntity(entity);

            HttpResponse res = client.execute(post);

            if (res != null) {
                BufferedReader in = new BufferedReader(new InputStreamReader(res.getEntity().getContent(), encodingType));
                String buffer = null;
                while ((buffer = in.readLine()) != null) {
                    rs += buffer;
                }
                in.close();
            }

        } catch (Exception e) {
            rs = e.getMessage();
        }
        return rs;

    }

}
