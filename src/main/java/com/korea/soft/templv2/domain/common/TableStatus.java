package com.korea.soft.templv2.domain.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TableStatus {
    N(0, false),
    Y(1, true);


    private final int intValue;
    private final boolean booleanValue;

}
