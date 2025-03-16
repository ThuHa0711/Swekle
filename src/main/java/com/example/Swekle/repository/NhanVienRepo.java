package com.example.Swekle.repository;

import com.example.Swekle.model.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhanVienRepo extends JpaRepository<NhanVien, Integer> {
    @Query(value = "SELECT nv.id, nv.ma_nv, nv.ho_ten_nhan_vien, nv.ngay_sinh, nv.gioi_tinh, nv.anh, nv.email, nv.dia_chi, nv.sdt, nv.trang_thai, nv.mat_khau, nv.id_chuc_vu, cv.ten_chuc_vu\n" +
            "            FROM nhan_vien nv inner join chuc_vu cv\n" +
            "            on nv.id_chuc_vu = cv.id", nativeQuery = true)
    List<NhanVien> getNhanVienInterface();
}
