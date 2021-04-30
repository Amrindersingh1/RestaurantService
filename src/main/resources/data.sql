
INSERT INTO Restaurant(name, rating, city, province) VALUES('RestaurantA', 5, 'brampton', 'ON');
INSERT INTO Restaurant(name, rating, city, province) VALUES('RestaurantB', 8, 'Missi', 'ON');

INSERT INTO CHEF (name, salary, restaurant_id) VALUES ('chefA', 2000, 1);
INSERT INTO CHEF (name, salary, restaurant_id) VALUES ('chefB', 2000, 1);
INSERT INTO CHEF (name, salary, restaurant_id) VALUES ('chefC', 4000, 2);
INSERT INTO CHEF (name, salary, restaurant_id) VALUES ('chefD', 4000, 2);


INSERT INTO CUSINE (name, restaurant_id) VALUES ('cusineA',1);
INSERT INTO CUSINE (name, restaurant_id) VALUES ('cusineF',2);
INSERT INTO CUSINE (name, restaurant_id) VALUES ('cusineB',1);
INSERT INTO CUSINE (name, restaurant_id) VALUES ('cusineG',2);
INSERT INTO CUSINE (name, chef_id) VALUES ('cusineA',1);
INSERT INTO CUSINE (name, chef_id) VALUES ('cusineC',2);
INSERT INTO CUSINE (name, chef_id) VALUES ('cusineF',3);
INSERT INTO CUSINE (name, chef_id) VALUES ('cusineB',1);
INSERT INTO CUSINE (name, chef_id) VALUES ('cusineD',2);
INSERT INTO CUSINE (name, chef_id) VALUES ('cusineG',3);
INSERT INTO CUSINE (name, chef_id) VALUES ('cusineE',4);

