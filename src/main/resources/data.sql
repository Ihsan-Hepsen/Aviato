INSERT INTO FLIGHTS(ID, AIRLINE, FLIGHT_NUMBER, FLIGHT_TYPE, DEPARTURE, ARRIVAL, DATE, ON_TIME)
VALUES (0, 'Golden Wings', 'G1456', 'PRIV', 'Sydney', 'Gold Coast', DATE '2021-11-21', true),
       (1, 'Qantas Airlines', 'QF12', 'COMM', 'Los Angeles', 'Sydney', DATE '2021-10-21', true),
       (2, 'Turkish Airlines', 'TK77', 'COMM', 'Istanbul', 'Miami', DATE '2021-10-22', false),
       (3, 'Private Voyages', 'HI4506', 'PRIV', 'Honolulu', 'Sydney', DATE '2021-10-21', true),
       (4, 'Air New Zealand', 'NZ6141', 'COMM', 'Auckland', 'Sydney', DATE '2021-10-22', false),
       (5, 'Bahamas Air', 'BHS224', 'COMM', 'Miami', 'Nassau', DATE '2021-10-23', false),
       (6, 'Virgin Australia', 'VA526', 'COMM', 'Sydney', 'Gold Coast', DATE '2021-10-22', true),
       (7, 'Virgin Australia', 'VA734', 'COMM', 'Gold Coast', 'Melbourne', DATE '2021-10-23', false),
       (8, 'Private Voyages', 'HI1204', 'PRIV', 'New York', 'Miami', DATE '2021-10-23', false),
       (9, 'Iberia Airlines', 'IB3013', 'COMM', 'Barcelona', 'Madrid', DATE '2021-11-19', true),
       (10, 'All Nippon Airways', 'NH802', 'COMM', 'Singapore', 'Tokyo', DATE '2021-12-13', true);

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

-- SELECT * FROM PASSENGERS;

INSERT INTO BOOKED_FLIGHTS(FLIGHT, PASSENGER_ID)
VALUES ('QF12', 0),
       ('VA526', 0),
       ('VA734', 0),
       ('TK77', 1),
       ('BHS224', 1),
       ('HI4506', 2),
       ('NZ6141', 3),
       ('NZ6141', 4),
       ('HI1204', 5),
       ('IB3013', 6),
       ('NH802', 7);

-- SELECT * FROM BOOKED_FLIGHTS;