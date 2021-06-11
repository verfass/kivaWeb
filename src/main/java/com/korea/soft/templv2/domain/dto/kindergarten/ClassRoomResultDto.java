package com.korea.soft.templv2.domain.dto.kindergarten;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClassRoomResultDto {
    private Long ClassId;
    private String ClassName;
    private Integer Grade;
    private Long KindergartenId;
}