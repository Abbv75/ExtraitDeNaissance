-- phpMyAdmin SQL Dump
-- version 5.1.1deb5ubuntu1
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le : ven. 03 fév. 2023 à 16:05
-- Version du serveur : 8.0.32-0ubuntu0.22.04.2
-- Version de PHP : 8.1.2-1ubuntu2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `mairiedb`
--

-- --------------------------------------------------------

--
-- Structure de la table `extrait`
--

CREATE TABLE `extrait` (
  `num` int NOT NULL,
  `nomE` varchar(40) NOT NULL,
  `prenomE` varchar(60) NOT NULL,
  `dateNaiss` date NOT NULL,
  `lieuNaiss` varchar(60) NOT NULL,
  `sexe` tinyint NOT NULL,
  `nomP` varchar(40) NOT NULL,
  `prenomP` varchar(60) NOT NULL,
  `domicileP` varchar(60) NOT NULL,
  `proffessionP` varchar(60) DEFAULT NULL,
  `nomM` varchar(40) NOT NULL,
  `prenomM` varchar(60) NOT NULL,
  `domicileM` varchar(60) NOT NULL,
  `proffessionM` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `dateDeliv` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `extrait`
--

INSERT INTO `extrait` (`num`, `nomE`, `prenomE`, `dateNaiss`, `lieuNaiss`, `sexe`, `nomP`, `prenomP`, `domicileP`, `proffessionP`, `nomM`, `prenomM`, `domicileM`, `proffessionM`, `dateDeliv`) VALUES
(445, '46', '45', '2023-02-05', '54', 1, '562', '45', 'j', 'j', 'j', 'k', 'k', 'k', '2023-02-03');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `extrait`
--
ALTER TABLE `extrait`
  ADD PRIMARY KEY (`num`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
