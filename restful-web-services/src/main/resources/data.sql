INSERT INTO user_details(id,name,birth_date)
values (10001,'Andres',current_date());

INSERT INTO user_details(id,name,birth_date)
values (10002,'Laura',current_date());

INSERT INTO user_details(id,name,birth_date)
values (10003,'Marta',current_date());

INSERT INTO post(id,user_id,description)
values (50001,10001,'aaaaaaaa');

INSERT INTO post(id,user_id,description)
values (50002,10001,'bbbbbbbb');

INSERT INTO post(id,user_id,description)
values (50003,10001,'cccccc');

INSERT INTO post(id,user_id,description)
values (50004,10002,'dddddd');

INSERT INTO post(id,user_id,description)
values (50005,10002,'eeeeeeeee');

INSERT INTO post(id,user_id,description)
values (50006,10003,'fffffffff');

INSERT INTO post(id,user_id,description)
values (50007,10003,'gggggggg');