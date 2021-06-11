package com.korea.soft.templv2.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.korea.soft.templv2.domain.common.TrainingEnum;
import com.korea.soft.templv2.domain.entity.Category;
import com.korea.soft.templv2.domain.entity.TrainingMenu;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name = "`TB_Phonics`")
@ToString(exclude = "trainingMenu")
public class Phonics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PhonicsId;

    // 공통
    private TrainingEnum AnswerCode; // 정답 알파뱃 코드
//        AnswerCode.getUpper();       // 정답 대문자
//        AnswerCode.getUpperSound();  // 정답 대문자 사운드
//        AnswerCode.getLower();       // 정답 소문자
//        AnswerCode.getLowerSound();  // 정답 소문자 사운드

    private TrainingEnum ErrorCode1; // 오답1 대/소문자 알파뱃 코드
//        ErrorCode1.getUpper();       // 에러1 대문자
//        ErrorCode1.getUpperSound();  // 에러1 대문자 사운드
//        ErrorCode1.getLower();       // 에러1 소문자
//        ErrorCode1.getLowerSound();  // 에러1 소문자 사운드

    private TrainingEnum ErrorCode2; // 오답2 대/소문자 알파뱃 코드
//        ErrorCode2.getUpper();       // 에러2 대문자
//        ErrorCode2.getUpperSound();  // 에러2 대문자 사운드
//        ErrorCode2.getLower();       // 에러2 소문자
//        ErrorCode2.getLowerSound();  // 에러2 소문자 사운드

    private TrainingEnum ErrorCode3; // 오답3 대/소문자 알파뱃 코드
//        ErrorCode3.getUpper();       // 에러3 대문자
//        ErrorCode3.getUpperSound();  // 에러3 대문자 사운드
//        ErrorCode3.getLower();       // 에러3 소문자
//        ErrorCode3.getLowerSound();  // 에러3 소문자 사운드

    // 1 [인트로]
    private String IntroImage; // 첫인트로 대/소문자 이미지 (트레이닝 대소문자 이미지) //todo 공통
    private String IntroSound; // 첫인트로 대/소문자 사운드 (트레이닝 대소문자 사운드) //todo 공통

    // 2 [대문자 소개]
    private String UpperStrokeGif; // 대문자 획수 gif
    private String UpperStrokeSlowSound; // 대문자 획수 느린 사운드 (원,투,쓰리,포)  //todo 공통
    private String UpperStrokeNormalSound; // 대문자 획수 보통 사운드 (원,투,쓰리,포)  //todo 공통

    // 3 [소문자 소개]
    private String LowerStrokeGif; // 소문자 획수 gif
    private String LowerStrokeSlowSound; // 소문자 획수 느린 사운드 (원,투,쓰리,포) //todo 공통
    private String LowerStrokeNormalSound; // 소문자 획수 보통 사운드 (원,투,쓰리,포) //todo 공통

    //region [4,5]=대문자 / [6,7]=소문자 획수 - 이미지/사운드

    // 4
    private String UpperStrokeSlowGif;  // 대문자 획수 느리게 gif
//    UpperStrokeSlowSound; // 기존 사운드 사용 =========================================> UpperStrokeSlowSound [등록된거사용]

    // 5
    private String UpperStrokeNormalGif; // 대문자 획수 보통 gif
//    UpperStrokeNormalSound;// 기존 사운드 사용 =========================================> UpperStrokeNormalSound

    // 6
    private String LowerStrokeSlowGif;  // 소문자 획수 느리게 gif
//    LowerStrokeSlowSound; // 기존 사운드 사용 =========================================> LowerStrokeSlowSound [등록된거사용]

    // 7
    private String LowerStrokeNormalGif;  // 소문자 획수 보통 gif
//    LowerStrokeNormalSound; // 기존 사운드 사용 =========================================> LowerStrokeSlowSound [등록된거사용]

    //endregion

    // 8 ~ 13  [악어 : 대문자 3번 => 소문자 3번]
    private String UpperQuestionSound; // 대문자 문제기출용 사운드 //todo 공통
    private String UpperQuestionPng;   // 대문자 투명이미지        //todo 공통
    private String UpperSuccessPng;    // 대문자 투명이미지 정답용 //todo 공통

    private String LowerQuestionSound; // 소문자 문제기출용 사운드 //todo 공통
    private String LowerQuestionPng;   // 소문자 투명이미지 //todo 공통
    private String LowerSuccessPng;    // 소문자 투명이미지 정답용   //todo 공통


    // 14 [인트로 재탕]
//    IntroImage; // 첫인트로 대/소문자 이미지 (트레이닝 대소문자 이미지)  =========================================>  기존 이미지
//    IntroSound; // 첫인트로 대/소문자 사운드 (트레이닝 대소문자 사운드)  =========================================>  기존 사운드

    // 15  [사과 - 정답 대/소문자:3/3, 오답: 대/소문자 ]
    private String UpperLowerQuestionSound; // 대/소문자 문제기출용 사운드
//    private String UpperQuestionPng; // 대문자 투명이미지
//    private String UpperSuccessPng;  // 대문자 정답용 투명이미지
//    private String LowerQuestionPng; // 소문자 투명이미지
//    private String LowerSuccessPng; // 소문자 정답용 투명이미지

//        AnswerCode.getUpper();       // 정답 대문자 -------- 2개
//        AnswerCode.getUpperSound();  // 정답 대문자 사운드 -------- 2개
//        AnswerCode.getLower();       // 정답 소문자 -------- 2개
//        AnswerCode.getLowerSound();  // 정답 소문자 사운드 -------- 2개
//        ErrorCode1.getUpper();       // 에러1 대문자
//        ErrorCode1.getLower();       // 에러1 소문자
//        ErrorCode2.getUpper();       // 에러2 대문자
//        ErrorCode2.getLower();       // 에러2 소문자


    // 16 ~ 18 [악어:  정답 대문자 <= 소문자]
    private String UpperEqualsLowerQuestionSound; // 대문자에 맞는 소문자찾는 문제기출용 사운드
//    UpperQuestionPng; // 대문자 정답용 투명이미지 필요
//    UpperSuccessPng;  // 대문자 정답용 투명이미지

//    ---------------  에러 소문자 5개 필요
//        ErrorCode1.getLower();       // 에러1 소문자
//        ErrorCode1.getLowerSound();  // 에러1 소문자 사운드
//        ErrorCode2.getLower();       // 에러2 소문자
//        ErrorCode2.getLowerSound();  // 에러2 소문자 사운드
//        ErrorCode3.getLower();       // 에러3 소문자
//        ErrorCode3.getLowerSound();  // 에러3 소문자 사운드

    // 19 ~ 21 [악어:  정답 소문자 <= 대문자]
    private String LowerEqualsUpperQuestionSound; // 소문자에 맞는 대문자찾는 문제기출용 사운드
//    LowerQuestionPng; // 소문자 투명이미지
//    LowerSuccessPng; // 소문자 투명이미지 정답용

//    ---------------  에러 대문자 5개 필요
//        ErrorCode1.getUpper();       // 에러1 대문자
//        ErrorCode1.getUpperSound();  // 에러1 대문자 사운드
//        ErrorCode2.getUpper();       // 에러2 대문자
//        ErrorCode2.getUpperSound();  // 에러2 대문자 사운드
//        ErrorCode3.getUpper();       // 에러3 대문자
//        ErrorCode3.getUpperSound();  // 에러3 대문자 사운드

    // 22 ~ 25 [날아다니는 풍선/ 상자풍선]
    private String FindAlphabetQuestionSound1; // 날아다니는 풍선 정답 알파벳 찾기 문제기출용 사운드
    private String FindAlphabetQuestionSound2; // 상자 풍선 정답 알파벳 찾기 문제기출용 사운드
//        AnswerCode.getUpper();       // 정답 대문자 -------- 2개
//        AnswerCode.getUpperSound();  // 정답 대문자 사운드 -------- 2개
//        AnswerCode.getLower();       // 정답 소문자 -------- 2개
//        AnswerCode.getLowerSound();  // 정답 소문자 사운드 -------- 2개
//    ---------------  에러 대/소문자 9개 필요
//        ErrorCode1.getUpper();       // 에러1 대문자
//        ErrorCode2.getUpper();       // 에러2 대문자
//        ErrorCode3.getUpper();       // 에러3 대문자
    private String WordAnswerImage1; // 단어 정답 이미지1
    private String WordAnswerSound1; // 단어 정답 사운드1
    private String WordAnswerAfterText1; // [정답제외] 단어 텍스트1
    private String WordAnswerImage2; // 단어 정답 이미지2
    private String WordAnswerSound2; // 단어 정답 사운드2
    private String WordAnswerAfterText2; // [정답제외] 단어 텍스트2
    private String WordAnswerImage3; // 단어 정답 이미지3
    private String WordAnswerSound3; // 단어 정답 사운드3
    private String WordAnswerAfterText3; // [정답제외] 단어 텍스트3
    private String WordAnswerImage4; // 단어 정답 이미지4
    private String WordAnswerSound4; // 단어 정답 사운드4
    private String WordAnswerAfterText4; // [정답제외] 단어 텍스트4

    // 26 ~ 29 [상자 풍선, 사탕, ]
//        AnswerCode.getUpper();       // 정답 대문자 -------- 2개
//        AnswerCode.getUpperSound();  // 정답 대문자 사운드 -------- 2개
//        AnswerCode.getLower();       // 정답 소문자 -------- 2개
//        AnswerCode.getLowerSound();  // 정답 소문자 사운드 -------- 2개
//        ErrorCode1.getUpper();       // 에러1 대문자
//        ErrorCode1.getLower();       // 에러1 소문자
//        ErrorCode2.getUpper();       // 에러2 대문자
//        ErrorCode2.getLower();       // 에러2 소문자
//    WordAnswerImage1; // 단어 정답 이미지1
//    WordAnswerSound1; // 단어 정답 사운드1
//    WordAnswerAfterText1; // [정답제외] 단어 텍스트1
//    WordAnswerImage2; // 단어 정답 이미지2
//    WordAnswerSound2; // 단어 정답 사운드2
//    WordAnswerAfterText2; // [정답제외] 단어 텍스트2
//    WordAnswerImage3; // 단어 정답 이미지3
//    WordAnswerSound3; // 단어 정답 사운드3
//    WordAnswerAfterText3; // [정답제외] 단어 텍스트3
//    WordAnswerImage4; // 단어 정답 이미지4
//    WordAnswerSound4; // 단어 정답 사운드4
//    WordAnswerAfterText4; // [정답제외] 단어 텍스트4

    // 30 [문장 소개]
    private String SentenceAnswerText;  // 문장 전체 정답 텍스트
    private String SentenceAnswerImage; // 문장 전체 정답 이미지
    private String SentenceAnswerSound; // 문장 전체 정답 사운드

    // 31~33 [문장 3지선다형 선택 문제 (3부분으로 나눔)]
    private String SentenceAnswerSplit1;      // 문장의 첫번째 문단 정답 텍스트
    private String SentenceQuestionImage1;    // 문장의 첫번째 문단 문제 이미지
    private String SentenceAnswerSplitSoundEn1; // 문장의 첫번째 문단 정답 사운드 (영어)
    private String SentenceAnswerSplitSoundKr1; // 문장의 첫번째 문단 정답 사운드 (한국어)

    private String SentenceAnswerSplit2;      // 문장의 두번째 문단 정답 텍스트
    private String SentenceQuestionImage2;    // 문장의 두번째 문단 문제 이미지
    private String SentenceAnswerSplitSoundEn2; // 문장의 두번째 문단 정답 사운드 (영어)
    private String SentenceAnswerSplitSoundKr2; // 문장의 두번째 문단 정답 사운드 (한국어)

    private String SentenceAnswerSplit3;      // 문장의 세번째 문단 정답 텍스트
    private String SentenceQuestionImage3;    // 문장의 세번째 문단 문제 이미지
    private String SentenceAnswerSplitSoundEn3; // 문장의 세번째 문단 정답 사운드 (영어)
    private String SentenceAnswerSplitSoundKr3; // 문장의 세번째 문단 정답 사운드 (한국어)

    
    // 31 - 2번째 텍스트 필요
    @JsonBackReference
    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn(name = "MenuId")
    private TrainingMenu trainingMenu;


}

