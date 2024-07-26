INSERT INTO COURSE(id , name , last_updated_date , created_date) VALUES (10001,'JPA in 100 steps', current_timestamp(), current_timestamp());
INSERT INTO COURSE(id , name , last_updated_date , created_date) VALUES (10002,'Spring security', current_timestamp(), current_timestamp());
INSERT INTO COURSE(id , name , last_updated_date , created_date) VALUES (10003,'Microservices in 100 steps', current_timestamp(), current_timestamp());
INSERT INTO COURSE(id , name , last_updated_date , created_date) VALUES (10004,'GraphQL', current_timestamp(), current_timestamp());
/*INSERT INTO COURSE(id , name , last_updated_date , created_date) VALUES (10005,'KAFKA', current_timestamp(), current_timestamp());
INSERT INTO COURSE(id , name , last_updated_date , created_date) VALUES (10006,'ZOOKeeper', current_timestamp(), current_timestamp());
INSERT INTO COURSE(id , name , last_updated_date , created_date) VALUES (10007,'kubernetes', current_timestamp(), current_timestamp());
INSERT INTO COURSE(id , name , last_updated_date , created_date) VALUES (10008,'Docker', current_timestamp(), current_timestamp());
*/

INSERT INTO PASSPORT(id , number) VALUES(4001,'W23803');
INSERT INTO PASSPORT(id , number) VALUES(4002,'FD98wW');
INSERT INTO PASSPORT(id , number) VALUES(4003,'KDIO824');
INSERT INTO PASSPORT(id , number) VALUES(4004,'123PJPL');

INSERT INTO STUDENT(id , name, passport_id) VALUES(2001,'Yashpal',4001);
INSERT INTO STUDENT(id , name, passport_id) VALUES(2002,'Dante',4002);
INSERT INTO STUDENT(id , name, passport_id) VALUES(2003,'Shona',4003);
INSERT INTO STUDENT(id , name, passport_id) VALUES(2004,'Samyak',4004);

INSERT INTO REVIEW(id , rating , description, course_id) VALUES(5001,'5','Great',10001);
INSERT INTO REVIEW(id , rating , description, course_id) VALUES(5002,'4','Awesome',10001);
INSERT INTO REVIEW(id , rating , description, course_id) VALUES(5003,'3','Nice',10002);
INSERT INTO REVIEW(id , rating , description, course_id) VALUES(5004,'2','Wonderful',10003);


INSERT INTO STUDENT_COURSE(STUDENT_ID ,COURSE_ID) VALUES(2001 , 10004 );
INSERT INTO STUDENT_COURSE(STUDENT_ID ,COURSE_ID) VALUES(2001 , 10003 );
INSERT INTO STUDENT_COURSE(STUDENT_ID ,COURSE_ID) VALUES(2003 , 10004 );
INSERT INTO STUDENT_COURSE(STUDENT_ID ,COURSE_ID) VALUES(2004 , 10002 );
