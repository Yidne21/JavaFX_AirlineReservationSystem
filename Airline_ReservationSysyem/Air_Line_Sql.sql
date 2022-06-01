create database Air_Line;
use Air_Line;

CREATE TABLE user(  
    id int NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'Primary Key',
    fname VARCHAR(200) NOT NULL,
    lname VARCHAR(200) NOT NULL,
    email VARCHAR(200) NOT NULL,
    phone VARCHAR(200) NOT NULL,
    pass_word VARCHAR(200) NOT NULL,
    dob DATE NOT NULL,
    Addresss VARCHAR(200) NOT NULL,
    roles VARCHAR(200) NOT NULL
) DEFAULT CHARSET UTF8 COMMENT 'newTable';



CREATE TABLE plane(  
    plane_id int NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'Primary Key',
    total_seat int NOT NULL,
    reserved_seat int NOT null,
    avilable_seaat int NOT NULL
) DEFAULT CHARSET UTF8 COMMENT 'newTable';

CREATE TABLE seats(  
    seat_id int NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'Primary Key',
    pid int,
    class VARCHAR(200) NOT null,
    CONSTRAINT fk_seats
    FOREIGN KEY (pid) 
    REFERENCES plane(plane_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE
) DEFAULT CHARSET UTF8 COMMENT 'newTable';
/* 2022-05-17 18:32:48 [1466 ms] */ 


CREATE TABLE journey(  
    journey_id int NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'Primary Key',
    from_ VARCHAR(200) NOT null,
    destination VARCHAR(200) NOT null,
    rout VARCHAR(200) NOT null
) DEFAULT CHARSET UTF8 COMMENT 'newTable';
/* 2022-05-17 19:08:02 [2367 ms] */ 


CREATE TABLE flight_schedule(  
    schedule_id int NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'Primary Key',
    flight_name varchar(20),
    jid int NOT NULL,
    pid int NOT NULL,
    DATE_ DATE NOT NULL,
    arrival_time TIME NOT NULL,
    destination_time TIME NOT NULL,
    CONSTRAINT fk_schedule
    FOREIGN KEY (pid) 
    REFERENCES plane(plane_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT fk_sche_jour
    FOREIGN KEY (jid) 
    REFERENCES journey(journey_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE
) DEFAULT CHARSET UTF8 COMMENT 'newTable';
/* 2022-05-17 19:17:26 [2436 ms] */ 


CREATE TABLE tickets(  
    ticket_id int NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'Primary Key',
    seatid int NOT NULL,
    scheid int NOT NULL,
	cost FLOAT NOT NULL,
    status_ VARCHAR(222) NOT NULL,
    CONSTRAINT fk_ticket_sche
    FOREIGN KEY (scheid) 
    REFERENCES flight_schedule(schedule_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT fk_seat
    FOREIGN KEY (seatid) 
    REFERENCES seats(seat_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE
) DEFAULT CHARSET UTF8 COMMENT 'newTable';
/* 2022-05-17 19:23:39 [1098 ms] */ 


CREATE TABLE books(  
    book_id int NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'Primary Key',
    uid_ int NOT NULL,
    ticketid int NOT NULL,
    no_person int NOT NULL,
    total_price int not null,
    CONSTRAINT fk_book_ticket
    FOREIGN KEY (ticketid) 
    REFERENCES tickets(ticket_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT fk_book_user
    FOREIGN KEY (uid_) 
    REFERENCES user(id)
        ON UPDATE CASCADE
        ON DELETE CASCADE
) DEFAULT CHARSET UTF8 COMMENT 'newTable';


 --- user
 insert into user (fname , lname , email , phone , pass_word , dob , Addresss , roles ) 
 values ('gh' , 'jk' , 'hgg' , 'jk' , 'reff' ,4/5/2012,'hfs','dss');

-- plane
insert into plane values (3,50,25,25);

-- seat 
insert into seats(pid , class)  values(3,'economics');

-- journey

insert into journey values (1,'ds','ss','dd');
insert into journey values (2,'ds','ss','dd');
insert into journey values (3,'ds','ss','dd');

delete from journey 
where journey_id = 2;

update journey
set from_ = 'ff'
where journey_id = '1';


-- flight_schedule
insert into flight_schedule(flight_name , jid , pid , DATE_ , arrival_time , destination_time )values ('E',3,3,2/2/2022,12,11);

-- tickets
insert into tickets(seatid , scheid , cost , status_ ) values (1,1,700,'dd');

-- book
insert into books(uid_ , ticketid , no_person , total_price) values(1,1,4,234);



select *from journey; 
select *from plane;
select *from flight_schedule;
select *from seats;
select *from books;
select *from tickets;
select *from user;


-- booklist
 select   fname , lname , phone , email , no_person , cost as 'Iicket price' , total_price
 from books
 inner join user 
 on  books.uid_ = user.id
 inner join tickets
 on tickets.ticket_id = books.ticketid;
 
--  flightlist

  select schedule_id , flight_name , from_ , destination , DATE_ , arrival_time , destination_time 
  from flight_schedule
 inner join journey
 on flight_schedule.jid= journey.journey_id 
  inner join tickets
 on tickets.scheid= flight_schedule.schedule_id ;
