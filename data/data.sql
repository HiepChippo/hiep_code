create database QLLuongSanPham
go
use QLLuongSanPham
go
create table ChucVu(
	idChucVu varchar(10) primary key not null,
	tenChucVu nvarchar(50),
	heSoLuong float
)
create table PhongBan(
	idPhongBan varchar(10) primary key not null,
	tenPhongBan nvarchar(50)
)
create table TaiKhoan(
	tenTaiKhoan varchar(10) primary key not null,
	matKhau varchar(50),
	loaiTaiKhoan nvarchar(30)
)
create table CaLam(
	idCaLam int identity primary key not null,
	tenCaLam nvarchar(50),
	thoiGianBatDau time(7),
	thoiGianKetThuc time(7),
	heSoLuong float
)
create table PhanXuong(
	idPhanXuong varchar(10) primary key not null,
	tenPhanXuong nvarchar(50)
)
create table NhanVien(
	idNhanVien varchar(10) primary key not null,
	hoTen nvarchar(50),
	phai bit,
	ngaySinh date,
	ngayBatDauCongTac date,
	ngayKetThucCongTac date,
	email varchar(50),
	soDienThoai varchar(10),
	idChucVu varchar(10),
	heSoBaoHiemXaHoi float,
	luongCoBan money,
	tenTaiKhoan varchar(10),
	idPhongBan varchar(10),
	phuCap float
)
alter table NhanVien add constraint FK_tenTaiKhoan foreign key (tenTaiKhoan) references TaiKhoan(tenTaiKhoan) on delete cascade
alter table NhanVien add constraint FK_idPhongBan foreign key (idPhongBan) references PhongBan(idPhongBan) on delete cascade
alter table NhanVien add constraint FK_idChucVu foreign key (idChucVu) references ChucVu(idChucVu) on delete cascade
create table CongNhan(
	idCongNhan varchar(10) primary key not null,
	heTen nvarchar(50),
	phai bit,
	ngaySinh date,
	ngayBatDauCongTac date,
	ngayKetThucCongTac date,
	idPhanXuong varchar(10),
	email varchar(50),
	soDienThoai varchar(10),
	idCaLam int,
	tayNghe nvarchar(20),
	tenTaiKhoan varchar(10)
)
alter table CongNhan add constraint FK_tenTaiKhoan_CongNhan foreign key (tenTaiKhoan) references TaiKhoan(tenTaiKhoan) on delete cascade
alter table CongNhan add constraint FK_CaLam_CongNhan foreign key (idCaLam) references CaLam(idCaLam) on delete cascade
alter table CongNhan add constraint FK_PhanXuong_CongNhan foreign key (idPhanXuong) references PhanXuong(idPhanXuong) on delete cascade
create table HopDongSanPham(
	idHopDong varchar(10) primary key not null,
	tenHopDong nvarchar(50),
	ngayBatDau date,
	ngayKetThuc date,
	idNguoiQuanLy varchar(10),
	ghiChu nvarchar(max)
)
alter table HopDongSanPham add constraint FK_HopDongSanPham_NhanVien foreign key (idNguoiQuanLy) references NhanVien(idNhanVien)
create table SanPham(
	idSanPham varchar(10) primary key not null,
	tenSanPham nvarchar(50),
	donGia money,
	soLuong int,
	idHopDongSanPham varchar(10)
)
alter table SanPham add constraint FK_HopDongSanPham_SanPham foreign key (idHopDongSanPham) references HopDongSanPham(idHopDong) on delete cascade
create table CongDoanSP(
	idCongDoan varchar(10) primary key not null,
	tenCongDoan nvarchar(50),
	soLuongSanPham int,
	luongCongDoan money,
	soLuongCongNhan int,
	idSanPham varchar(10),
	thuTuUuTien varchar(3)
)
alter table CongDoanSP add constraint FK_CongDoanSP_SanPham foreign key (idSanPham) references SanPham(idSanPham)
create table CongDoanPhanCong(
	idCongDoan varchar(10) not null,
	idCongNhan varchar(10) not null,
	soLuongSPDuocGiao int
	primary key (idCongDoan, idCongNhan)
)
alter table CongDoanPhanCong add constraint FK_CongDoanPhanCong_CongDoanSanPham foreign key (idCongDoan) references CongDoanSP(idCongDoan)
alter table CongDoanPhanCong add constraint FK_CongDoanPhanCong_CongNhan foreign key (idCongNhan) references CongNhan(idCongNhan) on delete cascade
create table BangChamCongCongNhan(
	idNgayChamCong varchar(10) primary key not null,
	ngayChamCong date,
	soLuongHoanThanh int,
	idCongDoan varchar(10),
	idCongNhan varchar(10),
	heSoNgayLam float
)
alter table BangChamCongCongNhan add constraint FK_BangChamCongCongNhan_CongDoanPhanCong foreign key (idCongDoan,idCongNhan) references CongDoanPhanCong(idCongDoan,idCongNhan) on delete cascade
create table BangLuongCongNhan(
	idLuongCN varchar(10) primary key not null,
	ngayTinhLuong date,
	idCongNhan varchar(10),
	tongLuong money
)
alter table BangLuongCongNhan add constraint FK_BangLuongCongNhan_CongNhan foreign key (idCongNhan) references CongNhan(idCongNhan)
create table BangChamCongNhanVienHC(
	idChamCong varchar(10) primary key not null,
	ngayChamCong date,
	trangThai nvarchar(10),
	idNhanVien varchar(10)
)
alter table BangChamCongNhanVienHC add constraint FK_BangChamCongNhanVienHC_NhanVien foreign key (idNhanVien) references NhanVien(idNhanVien)
create table BangLuongNhanVien(
	idLuongNVHC varchar(10),
	ngayTinhLuong date,
	idNhanVien varchar(10),
	thueLaoDong money,
	tienBaoHiemXaHoi money,
	tongLuong money
)
alter table BangLuongNhanVien add constraint FK_BangLuongNhanVien_NhanVien foreign key (idNhanVien) references NhanVien(idNhanVien)

insert into TaiKhoan values('NV0001', '1111', 'admin'),
							('NV0002', '1111', 'tpkd')