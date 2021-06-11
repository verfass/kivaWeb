package com.korea.soft.templv2.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.korea.soft.templv2.domain.common.TableStatus;
import com.korea.soft.templv2.domain.entity.inherit.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "`TB_SmsHist`")
public class SmsHist extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long SmsId;
    private String SendType;
    private String SendText;
    private String SendPh;

    private String SendDate;
    @Enumerated(EnumType.STRING)
    private TableStatus ResultYn;
    private String AuthCode;


}