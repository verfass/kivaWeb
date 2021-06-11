package com.korea.soft.templv2.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardSaveReqDTO {
    private Long id;
    private String content;
    private Integer count;
    private LocalDateTime createDate;
    private String title;
    private String userId;
    private LocalDateTime moddate, regdate;

}
