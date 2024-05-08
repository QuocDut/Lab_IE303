create database QLSV;
use QLSV;


create table SINHVIEN
(	
MASV char(10) primary key,
HOTEN nvarchar(40),
NGSINH char(10),
DIEMTOAN float,
DIEMLY float,
DIEMHOA float,
DIEMTB float
);

insert into SINHVIEN values('09520001', N'Thạch Sanh', N'01/01/1995', 6,4.5,7,5.8);
insert into SINHVIEN values('09520002', N'Lý Thông', N'02/03/1995', 10,10,10,10.0);
insert into SINHVIEN values('09520003', N'Bạch Tuyết', N'04/06/1996', 5,7,8,6.7);
insert into SINHVIEN values('09520004', N'Chí Phèo', N'08/04/1995', 9.5,10,9,9.5);
insert into SINHVIEN values('09520005', N'A Phủ', N'09/09/1995', 7,7,7,7.0);
insert into SINHVIEN values('09520006', N'Xuân Tóc Đỏ', N'09/10/1995', 8,8,8,8.0);