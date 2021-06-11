package com.korea.soft.templv2.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.korea.soft.templv2.domain.common.TrainingEnum;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name = "`TB_DailyTalk`")
@ToString(exclude = "trainingMenu")
public class DailyTalk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long DailyTalkId;

    // 1 [회화제목]
    private String DailyTalkImage1; // 회화제목 이미지1
    private String DailyTalkSound1; // 회화제목 사운드1

    // 2 [영상 1]
    //"Let‘s Sing!"
    private String SongUrl; // 회화송 url1

    // 3 [영상 2]
    // "Let‘s Chant!"
    private String ChantUrl; // 회화챈트 url2

    // 4 [영상 3]
    //Courses Book.    -----------소리 받아야됨
    //What's your name?
    private String EbookUrl; // EBook url3

    // 5 [회화단어 제시]
    private String CardImage1; // 단어카드 이미지1
    private String CardSound1; // 단어카드 사운드1
    private String CardText1;  // 단어카드 텍스트1
    private String CardImage2; // 단어카드 이미지2
    private String CardSound2; // 단어카드 사운드2
    private String CardText2;  // 단어카드 텍스트2
    private String CardImage3; // 단어카드 이미지3
    private String CardSound3; // 단어카드 사운드3
    private String CardText3;  // 단어카드 텍스트3
    private String CardImage4; // 단어카드 이미지4
    private String CardSound4; // 단어카드 사운드4
    private String CardText4;  // 단어카드 텍스트4

    // 6 [회화 장면 맞추기]
//    Listen n choos the correct picture -- 음성 받아서 덮어씌우기
    private String Type1QuestionText; // 타입 1번 - 문제텍스트
    private String Type1AnswerImage; //타입 1번 - 정답이미지
    private String Type1AnswerSound; //타입 1번 - 정답사운드
    private String Type1ErrorImage1; // 타입 1번 -오답 이미지1
    private String Type1ErrorSound1; // 타입 1번 -오답 사운드1
    private String Type1ErrorImage2; // 타입 1번 -오답 이미지2
    private String Type1ErrorSound2; // 타입 1번 -오답 사운드2

    private String Type2AnswerImage; // 타입 2번 - 정답 이미지
    private String Type2AnswerSound; // 타입 2번 - 정답 사운드
    private String Type2AnswerTextSplit1; // 타입 2번 - 정답 첫번째 단어
    private String Type2AnswerSoundSplit1; // 타입 2번 - 정답 첫번째 단어 사운드
    private String Type2AnswerTextSplit2; // 타입 2번 - 정답 두번째 단어
    private String Type2AnswerSoundSplit2; //타입 2번 - 정답 두번째 단어 사운드
    private String Type2AnswerTextSplit3; // 타입 2번 - 정답 세번째 단어
    private String Type2AnswerSoundSplit3;// 타입 2번 - 정답 세번째 단어 사운드
    private String Type2AnswerTextSplit4; // 타입 2번 - 정답 네번째 단어
    private String Type2AnswerSoundSplit4;// 타입 2번 - 정답 네번째 단어 사운드
    private int Type2QuestionNumber; // 문제 자리 번호
    private String Type2ErrorTextSplit1; // 타입 2번 - 오답 단어 1
    private String Type2ErrorSoundSplit1; // 타입 2번 - 오답 단어 사운드 1
    private String Type2ErrorTextSplit2; // 타입 2번 - 오답 단어 2
    private String Type2ErrorSoundSplit2; // 타입 2번 - 오답 단어 사운드 2

    private String GoodJobImage; // 굿잡 이미지
    private String GoodJobSound; // 굿잡 사운드
    
    // 31 - 2번째 텍스트 필요
    @JsonBackReference
    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn(name = "MenuId")
    private TrainingMenu trainingMenu;


}

