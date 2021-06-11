package com.korea.soft.templv2.domain.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public enum CategoryType {
    MENU(1, "메뉴"),
    BOARD(2, "게시판");

    private final int typeInt;
    private final String typeString;
    
}
