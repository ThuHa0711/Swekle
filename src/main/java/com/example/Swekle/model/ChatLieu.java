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
@Table(name = "chat_lieu")
public class ChatLieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ma_chat_lieu", nullable = false, unique = true)
    @NotBlank(message = "Mã chất liệu không được để trống")
    private String maCL;

    @Column(name = "ten_chat_lieu")
    @NotBlank(message = "Tên chất liệu không được để trống")
    private String tenCL;

    @Column(name = "trang_thai")
    @NotNull(message = "Trạng thái không được để trống")
    private Boolean trangThai;


}
