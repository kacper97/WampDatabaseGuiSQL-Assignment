-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Oct 09, 2018 at 11:35 PM
-- Server version: 5.7.23
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `test`
--

-- --------------------------------------------------------

--
-- Table structure for table `jdbc_test`
--

DROP TABLE IF EXISTS `jdbc_test`;
CREATE TABLE IF NOT EXISTS `jdbc_test` (
  `id` int(10) NOT NULL,
  `DOB` varchar(10) NOT NULL,
  `Name` varchar(10) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `Salary` int(11) NOT NULL,
  `Gender` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jdbc_test`
--

INSERT INTO `jdbc_test` (`id`, `DOB`, `Name`, `Address`, `Salary`, `Gender`) VALUES
(1, '1996-06-03', 'Michela', '10 Rodny Street Bratislava', 30000, 'Female'),
(4, '1998-10-2', 'Fiona', '4 City Lane', 41000, 'Female'),
(3, '1995-1-30', 'John', '10 Strand Road', 24000, 'Male'),
(2, '1997-11-19', 'Kacper', '9 Aylesbury Avenue Belmont Road', 50000, 'Male'),
(5, '1974-6-09', 'Monika', '10 Krakow Road', 34000, 'Female'),
(6, '1967-11-21', 'Alan', '10 Sandy Road', 60000, 'Male');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
