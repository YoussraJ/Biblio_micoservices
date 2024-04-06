CREATE TABLE emprunts(
    id SERIAL NOT NULL PRIMARY KEY,
    id_user INT,
    id_livre INT,
    borrow_date DATE,
    return_date DATE

)