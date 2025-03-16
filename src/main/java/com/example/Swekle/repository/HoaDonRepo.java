package com.example.Swekle.repository;

import com.example.Swekle.model.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HoaDonRepo extends JpaRepository<HoaDon, Integer> {
    @Query(value = "Select hd.id, hd.ma_hoa_don, hd.id_khach_hang, kh.ho_ten, hd.trang_thai, hd.ngay_tao, hd.dia_chi, hd.id_nhan_vien, nv.ho_ten_nhan_vien" +
            " from hoa_don hd inner join khach_hang kh on hd.id_khach_hang = kh.id" +
            " inner join nhan_vien nv on hd.id_nhan_vien = nv.id", nativeQuery = true)
    List<HoaDon> getHoaDonInterface();

}
