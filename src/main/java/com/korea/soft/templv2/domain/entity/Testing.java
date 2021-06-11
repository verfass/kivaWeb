package com.korea.soft.templv2.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name = "`TB_Testing`")
@ToString(exclude = "trainingMenu")
public class Testing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long TestingId;

    private int TestingType; // 1.문제 텍스트, 2.문제 이미지
    private String Title;
    private String QuestionText; // 2번 유형
    private String QuestionSound; // 2번 사운드
    private String QuestionImage1;
    private String QuestionImage2;
    private String QuestionImageSound1;
    private String QuestionImageSound2;
    private String AnswerTextAndImageUrl;
    private String ErrorTextAndImageUrl1;
    private String ErrorTextAndImageUrl2;
    private String ErrorTextAndImageUrl3;
    private int Sort;
    private int Point;




    @JsonBackReference
    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn(name = "MenuId")
    private TrainingMenu trainingMenu;


}

