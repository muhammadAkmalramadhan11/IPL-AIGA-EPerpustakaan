-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 07, 2022 at 04:39 AM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 8.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `perpustakaan`
--

-- --------------------------------------------------------

--
-- Table structure for table `anggota`
--

CREATE TABLE `anggota` (
  `ID_Anggota` char(10) NOT NULL,
  `Nama` varchar(20) NOT NULL,
  `Jenis_Kelamin` varchar(15) NOT NULL,
  `Alamat` varchar(50) NOT NULL,
  `No_HP` varchar(12) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Tgl_Entry` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `anggota`
--

INSERT INTO `anggota` (`ID_Anggota`, `Nama`, `Jenis_Kelamin`, `Alamat`, `No_HP`, `Email`, `Tgl_Entry`) VALUES
('A0001', 'Ratna', 'Perempuan', 'Cililin', '0866666667', 'ratna12@gmail.com', '2021-12-01'),
('A0002', 'Supra', 'Laki - Laki', 'Padalarang', '0852676312', 'supra12@gmail.com', '2021-12-02'),
('A0003', 'Mio', 'Perempuan', 'Leuwigajah', '0873214313', 'Mio90@gmail.com', '2021-12-03'),
('A0004', 'Maha', 'Perempuan', 'Kabupaten Bandung Barat', '0863782132', 'mahaS@yahoo.com', '2021-12-04'),
('A0005', 'Danil', 'Laki - Laki', 'Cibodas', '0843829284', 'Danil02@gmail.com', '2021-12-05'),
('A0006', 'Alfa', 'Perempuan', 'Ngamprah', '0836271814', 'AF09@gmaill.com', '2021-12-06'),
('A0007', 'Udin', 'Laki - Laki', 'Cilame Indah', '085861298186', 'Udin0902@gmail.com', '2021-12-07'),
('A0008', 'Indira', 'Perempuan', 'Cisarua', '0832819435', 'Indirasyifa@upi.edu', '2021-12-08'),
('A0009', 'Talithaaaur', 'Perempuan', 'Setiabudi', '085328932', 'Talitha01@gmail.com', '2021-12-09'),
('A0010', 'Dinda', 'Perempuan', 'Gegerkalong', '0843278264', 'dinrizka1@gmail.com', '2021-12-10'),
('A0011', 'GhinaS', 'Perempuan', 'Cimindi', '0846378134', 'GhinaS01@gmail.com', '2021-12-11'),
('A0012', 'Zahwa', 'Perempuan', 'Cimindi', '0847327913', 'Zwh89@gmail.com', '2021-12-12'),
('A0013', 'Aika', 'Perempuan', 'Tokyo', '438478925', 'AikaY@gmail.com', '2021-12-13'),
('A0014', 'Fuka', 'Perempuan', 'Kyoto', '364781264', 'FukaA@gmail.com', '2021-12-14'),
('A0015', 'Unmei', 'Perempuan', 'Las Vegas', '8743891248', 'Unmei@gmail.com', '2021-12-15'),
('A0016', 'Sebastian', 'Laki - Laki', 'Cilame Indah', '08582317463', 'Sbs90@gmail.com', '2021-12-16'),
('A0017', 'Joseph', 'Laki - Laki', 'Padalarang', '08432784681', 'Jsp091@gmail.com', '2021-12-17'),
('A0018', 'Kidman', 'Perempuan', 'Ciremai', '084637721', 'Km88@gmail.com', '2021-12-18'),
('A0019', 'Slyphie', 'Perempuan', 'Kebonkopi', '084673813', 'Phie341@gmail.com', '2021-12-19'),
('A0020', 'Rudeus Fs', 'Laki - Laki', 'Cisarua', '084738264', 'Rudi20@gmail.com', '2021-12-20');

-- --------------------------------------------------------

--
-- Table structure for table `buku`
--

CREATE TABLE `buku` (
  `ID_Buku` char(5) NOT NULL,
  `Jenis_Buku` char(5) NOT NULL,
  `Nama_Buku` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `buku`
--

INSERT INTO `buku` (`ID_Buku`, `Jenis_Buku`, `Nama_Buku`) VALUES
('1', '1', 'Struktur Data'),
('2', '1', 'Matematika Diskrit'),
('3', '5', 'Bulan'),
('4', '1', 'Fisika'),
('5', '1', 'Kimia');

-- --------------------------------------------------------

--
-- Table structure for table `description`
--

CREATE TABLE `description` (
  `ID_Desc` char(5) NOT NULL,
  `Jenis Buku` char(5) NOT NULL,
  `Deskripsi` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `description`
--

INSERT INTO `description` (`ID_Desc`, `Jenis Buku`, `Deskripsi`) VALUES
('1', '1', 'Berisi sebuah Fakta yang ada dan dapat dijadikan sebuah pelajaran'),
('2', '2', 'Berisi sebuah cerita atau sejarah yang terjadi secara nyata'),
('3', '3', 'Berisi sebuah cerita, dongeng, atau sejarah yang tidak terjadi secara nyata'),
('4', '4', 'Berisi sebuah referensi atau rangkuman dari informasi cabang pendidikan'),
('5', '5', 'Berisi sebuah cerita dapat terjadi secara nyata ataupun tidak');

-- --------------------------------------------------------

--
-- Table structure for table `jenis_buku`
--

CREATE TABLE `jenis_buku` (
  `ID_Jenis` char(5) NOT NULL,
  `Jenis Buku` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `jenis_buku`
--

INSERT INTO `jenis_buku` (`ID_Jenis`, `Jenis Buku`) VALUES
('1', 'Pendidikan'),
('2', 'Non-Fiksi'),
('3', 'Fiksi'),
('4', 'Insiklopedia'),
('5', 'Novel');

-- --------------------------------------------------------

--
-- Table structure for table `penerbit`
--

CREATE TABLE `penerbit` (
  `ID_Penerbit` char(5) NOT NULL,
  `Nama Penerbit` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `penerbit`
--

INSERT INTO `penerbit` (`ID_Penerbit`, `Nama Penerbit`) VALUES
('1', 'PT Wijaya'),
('2', 'PT Garuda Indonesia'),
('3', 'PT Gramedia'),
('4', 'Erlangga'),
('5', 'Bentang');

-- --------------------------------------------------------

--
-- Table structure for table `penulis`
--

CREATE TABLE `penulis` (
  `ID_Penulis` char(5) NOT NULL,
  `Penulis` varchar(30) NOT NULL,
  `Jenis_Kelamin` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `penulis`
--

INSERT INTO `penulis` (`ID_Penulis`, `Penulis`, `Jenis_Kelamin`) VALUES
('00001', 'Ahmad', 'L'),
('00002', 'Asep', 'L'),
('3', 'Tere  Liye', 'P'),
('4', 'Ripandi', 'L'),
('5', 'Supriandi', 'L');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `ID_Transaksi` char(5) NOT NULL,
  `ID_Buku` char(5) NOT NULL,
  `ID_Jenis` char(5) NOT NULL,
  `ID_Penulis` char(5) NOT NULL,
  `ID_Penerbit` char(5) NOT NULL,
  `ID_Desc` char(5) NOT NULL,
  `Tanggal` date NOT NULL,
  `Keterangan` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`ID_Transaksi`, `ID_Buku`, `ID_Jenis`, `ID_Penulis`, `ID_Penerbit`, `ID_Desc`, `Tanggal`, `Keterangan`) VALUES
('1', '1', '1', '00001', '1', '1', '2021-12-01', 'Terima kasih Atas Pembelian'),
('2', '2', '1', '00002', '2', '2', '2021-12-02', 'Terima kasih Atas Pembelian'),
('3', '5', '3', '3', '3', '3', '2021-12-03', 'Terima kasih Atas Pembelian'),
('4', '4', '1', '4', '4', '4', '2021-12-04', 'Terima kasih Atas Pembelian'),
('5', '5', '1', '5', '5', '5', '2021-12-05', 'Terima kasih Atas Pembelian');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `anggota`
--
ALTER TABLE `anggota`
  ADD PRIMARY KEY (`ID_Anggota`);

--
-- Indexes for table `buku`
--
ALTER TABLE `buku`
  ADD PRIMARY KEY (`ID_Buku`),
  ADD KEY `Jenis_Buku` (`Jenis_Buku`);

--
-- Indexes for table `description`
--
ALTER TABLE `description`
  ADD PRIMARY KEY (`ID_Desc`),
  ADD KEY `Jenis Buku` (`Jenis Buku`);

--
-- Indexes for table `jenis_buku`
--
ALTER TABLE `jenis_buku`
  ADD PRIMARY KEY (`ID_Jenis`);

--
-- Indexes for table `penerbit`
--
ALTER TABLE `penerbit`
  ADD PRIMARY KEY (`ID_Penerbit`);

--
-- Indexes for table `penulis`
--
ALTER TABLE `penulis`
  ADD PRIMARY KEY (`ID_Penulis`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`ID_Transaksi`),
  ADD KEY `ID_Buku` (`ID_Buku`),
  ADD KEY `ID_Jenis` (`ID_Jenis`),
  ADD KEY `ID_Penulis` (`ID_Penulis`),
  ADD KEY `ID_Penerbit` (`ID_Penerbit`),
  ADD KEY `ID_Desc` (`ID_Desc`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `buku`
--
ALTER TABLE `buku`
  ADD CONSTRAINT `fk_Buku_JenisBuku` FOREIGN KEY (`Jenis_Buku`) REFERENCES `jenis_buku` (`ID_Jenis`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `description`
--
ALTER TABLE `description`
  ADD CONSTRAINT `fk_Buku_Description` FOREIGN KEY (`Jenis Buku`) REFERENCES `buku` (`ID_Buku`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`ID_Buku`) REFERENCES `buku` (`ID_Buku`),
  ADD CONSTRAINT `transaksi_ibfk_2` FOREIGN KEY (`ID_Jenis`) REFERENCES `jenis_buku` (`ID_Jenis`),
  ADD CONSTRAINT `transaksi_ibfk_3` FOREIGN KEY (`ID_Penerbit`) REFERENCES `penerbit` (`ID_Penerbit`),
  ADD CONSTRAINT `transaksi_ibfk_4` FOREIGN KEY (`ID_Penulis`) REFERENCES `penulis` (`ID_Penulis`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
