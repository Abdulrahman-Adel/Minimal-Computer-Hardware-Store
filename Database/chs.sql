-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3308
-- Generation Time: Jul 15, 2021 at 10:36 PM
-- Server version: 5.7.31
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `chs`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `Admin_ID` varchar(256) NOT NULL,
  `Email` varchar(256) DEFAULT NULL,
  `Password` varchar(256) DEFAULT NULL,
  `Full_Name` varchar(256) DEFAULT NULL,
  `Salary` double NOT NULL,
  PRIMARY KEY (`Admin_ID`),
  UNIQUE KEY `Email` (`Email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`Admin_ID`, `Email`, `Password`, `Full_Name`, `Salary`) VALUES
('02113ec9-2536-4174-acf0-93350bdb5ee1', 'bedo.adel06@gmail.com', 'Abdo022012$', 'Abdulrahman', 1550),
('180f969a-18f0-40d6-8d16-0bf7e26bce51', 'Osama.mohamed@gmail.com', 'Osama033013$', 'Abdulla Osama', 1550);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `Customer_ID` varchar(256) NOT NULL,
  `Full_Name` varchar(256) NOT NULL,
  `Email` varchar(256) NOT NULL,
  `Password` varchar(256) NOT NULL,
  `Address` varchar(256) NOT NULL,
  `PhoneNum` varchar(11) NOT NULL,
  PRIMARY KEY (`Customer_ID`),
  UNIQUE KEY `Email` (`Email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`Customer_ID`, `Full_Name`, `Email`, `Password`, `Address`, `PhoneNum`) VALUES
('8c10dca2-2373-45f8-ba90-9ab3fa8a4fb4', 'Abdulrahman Adel', 'bedo.adel06@gmail.com', 'Abdo022012$', 'Al Amal,Faisal,Cairo', '01146631026');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
CREATE TABLE IF NOT EXISTS `orders` (
  `Order_ID` varchar(256) NOT NULL,
  `Customer_ID` varchar(256) NOT NULL,
  `Full_Price` double NOT NULL,
  `Date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Shipping_Address` varchar(256) NOT NULL,
  `Product_List_ID` varchar(256) NOT NULL,
  `Payment_Method` varchar(256) NOT NULL,
  `Customer_Feedback` text,
  PRIMARY KEY (`Order_ID`),
  UNIQUE KEY `Product_List_ID` (`Product_List_ID`),
  KEY `Customer_ID` (`Customer_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`Order_ID`, `Customer_ID`, `Full_Price`, `Date`, `Shipping_Address`, `Product_List_ID`, `Payment_Method`, `Customer_Feedback`) VALUES
('015c7a11-5d6c-4699-a164-c0d8b6e37084', '8c10dca2-2373-45f8-ba90-9ab3fa8a4fb4', 676.5, '2021-07-14 01:36:32', 'Al Amal,Faisal,Cairo', '77373dd3-4ff2-4e56-ac84-19ac565f1cce', 'Cash,	676.5 L.E', 'Thanks'),
('261782a2-5b4b-48eb-8982-84442d0f4196', '8c10dca2-2373-45f8-ba90-9ab3fa8a4fb4', 1725.5, '2021-07-14 01:29:31', 'Al Amal,Faisal,Cairo', '17926fca-7dd6-414e-b7fc-41900ac56378', 'Cash,	1725.5 L.E', 'It was pleasant'),
('d71fe611-3466-4ea3-9137-d4bc8e7a69fc', '8c10dca2-2373-45f8-ba90-9ab3fa8a4fb4', 225.5, '2021-07-14 11:24:13', 'Al Amal,Faisal,Cairo', '7a2235f9-c189-425c-9e07-133befacd5dd', 'Cash,	225.5 L.E', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `Product_ID` varchar(256) NOT NULL,
  `Product_Name` varchar(256) NOT NULL,
  `Price` double NOT NULL,
  `Category` varchar(256) NOT NULL,
  `Company` varchar(256) NOT NULL,
  `Description` mediumtext NOT NULL,
  `Admin_ID` varchar(256) DEFAULT NULL,
  `ImagePath` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`Product_ID`),
  KEY `Admin_ID` (`Admin_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`Product_ID`, `Product_Name`, `Price`, `Category`, `Company`, `Description`, `Admin_ID`, `ImagePath`) VALUES
('0da3fe43-657f-44b5-91bd-1f49b3e837fd', 'Monitor_1', 1500, 'Monitors', 'Apple', '14-inch Screen, 4K resolution', '180f969a-18f0-40d6-8d16-0bf7e26bce51', 'monitor_1.jpg'),
('25e66fc4-cf67-4ec8-9f06-5cc1f096c35e', 'Intel core-i7', 225.5, 'CPUs', 'Intel', 'Sate-of-the-art Cpu That is capable of speed processing', '180f969a-18f0-40d6-8d16-0bf7e26bce51', 'C:\\images\\CPU_INTEL.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `product_list`
--

DROP TABLE IF EXISTS `product_list`;
CREATE TABLE IF NOT EXISTS `product_list` (
  `Product_List_ID` varchar(256) NOT NULL,
  `Product_ID` varchar(256) NOT NULL,
  `Quantity` int(11) NOT NULL,
  KEY `Product_ID` (`Product_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product_list`
--

INSERT INTO `product_list` (`Product_List_ID`, `Product_ID`, `Quantity`) VALUES
('17926fca-7dd6-414e-b7fc-41900ac56378', '0da3fe43-657f-44b5-91bd-1f49b3e837fd', 1),
('17926fca-7dd6-414e-b7fc-41900ac56378', '25e66fc4-cf67-4ec8-9f06-5cc1f096c35e', 1),
('77373dd3-4ff2-4e56-ac84-19ac565f1cce', '25e66fc4-cf67-4ec8-9f06-5cc1f096c35e', 3),
('7a2235f9-c189-425c-9e07-133befacd5dd', '25e66fc4-cf67-4ec8-9f06-5cc1f096c35e', 1);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`Customer_ID`) REFERENCES `customer` (`Customer_ID`);

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`Admin_ID`) REFERENCES `admin` (`Admin_ID`);

--
-- Constraints for table `product_list`
--
ALTER TABLE `product_list`
  ADD CONSTRAINT `product_list_ibfk_2` FOREIGN KEY (`Product_ID`) REFERENCES `product` (`Product_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
