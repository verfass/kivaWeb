package com.korea.soft.templv2.tempTest;

import com.korea.soft.templv2.domain.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UnitTest {

//
//
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//
//    @Test
//    public void 테스트(){
//        String password = bCryptPasswordEncoder.encode("1234");
//        System.out.println(password);
//        boolean isPasswordOk = bCryptPasswordEncoder.matches("1234","$2a$11$eXWVgLbAQdVMBeerViWGW.vDRaNbcRLm44j4ZWaPXi4VTsjo5GxTe");
//        System.out.println(isPasswordOk);
//        boolean isPasswordOk2 = bCryptPasswordEncoder.matches("1234","$2a$10$yCOM0Ib5kmKPnXyixx/NqOUYzT1SodUgAx8NZMelPayOJrxLC0ogG");
//        boolean isPasswordOk3 = bCryptPasswordEncoder.matches("1234","$2a$10$Hafh9GKBdLgwsKi9P9.hhe8U3dMSN6VjnWuKmYJhBg.gyIva6ZfWu");
//        System.out.println(isPasswordOk2);
//    }
//
//
//    @Test
//    public void 테스트2(){
//        String userId = "test";
//        String director = "director";
//        String addr1 = "addr1";
//
//
//        System.out.println("유저객체");




//        Instructor instructor =  Instructor.builder()
//                .UserId("test")
//                .Address1("하하")
//                .Address2("후후")
//                .Password("11")
//                .Role(RoleType.USER)
//                .UseYn(TableStatus.Y)
//                .CellPhone("01022222222")
//                .build();
//
//    }
}