INSERT INTO FLIGHTS(AIRLINE, FLIGHT_NUMBER, FLIGHT_TYPE, DEPARTURE, ARRIVAL, DATE, ON_TIME)
VALUES ('Golden Wings', 'G1456', 'Private', 'Sydney', 'Gold Coast', DATE '2021-11-21', true),
       ('Qantas Airlines', 'QF12', 'Commercial', 'Los Angeles','Sydney', DATE '2021-10-21', true),
       ('Turkish Airlines','TK77', 'Commercial', 'Istanbul','Miami', DATE '2021-10-22', false),
       ('Private Voyages','HI4506', 'Private', 'Honolulu','Sydney', DATE '2021-10-21', true),
       ('Air New Zealand', 'NZ6141', 'Commercial', 'Auckland','Sydney', DATE '2021-10-22', false),
       ('Bahamas Air', 'BHS224', 'Commercial', 'Miami', 'Nassau', DATE '2021-10-23', false),
       ('Virgin Australia', 'VA526', 'Commercial', 'Sydney', 'Gold Coast', DATE '2021-10-22', true),
       ('Virgin Australia', 'VA734', 'Commercial', 'Gold Coast', 'Melbourne', DATE '2021-10-23', false),
       ('Private Voyages', 'HI1204', 'Private', 'New York', 'Miami', DATE '2021-10-23', false),
       ('Iberia Airlines', 'IB3013', 'Commercial', 'Barcelona', 'Madrid', DATE '2021-11-19', true),
       ('All Nippon Airways', 'NH802', 'Commercial', 'Singapore', 'Tokyo', DATE '2021-12-13', true);

SELECT * FROM FLIGHTS;

INSERT INTO PASSENGERS(name, age, gender, transit, flights)
VALUES('JOHNNY THUNDER', 21, 'MALE', TRUE, 3),
      ('ANNA COOPER', 23, 'FEMALE', TRUE, 2),
      ('PADME AMIDALA', 35, 'FEMALE', FALSE, 1),
      ('KILROY BARRON', 52, 'MALE', FALSE, 1),
      ('SENOR PALOMAR', 32, 'MALE', FALSE, 1),
      ('KÜL TİGİN', 37, 'MALE', FALSE, 1),
      ('VALARIA FERREIRA', 26, 'FEMALE', FALSE, 1),
      ('AKANE TANAKA', 34, 'FEMALE', FALSE, 1);

SELECT * FROM PASSENGERS;