/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     15/04/2017 10:49:54 a. m.                    */
/*==============================================================*/


drop table if exists CATEGORIA;

drop table if exists CLIENTE;

drop table if exists DETALLE;

drop table if exists DETALLE_PEDIDO;

drop table if exists PEDIDO;

drop table if exists PRODUCTO;

drop table if exists PROVEEDOR;

drop table if exists SUB_CATEGORIA;

/*==============================================================*/
/* Table: CATEGORIA                                             */
/*==============================================================*/
create table CATEGORIA
(
   ID_CATEGORIA         int not null auto_increment,
   CATEGORIA            varchar(20),
   primary key (ID_CATEGORIA)
);

/*==============================================================*/
/* Table: CLIENTE                                               */
/*==============================================================*/
create table CLIENTE
(
   ID_CLIENTE           int(11) not null auto_increment,
   CI                   varchar(15) not null,
   NOMBRE               varchar(30),
   DIRECCION            varchar(50),
   TELEFONO             int,
   CELULAR              int,
   CORREO               varchar(50),
   primary key (ID_CLIENTE)
);

/*==============================================================*/
/* Table: DETALLE                                               */
/*==============================================================*/
create table DETALLE
(
   ID_PRODUCTO          int,
   ID_PROVEEDOR         int,
   PRECIO               double
);

/*==============================================================*/
/* Table: DETALLE_PEDIDO                                        */
/*==============================================================*/
create table DETALLE_PEDIDO
(
   ID_PRODUCTO          int,
   ID_PEDIDO            int,
   CANTIDAD             int,
   PRECIO_PARCIAL       double
);

/*==============================================================*/
/* Table: PEDIDO                                                */
/*==============================================================*/
create table PEDIDO
(
   ID_PEDIDO            int not null auto_increment,
   ID_CLIENTE           int,
   FECHA_PEDIDO         date,
   FECHA_LLEGADA        date,
   ESTADO               bool,
   primary key (ID_PEDIDO)
);

/*==============================================================*/
/* Table: PRODUCTO                                              */
/*==============================================================*/
create table PRODUCTO
(
   ID_PRODUCTO          int not null auto_increment,
   ID_SUB_CAT           int,
   PRODUCTO             varchar(50),
   MARCA                varchar(50),
   MODELO               varchar(30),
   NUMERO_SERIE         varchar(20),
   primary key (ID_PRODUCTO)
);

/*==============================================================*/
/* Table: PROVEEDOR                                             */
/*==============================================================*/
create table PROVEEDOR
(
   ID_PROVEEDOR         int not null auto_increment,
   CI                   varchar(15) not null,
   NOMBRE               varchar(30),
   PAIS                 varchar(15),
   TELEFONO             int,
   CELULAR              int,
   CORREO               varchar(30),
   primary key (ID_PROVEEDOR)
);

/*==============================================================*/
/* Table: SUB_CATEGORIA                                         */
/*==============================================================*/
create table SUB_CATEGORIA
(
   ID_SUB_CAT           int not null auto_increment,
   ID_CATEGORIA         int,
   SUB_CATEGORIA        varchar(30),
   primary key (ID_SUB_CAT)
);

alter table DETALLE add constraint FK_REFERENCE_6 foreign key (ID_PROVEEDOR)
      references PROVEEDOR (ID_PROVEEDOR) on delete restrict on update restrict;

alter table DETALLE add constraint FK_REFERENCE_7 foreign key (ID_PRODUCTO)
      references PRODUCTO (ID_PRODUCTO) on delete restrict on update restrict;

alter table DETALLE_PEDIDO add constraint FK_REFERENCE_3 foreign key (ID_PRODUCTO)
      references PRODUCTO (ID_PRODUCTO) on delete restrict on update restrict;

alter table DETALLE_PEDIDO add constraint FK_REFERENCE_4 foreign key (ID_PEDIDO)
      references PEDIDO (ID_PEDIDO) on delete restrict on update restrict;

alter table PEDIDO add constraint FK_REFERENCE_5 foreign key (ID_CLIENTE)
      references CLIENTE (ID_CLIENTE) on delete restrict on update restrict;

alter table PRODUCTO add constraint FK_REFERENCE_2 foreign key (ID_SUB_CAT)
      references SUB_CATEGORIA (ID_SUB_CAT) on delete restrict on update restrict;

alter table SUB_CATEGORIA add constraint FK_REFERENCE_1 foreign key (ID_CATEGORIA)
      references CATEGORIA (ID_CATEGORIA) on delete restrict on update restrict;

