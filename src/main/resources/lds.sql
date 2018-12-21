-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Dec 21, 2018 at 02:42 AM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lds`
--

CREATE DATABASE `lds`;
USE lds;

-- --------------------------------------------------------

--
-- Table structure for table `m_area`
--

CREATE TABLE `m_area` (
  `id_area` varchar(20) NOT NULL,
  `id_province` int(11) NOT NULL,
  `id_cityregency` int(11) NOT NULL,
  `id_district` int(11) NOT NULL,
  `sub_district` varchar(50) NOT NULL,
  `postal_code` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `m_area`
--

INSERT INTO `m_area` (`id_area`, `id_province`, `id_cityregency`, `id_district`, `sub_district`, `postal_code`) VALUES
('AR100005009401', 10, 5, 94, 'KESATRIAN', '65121'),
('AR100005009402', 10, 5, 94, 'POLEHAN', '65121'),
('AR100005009403', 10, 5, 94, 'PURWANTORO', '65122'),
('AR100005009404', 10, 5, 94, 'BUNULREJO', '65123'),
('AR100005009405', 10, 5, 94, 'PANDANWANGI', '65124'),
('AR100005009406', 10, 5, 94, 'BLIMBING', '65125'),
('AR100005009407', 10, 5, 94, 'PURWODADI', '65125'),
('AR100005009408', 10, 5, 94, 'ARJOSARI', '65126'),
('AR100005009409', 10, 5, 94, 'BALEARJOSARI', '65126'),
('AR100005009410', 10, 5, 94, 'POLOWIJEN', '65126'),
('AR100005009411', 10, 5, 94, 'JODIPAN', '65137'),
('AR100005009501', 10, 5, 95, 'ARJOWINANGUN', '65132'),
('AR100005009502', 10, 5, 95, 'TLOGOWARU', '65133'),
('AR100005009503', 10, 5, 95, 'MERGOSONO', '65134'),
('AR100005009504', 10, 5, 95, 'BUMIAYU', '65135'),
('AR100005009505', 10, 5, 95, 'WONOKOYO', '65135'),
('AR100005009506', 10, 5, 95, 'BURING', '65136'),
('AR100005009507', 10, 5, 95, 'KOTALAMA', '65136'),
('AR100005009508', 10, 5, 95, 'KEDUNGKANDANG', '65137'),
('AR100005009509', 10, 5, 95, 'CEMOROKANDANG', '65138'),
('AR100005009510', 10, 5, 95, 'LESANPURO', '65138'),
('AR100005009511', 10, 5, 95, 'MADYOPURO', '65139'),
('AR100005009512', 10, 5, 95, 'SAWOJAJAR', '65139'),
('AR100005009601', 10, 5, 96, 'KLOJEN', '65111'),
('AR100005009602', 10, 5, 96, 'RAMPAL CELAKET', '65111'),
('AR100005009603', 10, 5, 96, 'SAMAAN', '65112'),
('AR100005009604', 10, 5, 96, 'PENANGGUNGAN', '65113'),
('AR100005009605', 10, 5, 96, 'GADINGKASRI', '65115'),
('AR100005009606', 10, 5, 96, 'BARENG', '65116'),
('AR100005009607', 10, 5, 96, 'KASIN', '65117'),
('AR100005009608', 10, 5, 96, 'SUKOHARJO', '65118'),
('AR100005009609', 10, 5, 96, 'KAUMAN', '65119'),
('AR100005009610', 10, 5, 96, 'KIDUL DALEM', '65119'),
('AR100005009611', 10, 5, 96, 'ORO ORO DOWO', '65119'),
('AR100005009701', 10, 5, 97, 'JATIMULYO', '65141'),
('AR100005009702', 10, 5, 97, 'LOWOKWARU', '65141'),
('AR100005009703', 10, 5, 97, 'TULUSREJO', '65141'),
('AR100005009704', 10, 5, 97, 'MOJOLANGU', '65142'),
('AR100005009705', 10, 5, 97, 'TUNJUNGSEKAR', '65142'),
('AR100005009706', 10, 5, 97, 'TASIKMADU', '65143'),
('AR100005009707', 10, 5, 97, 'TUNGGULWULUNG', '65143'),
('AR100005009708', 10, 5, 97, 'DINOYO', '65144'),
('AR100005009709', 10, 5, 97, 'MERJOSARI', '65144'),
('AR100005009710', 10, 5, 97, 'TLOGOMAS', '65144'),
('AR100005009711', 10, 5, 97, 'KETAWANGGEDE', '65145'),
('AR100005009712', 10, 5, 97, 'SUMBERSARI', '65145'),
('AR100005009801', 10, 5, 98, 'BANDULAN', '65146'),
('AR100005009802', 10, 5, 98, 'PISANG CANDI', '65146'),
('AR100005009803', 10, 5, 98, 'MULYOREJO', '65147'),
('AR100005009804', 10, 5, 98, 'SUKUN', '65147'),
('AR100005009805', 10, 5, 98, 'TANJUNGREJO', '65147'),
('AR100005009806', 10, 5, 98, 'BAKALAN KRAJAN', '65148'),
('AR100005009807', 10, 5, 98, 'BANDUNGREJOSARI', '65148'),
('AR100005009808', 10, 5, 98, 'CIPTOMULYO', '65148'),
('AR100005009809', 10, 5, 98, 'GADANG', '65149'),
('AR100005009810', 10, 5, 98, 'KARANG BESUKI', '65149'),
('AR100009016567', 10, 9, 165, 'test', '65121');

-- --------------------------------------------------------

--
-- Table structure for table `m_cityregency`
--

CREATE TABLE `m_cityregency` (
  `id_cityregency` int(11) NOT NULL,
  `cityregency_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `m_cityregency`
--

INSERT INTO `m_cityregency` (`id_cityregency`, `cityregency_name`) VALUES
(1, 'KOTA BATU'),
(2, 'KOTA BLITAR'),
(4, 'KOTA MADIUN'),
(5, 'KOTA MALANG'),
(6, 'KOTA MOJOKERTO'),
(7, 'KOTA PASURUAN'),
(8, 'KOTA PROBOLINGGO'),
(9, 'KOTA SURABAYA'),
(10, 'KOTA KEDIRI'),
(11, 'KOTA MAGELANG'),
(12, 'KOTA SURAKARTA'),
(13, 'KOTA SALATIGA'),
(14, 'KOTA SEMARANG'),
(15, 'KOTA PEKALONGAN'),
(16, 'KOTA TEGAL'),
(17, 'KOTA BOGOR'),
(18, 'KOTA SUKABUMI'),
(19, 'KOTA BANDUNG'),
(20, 'KOTA CIREBON'),
(21, 'KOTA BEKASI'),
(22, 'KOTA DEPOK'),
(23, 'KOTA CIMAHI'),
(24, 'KOTA TASIKMALAYA'),
(25, 'KOTA BANJAR'),
(26, 'KOTA YOGYAKARTA'),
(27, 'KOTA JAKARTA PUSAT'),
(28, 'KOTA JAKARTA BARAT'),
(29, 'KOTA JAKARTA TIMUR'),
(30, 'KOTA JAKARTA SELATAN'),
(31, 'KOTA JAKARTA UTARA'),
(32, 'KABUPATEN PACITAN'),
(33, 'KABUPATEN PONOROGO'),
(34, 'KABUPATEN TRENGGALEK'),
(35, 'KABUPATEN TULUNGAGUNG'),
(36, 'KABUPATEN BLITAR'),
(37, 'KABUPATEN KEDIRI'),
(38, 'KABUPATEN MALANG'),
(39, 'KABUPATEN LUMAJANG'),
(40, 'KABUPATEN JEMBER'),
(41, 'KABUPATEN BANYUWANGI'),
(42, 'KABUPATEN BONDOWOSO'),
(43, 'KABUPATEN SITUBONDO'),
(44, 'KABUPATEN PROBOLINGGO'),
(45, 'KABUPATEN PASURUAN'),
(46, 'KABUPATEN SIDOARJO'),
(47, 'KABUPATEN MOJOKERTO'),
(48, 'KABUPATEN JOMBANG'),
(49, 'KABUPATEN NGANJUK'),
(50, 'KABUPATEN MADIUN'),
(51, 'KABUPATEN MAGETAN'),
(52, 'KABUPATEN NGAWI'),
(53, 'KABUPATEN BOJONEGORO'),
(54, 'KABUPATEN TUBAN'),
(55, 'KABUPATEN LAMONGAN'),
(56, 'KABUPATEN GRESIK'),
(57, 'KABUPATEN BANGKALAN'),
(58, 'KABUPATEN SAMPANG'),
(59, 'KABUPATEN SUMENEP'),
(60, 'KABUPATEN KULON PROGO'),
(61, 'KABUPATEN BANTUL'),
(62, 'KABUPATEN GUNUNGKIDUL'),
(63, 'KABUPATEN SLEMAN'),
(64, 'KABUPATEN KEPULAUAN SERIBU'),
(65, 'KABUPATEN BOGOR'),
(66, 'KABUPATEN SUKABUMI'),
(67, 'KABUPATEN CIANJUR'),
(68, 'KABUPATEN BANDUNG'),
(69, 'KABUPATEN GARUT'),
(70, 'KABUPATEN TASIKMALAYA'),
(71, 'KABUPATEN CIAMIS'),
(72, 'KABUPATEN KUNINGAN'),
(73, 'KABUPATEN CIREBON'),
(74, 'KABUPATEN MAJALENGKA'),
(75, 'KABUPATEN SUMEDANG'),
(76, 'KABUPATEN INDRAMAYU'),
(77, 'KABUPATEN SUBANG'),
(78, 'KABUPATEN PURWAKARTA'),
(79, 'KABUPATEN KARAWANG'),
(80, 'KABUPATEN BEKASI'),
(81, 'KABUPATEN BANDUNG BARAT'),
(82, 'KABUPATEN PANGANDARAN'),
(83, 'KABUPATEN CILACAP'),
(84, 'KABUPATEN BANYUMAS'),
(85, 'KABUPATEN PURBALINGGA'),
(86, 'KABUPATEN BANJARNEGARA'),
(87, 'KABUPATEN KEBUMEN'),
(88, 'KABUPATEN PURWOREJO'),
(89, 'KABUPATEN WONOSOBO'),
(90, 'KABUPATEN MAGELANG'),
(91, 'KABUPATEN BOYOLALI'),
(92, 'KABUPATEN SUKOHARJO'),
(93, 'KABUPATEN WONOGIRI'),
(94, 'KABUPATEN KARANGANYAR'),
(95, 'KABUPATEN SRAGEN'),
(96, 'KABUPATEN KLATEN'),
(97, 'KABUPATEN GROBOGAN'),
(98, 'KABUPATEN BLORA'),
(99, 'KABUPATEN REMBANG'),
(100, 'KABUPATEN PATI'),
(101, 'KABUPATEN KUDUS'),
(102, 'KABUPATEN JEPARA'),
(103, 'KABUPATEN DEMAK'),
(104, 'KABUPATEN SEMARANG'),
(105, 'KABUPATEN TEMANGGUNG'),
(106, 'KABUPATEN KENDAL'),
(107, 'KABUPATEN BATANG'),
(108, 'KABUPATEN PEKALONGAN'),
(109, 'KABUPATEN PEMALANG'),
(110, 'KABUPATEN TEGAL'),
(111, 'KABUPATEN BREBES');

-- --------------------------------------------------------

--
-- Table structure for table `m_consignee`
--

CREATE TABLE `m_consignee` (
  `id_consignee` int(11) NOT NULL,
  `id_shipper` int(11) NOT NULL,
  `reg_to` varchar(50) NOT NULL,
  `full_address` varchar(255) NOT NULL,
  `phone_number` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `m_district`
--

CREATE TABLE `m_district` (
  `id_district` int(11) NOT NULL,
  `district_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `m_district`
--

INSERT INTO `m_district` (`id_district`, `district_name`) VALUES
(1, 'BATU'),
(2, 'BUMIAJI'),
(3, 'JUNREJO'),
(4, 'KEPANJEN KIDUL'),
(5, 'SANAN WETAN'),
(7, 'BAKUNG'),
(8, 'BINANGUN'),
(9, 'DOKO'),
(10, 'GANDUSARI'),
(11, 'GARUM'),
(13, 'KANIGORO'),
(15, 'NGLEGOK'),
(16, 'PANGGUNGREJO'),
(17, 'PONGGOK'),
(18, 'SANAN KULON'),
(19, 'SELOPURO'),
(20, 'SELOREJO'),
(21, 'SRENGAT'),
(22, 'SUTOJAYAN'),
(24, 'UDANAWU'),
(26, 'WLINGI'),
(27, 'WONODADI'),
(28, 'WONOTIRTO'),
(29, 'JOMBANG'),
(30, 'PETERONGAN'),
(31, 'KESAMBEN'),
(32, 'MOJOAGUNG'),
(34, 'BARENG'),
(35, 'PLOSO'),
(36, 'TEMBELANG'),
(37, 'SUMOBITO'),
(38, 'DIWEK'),
(39, 'JOGOROTO'),
(40, 'KUDU'),
(41, 'KABUH'),
(42, 'WONOSALAM'),
(43, 'PLANDAAN'),
(44, 'BANDAR KEDUNGMULYO'),
(45, 'MEGALUH'),
(46, 'MOJOWARNO'),
(47, 'NGUSIKKAN'),
(48, 'PERAK'),
(49, 'KEDIRI KOTA'),
(50, 'MOJOROTO'),
(51, 'PESANTREN'),
(52, 'BADAS'),
(53, 'BANYAKAN'),
(54, 'GAMPENGREJO'),
(55, 'GROGOL'),
(56, 'KANDANGAN'),
(57, 'KANDAT'),
(58, 'KAYEN KIDUL'),
(59, 'KEPUNG'),
(60, 'KRAS'),
(61, 'KUNJANG'),
(62, 'MOJO'),
(63, 'NGADILUWIH'),
(64, 'NGANCAR'),
(65, 'NGASEM'),
(66, 'PAGU'),
(67, 'PAPAR'),
(68, 'PARE'),
(69, 'PLEMAHAN'),
(70, 'PLOSOKLATEN'),
(71, 'PUNCU'),
(73, 'RINGINREJO'),
(74, 'SEMEN'),
(75, 'TAROKAN'),
(76, 'WATES'),
(77, 'KARTOHARJO'),
(78, 'MANGUHARJO'),
(79, 'TAMAN'),
(80, 'BALEREJO'),
(81, 'DAGANGAN'),
(82, 'DOLOPO'),
(83, 'GEGER'),
(84, 'GEMARANG'),
(85, 'JIWAN'),
(86, 'KEBONSARI'),
(87, 'MADIUN'),
(88, 'KARE'),
(89, 'PILANGKENCENG'),
(90, 'SARADAN'),
(93, 'WUNGU'),
(94, 'BLIMBING'),
(95, 'KEDUNGKANDANG'),
(96, 'KLOJEN'),
(97, 'LOWOKWARU'),
(98, 'SUKUN'),
(99, 'AMPELGADING'),
(100, 'BANTUR'),
(101, 'BULULAWANG'),
(102, 'DAMPIT'),
(103, 'DAU'),
(104, 'DONOMULYO'),
(105, 'GEDANGAN'),
(106, 'GONDANGLEGI'),
(107, 'JABUNG'),
(108, 'KALIPARE'),
(109, 'KARANGPLOSO'),
(110, 'KASEMBON'),
(111, 'KEPANJEN'),
(112, 'KROMENGAN'),
(113, 'LAWANG'),
(114, 'NGAJUM'),
(115, 'NGANTANG'),
(116, 'PAGAK'),
(117, 'PAGELARAN'),
(119, 'PAKISAJI'),
(120, 'PONCOKUSUMO'),
(121, 'PUJON'),
(122, 'SINGOSARI'),
(123, 'SUMBERMANJING WETAN'),
(124, 'SUMBERPUCUNG'),
(125, 'TAJINAN'),
(126, 'TIRTOYUDO'),
(127, 'TUMPANG'),
(128, 'TUREN'),
(129, 'WAGIR'),
(130, 'WAJAK'),
(131, 'WONOSARI'),
(132, 'MAGERSARI'),
(133, 'PRAJURIT KULON'),
(134, 'BANGSAR'),
(135, 'DAWAR BLANDONG'),
(136, 'DLANGGU'),
(137, 'GEDEG'),
(138, 'GONDANG'),
(139, 'JATIREJO'),
(141, 'KEMLAGI'),
(142, 'KUTOREJO'),
(143, 'MOJOANYAR'),
(144, 'MOJOSARI'),
(145, 'NGORO'),
(146, 'PACET'),
(147, 'PUNGGING'),
(148, 'PURI'),
(149, 'SOOKO'),
(150, 'TRAWAS'),
(151, 'TROWULAN'),
(152, 'BUGUL KIDUL'),
(153, 'GADINGREJO'),
(154, 'PURWOREJO'),
(155, 'BANGIL'),
(158, 'GONDANG WETAN'),
(159, 'GRATI'),
(160, 'KEJAYAN'),
(162, 'LEKOK'),
(164, 'NGULING'),
(165, 'PANDAAN'),
(166, 'PASREPAN'),
(167, 'POHJENTREK'),
(168, 'PRIGEN'),
(169, 'PURWODADI'),
(170, 'PURWOSARI'),
(171, 'PUSPO'),
(172, 'REJOSO'),
(173, 'REMBANG'),
(174, 'SUKOREJO'),
(175, 'TOSARI'),
(176, 'TUTUR'),
(177, 'WINONGAN'),
(178, 'WONOREJO'),
(179, 'KADEMANGAN'),
(180, 'MAYANGAN'),
(181, 'WONOASIH'),
(182, 'BANTARAN'),
(183, 'BANYU ANYAR'),
(184, 'BESUK'),
(185, 'DRINGU'),
(186, 'GADING'),
(187, 'GENDING'),
(188, 'KOTA ANYAR'),
(189, 'KRAKSAAN'),
(190, 'KREJENGAN'),
(191, 'KRUCIL'),
(192, 'KURIPAN'),
(193, 'LECES'),
(194, 'LUMBANG'),
(195, 'MARON'),
(196, 'PAITON'),
(197, 'PAJARAKAN'),
(198, 'PAKUNIRAN'),
(199, 'SUKAPURA'),
(201, 'SUMBERASIH'),
(202, 'TEGAL SIWALAN'),
(203, 'TIRIS'),
(204, 'TONGAS'),
(205, 'WONOMERTO'),
(206, 'ASEMROWO'),
(207, 'BENOWO'),
(208, 'BUBUTAN'),
(209, 'BULAK'),
(210, 'DUKUH PAKIS'),
(211, 'GAYUNGAN'),
(212, 'GENTENG'),
(213, 'GUBENG'),
(214, 'GUNUNGANYAR'),
(215, 'JAMBANGAN'),
(216, 'KARANGPILANG'),
(217, 'KENJERAN'),
(218, 'KREMBANGAN'),
(219, 'LAKAR SANTRI'),
(220, 'MULYOREJO'),
(221, 'PABEAN CANTIKAN'),
(222, 'PAKAL'),
(223, 'RUNGKUT'),
(224, 'SAMBIKEREP'),
(225, 'SAWAHAN'),
(226, 'SEMAMPIR'),
(227, 'SIMOKERTO'),
(228, 'SUKOLILO'),
(229, 'SUKOMANUNGGAL'),
(230, 'TAMBAKSARI'),
(231, 'TANDES'),
(232, 'TEGALSARI'),
(233, 'TENGGILIS MEJOYO'),
(234, 'WIYUNG'),
(235, 'WONOCOLO'),
(236, 'WONOKROMO'),
(237, 'BANDONGAN'),
(238, 'BOROBUDUR'),
(239, 'CANDIMULYO'),
(240, 'DUKUN'),
(241, 'GRABAG'),
(242, 'KAJORAN'),
(243, 'KALIANGKRIK'),
(244, 'MERTOYUDAN'),
(245, 'MUNGKID'),
(246, 'MUNTILAN'),
(247, 'NGABLAK'),
(248, 'NGLUWAR'),
(249, 'PAKIS'),
(250, 'SALAM'),
(251, 'SALAMAN'),
(253, 'SECANG'),
(254, 'SRUMBUNG'),
(256, 'TEMPURAN'),
(257, 'WINDUSARI'),
(258, 'BANJARSARI'),
(259, 'JEBRES'),
(260, 'LAWEYAN'),
(261, 'PASAR KLIWON'),
(262, 'SERENGAN'),
(263, 'ARGOMULYO'),
(264, 'SIDOMUKTI'),
(265, 'SIDOREJO'),
(266, 'TINGKIR'),
(267, 'BANYUMANIK'),
(268, 'CANDISARI'),
(269, 'GAJAH MUNGKUR'),
(270, 'GAYAMSARI'),
(271, 'GENUK'),
(272, 'GUNUNGPATI'),
(273, 'MIJEN'),
(274, 'NGALIYAN'),
(275, 'PEDURUNGAN'),
(276, 'SEMARANG BARAT'),
(277, 'SEMARANG SELATAN'),
(278, 'SEMARANG TENGAH'),
(279, 'SEMARANG TIMUR'),
(280, 'SEMARANG UTARA'),
(281, 'TEMBALANG'),
(282, 'TUGU'),
(284, 'BUARAN'),
(285, 'DORO'),
(286, 'KAJEN'),
(287, 'KANDANGSERANG'),
(288, 'KARANGANYAR'),
(289, 'KARANGDADAP'),
(290, 'KEDUNGWUNI'),
(291, 'KESESI'),
(292, 'LEBAKBARANG'),
(293, 'PANINGGARAN'),
(294, 'PETUNGKRIONO'),
(295, 'SIWALAN'),
(296, 'SRAGI'),
(298, 'TIRTO'),
(299, 'WIRADESA'),
(300, 'WONOKERTO'),
(301, 'WONOPRINGGO'),
(302, 'ADIWERNA'),
(303, 'BALAPULANG'),
(304, 'BOJONG'),
(305, 'BUMIJAWA'),
(306, 'DUKUHTURI'),
(307, 'DUKUHWARU'),
(308, 'JATINEGARA'),
(309, 'KEDUNG BANTENG'),
(310, 'KRAMAT'),
(311, 'LEBAKSIU'),
(312, 'MARGASARI'),
(313, 'PAGERBARANG'),
(314, 'PANGKAH'),
(315, 'SLAWI'),
(316, 'SURODADI'),
(317, 'KECAMATAN'),
(318, 'TALANG'),
(319, 'TARUB'),
(320, 'WARUREJO'),
(321, 'BOGOR BARAT'),
(322, 'BOGOR SELATAN'),
(323, 'BOGOR TENGAH'),
(324, 'BOGOR TIMUR'),
(325, 'BOGOR UTARA'),
(326, 'TANAH SAREAL'),
(327, 'BANTAR GADUNG'),
(328, 'BOJONG GENTENG'),
(329, 'CARINGIN'),
(330, 'CIAMBAR'),
(331, 'CIBADAK'),
(332, 'CIBITUNG'),
(333, 'CICANTAYAN'),
(334, 'CICURUG'),
(336, 'CIDAHU'),
(337, 'CIDOLOG'),
(338, 'CIEMAS'),
(339, 'CIKAKAK'),
(340, 'CIKEMBAR'),
(341, 'CIKIDANG'),
(342, 'CIMANGGU'),
(343, 'CIRACAP'),
(344, 'CIREUNGHAS'),
(345, 'CISAAT'),
(346, 'CISOLOK'),
(347, 'CURUGKEMBAR'),
(348, 'GEGER BITUNG'),
(349, 'GUNUNG GURUH'),
(350, 'JAMPANG KULON'),
(351, 'JAMPANG TENGAH'),
(352, 'KABANDUNGAN'),
(353, 'KADUDAMPIT'),
(354, 'KALAPA NUNGGAL'),
(355, 'KALI BUNDER'),
(356, 'KEBONPEDES'),
(358, 'NAGRAK'),
(359, 'NYALINDUNG'),
(361, 'PARAKAN SALAK'),
(362, 'PARUNG KUDA'),
(363, 'PELABUHAN RATU'),
(364, 'PURABAYA'),
(365, 'SAGARANTEN'),
(366, 'SIMPENAN'),
(367, 'SUKABUMI'),
(368, 'SUKALARANG'),
(369, 'SUKARAJA'),
(370, 'SURADE'),
(371, 'TEGAL BULEUD'),
(372, 'WALURAN'),
(373, 'WARUNG KIARA'),
(374, 'ANDIR'),
(375, 'CICADAS'),
(376, 'ARCAMANIK'),
(377, 'ASTANA ANYAR'),
(378, 'BABAKAN CIPARAY'),
(379, 'GUNUNG KIDUL'),
(380, 'BANDUNG KULON'),
(381, 'BANDUNG WETAN'),
(382, 'BATUNUNGGAL'),
(383, 'BOJONGLOA KALER'),
(384, 'BOJONGLOA KIDUL'),
(385, 'BUAHBATU'),
(386, 'CIBEUNYING KALER'),
(387, 'CIBEUNYING KIDUL'),
(388, 'CIBIRU'),
(389, 'CICENDO'),
(390, 'CIDADAP'),
(391, 'CINAMBO'),
(392, 'COBLONG'),
(393, 'GEDEBAGE'),
(394, 'KIARACONDONG'),
(395, 'LENGKONG'),
(396, 'MANDALA JATI'),
(397, 'PANYILEUKAN'),
(398, 'RANCASARI'),
(399, 'REGOL'),
(400, 'SUKAJADI'),
(401, 'SUMUR BANDUNG'),
(402, 'UJUNG BERUNG'),
(403, 'BANTAR GEBANG'),
(404, 'BEKASI BARAT'),
(405, 'BEKASI SELATAN'),
(406, 'BEKASI TIMUR'),
(407, 'BEKASI UTARA'),
(408, 'JATI SAMPURNA'),
(409, 'JATIASIH'),
(410, 'MEDAN SATRIA'),
(411, 'MUSTIKA JAYA'),
(412, 'PONDOK GEDE'),
(413, 'PONDOK MELATI'),
(414, 'RAWALUMBU'),
(415, 'ARJAWINANGUN'),
(416, 'ASTANAJAPURA'),
(417, 'BABAKAN'),
(418, 'BEBER'),
(419, 'CILEDUG'),
(420, 'CIWARINGIN'),
(421, 'DEPOK'),
(422, 'DUKUPUNTANG'),
(423, 'GEBANG'),
(424, 'GEGESIK'),
(425, 'GEMPOL'),
(426, 'GREGED'),
(427, 'GUNUNG JATI'),
(428, 'JAMBLANG'),
(429, 'KALIWEDI'),
(430, 'KAPETAKAN'),
(431, 'KARANGSEMBUNG'),
(432, 'KARANGWARENG'),
(433, 'KEDAWUNG'),
(434, 'KLANGENAN'),
(435, 'LEMAHABANG'),
(436, 'LOSARI'),
(437, 'MUNDU'),
(438, 'PABEDILAN'),
(439, 'PABUARAN'),
(440, 'PALIMANAN'),
(441, 'PANGENAN'),
(442, 'PANGURAGAN'),
(443, 'PASALEMAN'),
(444, 'PLERED'),
(445, 'PLUMBON'),
(446, 'SEDONG'),
(447, 'SUMBER'),
(448, 'SURANENGGALA'),
(449, 'SUSUKAN'),
(450, 'SUSUKAN LEBAK'),
(451, 'TALUN'),
(452, 'TENGAH TANI'),
(453, 'WALED'),
(454, 'WERU'),
(455, 'BEJI'),
(456, 'CIMANGGIS'),
(457, 'LIMO'),
(458, 'PANCORAN MAS'),
(459, 'SAWANGAN'),
(460, 'SUKMAJAYA'),
(461, 'CIMAHI SELATAN'),
(462, 'CIMAHI TENGAH'),
(463, 'CIMAHI UTARA'),
(464, 'BUNGURSARI'),
(465, 'CIBEUREUM'),
(466, 'CIHIDEUNG'),
(467, 'CIPEDES'),
(468, 'INDIHIANG'),
(469, 'KAWALU'),
(470, 'MANGKUBUMI'),
(471, 'PURBARATU'),
(472, 'TAMANSARI'),
(473, 'TAWANG'),
(474, 'BANJAR'),
(475, 'LANGENSARI'),
(476, 'PATARUMAN'),
(477, 'PURWAHARJA'),
(478, 'DANUREJAN'),
(479, 'GEDONG TENGEN'),
(480, 'GONDOKUSUMAN'),
(481, 'GONDOMANAN'),
(482, 'JETIS'),
(483, 'KOTAGEDE'),
(484, 'KRATON'),
(485, 'MANTRIJERON'),
(486, 'MERGANGSAN'),
(487, 'NGAMPILAN'),
(488, 'PAKUALAMAN'),
(489, 'TEGALREJO'),
(490, 'UMBULHARJO'),
(491, 'WIROBRAJAN');

-- --------------------------------------------------------

--
-- Table structure for table `m_fleet`
--

CREATE TABLE `m_fleet` (
  `id_vehicle` int(11) NOT NULL,
  `license_plate` varchar(20) NOT NULL,
  `vehicle_type` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `m_fleet`
--

INSERT INTO `m_fleet` (`id_vehicle`, `license_plate`, `vehicle_type`) VALUES
(1, 'N 7131 AL', 'SEPEDA MOTOR'),
(2, 'N 1980 LJ', 'SEPEDA MOTOR'),
(3, 'N 5224 AB', 'SEPEDA MOTOR'),
(4, 'N 8341 PO', 'TRUCK'),
(5, 'N 3213 QS', 'TRUCK'),
(6, 'N 4220 PJ', 'TRUCK'),
(7, 'N 9123 XF', 'MOBIL BOX'),
(8, 'N 6153 OL', 'MOBIL BOX'),
(9, 'N 7747 BV', 'MOBIL BOX');

-- --------------------------------------------------------

--
-- Table structure for table `m_price`
--

CREATE TABLE `m_price` (
  `id_price` int(11) NOT NULL,
  `id_origin` int(11) NOT NULL,
  `id_destination` int(11) NOT NULL,
  `id_service` int(11) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `m_province`
--

CREATE TABLE `m_province` (
  `id_province` int(11) NOT NULL,
  `province_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `m_province`
--

INSERT INTO `m_province` (`id_province`, `province_name`) VALUES
(1, 'ACEH'),
(2, 'BALI'),
(3, 'BANTEN'),
(4, 'BENGKULU'),
(5, 'GORONTALO'),
(6, 'JAKARTA'),
(7, 'JAMBI'),
(8, 'JAWA BARAT'),
(9, 'JAWA TENGAH'),
(10, 'JAWA TIMUR'),
(11, 'KALIMANTAN BARAT'),
(12, 'KALIMANTAN SELATAN'),
(13, 'KALIMANTAN TENGAH'),
(14, 'KALIMANTAN TIMUR'),
(15, 'KALIMANTAN UTARA'),
(16, 'KEPULAUAN BANGKA BELITUNG'),
(17, 'KEPULAUAN RIAU'),
(18, 'LAMPUNG'),
(19, 'MALUKU'),
(20, 'MALUKU UTARA'),
(21, 'NUSA TENGGARA BARAT'),
(22, 'NUSA TENGGARA TIMUR'),
(23, 'PAPUA'),
(24, 'PAPUA BARAT'),
(25, 'RIAU'),
(26, 'SULAWESI BARAT'),
(27, 'SULAWESI SELATAN'),
(28, 'SULAWESI TENGAH'),
(29, 'SULAWESI TENGGARA'),
(30, 'SULAWESI UTARA'),
(31, 'SUMATERA BARAT'),
(32, 'SUMATERA SELATAN'),
(33, 'SUMATERA UTARA'),
(34, 'YOGYAKARTA');

-- --------------------------------------------------------

--
-- Table structure for table `m_service`
--

CREATE TABLE `m_service` (
  `id_service` int(11) NOT NULL,
  `service_name` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `m_service`
--

INSERT INTO `m_service` (`id_service`, `service_name`) VALUES
(1, 'REGULAR'),
(2, 'QUICK'),
(3, 'EXCLUSIVE'),
(4, 'ZOOM-ZOOM'),
(5, 'PLATINUM');

-- --------------------------------------------------------

--
-- Table structure for table `m_shipper`
--

CREATE TABLE `m_shipper` (
  `id_shipper` int(11) NOT NULL,
  `id_trx` varchar(20) NOT NULL,
  `reg_to` varchar(50) NOT NULL,
  `full_address` varchar(255) NOT NULL,
  `phone_number` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `m_transaction`
--

CREATE TABLE `m_transaction` (
  `id_trx` varchar(20) NOT NULL,
  `id_admin` int(11) NOT NULL,
  `id_courier` int(11) NOT NULL,
  `id_fleet` int(11) NOT NULL,
  `id_origin` varchar(20) NOT NULL,
  `id_destination` varchar(20) NOT NULL,
  `pkg_details` varchar(100) NOT NULL,
  `pkg_weight` int(11) NOT NULL,
  `pkg_type` int(11) NOT NULL,
  `service_type` int(11) NOT NULL,
  `date_reg` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `date_arrived` datetime NOT NULL,
  `trx_status` int(2) DEFAULT '0',
  `total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `m_type`
--

CREATE TABLE `m_type` (
  `id_type` int(11) NOT NULL,
  `type_name` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `m_type`
--

INSERT INTO `m_type` (`id_type`, `type_name`) VALUES
(1, 'GLASSY'),
(2, 'ELECTRONIC'),
(3, 'DOCUMENT'),
(4, 'FOOD & BEVERAGE'),
(5, 'OTHER');

-- --------------------------------------------------------

--
-- Table structure for table `t_admin`
--

CREATE TABLE `t_admin` (
  `id_admin` int(11) NOT NULL,
  `id_employee` int(11) NOT NULL,
  `username` varchar(25) NOT NULL,
  `password` varchar(100) NOT NULL,
  `date_reg` datetime NOT NULL,
  `permit` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `t_admin`
--

INSERT INTO `t_admin` (`id_admin`, `id_employee`, `username`, `password`, `date_reg`, `permit`) VALUES
(1, 1, 'kaboel', 'kaboel', '2018-11-30 00:28:26', 1),
(2, 2, 'hesti', 'hesti', '2018-12-12 00:42:49', 0);

-- --------------------------------------------------------

--
-- Table structure for table `t_employee`
--

CREATE TABLE `t_employee` (
  `id_employee` int(11) NOT NULL,
  `lastname` varchar(25) NOT NULL,
  `firstname` varchar(25) NOT NULL,
  `gender` int(2) DEFAULT NULL,
  `email` varchar(25) NOT NULL,
  `address` varchar(100) NOT NULL,
  `phone` varchar(25) NOT NULL,
  `date_reg` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `date_upd` datetime DEFAULT NULL,
  `position` int(2) NOT NULL,
  `activation` int(2) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `t_employee`
--

INSERT INTO `t_employee` (`id_employee`, `lastname`, `firstname`, `gender`, `email`, `address`, `phone`, `date_reg`, `date_upd`, `position`, `activation`) VALUES
(1, 'Allam', 'Faiq', 1, 'faiq.kaboel@gmail.com', 'jl. batubara', '081515291890', '2018-11-30 01:04:35', NULL, 0, 1),
(2, 'Febriyani', 'Hesti', 0, 'hesti.febriyani115@gmail.', 'jl. bandulan', '08123456789', '2018-11-30 01:07:07', NULL, 1, 1),
(3, 'Tantular', 'Robert', 1, 'robert@gmail.com', 'jl. raya tumpang', '08111222333', '2018-12-14 02:43:10', NULL, 1, 1),
(4, 'Sujadi', 'Andrew', 1, 'ansuj@gmail.com', 'jl. kembang turi', '08222111333', '2018-12-14 02:43:53', NULL, 1, 1),
(5, 'Suryawan', 'Johnny', 1, 'johnny.sur@gmail.com', 'jl. taliban', '08299299111', '2018-12-14 02:55:06', NULL, 1, 1),
(6, 'Elizabeth', 'Siti', 0, 'siti.hehe@gmail.com', 'jl. sulfat', '089722980212', '2018-12-14 02:55:06', NULL, 2, 1),
(7, 'Saritem', 'Jenny', 0, 'jennem@gmail.com', 'jl. sawojajar', '083211091921', '2018-12-14 02:55:06', NULL, 2, 1),
(8, 'Hendrawan', 'Alex', 1, 'mr.alex@gmail.com', 'jl. tenaga', '085122098777', '2018-12-14 02:55:06', NULL, 1, 1),
(9, 'Van Bosch', 'Ayu', 1, 'vanayu@gmail.com', 'jl. ijen', '081211790900', '2018-12-14 02:55:06', NULL, 2, 1),
(10, 'Ferguso', 'Aji', 1, 'goool@gmail.com', 'jl. kembang mayit', '08999666000', '2018-12-14 02:55:06', NULL, 1, 1),
(12, 'Wellick', 'Tyrell', 1, 'wellick.ty@email.com', 'Jl. Sukodiharjo', '08921222453', '2018-12-19 04:27:52', NULL, 0, 1),
(13, 'Alderson', 'Elliot', 1, 'elliot.alderson@email.com', 'Jl. wikwik', '08124133452', '2018-12-19 04:33:46', NULL, 3, 1),
(14, 'Moss', 'Angela', 0, 'moss.angela@mrrobot.com', 'Jl. Sunan Kalijaga', '08123331241', '2018-12-21 07:39:31', NULL, 2, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `m_area`
--
ALTER TABLE `m_area`
  ADD PRIMARY KEY (`id_area`),
  ADD KEY `fk_area_district` (`id_district`),
  ADD KEY `fk_area_cireg` (`id_cityregency`),
  ADD KEY `fk_area_prov` (`id_province`);

--
-- Indexes for table `m_cityregency`
--
ALTER TABLE `m_cityregency`
  ADD PRIMARY KEY (`id_cityregency`);

--
-- Indexes for table `m_consignee`
--
ALTER TABLE `m_consignee`
  ADD PRIMARY KEY (`id_consignee`),
  ADD KEY `fk_ship_cons` (`id_shipper`);

--
-- Indexes for table `m_district`
--
ALTER TABLE `m_district`
  ADD PRIMARY KEY (`id_district`);

--
-- Indexes for table `m_fleet`
--
ALTER TABLE `m_fleet`
  ADD PRIMARY KEY (`id_vehicle`),
  ADD UNIQUE KEY `license_plate` (`license_plate`);

--
-- Indexes for table `m_price`
--
ALTER TABLE `m_price`
  ADD PRIMARY KEY (`id_price`),
  ADD KEY `fk_prc_orig` (`id_origin`),
  ADD KEY `fk_prc_dest` (`id_destination`),
  ADD KEY `fk_prc_serv` (`id_service`);

--
-- Indexes for table `m_province`
--
ALTER TABLE `m_province`
  ADD PRIMARY KEY (`id_province`);

--
-- Indexes for table `m_service`
--
ALTER TABLE `m_service`
  ADD PRIMARY KEY (`id_service`);

--
-- Indexes for table `m_shipper`
--
ALTER TABLE `m_shipper`
  ADD PRIMARY KEY (`id_shipper`),
  ADD KEY `fk_ship_trx` (`id_trx`);

--
-- Indexes for table `m_transaction`
--
ALTER TABLE `m_transaction`
  ADD PRIMARY KEY (`id_trx`),
  ADD KEY `fk_admin_trx` (`id_admin`),
  ADD KEY `fk_service_trx` (`service_type`),
  ADD KEY `fk_type_trx` (`pkg_type`),
  ADD KEY `fk_courier_trx` (`id_courier`),
  ADD KEY `fk_fleet_trx` (`id_fleet`),
  ADD KEY `fk_trx_orig` (`id_origin`),
  ADD KEY `fk_trx_dest` (`id_destination`);

--
-- Indexes for table `m_type`
--
ALTER TABLE `m_type`
  ADD PRIMARY KEY (`id_type`);

--
-- Indexes for table `t_admin`
--
ALTER TABLE `t_admin`
  ADD PRIMARY KEY (`id_admin`),
  ADD KEY `fk_admin_emp` (`id_employee`);

--
-- Indexes for table `t_employee`
--
ALTER TABLE `t_employee`
  ADD PRIMARY KEY (`id_employee`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `m_cityregency`
--
ALTER TABLE `m_cityregency`
  MODIFY `id_cityregency` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=112;

--
-- AUTO_INCREMENT for table `m_consignee`
--
ALTER TABLE `m_consignee`
  MODIFY `id_consignee` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `m_district`
--
ALTER TABLE `m_district`
  MODIFY `id_district` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=492;

--
-- AUTO_INCREMENT for table `m_fleet`
--
ALTER TABLE `m_fleet`
  MODIFY `id_vehicle` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `m_price`
--
ALTER TABLE `m_price`
  MODIFY `id_price` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `m_province`
--
ALTER TABLE `m_province`
  MODIFY `id_province` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT for table `m_service`
--
ALTER TABLE `m_service`
  MODIFY `id_service` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `m_shipper`
--
ALTER TABLE `m_shipper`
  MODIFY `id_shipper` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `m_type`
--
ALTER TABLE `m_type`
  MODIFY `id_type` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `t_admin`
--
ALTER TABLE `t_admin`
  MODIFY `id_admin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `t_employee`
--
ALTER TABLE `t_employee`
  MODIFY `id_employee` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `m_area`
--
ALTER TABLE `m_area`
  ADD CONSTRAINT `fk_area_cireg` FOREIGN KEY (`id_cityregency`) REFERENCES `m_cityregency` (`id_cityregency`),
  ADD CONSTRAINT `fk_area_district` FOREIGN KEY (`id_district`) REFERENCES `m_district` (`id_district`),
  ADD CONSTRAINT `fk_area_prov` FOREIGN KEY (`id_province`) REFERENCES `m_province` (`id_province`);

--
-- Constraints for table `m_consignee`
--
ALTER TABLE `m_consignee`
  ADD CONSTRAINT `fk_ship_cons` FOREIGN KEY (`id_shipper`) REFERENCES `m_shipper` (`id_shipper`);

--
-- Constraints for table `m_price`
--
ALTER TABLE `m_price`
  ADD CONSTRAINT `fk_prc_dest` FOREIGN KEY (`id_destination`) REFERENCES `m_province` (`id_province`),
  ADD CONSTRAINT `fk_prc_orig` FOREIGN KEY (`id_origin`) REFERENCES `m_province` (`id_province`),
  ADD CONSTRAINT `fk_prc_serv` FOREIGN KEY (`id_service`) REFERENCES `m_service` (`id_service`);

--
-- Constraints for table `m_shipper`
--
ALTER TABLE `m_shipper`
  ADD CONSTRAINT `fk_ship_trx` FOREIGN KEY (`id_trx`) REFERENCES `m_transaction` (`id_trx`);

--
-- Constraints for table `m_transaction`
--
ALTER TABLE `m_transaction`
  ADD CONSTRAINT `fk_admin_trx` FOREIGN KEY (`id_admin`) REFERENCES `t_admin` (`id_admin`),
  ADD CONSTRAINT `fk_courier_trx` FOREIGN KEY (`id_courier`) REFERENCES `t_employee` (`id_employee`),
  ADD CONSTRAINT `fk_fleet_trx` FOREIGN KEY (`id_fleet`) REFERENCES `m_fleet` (`id_vehicle`),
  ADD CONSTRAINT `fk_service_trx` FOREIGN KEY (`service_type`) REFERENCES `m_service` (`id_service`),
  ADD CONSTRAINT `fk_trx_dest` FOREIGN KEY (`id_destination`) REFERENCES `m_area` (`id_area`),
  ADD CONSTRAINT `fk_trx_orig` FOREIGN KEY (`id_origin`) REFERENCES `m_area` (`id_area`),
  ADD CONSTRAINT `fk_type_trx` FOREIGN KEY (`pkg_type`) REFERENCES `m_type` (`id_type`);

--
-- Constraints for table `t_admin`
--
ALTER TABLE `t_admin`
  ADD CONSTRAINT `fk_admin_emp` FOREIGN KEY (`id_employee`) REFERENCES `t_employee` (`id_employee`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
