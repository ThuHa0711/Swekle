package com.example.Swekle.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "san_pham")
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ma_san_pham", nullable = false, unique = true)
    @NotBlank(message = "Mã sản phẩm không được để trống")
    private String maSP;

    @Column(name = "ten_san_pham")
    @NotBlank(message = "Tên sản phẩm không được để trống")
    private String tenSP;

    @Column(name = "anh")
    @NotBlank(message = "Ảnh không được để trống")
    private String anh;

    @Column(name = "mo_ta")
    @NotBlank(message = "Mô tả không được để trống")
    private String moTa;

    @Column(name = "trang_thai")
    @NotNull(message = "Trạng thái không được để trống")
    private Boolean trangThai;

    @ManyToOne
    @JoinColumn(name = "id_danh_muc", referencedColumnName = "id")
    private DanhMuc danhMuc;
}
