---  database creation then schema creation must executed  before running the application
CREATE DATABASE triptekker;

--- check connection then create schema from the db UI if it is not created
CREATE SCHEMA triptekker;

---  after registering new user run this query
SELECT * FROM triptekker.user;
