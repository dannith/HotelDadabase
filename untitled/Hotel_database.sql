CREATE TABLE Hotel(
    HotelName VARCHAR(255),
    Location VARCHAR(255),
    Address VARCHAR(255),
    Picture VARCHAR(255),
    Description VARCHAR(255),
    PRIMARY KEY (HotelName, Address)
);

INSERT INTO Hotel VALUES("StykkisHótel", "Stykkishólmur", "Gullagata 3", "img/hotel/styh3.jpg", "Frábært hótel á flottum stað");
INSERT INTO Hotel VALUES("LúxusHótel", "Stykkishólmur", "Ullarstígur 19", "img/hotel/styh6.jpg", "Fínt 5* hótel");

CREATE TABLE Room (
    HotelName VARCHAR(255),
    HotelAddress VARCHAR(255),
    Number INT NOT NULL,
    NrPerson INT NOT NULL,
    Floor INT NOT NULL,
    Price_Isk INT NOT NULL,
    PictureUrl VARCHAR(255),
    FOREIGN KEY (HotelName, HotelAddress)
    REFERENCES Hotel(HotelName, Address)
    PRIMARY KEY (HotelName, Number)
);

INSERT INTO Room VALUES("StykkisHótel", "Gullagata 3", 1, 2, 1, 2999, "img/room/sty1.jpg");
INSERT INTO Room VALUES("StykkisHótel", "Gullagata 3", 2, 5, 1, 7999, "img/room/sty2.jpg");
INSERT INTO Room VALUES("StykkisHótel", "Gullagata 3", 3, 3, 1, 5999, "img/room/sty3.jpg");
INSERT INTO Room VALUES("LúxusHótel", "Ullarstígur 19", 1, 2, 1, 3800, "img/room/sty4.jpg");
INSERT INTO Room VALUES("LúxusHótel", "Ullarstígur 19", 2, 2, 2, 5400, "img/room/sty5.jpg");
INSERT INTO Room VALUES("LúxusHótel", "Ullarstígur 19", 3, 3, 2, 5000, "img/room/sty6.jpg");

CREATE TABLE Booking (
    BookingID INTEGER PRIMARY KEY AUTOINCREMENT,
    Arrival DATE NOT NULL,
    Departure DATE NOT NULL,
    nrPerson INT NOT NULL,
    OwnerLastName VARCHAR(255) NOT NULL,
    OwnerEmail VARCHAR(255) NOT NULL,
    FOREIGN KEY (OwnerLastName, OwnerEmail)
    REFERENCES User(LastName, Email)
);

INSERT INTO Booking('Arrival', 'Departure', 'nrPerson', 'OwnerLastName', 'OwnerEmail') VALUES('2024-06-18', '2024-06-24', 4, 'Arnar','a@a.is');

CREATE TABLE Booking_Room (
    BookingID INT NOT NULL,
    HotelName VARCHAR(255) NOT NULL,
    RoomNumber INT NOT NULL,
    PRIMARY KEY(BookingID, HotelName, RoomNumber),
    FOREIGN KEY(HotelName, RoomNumber)
    REFERENCES Room(HseleotelName, Number)
    FOREIGN KEY(BookingID)
    REFERENCES Booking(BookingID)
);

insert into Booking_Room VALUES(4, 'LúxusHótel', 2);
insert into Booking_Room VALUES(4, 'LúxusHótel', 1);



CREATE TABLE User (
    FirstName VARCHAR(255),
    LastName VARCHAR(255),
    Email VARCHAR(255),
    PRIMARY KEY(LastName, Email)
);

INSERT INTO User VALUES("Palli", "Arnar", "a@a.is");

--aVAILABLEROOMS FOR DATE
select * from Room as r 
	join Hotel as h ON ((r.HotelName, r.HotelAddress) = (h.HotelName, h.Address)) 
	join Booking_Room as br ON ((br.HotelName, br.RoomNumber) = (r.HotelName, r.Number)) 
	join Booking as b ON (b.BookingID = br.BookingID)
	where (b.arrival NOT BETWEEN ? AND ?) 
	AND (b.departure NOT BETWEEN ? AND ?)
	AND (? BETWEEN b.arrival AND b.departure)
	AND (? BETWEEN b.arrival AND b.departure)
	
select * from Room as r 
	join Hotel as h ON ((r.HotelName, r.HotelAddress) = (h.HotelName, h.Address)) 
	join Booking_Room as br ON ((br.HotelName, br.RoomNumber) = (r.HotelName, r.Number)) 
	join Booking as b ON (b.BookingID = br.BookingID)
	where (b.arrival > '2024-05-15' AND b.departure < '2024-0-27');


select * from Room as r 
	join Hotel as h ON ((r.HotelName, r.HotelAddress) = (h.HotelName, h.Address)) 
	join Booking_Room as br ON ((br.HotelName, br.RoomNumber) = (r.HotelName, r.Number)) 
	join Booking as b ON (b.BookingID = br.BookingID)
	where('2024-06-15' BETWEEN b.arrival AND b.departure)
	AND ('2024-06-27' BETWEEN b.arrival AND b.departure);

