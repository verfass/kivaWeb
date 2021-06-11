package com.korea.soft.templv2.domain.dto.user;

import com.korea.soft.templv2.domain.common.ValidatationMessage;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;

@Data
public class UserFindPasswordDto {

    private String UserId;

    @Length(min = 2, max = 8, message = ValidatationMessage.USER_NAME_CK)
    @Pattern(regexp = "^[가-힣]*$", message = ValidatationMessage.USER_NAME_PATTERN_CK)
    private String UserName;

    @Pattern(regexp = "^01(?:0|1|[6-9])(?:\\d{3}|\\d{4})\\d{4}$", message = ValidatationMessage.CELLPHONE_PATTERN_CK)
    private String CellPhone;
}
