package com.example.Swekle.repository;

import com.example.Swekle.model.DanhMuc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DanhMucRepo extends JpaRepository<DanhMuc, Integer> {
    @Query(value = "SELECT [id]\n" +
            "      ,[ma_danh_muc]\n" +
            "      ,[ten_danh_muc]\n" +
            "      ,[trang_thai]\n" +
            "  FROM [dbo].[danh_muc]", nativeQuery = true)
    Page<DanhMuc> getDanhMucWithPagination(Pageable pageable);

    @Query("SELECT m FROM DanhMuc m WHERE " +
            "LOWER(m.maDanhMuc) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
            "LOWER(m.tenDanhMuc) LIKE LOWER(CONCAT('%', :search, '%'))")
    Page<DanhMuc> findBySearch(@Param("search") String search, Pageable pageable);
}
