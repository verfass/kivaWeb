package com.korea.soft.templv2.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.korea.soft.templv2.domain.common.RoleType;
import com.korea.soft.templv2.domain.entity.inherit.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "`TB_Role`")
@ToString  /*나중에 따로 뽑을때 사용*/
public class Role implements Serializable {
    private static final long serialVersionUID = -5090689732836211597L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private int RoleId;
    private String RoleName;
    @Enumerated(EnumType.STRING)
    private RoleType RoleType; // Enum을 쓰는게 좋다, // ADMIN, USER

//    @JsonIgnoreProperties({"role"}) // Reply객체의 board는 json으로 파싱하지 않겠다는 설정 => 무한참조 방지 반드시 설정해야함
//    @OneToOne(mappedBy = "role",fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
//    @JoinColumn(name = "RoleId")
//    private User user;

}