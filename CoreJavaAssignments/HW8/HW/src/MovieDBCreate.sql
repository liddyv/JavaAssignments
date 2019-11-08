CONNECT 'jdbc:derby:MovieDB;create=true';

-- drop tables (ignore errors if they don't exist)
DROP TABLE movies;

-- create Products tabl
CREATE TABLE movies
(
    actor VARCHAR(255), 
	movie VARCHAR(255), 
	movieYear INT
);

 "CREATE TABLE movies" +
				"(actor VARCHAR(255)," +
				"movie VARCHAR(255)," +
				"movieYear INT)";
	