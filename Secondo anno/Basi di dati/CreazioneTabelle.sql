drop database Progetto2022;

create database Progetto2022;

use Progetto2022;

-- Negozi (pIva, ragSoc, toponimo, civico, comune, cap, provincia)

create table Negozi(
	pIva VARCHAR(30) PRIMARY KEY,
    ragSoc VARCHAR(40) NOT NULL,
    toponimo VARCHAR(40) NOT NULL,
    civico INT NOT NULL,
    comune VARCHAR(30) NOT NULL,
    cap VARCHAR(6) NOT NULL,
    provincia VARCHAR(30) NOT NULL
);

-- Vinili (id, prezzoListino, durata, annoUscita, titolo, tipo, inedito*)

create table Vinili(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    titolo VARCHAR(30) NOT NULL,
    tipo VARCHAR(4) NOT NULL,
    durata VARCHAR(7) NOT NULL,
    prezzo_Listino DOUBLE NOT NULL,
    anno_Uscita VARCHAR(4) NOT NULL,
	inedito BOOLEAN default false
);

-- Artisti (matricola, numDischi, nome, cognome, etichetta)

create table Artisti(
	matricola INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(30) NOT NULL,
    cognome VARCHAR(30) NOT NULL,
    etichetta VARCHAR(30) NOT NULL,
    numDischi INT DEFAULT 0 NOT NULL
);

-- Acquisti (data, ora, pIva, idVinile, prezzoUnitario, quantita, usato, sconto*)

create table Acquisti(
	dataOra DATETIME DEFAULT current_timestamp NOT NULL,
    p_Iva VARCHAR(30) NOT NULL,
    id_Vinile int not null,
    prezzoUnita DOUBLE NOT NULL,
    quantita INT NOT NULL DEFAULT 1,
    sconto DECIMAL(5,2),
	usato BOOLEAN NOT NULL,
    FOREIGN KEY (id_Vinile) REFERENCES Vinili (id) 
		ON UPDATE CASCADE 
        ON DELETE CASCADE,
	FOREIGN KEY (p_Iva) REFERENCES Negozi (pIva)
		ON UPDATE CASCADE 
        ON DELETE CASCADE,
    PRIMARY KEY(dataOra,p_Iva,id_Vinile)
);

-- Vendite (data, ora, pIva, idVinile, prezzoUnitario, usato, quantita, sconto*)

create table Vendite(
	dataOra DATETIME DEFAULT current_timestamp NOT NULL,
    p_iva VARCHAR(30) NOT NULL,
    id_Vinile int not null,
    prezzoUnita DOUBLE NOT NULL,
    quantita INT NOT NULL DEFAULT 1,
    sconto DECIMAL(5,2),
	usato BOOLEAN NOT NULL,
    FOREIGN KEY (id_Vinile) REFERENCES Vinili (id) 
		ON UPDATE CASCADE 
        ON DELETE CASCADE,
	FOREIGN KEY (p_iva) REFERENCES Negozi (pIva)
		ON UPDATE CASCADE 
        ON DELETE CASCADE,
    PRIMARY KEY(dataOra,p_iva,id_Vinile)
);

-- Autori (idVinile, matricolaArtista)

create table Autori(
	idVinile int not null REFERENCES Vinili (id) 
		ON UPDATE CASCADE 
        ON DELETE CASCADE,
    matricolaArtista INT NOT NULL REFERENCES Artisti (matricola)
		ON UPDATE CASCADE 
        ON DELETE CASCADE,
	PRIMARY KEY(idVinile, matricolaArtista)
);

-- Tracce (nome, idVinile)

create table Tracce(
	NomeCanzione VARCHAR(40) NOT NULL,
	idVinile int not null REFERENCES Vinili (id) 
		ON UPDATE CASCADE 
        ON DELETE CASCADE,
	PRIMARY KEY(idVinile, NomeCanzione)
);






