CREATE TABLE Hotels (
    HotelName VARCHAR(255),
    Location VARCHAR(255),
    Address VARCHAR(255),
    picture VARCHAR(255),
    AvRooms INT,
    RevRooms INT,
    PRIMARY KEY (HotelName, Address)
)

CREATE TABLE Room (
    HotelName VARCHAR(255),
    Number INT,
    NrPerson INT,
    Floor INT,
    Price_Isk INT,
    PictureUrl VARCHAR(255),
    FOREIGN KEY (HotelName),
    PRIMARY KEY (HotelName, Number)
)

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
    PhoneNr INT,
    idNr
)