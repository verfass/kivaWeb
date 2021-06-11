package com.korea.soft.templv2.domain.dto.language;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LanguageMenuResultDto {
    private Long MenuId;
    private Long ParentId;
    private String MenuName;
    private String FileUrl;
    private String ModifiedId;
    private String ModifiedIp;
    private Long CategoryId;
}