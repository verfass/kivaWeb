package com.korea.soft.templv2.repository;

import com.korea.soft.templv2.domain.common.ValidatationMessage;
import com.korea.soft.templv2.domain.dto.training.TrainingHistResultDto;
import com.korea.soft.templv2.domain.entity.TestingResult;
import com.korea.soft.templv2.domain.entity.TrainingHist;
import com.korea.soft.templv2.domain.entity.TrainingMenu;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class UserRepositoryTest {

//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private TrainingDynamicQuery trainingDynamicQuery;
//
//
//    @Test
//    public void testQuery1() {
//        System.out.printf("테스트");
//    }
//    @Test
//    public void 카운트() {
//        List<TrainingHistResultDto> trainingHistResultDtos = trainingDynamicQuery.findByTrainingHist(365L,15L);
//        for(TrainingHistResultDto traininghist : trainingHistResultDtos){
//            System.out.println(traininghist);
//        }
//    }
//    @Test
//    public void 테스트결과() {
//        List<TestingResult> testingResults = trainingDynamicQuery.findByTestingResults(368L, 39L);
//        for(TestingResult testingResult : testingResults){
//            System.out.println(testingResult);
//        }
//    }

}
