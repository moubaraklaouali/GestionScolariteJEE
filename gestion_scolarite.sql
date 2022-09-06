-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mar. 06 sep. 2022 à 11:33
-- Version du serveur : 5.7.36
-- Version de PHP : 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gestion_scolarite`
--

-- --------------------------------------------------------

--
-- Structure de la table `college`
--

DROP TABLE IF EXISTS `college`;
CREATE TABLE IF NOT EXISTS `college` (
  `id_college` int(255) NOT NULL AUTO_INCREMENT,
  `nom_college` varchar(255) DEFAULT NULL,
  `adresse_site` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_college`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `cours`
--

DROP TABLE IF EXISTS `cours`;
CREATE TABLE IF NOT EXISTS `cours` (
  `id_cours` int(11) NOT NULL AUTO_INCREMENT,
  `id_salle` int(255) NOT NULL,
  `libelle_couurs` text,
  PRIMARY KEY (`id_cours`),
  KEY `FK_cours_id_salle` (`id_salle`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `departement`
--

DROP TABLE IF EXISTS `departement`;
CREATE TABLE IF NOT EXISTS `departement` (
  `id_departement` int(11) NOT NULL AUTO_INCREMENT,
  `nom_departement` varchar(255) DEFAULT NULL,
  `id_college` int(255) NOT NULL,
  `id_enseignant` int(255) NOT NULL,
  PRIMARY KEY (`id_departement`),
  KEY `FK_departement_id_college` (`id_college`),
  KEY `FK_departement_id_enseignant` (`id_enseignant`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `enseignant`
--

DROP TABLE IF EXISTS `enseignant`;
CREATE TABLE IF NOT EXISTS `enseignant` (
  `id_enseignant` int(255) NOT NULL AUTO_INCREMENT,
  `nom_enseignant` varchar(255) DEFAULT NULL,
  `prenom_enseignant` varchar(255) DEFAULT NULL,
  `telephone_enseignant` varchar(255) DEFAULT NULL,
  `mail_enseignant` varchar(255) DEFAULT NULL,
  `Id_Departement` int(255) NOT NULL,
  `date_prise_fonction_enseignant` date DEFAULT NULL,
  `indice_enseignant` text,
  `id_cours` int(255) NOT NULL,
  PRIMARY KEY (`id_enseignant`),
  KEY `FK_enseignant_id_Departement` (`Id_Departement`),
  KEY `FK_enseignant_id_cours` (`id_cours`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

DROP TABLE IF EXISTS `etudiant`;
CREATE TABLE IF NOT EXISTS `etudiant` (
  `id_etudiant` int(255) NOT NULL AUTO_INCREMENT,
  `nom_etudiant` varchar(255) DEFAULT NULL,
  `prenom_etudiant` varchar(255) DEFAULT NULL,
  `telephone_etudiant` varchar(255) DEFAULT NULL,
  `mail_etudiant` varchar(255) DEFAULT NULL,
  `annee_entree` date DEFAULT NULL,
  PRIMARY KEY (`id_etudiant`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `salle`
--

DROP TABLE IF EXISTS `salle`;
CREATE TABLE IF NOT EXISTS `salle` (
  `id_salle` int(255) NOT NULL AUTO_INCREMENT,
  `nom_salle` varchar(255) DEFAULT NULL,
  `capacite` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_salle`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `suivre_cours`
--

DROP TABLE IF EXISTS `suivre_cours`;
CREATE TABLE IF NOT EXISTS `suivre_cours` (
  `id_suivre_cours` int(11) NOT NULL AUTO_INCREMENT,
  `note_etudiant` int(11) NOT NULL,
  `id_etudiant` int(11) NOT NULL,
  `id_cours` int(11) NOT NULL,
  PRIMARY KEY (`id_suivre_cours`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
