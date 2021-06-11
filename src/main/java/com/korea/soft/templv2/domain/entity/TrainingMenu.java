package com.korea.soft.templv2.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "`TB_TrainingMenu`")
@ToString(exclude = {"phonicses","trainingHists","testings"})
public class TrainingMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long MenuId;
    private Long ParentId;
    private String MenuName;
    private String VideoUrl;
    private LocalDateTime ModifiedDate;
    private String ModifiedId;
    private String ModifiedIp;

    @JsonManagedReference
    @OneToMany(mappedBy = "trainingMenu") // 기본 전략 Lazy
    @JsonIgnoreProperties({"trainingMenu"}) // 무한참조 방지 반드시 설정해야함
    private List<TrainingHist> trainingHists;

    @JsonManagedReference
    @OneToMany(mappedBy = "trainingMenu",cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    @JsonIgnoreProperties({"trainingMenu"}) // 무한참조 방지 반드시 설정해야함
    private List<Phonics> phonicses;

    @JsonManagedReference
    @OneToMany(mappedBy = "trainingMenu",cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    @JsonIgnoreProperties({"trainingMenu"}) // 무한참조 방지 반드시 설정해야함
    private List<DailyTalk> dailyTalks;

    @JsonManagedReference
    @OneToMany(mappedBy = "trainingMenu",cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    @JsonIgnoreProperties({"trainingMenu"}) // 무한참조 방지 반드시 설정해야함
    private List<Testing> testings;

}