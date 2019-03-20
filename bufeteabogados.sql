-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Nov 15, 2017 at 09:57 AM
-- Server version: 5.7.17-log
-- PHP Version: 5.6.30

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
  `IdBitacora` int(11) NOT NULL,
  `Referencia` varchar(18) NOT NULL,
  `IdColaborador` varchar(6) DEFAULT NULL,
  `Detalle` varchar(500) DEFAULT NULL,
  `fecha` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bitacora`
--

INSERT INTO `bitacora` (`IdBitacora`, `Referencia`, `IdColaborador`, `Detalle`, `fecha`) VALUES
(1, '12346-23-5612-4523', 'COL002', 'Algo paso dicen', '2017-11-14'),
(2, '12345-12-1234-1234', 'COL001', 'no s[e algo tenia que poner', '2017-11-05'),
(3, '12345-12-1234-1294', 'COL002', 'No pos se supone que van a duplicar la nota de algo', '2017-11-16'),
(4, '12345-12-1234-1294', 'COL001', 'No s[e, hoy dice que mejor van a hacer el parcial un dia que todos puedan', '2017-11-17');

-- --------------------------------------------------------

--
-- Table structure for table `caso`
--

CREATE TABLE `caso` (
  `Referencia` varchar(18) NOT NULL,
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `caso`
--

INSERT INTO `caso` (`Referencia`, `IdCliente`, `TituloCaso`, `Materia`, `Juzgado`, `NumJuez`, `Demandante`, `Demandado`, `Proceso`, `Jurisprudencia`, `DetalleCaso`, `ReferenciaExterna`, `FechaInicio`, `FechaFin`) VALUES
('12345-12-1234-1234', 'CLI00002', 'La caida de Constantinopla', 'politica', 'sexto', '4', 'Constantinopla', 'turcos otomanos ', 'Penal', '1234-1331', '(de acuerdo con el calendario juliano) fue un hecho histórico que, en la periodización clásica, y según algunos historiadores, marcó el fin de la Edad Media en Europa y el fin del último vestigio del Imperio romano de Oriente.', '', '2017-05-28', NULL),
('12345-12-1234-1294', 'CLI00004', 'Nos aplazaron el parcial', 'Estudiantil', 'segundo', '5', 'Los que dejaron frameworks', 'pa\'que quiere saber eso', 'educativo', 'ni idea', 'Pos casual, los alumnos llegan a la hora y que no llega el docente con el examen', '', '2017-11-14', '2017-11-16'),
('12346-23-5612-4523', 'CLI00001', 'Maria Laguerta pide el divocio de Miguel Angel Batista', 'Divorcio', 'quinto', '3', 'Maria LaGuerta', 'Miguel Angel Batista', 'Manutencion', 'Familia', 'Maria LaGuerta pide a Miguel Angel Batista el divorcio debido a que su matrimonio se encuentra irremediablemente roto', '', '2017-09-30', NULL),
('12355-12-1234-1234', 'CLI00003', 'Pepsi demanda cocacola', 'mercantil', 'quinto', '5', 'Pepsi', 'Cocacola', 'mercanil', '12345678', 'Cocacola le copio el logo', '', '2017-04-11', NULL),
('12355-12-1234-1237', 'CLI00002', 'pension alimenticia', 'derecho', 'uno', '2', 'luis', 'javier', 'uno', 'dosgfdg', 'gfgdfg', '', '2017-04-11', NULL),
('12446-23-5612-4523', 'CLI00003', 'Reclama derechos de Copyright', 'publicidad', 'cuarto', '3', 'Fernando Delgado', 'Pepsi', 'no se', 'no tengo idea', 'Pues estaba una vez cocacola y dijo que pepsi le habia copiada la gota de agua de la lata numero 5086', '', '2017-11-05', '2017-11-22');

-- --------------------------------------------------------

--
-- Table structure for table `cliente`
--

CREATE TABLE `cliente` (
  `IdCliente` varchar(8) NOT NULL,
  `DI` varchar(17) NOT NULL,
  `Nombre` varchar(50) DEFAULT NULL,
  `Apellido` varchar(50) DEFAULT NULL,
  `RepresentanteLegal` varchar(90) DEFAULT NULL,
  `Correo` varchar(40) DEFAULT NULL,
  `Telefono` varchar(9) DEFAULT NULL,
  `Direccion` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cliente`
--

INSERT INTO `cliente` (`IdCliente`, `DI`, `Nombre`, `Apellido`, `RepresentanteLegal`, `Correo`, `Telefono`, `Direccion`) VALUES
('CLI00001', '12345678987654321', 'Maria Esmeraldo', 'LaGuerta', 'Sonia Alvarado', 'maria.guerta@hotmail.com', '7090-8989', 'Miami Beach, Florida'),
('CLI00002', '12345678901234567', 'Constantinopla', 'Imperio Latino', 'Constantino XI ', 'correo@gmial.com', '2290-8967', 'Continente europeo'),
('CLI00003', '00000001234567890', 'Cocacola', 'Company', 'Justino Aguilar', 'justino.aguilar@cocacola.com', '2389-8989', 'Industrias nojeque'),
('CLI00004', '06141269000012345', 'Universidad Don', 'Bosco', 'el rector', 'decano@udb.edu.sv', '2990-8989', 'ciudad delgado'),
('CLI00006', '12345678987654323', 'Salvador', 'Gonzalez', 'El Cuervo', 'col1@bufetegl.com', '7678-9034', 'por ahi');

-- --------------------------------------------------------

--
-- Table structure for table `colaborador`
--

CREATE TABLE `colaborador` (
  `IdColaborador` varchar(6) NOT NULL,
  `Nombre` varchar(40) DEFAULT NULL,
  `Apellido` varchar(40) DEFAULT NULL,
  `Correo` varchar(40) DEFAULT NULL,
  `Telefono` varchar(9) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `colaborador`
--

INSERT INTO `colaborador` (`IdColaborador`, `Nombre`, `Apellido`, `Correo`, `Telefono`) VALUES
('COL001', 'Mario Bejamin', 'Arana Gochez', 'col1@bufetegl.com', '7990-2345'),
('COL002', 'Edgar Allan', 'Poe', 'col2@bufetegl.com', '7890-6734'),
('COL006', 'daenerys targaryen', 'Mother of Dragons', 'col6@bufetegl.com', '7990-2349');

-- --------------------------------------------------------

--
-- Table structure for table `colaboradorcaso`
--

CREATE TABLE `colaboradorcaso` (
  `IdColaboradorCaso` int(11) NOT NULL,
  `IdColaborador` varchar(6) DEFAULT NULL,
  `Referencia` varchar(18) DEFAULT NULL,
  `fechaAsignacion` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `colaboradorcaso`
--

INSERT INTO `colaboradorcaso` (`IdColaboradorCaso`, `IdColaborador`, `Referencia`, `fechaAsignacion`) VALUES
(1, 'COL001', '12345-12-1234-1234', '2017-11-12'),
(2, 'COL002', '12346-23-5612-4523', '2017-11-14'),
(3, 'COL001', '12346-23-5612-4523', '2017-11-13'),
(4, 'COL001', '12446-23-5612-4523', '2017-11-21'),
(5, 'COL006', '12345-12-1234-1294', '2017-11-18');

-- --------------------------------------------------------

--
-- Table structure for table `poder`
--

CREATE TABLE `poder` (
  `IdPoder` int(11) NOT NULL,
  `Poder` varchar(40) DEFAULT NULL,
  `Detalle` varchar(500) DEFAULT NULL,
  `IdCliente` varchar(8) NOT NULL,
  `Otorgante` varchar(120) DEFAULT NULL,
  `Fecha` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `poder`
--

INSERT INTO `poder` (`IdPoder`, `Poder`, `Detalle`, `IdCliente`, `Otorgante`, `Fecha`) VALUES
(1, 'TODOS', 'Poder concedido para la representacion total del clienteeeeee', 'CLI00001', 'LaGuerta', '2017-09-14'),
(2, 'medio poder', 'Constantino XI est[a sufriendo saqueos en su ciudad y ha contratado los servicios para llegar a un acuerdo politico', 'CLI00001', 'Constantino XI', '2017-09-10');

-- --------------------------------------------------------

--
-- Table structure for table `tipousuario`
--

CREATE TABLE `tipousuario` (
  `IdTipoUsuario` varchar(6) NOT NULL,
  `Tipo` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tipousuario`
--

INSERT INTO `tipousuario` (`IdTipoUsuario`, `Tipo`) VALUES
('TIP001', 'ADM'),
('TIP002', 'EDIT');

-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

CREATE TABLE `usuario` (
  `IdUsuario` varchar(6) NOT NULL,
  `Nombre` varchar(40) NOT NULL,
  `Apellido` varchar(40) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `IdTipoUsuario` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usuario`
--

INSERT INTO `usuario` (`IdUsuario`, `Nombre`, `Apellido`, `Password`, `IdTipoUsuario`) VALUES
('USU001', 'Grismary', 'Guerrero', '5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5', 'TIP002'),
('USU003', 'Adan', 'Romero', '5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5', 'TIP001'),
('USU004', 'Salvador', 'Dalhi', '5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5', 'TIP002'),
('USU005', 'Kittim', 'Gonzalez', '5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5', 'TIP001'),
('USU999', 'Mario Benjamin', 'Arana Gochez', '5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5', 'TIP001');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bitacora`
--
ALTER TABLE `bitacora`
  ADD PRIMARY KEY (`IdBitacora`),
  ADD KEY `Referencia` (`Referencia`),
  ADD KEY `IdColaborador` (`IdColaborador`);

--
-- Indexes for table `caso`
--
ALTER TABLE `caso`
  ADD PRIMARY KEY (`Referencia`),
  ADD KEY `IdCliente` (`IdCliente`);

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`IdCliente`);

--
-- Indexes for table `colaborador`
--
ALTER TABLE `colaborador`
  ADD PRIMARY KEY (`IdColaborador`);

--
-- Indexes for table `colaboradorcaso`
--
ALTER TABLE `colaboradorcaso`
  ADD PRIMARY KEY (`IdColaboradorCaso`),
  ADD KEY `IdColaborador` (`IdColaborador`),
  ADD KEY `Referencia` (`Referencia`);

--
-- Indexes for table `poder`
--
ALTER TABLE `poder`
  ADD PRIMARY KEY (`IdPoder`),
  ADD KEY `poder_ibfk_1` (`IdCliente`);

--
-- Indexes for table `tipousuario`
--
ALTER TABLE `tipousuario`
  ADD PRIMARY KEY (`IdTipoUsuario`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`IdUsuario`),
  ADD KEY `IdTipoUsuario` (`IdTipoUsuario`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bitacora`
--
ALTER TABLE `bitacora`
  MODIFY `IdBitacora` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `colaboradorcaso`
--
ALTER TABLE `colaboradorcaso`
  MODIFY `IdColaboradorCaso` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `poder`
--
ALTER TABLE `poder`
  MODIFY `IdPoder` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `bitacora`
--
ALTER TABLE `bitacora`
  ADD CONSTRAINT `bitacora_ibfk_1` FOREIGN KEY (`IdColaborador`) REFERENCES `colaborador` (`IdColaborador`),
  ADD CONSTRAINT `bitacora_ibfk_2` FOREIGN KEY (`Referencia`) REFERENCES `caso` (`Referencia`),
  ADD CONSTRAINT `bitacora_ibfk_3` FOREIGN KEY (`IdColaborador`) REFERENCES `colaborador` (`IdColaborador`);

--
-- Constraints for table `caso`
--
ALTER TABLE `caso`
  ADD CONSTRAINT `caso_ibfk_1` FOREIGN KEY (`IdCliente`) REFERENCES `cliente` (`IdCliente`);

--
-- Constraints for table `colaboradorcaso`
--
ALTER TABLE `colaboradorcaso`
  ADD CONSTRAINT `colaboradorcaso_ibfk_1` FOREIGN KEY (`IdColaborador`) REFERENCES `colaborador` (`IdColaborador`),
  ADD CONSTRAINT `colaboradorcaso_ibfk_2` FOREIGN KEY (`Referencia`) REFERENCES `caso` (`Referencia`);

--
-- Constraints for table `poder`
--
ALTER TABLE `poder`
  ADD CONSTRAINT `poder_ibfk_1` FOREIGN KEY (`IdCliente`) REFERENCES `cliente` (`IdCliente`);

--
-- Constraints for table `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`IdTipoUsuario`) REFERENCES `tipousuario` (`IdTipoUsuario`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
