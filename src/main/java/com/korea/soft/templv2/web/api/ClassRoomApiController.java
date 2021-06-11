package com.korea.soft.templv2.web.api;


import com.korea.soft.templv2.domain.common.CommonDto;
import com.korea.soft.templv2.domain.dto.kindergarten.ClassRoomResultDto;
import com.korea.soft.templv2.domain.dto.kindergarten.KindergartenResultDto;
import com.korea.soft.templv2.domain.entity.ClassRoom;
import com.korea.soft.templv2.service.ClassRoomService;
import com.korea.soft.templv2.service.KindergartenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ClassRoomApiController {
    private final ClassRoomService kindergartenService;
    private final AuthenticationManager authenticationManager;


    @GetMapping("/auth/classRoom/{kindergartenId}")
    public CommonDto<?> findById(@PathVariable Long kindergartenId){
        log.info("파라미터 체크 ===== > {}", kindergartenId);
        List<ClassRoomResultDto> classRoomList = kindergartenService.클래스룸_검색(kindergartenId);
        log.info("파라미터 체크 ===== > {}", classRoomList);
        return new CommonDto<List<ClassRoomResultDto>>(HttpStatus.OK.value(), classRoomList);
    }
}