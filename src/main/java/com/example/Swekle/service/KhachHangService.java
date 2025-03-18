package com.example.Swekle.service;

import com.example.Swekle.model.KhachHang;
import org.springframework.data.domain.Page;

import java.util.List;

public interface KhachHangService {
    Page<KhachHang> getListKH(int page, int size);

    void addKH(KhachHang khachHang);

    KhachHang viewUpdateKH(Integer id);

    void updateKH(KhachHang khachHang);

    void deleteKH(Integer id);
}
