package com.hyiker.xdrive.entity;

import java.io.File;
import java.net.URI;

/**
 * 由sidhch于2018/4/6创建
 */
public class MyFile extends File {
    private String realName;
    /**
     * fileType:
     * 1:图片
     * 2:zip
     */
    private int fileType;

    public MyFile(String pathname) {
        super(pathname);
    }

    public MyFile(String pathname, int fileType) {
        super(pathname);
        this.fileType = fileType;
    }

    public MyFile(String parent, String child) {
        super(parent, child);
    }

    public MyFile(File parent, String child) {
        super(parent, child);
    }

    public MyFile(URI uri) {
        super(uri);
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public int getFileType() {
        return fileType;
    }

    public void setFileType(int fileType) {
        this.fileType = fileType;
    }
}
