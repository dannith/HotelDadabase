SELECT Number, NrPerson, Floor, Price_Isk, PictureUrl FROM Room JOIN hotel ON (Room.HotelName, Room.HotelAddress) = (hotel.HotelName, hotel.Address)
WHERE NOT EXISTS (SELECT r.Number, r.NrPerson, r.Floor, r.Price_Isk, r.PictureUrl FROM Room AS r
JOIN Hotel AS h ON ((r.HotelName, r.HotelAddress) = (h.HotelName, h.Address))
JOIN Booking_Room AS br ON ((br.HotelName, br.HotelAddress, br.RoomNumber) = (r.HotelName, r.HotelAddress, r.Number))
JOIN Booking AS b ON (b.BookingID = br.BookingID)
WHERE (b.arrival NOT BETWEEN '2024-04-11' AND '2024-04-15')
AND (b.departure NOT BETWEEN '2024-04-11' AND '2024-04-15')
AND NOT (b.arrival > '2024-04-11' AND b.departure < '2024-04-15'))
AND (hotel.HotelName, hotel.Address) = ('AK-HOTEL', 'Borgarbraut 3');


SELECT Number, NrPerson, Floor, Price_Isk, PictureUrl FROM Room WHERE (HotelName, HotelAddress, Number) NOT IN(
SELECT r.HotelName, r.HotelAddress, r.Number FROM Room AS r
JOIN Hotel AS h ON ((r.HotelName, r.HotelAddress) = (h.HotelName, h.Address))
JOIN Booking_Room AS br ON ((br.HotelName, br.HotelAddress, br.RoomNumber) = (r.HotelName, r.HotelAddress, r.Number))
JOIN Booking AS b ON (b.BookingID = br.BookingID)
WHERE (b.arrival BETWEEN '2024-04-11' AND '2024-04-15')
OR (b.departure BETWEEN '2024-04-11' AND '2024-04-15')
OR (b.arrival < '2024-04-11' AND b.departure > '2024-04-15'))
AND (HotelName, HotelAddress) = ('AK-HOTEL', 'Borgarbraut 3');