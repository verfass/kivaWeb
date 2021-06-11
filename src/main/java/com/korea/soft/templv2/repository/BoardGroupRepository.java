package com.korea.soft.templv2.repository;


import com.korea.soft.templv2.domain.common.RoleType;
import com.korea.soft.templv2.domain.entity.Board;
import com.korea.soft.templv2.domain.entity.BoardGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.sql.Driver;
import java.util.List;


public interface BoardGroupRepository extends JpaRepository<BoardGroup, Integer>, QuerydslPredicateExecutor<BoardGroup> {

    @Query("select g from BoardGroup g where g.GroupId <> :notGroupId and g.Roles like :role order by g.Sort asc ")
    List<BoardGroup> findAllByLikeRole(@Param("role") String role,@Param("notGroupId") int notGroupId);

//    @Query("select f from Board b inner join File f on b.id = f.relId and f.relTypeCode = 'board' where b.id = :id ")
//    List<Object[]> getBoardWithFiles(@Param("id") int id);

//    @Query("select b from BoardGroup g inner join Board b on g.GroupId = b.boardGroup.GroupId and g.GroupId = :boardId")
//    Page<Board> findByGroupId(Pageable pageable, long groupId); // User 테이블의 키값은 Integer 이다
}
