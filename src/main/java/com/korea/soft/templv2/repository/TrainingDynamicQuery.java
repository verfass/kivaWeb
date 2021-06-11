package com.korea.soft.templv2.repository;

import com.korea.soft.templv2.domain.dto.training.TrainingHistResultDto;
import com.korea.soft.templv2.domain.entity.*;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.hibernate.criterion.Projection;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.korea.soft.templv2.domain.entity.QTrainingMenu.trainingMenu;
import static com.korea.soft.templv2.domain.entity.QTrainingHist.trainingHist;
import static com.korea.soft.templv2.domain.entity.QUser.user;
import static com.korea.soft.templv2.domain.entity.QDailyTalk.dailyTalk;
import static com.korea.soft.templv2.domain.entity.QPhonics.phonics;
import static com.korea.soft.templv2.domain.entity.QTesting.testing;
import static com.korea.soft.templv2.domain.entity.QTestingResult.testingResult;

@RequiredArgsConstructor
@Repository
public class TrainingDynamicQuery {
    private final JPAQueryFactory queryFactory;


    public List<TrainingMenu> findByMainMenu() {
        return queryFactory.selectFrom(trainingMenu)
                .where(trainingMenu.ParentId.isNull())
                .fetch();
    }

    public List<TrainingMenu> findBySubMenu(Long parentId) {
        return queryFactory.selectFrom(trainingMenu)
                .where(trainingMenu.ParentId.eq(parentId))
                .fetch();
    }

    public List<TrainingHistResultDto> findByTrainingHist(Long menuId, Long userSeq) {
        List<TrainingHistResultDto>  trainingHistResultDtos = queryFactory.select(Projections.fields(TrainingHistResultDto.class,
                trainingHist.ClickCount.coalesce(0).as("ClickCount"),
                trainingMenu.VideoUrl.as("KivaPlayUrl"),
                trainingMenu.MenuName.as("MenuName"),
                trainingMenu.MenuId.as("MenuId"),
                phonics.PhonicsId.as("PhonicsId"),
                dailyTalk.DailyTalkId.as("DailyTalkId")
                ))
                .from(trainingMenu)
                .leftJoin(trainingHist).on(trainingMenu.MenuId.eq(trainingHist.trainingMenu.MenuId).and(trainingHist.user.UserSeq.eq(userSeq)))
                .leftJoin(user).on(trainingHist.user.UserSeq.eq(user.UserSeq))
                .leftJoin(phonics).on(trainingMenu.MenuId.eq(phonics.trainingMenu.MenuId))
                .leftJoin(dailyTalk).on(trainingMenu.MenuId.eq(dailyTalk.trainingMenu.MenuId))
                .where(trainingMenu.ParentId.eq(menuId))
                .fetch();

        return trainingHistResultDtos;
    }
    public TrainingHist findByTrainingHistOne(Long menuId, Long userSeq) {
        TrainingHist  trainingHistResultDtos = queryFactory.selectFrom(trainingHist)
                .innerJoin(trainingMenu).on(trainingHist.trainingMenu.MenuId.eq(trainingMenu.MenuId))
                .innerJoin(user).on(trainingHist.user.UserSeq.eq(user.UserSeq))
                .where(trainingHist.trainingMenu.MenuId.eq(menuId),
                        trainingHist.user.UserSeq.eq(userSeq)
                )
                .fetchFirst();

        return trainingHistResultDtos;
    }

    public List<Testing> findByTestings(Long testingMenuId) {
        List<Testing> testings = queryFactory.selectFrom(testing)
                .innerJoin(testing.trainingMenu, trainingMenu)
                .where(trainingMenu.MenuId.eq(testingMenuId))
                .orderBy(testing.Sort.asc())
                .fetch();
        return testings;
    }

    public List<TestingResult> findByTestingResults(Long testingMenuId, Long userSeq) {
        List<TestingResult> testings = queryFactory.selectFrom(testingResult)
                .innerJoin(testingResult.user, user)
                .where(user.UserSeq.eq(userSeq),
                        testingResult.MenuId.eq(testingMenuId))
                .limit(3L)
                .orderBy(testingResult.TestingResultId.asc())
                .fetch();
        return testings;
    }


//    public DailyTalk findByDailyTalk() {
//        return queryFactory.selectFrom(dailyTalk)
//                .where(trainingMenu.ParentId.isNull())
//                .fetch();
//    }
//    public Phonics findByPhonics() {
//        return queryFactory.selectFrom(phonics)
//                .inn
//                .where(phonics.trainingMenu.MenuId.isNull())
//                .fetch();
//    }

}