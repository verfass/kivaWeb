package com.korea.soft.templv2.repository;


import com.korea.soft.templv2.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

// DAO와 같은 개념
// 자동으로 bean등록이 된다.
// @Repository // 생략이 가능하다.
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM [TB_User] WHERE UserId = ?1", nativeQuery = true)
    Optional<User> findByUserId(String UserId); // User 테이블의 키값은 Integer 이다

//    Optional<User> findById(String UserId); // User 테이블의 키값은 Integer 이다

}
//JPA Naming 전략
// SELECT * FFOM user WHERE username = ? AND password = ?;
//    User findByUsernameAndPassword(String username, String password);

//    @Query(value = "SELECT * FROM [User] WHERE username = ?1 AND password=?2", nativeQuery = true)
//    User login(String username, String password);