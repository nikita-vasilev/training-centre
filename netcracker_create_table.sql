create table employees(
	empl_id Serial Primary Key,
	name Varchar(50),
	department Varchar(50)
);
create table companies(
	name Varchar(50) Primary Key
);
create table projects(
	name Varchar(50) Primary Key,
	company Varchar(50),
	manager_id integer,
	constraint fk_manager
		foreign key (manager_id)
			references employees(empl_id),
	constraint fk_company
		foreign key(company)
			references companies(name)
);
create table emp_to_project(
	empl_id integer,
	name Varchar(50),
	constraint fk_empl
		foreign key (empl_id)
			references employees(empl_id),
	constraint fk_project
		foreign key(name)
			references projects(name)
);