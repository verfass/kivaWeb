package com.korea.soft.templv2.web.api;


import com.korea.soft.templv2.domain.common.CommonDto;
import com.korea.soft.templv2.domain.dto.kindergarten.KindergartenResultDto;
import com.korea.soft.templv2.service.KindergartenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class KindergartenApiController {
    private final KindergartenService kindergartenService;
    private final AuthenticationManager authenticationManager;


    @GetMapping("/auth/kindergarten/{name}")
    public CommonDto<?> findById(@PathVariable String name){
        log.info("파라미터 체크 ===== > {}", name);
        List<KindergartenResultDto> kindergartens = kindergartenService.기관_검색(name);
        log.info("파라미터 체크 ===== > {}", kindergartens);
        return new CommonDto<List<KindergartenResultDto>>(HttpStatus.OK.value(), kindergartens);
    }
}
