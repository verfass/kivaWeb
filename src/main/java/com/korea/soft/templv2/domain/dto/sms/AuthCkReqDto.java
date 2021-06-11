package com.korea.soft.templv2.domain.dto.sms;

import com.korea.soft.templv2.domain.common.ValidatationMessage;
import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
public class AuthCkReqDto {
    @NotBlank(message = ValidatationMessage.AUTHKEY_CK)
    private String AuthKey; // 인증 번호
}
