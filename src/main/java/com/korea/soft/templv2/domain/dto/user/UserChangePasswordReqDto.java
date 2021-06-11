package com.korea.soft.templv2.domain.dto.user;

import com.korea.soft.templv2.domain.common.ValidatationMessage;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class UserChangePasswordReqDto {
    @NotBlank(message = ValidatationMessage.PASSWORD_CK1)
    private String Password;

    @Length(min = 8, max = 20, message = "비밀번호는 8이상 입력해주세요")
    @NotBlank(message = ValidatationMessage.PASSWORD_CK1)
    private String ChangePassword;

    @Length(min = 8, max = 20, message = "비밀번호는 8이상 입력해주세요")
    @NotBlank(message = ValidatationMessage.PASSWORD_CK1)
    private String ChangePasswordRe;

    @AssertTrue(message = "비밀번호가 일치하지 않습니다.")
    public boolean isValidPassword(){
        return ChangePassword.equals(ChangePasswordRe);
    }


}
