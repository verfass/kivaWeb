package com.korea.soft.templv2.domain.dto.training;

import com.korea.soft.templv2.domain.entity.TrainingHist;
import com.korea.soft.templv2.domain.entity.TrainingMenu;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrainingHistResultDto {
//    private Long HistId;
//    private Long KivaPlayHistId;
//    private Long PhonicsHistId;
//    private Long DailyTalkHistId;
    private int ClickCount;
    private int KivaPlayCount;
    private int PhonicsCount;
    private int DailyTalkCount;
    private String KivaPlayUrl;
    private Long KivaPlayMenuId;
    private Long PhonicsMenuId;
    private Long DailyTalkMenuId;
    private Long MenuId;
    private String MenuName;
    private Long UserSeq;
    private Long PhonicsId;
    private Long DailyTalkId;
}