package com.korea.soft.templv2.service;


import com.korea.soft.templv2.config.auth.PrincipalDetails;
import com.korea.soft.templv2.domain.dto.training.TestingResultReqDto;
import com.korea.soft.templv2.domain.dto.training.TrainingHistResultDto;
import com.korea.soft.templv2.domain.entity.*;
import com.korea.soft.templv2.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
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
public class TrainingService {

    private final TrainingDynamicQuery trainingDynamicQuery;
    private final TrainingMenuRepository menuRepository;
    private final PhonicsRepository phonicsRepository;
    private final TrainingHistRepository histRepository;
    private final DailyTalkRepository dailyTalkRepository;
    private final TestingResultRepository testingResultRepository;

    @Transactional(readOnly = true)
    public List<TrainingMenu> 메인메뉴() {
        List<TrainingMenu> mainMenus = trainingDynamicQuery.findByMainMenu();
        return mainMenus;
    }

    @Transactional(readOnly = true)
    public List<TrainingMenu> 서브메뉴(Long parentId) {
        List<TrainingMenu> subMenus = trainingDynamicQuery.findBySubMenu(parentId);

        return subMenus;
    }

    @Transactional(readOnly = true)
    public TrainingHistResultDto 선택메뉴(Long menuId) {
        PrincipalDetails principal = (PrincipalDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = principal.getUser();
        log.info("유저 가져오는지 확인 ===================> {}", user);

        // 클릭 이력 가져오기
        List<TrainingHistResultDto> trainingHists = trainingDynamicQuery.findByTrainingHist(menuId, user.getUserSeq());


        TrainingHistResultDto resultDto = TrainingHistResultDto.builder()
                .KivaPlayCount(trainingHists.get(0).getClickCount())
                .PhonicsCount(trainingHists.get(1).getClickCount())
                .DailyTalkCount(trainingHists.get(2).getClickCount())
                .KivaPlayMenuId(trainingHists.get(0).getMenuId())
                .PhonicsMenuId(trainingHists.get(1).getMenuId())
                .DailyTalkMenuId(trainingHists.get(2).getMenuId())
                .KivaPlayUrl(trainingHists.get(0).getKivaPlayUrl())
                .PhonicsId(trainingHists.get(1).getPhonicsId())
                .DailyTalkId(trainingHists.get(2).getDailyTalkId())
                .build();
        return resultDto;
    }

    @Transactional(readOnly = true)
    public Phonics 문제가져오기(Long phonicsId) {
        return phonicsRepository.findById(phonicsId).orElseThrow(() -> {
            return new IllegalArgumentException("문제가 등록되어 있지 않습니다.");
        });
    }
    @Transactional
    public void 클릭카운트(Long menuId, User user) {
        TrainingHist trainingHist =  trainingDynamicQuery.findByTrainingHistOne(menuId, user.getUserSeq());
        TrainingMenu menu = menuRepository.findById(menuId).orElseThrow(()->{
            return new IllegalArgumentException("잘못된 메뉴번호 입니다.");
        });
        if(trainingHist == null){
            trainingHist = TrainingHist.builder()
                    .trainingMenu(menu)
                    .user(user)
                    .ClickCount(1)
                    .build();
            histRepository.save(trainingHist);
        } else {
            trainingHist.setClickCount(trainingHist.getClickCount()+1);
        }
    }
    @Transactional(readOnly = true)
    public DailyTalk 데일리톡상세(Long dailyTalkId) {
        DailyTalk dailyTalk = dailyTalkRepository.findById(dailyTalkId).orElseThrow(()->{
            return new IllegalArgumentException("데일리톡이 등록되어 있지 않습니다.");
        });
        return dailyTalk;
    }
    @Transactional(readOnly = true)
    public List<Testing> 테스트상세(Long testingMenuId) {
        List<Testing> testings = trainingDynamicQuery.findByTestings(testingMenuId);
        return testings;
    }
    @Transactional(readOnly = true)
    public List<TestingResult> 테스트결과목록(Long testingMenuId, User user) {
        return trainingDynamicQuery.findByTestingResults(testingMenuId,user.getUserSeq()); // 최대 3개
    }

    @Transactional
    public int 점수저장(TestingResultReqDto resultReqDto, User user) {
        List<TestingResult> testingResults = trainingDynamicQuery.findByTestingResults(resultReqDto.getMenuId(),user.getUserSeq()); // 최대 3개
        if(testingResults.size() >= 3){
            throw new IllegalArgumentException("최대 3회까지만 저장가능합니다.");
        } else {
            TestingResult testingResult = TestingResult.builder()
                    .user(user)
                    .ResultPoint(resultReqDto.getResultPoint())
                    .MenuId(resultReqDto.getMenuId())
                    .build();
            testingResultRepository.save(testingResult);
        }
        return testingResults.size()+1;
    }
}
