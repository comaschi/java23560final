-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: db
-- Generation Time: Dec 13, 2023 at 07:04 PM
-- Server version: 8.0.33
-- PHP Version: 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `oradoresDB`
--

-- --------------------------------------------------------

--
-- Table structure for table `oradores`
--

CREATE TABLE `oradores` (
  `id` int NOT NULL,
  `nombre` varchar(40) DEFAULT NULL,
  `apellido` varchar(40) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  `tema` varchar(255) DEFAULT NULL,
  `fechaCreacion` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `imagen` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `oradores`
--

INSERT INTO `oradores` (`id`, `nombre`, `apellido`, `email`, `tema`, `fechaCreacion`, `imagen`) VALUES
(34, 'Diego', 'Comaschi', 'Comn@asdas', 'Presentacion trabajo Final', '2023-12-12 00:00:00', 'null'),
(35, 'Hernan', 'Comaschi', 'HCsd@Sysem.com', 'Introduccion al JavaScrip', '2023-12-12 00:00:00', 'null'),
(53, 'Martin ', 'Luther King', 'King@hotmail.com', 'Next civil rights', '2023-12-13 00:00:00', 'null'),
(54, 'Jose', 'San Martin', 'boulogne@sudmer.com', 'Cruzada a la cordillera', '2023-12-13 00:00:00', 'null'),
(55, 'Jorge', 'Sabato', 'Sabato@edicion.com', 'Como escribir un libro\r\n', '2023-12-13 00:00:00', 'null'),
(56, 'Rene', 'Favaloro', 'Favloro@gmail.com', 'Hablemos a corazon abierto', '2023-12-13 00:00:00', 'null');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `oradores`
--
ALTER TABLE `oradores`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `oradores`
--
ALTER TABLE `oradores`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
