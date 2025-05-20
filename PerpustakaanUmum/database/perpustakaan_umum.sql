-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 20, 2025 at 04:22 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.3.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `perpustakaan_umum`
--

-- --------------------------------------------------------

--
-- Table structure for table `buku`
--

CREATE TABLE `buku` (
  `id` int(11) NOT NULL,
  `judul` varchar(50) NOT NULL,
  `genre` varchar(25) NOT NULL,
  `penulis` varchar(50) NOT NULL,
  `penerbit` varchar(50) NOT NULL,
  `lokasi` varchar(20) NOT NULL,
  `stock` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `buku`
--

INSERT INTO `buku` (`id`, `judul`, `genre`, `penulis`, `penerbit`, `lokasi`, `stock`) VALUES
(1, 'Bumi', 'Fantasi', 'Tereliye', 'Gramedia', 'LT 1', 3),
(2, 'Bulan', 'Action', 'Tereliye', 'Gramedia', 'LT 2', 2),
(4, 'Matahari', 'Action', 'Tereliye', 'Gramedia', 'LT 3', 2),
(5, 'Laskar Pelangi', 'Drama, Pendidikan', 'Andrea Hirata', 'Bentang Pustaka', 'LT 1', 2),
(6, 'Ayat - Ayat Cinta', 'Romantis, Religi', 'Habiburrahman El Shirazy', 'Republika', 'LT 1', 1),
(7, 'Negeri 5 Menara', 'Drama, Motivasi', 'Ahmad Fuadi', 'Gramedia Pustaka Utama', 'LT 2', 3),
(8, 'Dilan: Dia adalah Dilanku 1990', 'Romantis', 'Pidi Baiq', 'Pastel Books', 'LT 3', 3),
(9, 'Perahu Kertas', 'Romantis, Drama', 'Dee Lestari', 'Bentang Pustaka', 'LT 2', 4),
(10, 'Hujan', 'Drama, Fantasi', 'Tere Liye', 'Gramedia Pustaka Utama', 'LT 1', 2),
(11, 'Pulang', 'Drama, Thriller', 'Tere Liye', 'Republika', 'LT 1', 2),
(12, 'Laut Bercerita', 'Drama, Sosial', 'Leila S. Chudori', 'KPG (Kepustakaan Populer Gramedia)', 'LT 3', 1),
(13, 'Ganjil Genap', 'Komedi Romantis', 'Almira Bastari', 'Gramedia Pustaka Utama', 'LT 1', 2),
(14, 'Dunia Sophie', 'Filsafat, Fiksi', 'Jostein Gaarder', 'Mizan', 'LT 2', 1),
(15, 'Sang Pemimpi', 'Drama, Pendidikan', 'Andrea Hirata', 'Bentang Pustaka', 'LT 1', 3),
(16, 'Jejak Langkah', 'Sejarah, Nasionalisme', 'Pramoedya Ananta Toer', 'Hasta Mitra', 'LT 4', 2),
(17, 'Kerumunan Terakhir', 'Distopia', 'Okky Madasari', 'Gramedia', 'LT 4', 1),
(18, 'Notasi', 'Musik, Romantis', 'Morra Quatro', 'Bentang Belia', 'LT 2', 2),
(19, 'Entrok', 'Sosial, Perempuan', 'Okky Madasari', 'Gramedia', 'LT 3', 2),
(20, 'Di Tanah Lada', 'Drama Sosial', 'Ziggy Zezsyazeoviennazabrizkie', 'Gramedia', 'LT 4', 1),
(21, '5 cm', 'Petualangan, Motivasi', 'Donny Dhirgantoro', 'Grasindo', 'LT 1', 2),
(22, 'The Alchemist', 'Fantasi, Filsafat', 'Paulo Coelho', 'HarperOne', 'LT 4', 3),
(23, 'Gadis Kretek', 'Fiksi Historis', 'Ratih Kumala', 'Gramedia', 'LT 4', 2),
(24, 'Sehidup Sesurga', 'Romantis Islami', 'Natta Reza & Wardah Maulina', 'Salsabila', 'LT 4', 3),
(25, 'Rumah Kaca', 'Sejarah, Politik', 'Pramoedya Ananta Toer', 'Hasta Mitra', 'LT 4', 2),
(26, 'Si Barista', 'Drama, Psikologi', 'Ali', 'Mizan', 'LT 1', 4);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `buku`
--
ALTER TABLE `buku`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `buku`
--
ALTER TABLE `buku`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
