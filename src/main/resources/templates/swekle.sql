CREATE database Swekle
go
use Swekle
go

CREATE TABLE san_pham (
        id INT IDENTITY(1,1) PRIMARY KEY,
        ma_san_pham VARCHAR(255) ,
        ten_san_pham NVARCHAR(255),
		anh NVARCHAR(255),
		mo_ta NVARCHAR(300),
        trang_thai BIT, -- or INT, depending on how you represent status
		id_danh_muc INT,
		FOREIGN KEY (id_danh_muc) REFERENCES danh_muc(id)
        );

        CREATE TABLE mau_sac (
        id INT IDENTITY(1,1) PRIMARY KEY,
        ma_mau VARCHAR(255),
        ten_mau NVARCHAR(255),
        trang_thai BIT, -- or INT, based on your status representation
        );

        CREATE TABLE size (
        id INT IDENTITY(1,1) PRIMARY KEY,
        ma_size VARCHAR(255),
        ten_size NVARCHAR(255),
        trang_thai BIT, -- or INT, based on your status representation
        );

        CREATE TABLE danh_muc (
        id INT IDENTITY(1,1) PRIMARY KEY,
        ma_danh_muc VARCHAR(255),
        ten_danh_muc NVARCHAR(255),
        trang_thai BIT, -- Adjust based on how you plan to represent the status
        );

		CREATE TABLE chat_lieu (
        id INT IDENTITY(1,1) PRIMARY KEY,
        ma_chat_lieu VARCHAR(255),
        ten_chat_lieu NVARCHAR(255),
        trang_thai BIT, -- Adjust based on how you plan to represent the status
        );

		CREATE TABLE chuc_vu (
        id INT IDENTITY(1,1) PRIMARY KEY,
        ma_chuc_vu VARCHAR(255),
        ten_chuc_vu NVARCHAR(255),
        trang_thai BIT, -- Adjust based on how you plan to represent the status
        );

        CREATE TABLE khach_hang (
        id INT IDENTITY(1,1) PRIMARY KEY,
		ma_kh NVARCHAR(255),
        ho_ten NVARCHAR(255),
		ngay_sinh DATE,
		gioi_tinh BIT,
		email NVARCHAR(255),
        dia_chi NVARCHAR(255),
        sdt VARCHAR(20),
        trang_thai BIT, 
		mat_khau VARCHAR(20),
        );

        CREATE TABLE ctsp (
        id INT IDENTITY(1,1) PRIMARY KEY,
        id_sp INT NULL,
        id_mau_sac INT NULL,
        id_chat_lieu INT NULL,
        id_size INT NULL,
        gia_ban DECIMAL(18, 2),
        so_luong_ton INT,
        trang_thai BIT, -- Adjust based on your representation of status
        FOREIGN KEY (id_sp) REFERENCES san_pham(id),
        FOREIGN KEY (id_mau_sac) REFERENCES mau_sac(id),
        FOREIGN KEY (id_size) REFERENCES size(id),
        FOREIGN KEY (id_chat_lieu) REFERENCES chat_lieu(id),
        );

		CREATE TABLE nhan_vien(
		id INT IDENTITY(1,1) PRIMARY KEY,
		ma_nv NVARCHAR(255),
        ho_ten_nhan_vien NVARCHAR(255),
		ngay_sinh DATE,
		gioi_tinh BIT,
		anh NVARCHAR(255),
		email NVARCHAR(255),
        dia_chi NVARCHAR(255),
        sdt VARCHAR(20),
        trang_thai BIT, -- Adjust based on how you plan to represent the status
		mat_khau VARCHAR(20),
		id_chuc_vu INT,
        FOREIGN KEY (id_chuc_vu) REFERENCES chuc_vu(id)
		);

        CREATE TABLE hoa_don (
        id INT IDENTITY(1,1) PRIMARY KEY,
		ma_hoa_don VARCHAR(255),
        id_khach_hang INT,
        trang_thai BIT, -- Adjust based on how you represent the status
        ngay_tao DATE,
        dia_chi NVARCHAR(255),
		id_nhan_vien INT,
        FOREIGN KEY (id_khach_hang) REFERENCES khach_hang(id),
		FOREIGN KEY (id_nhan_vien) REFERENCES nhan_vien(id),
        );


        CREATE TABLE hdct (
        id INT IDENTITY(1,1) PRIMARY KEY,
        id_hoa_don INT,
        id_ctsp INT,
		gia_ban DECIMAL(18, 2),
        so_luong_mua INT,
		tong_tien DECIMAL(18, 2),
        trang_thai BIT, -- Adjust based on how you represent the status
        FOREIGN KEY (id_hoa_don) REFERENCES hoa_don(id),
        FOREIGN KEY (id_ctsp) REFERENCES ctsp(id)
        );

       INSERT INTO danh_muc (ma_danh_muc, ten_danh_muc, trang_thai) VALUES
       ('DM001', N'Áo thun', 1),
       ('DM002', N'Áo khoác', 1),
       ('DM003', N'Quần dài', 1),
       ('DM004', N'Quần đùi', 1);

	   INSERT INTO chuc_vu (ma_chuc_vu, ten_chuc_vu, trang_thai) VALUES
       ('CV001', N'Quản lý', 1),
       ('CV002', N'Nhân viên bán hàng', 1),
       ('CV003', N'Nhân viên thu ngân', 1);

       INSERT INTO san_pham (ma_san_pham, ten_san_pham, anh, mo_ta, trang_thai, id_danh_muc) VALUES
       ('SP001', N'Quần short kaki cạp chun', 'quan_short_kaki.jpg', N'Được thiết kế phía trước túi hộp tạo điểm nhấn độc và lạ mắt', 1, 4),
       ('SP002', N'Quần ống suông dài nữ nhung tăm', 'quan_ong_suong_nhung_tam.jpg', N'Dáng quần rộng che khuyết điểm chân to cong',  1, 3), 
       ('SP003', N'Áo thun in vẩy sơn', 'ao_thun_in_vay_son.jpg', N'Chất áo dày dặn, không xù', 1, 1),
       ('SP004', N'Áo khoác gió có mũ lót lưới', 'ao_khoac_gio_co_mu_lot_luoi.jpg', N'Chất liệu dày dặn và được lót thêm 1 lớp lót luới bên trong', 1, 2);

       INSERT INTO mau_sac (ma_mau, ten_mau, trang_thai) VALUES
       ('M001', N'Đen', 1),
       ('M002', N'Trắng', 1),
       ('M003', N'Xanh dương', 1),
       ('M004', N'Đỏ', 1),
       ('M005', N'Vàng', 1),
       ('M006', N'Hồng', 1),
       ('M007', N'Nâu', 1),
       ('M008', N'Xanh lá', 1);

       INSERT INTO size (ma_size, ten_size, trang_thai) VALUES
       ('S001', 'S', 1),
       ('S002', 'M', 1),
       ('S003', 'L', 1),
       ('S004', 'XL', 1);

	   INSERT INTO chat_lieu (ma_chat_lieu, ten_chat_lieu, trang_thai) VALUES
       ('CL01', N'Kaki', 1),
       ('CL02', N'Cotton', 1),
       ('CL03', N'Đũi', 1),
       ('CL04', N'Nhung tăm', 1),
       ('CL05', N'Dù', 1);

       INSERT INTO ctsp (id_sp, id_mau_sac, id_chat_lieu, id_size, gia_ban, so_luong_ton, trang_thai) VALUES
       (2, 2, 3, 4, 130000, 50, 1),
       (3, 3, 2, 1, 100000, 70, 1),
       (3, 6, 2, 2, 100000, 70, 1),
       (4, 2, 5, 3, 270000, 200, 1);

INSERT INTO nhan_vien (ma_nv, ho_ten_nhan_vien, ngay_sinh, gioi_tinh, anh, email, dia_chi, sdt, trang_thai, mat_khau, id_chuc_vu)
VALUES 
('NV01', N'Nguyễn Thị A', '1999-07-08', 0, 'nv1.jpg', 'a@swekle.com', N'Hà Nội', '0123456789', 1, '123456', 1),
('NV02', N'Trần Minh B', '2000-04-07', 1, 'nv2.jpg', 'b@swekle.com', N'TP HCM', '0987654321', 1, '654321', 2),
('NV03', N'Lê Quang C', '1997-07-16', 1, 'nv3.jpg', 'c@swekle.com', N'Đà Nẵng', '0912345678', 1, 'cccccc', 3),
('NV04', N'Nguyễn Thị Mai D', '2001-09-08', 0, 'nv4.jpg', 'dd@swekle.com', N'Hà Nội', '0123456789', 1, 'dddddd', 2),
('NV05', N'Trần Quốc Quang G', '1999-10-08', 1, 'nv5.jpg', 'gg@swekle.com', N'TP HCM', '0987654321', 1, 'gggggg', 2),
('NV06', N'Lê Quang Văn H', '1996-02-08', 1, 'nv6.jpg', 'hh@swekle.com', N'Đà Nẵng', '0912345678', 1, 'hhhhhh', 3);


-- Thêm dữ liệu cho bảng hoa_don (Hóa đơn)
INSERT INTO hoa_don (ma_hoa_don, id_khach_hang, trang_thai, ngay_tao, dia_chi, id_nhan_vien)
VALUES 
('HD1', 1, 1, GETDATE(), N'Hà Nội', 1),
('HD2', 1, 1, GETDATE(), N'TP HCM', 2);

-- Thêm dữ liệu cho bảng hdct (Chi tiết hóa đơn)
INSERT INTO hdct (id_hoa_don, id_ctsp, gia_ban, so_luong_mua, tong_tien, trang_thai)
VALUES 
(1, 3, 100000, 2, 200000, 1),
(2, 4, 120000, 1, 120000, 1);


-- Thêm dữ liệu cho bảng khach_hang (Khách hàng)
INSERT INTO khach_hang (ma_kh, ho_ten, ngay_sinh, gioi_tinh, email, dia_chi, sdt, trang_thai, mat_khau)
VALUES
('KH01', N'Nguyễn Văn D', '1999-10-08', 1, 'd@gmail.com', N'Hà Nội', '0945678912', 1, 'vand123'),
('KH02', N'Lê Thị E', '1999-11-08', 0, 'e@gmail.com', N'TP HCM', '0976543210', 1, 'thienguyen'),
('KH03', N'Trần Quang F', '1999-12-08', 1, 'f@gmail.com', N'Đà Nẵng', '0901234567', 1, 'tttttt');

Select sp.id, sp.ma_san_pham, sp.ten_san_pham, sp.anh, sp.mo_ta, sp.trang_thai, sp.ngay_tao, sp.ngay_sua, dm.ten_danh_muc
              from san_pham sp inner join danh_muc dm 
              on sp.id_danh_muc = dm.id

SELECT nv.id, nv.ma_nv, nv.ho_ten_nhan_vien, nv.gioi_tinh, nv.dia_chi, nv.sdt, nv.trang_thai, nv.ngay_tao, nv.ngay_sua, nv.mat_khau, nv.id_chuc_vu, cv.ten_chuc_vu
FROM nhan_vien nv inner join chuc_vu cv
on nv.id_chuc_vu = cv.id

Select hd.id, hd.ma_hoa_don, kh.ho_ten, hd.trang_thai, hd.ngay_tao, hd.dia_chi, nv.ho_ten_nhan_vien
            from hoa_don hd inner join khach_hang kh on hd.id_khach_hang = kh.id
            inner join nhan_vien nv on hd.id_nhan_vien = nv.id

Select hdct.id, hd.ma_hoa_don, ctsp.id, ctsp.id_sp, ctsp.id_chat_lieu, ctsp.id_mau_sac, ctsp.id_size, hdct.gia_ban, hdct.so_luong_mua, hdct.tong_tien, hdct.trang_thai
from hdct inner join ctsp on hdct.id_ctsp = ctsp.id
inner join hoa_don hd on hdct.id_hoa_don = hd.id

Select hdct.id, hd.ma_hoa_don, hdct.id_ctsp, ctsp.id_sp, ctsp.id_chat_lieu, ctsp.id_mau_sac, ctsp.id_size, hdct.gia_ban, hdct.so_luong_mua, hdct.gia_ban * hdct.so_luong_mua as tong_tien, hdct.trang_thai
            from hdct inner join ctsp on hdct.id_ctsp = ctsp.id
            inner join hoa_don hd on hdct.id_hoa_don = hd.id