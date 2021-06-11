package com.korea.soft.templv2.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "`TB_StudyMenu`")
@ToString(exclude = {"studyRooms"})
public class StudyMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long MenuId;
    private Long ParentId;
    private String MenuName;
    private LocalDateTime ModifiedDate;
    private String ModifiedId;
    private String ModifiedIp;

    @JsonManagedReference
    @OneToMany(mappedBy = "studyMenu") // 기본 전략 Lazy
    @JsonIgnoreProperties({"studyMenu"}) // 무한참조 방지 반드시 설정해야함
    private List<StudyRoom> studyRooms;

}