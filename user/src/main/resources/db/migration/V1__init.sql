CREATE TABLE users(
    id SERIAL NOT NULL PRIMARY KEY,
    firstname VARCHAR(250),
    lastname VARCHAR(250),
    age integer,
    phone_number VARCHAR(20),
    email VARCHAR(250)

)