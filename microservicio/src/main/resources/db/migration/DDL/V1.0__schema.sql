create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

create table persona (
  id int(11) not null auto_increment,
  nombre varchar(100) not null,
  celular varchar(50),
  primary key (id)
);


create table cita (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 odontologo varchar(100) not null,
 valor int not null,
 fecha_creacion date null,
 id_persona int(11) not null,
 primary key (id),
 CONSTRAINT fk_cita_persona
  FOREIGN KEY (id_persona)
  REFERENCES persona (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION);