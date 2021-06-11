package com.korea.soft.templv2.web;

import com.korea.soft.templv2.config.auth.PrincipalDetails;
import com.korea.soft.templv2.domain.common.RoleType;
import com.korea.soft.templv2.domain.entity.StudyRoom;
import com.korea.soft.templv2.service.LanguageMenuService;
import com.korea.soft.templv2.service.StudyRoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class StudyRoomController {
    private final StudyRoomService studyRoomService;

    //region [학습관 메인] - 'ROLE_ADMIN','ROLE_MANAGER','ROLE_TEACHER','ROLE_KINDERGARTEN'
//    @Secured({"ROLE_ADMIN","ROLE_MANAGER","ROLE_TEACHER","ROLE_KINDERGARTEN"})
    @GetMapping("/study")
    public String studyRoom(Model model){
        return "study/study_menu";
    }
    //endregion

    //region [학습관 서브 메뉴]
    @GetMapping("/study/menu/{parentId}")
    public String detail(@PathVariable Long parentId,
                      @RequestParam(required = false, defaultValue = "1") String month, Model model, @AuthenticationPrincipal PrincipalDetails principalDetails){

        log.info("파라미터 확인 {}, {}", parentId, month);
        List<StudyRoom> studyRooms = studyRoomService.학습관상세(parentId, month);
        model.addAttribute("parentId", parentId);
        model.addAttribute("selectMonth", month);
        model.addAttribute("studyRooms", studyRooms);
        return "study/study_room";
    }
    //endregion

    //region [어학기 서브_카테고리 메뉴]
//    @GetMapping("/study/menu/{MenuId}/{type}")
//    public String sub_category(@PathVariable Long MenuId, @PathVariable String type,
//                               Model model, @AuthenticationPrincipal PrincipalDetails principalDetails){
//        model.addAttribute("CategoryMenus", languageMenuService.서브메뉴(MenuId));
//        model.addAttribute("type", type);
//        return "language/category";
//    }
    //endregion

}
