package com.korea.soft.templv2.repository;

import com.korea.soft.templv2.domain.common.RoleType;
import com.korea.soft.templv2.domain.common.TableStatus;
import com.korea.soft.templv2.domain.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
public class DummyRepositoryTest {

    @Autowired
    private ClassRoomRepository classRoomRepository;
    @Autowired
    private KindergartenRepository kindergartenRepository;
    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private TrainingMenuRepository trainingMenuRepository;
    @Autowired
    private StudyMenuRepository studyMenuRepository;


//
//    @Test
//    public void insertDummys() {
//        // 지사 데이터
//        IntStream.rangeClosed(1,20).forEach(i -> {
//            Manager dummyMember = Manager.builder()
//                    .ManagerName("지사.." + i)
//                    .RegionName("지역.." + i)  // 비번 1
//                    .ZipCode("우편.."+i)
//                    .Address1("주소1.."+i)
//                    .Address2("주소2.."+i)
//                    .TelePhone("010111"+i)
//                    .build();
//            System.out.println(managerRepository.save(dummyMember));
//        });
//
//        // 유치원 데이터
//        IntStream.rangeClosed(1,40).forEach(i -> {
//            long managerId = (long) ((Math.random() * 20) + 1);
//            Manager manager = Manager.builder()
//                    .ManagerId(managerId)
//                    .build();
//
//            Kindergarten dummyKindergarten = Kindergarten.builder()
//                    .KindergartenName("유치원.." + i)
//                    .ZipCode("우편.."+i)
//                    .Address1("주소1.."+i)
//                    .Address2("주소2.."+i)
//                    .TelePhone("휴대폰.."+i)
//                    .manager(manager)
//                    .build();
//            System.out.println(kindergartenRepository.save(dummyKindergarten));
//        });
//
//        // 클래스룸 데이터
//        IntStream.rangeClosed(1,60).forEach(i -> {
//            long kindergartenId = (long) ((Math.random() * 40) + 1);
//            Kindergarten kindergarten = Kindergarten.builder()
//                    .KindergartenId(kindergartenId)
//                    .build();
//            int grade = (int) ((Math.random() * 5) + 3);
//            ClassRoom dummyClassRoom = ClassRoom.builder()
//                    .ClassName("클래스룸.." + i)
//                    .Grade(grade)
//                    .kindergarten(kindergarten)
//                    .build();
//            System.out.println(classRoomRepository.save(dummyClassRoom));
//        });
//    }
////
//    @Transactional
//    @Rollback(false) // 테스트 환경에서 Transactional은 디비에 반영할건지 정해주어야 한다 => default :반영안됨
//    @Test
//    public void 더미유저데이터_테스트() {
//        Role adminRole = roleRepository.findById(RoleType.ADMIN.getRoleInt()).orElseGet(()->{
//            return null;

//        });
//        Role managerRole = roleRepository.findById(RoleType.MANAGER.getRoleInt()).orElseGet(()->{
//            return null;
//        });
//        Role teacherRole = roleRepository.findById(RoleType.TEACHER.getRoleInt()).orElseGet(()->{
//            return null;
//        });
//        Role kindergartenRole = roleRepository.findById(RoleType.KINDERGARTEN.getRoleInt()).orElseGet(()->{
//            return null;
//        });
//        Role kidRole = roleRepository.findById(RoleType.KID.getRoleInt()).orElseGet(()->{
//            return null;
//        });
//
//        // 지사 유저 데이터 추가
//        List<User> users = new ArrayList<User>();
//        IntStream.rangeClosed(1,20).forEach(i -> {
//            long managerId = (long) ((Math.random() * 20) + 1);
//            Manager manager = managerRepository.findById(managerId).orElseGet(()->{
//                return null;
//            });
//
//            User dummyUser = User.builder()
//                    .UserId("id_manager" + i)
//                    .UserName("name_manager"+i)
//                    .Password("$2a$10$FEmyhU76URb8YOPF75NZC.wd9tSsll3BZocOWyfazBUPPMY47IZzi")  // 비번 1
//                    .role(managerRole)
//                    .UseYn(TableStatus.Y)
//                    .manager(manager)
//                    .build();
//            users.add(dummyUser);
//        });
//        System.out.println(userRepository.saveAll(users));
//        // 강사 유저 데이터 추가
//        IntStream.rangeClosed(21,40).forEach(i -> {
//            long managerId = (long) ((Math.random() * 20) + 1);
//            Manager manager = managerRepository.findById(managerId).orElseGet(()->{
//                return null;
//            });
//
//            User dummyUser = User.builder()
//                    .UserId("id_teacher.." + i)
//                    .UserName("name_teacher"+i)
//                    .Password("$2a$10$FEmyhU76URb8YOPF75NZC.wd9tSsll3BZocOWyfazBUPPMY47IZzi")  // 비번 1
//                    .role(teacherRole)
//                    .UseYn(TableStatus.Y)
//                    .manager(manager)
//                    .build();
//            System.out.println(userRepository.save(dummyUser));
//        });
//
//        // 유치원 유저 데이터 추가
//        IntStream.rangeClosed(41,60).forEach(i -> {
//            long kindergartenId = (long) ((Math.random() * 40) + 1);
//            Kindergarten kindergarten = kindergartenRepository.findById(kindergartenId).orElseGet(()->{
//                return null;
//            });
//            long mangerId = kindergarten.getManager().getManagerId();
//            Manager manager = kindergarten.getManager();
//
//            User dummyUser = User.builder()
//                    .UserId("id_kinder.." + i)
//                    .UserName("name_kinder"+i)
//                    .Password("$2a$10$FEmyhU76URb8YOPF75NZC.wd9tSsll3BZocOWyfazBUPPMY47IZzi")  // 비번 1
//                    .role(kindergartenRole)
//                    .UseYn(TableStatus.Y)
//                    .manager(manager)
//                    .kindergarten(kindergarten)
//                    .build();
//            System.out.println(userRepository.save(dummyUser));
//        });
//
//        // 원아 유저 데이터 추가
//        IntStream.rangeClosed(81,100).forEach(i -> {
//
//            long classId = (long) ((Math.random() * 60) + 1);
//            ClassRoom classRoom = classRoomRepository.findById(classId).orElseGet(()->{
//                return null;
//            });
//
//            long  kindergartenId = classRoom.getKindergarten().getKindergartenId();
//            Kindergarten kindergarten = classRoom.getKindergarten();
//
//            long mangerId = kindergarten.getManager().getManagerId();
//            Manager manager = kindergarten.getManager();
//
//            User dummyUser = User.builder()
//                    .UserId("id_kid.." + i)
//                    .UserName("name_kid"+i)
//                    .Password("$2a$10$FEmyhU76URb8YOPF75NZC.wd9tSsll3BZocOWyfazBUPPMY47IZzi")  // 비번 1
//                    .role(kidRole)
//                    .UseYn(TableStatus.Y)
//                    .manager(manager)
//                    .kindergarten(kindergarten)
//                    .classRoom(classRoom)
//                    .build();
//            System.out.println(userRepository.save(dummyUser));
//        });
//    }
//    @Transactional
//    @Test
//    public void 더미유저데이터_테스트2() {
//
//        long classId = (long) ((Math.random() * 60) + 1);
//        ClassRoom classRoom = classRoomRepository.findById(classId).orElseGet(()->{
//            return null;
//        });
//
//        long  kindergartenId = classRoom.getKindergarten().getKindergartenId();
//        Kindergarten kindergarten = classRoom.getKindergarten();
//
//        long mangerId = kindergarten.getManager().getManagerId();
//        Manager manager = kindergarten.getManager();
//
//    }
//    @Transactional
//    @Rollback(false) // 테스트 환경에서 Transactional은 디비에 반영할건지 정해주어야 한다 => default :반영안됨
//    @Test
//    public void 스터디_메뉴() {
//        // 트레이닝 데이터
//        IntStream.rangeClosed(1,8).forEach(i -> {
//            IntStream.rangeClosed(1, 12).forEach(j -> {
//                long ParentId = i;
//                String menuName = j+"";
//                StudyMenu dummyStudyMenu = StudyMenu.builder()
//                        .ParentId(ParentId)
//                        .MenuName(menuName)
//                        .build();
//                System.out.println(dummyStudyMenu.toString());
//                System.out.println(studyMenuRepository.save(dummyStudyMenu));
//            });
//        });
//    }

//    @Transactional
//    @Rollback(false) // 테스트 환경에서 Transactional은 디비에 반영할건지 정해주어야 한다 => default :반영안됨
//    @Test
//    public void 트레이닝_메뉴() {
//        // 트레이닝 데이터
//        IntStream.rangeClosed(1,12).forEach(i -> {
//            IntStream.rangeClosed(1, 5).forEach(j -> {
//                long ParentId = i;
//                String menuName = "";
//                if (j==5){
//                    menuName = "test";
//                } else {
//                    menuName = j+"week";
//                }
//                TrainingMenu dummyTrainingMenu = TrainingMenu.builder()
//                        .ParentId(16L+ ParentId)
//                        .MenuName(menuName)
//                        .build();
//                System.out.println(trainingMenuRepository.save(dummyTrainingMenu));
//            });
//        });
//    }



}
