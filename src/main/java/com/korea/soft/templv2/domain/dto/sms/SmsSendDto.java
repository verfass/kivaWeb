package com.korea.soft.templv2.domain.dto.sms;

import com.korea.soft.templv2.domain.common.ValidatationMessage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SmsSendDto {

    @Pattern(regexp = "^01(?:0|1|[6-9])(?:\\d{3}|\\d{4})\\d{4}$", message = ValidatationMessage.CELLPHONE_PATTERN_CK)
    private String CellPhone;

    private String ResultCode;
    private String Msg; // 메세지 내용
}
