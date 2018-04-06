package com.hyiker.xdrive.controller;

import com.hyiker.xdrive.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * 由sidhch于2018/3/31创建
 */
@Controller
public class PageController {
    private Logger logger = LoggerFactory.getLogger(FileController.class);
    @Resource
    private FileService fileService;

    @RequestMapping({"/", "/index"})
    public String index(Model model) {
        model.addAttribute("files", fileService.getAllFiles());
        return "indexPage";
    }

}
