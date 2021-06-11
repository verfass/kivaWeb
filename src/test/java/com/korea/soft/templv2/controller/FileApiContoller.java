package com.korea.soft.templv2.controller;

import com.korea.soft.templv2.common.Util;
import com.korea.soft.templv2.domain.common.TrainingEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@SpringBootTest
public class FileApiContoller {

    @Value("${custom.uploadFileDirPath}")
    private String uploadFileDirPath;


    @Test
    public void showTestMkdirs()  {
        String relTypeCode = "board";
        String dirName = Util.getNowYearMonthDateStr();

        TrainingEnum.TYPE_A.getUpper();
        TrainingEnum.TYPE_A.getUpperSound();
        TrainingEnum.TYPE_A.getLower();
        TrainingEnum.TYPE_A.getLowerSound();


        File file = new File(uploadFileDirPath+ "/" + relTypeCode + "/" + dirName);
        boolean mkdirRs = file.mkdirs();
        System.out.println("mkdirsRs : " + mkdirRs);
        System.out.println(uploadFileDirPath);
    }



}
