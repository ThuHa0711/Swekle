package com.example.Swekle.service;

import com.example.Swekle.model.HoaDon;
import org.springframework.data.domain.Page;

import java.util.List;

public interface HoaDonService {
    Page<HoaDon> getListHD(int page, int size);

    Page<HoaDon> searchHD(String search, int page, int size);
}
