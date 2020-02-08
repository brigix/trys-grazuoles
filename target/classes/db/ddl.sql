create table person
(
    id int unsigned auto_increment primary key,
    name varchar (50) not null,
    surname varchar (50),
    birthday date
);
create table service
(
    id int unsigned auto_increment primary key,
    title varchar (50) not null,
    price decimal(8, 2) not null
);
create table employee
(
    id int unsigned auto_increment primary key,
    coefficient decimal(8, 2) not null,
    person_id int unsigned not null,
    foreign key (person_id) references person(id)
);
create table client
(
    id int unsigned auto_increment primary key,
    telephone_no int unsigned not null,
    person_id int unsigned not null,
    foreign key (person_id) references person(id),
    unique (telephone_no)
    );
create table employee_service
(
    id int unsigned not null auto_increment primary key,
    employee_id int unsigned not null,
    service_id int unsigned not null,
    foreign key (employee_id) references employee(id),
    foreign key (service_id) references service(id)
  );
  create table timetable
  (
     id int unsigned not null auto_increment primary key,
     booked_time datetime not null,
     employee_id int unsigned not null,
     service_id int unsigned not null,
     client_id int unsigned not null,
     foreign key (employee_id) references employee(id),
     foreign key (client_id) references client(id),
     foreign key (service_id) references service(id)
  );
