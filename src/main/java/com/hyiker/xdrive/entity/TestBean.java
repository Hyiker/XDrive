package com.hyiker.xdrive.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * 由sidhch于2018/3/31创建
 */
@Entity
@Table(name = "test_table")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TestBean {

    @Id
    @GeneratedValue()
    private Long id;
    @Column(name = "text", length = 140)
    private String text;
    @Column(name = "is_deleted")
    private Boolean is_deleted;

    /**
     * default constructor,to prevent the InstantiationException
     */
    public TestBean() {
    }

    public TestBean(String text) {
        this.text = text;
        this.is_deleted = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(Boolean is_deleted) {
        this.is_deleted = is_deleted;
    }

}
