package com.hyiker.xdrive.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.File;
import java.util.Date;

/**
 * 由sidhch于2018/4/4创建
 */
@Entity
@Table(name = "file_storage")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "file"})
public class FileStorage {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "uuid", unique = true, nullable = false, length = 32)
    private String uuid;

    @Column(name = "original_name", nullable = false)
    private String original_name;

    @Column(name = "filename", nullable = false)
    private String filename;

    @Column(name = "suffix", nullable = false)
    private String suffix;


    @JsonIgnore
    @Transient
    private File file;

    @Column(name = "update_time", nullable = false)
    private Date update_time;

    @Column(name = "is_deleted", nullable = false)
    private Boolean is_deleted;

    public FileStorage() {
    }

    public FileStorage(String uuid, String original_name, String filename, String suffix, File file, Date update_time, Boolean is_deleted) {
        this.uuid = uuid;
        this.original_name = original_name;
        this.filename = filename;
        this.suffix = suffix;
        this.file = file;
        this.update_time = update_time;
        this.is_deleted = is_deleted;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getOriginal_name() {
        return original_name;
    }

    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Boolean getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(Boolean is_deleted) {
        this.is_deleted = is_deleted;
    }
}
