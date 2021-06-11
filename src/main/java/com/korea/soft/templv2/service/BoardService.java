package com.korea.soft.templv2.service;


import com.korea.soft.templv2.domain.common.RoleType;
import com.korea.soft.templv2.domain.dto.BoardSaveReqDTO;
import com.korea.soft.templv2.domain.dto.ReplyReqDto;
import com.korea.soft.templv2.domain.entity.Board;
import com.korea.soft.templv2.domain.entity.BoardGroup;
import com.korea.soft.templv2.domain.entity.User;
import com.korea.soft.templv2.repository.BoardDynamicQuery;
import com.korea.soft.templv2.repository.BoardGroupRepository;
import com.korea.soft.templv2.repository.BoardRepository;
import com.korea.soft.templv2.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// 서비스를 하는 이유
// 1. 트랜잭션 관리를 위해
// 2. 서비스 의미 때문에


// 스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해줌. IOC를 해준다.
@Slf4j
@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;
    private final BoardDynamicQuery boardDynamicQuery;
    private final UserRepository userRepository;
    private final BoardGroupRepository boardGroupRepository;


    @Transactional(readOnly = true)
    public Page<Board> 글목록(Pageable pageable) {
        Page<Board> result = boardRepository.findAll(pageable);
        return result;
    }

    @Transactional(readOnly = true)
    public Board 글상세보기(Long id) {
        return boardRepository.findById(id)
                .orElseThrow(() -> {
                    return new IllegalArgumentException("글 상세보기 실패: 아이디를 찾을 수 없습니다.");
                });
    }
    @Transactional(readOnly = true)
    public Page<Board> 게시판_글목록(int groupId, String searchText, Pageable pageable) {
//        Page<Board> boards = boardRepository.findByGroupId(pageable,groupId);
        Page<Board> boards = boardDynamicQuery.findByGroupIdAndBoardTitle(pageable, groupId, searchText);

        return boards;
    }

    @Transactional(readOnly = true)
    public List<BoardGroup> 게시판_그룹목록(RoleType role) {
        int notGroupId = 1; // 공지사항 빼기
        List<BoardGroup> boardGroups = boardGroupRepository.findAllByLikeRole("%"+role.getRoleInt()+"%",notGroupId);
        log.info("게시판그룹 ==========> {}", boardGroups);

        return boardGroups;
    }
}
