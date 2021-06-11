package com.korea.soft.templv2.web.api;


import com.korea.soft.templv2.config.auth.PrincipalDetails;
import com.korea.soft.templv2.domain.common.CommonDto;
import com.korea.soft.templv2.domain.dto.kindergarten.KindergartenResultDto;
import com.korea.soft.templv2.domain.dto.training.TestingResultReqDto;
import com.korea.soft.templv2.domain.dto.training.TrainingHistResultDto;
import com.korea.soft.templv2.domain.entity.TrainingMenu;
import com.korea.soft.templv2.domain.entity.User;
import com.korea.soft.templv2.service.KindergartenService;
import com.korea.soft.templv2.service.TrainingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class TrainingApiController {
    private final TrainingService trainingService;

    
    @GetMapping("/training/parent/{menuId}")
    public CommonDto<?> openCategory(@PathVariable Long menuId){
        TrainingHistResultDto trainingHistResultDto = trainingService.선택메뉴(menuId);
        return new CommonDto<TrainingHistResultDto>(HttpStatus.OK.value(), trainingHistResultDto);
    }
    @PostMapping("/training/counting/{menuId}")
    public CommonDto<?> counting(@PathVariable Long menuId, @AuthenticationPrincipal PrincipalDetails principalDetails){
        User user = principalDetails.getUser();
        trainingService.클릭카운트(menuId, user);
        return new CommonDto<String>(HttpStatus.OK.value(), "클릭카운트 완료");
    }

    @PostMapping("/training/testingResult")
    public CommonDto<?> testingResultSave(@RequestBody TestingResultReqDto resultReqDto, @AuthenticationPrincipal PrincipalDetails principalDetails){
        User user = principalDetails.getUser();

        int pointIndex = trainingService.점수저장(resultReqDto, user);
        return new CommonDto<String>(HttpStatus.OK.value(), pointIndex+"");
    }
}
