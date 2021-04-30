DROP TABLE IF EXISTS Cusine;
DROP TABLE IF EXISTS Chef;
DROP TABLE IF EXISTS Restaurant;

CREATE TABLE Restaurant (
                              id INT AUTO_INCREMENT  PRIMARY KEY,
                              name VARCHAR(250) NOT NULL,
                              rating DOUBLE,
                              city VARCHAR(128) NOT NULL,
                              province VARCHAR(128) NOT NULL
);

CREATE TABLE Chef (
                            id INT AUTO_INCREMENT  PRIMARY KEY,
                            name VARCHAR(250) NOT NULL,
                            salary DOUBLE NOT NULL,
                            restaurant_id INT,
                            foreign key(restaurant_id) references Restaurant(id)
);

CREATE TABLE Cusine (
                      id INT AUTO_INCREMENT  PRIMARY KEY,
                      name VARCHAR(250) NOT NULL,
                      restaurant_id INT,
                      chef_id INT,
                      foreign key(chef_id) references Chef(id),
                      foreign key(restaurant_id) references Restaurant(id)
);

INSERT INTO Restaurant(name, rating, city, province) VALUES('mcdonalds', 5, 'brampton', 'ON');
INSERT INTO Restaurant(name, rating, city, province) VALUES('Tims', 8, 'Missi', 'ON');

INSERT INTO CHEF (name, salary, restaurant_id) VALUES ('chefa', 2000, 1);
INSERT INTO CHEF (name, salary, restaurant_id) VALUES ('bchef', 2000, 1);
INSERT INTO CHEF (name, salary, restaurant_id) VALUES ('timchef', 4000, 2);
INSERT INTO CHEF (name, salary, restaurant_id) VALUES ('timb1', 4000, 2);

INSERT INTO CUSINE (name, restaurant_id) VALUES ('a',1);
INSERT INTO CUSINE (name, restaurant_id) VALUES ('a',2);
INSERT INTO CUSINE (name, restaurant_id) VALUES ('b',1);
INSERT INTO CUSINE (name, restaurant_id) VALUES ('c',2);
INSERT INTO CUSINE (name, chef_id) VALUES ('d',1);
INSERT INTO CUSINE (name, chef_id) VALUES ('a',2);
INSERT INTO CUSINE (name, chef_id) VALUES ('b',3);
INSERT INTO CUSINE (name, chef_id) VALUES ('c',4);
INSERT INTO CUSINE (name, chef_id) VALUES ('e',1);
INSERT INTO CUSINE (name, chef_id) VALUES ('f',2);
INSERT INTO CUSINE (name, chef_id) VALUES ('g',3);
INSERT INTO CUSINE (name, chef_id) VALUES ('h',4);

