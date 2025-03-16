package com.example.Swekle.service;

import com.example.Swekle.model.KhachHang;

import java.util.List;

public interface KhachHangService {
    List<KhachHang> getListKH();

    void addKH(KhachHang khachHang);

    KhachHang viewUpdateKH(Integer id);

    void updateKH(KhachHang khachHang);

    void deleteKH(Integer id);
}
