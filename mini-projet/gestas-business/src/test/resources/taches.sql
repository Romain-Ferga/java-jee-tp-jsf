-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Jeu 24 Août 2017 à 04:41
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `taches`
--

-- --------------------------------------------------------

--
-- Structure de la table `tache`
--

CREATE TABLE `tache` (
  `ID_TACHE` int(4) NOT NULL,
  `ID_USER` int(4) NOT NULL,
  `LIBELLE` varchar(100) NOT NULL,
  `STATUT` int(1) NOT NULL,
  `TEMPS_RESTANT` int(4) NOT NULL,
  `TEMPS_IMPARTI` int(4) NOT NULL,
  `DATE_CREATION` timestamp NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `tache`
--

INSERT INTO `tache` (`ID_TACHE`, `ID_USER`, `LIBELLE`, `STATUT`, `TEMPS_RESTANT`, `TEMPS_IMPARTI`, `DATE_CREATION`) VALUES
(5, 1, 'Envoi d\'email', 1, 30, 20, '2017-01-15 15:33:57'),
(6, 1, 'Modele conceptuel De donnees', 2, 20, 27, '2017-01-15 15:41:36'),
(7, 2, 'Diagramme de classes', 1, 10, 10, '2017-01-15 15:41:57'),
(9, 4, 'Transfert de docs FTP', 1, 30, 30, '2017-01-19 10:42:57');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `ID_USER` int(11) NOT NULL,
  `NOM` varchar(25) NOT NULL,
  `PRENOM` varchar(25) NOT NULL,
  `SEXE` int(1) NOT NULL,
  `EMAIL` varchar(100) NOT NULL,
  `PASSWORD` varchar(25) NOT NULL,
  `CODE_POSTAL` int(5) NOT NULL,
  `CODE_DEPARTEMENT` int(1) NOT NULL,
  `DATE_INSCRIPTION` timestamp NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`ID_USER`, `NOM`, `PRENOM`, `SEXE`, `EMAIL`, `PASSWORD`, `CODE_POSTAL`, `CODE_DEPARTEMENT`, `DATE_INSCRIPTION`) VALUES
(1, 'ZOME', 'Christophe', 1, 'christophe.zome@sogeti.com', 'pwd_esic', 35700, 0, '2017-01-09 18:34:35'),
(2, 'ROCARD', 'Michel', 1, 'michel.rocard@lr.fr', '', 75030, 1, '2017-01-09 18:34:35'),
(3, 'LE PEN', 'Marine', 2, 'marine.lepen@fn.fr', '', 82003, 2, '2017-01-10 07:39:48'),
(4, 'PEILLON', 'Vincent', 1, 'vincent.peillon@ps.fr', 'vpei', 72000, 0, '2017-01-16 06:27:07'),
(5, 'ROYAL', 'Segolene', 2, 'segolene.royal@ps.fr', 'sego', 72000, 2, '2017-01-16 06:28:03'),
(10, 'benoit', 'HAMON', 1, 'benoit.hamon@ps.fr', 'ham', 44230, 2, '2017-01-19 10:40:24'),
(9, 'Aubry', 'Martine', 2, 'martine.aubry@ps.fr', 'aub', 81012, 0, '2017-01-17 05:40:38'),
(11, 'Alain', 'JUPPE', 1, 'alain.juppe@gouv.fr', 'der', 23145, 0, '2017-01-20 12:05:22'),
(12, 'Arnaud', 'MONTEBOURG', 1, 'arnaud.montbourg@s.fr', 'mont', 34000, 2, '2017-01-23 15:02:51'),
(17, 'DJEUMENI', 'Lucrece', 2, 'linda.djeumeni@yahoo.com', 'djeu', 34564, 3, '2017-01-28 22:50:52');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `tache`
--
ALTER TABLE `tache`
  ADD PRIMARY KEY (`ID_TACHE`),
  ADD KEY `FK_USER` (`ID_USER`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`ID_USER`),
  ADD UNIQUE KEY `EMAIL` (`EMAIL`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `tache`
--
ALTER TABLE `tache`
  MODIFY `ID_TACHE` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `ID_USER` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
