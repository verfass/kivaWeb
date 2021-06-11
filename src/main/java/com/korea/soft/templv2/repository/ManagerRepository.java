package com.korea.soft.templv2.repository;

import com.korea.soft.templv2.domain.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long> {

//    @Modifying
//    @Query(value = "INSERT INTO Reply(userId, boardId, content, createDate ) " +
//            "VALUES(?1,?2,?3,getdate())", nativeQuery = true)
//    int customSave(Long userId, Long boardId, String content); // 업데이트된 행의 개수를 리턴해줌
}
