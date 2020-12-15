--Набитие таблиц
insert into companies values ('Company1');
insert into companies values ('Company2');
insert into companies values ('Company3');

insert into employees values(1,'Ivan','Dep1');
insert into employees values(2,'Sergei','Dep1');
insert into employees values(3,'Oleg','Dep2');

insert into projects values('Proj1','Company1',1);
insert into projects values('Proj2','Company1',2);
insert into projects values('Proj3','Company3',2);

insert into emp_to_project values(1,'Proj1');
insert into emp_to_project values(2,'Proj2');
insert into emp_to_project values(3,'Proj3');

--select 1
select  e.department ,
		etp.name 
	from employees e
		 inner join emp_to_project etp
		 	on e.empl_id=etp.empl_id
;
--select 2
select  e.name ,
		p.company 
	from employees e
		 inner join emp_to_project etp
		 	on e.empl_id=etp.empl_id
		 inner join projects p on
		 	p.name=etp.name
;	
--update 
update employees set name ='Ivan1' where name ='Ivan';
--delete
delete from emp_to_project where empl_id=1