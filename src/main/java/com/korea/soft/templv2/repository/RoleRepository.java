package com.korea.soft.templv2.repository;

import com.korea.soft.templv2.domain.common.RoleType;
import com.korea.soft.templv2.domain.entity.Board;
import com.korea.soft.templv2.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
