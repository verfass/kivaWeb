package com.korea.soft.templv2.service;


import com.korea.soft.templv2.domain.dto.kindergarten.ClassRoomResultDto;
import com.korea.soft.templv2.domain.dto.kindergarten.KindergartenResultDto;
import com.korea.soft.templv2.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

// 서비스를 하는 이유
// 1. 트랜잭션 관리를 위해
// 2. 서비스 의미 때문에


// 스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해줌. IOC를 해준다.
@Slf4j
@RequiredArgsConstructor
@Service
public class ClassRoomService {

    private final ClassRoomRepository classRoomRepository;
    private final ClassRoomDynamicQuery classRoomDynamicQuery;
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<ClassRoomResultDto> 클래스룸_검색(Long kindergartenId) {
        List<ClassRoomResultDto> classRoomList =
                classRoomDynamicQuery.findByKindergartenId(kindergartenId)
                .stream()
                .map(entity ->
                        ClassRoomResultDto.builder()
                                .ClassId(entity.getClassId())
                                .ClassName(entity.getClassName())
                                .Grade(entity.getGrade())
                                .KindergartenId(entity.getKindergarten().getKindergartenId())
                                .build()
                )
                .collect(Collectors.toList());
        return classRoomList;
    }


//    @Transactional(readOnly = true)
//    public Page<Board> 글목록(Pageable pageable) {
//        Page<Board> result = boardRepository.findAll(pageable);
//        return result;
//    }

}
