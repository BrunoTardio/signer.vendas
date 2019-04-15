-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 15-Abr-2019 às 20:46
-- Versão do servidor: 10.1.37-MariaDB
-- versão do PHP: 7.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `curso_spring`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `agenda`
--

CREATE TABLE `agenda` (
  `pedido_id` int(11) NOT NULL,
  `data` datetime DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL,
  `login` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`id`, `login`, `senha`) VALUES
(1, 'brunotardio@gmail.com', '123'),
(2, 'tardio@gmail.com', '123'),
(3, 'fernando@gmail.com', '123'),
(4, 'gustavo@gmail.com', '123'),
(5, 'bruno@gmail.com', '123');

-- --------------------------------------------------------

--
-- Estrutura da tabela `clientepf`
--

CREATE TABLE `clientepf` (
  `id` int(11) NOT NULL,
  `cei` varchar(255) DEFAULT NULL,
  `cpf` varchar(255) DEFAULT NULL,
  `nascimento` datetime DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `pis` varchar(255) DEFAULT NULL,
  `cliente_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `clientepf`
--

INSERT INTO `clientepf` (`id`, `cei`, `cpf`, `nascimento`, `nome`, `pis`, `cliente_id`) VALUES
(1, '1910509', '0907777777', '2000-02-21 02:00:00', 'Bruno Tardio', '1515', 1),
(2, '191919', '865656555', '1980-02-21 03:00:00', 'Augosto Silva', '1015', 2),
(3, '0013319', '090770007', '1990-02-21 03:00:00', 'Marcelo Divino', '1512', 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `clientepj`
--

CREATE TABLE `clientepj` (
  `id` int(11) NOT NULL,
  `cnpj` varchar(255) DEFAULT NULL,
  `inscricao_estadual` varchar(255) DEFAULT NULL,
  `nome_empresa` varchar(255) DEFAULT NULL,
  `nome_fantasia` varchar(255) DEFAULT NULL,
  `tributacao` varchar(255) DEFAULT NULL,
  `cliente_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `clientepj`
--

INSERT INTO `clientepj` (`id`, `cnpj`, `inscricao_estadual`, `nome_empresa`, `nome_fantasia`, `tributacao`, `cliente_id`) VALUES
(1, '44777799595', '9600600', 'TardioTEC', 'Tardio aplicacoes', 'mei', 1),
(2, '65656005', '9322200', 'TardioTEC 02 ', 'Tardio websites', 'simples', 1),
(3, '000651050', '4444444', 'Limtda', 'Gustavo mecanico', 'eirele', 4);

-- --------------------------------------------------------

--
-- Estrutura da tabela `clienterg`
--

CREATE TABLE `clienterg` (
  `id` int(11) NOT NULL,
  `data_expedicao` datetime DEFAULT NULL,
  `nome_da_mae` varchar(255) DEFAULT NULL,
  `nome_do_pai` varchar(255) DEFAULT NULL,
  `nome_titular` varchar(255) DEFAULT NULL,
  `numerorg` varchar(255) DEFAULT NULL,
  `orgao_expeditor` varchar(255) DEFAULT NULL,
  `cliente_pf` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `clienterg`
--

INSERT INTO `clienterg` (`id`, `data_expedicao`, `nome_da_mae`, `nome_do_pai`, `nome_titular`, `numerorg`, `orgao_expeditor`, `cliente_pf`) VALUES
(1, '2010-02-21 03:00:00', 'cristiane', 'elias', 'Bruno Tardio', '0000', 'ssp', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente_eleitor`
--

CREATE TABLE `cliente_eleitor` (
  `id` int(11) NOT NULL,
  `cidade` varchar(255) DEFAULT NULL,
  `numero` varchar(255) DEFAULT NULL,
  `secao` varchar(255) DEFAULT NULL,
  `uf` varchar(255) DEFAULT NULL,
  `zona` varchar(255) DEFAULT NULL,
  `cliente_pf` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cliente_eleitor`
--

INSERT INTO `cliente_eleitor` (`id`, `cidade`, `numero`, `secao`, `uf`, `zona`, `cliente_pf`) VALUES
(1, 'juiz de fora', '300', 'jardim', 'mg', '153', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente_email`
--

CREATE TABLE `cliente_email` (
  `cliente_id` int(11) NOT NULL,
  `emails` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cliente_email`
--

INSERT INTO `cliente_email` (`cliente_id`, `emails`) VALUES
(1, 'brunotardio@gmail.com'),
(1, 'brunotardio89@gmail.com'),
(1, 'barbosasilverio89@gmail.com');

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente_endereco`
--

CREATE TABLE `cliente_endereco` (
  `id` int(11) NOT NULL,
  `bairro` varchar(255) DEFAULT NULL,
  `cep` varchar(255) DEFAULT NULL,
  `cidade` varchar(255) DEFAULT NULL,
  `complemento` varchar(255) DEFAULT NULL,
  `logradouro` varchar(255) DEFAULT NULL,
  `numero` varchar(255) DEFAULT NULL,
  `uf` varchar(255) DEFAULT NULL,
  `cliente_pf` int(11) DEFAULT NULL,
  `cliente_pj` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cliente_endereco`
--

INSERT INTO `cliente_endereco` (`id`, `bairro`, `cep`, `cidade`, `complemento`, `logradouro`, `numero`, `uf`, `cliente_pf`, `cliente_pj`) VALUES
(1, 'Milho branco', '360000', 'Juiz de fora', 'Casa', 'Rua guilardo', '200', 'mg', 1, NULL),
(2, 'Milho preto', '360000', 'Juiz de fora', 'ap 01', 'Eulices', '200', 'mg', NULL, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente_telefone`
--

CREATE TABLE `cliente_telefone` (
  `cliente_id` int(11) NOT NULL,
  `telefones` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cliente_telefone`
--

INSERT INTO `cliente_telefone` (`cliente_id`, `telefones`) VALUES
(1, '32999998888'),
(1, '32991612896');

-- --------------------------------------------------------

--
-- Estrutura da tabela `endereco`
--

CREATE TABLE `endereco` (
  `id` int(11) NOT NULL,
  `cidade` varchar(255) DEFAULT NULL,
  `logradouro` varchar(255) DEFAULT NULL,
  `numero` varchar(255) DEFAULT NULL,
  `referencia` varchar(255) DEFAULT NULL,
  `uf` varchar(255) DEFAULT NULL,
  `pessoa_fisica_id` int(11) DEFAULT NULL,
  `pessoa_juridica_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `usuario_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `item_pedido`
--

CREATE TABLE `item_pedido` (
  `desconto` double DEFAULT NULL,
  `preco` double DEFAULT NULL,
  `quantidade` int(11) DEFAULT NULL,
  `pedido_id` int(11) NOT NULL,
  `produto_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pagamento`
--

CREATE TABLE `pagamento` (
  `pedido_id` int(11) NOT NULL,
  `estado` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pagamento_com_boleto`
--

CREATE TABLE `pagamento_com_boleto` (
  `data_pagamento` datetime DEFAULT NULL,
  `data_vencimento` datetime DEFAULT NULL,
  `pedido_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pagamento_com_cartao`
--

CREATE TABLE `pagamento_com_cartao` (
  `numero_de_parcelas` int(11) DEFAULT NULL,
  `pedido_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pedido`
--

CREATE TABLE `pedido` (
  `id` int(11) NOT NULL,
  `estado_pagamento` int(11) DEFAULT NULL,
  `estado_pedido` int(11) DEFAULT NULL,
  `instante` datetime DEFAULT NULL,
  `valor` double NOT NULL,
  `cliente_pf` int(11) DEFAULT NULL,
  `cliente_pj` int(11) DEFAULT NULL,
  `produto_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `pedido`
--

INSERT INTO `pedido` (`id`, `estado_pagamento`, `estado_pedido`, `instante`, `valor`, `cliente_pf`, `cliente_pj`, `produto_id`) VALUES
(1, 2, 1, '2019-02-26 16:37:00', 55, 1, NULL, 1),
(2, 2, 1, '2019-02-26 16:37:00', 55, 2, NULL, 1),
(3, 2, 1, '2019-02-26 16:37:00', 55, 3, NULL, 2),
(4, 2, 1, '2019-02-26 16:37:00', 55, NULL, 1, 2),
(5, 2, 1, '2019-02-26 16:37:00', 55, NULL, 2, 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `perfis`
--

CREATE TABLE `perfis` (
  `usuario_id` int(11) NOT NULL,
  `perfis` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoa_fisica`
--

CREATE TABLE `pessoa_fisica` (
  `funcionario_id` int(11) NOT NULL,
  `cei` varchar(255) DEFAULT NULL,
  `cpf` varchar(255) DEFAULT NULL,
  `data_nascimento` datetime DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `pis` varchar(255) DEFAULT NULL,
  `cliente_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoa_fisica_eleitor`
--

CREATE TABLE `pessoa_fisica_eleitor` (
  `pessoa_fisica_id` varchar(255) NOT NULL,
  `eleitor_cidade` varchar(255) DEFAULT NULL,
  `eleitor_numero` varchar(255) DEFAULT NULL,
  `eleitor_secao` varchar(255) DEFAULT NULL,
  `eleitoruf` varchar(255) DEFAULT NULL,
  `eleitor_zona` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoa_fisica_rg`
--

CREATE TABLE `pessoa_fisica_rg` (
  `pessoa_fisica_id` int(11) NOT NULL,
  `data_expedicao` datetime DEFAULT NULL,
  `naturalidade` varchar(255) DEFAULT NULL,
  `nome_da_mae` varchar(255) DEFAULT NULL,
  `nome_do_pai` varchar(255) DEFAULT NULL,
  `nome_titular` varchar(255) DEFAULT NULL,
  `orgao_expeditor` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoa_juridica`
--

CREATE TABLE `pessoa_juridica` (
  `id` int(11) NOT NULL,
  `cnpj` varchar(255) DEFAULT NULL,
  `fantasia` varchar(255) DEFAULT NULL,
  `inscricao_estadual` varchar(255) DEFAULT NULL,
  `nome_empresa` varchar(255) DEFAULT NULL,
  `tributacao` varchar(255) DEFAULT NULL,
  `cliente_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `id` int(11) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `preco` double DEFAULT NULL,
  `validade` int(11) DEFAULT NULL,
  `produto_categoria_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`id`, `descricao`, `nome`, `preco`, `validade`, `produto_categoria_id`) VALUES
(1, 'CPF', 'E-DIGITAL', 90, 180, 1),
(2, 'CNPJ', 'E-CNPJ Certificado', 150, 360, 2),
(3, 'CPF', 'E-CPF', 80, 360, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto_categoria`
--

CREATE TABLE `produto_categoria` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `produto_categoria`
--

INSERT INTO `produto_categoria` (`id`, `nome`) VALUES
(1, 'CD'),
(2, 'PEN DRIVE'),
(3, 'MIDIA DIGITAL');

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto_descricao`
--

CREATE TABLE `produto_descricao` (
  `id` int(11) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto_detalhe`
--

CREATE TABLE `produto_detalhe` (
  `produto_id` int(11) NOT NULL,
  `estoque` int(11) DEFAULT NULL,
  `promocao` double DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto_tipo`
--

CREATE TABLE `produto_tipo` (
  `id` int(11) NOT NULL,
  `produto_tipo` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto_validade`
--

CREATE TABLE `produto_validade` (
  `id` int(11) NOT NULL,
  `validade` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `status_pedido`
--

CREATE TABLE `status_pedido` (
  `id_status_pedido` int(11) NOT NULL,
  `descricao_pedido` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `telefone`
--

CREATE TABLE `telefone` (
  `id` int(11) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `telefone` varchar(255) DEFAULT NULL,
  `usuario_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `telefone_juridica`
--

CREATE TABLE `telefone_juridica` (
  `pessoa_juridica_id` int(11) NOT NULL,
  `telefones` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `login` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario_email`
--

CREATE TABLE `usuario_email` (
  `id` int(11) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `usuario_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `agenda`
--
ALTER TABLE `agenda`
  ADD PRIMARY KEY (`pedido_id`);

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `clientepf`
--
ALTER TABLE `clientepf`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKiib096kv20y9cyi4lknrajf67` (`cliente_id`);

--
-- Indexes for table `clientepj`
--
ALTER TABLE `clientepj`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK9k8i52k4dp9bubcj44onru38t` (`cliente_id`);

--
-- Indexes for table `clienterg`
--
ALTER TABLE `clienterg`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKbdya0pjsmt1r6vu2ftvbetqjv` (`cliente_pf`);

--
-- Indexes for table `cliente_eleitor`
--
ALTER TABLE `cliente_eleitor`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKr3elwukud8o3l2hqu8kx46h12` (`cliente_pf`);

--
-- Indexes for table `cliente_email`
--
ALTER TABLE `cliente_email`
  ADD KEY `FKo6c0bi6elgq53pekbyr5jnev3` (`cliente_id`);

--
-- Indexes for table `cliente_endereco`
--
ALTER TABLE `cliente_endereco`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKpbltilfaqw0vshbbby88x15po` (`cliente_pf`),
  ADD KEY `FKouisk2fiv5hainde612x8b04x` (`cliente_pj`);

--
-- Indexes for table `cliente_telefone`
--
ALTER TABLE `cliente_telefone`
  ADD KEY `FK9mctflnsv94li2fjlvcskl8tu` (`cliente_id`);

--
-- Indexes for table `endereco`
--
ALTER TABLE `endereco`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKc0ys7g5ule9w30t5r935p9h2x` (`pessoa_fisica_id`),
  ADD KEY `FKnohad3evpj0rtui7kfm5ql4jx` (`pessoa_juridica_id`);

--
-- Indexes for table `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`usuario_id`);

--
-- Indexes for table `item_pedido`
--
ALTER TABLE `item_pedido`
  ADD PRIMARY KEY (`pedido_id`,`produto_id`),
  ADD KEY `FKtk55mn6d6bvl5h0no5uagi3sf` (`produto_id`);

--
-- Indexes for table `pagamento`
--
ALTER TABLE `pagamento`
  ADD PRIMARY KEY (`pedido_id`);

--
-- Indexes for table `pagamento_com_boleto`
--
ALTER TABLE `pagamento_com_boleto`
  ADD PRIMARY KEY (`pedido_id`);

--
-- Indexes for table `pagamento_com_cartao`
--
ALTER TABLE `pagamento_com_cartao`
  ADD PRIMARY KEY (`pedido_id`);

--
-- Indexes for table `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKbmeslayi77ki9ev5jvpqj18h5` (`cliente_pf`),
  ADD KEY `FK6nwnk1onwi3fka03adp74itxd` (`cliente_pj`),
  ADD KEY `FK73bw249kqpeedj11lmig00nj4` (`produto_id`);

--
-- Indexes for table `perfis`
--
ALTER TABLE `perfis`
  ADD KEY `FKiso72ajmkk36lw7dqjva1h8hl` (`usuario_id`);

--
-- Indexes for table `pessoa_fisica`
--
ALTER TABLE `pessoa_fisica`
  ADD PRIMARY KEY (`funcionario_id`),
  ADD UNIQUE KEY `UK_ebifyhm97rhq9y74i6ayn9xp7` (`cliente_id`);

--
-- Indexes for table `pessoa_fisica_eleitor`
--
ALTER TABLE `pessoa_fisica_eleitor`
  ADD PRIMARY KEY (`pessoa_fisica_id`);

--
-- Indexes for table `pessoa_fisica_rg`
--
ALTER TABLE `pessoa_fisica_rg`
  ADD PRIMARY KEY (`pessoa_fisica_id`);

--
-- Indexes for table `pessoa_juridica`
--
ALTER TABLE `pessoa_juridica`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK4l2d0sd3deb5826pp3eqxg81x` (`cliente_id`);

--
-- Indexes for table `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKgho7grtbgmanbuahy8b7182uh` (`produto_categoria_id`);

--
-- Indexes for table `produto_categoria`
--
ALTER TABLE `produto_categoria`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `produto_descricao`
--
ALTER TABLE `produto_descricao`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `produto_detalhe`
--
ALTER TABLE `produto_detalhe`
  ADD PRIMARY KEY (`produto_id`);

--
-- Indexes for table `produto_tipo`
--
ALTER TABLE `produto_tipo`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `produto_validade`
--
ALTER TABLE `produto_validade`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `status_pedido`
--
ALTER TABLE `status_pedido`
  ADD PRIMARY KEY (`id_status_pedido`);

--
-- Indexes for table `telefone`
--
ALTER TABLE `telefone`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK92q33nmw94rylnpis5mgcy3v` (`usuario_id`);

--
-- Indexes for table `telefone_juridica`
--
ALTER TABLE `telefone_juridica`
  ADD KEY `FKnd1hx8q3oep2uc7pluae6qiij` (`pessoa_juridica_id`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_pm3f4m4fqv89oeeeac4tbe2f4` (`login`);

--
-- Indexes for table `usuario_email`
--
ALTER TABLE `usuario_email`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK35ob19g3k2rmbl7vb27mjlcrt` (`usuario_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `clientepf`
--
ALTER TABLE `clientepf`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `clientepj`
--
ALTER TABLE `clientepj`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `clienterg`
--
ALTER TABLE `clienterg`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `cliente_eleitor`
--
ALTER TABLE `cliente_eleitor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `cliente_endereco`
--
ALTER TABLE `cliente_endereco`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `endereco`
--
ALTER TABLE `endereco`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pedido`
--
ALTER TABLE `pedido`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `pessoa_juridica`
--
ALTER TABLE `pessoa_juridica`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `produto`
--
ALTER TABLE `produto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `produto_categoria`
--
ALTER TABLE `produto_categoria`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `produto_descricao`
--
ALTER TABLE `produto_descricao`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `produto_tipo`
--
ALTER TABLE `produto_tipo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `produto_validade`
--
ALTER TABLE `produto_validade`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `status_pedido`
--
ALTER TABLE `status_pedido`
  MODIFY `id_status_pedido` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `telefone`
--
ALTER TABLE `telefone`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `usuario_email`
--
ALTER TABLE `usuario_email`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
