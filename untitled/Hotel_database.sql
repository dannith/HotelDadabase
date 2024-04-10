CREATE TABLE Hotel(
    HotelName VARCHAR(255),
    Location VARCHAR(255),
    Address VARCHAR(255),
    Picture VARCHAR(255),
    Description VARCHAR(255),
    PRIMARY KEY (HotelName, Address)
)

INSERT INTO Hotel VALUES("StykkisHótel", "Stykkishólmur", "Gullagata 3", "img/hotel/styh3.jpg", "Frábært hótel á flottum stað");
INSERT INTO Hotel VALUES("LúxusHótel", "Stykkishólmur", "Ullarstígur 19", "img/hotel/styh6.jpg", "Fínt 5* hótel");
CREATE TABLE Room (
    HotelName VARCHAR(255),
    HotelAddress VARCHAR(255),
    Number INT,
    NrPerson INT,
    Floor INT,
    Price_Isk INT,
    PictureUrl VARCHAR(255),
    FOREIGN KEY (HotelName, HotelAddress)
    REFERENCES Hotel(HotelName, Address)
    PRIMARY KEY (HotelName, Number)
)
INSERT INTO Room VALUES("StykkisHótel", "Gullagata 3", 1, 2, 1, 2999, "img/room/sty1.jpg");
INSERT INTO Room VALUES("StykkisHótel", "Gullagata 3", 2, 5, 1, 7999, "img/room/sty2.jpg");
INSERT INTO Room VALUES("StykkisHótel", "Gullagata 3", 3, 3, 1, 5999, "img/room/sty3.jpg");
INSERT INTO Room VALUES("LúxusHótel", "Ullarstígur 19", 1, 2, 1, 3800, "img/room/sty4.jpg");
INSERT INTO Room VALUES("LúxusHótel", "Ullarstígur 19", 2, 2, 2, 5400, "img/room/sty5.jpg");
INSERT INTO Room VALUES("LúxusHótel", "Ullarstígur 19", 3, 3, 2, 5000, "img/room/sty6.jpg");

CREATE TABLE Booking (
    Arrival DATE,
    Departure DATE,
    nrPerson INT,
    Rooms INT,
    Owner VARCHAR(255)
)

CREATE TABLE User (
    FirstName VARCHAR(255),
    LastName VARCHAR(255),
    Email VARCHAR(255),
    PhoneNr INT
)
