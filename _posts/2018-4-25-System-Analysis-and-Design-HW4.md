---
layout: post
title: Homework4
date: 2018-4-25 10:51:43
categories: 系统分析与设计
tags: 系统分析与设计作业
---

# Homework3
*****
## 1、 领域建模
* a. 阅读 Asg_RH 文档，按用例构建领域模型。 
    - 按 Task2 要求，请使用工具 UMLet，截图格式务必是 png 并控制尺寸
    - 说明：请不要受 PCMEF 层次结构影响。你需要识别实体（E）和 中介实体（M，也称状态实体） 
        在单页面应用（如 vue）中，E 一般与数据库构建有关， M 一般与 store 模式 有关
        在 java web 应用中，E 一般与数据库构建有关， M 一般与 session 有关

如下图所示：
![](https://s1.ax1x.com/2018/04/25/ClObKU.png)

* b. 数据库建模(E-R 模型)
    - 按 Task 3 要求，给出系统的 E-R 模型（数据逻辑模型）
    - 建模工具 PowerDesigner（简称PD） 或开源工具 OpenSystemArchitect
    - 不负责的链接 http://www.cnblogs.com/mcgrady/archive/2013/05/25/3098588.html
    - 导出 Mysql 物理数据库的脚本
    - 简单叙说 数据库逻辑模型 与 领域模型 的异同
数据逻辑模型如下：
![](https://s1.ax1x.com/2018/04/25/C1idhD.png)
根据数据逻辑模型可以用工具导出物理模型：
![](https://s1.ax1x.com/2018/04/25/C1iatO.png)
得到追踪的Mysql脚本：
```sql
drop table if exists CreditCard;

drop table if exists HotelMessage;

drop table if exists SearchHotelList;

drop table if exists SearchMessage;

drop table if exists Summary;

drop table if exists Travelor;

drop table if exists billMessage;

drop table if exists confirmation;

drop table if exists roomMessage;

/*==============================================================*/
/* Table: CreditCard                                            */
/*==============================================================*/
create table CreditCard
(
   cardNumber           int,
   expiryDate           date,
   securityCode         int,
   holderAddress        text
);

/*==============================================================*/
/* Table: HotelMessage                                          */
/*==============================================================*/
create table HotelMessage
(
   name                 text,
   "min Stay"           numeric(8,0),
   cost                 float(8,2),
   information          text
);

/*==============================================================*/
/* Table: SearchHotelList                                       */
/*==============================================================*/
create table SearchHotelList
(
   hotelMessage         char(10)
);

/*==============================================================*/
/* Table: SearchMessage                                         */
/*==============================================================*/
create table SearchMessage
(
   city                 text,
   checkIn              date,
   checkOut             date
);

/*==============================================================*/
/* Table: Summary                                               */
/*==============================================================*/
create table Summary
(
   city                 text,
   checkIn              date,
   checkOut             date,
   hotelName            text
);

/*==============================================================*/
/* Table: Travelor                                              */
/*==============================================================*/
create table Travelor
(
   adultsNum            numeric(8,0),
   childrenNum          numeric(8,0),
   childrenAge          int
);

/*==============================================================*/
/* Table: billMessage                                           */
/*==============================================================*/
create table billMessage
(
   roomType             text,
   totalMoney           float(8,2)
);

/*==============================================================*/
/* Table: confirmation                                          */
/*==============================================================*/
create table confirmation
(
   email                text,
   name                 text,
   requirements         text
);

/*==============================================================*/
/* Table: roomMessage                                           */
/*==============================================================*/
create table roomMessage
(
   availability         bool,
   money                float(8,2)
);

alter table CreditCard add constraint FK_resultIn1 foreign key ()
      references billMessage on delete restrict on update restrict;

alter table HotelMessage add constraint FK_actAs2 foreign key ()
      references SearchHotelList on delete restrict on update restrict;

alter table HotelMessage add constraint FK_produce foreign key ()
      references Summary on delete restrict on update restrict;

alter table SearchHotelList add constraint FK_has2 foreign key ()
      references HotelMessage on delete restrict on update restrict;

alter table SearchHotelList add constraint FK_result2 foreign key ()
      references SearchMessage on delete restrict on update restrict;

alter table SearchMessage add constraint FK_result foreign key ()
      references SearchHotelList on delete restrict on update restrict;

alter table Summary add constraint FK_actAs1 foreign key ()
      references SearchMessage on delete restrict on update restrict;

alter table Summary add constraint FK_has1 foreign key ()
      references SearchMessage on delete restrict on update restrict;

alter table Summary add constraint FK_include4 foreign key ()
      references billMessage on delete restrict on update restrict;

alter table Travelor add constraint FK_actAs foreign key ()
      references billMessage on delete restrict on update restrict;

alter table Travelor add constraint FK_include2 foreign key ()
      references confirmation on delete restrict on update restrict;

alter table billMessage add constraint FK_act foreign key ()
      references Travelor on delete restrict on update restrict;

alter table billMessage add constraint FK_include3 foreign key ()
      references Summary on delete restrict on update restrict;

alter table billMessage add constraint FK_resultIn2 foreign key ()
      references CreditCard on delete restrict on update restrict;

alter table confirmation add constraint FK_include1 foreign key ()
      references Travelor on delete restrict on update restrict;

alter table roomMessage add constraint FK_include5 foreign key ()
      references HotelMessage on delete restrict on update restrict;

```

数据库逻辑模型 与 领域模型 的异同:
- 领域模型：就是从现实世界到信息世界的第一层抽象，确定领域实体属性关系等，使用E-R图表示，主要是由实体、属性和联系三个要素构成的。  
  
- 逻辑模型：是将概念模型转化为具体的数据模型，即按照领域模型的基本E-R图，按选定的管理系统软件支持的数据模型，转换成相应的逻辑模型。这种转换要符合关系数据模型的原则。