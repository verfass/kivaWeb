package com.korea.soft.templv2.service;


import com.korea.soft.templv2.domain.entity.LanguageMenu;
import com.korea.soft.templv2.domain.entity.StudyRoom;
import com.korea.soft.templv2.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
public class StudyRoomService {

    private final StudyMenuRepository studyMenuRepository;
    private final StudyRoomRepository studyRoomRepository;
    private final StudyRoomDynamicQuery studyRoomDynamicQuery;


    @Transactional(readOnly = true)
    public List<StudyRoom> 학습관상세(Long parentId, String month) {
        List<StudyRoom> subMenus = studyRoomDynamicQuery.findByStudyRoom(parentId, month);

        return subMenus;
    }

}
