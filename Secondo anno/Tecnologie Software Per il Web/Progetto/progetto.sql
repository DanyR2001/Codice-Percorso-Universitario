drop database TSPW;
create database TSPW;
use TSPW;

create table User(
	id int auto_increment primary key,
	nome varchar(30) not null,
	cognome varchar(30) not null,
	mail varchar(30) not null,
    passwrd varchar(30)not null,
    dat date not null
);

insert into User values (1,"Daniele","Russo","danielerusso_@hotmai.it","Ciao12",'2001/11/15');

select * from User;

create table vinilidisp(
ID int auto_increment primary key,
Titolo varchar(30) not null,
Prezzo double not null,
Quantita int not null,
Url varchar(120),
Artista varchar(30) not null
);

insert into vinilidisp value (1,"Thriller",29.99,3,"https:\/\/upload.wikimedia.org\/wikipedia\/en\/5\/55\/Michael_Jackson_-_Thriller.png","Michael jackson");
insert into vinilidisp(Titolo,Prezzo,Quantita,Url,Artista) value ("The Dark Side of the Moon",31.99,3,"https:\/\/upload.wikimedia.org\/wikipedia\/en\/3\/3b\/Dark_Side_of_the_Moon.png","Pink Floyd");
insert into vinilicustomerdisp(Titolo,Prezzo,Quantita,Url,Artista) value ("A Night at the Opera",15.99,2,"https:\/\/cdns-images.dzcdn.net\/images\/cover\/6706f1154083f461a348508c28030a30\/350x350.jpg","Queen");


select * from vinilidisp;

update vinilidisp set Quantita = Quantita - 2  where ID = 1;

alter table User add column passwordhash varchar(50) not null;
alter table User rename Users;
alter table Users drop column admin_bool;
alter table Users add column admin_bool boolean not null default false;
select * from Users;

create table ordine(
	codice int not null auto_increment primary key,
    prezzo double not null default 0,
    dataev date,
    evaso boolean not null default false,
    id_user int not null references User(id)
);

create table comporre(
	id_vinile int not null references vinilidisp(ID),
    code_ordine int not null references ordine(codice),
    quantita int not null default 0,
    prezzo double not null default 0,
    primary key(id_vinile,code_ordine)
);

insert into comporre values (1,1,1,29.99);
insert into comporre values (2,1,2,31.99);


SELECT id_vinile,quantita, prezzo FROM comporre WHERE code_ordine=1;

create table tags(
id_tag int auto_increment primary key,
nome varchar(30) not null
); 

insert into tags values (1,"35 giri");
insert into tags(nome) values ("45 giri");
insert into tags(nome) values ("pop");
insert into tags(nome) values ("rock");


create table vinil_tag(
id_vinile int references vinilidisp,
id_tag int references tags,
primary key(id_vinile,id_tag)
);

insert into vinil_tag values (1,2);
insert into vinil_tag values (1,3);






