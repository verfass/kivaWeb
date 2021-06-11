package com.korea.soft.templv2.domain.dto.user;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserUpdateReqDto {
    @NotNull( message = "패스워드를 입력하지 않았습니다.")
    private String password;
    private String phone;
}
