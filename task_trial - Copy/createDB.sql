create schema companys;

create table companys.employee (
	emplID serial,
	name varchar(30) not null,
	department varchar(40) not null,

	primary key (emplID)
);

create table companys.company (
	name varchar(70) not null,

	primary key (name)
);

create table companys.project (
	name varchar(30) not null,
	company varchar(70) not null,
	managerID int not null,

	primary key (name),

	constraint fk_company foreign key (company) references companys.company (name),
	constraint fk_managerID foreign key (managerID) references companys.employee (emplID)
);

create table companys.empToProject (
	name varchar(30) not null,
	emplID int not null,

	constraint fk_emplIdProject foreign key (emplID) references companys.employee (emplID),
	constraint fk_nameProject foreign key (name) references companys.project (name)
);
