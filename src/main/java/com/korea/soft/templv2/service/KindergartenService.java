package com.korea.soft.templv2.service;


import com.korea.soft.templv2.domain.dto.kindergarten.KindergartenResultDto;
import com.korea.soft.templv2.domain.entity.Board;
import com.korea.soft.templv2.domain.entity.Kindergarten;
import com.korea.soft.templv2.repository.BoardRepository;
import com.korea.soft.templv2.repository.KindergartenDynamicQuery;
import com.korea.soft.templv2.repository.KindergartenRepository;
import com.korea.soft.templv2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

// 서비스를 하는 이유
// 1. 트랜잭션 관리를 위해
// 2. 서비스 의미 때문에


// 스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해줌. IOC를 해준다.
@Slf4j
@RequiredArgsConstructor
@Service
public class KindergartenService {

    private final KindergartenRepository kindergartenRepository;
    private final KindergartenDynamicQuery kindergartenDynamicQuery;
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<KindergartenResultDto> 기관_검색(String name) {
        List<KindergartenResultDto> resultDtos =
                kindergartenDynamicQuery.findByNameLikeDSL(name)
                        .stream()
                        .map(entity ->
                                KindergartenResultDto.builder()
                                        .KindergartenId(entity.getKindergartenId())
                                        .Address1(entity.getAddress1())
                                        .Address2(entity.getAddress2())
                                        .KindergartenName(entity.getKindergartenName())
                                        .TelePhone(entity.getTelePhone())
                                        .ZipCode(entity.getZipCode())
                                        .ManagerId(entity.getManager().getManagerId())
                                        .build()
                        )
                        .collect(Collectors.toList());
        return resultDtos;
    }


//    @Transactional(readOnly = true)
//    public Page<Board> 글목록(Pageable pageable) {
//        Page<Board> result = boardRepository.findAll(pageable);
//        return result;
//    }

}
