insert into user_details(id,birth_date,name)
values(1001,current_date(),'sanjay');

insert into user_details(id,birth_date,name)
values(1002,current_date(),'kumar');

insert into user_details(id,birth_date,name)
values(1003,current_date(),'janani');

insert into post(id,description,user_id)
values(2001,'Learn aws today',1001);

insert into post(id,description,user_id)
values(2002,'Learn docker today',1001);

insert into post(id,description,user_id)
values(2003,'everything you need to know about computers',1002);

insert into post(id,description,user_id)
values(2004,'The art of beauty',1003);
