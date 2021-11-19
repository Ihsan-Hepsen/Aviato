-- INSERT INTO AIRLINES(ID, AIRLINE, FLEET_SIZE, DESTINATIONS, FLIGHTS)
-- VALUES (0, 'Qantas Airlines', 134, 77, 1),
--        (1, 'Turkish Airlines', 350, 304, 1),
--        (2, 'Air New Zealand', 114, 80, 1),
--        (3, 'Virgin Australia', 68, 40, 2),
--        (4, 'Bahamas Air', 10, 21, 1),
--        (5, 'Private Voyages', 11, 13, 2),
--        (6, 'Iberia Airlines', 68, 120, 1),
--        (7, 'All Nippon Airways', 220, 75, 1);

/* WEEK-7 REQUIREMENT */
INSERT INTO FLIGHTS(ID, AIRLINE, FLIGHT_NUMBER, FLIGHT_TYPE, DEPARTURE, ARRIVAL, DATE, ON_TIME)
VALUES (0, 'Qantas Airlines', 'QF12', 'COMM', 'Los Angeles', 'Sydney', DATE '2021-10-21', true),
       (1, 'Turkish Airlines', 'TK77', 'COMM', 'Istanbul', 'Miami', DATE '2021-10-22', false),
       (2, 'Private Voyages', 'HI4506', 'PRIV', 'Honolulu', 'Sydney', DATE '2021-10-21', true),
       (3, 'Air New Zealand', 'NZ6141', 'COMM', 'Auckland', 'Sydney', DATE '2021-10-22', false),
       (4, 'Bahamas Air', 'BHS224', 'COMM', 'Miami', 'Nassau', DATE '2021-10-23', false),
       (5, 'Virgin Australia', 'VA526', 'COMM', 'Sydney', 'Gold Coast', DATE '2021-10-22', true),
       (6, 'Virgin Australia', 'VA734', 'COMM', 'Gold Coast', 'Melbourne', DATE '2021-10-23', false),
       (7, 'Private Voyages', 'HI1204', 'PRIV', 'New York', 'Miami', DATE '2021-10-23', false),
       (8, 'Iberia Airlines', 'IB3013', 'COMM', 'Barcelona', 'Madrid', DATE '2021-11-19', true),
       (9, 'All Nippon Airways', 'NH802', 'COMM', 'Singapore', 'Tokyo', DATE '2021-12-13', true);

-- SELECT * FROM FLIGHTS;

INSERT INTO PASSENGERS(ID, NAME, AGE, GENDER, TRANSIT, FLIGHTS)
VALUES (0, 'Johnny Thunder', 21, 'M', TRUE, 3),
       (1, 'Anna Cooper', 23, 'F', TRUE, 2),
       (2, 'Padme Amidala', 35, 'F', FALSE, 1),
       (3, 'Kilroy Barron', 52, 'M', FALSE, 1),
       (4, 'Senor Palomar', 32, 'M', FALSE, 1),
       (5, 'Kül Tigin', 37, 'M', FALSE, 1),
       (6, 'Valaria Ferreria', 26, 'F', FALSE, 1),
       (7, 'Akane Tanaka', 34, 'F', FALSE, 1);
/* WEEK-7 REQUIREMENT ENDS */

-- SELECT * FROM PASSENGERS;

INSERT INTO BOOKED_FLIGHTS(FLIGHT_ID, PASSENGER_ID)
VALUES (0, 0),
       (5, 0),
       (6, 0),
       (1, 1),
       (4, 1),
       (2, 2),
       (3, 3),
       (3, 4),
       (7, 5),
       (8, 6),
       (9, 7);

-- Below section is for later. Come back later.
-- SELECT passenger_id, id, airline, flight_number, flight_type, departure, arrival, date, on_time
-- FROM BOOKED_FLIGHTS
-- INNER JOIN FLIGHTS F on F.FLIGHT_NUMBER = BOOKED_FLIGHTS.FLIGHT;

-- SELECT passenger_id, flight_number
-- FROM BOOKED_FLIGHTS
-- INNER JOIN FLIGHTS F on BOOKED_FLIGHTS.FLIGHT = F.FLIGHT_NUMBER;
--
-- SELECT * FROM BOOKED_FLIGHTS WHERE FLIGHT like '%';