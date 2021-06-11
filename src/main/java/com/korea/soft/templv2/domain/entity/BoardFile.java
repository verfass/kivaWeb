package com.korea.soft.templv2.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.korea.soft.templv2.domain.entity.inherit.BaseEntity;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "`TB_BoardFile`")
@ToString( exclude = {"board"})  /*나중에 따로 뽑을때 사용*/
public class BoardFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long FileId;
    private String FileName;
    private String FileExtension;
    private String FileSize;
    private String OriginalName;
    private String FilePath;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BoardId")
    private Board board;

}