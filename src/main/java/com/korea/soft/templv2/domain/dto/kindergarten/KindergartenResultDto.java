package com.korea.soft.templv2.domain.dto.kindergarten;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KindergartenResultDto {
    private Long KindergartenId;
    private String Address1;
    private String Address2;
    private String KindergartenName;
    private String TelePhone;
    private String ZipCode;
    private Long ManagerId;

}