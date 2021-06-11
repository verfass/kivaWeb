package com.korea.soft.templv2.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReplyReqDto {

    private String userId;
    private Long boardId;
    private String content;
}
