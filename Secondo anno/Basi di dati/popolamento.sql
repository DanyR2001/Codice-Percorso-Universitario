-- drop database Progetto2022;
use Progetto2022;

-- popolamento Artisti

INSERT INTO Artisti VALUES (1 , "Michael", "Jackson", "Steeltown Records", 13);

INSERT INTO Artisti(nome,cognome,etichetta,numDischi) VALUES ("Riccardo", "Cocciante", "RCA Talent", 18),
							("Edoardo", "Bennato", "Parade", 20),
							("Renato", "Zero", "Zerolandia", 31),
							("Lucio", "Dalla", "RCA Italiana", 22),
							("Claudio", "Baglioni", "Sony Music", 16),
							("Antonello", "Venditti", "Philips Records", 46);
                            
select * from Artisti;

-- popolamento Negozi 

insert into Negozi Values ("1020405060","DiscLand","Via Roma",20,"Salerno","84120","Salerno"),
							("1121415161","MusicLand","Via Irno",213,"Cava","84110","Salerno"),
                            ("1222425262","DiscWord","Via Velia",58,"Pontecagnano","84130","Salerno"),
                            ("1323435363","VinilLand","Via Europa",22,"Napoli","84110","Napoli");
                            
select * from Negozi;

-- popolamento Vinili

select * from Vinili;

INSERT INTO Vinili values (1,"Thriller","33","42:19",30.99,"1982",false);

INSERT INTO Vinili(titolo, tipo, durata ,prezzo_Listino, anno_Uscita, inedito) values ("Concerto per Margherita","33","38:37",35.99,"1976",false),
		("Zerofobia","33","38:29",25.99,"1977",false),
        ("La torre di Babele","33","41:06",32.99,"1976",false),
        ("Zerolandia","33","43:08",25.99,"1978",false),
        ("Lucio Dalla","33","37:19",28.99,"1979",false);
        
INSERT INTO Vinili (titolo, tipo, durata ,prezzo_Listino, anno_Uscita, inedito) values ("XSCAPE","45","34:04",30.99,"2014",true);


-- popolamento Autori

Insert into Autori values (1,1),(2,2),(3,4),(5,4),(4,3),(6,5),(7,1);

select v.titolo, ar.nome, ar.cognome, ar.etichetta, v.durata, v.prezzo_Listino,v.tipo from Vinili v, Autori au , Artisti ar where v.id=au.idVinile&&au.matricolaArtista=ar.matricola;

-- popolamento acquisto

select * from Acquisti;

Insert into Acquisti (p_Iva,id_Vinile,prezzoUnita,quantita,sconto,usato) values ("1020405060",1,30.99,1,0,false),
	("1020405060",3,13.99,2,0,true),
    ("1020405060",6,28.99,1,0,false),
    ("1020405060",5,13.99,1,50,true),
    ("1121415161",1,30.12,1,0,false),
    ("1121415161",5,13.99,1,50,true),
    ("1121415161",6,28.99,1,0,false);

-- popolamento venidite

Insert into Vendite (p_Iva,id_Vinile,prezzoUnita,quantita,sconto,usato) values ("1020405060",1,30.99,1,0,false),
    ("1121415161",6,28.99,1,0,false);

-- proviamo qualche query

-- 1.Selezionare tutti gli artisti che hanno fatto più di 5 dischi e che appartengono al etichetta X o Y
Select * from Artisti a where a.numDischi>5 and (a.etichetta like "Sony Music" or a.etichetta like "RCA Talent");

-- 2.Selezionare tutti i brani inediti del artista michael jackson (puniti 1 e 2) 
select v.titolo,v.tipo,v.durata,v.anno_Uscita,v.prezzo_Listino from Artisti ar, Autori au, Vinili v where ar.nome like "Michael" and ar.cognome like "jackson" and ar.matricola=au.matricolaArtista and au.idVinile=v.id and v.inedito=true;

-- 3.Selezionare il numero di vinili complessivamente venduti da tutti i negozi.
select sum(v.quantita) from Vendite v; 

-- 4.Selezionare il numero di vinili venduti da ogni negozio.
select n.ragSoc,sum(v.quantita) as NumeroDischiVenduti from Negozi n,Vendite v where n.pIva=v.p_iva group by n.pIva;

-- 5.Selezionare P.iva e ragione sociale dei negozi che hanno acquistato piu di 100 vinili.
select n.ragSoc,n.pIva from Negozi n, Acquisti a where a.p_iva=n.pIva group by n.pIva having sum(a.quantita)>4;

-- 6.Selezione il negozio che ha acquistato piu vinili di tutti.
select n.ragSoc,sum(a.quantita) as NumeroDischiVenduti from Negozi n,Acquisti a where n.pIva=a.p_iva group by n.pIva having NumeroDischiVenduti=(select max(s.cont)as Maax from (Select sum(a.quantita)as cont from Acquisti a group by p_iva ) s);







 
