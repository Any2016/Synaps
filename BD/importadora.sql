/*==============================================================*/
/* DBMS name:      Sybase SQL Anywhere 12                       */
/* Created on:     17/04/2017 11:59:08                          */
/*==============================================================*/


if exists(select 1 from sys.sysforeignkey where role='FK_DETALLE_REFERENCE_PROVEEDO') then
    alter table DETALLE
       delete foreign key FK_DETALLE_REFERENCE_PROVEEDO
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_DETALLE_REFERENCE_PRODUCTO') then
    alter table DETALLE
       delete foreign key FK_DETALLE_REFERENCE_PRODUCTO
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_DETALLE__REFERENCE_PRODUCTO') then
    alter table DETALLE_PEDIDO
       delete foreign key FK_DETALLE__REFERENCE_PRODUCTO
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_DETALLE__REFERENCE_PEDIDO') then
    alter table DETALLE_PEDIDO
       delete foreign key FK_DETALLE__REFERENCE_PEDIDO
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_PEDIDO_REFERENCE_CLIENTE') then
    alter table PEDIDO
       delete foreign key FK_PEDIDO_REFERENCE_CLIENTE
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_PRODUCTO_REFERENCE_SUB_CATE') then
    alter table PRODUCTO
       delete foreign key FK_PRODUCTO_REFERENCE_SUB_CATE
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_SUB_CATE_REFERENCE_CATEGORI') then
    alter table SUB_CATEGORIA
       delete foreign key FK_SUB_CATE_REFERENCE_CATEGORI
end if;

drop table if exists CATEGORIA;

drop table if exists CLIENTE;

drop table if exists DETALLE;

drop table if exists DETALLE_PEDIDO;

drop table if exists PEDIDO;

drop table if exists PRODUCTO;

drop table if exists PROVEEDOR;

drop table if exists SUB_CATEGORIA;

if exists(select 1 from sys.syssequence s
   where sequence_name='S_CATEGORIA') then
      drop sequence S_CATEGORIA
end if;

if exists(select 1 from sys.syssequence s
   where sequence_name='S_SUB_CATEGORIA') then
      drop sequence S_SUB_CATEGORIA
end if;

create sequence S_CATEGORIA;

create sequence S_SUB_CATEGORIA;

/*==============================================================*/
/* Table: CATEGORIA                                             */
/*==============================================================*/
create table CATEGORIA 
(
   ID_CATEGORIA         integer                        not null default autoincrement,
   CATEGORIA            varchar(20)                    null,
   constraint PK_CATEGORIA primary key (ID_CATEGORIA)
);

/*==============================================================*/
/* Table: CLIENTE                                               */
/*==============================================================*/
create table CLIENTE 
(
   CI                   varchar(15)                    not null,
   NOMBRE               varchar(30)                    null,
   APELLIDO				varchar(30)					   null,
   DIRECCION            varchar(50)                    null,
   TELEFONO             integer                        null,
   CELULAR              integer                        null,
   CELULAR 				integer						   null,
   CORREO               varchar(50)                    null,
   constraint PK_CLIENTE primary key (CI)
);

/*==============================================================*/
/* Table: DETALLE                                               */
/*==============================================================*/
create table DETALLE 
(
   CI                   varchar(15)                    null,
   ID_PRODUCTO          integer                        null,
   CATEGRIA             varchar(30)                    null,
   PRECIO               double                         null
);

/*==============================================================*/
/* Table: DETALLE_PEDIDO                                        */
/*==============================================================*/
create table DETALLE_PEDIDO 
(
   ID_PRODUCTO          integer                        null,
   ID_PEDIDO            integer                        null,
   CANTIDAD             integer                        null,
   PRECIO_PARCIAL       double                         null
);

/*==============================================================*/
/* Table: PEDIDO                                                */
/*==============================================================*/
create table PEDIDO 
(
   ID_PEDIDO            integer                        not null,
   CI                   varchar(15)                    null,
   FECHA_PEDIDO         date                           null,
   FECHA_LLEGADA        date                           null,
   PRECIO_TOTAL         double                         null,
   ESTADO               smallint                       null,
   constraint PK_PEDIDO primary key (ID_PEDIDO)
);

/*==============================================================*/
/* Table: PRODUCTO                                              */
/*==============================================================*/
create table PRODUCTO 
(
   ID_PRODUCTO          integer                        not null,
   ID_SUB_CAT           integer                        null,
   PRODUCTO             varchar(50)                    null,
   constraint PK_PRODUCTO primary key (ID_PRODUCTO)
);

/*==============================================================*/
/* Table: PROVEEDOR                                             */
/*==============================================================*/
create table PROVEEDOR 
(
   CI                   varchar(15)                    not null,
   NOMBRE               varchar(30)                    null,
   PAIS                 varchar(15)                    null,
   TELEFONO             integer                        null,
   CORREO               varchar(30)                    null,
   constraint PK_PROVEEDOR primary key (CI)
);

/*==============================================================*/
/* Table: SUB_CATEGORIA                                         */
/*==============================================================*/
create table SUB_CATEGORIA 
(
   ID_SUB_CAT           integer                        not null default autoincrement,
   ID_CATEGORIA         integer                        null,
   SUB_CATEGORIA        varchar(30)                    null,
   constraint PK_SUB_CATEGORIA primary key (ID_SUB_CAT)
);

alter table DETALLE
   add constraint FK_DETALLE_REFERENCE_PROVEEDO foreign key (CI)
      references PROVEEDOR (CI)
      on update restrict
      on delete restrict;

alter table DETALLE
   add constraint FK_DETALLE_REFERENCE_PRODUCTO foreign key (ID_PRODUCTO)
      references PRODUCTO (ID_PRODUCTO)
      on update restrict
      on delete restrict;

alter table DETALLE_PEDIDO
   add constraint FK_DETALLE__REFERENCE_PRODUCTO foreign key (ID_PRODUCTO)
      references PRODUCTO (ID_PRODUCTO)
      on update restrict
      on delete restrict;

alter table DETALLE_PEDIDO
   add constraint FK_DETALLE__REFERENCE_PEDIDO foreign key (ID_PEDIDO)
      references PEDIDO (ID_PEDIDO)
      on update restrict
      on delete restrict;

alter table PEDIDO
   add constraint FK_PEDIDO_REFERENCE_CLIENTE foreign key (CI)
      references CLIENTE (CI)
      on update restrict
      on delete restrict;

alter table PRODUCTO
   add constraint FK_PRODUCTO_REFERENCE_SUB_CATE foreign key (ID_SUB_CAT)
      references SUB_CATEGORIA (ID_SUB_CAT)
      on update restrict
      on delete restrict;

alter table SUB_CATEGORIA
   add constraint FK_SUB_CATE_REFERENCE_CATEGORI foreign key (ID_CATEGORIA)
      references CATEGORIA (ID_CATEGORIA)
      on update restrict
      on delete restrict;

