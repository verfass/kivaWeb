package com.korea.soft.templv2.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.korea.soft.templv2.domain.common.TableStatus;
import com.korea.soft.templv2.domain.entity.inherit.BaseEntity;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity // User 클래스가 Mssql에 테이블로 생성이 된다.
@ToString(exclude = {"manager","kindergarten","classRoom","boards","trainingHists", "testingResults"})
@Table(name = "`TB_User`")
// @DynamicInsert //insert시 null 인 필드를 제외시킨다
public class User extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 4346264299276031915L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long UserSeq;

    @Column(nullable = false, length = 20)
    private String UserId;

//    @Column(nullable = false, length = 100)
    private String Password;

//    @Column(nullable = false, length = 50)
    private String UserName;

//    @Column(nullable = false, length = 100)
    private String CellPhone;

    @Enumerated(EnumType.ORDINAL)
//    @Column(nullable = false, length = 1)
    private TableStatus UseYn; // 미사용, 사용


    @Column(length = 20)
    private String FirstAccessIp;

    @Column(length = 20)
    private String LastAccessIp;

    // DB는 RoleType이라는게 없다.
//    @Enumerated(EnumType.STRING)
////    @Column(nullable = false, length = 20)
//    private RoleType Role; // Enum을 쓰는게 좋다, // ADMIN, USER

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "RoleId")
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ManagerId")
    private Manager manager;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "KindergartenId")
    private Kindergarten kindergarten;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ClassId")
    private ClassRoom classRoom;

    // 1. 참조가 되는 앞부분을 의미하며, 정상적으로 직렬화를 수행한다.
    // 2. Collection Type 에 적용된다.
    @JsonManagedReference
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY) // mappedBy 연관관계의 주인이 아니다 (난 FK가 아니에요) DB에 칼럼을 만들지 마세요
    @JsonIgnoreProperties({"user"}) // Reply객체의 board는 json으로 파싱하지 않겠다는 설정 => 무한참조 방지 반드시 설정해야함( 대부분 OneToMany 해당
    @OrderBy("BoardId desc")
    private List<Board> boards;

    // 1. 참조가 되는 앞부분을 의미하며, 정상적으로 직렬화를 수행한다.
    // 2. Collection Type 에 적용된다.
    @JsonManagedReference
    @OneToMany(mappedBy = "user") // 기본 전략 Lazy
    @JsonIgnoreProperties({"user"}) // 무한참조 방지 반드시 설정해야함
    private List<TrainingHist> trainingHists;

    // 1. 참조가 되는 앞부분을 의미하며, 정상적으로 직렬화를 수행한다.
    // 2. Collection Type 에 적용된다.
    @JsonManagedReference
    @OneToMany(mappedBy = "user") // 기본 전략 Lazy
    @JsonIgnoreProperties({"user"}) // 무한참조 방지 반드시 설정해야함
    private List<TestingResult> testingResults;


}