package com.korea.soft.templv2.repository;

import com.korea.soft.templv2.domain.entity.Category;
import com.korea.soft.templv2.domain.entity.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
