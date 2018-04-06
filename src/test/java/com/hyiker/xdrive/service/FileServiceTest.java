package com.hyiker.xdrive.service;

import com.hyiker.xdrive.XDriveApplication;
import com.hyiker.xdrive.repository.FileRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * 由sidhch于2018/4/6创建
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = XDriveApplication.class)
public class FileServiceTest {
    private static final Logger logger = LoggerFactory.getLogger(FileServiceTest.class);

    @Resource
    private FileService fileService;
    @Resource
    private FileRepository fileRepository;


    @Test
    public void getFileInPutStream() {
        logger.info("obj =======> {}", fileRepository.findAllById(Arrays.asList(22L)).size());
    }

    @Test
    public void getFiles() {
        fileService.getFiles(Arrays.asList(22L, 23L, 24L));
    }
}