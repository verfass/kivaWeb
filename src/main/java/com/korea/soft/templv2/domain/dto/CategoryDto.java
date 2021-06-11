package com.korea.soft.templv2.domain.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CategoryDto implements Serializable {

    private static final long serialVersionUID = -8897967171463377124L;

    private Long categoryId;
    private String categoryName;
    private Long parentId;
    private List<CategoryDto> subCategories;


}
