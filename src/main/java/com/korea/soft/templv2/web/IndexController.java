package com.korea.soft.templv2.web;

import com.korea.soft.templv2.common.ClientIp;
import com.korea.soft.templv2.config.auth.PrincipalDetails;
import com.korea.soft.templv2.domain.common.RoleType;
import com.korea.soft.templv2.domain.entity.ClassRoom;
import com.korea.soft.templv2.domain.entity.User;
import com.korea.soft.templv2.repository.ClassRoomRepository;
import com.korea.soft.templv2.service.TrainingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
public class IndexController {
    private final TrainingService trainingService;
    private final ClassRoomRepository classRoomRepository;

    //region [홈페이지 인덱스] - auth
    @GetMapping({"","/"})
    public String index(Model model){
        model.addAttribute("ptName", "index");
        return "index";
    }
    //endregion

    //region [정적 메뉴들] - auth
    @GetMapping("/auth/menu/{menuNum}")
    public String topMenu(@PathVariable String menuNum, Model model){
        String ptName = "menu"+menuNum;
        model.addAttribute("ptName", ptName);
        return "static/"+ptName;
    }
    //endregion

    //region [정적 메뉴들] - auth
    @GetMapping("/auth/download")
    public String topMenu(Model model){
        String ptName = "download";
        model.addAttribute("ptName", ptName);
        return "static/"+ptName;
    }
    //endregion

    //region [권한별 사용자 전용 분기 화면] - RoleType
    @GetMapping("/menu/branch")
    public String branch(Model model, @AuthenticationPrincipal PrincipalDetails principalDetails){
        User user = principalDetails.getUser();
        RoleType role = user.getRole().getRoleType();
        String ptName = "branch";
        if(role == RoleType.KID){
            ClassRoom classRoom = classRoomRepository.findById(user.getClassRoom().getClassId()).orElseThrow(() -> {
                return new IllegalArgumentException("원아의 나이 정보가 존재하지 않습니다.");
            });
            int grade = classRoom.getGrade();
            log.info("학년 정보 =============> {} ", grade);
            model.addAttribute("grade", grade);

            if( grade == 3 || grade == 4 ){
                model.addAttribute("SubMenus", trainingService.서브메뉴(1L)); // 버블버블B (3~4세)
                return "training/main_buble";
            } else if( grade == 5) {
                model.addAttribute("SubMenus", trainingService.서브메뉴(2L)); // 키바월드A (5세)
            } else if( grade == 6) {
                model.addAttribute("SubMenus", trainingService.서브메뉴(3L)); // 키바월드B (6세)
            } else if( grade == 7) {
                model.addAttribute("SubMenus", trainingService.서브메뉴(4L)); // 키바월드C (7세)
            }
            return "training/main";
        }

        model.addAttribute("ptName", ptName);
        return "static/"+ptName;
    }
    //endregion
}
