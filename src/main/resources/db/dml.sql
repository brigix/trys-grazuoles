-- DML
insert into person
  (name,surname,birthday)
values
  ('Brigita','Dulksna','1981-10-15'),
  ('Svetlana','Armoškienė ','1965-04-20'),
  ('Rita','Baibokienė ','1968-09-11'),
  ('Rasytė','Banevičienė','1978-05-17'),
  ('Janina','Bataitė ','1989-05-06'),
  ('Inga','Bujokienė ','1992-03-30'),
  ('Gintarė','Bukšnienė ','1984-10-29'),
  ('Ema','Dabkevičienė ','1970-06-30'),
  ('Daiva','Gelžinienė ','1965-11-10'),
  ('Audronė','Graudinienė','1957-11-16'),
  ('Adrija','Grendaitė ','1997-10-18'),
  ('Akvilė','Jakaitienė ','1989-12-04'),
  ('Daiva','Kameneckienė ','1987-05-18'),
  ('Edita','Kazakevičiūtė-Iljeva ','1987-04-03'),
  ('Eglė','Kelevičienė ','1986-09-13'),
  ('Jūratė','Kučiauskienė ','1983-01-29'),
  ('Jurgita','Kulišauskienė ','1981-08-20'),
  ('Laimutė','Lapukienė ','1981-07-15'),
  ('Lora','Lileikienė ','1979-05-19'),
  ('Nijolė','Linkienė ','1976-10-25'),
  ('Rosita','Mažeikienė ','1974-12-17'),
  ('Vida','Mesonienė ','1974-08-30'),
  ('Toma','Mezginienė ','1971-10-27'),
  ('Aldona','Norkienė ','1971-09-18'),
  ('Diana','Pečiulienė ','1970-12-25'),
  ('Jolanta','Pikšrienė ','1970-01-19'),
  ('Sigitas','Povilaitis ','1968-10-28'),
  ('Gediminas','Povilavičius ','1968-09-02'),
  ('Evelina','Pranaitytė ','1968-01-27'),
  ('Justė','Rajeckienė ','1967-08-19'),
  ('Lilia','Sanvaitytė ','1967-07-14'),
  ('Giedrius','Saveikis ','1964-09-26'),
  ('Aidas','Skiparis ','1963-10-23'),
  ('Dalia','Slušnė ','1961-06-17'),
  ('Greta','Šeštakauskienė ','1959-04-14'),
  ('Irena','Vedeikienė ','1956-11-27'),
  ('Rokas','Žilinskas ','1955-08-26');
  
insert into service
  (title,price)
values
  ('Plaukų kirpimas',50),
  ('Plaukų dažymas',40),
  ('Pedikiūras',35),
  ('Masažas',65),
  ('Manikiūras',20);
    
insert into employee
  (coefficient,person_id)
values
  ('1.50',1),
  ('1.60',2),
  ('1.00',3),
  ('1.10',4),
  ('1.20',5),
  ('1.50',6),
  ('1.20',7),
  ('1.11',8),
  ('1.80',9),
  ('1.60',10);

insert into client
  (telephone_no,person_id)
values
 (61246067,11),
 (61530227,12),
  (65248699,13),
  (64826191,14),
  (65946857,15),
  (61445759,16),
  (61199974,17),
  (65225431,18),
  (68259472,19),
  (67418515,20),
  (65638321,21),
  (64708967,22),
  (60138453,23),
  (61878423,24),
  (61678542,25),
  (68073938,26),
  (67040163,27),
  (64870406,28),
  (60137010,29),
  (61437852,30),
  (63176794,31),
  (68477602,32),
  (61581770,33),
  (60226716,34),
  (69962450,35),
  (61203263,36),
  (67307299,37);

insert into employee_service
  (employee_id,service_id)
values
  (1,1),
  (2,5),
  (3,2),
  (4,3),
  (5,4),
  (6,1),
  (7,2),
  (8,3),
  (9,4),
  (10,5);
  
select * from service;
select * from employee_service;
select * from client;
select * from timetable;
select * from person;
select * from employee;
