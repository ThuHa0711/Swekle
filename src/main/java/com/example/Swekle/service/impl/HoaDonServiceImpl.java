package com.example.Swekle.service.impl;

import com.example.Swekle.model.HoaDon;
import com.example.Swekle.repository.HoaDonRepo;
import com.example.Swekle.service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HoaDonServiceImpl implements HoaDonService {
    @Autowired
    HoaDonRepo hoaDonRepo;

    @Override
    public Page<HoaDon> getListHD(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return hoaDonRepo.getHoaDonWithPagination(pageable);
    }

//    @Override
//    public Page<HoaDon> searchHD(String search, int page, int size) {
//        Pageable pageable = PageRequest.of(page, size);
//        return hoaDonRepo.searchHoaDon(search, pageable);
//    }

    @Override
    public Page<HoaDon> searchHD(String search, int page, int size) {
        // Kiểm tra nếu từ khóa tìm kiếm rỗng, để tránh trường hợp tìm kiếm không hợp lệ
        if (search == null || search.trim().isEmpty()) {
            return hoaDonRepo.findAll(PageRequest.of(page, size));  // Nếu không có từ khóa tìm kiếm, trả về tất cả hóa đơn
        }

        // Sử dụng PageRequest để phân trang và truyền search vào phương thức repository
        Pageable pageable = PageRequest.of(page, size);
        return hoaDonRepo.searchHoaDon(search, pageable);
    }
}
