package com.korea.soft.templv2.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "`TB_TrainingHist`")
@ToString(exclude = {"user","trainingMenu"})
public class TrainingHist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long HistId;

    @Column(nullable=false, columnDefinition = "integer default 0")
    private int ClickCount;

    @JsonBackReference
    @ManyToOne // 기본 전략 Eager
    @JoinColumn(name = "UserSeq")
    private User user;

    @JsonBackReference
    @ManyToOne // 기본 전략 Eager
    @JoinColumn(name = "MenuId")
    private TrainingMenu trainingMenu;


}