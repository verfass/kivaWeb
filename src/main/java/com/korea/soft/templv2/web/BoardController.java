package com.korea.soft.templv2.web;

import com.korea.soft.templv2.config.auth.PrincipalDetails;
import com.korea.soft.templv2.domain.common.CommonPageInfo;
import com.korea.soft.templv2.domain.common.CommonRedirect;
import com.korea.soft.templv2.domain.common.RoleType;
import com.korea.soft.templv2.domain.entity.Board;
import com.korea.soft.templv2.domain.entity.BoardGroup;
import com.korea.soft.templv2.domain.entity.Role;
import com.korea.soft.templv2.domain.entity.User;
import com.korea.soft.templv2.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;
    private final CommonRedirect redirect;

    //region [공지사항 목록] - auth
    @GetMapping("/auth/boardGroup/notice")
    public String noticeAll(Model model,
                            @RequestParam(required = false, defaultValue = "") String searchText,
                            @PageableDefault(size = 20, sort = "BoardId", direction = Sort.Direction.DESC) Pageable pageable) {

        Page<Board> noticeList = boardService.게시판_글목록(1, searchText, pageable);

        CommonPageInfo pageInfo = new CommonPageInfo(noticeList);
        log.info("페이징 객체 확인 : {}", pageInfo);

        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("boardList", noticeList);
        model.addAttribute("ptName", "notice");
        return "board/notice_all";
    }
    //endregion

    //region [공지사항 상세보기] - auth
    @GetMapping("/auth/boardGroup/notice/{boardId}")
    public String noticeDetail(@PathVariable Long boardId, Model model) {

        Board notice = boardService.글상세보기(boardId);
        model.addAttribute("board", notice);
        model.addAttribute("ptName", "notice");
        return "board/notice_detail";
    }
    //endregion

    //region [게시글 목록]
    @Transactional
    @GetMapping("/boardGroup/{groupId}")
    public String boardAll(Model model,
                           @AuthenticationPrincipal PrincipalDetails principalDetails,
                           @PathVariable int groupId,
                           @RequestParam(required = false, defaultValue = "") String searchText,
                           @PageableDefault(size = 20, sort = "BoardId", direction = Sort.Direction.DESC) Pageable pageable) {
        User user = principalDetails.getUser();
        RoleType role = user.getRole().getRoleType();

        List<BoardGroup> boardGroups = boardService.게시판_그룹목록(role);
        BoardGroup groupInfo = boardGroups.stream()
                .filter(t -> t.getGroupId() == groupId)
                .findFirst().orElseGet(() -> {
                    return null;
                });
        if (boardGroups.size() == 0) {
            redirect.CommonRedirect(model, "게시판에 읽기 권한이 존재하지 않습니다.");
            return "redirect";
        }

        Page<Board> boardList = boardService.게시판_글목록(groupId, searchText, pageable);
        CommonPageInfo pageInfo = new CommonPageInfo(boardList);

        model.addAttribute("boardGroups", boardGroups);
        model.addAttribute("boardList", boardList);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("ptName", "board");
        model.addAttribute("groupInfo", groupInfo);
        return "board/board_all";
    }
    //endregion

    //region [게시글 상세보기]
    @GetMapping("/boardGroup/{groupId}/board/{boardId}")
    public String boardDetail(@PathVariable Long boardId, Model model) {
        Board board = boardService.글상세보기(boardId);
        model.addAttribute("board", board);
        model.addAttribute("ptName", "board");
        return "board/board_detail";
    }
    //endregion

}