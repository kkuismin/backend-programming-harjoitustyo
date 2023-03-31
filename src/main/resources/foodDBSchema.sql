SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS location;
DROP TABLE IF EXISTS foodtype;
DROP TABLE IF EXISTS car;
DROP TABLE IF EXISTS appuser;

SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE location
(id BIGINT NOT NULL AUTO_INCREMENT
, locationname VARCHAR(100) NOT NULL
, PRIMARY KEY (id)
);

INSERT INTO location (locationname) 
VALUES ("Freezer"), ("Fridge"), ("Pantry");

CREATE TABLE foodtype 
(id BIGINT NOT NULL AUTO_INCREMENT
, typename VARCHAR(250) NOT NULL
, PRIMARY KEY (id)
);

INSERT INTO foodtype (typename)
VALUES ("Dairy"), ("Drinks"), ("Fruits, Vegetables and Berries"),
("Grains"), ("Proteins"), ("Snacks"), ("Spices");

CREATE TABLE food
(id BIGINT NOT NULL AUTO_INCREMENT
, name VARCHAR(50) NOT NULL
, quantity INT
, locationid BIGINT
, typeid BIGINT
, expirationdate VARCHAR(50)
, FOREIGN KEY (locationid) REFERENCES location(id)
, FOREIGN KEY (typeid) REFERENCES foodtype(id)
, PRIMARY KEY (id)
);

INSERT INTO food (name, quantity, locationid, typeid, expirationdate)
VALUES ("Tuna", 1, 3, 5, "1.5.2024"), 
("Oat flakes", 2, 3, 4, "5.10.2023"),
("Strawberries", 1, 1, 3, "1.6.2023"),
("Tofu", 1, 2, 5, "31.3.2023"),
("Chocolate bar", 3, 3, 6, "22.7.2023"),
("Orange juice", 2, 2, 2, "2.4.2023"),
("Butter", 2, 2, 1, "30.4.2023");

CREATE TABLE appuser
(id BIGINT NOT NULL AUTO_INCREMENT
, firstname VARCHAR(100) NOT NULL
, lastname VARCHAR(100) NOT NULL
, username VARCHAR(250) NOT NULL
, password_hash VARCHAR(250) NOT NULL
, role VARCHAR(100) NOT NULL
, PRIMARY KEY(id)
);

INSERT INTO appuser (firstname, lastname, username, password_hash, role)
VALUES ("John", "Doe", "user", "$2a$10$44CXRQzFklqLdg8EP2n35upJSOrSSd.q.GcBjVnoYpqhx8jpInMhy", "USER"),
("Jane", "Doe", "admin", "$2a$10$wRPxDuKJ5uVaholbnaD89ulbEvAyHqI0i6SS6XnKk1gGF6.Rr76hm", "ADMIN");

SELECT * FROM location;
SELECT * FROM foodtype;
SELECT * FROM food;
SELECT * FROM appuser;