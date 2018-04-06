package com.hyiker.xdrive.repository;

import com.hyiker.xdrive.entity.TestBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 由sidhch于2018/3/31创建
 */
@Repository
public interface TestRepository extends JpaRepository<TestBean, Long> {
    @Query(value = "SELECT * FROM test_table WHERE is_deleted=?1", nativeQuery = true)
    public List<TestBean> getSpecific(Boolean is_deleted);
}
