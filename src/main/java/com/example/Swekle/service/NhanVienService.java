package com.example.Swekle.service;

import com.example.Swekle.model.NhanVien;
import org.springframework.data.domain.Page;

import java.util.List;

public interface NhanVienService {
    Page<NhanVien> getListNV(int page, int size);

    void addNV(NhanVien nhanVien);

    NhanVien viewUpdateNV(Integer id);

    void updateNV(NhanVien nhanVien);

    void deleteNV(Integer id);
}
