
insert into role(code,name) values('ADMIN','Quản trị');
insert into role(code,name) values('Staff','Nhân viên');

insert into user(username,password,fullname,birthday)
values('admin','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','Khang','1');
insert into user(username,password,fullname,birthday)
values('huong','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','Huy','2');
insert into user(username,password,fullname,birthday)
values('huy','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','Hướng','3');

INSERT INTO user_role(user_id,role_id) VALUES (1,1);
INSERT INTO user_role(user_id,role_id) VALUES (2,2);
INSERT INTO user_role(user_id,role_id) VALUES (3,2);