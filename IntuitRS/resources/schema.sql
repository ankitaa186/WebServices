create table person(
id int auto_increment primary key,
name varchar(50),
dob date,
sex char(1),
email varchar(100)
);

create table department(
id int auto_increment primary key,
name varchar(30),
hod int,
constraint foreign key(hod) references person(id)
);

create table employee(
id int auto_increment primary key,
person int,
constraint foreign key(person) references person(id),
department int,
constraint foreign key(department) references department(id)
);

INSERT INTO `restservices`.`person`
(
`name`,
`dob`,
`sex`,
`email`)
VALUES
(
'Ankit',
'1984-12-17',
'M',
'ankit.ag.in@gmail.com');

INSERT INTO `restservices`.`employee`
(
`person`,
`department`)
VALUES
(
1,
1);

INSERT INTO `restservices`.`department`
(
`name`,
`hod`)
VALUES
(
'Computer Science',
1);