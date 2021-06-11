package com.korea.soft.templv2.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.korea.soft.templv2.domain.entity.inherit.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "`TB_Board`")
@ToString( exclude = {"boardGroup", "boardFiles"})  /*나중에 따로 뽑을때 사용*/
public class Board extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long BoardId;
    private String BoardTitle;
    private String BoardContent;
    private Long ModSeq;


    @JsonBackReference// 참조가 되는 뒷부분을 의미하며, 직렬화를 수행하지 않는다.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GroupId")
    private BoardGroup boardGroup;


    @JsonBackReference// 참조가 되는 뒷부분을 의미하며, 직렬화를 수행하지 않는다.
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "UserSeq")
    private User user;

    @JsonManagedReference    // 2. Collection Type 에 적용된다.
    @OneToMany(mappedBy = "board",fetch = FetchType.LAZY) // mappedBy 연관관계의 주인이 아니다 (난 FK가 아니에요) DB에 칼럼을 만들지 마세요
    @JsonIgnoreProperties({"board"}) // Reply객체의 board는 json으로 파싱하지 않겠다는 설정 => 무한참조 방지 반드시 설정해야함( 대부분 OneToMany 해당
    private List<BoardFile> boardFiles;

}