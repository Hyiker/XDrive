package com.hyiker.xdrive.task;

import com.hyiker.xdrive.controller.FileController;
import com.hyiker.xdrive.entity.FileStorage;
import com.hyiker.xdrive.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 由sidhch于2018/4/6创建
 */
@Component
@EnableScheduling
public class FileTasks {
    private Logger logger = LoggerFactory.getLogger(FileTasks.class);

    private static final String root = System.getProperty("user.dir");
    @Resource
    private FileService fileService;

    @Scheduled(fixedDelay = 1000 * 60 * 20)
    public void deletedUnnecessary() {
        List<String> uuids = fileService.getAllFiles().stream().map(fs -> (fs.getUuid() + "." + fs.getSuffix())).collect(Collectors.toList());

        File[] fs = new File(root + "/storage/").listFiles();
        if (fs == null || fs.length == 0) {
            return;
        }
        for (File f : fs) {
            if (!uuids.contains(f.getName()) && f.canWrite() && f.getName().length() >= 32) {
                f.delete();
            }
        }
    }
}
