package com.korea.soft.templv2.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "`TB_TestingResult`")
@ToString(exclude = "user")
public class TestingResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long TestingResultId;

    private int ResultPoint;
    private Long MenuId;

    @JsonBackReference
    @ManyToOne( fetch = FetchType.LAZY ) // 기본 전략 Eager
    @JoinColumn(name = "UserSeq")
    private User user;

}

