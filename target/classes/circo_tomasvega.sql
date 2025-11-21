-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-11-2025 a las 20:53:53
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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `artista`
--

CREATE TABLE `artista` (
  `id_artista` bigint(20) NOT NULL,
  `apodo` varchar(20) DEFAULT NULL,
  `id_usuario` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `artistanumero`
--

CREATE TABLE `artistanumero` (
  `id_numero` bigint(20) NOT NULL,
  `id_artista` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `artistaespecialidad`
--

CREATE TABLE `artistaespecialidad` (
  `id_artista` bigint(20) NOT NULL,
  `especialidades` enum('ACROBACIA','HUMOR','MALABARISMO','EQUILIBRISMO','MAGIA') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `numero`
--

CREATE TABLE `numero` (
  `id_numero` bigint(20) NOT NULL,
  `nombre_numero` varchar(40) NOT NULL,
  `orden` int NOT NULL,
  `duracion` double NOT NULL,
  `id_espectaculo` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
  `perfil` enum('ARTISTA','COORDINACION') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `artista`
--
ALTER TABLE `artista`
  ADD PRIMARY KEY (`id_artista`),
  ADD KEY `id_usuario_FK` (`id_usuario`);

--
-- Indices de la tabla `artistanumero`
--
ALTER TABLE `artistanumero`
  ADD KEY `id_numeroartista_FK` (`id_numero`),
  ADD KEY `id_artistanumero_FK` (`id_artista`);

--
-- Indices de la tabla `artistanumero`
--
ALTER TABLE `artistaespecialidad`
  ADD KEY `id_artistaespecialidad_FK` (`id_artista`);
--
-- Indices de la tabla `coordinacion`
--
ALTER TABLE `coordinacion`
  ADD PRIMARY KEY (`id_coordinacion`),
  ADD KEY `usuario_coord_FK` (`id_usuario`);

--
-- Indices de la tabla `espectaculo`
--
ALTER TABLE `espectaculo`
  ADD PRIMARY KEY (`id_espectaculo`),
  ADD UNIQUE KEY `id_espectaculo_UQ` (`nombre_espectaculo`),
  ADD KEY `id_coordinador_FK` (`id_coordinacion`);
  

--
-- Indices de la tabla `numero`
--
ALTER TABLE `numero`
  ADD PRIMARY KEY (`id_numero`),
  ADD UNIQUE KEY `nombre_numero_UQ` (`nombre_numero`),
  ADD KEY `id_espectaculo_FK` (`id_espectaculo`);
--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`),
  ADD UNIQUE KEY `nombre_usuario_UQ` (`nombre_usuario`),
  ADD UNIQUE KEY `email_UQ` (`email`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `artista`
--
ALTER TABLE `artista`
  MODIFY `id_artista` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `coordinacion`
--
ALTER TABLE `coordinacion`
  MODIFY `id_coordinacion` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `espectaculo`
--
ALTER TABLE `espectaculo`
  MODIFY `id_espectaculo` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `numero`
--
ALTER TABLE `numero`
  MODIFY `id_numero` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `artista`
--
ALTER TABLE `artista`
  ADD CONSTRAINT `id_usuario_FK` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`);

--
-- Filtros para la tabla `artistanumero`
--
ALTER TABLE `artistanumero`
  ADD CONSTRAINT `id_artistanumero_FK` FOREIGN KEY (`id_artista`) REFERENCES `artista` (`id_artista`),
  ADD CONSTRAINT `id_numeroartista_FK` FOREIGN KEY (`id_numero`) REFERENCES `numero` (`id_numero`);

--
-- Filtros para la tabla `artistaespecialidad`
--
ALTER TABLE `artistaespecialidad`
  ADD CONSTRAINT `id_artistaespecialidad_FK` FOREIGN KEY (`id_artista`) REFERENCES `artista` (`id_artista`);
--
-- Filtros para la tabla `coordinacion`
--
ALTER TABLE `coordinacion`
  ADD CONSTRAINT `usuario_coord_FK` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`);

--
-- Filtros para la tabla `espectaculo`
--
ALTER TABLE `espectaculo`
  ADD CONSTRAINT `id_coordinador_FK` FOREIGN KEY (`id_coordinacion`) REFERENCES `coordinacion` (`id_coordinacion`);
COMMIT;

--
-- Filtros para la tabla `numero`
--
ALTER TABLE `numero`
  ADD CONSTRAINT `id_espectaculo_FK` FOREIGN KEY (`id_espectaculo`) REFERENCES `espectaculo` (`id_espectaculo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
