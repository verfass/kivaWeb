package com.korea.soft.templv2.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "`TB_Manager`")
@ToString( exclude = {"kindergartens","users"})  /*나중에 따로 뽑을때 사용*/
public class Manager implements Serializable {

    private static final long serialVersionUID = 1803811433310742691L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long ManagerId;
    private String ManagerName;
    private String RegionName;
    private String ZipCode;
    private String Address1;
    private String Address2;
    private String TelePhone;

    // 1. 참조가 되는 앞부분을 의미하며, 정상적으로 직렬화를 수행한다.
    @JsonManagedReference    // 2. Collection Type 에 적용된다.
    @OneToMany(mappedBy = "manager",fetch = FetchType.LAZY, cascade = CascadeType.REMOVE) // mappedBy 연관관계의 주인이 아니다 (난 FK가 아니에요) DB에 칼럼을 만들지 마세요
    @JsonIgnoreProperties({"manager"}) // Reply객체의 board는 json으로 파싱하지 않겠다는 설정 => 무한참조 방지 반드시 설정해야함( 대부분 OneToMany 해당
    @OrderBy("KindergartenId desc")
    private List<Kindergarten> kindergartens;

    // 1. 참조가 되는 앞부분을 의미하며, 정상적으로 직렬화를 수행한다.
    @JsonManagedReference    // 2. Collection Type 에 적용된다.
    @OneToMany(mappedBy = "manager",fetch = FetchType.LAZY, cascade = CascadeType.REMOVE) // mappedBy 연관관계의 주인이 아니다 (난 FK가 아니에요) DB에 칼럼을 만들지 마세요
    @JsonIgnoreProperties({"manager"}) // Reply객체의 board는 json으로 파싱하지 않겠다는 설정 => 무한참조 방지 반드시 설정해야함( 대부분 OneToMany 해당
    @OrderBy("UserId desc")
    private List<User> users;


}