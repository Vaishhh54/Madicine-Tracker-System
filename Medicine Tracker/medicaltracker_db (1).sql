-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 22, 2023 at 07:39 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `medicaltracker_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `ademail` varchar(50) NOT NULL,
  `adpassword` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`ademail`, `adpassword`) VALUES
('admin@gmail.com', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `medical_tbl`
--

CREATE TABLE `medical_tbl` (
  `mid` int(100) NOT NULL,
  `mname` varchar(100) NOT NULL,
  `memail` varchar(100) NOT NULL,
  `mpassword` varchar(100) NOT NULL,
  `mcontact` varchar(100) NOT NULL,
  `mliecence` varchar(100) NOT NULL,
  `lat` varchar(100) NOT NULL,
  `lng` varchar(100) NOT NULL,
  `mlocation` varchar(100) NOT NULL,
  `status` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `medical_tbl`
--

INSERT INTO `medical_tbl` (`mid`, `mname`, `memail`, `mpassword`, `mcontact`, `mliecence`, `lat`, `lng`, `mlocation`, `status`) VALUES
(2, 'Dipraj Medical', 'dip@gmail.com', '123456', '902199926', 'hyag7855shyiujs', '0', '0', 'chopda', 'Approve'),
(5, 'janavi medical', 'janavi@gmail.com', '123456', '4078965852', 'sdfghjkl', '20.448029328044896', '75.00520140152481', 'chalisgaon', 'Approve'),
(6, '628 Medicals', 'Jits@gmail.com', '123', '7858963325', 'sdrewggs8546', '19.99472438566395', '73.77392292022705', 'chopda', 'Approve'),
(8, 'Shri Ram Medical', 'ram@gmail.com', '123456', '7054896584', '457859665', '20.003704697997602', '73.79297873547364', 'katara', 'pending'),
(9, 'shiv', 'shiv@gmail.com', '123456', '7020789658', '78965145', '20.89029344272892', '74.77549821506902', 'hated', 'pending'),
(10, 'yakshi Medicals', 'yakshi@gmail.com', '123456', '7845996321', '788459655', '20.760732960250117', '73.4776678593106', 'pune', 'pending');

-- --------------------------------------------------------

--
-- Table structure for table `medicine_tbl`
--

CREATE TABLE `medicine_tbl` (
  `mdid` int(100) NOT NULL,
  `mdname` varchar(100) NOT NULL,
  `mdbrand` varchar(100) NOT NULL,
  `mdquantity` int(100) NOT NULL,
  `mgfdate` date NOT NULL,
  `mdexpiredate` date NOT NULL,
  `oneMonthBeforeDate` date NOT NULL,
  `mddiscount` int(100) NOT NULL,
  `mdprice` int(100) NOT NULL,
  `memail` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `medicine_tbl`
--

INSERT INTO `medicine_tbl` (`mdid`, `mdname`, `mdbrand`, `mdquantity`, `mgfdate`, `mdexpiredate`, `oneMonthBeforeDate`, `mddiscount`, `mdprice`, `memail`) VALUES
(1, 'aspirin', 'jhh', 45, '2023-07-05', '2023-07-31', '0000-00-00', 78, 100, ''),
(2, 'Aspirin', 'sunpharma', 500, '2023-06-26', '2023-11-23', '2023-10-23', 20, 123, ''),
(3, 'paracetomol', 'apollo', 250, '2023-01-02', '2023-07-06', '2023-06-06', 14, 70, 'shiv@gmail.com'),
(4, 'Crocin', 'sunpharma', 250, '2023-02-02', '2023-06-27', '2023-05-27', 14, 120, 'ram@gmail.com'),
(5, 'Colagen', 'apollo', 250, '2023-06-26', '2023-07-26', '2023-06-26', 19, 96, 'shiv@gmail.com'),
(6, 'khokala aushad', 'sonawanes brand', 250, '2023-01-24', '2023-07-07', '2023-06-07', 14, 120, 'shiv@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `user1_tbl`
--

CREATE TABLE `user1_tbl` (
  `u1id` int(100) NOT NULL,
  `u1name` varchar(100) NOT NULL,
  `u1email` varchar(100) NOT NULL,
  `u1password` varchar(100) NOT NULL,
  `u1contact` varchar(100) NOT NULL,
  `u1pincode` int(100) NOT NULL,
  `lat` varchar(100) NOT NULL,
  `lng` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user1_tbl`
--

INSERT INTO `user1_tbl` (`u1id`, `u1name`, `u1email`, `u1password`, `u1contact`, `u1pincode`, `lat`, `lng`) VALUES
(1, 'Bhavika saner', 'bhavika@gmail.com', '123456', '548213665', 425107, '', ''),
(2, 'SaiSeva Trauma center', 'saiseva@gnail.com', '123456', '5554635635', 545563, '', ''),
(3, 'falguni lohar', 'falguni@gmail.com', '123456', '7487896585', 12345, '', ''),
(4, 'Nikita Ahirrao', 'nikita@gmail.com', '123456', '8957412444', 784418, '19.988863926304415', '73.78383776715089');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `medical_tbl`
--
ALTER TABLE `medical_tbl`
  ADD PRIMARY KEY (`mid`);

--
-- Indexes for table `medicine_tbl`
--
ALTER TABLE `medicine_tbl`
  ADD PRIMARY KEY (`mdid`);

--
-- Indexes for table `user1_tbl`
--
ALTER TABLE `user1_tbl`
  ADD PRIMARY KEY (`u1id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `medical_tbl`
--
ALTER TABLE `medical_tbl`
  MODIFY `mid` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `medicine_tbl`
--
ALTER TABLE `medicine_tbl`
  MODIFY `mdid` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `user1_tbl`
--
ALTER TABLE `user1_tbl`
  MODIFY `u1id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
