package com.korea.soft.templv2.domain.dto.training;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestingResultReqDto {
    private int ResultPoint;
    private Long MenuId;
}