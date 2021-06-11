package com.korea.soft.templv2.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name = "`TB_StudyRoom`")
@ToString(exclude = "studyMenu")
public class StudyRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long StudyRoomId;

    private int Week; // 1~4 ====> (1주차~4주차 )
    private String StudyType; // 1:Story, 2:Bubble Talk, 3:단어 스피킹, 4: Phonics Weekly, 5: Phonics Speaking////////////[6: 디지털 교재],[7:Youtube]  //////// 8: Kiva Song, 9: Singing Room, 10: Conversation, 11:동시통역(한->영), 12:동시통역(영->한), 13:Phonics, 14:스피드 스피킹, 15:파닉스 누적읽기
    private String LinkAndFileUrl;
    private String LinkAndFileText;

    @JsonBackReference
    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "MenuId" )
    private StudyMenu studyMenu;

}

