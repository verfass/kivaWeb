package com.korea.soft.templv2.domain.dto.user;

import com.korea.soft.templv2.domain.common.RoleType;
import com.korea.soft.templv2.domain.common.ValidatationMessage;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

@Data
public class UserJoinReqDto {

    @Length(min = 3, max = 20, message = ValidatationMessage.USER_ID_CK)
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = ValidatationMessage.USER_ID_PATTERN_CK)
    private String UserId;

    @NotBlank(message = ValidatationMessage.PASSWORD_CK1)
    private String Password;

    @NotBlank(message = ValidatationMessage.PASSWORD_CK1)
    private String PasswordRe;

    @NotNull(message = ValidatationMessage.CLASS_ID_CK)
    private Long ClassId;

    @Length(min = 2, max = 8, message = ValidatationMessage.USER_NAME_CK)
    @Pattern(regexp = "^[가-힣]*$", message = ValidatationMessage.USER_NAME_PATTERN_CK)
    private String UserName;

    @Pattern(regexp = "^01(?:0|1|[6-9])(?:\\d{3}|\\d{4})\\d{4}$", message = ValidatationMessage.CELLPHONE_PATTERN_CK)
    private String CellPhone;

    @AssertTrue(message = "비밀번호가 일치하지 않습니다.")
    public boolean isValidPassword(){
        return Password.equals(PasswordRe);
    }

    @AssertTrue(message = "반을 선택해주세요.")
    public boolean isValidClassId(){
        return ClassId > 0L;
    }

}
