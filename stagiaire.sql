-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 31, 2015 at 01:26 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `stagiaire`
--

-- --------------------------------------------------------

--
-- Table structure for table `rh`
--

CREATE TABLE IF NOT EXISTS `rh` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(20) NOT NULL,
  `Prenom` varchar(20) NOT NULL,
  `login` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

-- --------------------------------------------------------

--
-- Table structure for table `stagiaire`
--

CREATE TABLE IF NOT EXISTS `stagiaire` (
  `CINStagiaire` int(8) NOT NULL,
  `nomStagiaire` varchar(20) NOT NULL,
  `prenomStagiaire` varchar(20) NOT NULL,
  `naissanceStagiaire` varchar(20) NOT NULL,
  `universiteStagiaire` varchar(30) NOT NULL,
  `specialtyStagiaire` varchar(30) NOT NULL,
  `adresseStagiaire` varchar(30) NOT NULL,
  `emailStagiaire` varchar(30) NOT NULL,
  PRIMARY KEY (`CINStagiaire`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
