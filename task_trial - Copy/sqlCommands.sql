insert into companys.employee (name, department) values ('Sergey', 'IT');
insert into companys.employee (name, department) values ('Vasilii', 'Accounting');
insert into companys.employee (name, department) values ('Maxim', 'IT');
insert into companys.employee (name, department) values ('Andrew', 'IT');

insert into companys.company (name) values ('Comp');
insert into companys.company (name) values ('Company');

insert into companys.project (name, company, managerID) values ('project', 'Comp', 1);
insert into companys.project (name, company, managerID) values ('project1', 'Company', 2);

insert into companys.empToProject (name, emplID) values ('project', 3);
insert into companys.empToProject (name, emplID) values ('project1', 4);

select * from companys.employee;
select * from companys.company;
select * from companys.project;
select * from companys.empToProject;

select		e.name, e.department
	from	companys.employee e
	where	e.emplID = 3;

select		p.company,
			etp.name,
			p.managerID,
			etp.emplID
	from	companys.empToProject etp
			left join companys.project p on
			p.name = etp.name;

update companys.employee set department = 'IT' where emplID = 2;

delete from companys.empToProject where name = 'project1';

