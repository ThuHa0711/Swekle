package com.example.Swekle.repository;

import com.example.Swekle.model.HoaDonChiTiet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HDCTRepo extends JpaRepository<HoaDonChiTiet, Integer> {
    @Query(value = "Select hdct.id, hdct.id_hoa_don, hd.ma_hoa_don, hdct.id_ctsp, ctsp.id, ctsp.id_sp, ctsp.id_chat_lieu, ctsp.id_mau_sac, ctsp.id_size, hdct.gia_ban, hdct.so_luong_mua, hdct.tong_tien, hdct.trang_thai\n" +
            "from hdct inner join ctsp on hdct.id_ctsp = ctsp.id\n" +
            "inner join hoa_don hd on hdct.id_hoa_don = hd.id", nativeQuery = true)
    Page<HoaDonChiTiet> getHoaDonChiTietWithPagination(Pageable pageable);



}
