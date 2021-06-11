package com.korea.soft.templv2.domain.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoleType {
    ADMIN(1, "관리자"),
    MANAGER(2, "지사"),
    TEACHER(3, "강사"),
    KINDERGARTEN(4, "기관"),
    KID(5, "원아");

    private int roleInt;
    private String viewName;
}
