package com.example.Swekle.service;

import com.example.Swekle.model.NhanVien;

import java.util.List;

public interface NhanVienService {
    List<NhanVien> getListNV();

    void addNV(NhanVien nhanVien);

    NhanVien viewUpdateNV(Integer id);

    void updateNV(NhanVien nhanVien);

    void deleteNV(Integer id);
}
