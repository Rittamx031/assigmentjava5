USE [master]
GO
/****** Object:  Database [FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041]    Script Date: 10/8/2023 3:00:20 PM ******/
CREATE DATABASE [FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.SQLRITTAM\MSSQL\DATA\FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.SQLRITTAM\MSSQL\DATA\FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041] SET ARITHABORT OFF 
GO
ALTER DATABASE [FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041] SET  ENABLE_BROKER 
GO
ALTER DATABASE [FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041] SET RECOVERY FULL 
GO
ALTER DATABASE [FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041] SET  MULTI_USER 
GO
ALTER DATABASE [FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041] SET DB_CHAINING OFF 
GO
ALTER DATABASE [FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041', N'ON'
GO
ALTER DATABASE [FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041] SET QUERY_STORE = ON
GO
ALTER DATABASE [FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041]
GO
/****** Object:  User [rittam]    Script Date: 10/8/2023 3:00:20 PM ******/
CREATE USER [rittam] FOR LOGIN [rittam] WITH DEFAULT_SCHEMA=[dbo]
GO
ALTER ROLE [db_owner] ADD MEMBER [rittam]
GO
ALTER ROLE [db_datareader] ADD MEMBER [rittam]
GO
ALTER ROLE [db_datawriter] ADD MEMBER [rittam]
GO
/****** Object:  Table [dbo].[chi_tiet_sp]    Script Date: 10/8/2023 3:00:20 PM ******/
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
	[image] [nchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[chuc_vu]    Script Date: 10/8/2023 3:00:20 PM ******/
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
/****** Object:  Table [dbo].[cua_hang]    Script Date: 10/8/2023 3:00:20 PM ******/
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
/****** Object:  Table [dbo].[dong_sp]    Script Date: 10/8/2023 3:00:20 PM ******/
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
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[gio_hang]    Script Date: 10/8/2023 3:00:20 PM ******/
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
	[checked] [bit] DEFAULT 0,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[gio_hang_chi_tiet]    Script Date: 10/8/2023 3:00:20 PM ******/
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
	[checked] [bit]  DEFAULT 0,
 CONSTRAINT [PK_GioHangCT] PRIMARY KEY CLUSTERED 
(
	[id_gio_hang] ASC,
	[id_chi_tiet_sp] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[hoa_don]    Script Date: 10/8/2023 3:00:20 PM ******/
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
/****** Object:  Table [dbo].[hoa_don_chi_tiet]    Script Date: 10/8/2023 3:00:20 PM ******/
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
/****** Object:  Table [dbo].[khach_hang]    Script Date: 10/8/2023 3:00:20 PM ******/
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
/****** Object:  Table [dbo].[mau_sac]    Script Date: 10/8/2023 3:00:20 PM ******/
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
/****** Object:  Table [dbo].[nhan_vien]    Script Date: 10/8/2023 3:00:20 PM ******/
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
/****** Object:  Table [dbo].[nxs]    Script Date: 10/8/2023 3:00:20 PM ******/
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
/****** Object:  Table [dbo].[san_pham]    Script Date: 10/8/2023 3:00:20 PM ******/
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
INSERT [dbo].[chi_tiet_sp] ([id], [id_sp], [id_nsx], [id_mau_sac], [id_dong_sp], [nam_bh], [mo_ta], [so_luong_ton], [gia_nhap], [gia_ban], [image]) VALUES (N'98d17361-d799-441d-b3e1-48921bb839fa', N'5b6e6315-b2ec-43e7-a87f-1b444c5182bf', N'226f2a78-11cb-47b4-858c-2417c79d46b3', N'5bc9dcb2-000b-46b6-8c94-557ed7d65251', N'766b5464-afa3-4106-81fc-7447734d3657', 100, NULL, 212, CAST(121 AS Decimal(20, 0)), CAST(132 AS Decimal(20, 0)), N'070073f5-d290-4eb5-9f18-02f294f3fbf5.png                                                                                                                                                                                                                       ')
INSERT [dbo].[chi_tiet_sp] ([id], [id_sp], [id_nsx], [id_mau_sac], [id_dong_sp], [nam_bh], [mo_ta], [so_luong_ton], [gia_nhap], [gia_ban], [image]) VALUES (N'bb6228d8-cdf5-4332-b9fd-5970f5cd52d9', N'b2c9ef1c-a009-472a-b37a-511de397fa17', N'26edeb82-8020-4e6c-92a9-5a1c4b1f1b4c', N'5bc9dcb2-000b-46b6-8c94-557ed7d65251', N'766b5464-afa3-4106-81fc-7447734d3657', 2021, NULL, 12, CAST(132 AS Decimal(20, 0)), CAST(113 AS Decimal(20, 0)), N'5a3dc5f2-ff71-4b18-afec-5c41588f3263.png                                                                                                                                                                                                                       ')
GO
INSERT [dbo].[chuc_vu] ([id], [ma], [ten]) VALUES (N'ff9e5171-88ea-4c6a-b258-c9465a76ec0a', N'CV03', N'Phó giám Đốc')
INSERT [dbo].[chuc_vu] ([id], [ma], [ten]) VALUES (N'b075a122-b02d-481e-ba38-f5661e540c2b', N'CV01', N'Trưởng Phòng Vip')
GO
INSERT [dbo].[cua_hang] ([id], [ma], [ten], [dia_chi], [thanh_pho], [quoc_gia]) VALUES (N'00401583-21fa-46ef-be64-1c1c42b576f1', N'CH02', N'hung quanga', N'BacNinh', N'Bac Ninh City', N'VietNam')
GO
INSERT [dbo].[dong_sp] ([id], [ma], [ten], [ImageName]) VALUES (N'83583306-fd00-4834-936b-06a1ad51c3fc', N'DongSP04', N'Đồ Ăn', N'3c6f51c8-85e7-4314-bede-6f02fb2dbb57.png')
INSERT [dbo].[dong_sp] ([id], [ma], [ten], [ImageName]) VALUES (N'766b5464-afa3-4106-81fc-7447734d3657', N'DongSP05', N'Gỗ', N'82f45b9e-6451-4a07-9711-02bd8fc98530.png')
INSERT [dbo].[dong_sp] ([id], [ma], [ten], [ImageName]) VALUES (N'e9c5fde5-d87c-40e3-a7a4-a902299c8aec', N'DongSP03', N'Quần Áo', N'e97c8779-ddba-4880-84a1-7ee553f70759.png')
INSERT [dbo].[dong_sp] ([id], [ma], [ten], [ImageName]) VALUES (N'10a17b05-a2bd-4eda-8a8f-ad3e0e4f7dcd', N'DongSP01', N'Điện Thoại', N'439dceee-396b-4378-a363-3db98ed09e5e.png')
INSERT [dbo].[dong_sp] ([id], [ma], [ten], [ImageName]) VALUES (N'125d59e9-0907-4637-a154-bf4836e93fb9', N'DongSP02', N'Đồ Uống', N'dc6b5855-6422-4ef7-996a-121a71ff4a4b.png')
GO
INSERT [dbo].[gio_hang] ([id], [id_kh], [id_nv], [ma], [ngay_tao], [ngay_thanh_toan], [ten_nguoi_nhan], [dia_chi], [sdt], [tinh_trang], [checked]) VALUES (N'103098c9-5b69-4882-b8da-e494f36dc792', N'a307fdc7-2c84-4d3d-abb4-43757da88f34', NULL, N'KH06GH', CAST(N'2023-10-07' AS Date), NULL, N'Ð? H?ng Phúc', N'Nam Ð?nh', N'0962823303', 0, NULL)
GO
INSERT [dbo].[gio_hang_chi_tiet] ([id_gio_hang], [id_chi_tiet_sp], [so_luong], [don_gia], [don_gia_khi_giam], [checked]) VALUES (N'103098c9-5b69-4882-b8da-e494f36dc792', N'98d17361-d799-441d-b3e1-48921bb839fa', 6, CAST(792 AS Decimal(20, 0)), CAST(0 AS Decimal(20, 0)), 0)
GO
INSERT [dbo].[hoa_don] ([id], [id_kh], [id_nv], [ma], [ngay_tao], [ngay_thanh_toan], [ngay_ship], [ngay_nhan], [tinh_trang], [ten_nguoi_nhan], [dia_chi], [sdt]) VALUES (N'db4a4fc6-2a0f-44a3-bcf7-063458ed0375', N'a307fdc7-2c84-4d3d-abb4-43757da88f34', NULL, N'HD01', NULL, NULL, NULL, CAST(N'2023-10-08' AS Date), 0, N'Ð? H?ng Phúc', N'Nam Ð?nh', N'0962823303')
INSERT [dbo].[hoa_don] ([id], [id_kh], [id_nv], [ma], [ngay_tao], [ngay_thanh_toan], [ngay_ship], [ngay_nhan], [tinh_trang], [ten_nguoi_nhan], [dia_chi], [sdt]) VALUES (N'fdd60a86-9ea6-4b7d-9fa4-4d3666d509d4', N'a307fdc7-2c84-4d3d-abb4-43757da88f34', NULL, N'HD02', NULL, NULL, NULL, CAST(N'2023-10-08' AS Date), 0, N'Ð? H?ng Phúc', N'Nam Ð?nh', N'0962823303')
GO
INSERT [dbo].[hoa_don_chi_tiet] ([id_hoa_don], [id_chi_tiet_sp], [so_luong], [don_gia]) VALUES (N'db4a4fc6-2a0f-44a3-bcf7-063458ed0375', N'98d17361-d799-441d-b3e1-48921bb839fa', 6, CAST(792 AS Decimal(20, 0)))
INSERT [dbo].[hoa_don_chi_tiet] ([id_hoa_don], [id_chi_tiet_sp], [so_luong], [don_gia]) VALUES (N'db4a4fc6-2a0f-44a3-bcf7-063458ed0375', N'bb6228d8-cdf5-4332-b9fd-5970f5cd52d9', 1, CAST(113 AS Decimal(20, 0)))
GO
INSERT [dbo].[khach_hang] ([id], [ma], [ten], [ten_dem], [ho], [ngay_sinh], [sdt], [dia_chi], [thanh_pho], [quoc_gia], [mat_khau], [image]) VALUES (N'a307fdc7-2c84-4d3d-abb4-43757da88f34', N'KH06', N'Phúc', N'H?ng', N'Ð?', CAST(N'2003-08-03' AS Date), N'0962823303', N'Nam Ð?nh', NULL, NULL, N'11', NULL)
INSERT [dbo].[khach_hang] ([id], [ma], [ten], [ten_dem], [ho], [ngay_sinh], [sdt], [dia_chi], [thanh_pho], [quoc_gia], [mat_khau], [image]) VALUES (N'15232849-6b8a-4dc1-bfbc-9ceb251fa1d3', N'KH05', N'Phúc', N'H?ng', N'Ð?', CAST(N'2003-08-03' AS Date), N'0962823303', N'Nam Ð?nh', NULL, NULL, N'11', NULL)
INSERT [dbo].[khach_hang] ([id], [ma], [ten], [ten_dem], [ho], [ngay_sinh], [sdt], [dia_chi], [thanh_pho], [quoc_gia], [mat_khau], [image]) VALUES (N'848da39b-0d5c-4c40-87de-a39cd3be3c5b', N'KH04', N'M?nh', N'Van', N'Nguy?n', CAST(N'2003-08-03' AS Date), N'0962823303', N'BacNinh', NULL, NULL, N'11', NULL)
INSERT [dbo].[khach_hang] ([id], [ma], [ten], [ten_dem], [ho], [ngay_sinh], [sdt], [dia_chi], [thanh_pho], [quoc_gia], [mat_khau], [image]) VALUES (N'b7afca1d-3949-4cf7-b73c-a9acddcb8425', N'KH02', N'Huy?n', N'Thanh', N'Ðoàn', CAST(N'2003-08-03' AS Date), N'0962823303', N'BacNinh', NULL, NULL, N'11', NULL)
INSERT [dbo].[khach_hang] ([id], [ma], [ten], [ten_dem], [ho], [ngay_sinh], [sdt], [dia_chi], [thanh_pho], [quoc_gia], [mat_khau], [image]) VALUES (N'c90f24a4-f223-49f0-a42b-b31a86a302ab', N'KH01', N'Hung', N'Quang', N'Lê', CAST(N'2003-08-10' AS Date), N'0962823303', N'BacNinh', NULL, NULL, N'11', NULL)
INSERT [dbo].[khach_hang] ([id], [ma], [ten], [ten_dem], [ho], [ngay_sinh], [sdt], [dia_chi], [thanh_pho], [quoc_gia], [mat_khau], [image]) VALUES (N'31f63fcd-cf3d-4d02-8926-cc38d348e54f', N'KH03', N'Kh?i', N'Quang', N'Tr?n', CAST(N'2003-08-03' AS Date), N'0962823303', N'BacNinh', NULL, NULL, N'11', NULL)
GO
INSERT [dbo].[mau_sac] ([id], [ma], [ten]) VALUES (N'f6bb1959-2bd6-4287-94d8-010a2703cef1', N'MS01', N'Vàng Cứt')
INSERT [dbo].[mau_sac] ([id], [ma], [ten]) VALUES (N'5bc9dcb2-000b-46b6-8c94-557ed7d65251', N'MS03', N'Tím Mộng Mơ')
INSERT [dbo].[mau_sac] ([id], [ma], [ten]) VALUES (N'2f5169fe-1d80-435d-9780-612738ea52d2', N'MS02', N'Xanh')
INSERT [dbo].[mau_sac] ([id], [ma], [ten]) VALUES (N'3e11dc22-b20b-45cc-bb68-66021a6113f0', N'MS07', N'Xanh Dương')
INSERT [dbo].[mau_sac] ([id], [ma], [ten]) VALUES (N'64fefe23-5112-4694-8cbb-6e9d74f66eae', N'MS04', N'Hồng Cá Tính')
INSERT [dbo].[mau_sac] ([id], [ma], [ten]) VALUES (N'223c81a2-1822-4449-9f3b-b540bcd1f54d', N'MS06', N'ĐỎ')
GO
INSERT [dbo].[nhan_vien] ([id], [ma], [ten], [ten_dem], [ho], [gioi_tinh], [ngay_sinh], [dia_chi], [sdt], [mat_khau], [id_ch], [id_cv], [id_gui_bc], [trang_thai]) VALUES (N'0920c2bb-d2ca-4fd1-b11f-0598d735b39c', N'NV01', N'Hung', N'Quang', N'Le', N'Nam', CAST(N'2003-08-10' AS Date), N'Bac Ninh', N'0962823303', NULL, NULL, NULL, NULL, 0)
INSERT [dbo].[nhan_vien] ([id], [ma], [ten], [ten_dem], [ho], [gioi_tinh], [ngay_sinh], [dia_chi], [sdt], [mat_khau], [id_ch], [id_cv], [id_gui_bc], [trang_thai]) VALUES (N'37e78ca8-aa8f-4f66-9758-c140e72eead2', N'NV02', N'Khai', N'Văn', N'Tran', N'Nữ', CAST(N'2002-09-02' AS Date), N'Lai Chau 98', N'0962823303', NULL, NULL, NULL, NULL, 1)
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
/****** Object:  Index [UQ__chuc_vu__3213C8B6A5D62388]    Script Date: 10/8/2023 3:00:20 PM ******/
ALTER TABLE [dbo].[chuc_vu] ADD UNIQUE NONCLUSTERED 
(
	[ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__cua_hang__3213C8B6B63B902A]    Script Date: 10/8/2023 3:00:20 PM ******/
ALTER TABLE [dbo].[cua_hang] ADD UNIQUE NONCLUSTERED 
(
	[ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__dong_sp__3213C8B69424AB9A]    Script Date: 10/8/2023 3:00:20 PM ******/
ALTER TABLE [dbo].[dong_sp] ADD UNIQUE NONCLUSTERED 
(
	[ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__gio_hang__3213C8B6CD9B079B]    Script Date: 10/8/2023 3:00:20 PM ******/
ALTER TABLE [dbo].[gio_hang] ADD UNIQUE NONCLUSTERED 
(
	[ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__hoa_don__3213C8B6075015D0]    Script Date: 10/8/2023 3:00:20 PM ******/
ALTER TABLE [dbo].[hoa_don] ADD UNIQUE NONCLUSTERED 
(
	[ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__khach_ha__3213C8B6FD99A307]    Script Date: 10/8/2023 3:00:20 PM ******/
ALTER TABLE [dbo].[khach_hang] ADD UNIQUE NONCLUSTERED 
(
	[ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__mau_sac__3213C8B632B41ACE]    Script Date: 10/8/2023 3:00:20 PM ******/
ALTER TABLE [dbo].[mau_sac] ADD UNIQUE NONCLUSTERED 
(
	[ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__nhan_vie__3213C8B6E253D68B]    Script Date: 10/8/2023 3:00:20 PM ******/
ALTER TABLE [dbo].[nhan_vien] ADD UNIQUE NONCLUSTERED 
(
	[ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__nxs__3213C8B6848C8C8C]    Script Date: 10/8/2023 3:00:20 PM ******/
ALTER TABLE [dbo].[nxs] ADD UNIQUE NONCLUSTERED 
(
	[ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__san_pham__3213C8B6D83C25F4]    Script Date: 10/8/2023 3:00:20 PM ******/
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
ON DELETE SET NULL
GO
ALTER TABLE [dbo].[chi_tiet_sp]  WITH CHECK ADD FOREIGN KEY([id_mau_sac])
REFERENCES [dbo].[mau_sac] ([id])
ON DELETE SET NULL
GO
ALTER TABLE [dbo].[chi_tiet_sp]  WITH CHECK ADD FOREIGN KEY([id_nsx])
REFERENCES [dbo].[nxs] ([id])
ON DELETE SET NULL
GO
ALTER TABLE [dbo].[chi_tiet_sp]  WITH CHECK ADD FOREIGN KEY([id_sp])
REFERENCES [dbo].[san_pham] ([id])
ON DELETE SET NULL
GO
ALTER TABLE [dbo].[gio_hang]  WITH CHECK ADD FOREIGN KEY([id_kh])
REFERENCES [dbo].[khach_hang] ([id])
ON DELETE SET NULL
GO
ALTER TABLE [dbo].[gio_hang_chi_tiet]  WITH CHECK ADD  CONSTRAINT [FK1_IdGioHang] FOREIGN KEY([id_gio_hang])
REFERENCES [dbo].[gio_hang] ([id])
GO
ALTER TABLE [dbo].[gio_hang_chi_tiet] CHECK CONSTRAINT [FK1_IdGioHang]
GO
ALTER TABLE [dbo].[gio_hang_chi_tiet]  WITH CHECK ADD  CONSTRAINT [FK2_IdChiTietSP] FOREIGN KEY([id_chi_tiet_sp])
REFERENCES [dbo].[chi_tiet_sp] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[hoa_don_chi_tiet]  WITH CHECK ADD  CONSTRAINT [FK2_HDCTIdChiTietSP] FOREIGN KEY([id_chi_tiet_sp])
REFERENCES [dbo].[chi_tiet_sp] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[hoa_don_chi_tiet]  WITH CHECK ADD  CONSTRAINT [FK2_HDCTsp] FOREIGN KEY([id_hoa_don])
REFERENCES [dbo].[hoa_don] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[gio_hang_chi_tiet] CHECK CONSTRAINT [FK2_IdChiTietSP]
GO
ALTER TABLE [dbo].[hoa_don]  WITH CHECK ADD FOREIGN KEY([id_kh])
REFERENCES [dbo].[khach_hang] ([id])
GO
ALTER TABLE [dbo].[hoa_don]  WITH CHECK ADD FOREIGN KEY([id_nv])
REFERENCES [dbo].[nhan_vien] ([id])
GO
ALTER TABLE [dbo].[nhan_vien]  WITH CHECK ADD FOREIGN KEY([id_ch])
REFERENCES [dbo].[cua_hang] ([id])
ON DELETE SET NULL
GO
ALTER TABLE [dbo].[nhan_vien]  WITH CHECK ADD FOREIGN KEY([id_cv])
REFERENCES [dbo].[chuc_vu] ([id])
ON DELETE SET NULL
GO
ALTER TABLE [dbo].[nhan_vien]  WITH CHECK ADD  CONSTRAINT [FK1] FOREIGN KEY([id_gui_bc])
REFERENCES [dbo].[nhan_vien] ([id])
GO
ALTER TABLE [dbo].[nhan_vien] CHECK CONSTRAINT [FK1]
GO
/****** Object:  Trigger [dbo].[tr_generate_hoa_don_ma]    Script Date: 10/8/2023 3:00:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

-- Create the trigger
CREATE TRIGGER [dbo].[tr_generate_hoa_don_ma]
ON [dbo].[hoa_don]
AFTER INSERT
AS
BEGIN
    DECLARE @MaxMaValue INT
    DECLARE @NewMaValue VARCHAR(20)
    
    -- Find the maximum existing ma value
    SELECT @MaxMaValue = MAX(CAST(SUBSTRING([ma], 3, LEN([ma]) - 2) AS INT))
    FROM [dbo].[hoa_don]
    
    -- Check if there are any existing records
    IF @MaxMaValue IS NULL
        SET @MaxMaValue = 0

    -- Increment the max value by 1
    SET @MaxMaValue = @MaxMaValue + 1

    -- Create the new ma value
    SET @NewMaValue = 'HD' + RIGHT('00' + CAST(@MaxMaValue AS VARCHAR(2)), 2)

    -- Update the inserted rows with the new ma value
    UPDATE [dbo].[hoa_don]
    SET [ma] = @NewMaValue
    FROM [dbo].[hoa_don]
    INNER JOIN inserted ON [dbo].[hoa_don].[id] = inserted.[id]
END
GO
ALTER TABLE [dbo].[hoa_don] ENABLE TRIGGER [tr_generate_hoa_don_ma]
GO
USE [master]
GO
ALTER DATABASE [FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041] SET  READ_WRITE 
GO
