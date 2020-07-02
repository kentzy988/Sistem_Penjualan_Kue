
CREATE TABLESPACE kentzy_06988
datafile 'C:\Users\Kentzy\Documents\Praktikum Semester 4\Basis Data\sistem_penjualan_kue.dbf'
size 30M;


CREATE USER kentzypradana_06988
IDENTIFIED BY kentzy
DEFAULT TABLESPACE kentzy_06988
QUOTA 30M ON kentzy_06988;


GRANT ALL PRIVILEGES TO kentzypradana_06988;


create table T_kue
(
Id_kue             INTEGER         not null,
nama_kue           VARCHAR2(10),
stok_kue          NUMBER(10),
jenis_kue          VARCHAR2(10),
harga_satuan          NUMBER(10),
constraint PK_kue primary key (Id_kue)
);


create table T_transaksi
(
Id_transaksi       INTEGER         not null,
 nama_pembeli       VARCHAR2(10),
 tgl_transaksi      DATE,
 total_harga        INTEGER,
 total_kue        INTEGER,
 constraint PK_transaksi primary key (Id_transaksi)
 );


create table detail_transaksi
(
Id_transaksi       INTEGER         not null,
Id_kue             INTEGER
 );

alter table T_transaksi
 add constraint FK_kue FOREIGN KEY (Id_kue)
 references T_kue(Id_kue);


create sequence id_kue
  minvalue 1
  maxvalue 9999
  start with 1
  increment by 1
  cache 20;

create sequence id_transaksi
  minvalue 1
  maxvalue 9999
  start with 1
  increment by 1
  cache 20;

create view list_equjoin as
Select a.nama_kue, b.nama_pembeli
From t_transaksi b join t_kue a
On a.id_kue = b.id_kue;

create view list_equjoin as
Select a.nama_kue, b.nama_pembeli
From t_transaksi b join t_kue a
On a.id_kue = b.id_kue;

create view list_leftjoin as
Select a.id_transaksi, b.nama_pembeli, c.nama_kue
From detail_transaksi a left join t_transaksi b
On a.id_transaksi = b.id_transaksi
Left join t_kue c
On a.id_kue = c.id_kue
Where a.id_transaksi < (select max (id_transaksi) from detail_transaksi);

create view list_rightjoin as
Select a.id_transaksi, b.nama_pembeli, c.nama_kue
From detail_transaksi a right join t_transaksi b
On a.id_transaksi = b.id_transaksi
right join t_kue c
On a.id_kue = c.id_kue
Where a.id_transaksi < (select max (id_transaksi) from detail_transaksi)
AND a.id_transaksi > (select min (id_transaksi) from detail_transaksi);

SELECT * FROM DETAIL_TRANSAKSI JOIN T_KUE ON DETAIL_TRANSAKSI.ID_KUE = T_KUE.ID_KUE;

commit;