INSERT INTO bikes (id, picture, name, description, price, type, size, booked_dates, reviews, rating, gear, status)
VALUES (1, null,'Romet Aspre','Quite fast gravel bike. Enjoy the speed!', 23.5,'road','M', null, null, 5, '{wheels, breaks}', 'available'),
       (2, null,'Viking','Kids play. Biking makes fun!', 12, 'mtb','S', null, null, 3, '{wheels, breaks}', 'available'),
       (3, null,'Electric KTM','High tech inventory. Helps you beat all hills', 32, 'electric','L', null, null, 3, '{battery}', 'in service'),
       (4, null,'Romet Concordia','Advanced. Enjoy the speed!', 19.5,'road','S', null, null, 5, '{wheels, breaks}', 'available'),
       (5, null,'Viking II','Kids play. Biking makes fun!', 12, 'mtb','S', null, null, 3, '{wheels, breaks}', 'available'),
       (6, null,'Electric KTM II','High tech inventory. Helps you beat all hills', 32, 'electric','L', null, null, 3, '{battery}', 'available'),
       (7, null,'Viking III','Kids play. Biking makes fun!', 12, 'mtb','S', null, null, 3, '{wheels, breaks}', 'available'),
       (8, null,'Electric KTM','High tech inventory. Helps you beat all hills', 32, 'electric','L', null, null, 3, '{battery}', 'in service'),
       (9, null,'Romet Aspre II','Super fast gravel bike. Enjoy the speed!', 29.5,'road','L', null, null, 5, '{wheels, breaks}', 'available'),
       (10, null,'Merida Turbo','Speed race', 22, 'road','S', null, null, 3, '{wheels, breaks}', 'available'),
       (11, null,'Mock KTM','High tech inventory. Blabla', 32, 'electric','M', null, null, 3, '{battery}', 'available');

INSERT INTO booked_dates (id, bike_id, date_start, date_end)
VALUES (0, 1, 'Thu Jun 17 2021 00:00:00 GMT+0200', 'Wed Jun 23 2021 00:00:00 GMT+0200'),
       (1, 1, 'Mon Jun 21 2021 00:00:00 GMT+0200', 'Fri Jun 25 2021 00:00:00 GMT+0200'),
       (2, 2, 'Fri Jun 18 2021 00:00:00 GMT+0200', 'Sun Jun 20 2021 00:00:00 GMT+0200'),
       (3, 3, 'Mon Jun 21 2021 00:00:00 GMT+0200', 'Fri Jun 25 2021 00:00:00 GMT+0200');
