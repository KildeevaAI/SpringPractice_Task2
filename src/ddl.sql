use Bus
CREATE TABLE OPENJPA_SEQUENCE_TABLE (ID SMALLINT NOT NULL, SEQUENCE_VALUE BIGINT, PRIMARY KEY (ID));

CREATE TABLE BusStop (
      IDBusStop INTEGER NOT NULL,
	  NameStop VARCHAR(100)
);

ALTER TABLE BusStop ADD CONSTRAINT BusStop_PK Primary Key (IDBusStop);

CREATE TABLE Bus (
     IDBus INTEGER NOT NULL,
	 Number INTEGER NOT NULL,
	 Capacity INTEGER
);

ALTER TABLE Bus ADD CONSTRAINT Bus_PK Primary Key (IDBus);


CREATE TABLE BusStopDetails(
      IDBusStop INTEGER NOT NULL,
	  IDBus INTEGER NOT NULL,

);

ALTER TABLE BusStopDetails ADD CONSTRAINT BusStopDetails_PK Primary Key (IDBusStop, IDBus);

ALTER TABLE BusStopDetails ADD CONSTRAINT IDBusStop_FK Foreign Key (IDBusStop) REFERENCES BusStop (IDBusStop);

ALTER TABLE BusStopDetails ADD CONSTRAINT IDBus_FK Foreign Key (IDBus) REFERENCES Bus (IDBus);

INSERT BusStop(NameStop)
VALUES ('Kolosok'),
('Moskovckaya'),
('Chapaeva'),
('Rahova'),
('Rabochay');
GO

INSERT INTO Bus(Number, Capacity)
VALUES ('3', '50'),
('6', '50'),
('11', '50'),
('18', '50'),
('2', '50');
GO


INSERT INTO BusStopDetails(IDBusStop, IDBus)
VALUES ('1', '1'),
('1', '2'),
('1', '3'),
('2', '1'),
('2', '4'),
('2', '2'),
('3', '2'),
('3', '5'),
('4', '1'),
('4', '2'),
('4', '4'),
('5', '2'),
('5', '3');
GO
