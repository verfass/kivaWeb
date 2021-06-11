package com.korea.soft.templv2.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "`TB_LanguageMenu`")
@ToString(exclude = "category")
public class LanguageMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long MenuId;
    private Long ParentId;

    private String MenuName;
    private String FileUrl;
    private LocalDateTime ModifiedDate;
    private String ModifiedId;
    private String ModifiedIp;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CategoryId")
    private Category category;

//    @OneToMany(mappedBy = "board",fetch = FetchType.LAZY) // mappedBy 연관관계의 주인이 아니다 (난 FK가 아니에요) DB에 칼럼을 만들지 마세요
//    @JsonIgnoreProperties({"board"}) // Reply객체의 board는 json으로 파싱하지 않겠다는 설정 => 무한참조 방지 반드시 설정해야함( 대부분 OneToMany 해당
//    private List<BoardFile> boardFiles;

}