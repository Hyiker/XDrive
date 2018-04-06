package com.hyiker.xdrive;

import com.hyiker.xdrive.entity.TestBean;
import com.hyiker.xdrive.repository.TestRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@SpringBootApplication

public class XDriveApplication {

    public static void main(String[] args) {
        SpringApplication.run(XDriveApplication.class, args);
    }


}
