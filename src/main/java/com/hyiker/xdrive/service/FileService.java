package com.hyiker.xdrive.service;

import com.hyiker.xdrive.entity.FileStorage;
import com.hyiker.xdrive.entity.MyFile;
import com.hyiker.xdrive.repository.FileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.*;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 由sidhch于2018/4/4创建
 */
@Service
public class FileService {
    private static final Logger logger = LoggerFactory.getLogger(FileService.class);
    @Resource
    private FileRepository repository;

    private static final String root = System.getProperty("user.dir");

    public boolean saveFiles(MultipartFile[] files) {
        for (MultipartFile file : files) {
            try {
                FileStorage fs = createNewFile(file);
                file.transferTo(fs.getFile());
                repository.save(fs);
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public List<FileStorage> getAllFiles() {
        return repository.getUndeleted();
    }

    private FileStorage createNewFile(MultipartFile mf) throws IOException {
        String[] ofn_split = mf.getOriginalFilename().split("\\.");
        String suffix = ofn_split[ofn_split.length - 1],
                uuid = UUID.randomUUID().toString().replaceAll("-", ""),
                filename = root + "/storage/";
        File f = new File(filename);
        if (!f.exists()) {
            f.mkdirs();
        }
        f = new File(filename + uuid + "." + suffix);
        f.createNewFile();
        return new FileStorage(uuid, mf.getOriginalFilename(), mf.getOriginalFilename().replace("." + ofn_split[ofn_split.length - 1], ""), ofn_split[ofn_split.length - 1], f, new Date(), false);
    }

    /**
     * 如果是单个文件则直接返回文件本身
     * 如果是多个文件则返回zip
     *
     * @param ids 所需要的id
     * @return 返回文件的输出流
     */
    public MyFile getFiles(List<Long> ids) {
        List<FileStorage> fileStorages = repository.findAllById(ids);
        if (fileStorages.size() == 1) {
            FileStorage fs = fileStorages.get(0);
            MyFile mf = new MyFile(root + "/storage/" + fs.getUuid() + "." + fs.getSuffix(), 1);
            mf.setRealName(fs.getOriginal_name());
            return mf;
        }
        MyFile file = null;
        String file_path = root + "/storage/temp/" + UUID.randomUUID().toString() + ".zip";
        try {
            byte[] buffer = new byte[1024];
            file = new MyFile(file_path);

            file.createNewFile();
            ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(file));

            for (FileStorage fs :
                    fileStorages) {
                String fn = root + "/storage/" + fs.getUuid() + "." + fs.getSuffix();
                FileInputStream fis = new FileInputStream(fn);
                zos.putNextEntry(new ZipEntry(fs.getOriginal_name()));
                int len;
                // 读入需要下载的文件的内容，打包到zip文件
                while ((len = fis.read(buffer)) > 0) {
                    zos.write(buffer, 0, len);
                }
                zos.closeEntry();
                fis.close();
            }
            zos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        MyFile mf = new MyFile(file_path, 2);
        mf.setRealName("Files.zip");
        return mf;
    }
}
