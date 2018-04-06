package com.hyiker.xdrive.repository;

import com.hyiker.xdrive.entity.FileStorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 由sidhch于2018/4/5创建
 */
public interface FileRepository extends JpaRepository<FileStorage, Long> {
    @Query(value = "SELECT * FROM file_storage WHERE is_deleted = FALSE ", nativeQuery = true)
    List<FileStorage> getUndeleted();

    @Override
    @Query(value = "SELECT * FROM file_storage WHERE is_deleted = FALSE AND id IN ?1", nativeQuery = true)
    List<FileStorage> findAllById(Iterable<Long> longs);
}
