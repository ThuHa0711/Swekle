package com.example.Swekle.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "khach_hang")
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ma_kh", nullable = false, unique = true)
    @NotBlank(message = "Mã khách hàng không được để trống")
    private String maKH;

    @Column(name = "ho_ten")
    @NotBlank(message = "Tên khách hàng không được để trống")
    private String hoTen;

    @Column(name = "ngay_sinh")
    @Temporal(TemporalType.DATE)
    private Date ngaySinh;

    @Column(name = "gioi_tinh")
    @NotNull(message = "Giới tính không được để trống")
    private Boolean gioiTinh;

    @Column(name = "email")
    @NotBlank(message = "Email không được để trống")
    private String email;

    @Column(name = "dia_chi")
    @NotBlank(message = "Địa chỉ không được để trống")
    private String diaChi;

    @Column(name = "sdt")
    @NotBlank(message = "SDT không được để trống")
    private String sdt;

    @Column(name = "trang_thai")
    @NotNull(message = "Trạng thái không được để trống")
    private Boolean trangThai;

    @Column(name = "mat_khau")
    private String matKhau;
}
