-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 24-11-2025 a las 14:14:14
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `circo_tomasvega`
--
CREATE DATABASE IF NOT EXISTS `circo_tomasvega` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `circo_tomasvega`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `artista`
--

CREATE TABLE `artista` (
  `id_artista` bigint(20) NOT NULL,
  `apodo` varchar(20) DEFAULT NULL,
  `id_usuario` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `artista`
--

INSERT INTO `artista` (`id_artista`, `apodo`, `id_usuario`) VALUES
(1, 'AcrroLuis', 1),
(2, NULL, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `artistaespecialidad`
--

CREATE TABLE `artistaespecialidad` (
  `id_artista` bigint(20) NOT NULL,
  `especialidades` enum('ACROBACIA','HUMOR','MALABARISMO','EQUILIBRISMO','MAGIA') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `artistaespecialidad`
--

INSERT INTO `artistaespecialidad` (`id_artista`, `especialidades`) VALUES
(1, 'ACROBACIA'),
(1, 'MAGIA'),
(2, 'HUMOR');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `artistanumero`
--

CREATE TABLE `artistanumero` (
  `id_numero` bigint(20) NOT NULL,
  `id_artista` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `artistanumero`
--

INSERT INTO `artistanumero` (`id_numero`, `id_artista`) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 1),
(6, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `coordinacion`
--

CREATE TABLE `coordinacion` (
  `id_coordinacion` bigint(20) NOT NULL,
  `es_senior` tinyint(1) NOT NULL DEFAULT 0,
  `fecha_inicio_senior` date DEFAULT NULL,
  `id_usuario` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `coordinacion`
--

INSERT INTO `coordinacion` (`id_coordinacion`, `es_senior`, `fecha_inicio_senior`, `id_usuario`) VALUES
(1, 1, '2018-01-01', 3),
(2, 0, NULL, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `espectaculo`
--

CREATE TABLE `espectaculo` (
  `id_espectaculo` bigint(20) NOT NULL,
  `nombre_espectaculo` varchar(40) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date NOT NULL,
  `id_coordinacion` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `espectaculo`
--

INSERT INTO `espectaculo` (`id_espectaculo`, `nombre_espectaculo`, `fecha_inicio`, `fecha_fin`, `id_coordinacion`) VALUES
(1, 'Circo Fantasía', '2025-01-01', '2025-02-01', 1),
(2, 'Noche Estelar', '2025-03-01', '2025-04-01', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `numero`
--

CREATE TABLE `numero` (
  `id_numero` bigint(20) NOT NULL,
  `nombre_numero` varchar(40) NOT NULL,
  `orden` int(11) NOT NULL,
  `duracion` double NOT NULL,
  `id_espectaculo` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `numero`
--

INSERT INTO `numero` (`id_numero`, `nombre_numero`, `orden`, `duracion`, `id_espectaculo`) VALUES
(1, 'Acróbatas del Aire', 1, 12.5, 1),
(2, 'Magia Ilusoria', 2, 10, 1),
(3, 'Payasos en Escena', 3, 8, 1),
(4, 'Luz y Sombras', 1, 14, 2),
(5, 'Equilibristas del Vértigo', 2, 11, 2),
(6, 'Risas Nocturnas', 3, 9, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` bigint(20) NOT NULL,
  `nombre_usuario` varchar(40) NOT NULL,
  `contrasenia` varchar(40) NOT NULL,
  `nombre_real` varchar(20) NOT NULL,
  `email` varchar(40) NOT NULL,
  `nacionalidad` varchar(20) NOT NULL,
  `perfil` enum('ARTISTA','COORDINACION') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `nombre_usuario`, `contrasenia`, `nombre_real`, `email`, `nacionalidad`, `perfil`) VALUES
(1, 'artistaA', 'pass1', 'Luis Ortega', 'luis.ortega@example.com', 'España', 'ARTISTA'),
(2, 'artistaB', 'pass2', 'Marta Rios', 'marta.rios@example.com', 'México', 'ARTISTA'),
(3, 'coordA', 'pass10', 'Sonia Vidal', 'sonia.vidal@example.com', 'España', 'COORDINACION'),
(4, 'coordB', 'pass11', 'Ernesto Díaz', 'ernesto.diaz@example.com', 'Argentina', 'COORDINACION');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `artista`
--
ALTER TABLE `artista`
  ADD PRIMARY KEY (`id_artista`),
  ADD KEY `fk_artista_usuario` (`id_usuario`);

--
-- Indices de la tabla `artistaespecialidad`
--
ALTER TABLE `artistaespecialidad`
  ADD PRIMARY KEY (`id_artista`,`especialidades`);

--
-- Indices de la tabla `artistanumero`
--
ALTER TABLE `artistanumero`
  ADD PRIMARY KEY (`id_numero`,`id_artista`),
  ADD KEY `fk_artistanumero_artista` (`id_artista`);

--
-- Indices de la tabla `coordinacion`
--
ALTER TABLE `coordinacion`
  ADD PRIMARY KEY (`id_coordinacion`),
  ADD KEY `fk_coordinacion_usuario` (`id_usuario`);

--
-- Indices de la tabla `espectaculo`
--
ALTER TABLE `espectaculo`
  ADD PRIMARY KEY (`id_espectaculo`),
  ADD UNIQUE KEY `nombre_espectaculo` (`nombre_espectaculo`),
  ADD KEY `fk_espectaculo_coordinacion` (`id_coordinacion`);

--
-- Indices de la tabla `numero`
--
ALTER TABLE `numero`
  ADD PRIMARY KEY (`id_numero`),
  ADD UNIQUE KEY `nombre_numero` (`nombre_numero`),
  ADD KEY `fk_numero_espectaculo` (`id_espectaculo`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`),
  ADD UNIQUE KEY `nombre_usuario` (`nombre_usuario`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `artista`
--
ALTER TABLE `artista`
  MODIFY `id_artista` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `coordinacion`
--
ALTER TABLE `coordinacion`
  MODIFY `id_coordinacion` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `espectaculo`
--
ALTER TABLE `espectaculo`
  MODIFY `id_espectaculo` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `numero`
--
ALTER TABLE `numero`
  MODIFY `id_numero` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `artista`
--
ALTER TABLE `artista`
  ADD CONSTRAINT `fk_artista_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `artistaespecialidad`
--
ALTER TABLE `artistaespecialidad`
  ADD CONSTRAINT `fk_artistaespecialidad_artista` FOREIGN KEY (`id_artista`) REFERENCES `artista` (`id_artista`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `artistanumero`
--
ALTER TABLE `artistanumero`
  ADD CONSTRAINT `fk_artistanumero_artista` FOREIGN KEY (`id_artista`) REFERENCES `artista` (`id_artista`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_artistanumero_numero` FOREIGN KEY (`id_numero`) REFERENCES `numero` (`id_numero`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `coordinacion`
--
ALTER TABLE `coordinacion`
  ADD CONSTRAINT `fk_coordinacion_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `espectaculo`
--
ALTER TABLE `espectaculo`
  ADD CONSTRAINT `fk_espectaculo_coordinacion` FOREIGN KEY (`id_coordinacion`) REFERENCES `coordinacion` (`id_coordinacion`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `numero`
--
ALTER TABLE `numero`
  ADD CONSTRAINT `fk_numero_espectaculo` FOREIGN KEY (`id_espectaculo`) REFERENCES `espectaculo` (`id_espectaculo`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
