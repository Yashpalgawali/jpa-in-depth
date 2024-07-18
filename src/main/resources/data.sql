INSERT INTO COURSE(id , name , last_updated_date , created_date) VALUES (10001,'JPA', current_timestamp(), current_timestamp());
INSERT INTO COURSE(id , name , last_updated_date , created_date) VALUES (10002,'Spring security', current_timestamp(), current_timestamp());
INSERT INTO COURSE(id , name , last_updated_date , created_date) VALUES (10003,'Microservices', current_timestamp(), current_timestamp());
INSERT INTO COURSE(id , name , last_updated_date , created_date) VALUES (10004,'GraphQL', current_timestamp(), current_timestamp());

INSERT INTO PASSPORT(id , number) VALUES(4001,'W23803');
INSERT INTO PASSPORT(id , number) VALUES(4002,'FD98wW');
INSERT INTO PASSPORT(id , number) VALUES(4003,'KDIO824');
INSERT INTO PASSPORT(id , number) VALUES(4004,'213PJPL');

INSERT INTO STUDENT(id , name, passport_id) VALUES(2001,'Yashpal',4001);
INSERT INTO STUDENT(id , name, passport_id) VALUES(2002,'Dante',4002);
INSERT INTO STUDENT(id , name, passport_id) VALUES(2003,'Shona',4003);
INSERT INTO STUDENT(id , name, passport_id) VALUES(2004,'Samyak',4004);

INSERT INTO REVIEW(id , rating , description) VALUES(5001,'5','Great');
INSERT INTO REVIEW(id , rating , description) VALUES(5002,'4','Awesome');
INSERT INTO REVIEW(id , rating , description) VALUES(5003,'3','Nice');
INSERT INTO REVIEW(id , rating , description) VALUES(5004,'2','Wonderful');