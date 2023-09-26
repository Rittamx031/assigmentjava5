CREATE DATABASE FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041;
USE [FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041]
DROP DATABASE FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041
GO
/****** Object:  Table [dbo].[chi_tiet_sp]    Script Date: 29/03/2023 12:34:48 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[chi_tiet_sp](
	[id] [uniqueidentifier] NOT NULL,
	[id_sp] [uniqueidentifier] NULL,
	[id_nsx] [uniqueidentifier] NULL,
	[id_mau_sac] [uniqueidentifier] NULL,
	[id_dong_sp] [uniqueidentifier] NULL,
	[nam_bh] [int] NULL,
	[mo_ta] [nvarchar](50) NULL,
	[so_luong_ton] [int] NULL,
	[gia_nhap] [decimal](20, 0) NULL,
	[gia_ban] [decimal](20, 0) NULL,
[image] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[chuc_vu]    Script Date: 29/03/2023 12:34:48 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[chuc_vu](
	[id] [uniqueidentifier] NOT NULL,
	[ma] [varchar](20) NULL,
	[ten] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[cua_hang]    Script Date: 29/03/2023 12:34:48 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[cua_hang](
	[id] [uniqueidentifier] NOT NULL,
	[ma] [varchar](20) NULL,
	[ten] [nvarchar](50) NULL,
	[dia_chi] [nvarchar](100) NULL,
	[thanh_pho] [nvarchar](50) NULL,
	[quoc_gia] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[dong_sp]    Script Date: 29/03/2023 12:34:48 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[dong_sp](
	[id] [uniqueidentifier] NOT NULL,
	[ma] [varchar](20) NULL,
	[ten] [nvarchar](30) NULL,
		[ImageName] [nvarchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[gio_hang]    Script Date: 29/03/2023 12:34:48 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[gio_hang](
	[id] [uniqueidentifier] NOT NULL,
	[id_kh] [uniqueidentifier] NULL,
	[id_nv] [uniqueidentifier] NULL,
	[ma] [varchar](20) NULL,
	[ngay_tao] [date] NULL,
	[ngay_thanh_toan] [date] NULL,
	[ten_nguoi_nhan] [nvarchar](50) NULL,
	[dia_chi] [nvarchar](100) NULL,
	[sdt] [varchar](30) NULL,
	[tinh_trang] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[gio_hang_chi_tiet]    Script Date: 29/03/2023 12:34:48 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[gio_hang_chi_tiet](
	[id_gio_hang] [uniqueidentifier] NOT NULL,
	[id_chi_tiet_sp] [uniqueidentifier] NOT NULL,
	[so_luong] [int] NULL,
	[don_gia] [decimal](20, 0) NULL,
	[don_gia_khi_giam] [decimal](20, 0) NULL,
 CONSTRAINT [PK_GioHangCT] PRIMARY KEY CLUSTERED 
(
	[id_gio_hang] ASC,
	[id_chi_tiet_sp] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[hoa_don]    Script Date: 29/03/2023 12:34:48 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[hoa_don](
	[id] [uniqueidentifier] NOT NULL,
	[id_kh] [uniqueidentifier] NULL,
	[id_nv] [uniqueidentifier] NULL,
	[ma] [varchar](20) NULL,
	[ngay_tao] [date] NULL,
	[ngay_thanh_toan] [date] NULL,
	[ngay_ship] [date] NULL,
	[ngay_nhan] [date] NULL,
	[tinh_trang] [int] NULL,
	[ten_nguoi_nhan] [nvarchar](50) NULL,
	[dia_chi] [nvarchar](100) NULL,
	[sdt] [varchar](30) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[hoa_don_chi_tiet]    Script Date: 29/03/2023 12:34:48 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[hoa_don_chi_tiet](
	[id_hoa_don] [uniqueidentifier] NOT NULL,
	[id_chi_tiet_sp] [uniqueidentifier] NOT NULL,
	[so_luong] [int] NULL,
	[don_gia] [decimal](20, 0) NULL,
 CONSTRAINT [PK_HoaDonCT] PRIMARY KEY CLUSTERED 
(
	[id_hoa_don] ASC,
	[id_chi_tiet_sp] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[khach_hang]    Script Date: 29/03/2023 12:34:48 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[khach_hang](
	[id] [uniqueidentifier] NOT NULL,
	[ma] [varchar](20) NULL,
	[ten] [nvarchar](30) NULL,
	[ten_dem] [nvarchar](30) NULL,
	[ho] [nvarchar](30) NULL,
	[ngay_sinh] [date] NULL,
	[sdt] [varchar](30) NULL,
	[dia_chi] [nvarchar](100) NULL,
	[thanh_pho] [nvarchar](50) NULL,
	[quoc_gia] [nvarchar](50) NULL,
	[mat_khau] [varchar](max) NULL,
	[image] [nvarchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[mau_sac]    Script Date: 29/03/2023 12:34:48 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[mau_sac](
	[id] [uniqueidentifier] NOT NULL,
	[ma] [varchar](20) NULL,
	[ten] [nvarchar](30) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[nhan_vien]    Script Date: 29/03/2023 12:34:48 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[nhan_vien](
	[id] [uniqueidentifier] NOT NULL,
	[ma] [varchar](20) NULL,
	[ten] [nvarchar](30) NULL,
	[ten_dem] [nvarchar](30) NULL,
	[ho] [nvarchar](30) NULL,
	[gioi_tinh] [nvarchar](10) NULL,
	[ngay_sinh] [date] NULL,
	[dia_chi] [nvarchar](100) NULL,
	[sdt] [varchar](30) NULL,
	[mat_khau] [varchar](max) NULL,
	[id_ch] [uniqueidentifier] NULL,
	[id_cv] [uniqueidentifier] NULL,
	[id_gui_bc] [uniqueidentifier] NULL,
	[trang_thai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[nxs]    Script Date: 29/03/2023 12:34:48 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[nxs](
	[id] [uniqueidentifier] NOT NULL,
	[ma] [varchar](20) NULL,
	[ten] [nvarchar](30) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[san_pham]    Script Date: 29/03/2023 12:34:48 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[san_pham](
	[id] [uniqueidentifier] NOT NULL,
	[ma] [varchar](20) NULL,
	[ten] [nvarchar](30) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[chi_tiet_sp] ([id], [id_sp], [id_nsx], [id_mau_sac], [id_dong_sp], [nam_bh], [mo_ta], [so_luong_ton], [gia_nhap], [gia_ban]) VALUES (N'65ed8d2d-1623-446c-bf34-2c99fa6774fb', N'31de5538-6ade-4f2d-96e0-7857fa682cbb', N'26edeb82-8020-4e6c-92a9-5a1c4b1f1b4c', N'2f5169fe-1d80-435d-9780-612738ea52d2', N'e9c5fde5-d87c-40e3-a7a4-a902299c8aec', 1, N'chống điện tốt', 100, CAST(12000 AS Decimal(20, 0)), CAST(19000 AS Decimal(20, 0)))
INSERT [dbo].[chi_tiet_sp] ([id], [id_sp], [id_nsx], [id_mau_sac], [id_dong_sp], [nam_bh], [mo_ta], [so_luong_ton], [gia_nhap], [gia_ban]) VALUES (N'10d96f64-5cab-4534-9659-3c91038b0d5d', NULL, NULL, NULL, NULL, 1991, N'chống điện tốt', 100, CAST(12000 AS Decimal(20, 0)), NULL)
INSERT [dbo].[chi_tiet_sp] ([id], [id_sp], [id_nsx], [id_mau_sac], [id_dong_sp], [nam_bh], [mo_ta], [so_luong_ton], [gia_nhap], [gia_ban]) VALUES (N'61ef5a8e-2013-4778-b314-5fe560ef6a1d', N'b2c9ef1c-a009-472a-b37a-511de397fa17', N'b09bb1ed-796d-4fe9-9453-8e21ca0e274c', N'f6bb1959-2bd6-4287-94d8-010a2703cef1', N'10a17b05-a2bd-4eda-8a8f-ad3e0e4f7dcd', 2, N'xin hãy nhẹ tay', 24, CAST(30000 AS Decimal(20, 0)), CAST(40000 AS Decimal(20, 0)))
INSERT [dbo].[chi_tiet_sp] ([id], [id_sp], [id_nsx], [id_mau_sac], [id_dong_sp], [nam_bh], [mo_ta], [so_luong_ton], [gia_nhap], [gia_ban]) VALUES (N'3fdab3eb-8225-4bc3-a725-9db2c3856c2b', N'5b6e6315-b2ec-43e7-a87f-1b444c5182bf', N'0348cba6-c466-490a-a342-fe5bf2c673da', N'f6bb1959-2bd6-4287-94d8-010a2703cef1', N'e9c5fde5-d87c-40e3-a7a4-a902299c8aec', 2000, N'chống nuowsc', 100, CAST(12000 AS Decimal(20, 0)), CAST(19000 AS Decimal(20, 0)))
INSERT [dbo].[chi_tiet_sp] ([id], [id_sp], [id_nsx], [id_mau_sac], [id_dong_sp], [nam_bh], [mo_ta], [so_luong_ton], [gia_nhap], [gia_ban]) VALUES (N'f20ad5ca-4755-4d66-a9eb-9e791c81af72', NULL, NULL, NULL, NULL, 1999, N'chống điện tốt', 10, CAST(12000 AS Decimal(20, 0)), NULL)
INSERT [dbo].[chi_tiet_sp] ([id], [id_sp], [id_nsx], [id_mau_sac], [id_dong_sp], [nam_bh], [mo_ta], [so_luong_ton], [gia_nhap], [gia_ban]) VALUES (N'efa082b3-37a8-49fd-ac80-aeeb7ea12fd7', NULL, NULL, NULL, NULL, 1, N'chống điện tốt', 1001, CAST(12000 AS Decimal(20, 0)), NULL)
INSERT [dbo].[chi_tiet_sp] ([id], [id_sp], [id_nsx], [id_mau_sac], [id_dong_sp], [nam_bh], [mo_ta], [so_luong_ton], [gia_nhap], [gia_ban]) VALUES (N'aba32191-b48f-4a49-83c6-d51d909945ba', NULL, NULL, NULL, NULL, 1998, N'chống điện tốt', 10, CAST(12000 AS Decimal(20, 0)), NULL)
INSERT [dbo].[chi_tiet_sp] ([id], [id_sp], [id_nsx], [id_mau_sac], [id_dong_sp], [nam_bh], [mo_ta], [so_luong_ton], [gia_nhap], [gia_ban]) VALUES (N'da8e3ff8-cf3e-484d-b9a2-e6b09ba7cf19', NULL, NULL, NULL, NULL, 1998, N'chống điện tốt', 1000, CAST(12000 AS Decimal(20, 0)), NULL)
GO
INSERT [dbo].[chuc_vu] ([id], [ma], [ten]) VALUES (N'ff9e5171-88ea-4c6a-b258-c9465a76ec0a', N'CV03', N'Phó giám Đốc')
INSERT [dbo].[chuc_vu] ([id], [ma], [ten]) VALUES (N'b075a122-b02d-481e-ba38-f5661e540c2b', N'CV01', N'Trưởng Phòng Vip')
GO
INSERT [dbo].[cua_hang] ([id], [ma], [ten], [dia_chi], [thanh_pho], [quoc_gia]) VALUES (N'00401583-21fa-46ef-be64-1c1c42b576f1', N'CH02', N'hung quanga', N'BacNinh', N'Bac Ninh City', N'VietNam')
GO
INSERT [dbo].[dong_sp] ([id], [ma], [ten]) VALUES (N'83583306-fd00-4834-936b-06a1ad51c3fc', N'DongSP04', N'Đồ Ăn')
INSERT [dbo].[dong_sp] ([id], [ma], [ten]) VALUES (N'766b5464-afa3-4106-81fc-7447734d3657', N'DongSP05', N'Gỗ')
INSERT [dbo].[dong_sp] ([id], [ma], [ten]) VALUES (N'e9c5fde5-d87c-40e3-a7a4-a902299c8aec', N'DongSP03', N'Quần Áo')
INSERT [dbo].[dong_sp] ([id], [ma], [ten]) VALUES (N'10a17b05-a2bd-4eda-8a8f-ad3e0e4f7dcd', N'DongSP01', N'Điện Thoại')
INSERT [dbo].[dong_sp] ([id], [ma], [ten]) VALUES (N'125d59e9-0907-4637-a154-bf4836e93fb9', N'DongSP02', N'Đồ Uống')
GO
INSERT [dbo].[hoa_don] ([id], [id_kh], [id_nv], [ma], [ngay_tao], [ngay_thanh_toan], [ngay_ship], [ngay_nhan], [tinh_trang], [ten_nguoi_nhan], [dia_chi], [sdt]) VALUES (N'a00f690e-3f0f-4801-ab16-0b36439f2a07', NULL, NULL, N'HD697', CAST(N'2022-10-18' AS Date), NULL, NULL, NULL, 1, NULL, NULL, NULL)
INSERT [dbo].[hoa_don] ([id], [id_kh], [id_nv], [ma], [ngay_tao], [ngay_thanh_toan], [ngay_ship], [ngay_nhan], [tinh_trang], [ten_nguoi_nhan], [dia_chi], [sdt]) VALUES (N'4cb94dba-2ce9-4832-9fef-0bbfc42831c3', NULL, NULL, N'HD552', CAST(N'2022-10-18' AS Date), NULL, NULL, NULL, 1, NULL, NULL, NULL)
INSERT [dbo].[hoa_don] ([id], [id_kh], [id_nv], [ma], [ngay_tao], [ngay_thanh_toan], [ngay_ship], [ngay_nhan], [tinh_trang], [ten_nguoi_nhan], [dia_chi], [sdt]) VALUES (N'41b738c6-cbc8-4ad2-a5a3-3782efa7915c', NULL, NULL, N'HD549', CAST(N'2022-10-18' AS Date), NULL, NULL, NULL, 1, NULL, NULL, NULL)
INSERT [dbo].[hoa_don] ([id], [id_kh], [id_nv], [ma], [ngay_tao], [ngay_thanh_toan], [ngay_ship], [ngay_nhan], [tinh_trang], [ten_nguoi_nhan], [dia_chi], [sdt]) VALUES (N'e01285d8-e30b-478d-a66a-4799748e64a7', NULL, NULL, N'HD208', CAST(N'2022-10-18' AS Date), NULL, NULL, NULL, 1, NULL, NULL, NULL)
INSERT [dbo].[hoa_don] ([id], [id_kh], [id_nv], [ma], [ngay_tao], [ngay_thanh_toan], [ngay_ship], [ngay_nhan], [tinh_trang], [ten_nguoi_nhan], [dia_chi], [sdt]) VALUES (N'72e8e760-9838-4524-a55e-56f1e9b87b59', NULL, NULL, N'HD436', CAST(N'2022-10-18' AS Date), NULL, NULL, NULL, 1, NULL, NULL, NULL)
INSERT [dbo].[hoa_don] ([id], [id_kh], [id_nv], [ma], [ngay_tao], [ngay_thanh_toan], [ngay_ship], [ngay_nhan], [tinh_trang], [ten_nguoi_nhan], [dia_chi], [sdt]) VALUES (N'19e3955f-1e5a-4732-8293-681d34ed1e0d', NULL, NULL, N'HD201', CAST(N'2022-10-16' AS Date), NULL, NULL, NULL, 1, NULL, NULL, NULL)
INSERT [dbo].[hoa_don] ([id], [id_kh], [id_nv], [ma], [ngay_tao], [ngay_thanh_toan], [ngay_ship], [ngay_nhan], [tinh_trang], [ten_nguoi_nhan], [dia_chi], [sdt]) VALUES (N'4da116d0-765a-41c1-8bd3-6e5d517204f3', NULL, NULL, N'HD752', CAST(N'2022-10-18' AS Date), NULL, NULL, NULL, 1, NULL, NULL, NULL)
INSERT [dbo].[hoa_don] ([id], [id_kh], [id_nv], [ma], [ngay_tao], [ngay_thanh_toan], [ngay_ship], [ngay_nhan], [tinh_trang], [ten_nguoi_nhan], [dia_chi], [sdt]) VALUES (N'20c48afd-a623-406f-a935-879dcf320c24', NULL, NULL, N'HD596', CAST(N'2022-10-29' AS Date), NULL, NULL, NULL, 1, NULL, NULL, NULL)
INSERT [dbo].[hoa_don] ([id], [id_kh], [id_nv], [ma], [ngay_tao], [ngay_thanh_toan], [ngay_ship], [ngay_nhan], [tinh_trang], [ten_nguoi_nhan], [dia_chi], [sdt]) VALUES (N'79a49f8c-d2ef-4c07-89e4-a91717391196', NULL, NULL, N'HD819', CAST(N'2022-10-22' AS Date), NULL, NULL, NULL, 1, NULL, NULL, NULL)
INSERT [dbo].[hoa_don] ([id], [id_kh], [id_nv], [ma], [ngay_tao], [ngay_thanh_toan], [ngay_ship], [ngay_nhan], [tinh_trang], [ten_nguoi_nhan], [dia_chi], [sdt]) VALUES (N'4056bb05-1250-4570-9da1-cacfb75018ad', NULL, NULL, N'HD759', CAST(N'2022-10-18' AS Date), NULL, NULL, NULL, 1, NULL, NULL, NULL)
INSERT [dbo].[hoa_don] ([id], [id_kh], [id_nv], [ma], [ngay_tao], [ngay_thanh_toan], [ngay_ship], [ngay_nhan], [tinh_trang], [ten_nguoi_nhan], [dia_chi], [sdt]) VALUES (N'11e773b5-6bfc-4118-9e4e-ce54e34bc0a5', NULL, NULL, N'HD374', CAST(N'2022-10-18' AS Date), NULL, NULL, NULL, 1, NULL, NULL, NULL)
INSERT [dbo].[hoa_don] ([id], [id_kh], [id_nv], [ma], [ngay_tao], [ngay_thanh_toan], [ngay_ship], [ngay_nhan], [tinh_trang], [ten_nguoi_nhan], [dia_chi], [sdt]) VALUES (N'6bc0e476-11af-4fb1-a988-dd2a50af9181', NULL, NULL, N'HD451', CAST(N'2022-10-15' AS Date), NULL, NULL, NULL, 1, NULL, NULL, NULL)
INSERT [dbo].[hoa_don] ([id], [id_kh], [id_nv], [ma], [ngay_tao], [ngay_thanh_toan], [ngay_ship], [ngay_nhan], [tinh_trang], [ten_nguoi_nhan], [dia_chi], [sdt]) VALUES (N'f9164ed3-f351-40ca-bedf-f5e2797117df', NULL, NULL, N'HD959', CAST(N'2022-10-18' AS Date), NULL, NULL, NULL, 1, NULL, NULL, NULL)
GO
INSERT [dbo].[hoa_don_chi_tiet] ([id_hoa_don], [id_chi_tiet_sp], [so_luong], [don_gia]) VALUES (N'20c48afd-a623-406f-a935-879dcf320c24', N'61ef5a8e-2013-4778-b314-5fe560ef6a1d', 1, CAST(40000 AS Decimal(20, 0)))
INSERT [dbo].[hoa_don_chi_tiet] ([id_hoa_don], [id_chi_tiet_sp], [so_luong], [don_gia]) VALUES (N'20c48afd-a623-406f-a935-879dcf320c24', N'3fdab3eb-8225-4bc3-a725-9db2c3856c2b', 2, CAST(19000 AS Decimal(20, 0)))
GO
INSERT [dbo].[khach_hang] ([id], [ma], [ten], [ten_dem], [ho], [ngay_sinh], [sdt], [dia_chi], [thanh_pho], [quoc_gia], [mat_khau]) VALUES (N'a307fdc7-2c84-4d3d-abb4-43757da88f34', N'KH06', N'Phúc', N'H?ng', N'Ð?', CAST(N'2003-08-03' AS Date), N'0962823303', N'Nam Ð?nh', NULL, NULL, NULL)
INSERT [dbo].[khach_hang] ([id], [ma], [ten], [ten_dem], [ho], [ngay_sinh], [sdt], [dia_chi], [thanh_pho], [quoc_gia], [mat_khau]) VALUES (N'15232849-6b8a-4dc1-bfbc-9ceb251fa1d3', N'KH05', N'Phúc', N'H?ng', N'Ð?', CAST(N'2003-08-03' AS Date), N'0962823303', N'Nam Ð?nh', NULL, NULL, NULL)
INSERT [dbo].[khach_hang] ([id], [ma], [ten], [ten_dem], [ho], [ngay_sinh], [sdt], [dia_chi], [thanh_pho], [quoc_gia], [mat_khau]) VALUES (N'848da39b-0d5c-4c40-87de-a39cd3be3c5b', N'KH04', N'M?nh', N'Van', N'Nguy?n', CAST(N'2003-08-03' AS Date), N'0962823303', N'BacNinh', NULL, NULL, NULL)
INSERT [dbo].[khach_hang] ([id], [ma], [ten], [ten_dem], [ho], [ngay_sinh], [sdt], [dia_chi], [thanh_pho], [quoc_gia], [mat_khau]) VALUES (N'b7afca1d-3949-4cf7-b73c-a9acddcb8425', N'KH02', N'Huy?n', N'Thanh', N'Ðoàn', CAST(N'2003-08-03' AS Date), N'0962823303', N'BacNinh', NULL, NULL, NULL)
INSERT [dbo].[khach_hang] ([id], [ma], [ten], [ten_dem], [ho], [ngay_sinh], [sdt], [dia_chi], [thanh_pho], [quoc_gia], [mat_khau]) VALUES (N'c90f24a4-f223-49f0-a42b-b31a86a302ab', N'KH01', N'Hung', N'Quang', N'Lê', CAST(N'2003-08-10' AS Date), N'0962823303', N'BacNinh', NULL, NULL, NULL)
INSERT [dbo].[khach_hang] ([id], [ma], [ten], [ten_dem], [ho], [ngay_sinh], [sdt], [dia_chi], [thanh_pho], [quoc_gia], [mat_khau]) VALUES (N'31f63fcd-cf3d-4d02-8926-cc38d348e54f', N'KH03', N'Kh?i', N'Quang', N'Tr?n', CAST(N'2003-08-03' AS Date), N'0962823303', N'BacNinh', NULL, NULL, NULL)
GO
INSERT [dbo].[mau_sac] ([id], [ma], [ten]) VALUES (N'f6bb1959-2bd6-4287-94d8-010a2703cef1', N'MS01', N'Vàng Cứt')
INSERT [dbo].[mau_sac] ([id], [ma], [ten]) VALUES (N'5bc9dcb2-000b-46b6-8c94-557ed7d65251', N'MS03', N'Tím Mộng Mơ')
INSERT [dbo].[mau_sac] ([id], [ma], [ten]) VALUES (N'2f5169fe-1d80-435d-9780-612738ea52d2', N'MS02', N'Xanh')
INSERT [dbo].[mau_sac] ([id], [ma], [ten]) VALUES (N'3e11dc22-b20b-45cc-bb68-66021a6113f0', N'MS07', N'Xanh Dương')
INSERT [dbo].[mau_sac] ([id], [ma], [ten]) VALUES (N'64fefe23-5112-4694-8cbb-6e9d74f66eae', N'MS04', N'Hồng Cá Tính')
INSERT [dbo].[mau_sac] ([id], [ma], [ten]) VALUES (N'223c81a2-1822-4449-9f3b-b540bcd1f54d', N'MS06', N'ĐỎ')
GO
INSERT [dbo].[nhan_vien] ([id], [ma], [ten], [ten_dem], [ho], [gioi_tinh], [ngay_sinh], [dia_chi], [sdt], [mat_khau],[id_ch], [id_cv], [id_gui_bc], [trang_thai]) VALUES (N'0920c2bb-d2ca-4fd1-b11f-0598d735b39c', N'NV01', N'Hung', N'Quang', N'Le', N'Nam', CAST(N'2003-08-10' AS Date), N'Bac Ninh', N'0962823303', NULL, NULL, NULL, NULL, 0)
INSERT [dbo].[nhan_vien] ([id], [ma], [ten], [ten_dem], [ho], [gioi_tinh], [ngay_sinh], [dia_chi], [sdt], [mat_khau],[id_ch], [id_cv], [id_gui_bc], [trang_thai]) VALUES (N'37e78ca8-aa8f-4f66-9758-c140e72eead2', N'NV02', N'Khai', N'Văn', N'Tran', N'Nữ', CAST(N'2002-09-02' AS Date), N'Lai Chau 98', N'0962823303', NULL, NULL, NULL, NULL, 1)
GO
INSERT [dbo].[nxs] ([id], [ma], [ten]) VALUES (N'226f2a78-11cb-47b4-858c-2417c79d46b3', N'NSX03', N'Nhà Sản Xuất 2')
INSERT [dbo].[nxs] ([id], [ma], [ten]) VALUES (N'26edeb82-8020-4e6c-92a9-5a1c4b1f1b4c', N'NSX02', N'Nhà Sản Xuất 1')
INSERT [dbo].[nxs] ([id], [ma], [ten]) VALUES (N'b09bb1ed-796d-4fe9-9453-8e21ca0e274c', N'NSX01', N'Apple')
INSERT [dbo].[nxs] ([id], [ma], [ten]) VALUES (N'0348cba6-c466-490a-a342-fe5bf2c673da', N'NSX04', N'TOCOTOCO')
GO
INSERT [dbo].[san_pham] ([id], [ma], [ten]) VALUES (N'5b6e6315-b2ec-43e7-a87f-1b444c5182bf', N'SP09', N'Quan Hung Yen')
INSERT [dbo].[san_pham] ([id], [ma], [ten]) VALUES (N'b2c9ef1c-a009-472a-b37a-511de397fa17', N'SP05', N'IphoneX')
INSERT [dbo].[san_pham] ([id], [ma], [ten]) VALUES (N'b84c9227-3088-4278-9f81-73ec13257671', N'SP07', N'IphoneX')
INSERT [dbo].[san_pham] ([id], [ma], [ten]) VALUES (N'31de5538-6ade-4f2d-96e0-7857fa682cbb', N'SP06', N'ao coc11111')
INSERT [dbo].[san_pham] ([id], [ma], [ten]) VALUES (N'57d6d3cc-3f1a-450f-b256-aa27a7fd3f66', N'SP04', N'Trà Sữa')
INSERT [dbo].[san_pham] ([id], [ma], [ten]) VALUES (N'89e78d2e-ae06-4203-b1d3-b7302f532431', N'SP02', N'Áo Thun')
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__ChucVu__3214CC9E888E42E2]    Script Date: 29/03/2023 12:34:48 CH ******/
ALTER TABLE [dbo].[chuc_vu] ADD UNIQUE NONCLUSTERED 
(
	[ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__CuaHang__3214CC9E65AC44DB]    Script Date: 29/03/2023 12:34:48 CH ******/
ALTER TABLE [dbo].[cua_hang] ADD UNIQUE NONCLUSTERED 
(
	[ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__DongSP__3214CC9EA0AA1E38]    Script Date: 29/03/2023 12:34:48 CH ******/
ALTER TABLE [dbo].[dong_sp] ADD UNIQUE NONCLUSTERED 
(
	[ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__GioHang__3214CC9E260893A5]    Script Date: 29/03/2023 12:34:48 CH ******/
ALTER TABLE [dbo].[gio_hang] ADD UNIQUE NONCLUSTERED 
(
	[ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__HoaDon__3214CC9EEBF3B431]    Script Date: 29/03/2023 12:34:48 CH ******/
ALTER TABLE [dbo].[hoa_don] ADD UNIQUE NONCLUSTERED 
(
	[ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__KhachHan__3214CC9E3F5CBF63]    Script Date: 29/03/2023 12:34:48 CH ******/
ALTER TABLE [dbo].[khach_hang] ADD UNIQUE NONCLUSTERED 
(
	[ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__MauSac__3214CC9E1EC4D4AA]    Script Date: 29/03/2023 12:34:48 CH ******/
ALTER TABLE [dbo].[mau_sac] ADD UNIQUE NONCLUSTERED 
(
	[ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__NhanVien__3214CC9EAA3D3EF8]    Script Date: 29/03/2023 12:34:48 CH ******/
ALTER TABLE [dbo].[nhan_vien] ADD UNIQUE NONCLUSTERED 
(
	[ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__NSX__3214CC9ED1F5A9F9]    Script Date: 29/03/2023 12:34:48 CH ******/
ALTER TABLE [dbo].[nxs] ADD UNIQUE NONCLUSTERED 
(
	[ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__SanPham__3214CC9EA7A18306]    Script Date: 29/03/2023 12:34:48 CH ******/
ALTER TABLE [dbo].[san_pham] ADD UNIQUE NONCLUSTERED 
(
	[ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[chi_tiet_sp] ADD  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[chi_tiet_sp] ADD  DEFAULT (NULL) FOR [nam_bh]
GO
ALTER TABLE [dbo].[chi_tiet_sp] ADD  DEFAULT (NULL) FOR [mo_ta]
GO
ALTER TABLE [dbo].[chi_tiet_sp] ADD  DEFAULT ((0)) FOR [gia_nhap]
GO
ALTER TABLE [dbo].[chi_tiet_sp] ADD  DEFAULT ((0)) FOR [gia_ban]
GO
ALTER TABLE [dbo].[chuc_vu] ADD  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[chuc_vu] ADD  DEFAULT (NULL) FOR [ten]
GO
ALTER TABLE [dbo].[cua_hang] ADD  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[cua_hang] ADD  DEFAULT (NULL) FOR [ten]
GO
ALTER TABLE [dbo].[cua_hang] ADD  DEFAULT (NULL) FOR [dia_chi]
GO
ALTER TABLE [dbo].[cua_hang] ADD  DEFAULT (NULL) FOR [thanh_pho]
GO
ALTER TABLE [dbo].[cua_hang] ADD  DEFAULT (NULL) FOR [quoc_gia]
GO
ALTER TABLE [dbo].[dong_sp] ADD  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[gio_hang] ADD  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[gio_hang] ADD  DEFAULT (NULL) FOR [ngay_tao]
GO
ALTER TABLE [dbo].[gio_hang] ADD  DEFAULT (NULL) FOR [ngay_thanh_toan]
GO
ALTER TABLE [dbo].[gio_hang] ADD  DEFAULT (NULL) FOR [ten_nguoi_nhan]
GO
ALTER TABLE [dbo].[gio_hang] ADD  DEFAULT (NULL) FOR [dia_chi]
GO
ALTER TABLE [dbo].[gio_hang] ADD  DEFAULT (NULL) FOR [sdt]
GO
ALTER TABLE [dbo].[gio_hang] ADD  DEFAULT ((0)) FOR [tinh_trang]
GO
ALTER TABLE [dbo].[gio_hang_chi_tiet] ADD  DEFAULT ((0)) FOR [don_gia]
GO
ALTER TABLE [dbo].[gio_hang_chi_tiet] ADD  DEFAULT ((0)) FOR [don_gia_khi_giam]
GO
ALTER TABLE [dbo].[hoa_don] ADD  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[hoa_don] ADD  DEFAULT (NULL) FOR [ngay_tao]
GO
ALTER TABLE [dbo].[hoa_don] ADD  DEFAULT (NULL) FOR [ngay_thanh_toan]
GO
ALTER TABLE [dbo].[hoa_don] ADD  DEFAULT (NULL) FOR [ngay_ship]
GO
ALTER TABLE [dbo].[hoa_don] ADD  DEFAULT (NULL) FOR [ngay_nhan]
GO
ALTER TABLE [dbo].[hoa_don] ADD  DEFAULT ((0)) FOR [tinh_trang]
GO
ALTER TABLE [dbo].[hoa_don] ADD  DEFAULT (NULL) FOR [ten_nguoi_nhan]
GO
ALTER TABLE [dbo].[hoa_don] ADD  DEFAULT (NULL) FOR [dia_chi]
GO
ALTER TABLE [dbo].[hoa_don] ADD  DEFAULT (NULL) FOR [sdt]
GO
ALTER TABLE [dbo].[hoa_don_chi_tiet] ADD  DEFAULT ((0)) FOR [don_gia]
GO
ALTER TABLE [dbo].[khach_hang] ADD  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[khach_hang] ADD  DEFAULT (NULL) FOR [ten_dem]
GO
ALTER TABLE [dbo].[khach_hang] ADD  DEFAULT (NULL) FOR [ho]
GO
ALTER TABLE [dbo].[khach_hang] ADD  DEFAULT (NULL) FOR [ngay_sinh]
GO
ALTER TABLE [dbo].[khach_hang] ADD  DEFAULT (NULL) FOR [sdt]
GO
ALTER TABLE [dbo].[khach_hang] ADD  DEFAULT (NULL) FOR [dia_chi]
GO
ALTER TABLE [dbo].[khach_hang] ADD  DEFAULT (NULL) FOR [thanh_pho]
GO
ALTER TABLE [dbo].[khach_hang] ADD  DEFAULT (NULL) FOR [quoc_gia]
GO
ALTER TABLE [dbo].[khach_hang] ADD  DEFAULT (NULL) FOR [mat_khau]
GO
ALTER TABLE [dbo].[mau_sac] ADD  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[nhan_vien] ADD  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[nhan_vien] ADD  DEFAULT (NULL) FOR [ten]
GO
ALTER TABLE [dbo].[nhan_vien] ADD  DEFAULT (NULL) FOR [ten_dem]
GO
ALTER TABLE [dbo].[nhan_vien] ADD  DEFAULT (NULL) FOR [ho]
GO
ALTER TABLE [dbo].[nhan_vien] ADD  DEFAULT (NULL) FOR [gioi_tinh]
GO
ALTER TABLE [dbo].[nhan_vien] ADD  DEFAULT (NULL) FOR [ngay_sinh]
GO
ALTER TABLE [dbo].[nhan_vien] ADD  DEFAULT (NULL) FOR [dia_chi]
GO
ALTER TABLE [dbo].[nhan_vien] ADD  DEFAULT (NULL) FOR [sdt]
GO
ALTER TABLE [dbo].[nhan_vien] ADD  DEFAULT (NULL) FOR [mat_khau]
GO
ALTER TABLE [dbo].[nhan_vien] ADD  DEFAULT ((0)) FOR [trang_thai]
GO
ALTER TABLE [dbo].[nxs] ADD  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[san_pham] ADD  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[chi_tiet_sp]  WITH CHECK ADD FOREIGN KEY([id_dong_sp])
REFERENCES [dbo].[dong_sp] ([id])
GO
ALTER TABLE [dbo].[chi_tiet_sp]  WITH CHECK ADD FOREIGN KEY([id_mau_sac])
REFERENCES [dbo].[mau_sac] ([id])
GO
ALTER TABLE [dbo].[chi_tiet_sp]  WITH CHECK ADD FOREIGN KEY([id_nsx])
REFERENCES [dbo].[nxs] ([id])
GO
ALTER TABLE [dbo].[chi_tiet_sp]  WITH CHECK ADD FOREIGN KEY([id_sp])
REFERENCES [dbo].[san_pham] ([id])
GO
ALTER TABLE [dbo].[gio_hang]  WITH CHECK ADD FOREIGN KEY([id_kh])
REFERENCES [dbo].[khach_hang] ([id])
GO
ALTER TABLE [dbo].[gio_hang_chi_tiet]  WITH CHECK ADD  CONSTRAINT [FK1_IdGioHang] FOREIGN KEY([id_gio_hang])
REFERENCES [dbo].[gio_hang] ([id])
GO
ALTER TABLE [dbo].[gio_hang_chi_tiet] CHECK CONSTRAINT [FK1_IdGioHang]
GO
ALTER TABLE [dbo].[gio_hang_chi_tiet]  WITH CHECK ADD  CONSTRAINT [FK2_IdChiTietSP] FOREIGN KEY([id_chi_tiet_sp])
REFERENCES [dbo].[chi_tiet_sp] ([id])
GO
ALTER TABLE [dbo].[gio_hang_chi_tiet] CHECK CONSTRAINT [FK2_IdChiTietSP]
GO
ALTER TABLE [dbo].[hoa_don]  WITH CHECK ADD FOREIGN KEY([id_kh])
REFERENCES [dbo].[khach_hang] ([id])
GO
ALTER TABLE [dbo].[hoa_don]  WITH CHECK ADD FOREIGN KEY([id_nv])
REFERENCES [dbo].[nhan_vien] ([id])
GO
ALTER TABLE [dbo].[hoa_don_chi_tiet]  WITH CHECK ADD  CONSTRAINT [FK1] FOREIGN KEY([id_hoa_don])
REFERENCES [dbo].[hoa_don] ([id])
GO
ALTER TABLE [dbo].[hoa_don_chi_tiet] CHECK CONSTRAINT [FK1]
GO
ALTER TABLE [dbo].[hoa_don_chi_tiet]  WITH CHECK ADD  CONSTRAINT [FK2] FOREIGN KEY([id_chi_tiet_sp])
REFERENCES [dbo].[chi_tiet_sp] ([id])
GO
ALTER TABLE [dbo].[hoa_don_chi_tiet] CHECK CONSTRAINT [FK2]
GO
ALTER TABLE [dbo].[nhan_vien]  WITH CHECK ADD FOREIGN KEY([id_ch])
REFERENCES [dbo].[cua_hang] ([id])
GO
ALTER TABLE [dbo].[nhan_vien]  WITH CHECK ADD FOREIGN KEY ([id_cv])
REFERENCES [dbo].[chuc_vu] ([id])
GO
ALTER TABLE [dbo].[nhan_vien]  WITH CHECK ADD FOREIGN KEY([id_gui_bc])
REFERENCES [dbo].[nhan_vien] ([id])
GO


SELECT * from nhan_vien
SELECT * FROM chuc_vu
SELECT * FROM khach_hang
SELECT * FROM san_pham
SELECT * FROM chi_tiet_sp
SELECT * FROM cua_hang
SELECT * FROM hoa_don
SELECT * FROM hoa_don_chi_tiet
SELECT * FROM gio_hang
SELECT * FROM gio_hang_chi_tiet
SELECT * FROM mau_sac
SELECT * FROM dong_sp



