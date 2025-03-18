package com.example.Swekle.service;

import com.example.Swekle.model.HoaDonChiTiet;
import org.springframework.data.domain.Page;

import java.util.List;

public interface HDCTService {
    Page<HoaDonChiTiet> getListHDCT(int page, int size);


}
