package com.korea.soft.templv2.domain.common;

public class ValidatationMessage {
	
	// User 객체
	public static final String USER_ID_PATTERN_CK = "ID는 영문+숫자로 입력해주세요";
	public static final String USER_ID_CK = "ID를 3 ~ 20자리내로 입력해주세요";
	public static final String PASSWORD_CK1 = "비밀번호는 필수 입력 값입니다.";
	public static final String PASSWORD_CK2 = "비밀번호는 영문 대,소문자와 숫자, 특수기호가 적어도 1개 이상씩 포함된 8자 ~ 20자의 비밀번호여야 합니다.";
	public static final String CLASS_ID_CK = "반을 선택해 주세요";

	public static final String USER_NAME_CK = "유저이름은 2~8 글자 이내로 입력해주세요.";
	public static final String USER_NAME_PATTERN_CK = "이름은 한글로만 입력해주세요.";
	public static final String CELLPHONE_PATTERN_CK = "핸드폰 번호를 정확하게 입력해주세요";
    public static final String AUTHKEY_CK = "인증번호를 입력해주세요";
}