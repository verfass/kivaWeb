package com.korea.soft.templv2.service;


import com.korea.soft.templv2.domain.dto.kindergarten.ClassRoomResultDto;
import com.korea.soft.templv2.domain.dto.language.LanguageMenuResultDto;
import com.korea.soft.templv2.domain.entity.LanguageMenu;
import com.korea.soft.templv2.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

// 서비스를 하는 이유
// 1. 트랜잭션 관리를 위해
// 2. 서비스 의미 때문에
// 스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해줌. IOC를 해준다.
@Slf4j
@RequiredArgsConstructor
@Service
public class LanguageMenuService {

    private final ClassRoomRepository classRoomRepository;
    private final ClassRoomDynamicQuery classRoomDynamicQuery;
    private final LanguageMenuDynamicQuery languageMenuDynamicQuery;
    private final LanguageMenuRepository languageMenuRepository;

    @Transactional(readOnly = true)
    public List<LanguageMenu> 메인메뉴() {
        List<LanguageMenu> mainMenus = languageMenuDynamicQuery.findByMainMenu();
        return mainMenus;
    }
    @Transactional(readOnly = true)
    public List<LanguageMenu> 서브메뉴(Long parentId) {
        List<LanguageMenu> subMenus = languageMenuDynamicQuery.findBySubMenu(parentId);

        return subMenus;
    }


//    @Transactional(readOnly = true)
//    public Page<Board> 글목록(Pageable pageable) {
//        Page<Board> result = boardRepository.findAll(pageable);
//        return result;
//    }

}
