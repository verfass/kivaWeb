package com.korea.soft.templv2.domain.dto.user;

import com.korea.soft.templv2.domain.common.ValidatationMessage;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;

@Data
public class FindByIdReqDto {

    @Length(min = 3, max = 20, message = ValidatationMessage.USER_ID_CK)
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = ValidatationMessage.USER_ID_PATTERN_CK)
    private String UserId;

}
