package com.korea.soft.templv2.repository;


import com.korea.soft.templv2.domain.common.TableStatus;
import com.korea.soft.templv2.domain.entity.Board;
import com.korea.soft.templv2.domain.entity.BoardGroup;
import com.korea.soft.templv2.domain.entity.QBoard;
import com.korea.soft.templv2.domain.entity.User;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;


@SpringBootTest
public class BoardRepositoryTest {

//    @Autowired
//    private BoardRepository boardRepository;
//    @Autowired
//    private BoardGroupRepository boardGroupRepository;
//
//    @Test
//    public void insertDummys() {
//        IntStream.rangeClosed(161,180).forEach(i -> {
//            long j = 161;
//            User user = User.builder().UserSeq(j).build();
//            BoardGroup boardGroup= BoardGroup.builder().GroupId(2).build();
//            Board board = Board.builder()
//                    .BoardTitle("Title...." + i)
//                    .BoardContent("Content..." +i)
//                    .boardGroup(boardGroup)
//                    .user(user)
//                    .build();
//            System.out.println(boardRepository.save(board));
//        });
//    }
//    @Test
//    public void BoardGroupDummys(){
//        BoardGroup boardGroup= BoardGroup.builder().GroupId(6).GroupName("다른거카테고리6").Sort(5).UseYn(TableStatus.N).build();
//        boardGroupRepository.save(boardGroup);
//    }
//
//
//    @Transactional
//    @Test
//    public void testQuery1() {
//        Pageable pageable = PageRequest.of(0,10, Sort.by("BoardId").descending());
//        // findAll -> JpaRepository _
////        Page<Board> boards =boardRepository.findByGroupId(pageable,1);
////        System.out.println(boards.toString());
////        boards.forEach(board -> {
////            System.out.println(board);
////        });
//
////        //Predicate
////        QBoard qBoard = QBoard.board;
////        BooleanBuilder booleanBuilder = new BooleanBuilder();
////
////        // where 절 :  title like %1% or content like %1%
////        BooleanExpression expression = qBoard.BoardTitle.contains("1");
////        BooleanExpression exAll = expression.or(qBoard.content.contains("1"));
////
////        booleanBuilder.and(exAll);
////        booleanBuilder.and(qBoard.id.gt(0));
////
////        Page<Board> result = boardRepository.findAll(booleanBuilder,pageable);
////        System.out.println(result.toString());
////        result.forEach(board -> {
////            System.out.println(board);
////        });
//
//    }
//
//    @Test
//    @Transactional   // 중요!! Lazy 로딩할때는 트랜젝션(@Transactional) 을 꼭 걸어줘야한다
//    public void testRead1() {
//        Optional<Board> result = boardRepository.findById(100L);
//        Board board = result.get();
//        System.out.println(board);
//        System.out.println(board.getUser()); //service 단에서 getUser() 메서드 실행과 동시에 쿼리를 실행함.. 유저만 가져오는 쿼리..
//        System.out.println(board.getReplys()); //service 단에서 getReplys() 메서드 실행과 동시에 쿼리를 실행함.. 유저만 가져오는 쿼리..
//    }
//
//    @Test
//    @Transactional   // 중요!! Lazy 로딩할때는 트랜젝션(@Transactional) 을 꼭 걸어줘야한다
//    public void getBoardWithFiles_테스트() {
//        List<Object[]> result = boardRepository.getBoardWithFiles(1);
//
//        List<File> files = null;
//        for (Object[] arr : result){
//            Board board = (Board) arr[0];
//            File file = (File) arr[1];
//            files.add((File) arr[1]);
//            System.out.println(board.toString());
//            System.out.println(file.toString());
//        }
//    }

}
