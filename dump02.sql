-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Czas generowania: 07 Kwi 2016, 13:17
-- Wersja serwera: 10.1.9-MariaDB
-- Wersja PHP: 5.5.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `mydb`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `clinic`
--

CREATE TABLE `clinic` (
  `idClinic` int(10) UNSIGNED NOT NULL,
  `clinicName` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `clinic`
--

INSERT INTO `clinic` (`idClinic`, `clinicName`) VALUES
(1, 'Mayo Clinic'),
(2, 'CHOP'),
(3, 'BAYLO');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `schedule`
--

CREATE TABLE `schedule` (
  `idSchedule` int(10) UNSIGNED NOT NULL,
  `dateStart` datetime NOT NULL,
  `dateEnd` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `schedule`
--

INSERT INTO `schedule` (`idSchedule`, `dateStart`, `dateEnd`) VALUES
(1, '2016-10-22 14:30:00', '2016-10-22 15:30:00'),
(2, '2016-10-23 12:00:00', '2016-10-24 12:00:00'),
(3, '2016-04-08 00:00:00', '2016-04-15 00:00:00'),
(4, '2016-04-08 00:00:00', '2016-04-22 00:00:00'),
(5, '2016-04-10 00:00:00', '2016-04-20 00:00:00');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `user`
--

CREATE TABLE `user` (
  `idUser` int(10) UNSIGNED NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `login` varchar(45) NOT NULL,
  `password` varchar(255) NOT NULL,
  `isDoctor` tinyint(1) DEFAULT '0',
  `User_idUser` int(10) DEFAULT NULL,
  `Clinic_idClinic` int(10) UNSIGNED NOT NULL,
  `Schedule_idSchedule` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `user`
--

INSERT INTO `user` (`idUser`, `firstName`, `lastName`, `login`, `password`, `isDoctor`, `User_idUser`, `Clinic_idClinic`, `Schedule_idSchedule`) VALUES
(1, 'John', 'Smith', 'jsmith', 'jsmith', 1, NULL, 1, 1),
(2, 'User', 'Testowy', 'test', 'test', 0, 1, 1, 5),
(3, 'Damian', 'Damianowy', 'damian', 'damian', 0, 4, 1, 2),
(4, 'John', 'Smith Second', 'doktor', 'doktor', 1, NULL, 1, 1);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indexes for table `clinic`
--
ALTER TABLE `clinic`
  ADD PRIMARY KEY (`idClinic`);

--
-- Indexes for table `schedule`
--
ALTER TABLE `schedule`
  ADD PRIMARY KEY (`idSchedule`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`idUser`),
  ADD UNIQUE KEY `idUser_UNIQUE` (`idUser`),
  ADD UNIQUE KEY `login_UNIQUE` (`login`),
  ADD KEY `fk_User_User_idx` (`User_idUser`),
  ADD KEY `fk_User_Clinic1_idx` (`Clinic_idClinic`),
  ADD KEY `fk_User_Schedule1_idx` (`Schedule_idSchedule`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `clinic`
--
ALTER TABLE `clinic`
  MODIFY `idClinic` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT dla tabeli `schedule`
--
ALTER TABLE `schedule`
  MODIFY `idSchedule` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT dla tabeli `user`
--
ALTER TABLE `user`
  MODIFY `idUser` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `fk_User_Clinic1` FOREIGN KEY (`Clinic_idClinic`) REFERENCES `clinic` (`idClinic`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_User_Schedule1` FOREIGN KEY (`Schedule_idSchedule`) REFERENCES `schedule` (`idSchedule`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
