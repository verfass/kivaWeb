package com.korea.soft.templv2.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.korea.soft.templv2.domain.common.TableStatus;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "`TB_BoardGroup`")
@ToString( exclude = "boards")  /*나중에 따로 뽑을때 사용*/
public class BoardGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private int GroupId;
    private String GroupName;
    private int Sort;
    private TableStatus UseYn;
    private String Roles;

    @OneToMany(mappedBy = "boardGroup",fetch = FetchType.LAZY) // mappedBy 연관관계의 주인이 아니다 (난 FK가 아니에요) DB에 칼럼을 만들지 마세요
    @JsonIgnoreProperties({"boardGroup"}) // Reply객체의 board는 json으로 파싱하지 않겠다는 설정 => 무한참조 방지 반드시 설정해야함( 대부분 OneToMany 해당
    @OrderBy("BoardId desc")
    private List<Board> boards;


}