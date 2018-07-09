-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 09, 2018 at 09:51 PM
-- Server version: 5.6.16
-- PHP Version: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `realtime`
--

-- --------------------------------------------------------

--
-- Table structure for table `trans`
--

CREATE TABLE IF NOT EXISTS `trans` (
  `trans_id` int(11) NOT NULL AUTO_INCREMENT,
  `received_id` int(50) NOT NULL,
  `sender_id` int(50) NOT NULL,
  `amount` int(50) NOT NULL,
  `date` varchar(50) NOT NULL,
  PRIMARY KEY (`trans_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=33 ;

--
-- Dumping data for table `trans`
--

INSERT INTO `trans` (`trans_id`, `received_id`, `sender_id`, `amount`, `date`) VALUES
(1, 12, 1234, 100, '1530888562005'),
(2, 12, 1234, 100, '2018-07-06T14:52:30.339Z'),
(3, 12, 1234, 100, 'yyyy-mm-dd h:MM:ss'),
(4, 12, 1234, 100, 'Fri Jul 06 2018 17:54:18 GMT+0300 (E. Africa Stand'),
(5, 12, 1234, 100, 'Fri Jul 06 2018 17:58:08 GMT+0300 (E. Africa Stand'),
(6, 12, 1234, 100, 'Fri Jul 06 2018 17:59:13 GMT+0300 (E. Africa Stand'),
(7, 12, 1234, 100, 'Fri Jul 06 2018 17:59:50 GMT+0300 (E. Africa Stand'),
(8, 12, 1234, 100, 'Fri Jul 06 2018 18:00:50 GMT+0300 (E. Africa Stand'),
(9, 12, 1234, 100, 'Fri Jul 06 2018 18:01:31 GMT+0300 (E. Africa Stand'),
(10, 124, 12, 70, 'Sat Jul 07 2018 13:45:53 GMT+0300 (E. Africa Stand'),
(11, 124, 12, 70, 'Sat Jul 07 2018 13:47:10 GMT+0300 (E. Africa Stand'),
(12, 124, 12, 70, 'Sat Jul 07 2018 13:47:51 GMT+0300 (E. Africa Stand'),
(13, 124, 12, 70, 'Sat Jul 07 2018 13:59:34 GMT+0300 (E. Africa Stand'),
(14, 124, 12, 70, 'Sat Jul 07 2018 13:59:53 GMT+0300 (E. Africa Stand'),
(15, 124, 12, 70, 'Sat Jul 07 2018 14:02:49 GMT+0300 (E. Africa Stand'),
(16, 124, 12, 70, 'Sat Jul 07 2018 19:01:25 GMT+0300 (E. Africa Stand'),
(17, 124, 12, 70, 'Sat Jul 07 2018 19:05:41 GMT+0300 (E. Africa Stand'),
(18, 124, 12, 70, 'Sat Jul 07 2018 19:08:07 GMT+0300 (E. Africa Stand'),
(19, 12345, 12, 70, 'Sat Jul 07 2018 19:09:21 GMT+0300 (E. Africa Stand'),
(20, 90, 12, 70, 'Sat Jul 07 2018 19:09:37 GMT+0300 (E. Africa Stand'),
(21, 90, 12, 70, 'Sat Jul 07 2018 19:10:35 GMT+0300 (E. Africa Stand'),
(22, 90, 12, 70, 'Sat Jul 07 2018 19:26:20 GMT+0300 (E. Africa Stand'),
(24, 12, 123, 20, 'Sat Jul 07 2018 20:55:44 GMT+0300 (E. Africa Stand'),
(25, 123, 12, 30, 'Sat Jul 07 2018 20:56:31 GMT+0300 (E. Africa Stand'),
(26, 12, 123, 10, 'Sun Jul 08 2018 13:49:42 GMT+0300 (E. Africa Stand'),
(27, 12, 123, 20, 'Sun Jul 08 2018 14:36:32 GMT+0300 (E. Africa Stand'),
(28, 12, 123, 2, 'Sun Jul 08 2018 16:36:46 GMT+0300 (E. Africa Stand'),
(29, 12, 123, 2, 'Sun Jul 08 2018 16:36:51 GMT+0300 (E. Africa Stand'),
(30, 444, 123, 20, 'Sun Jul 08 2018 17:04:42 GMT+0300 (E. Africa Stand'),
(31, 444, 123, 20, 'Sun Jul 08 2018 17:05:10 GMT+0300 (E. Africa Stand'),
(32, 345, 123, 2, 'Sun Jul 08 2018 17:12:30 GMT+0300 (E. Africa Stand');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `pass` varchar(50) NOT NULL,
  `balance` int(50) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `name`, `phone`, `pass`, `balance`) VALUES
(1, 'mohamed xaaji', '12345', '12345', 0),
(2, 'asad warsame', '12', '12', 0),
(4, 'asad', '124', '124', 0),
(5, 'test', '90', '90', 0),
(7, 'admin', '615730747', '1311', 0),
(8, 'deeq', '618400222', '123', 100),
(9, 'deeq0', '618400221', '123', 100),
(10, 'deeq0', '618400221', '123', 100),
(11, 'deeq0', '618400221', '123', 100),
(12, 'cadeey', '123', '123', 100);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
