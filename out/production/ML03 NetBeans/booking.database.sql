--
-- DROP TABLES
--

drop table BOOKINGS;
drop table ORDERS;
drop table PRICES;

--
-- CREATE TABLES
--

create table PRICES (
	CLASS	 	int,							-- child, adult
    PRICE		decimal(6,2) not null,			-- corresponding unit price
    constraint PRICES_PK primary key (CLASS)
);
-- For the sake of simplicity, we assume there are only two price classes

create table ORDERS (
	CUSTOMER  	varchar(20),					-- customer who made the booking
    AMOUNT		decimal(7,2) not null,			-- total amount of the booking
    ODATE		date, 							-- date of the last order (booking or cancellation)
	constraint ORDERS_PK primary key (CUSTOMER)
);

create table BOOKINGS (
	SEAT 		int,							-- seat: available if CUSOMER=null, booked otherwise
    CLASS		int,							-- price class: null if the seat is not booked, one of the price class otherwise
    CUSTOMER	varchar(20),					-- customer who booked the seat (and sz*qnot the person who will actually seat on it)
    constraint BOOKINGS_PK primary key (SEAT),
    constraint BOOKINGS_FK_CUSTOMER foreign key (CUSTOMER) references ORDERS (CUSTOMER)
);

--
-- POPULATE TABLES
--

insert into PRICES values (1, 25.0);
insert into PRICES values (2, 50.0);

insert into BOOKINGS(SEAT) values (1);
insert into BOOKINGS(SEAT) values (2);
insert into BOOKINGS(SEAT) values (3);
insert into BOOKINGS(SEAT) values (4);
insert into BOOKINGS(SEAT) values (5);
insert into BOOKINGS(SEAT) values (6);
insert into BOOKINGS(SEAT) values (7);
insert into BOOKINGS(SEAT) values (8);
insert into BOOKINGS(SEAT) values (9);
insert into BOOKINGS(SEAT) values (10);


