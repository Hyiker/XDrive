package com.hyiker.xdrive.controller;

import com.hyiker.xdrive.entity.MyFile;
import com.hyiker.xdrive.entity.WebResult;
import com.hyiker.xdrive.service.FileService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 由sidhch于2018/3/31创建
 */
@RestController
@RequestMapping(value = "/file")
public class FileController {
    private Logger logger = LoggerFactory.getLogger(FileController.class);

    @Resource
    private FileService fileService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public WebResult addFile(@RequestParam("file") MultipartFile[] files) {
        WebResult result;
        if (fileService.saveFiles(files)) {
            result = new WebResult(true, "成功保存");
        } else {
            result = new WebResult(false, "保存失败");
        }
        return result;
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public void getFiles(@RequestBody Map<String, List<Long>> map, HttpServletResponse response) throws IOException {
        MyFile file = fileService.getFiles(map.get("ids"));
        response.addHeader("Content-disposition", "attachment;filename=" + file.getRealName() + "");
        response.setContentType("application/octet-stream");

        // Copy the stream to the response's output stream.
        IOUtils.copy(new FileInputStream(file), response.getOutputStream());
        response.flushBuffer();
        file.delete();

    }
}
