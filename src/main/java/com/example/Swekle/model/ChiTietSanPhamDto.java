package com.example.Swekle.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class ChiTietSanPhamDto {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "ten_san_pham")
    private String tenSanPham;

    @Column(name = "ten_danh_muc")
    private String tenDanhMuc;

    @Column(name = "gia_ban")
    private Double giaBan;

    @Column(name = "ten_mau")
    private String tenMau;

    @Column(name = "ten_size")
    private String tenSize;
}
