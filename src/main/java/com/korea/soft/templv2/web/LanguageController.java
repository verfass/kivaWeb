package com.korea.soft.templv2.web;

import com.korea.soft.templv2.config.auth.PrincipalDetails;
import com.korea.soft.templv2.domain.common.RoleType;
import com.korea.soft.templv2.domain.entity.User;
import com.korea.soft.templv2.service.LanguageMenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LanguageController {
    private final LanguageMenuService languageMenuService;

    //region [어학기 메인 화면]
    @GetMapping("/language")
    public String main(Model model, @AuthenticationPrincipal PrincipalDetails principalDetails){
        model.addAttribute("MainMenus",languageMenuService.메인메뉴());
        return "language/main";
    }
    //endregion
    //region [어학기 메인_서브 메뉴]
    @GetMapping("/language/parent/{ParentId}/{type}")
    public String sub(@PathVariable Long ParentId, @PathVariable String type, Model model, @AuthenticationPrincipal PrincipalDetails principalDetails){


        model.addAttribute("SubMenus", languageMenuService.서브메뉴(ParentId));
        model.addAttribute("type", type);
        return "language/sub";
    }
    //endregion
    //region [어학기 메인_서브_카테고리 메뉴]
    @GetMapping("/language/parent/{ParentId}/menu/{MenuId}/{type}/{bookNum}")
    public String sub_category(@PathVariable Long ParentId, @PathVariable Long MenuId,
                               @PathVariable String type,@PathVariable int bookNum, Model model, @AuthenticationPrincipal PrincipalDetails principalDetails){
        model.addAttribute("CategoryMenus", languageMenuService.서브메뉴(MenuId));
        model.addAttribute("type", type);
        model.addAttribute("bookNum",bookNum);
        return "language/category";
    }
    //endregion

}
