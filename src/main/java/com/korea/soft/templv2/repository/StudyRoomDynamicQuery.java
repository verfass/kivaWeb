package com.korea.soft.templv2.repository;

import com.korea.soft.templv2.domain.entity.LanguageMenu;
import com.korea.soft.templv2.domain.entity.StudyRoom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.korea.soft.templv2.domain.entity.QStudyMenu.studyMenu;
import static com.korea.soft.templv2.domain.entity.QStudyRoom.studyRoom;

@RequiredArgsConstructor
@Repository
public class StudyRoomDynamicQuery {
    private final JPAQueryFactory queryFactory;


    public List<StudyRoom> findByStudyRoom(Long parentId, String month) {
        return queryFactory.selectFrom(studyRoom)
                .innerJoin(studyRoom.studyMenu, studyMenu)
                .where(studyMenu.ParentId.eq(parentId),
                        studyMenu.MenuName.eq(month))
                .orderBy(studyRoom.Week.asc(),studyRoom.StudyRoomId.asc(),studyRoom.StudyType.asc())
                .fetch();
    }
}