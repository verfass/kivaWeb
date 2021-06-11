package com.korea.soft.templv2.repository;


import com.korea.soft.templv2.domain.entity.DailyTalk;
import com.korea.soft.templv2.domain.entity.Testing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


public interface TestingRepository extends JpaRepository<Testing, Long>, QuerydslPredicateExecutor<Testing> {

//    @Query("select f from Board b inner join File f on b.id = f.relId and f.relTypeCode = 'board' where b.id = :id ")
//    List<Object[]> getBoardWithFiles(@Param("id") int id);

//    @Query("select b from" +
//            " Board b inner join BoardGroup g on g.GroupId = b.boardGroup.GroupId " +
//            "and b.boardGroup.GroupId = :groupId")
//    Page<Board> findByGroupId(@Param("pageable") Pageable pageable, @Param("groupId") int groupId); // User 테이블의 키값은 Integer 이다

}
