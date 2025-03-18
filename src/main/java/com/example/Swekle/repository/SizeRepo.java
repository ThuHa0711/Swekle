package com.example.Swekle.repository;

import com.example.Swekle.model.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SizeRepo extends JpaRepository<Size, Integer> {
    @Query(value = "SELECT [id]\n" +
            "      ,[ma_size]\n" +
            "      ,[ten_size]\n" +
            "      ,[trang_thai]\n" +
            "  FROM [dbo].[size]", nativeQuery = true)
    List<Size> getSizeInterface();

    @Query("SELECT m FROM Size m WHERE " +
            "LOWER(m.maSize) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
            "LOWER(m.tenSize) LIKE LOWER(CONCAT('%', :search, '%'))")
    List<Size> findBySearch(@Param("search") String search);
}
