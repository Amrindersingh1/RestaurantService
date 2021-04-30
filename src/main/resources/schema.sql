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
