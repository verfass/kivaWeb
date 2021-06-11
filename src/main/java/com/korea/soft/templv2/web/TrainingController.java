package com.korea.soft.templv2.web;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.korea.soft.templv2.config.auth.PrincipalDetails;
import com.korea.soft.templv2.domain.common.CommonRedirect;
import com.korea.soft.templv2.domain.entity.Testing;
import com.korea.soft.templv2.domain.entity.TestingResult;
import com.korea.soft.templv2.domain.entity.User;
import com.korea.soft.templv2.service.TrainingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequiredArgsConstructor
public class TrainingController {
    private final TrainingService trainingService;
    private final CommonRedirect redirect;

    //region [트레이닝 메인_서브 메뉴]
    @GetMapping("/training/parent/{ParentId}/{grade}")
    public String sub(@PathVariable Long ParentId, @PathVariable int grade, Model model, @AuthenticationPrincipal PrincipalDetails principalDetails){
        model.addAttribute("SubMenus", trainingService.서브메뉴(ParentId));
        model.addAttribute("grade", grade);
        if(grade == 3 || grade == 4){
            return "training/sub_buble";
        } else {
            return "training/sub";
        }
    }
    //endregion

    //region [주별 파닉스 화면]
    @GetMapping("/training/phonics/{phonicsId}")
    public String phonics( @PathVariable Long phonicsId, Model model, @AuthenticationPrincipal PrincipalDetails principalDetails){

        model.addAttribute("Phonics", trainingService.문제가져오기(phonicsId));
        return "training/phonics";
    }
    //endregion

    //region [주별 데일리톡 화면]
    @GetMapping("/training/dailyTalk/{dailyTalkId}")
    public String dailyTalk( @PathVariable Long dailyTalkId, Model model, @AuthenticationPrincipal PrincipalDetails principalDetails){

        model.addAttribute("DailyTalk", trainingService.데일리톡상세(dailyTalkId));
        return "training/daily_talk";
    }
    //endregion

    //region [월별 TEST 화면]
    @GetMapping("/training/test/{testingMenuId}")
    public String test( @PathVariable Long testingMenuId, Model model, @AuthenticationPrincipal PrincipalDetails principalDetails){
        List<Testing> testings =  trainingService.테스트상세(testingMenuId);
        if (testings.size() == 0) {
            redirect.CommonRedirect(model, "등록된 테스트가 없습니다.");
            return "redirect";
        }
        model.addAttribute("testingMenuId", testingMenuId);
        model.addAttribute("Testings", testings);
        return "training/testing";
    }
    //endregion

    //region [월별 TEST 화면 -> 결과]
    @PostMapping("/training/test/{testingMenuId}/result")
    public String testResult(@PathVariable Long testingMenuId,@RequestParam String paramData, @RequestParam Integer pointSum, Model model, @AuthenticationPrincipal PrincipalDetails principalDetails){
        User user = principalDetails.getUser();
        List<TestingResult> preTestingResults =trainingService.테스트결과목록(testingMenuId, user);

        List<Map<String, Object>> testingResults = new Gson().fromJson(String.valueOf(paramData),
                new TypeToken<List<Map<String, Object>>>(){}.getType());
        log.info("testingResults : {}", testingResults);
        log.info("pointSum : {}", pointSum);

        model.addAttribute("testingMenuId", testingMenuId);
        model.addAttribute("pointSum", pointSum);
        model.addAttribute("preTestingResults", preTestingResults);
        model.addAttribute("testingResults", testingResults);
        return "training/testing_result";
    }
    //endregion



}
