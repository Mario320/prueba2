-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 06, 2017 at 05:49 PM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bufeteabogados`
--

-- --------------------------------------------------------

--
-- Table structure for table `bitacora`
--

CREATE TABLE `bitacora` (
  `IdBitacora` varchar(6) PRIMARY KEY NOT NULL,
  `Referencia` varchar(18) NOT NULL,
  `IdColaborador` varchar(6) DEFAULT NULL,
  `Detalle` varchar(500) DEFAULT NULL,
  `fecha` date DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `caso`
--

CREATE TABLE `caso` (
  `Referencia` varchar(18) PRIMARY KEY NOT NULL,
  `IdCliente` varchar(8) NOT NULL,
  `TituloCaso` varchar(100) DEFAULT NULL,
  `Materia` varchar(12) NOT NULL,
  `Juzgado` varchar(50) DEFAULT NULL,
  `NumJuez` varchar(4) DEFAULT NULL,
  `Demandante` varchar(100) DEFAULT NULL,
  `Demandado` varchar(100) DEFAULT NULL,
  `Proceso` varchar(50) DEFAULT NULL,
  `Jurisprudencia` varchar(50) DEFAULT NULL,
  `DetalleCaso` varchar(500) DEFAULT NULL,
  `ReferenciaExterna` varchar(20) DEFAULT NULL,
  `FechaInicio` date DEFAULT NULL,
  `FechaFin` date DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `cliente`
--

CREATE TABLE `cliente` (
  `IdCliente` varchar(8) PRIMARY KEY NOT NULL,
  `DI` varchar(17) NOT NULL,
  `Nombre` varchar(50) DEFAULT NULL,
  `Apellido` varchar(50) DEFAULT NULL,
  `RepresentanteLegal` varchar(90) DEFAULT NULL,
  `IdPoder` varchar(8) DEFAULT NULL,
  `Correo` varchar(40) DEFAULT NULL,
  `Telefono` varchar(9) DEFAULT NULL,
  `Direccion` varchar(150) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `colaborador`
--

CREATE TABLE `colaborador` (
  `IdColaborador` varchar(6) PRIMARY KEY NOT NULL,
  `Nombre` varchar(40) DEFAULT NULL,
  `Apellido` varchar(40) DEFAULT NULL,
  `Correo` varchar(40) DEFAULT NULL,
  `Telefono` varchar(9) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `colaboradorcaso`
--

CREATE TABLE `colaboradorcaso` (
  `IdColaboradorCaso` varchar(6) PRIMARY KEY NOT NULL,
  `IdColaborador` varchar(6) DEFAULT NULL,
  `Referencia` varchar(18) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `poder`
--

CREATE TABLE `poder` (
  `IdPoder` varchar(8) PRIMARY KEY NOT NULL,
  `Poder` varchar(40) DEFAULT NULL,
  `Detalle` varchar(500) DEFAULT NULL,
  `Otorgante` varchar(120) DEFAULT NULL,
  `Fecha` date DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tipousuario`
--

CREATE TABLE `tipousuario` (
  `IdTipoUsuario` varchar(6) PRIMARY KEY NOT NULL,
  `Tipo` varchar(40) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

CREATE TABLE `usuario` (
  `IdUsuario` varchar(6) PRIMARY KEY NOT NULL,
  `Nombre` varchar(40) DEFAULT NULL,
  `Apellido` varchar(40) DEFAULT NULL,
  `Password` varchar(25) DEFAULT NULL,
  `IdTipoUsuario` varchar(6) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bitacora`
--
ALTER TABLE `bitacora`
  ADD CONSTRAINT `Fk_Referencia` FOREIGN KEY (`Referencia`) REFERENCES `caso` (`Referencia`),
  ADD CONSTRAINT `Fk_IdColaborador` FOREIGN KEY (`IdColaborador`) REFERENCES `colaborador` (`IdColaborador`);

--
-- Indexes for table `caso`
--
ALTER TABLE `caso`
  ADD CONSTRAINT `Fk_IdCliente` FOREIGN KEY (`IdCliente`) REFERENCES `cliente` (`IdCliente`);

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `Fk_IdPoder` FOREIGN KEY (`IdPoder`) REFERENCES `poder` (`IdPoder`);

--
-- Indexes for table `colaboradorcaso`
--
ALTER TABLE `colaboradorcaso`
  ADD CONSTRAINT `fkIdColaborador` FOREIGN KEY (`IdColaborador`) REFERENCES `colaborador` (`IdColaborador`),
  ADD CONSTRAINT `fkIdCaso` FOREIGN KEY (`Referencia`) REFERENCES `caso` (`Referencia`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fkIdTipoUsuario` FOREIGN KEY (`IdTipoUsuario`) REFERENCES `tipousuario` (`IdTipoUsuario`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
