  
--  create roles
  create table role (
  roleId number(7),
  role_desc varchar2(15),
    primary key (roleId)
    );
  
  
  
--  create employee
  create table employee ( 
  employeeId number(7),
  employeeName varchar2(25), 
  roleId number(7),
    primary key (employeeId),
    constraint FK_Role foreign key (roleId) references role(roleId) );
  
  
--  create master table skill;
  create table skill (
  skillid number(7),
  skill_desc varchar2(20),
  primary key (skillid)
  );

--  create trainer_skill
  create table trainer_skill (
  employeeId number(7),
  skillid number(20),
  constraint FK_skill_trainer_skill foreign key (skillid) references skill(skillid)
  );
  
  
--  create center
  create table center (
  centerId number(7),
  centerName varchar2(20), primary key (centerId));
  
--  create address
  create table address(
  id number(7),
  line1 varchar2(25), 
  line2 varchar2(25) ,
  state varchar2(20),
  pincode number(6),
    constraint FK_on_centerId foreign key (id) references center(centerId)
    );
  
  
--  create course
  create table course (
  courseId number(7),
  courseName varchar2(20),
  courseDesc varchar2(25),
  course_charges number(4), 
    primary key(courseId)
    );
  
--  create training program
  create table program  (
    trainingId number(7),
    courseId number(7),
    employeeId number(7),
    centerId number(7),
    startDate DATE, 
      primary key (trainingId), 
      constraint FK_courseId_training_program foreign key (courseId) references course(courseId),
      constraint FK_CenterID foreign key  (centerId) references center(centerId),
      constraint FK_employeeID foreign key (employeeId) references employee(employeeId)
      );
  
--  create student
  create table students (
  studentId number(7),
  studentName varchar2(20),
  trainingId number(7), 
    primary key (studentId,trainingId),
    constraint FK_Student_trProgram foreign key (trainingId) references program(trainingId)
  );
  
--  create feedback
  create table feedback (studentId number(7),questionId number(7),rating number(2),programId number(7));
  
--  create  question
  create table questions (questionId number(7),question_desc varchar2(30),primary key (questionId));
  
  
  
  
--  Inserting roles
insert into role (roleId,role_desc) values (seq_role.nextval,'admin');
insert into role (roleId,role_desc) values (seq_role.nextval,'coordinator');
insert into role (roleId,role_desc) values (seq_role.nextval,'trainer');
select * from role;

--insert employee
insert into employee (employeeId,employeeName,roleId) values
  (seq_employee.nextval,'Ajay P',10002);
  insert into employee (employeeId,employeeName,roleId) values
  (seq_employee.nextval,'Tanmay Acharya',10002);
  insert into employee (employeeId,employeeName,roleId) values
  (seq_employee.nextval,'Nitin Joshi',10000);
  insert into employee (employeeId,employeeName,roleId) values
  (seq_employee.nextval,'Sujay',10000);
  insert into employee (employeeId,employeeName,roleId) values
  (seq_employee.nextval,'Rahul',10001);
  
--  insert skills
insert into skill (skillid,skill_desc) values (seq_skill.nextval,'JAVA');  
insert into skill (skillid,skill_desc) values (seq_skill.nextval,'C');  
insert into skill (skillid,skill_desc) values (seq_skill.nextval,'PYTHON');  
select * from employee;
--  inserting skill;
select * from trainer_skill;
  insert into trainer_skill (id,employeeId, skillid) values
  (seq_tr_skill.nextval,10001,10000);
    insert into trainer_skill (id,employeeId, skillid) values
  (seq_tr_skill.nextval,10001,10001);
    insert into trainer_skill (id,employeeId, skillid) values
  (seq_tr_skill.nextval,10002,10001);
      insert into trainer_skill (id,employeeId, skillid) values
  (seq_tr_skill.nextval,10002,10002);
  
--  inserting centers statically
  insert into center (centerId,centerName) values 
    (seq_center.nextval,'Capgemini SEZ');
--  insert address
    insert into address (id,line1,line2,state,pincode) values
    (10000,'B6- block 5','Aeroli Navi Mumbai','Maharashatra',400050);
    
--  insert course
  insert into course (courseId,courseName,courseDesc,course_charges) values 
    (seq_course.nextval,'J2EE','JAva Programming',1365);
  insert into course (courseId,courseName,courseDesc,course_charges) values 
    (seq_course.nextval,'BigData','Hadoop,Hive,Pig',5001);
    
--    insert programTO_DATE('2019/08/09 10:02:44', 'yyyy/mm/dd hh24:mi:ss')
    insert into program ( trainingId,courseId,employeeId,centerId,startDate ) values
    (seq_program.nextval,10000,10001,10000, TO_DATE('2019/08/09', 'yyyy/mm/dd'));
    
--    inserting  feedback
    
--    inserting question
--    question id =QU_1001

--insert into program ( trainingId,courseId,employeeId,centerId,startDate) values ('TP_1002','CO_1001','EM_1001','CN_1001',TO_DATE('2019/08/10', 'yyyy/mm/dd'));



  
--Sequence Generation
-- 
create SEQUENCE seq_course START WITH 10000 increment by 1 NOCACHE NOCYcLE;
create SEQUENCE seq_student START WITH 10000 increment by 1 NOCACHE NOCYcLE;
create SEQUENCE seq_program START WITH 10000 increment by 1 NOCACHE NOCYcLE;
create SEQUENCE seq_employee START WITH 10000 increment by 1 NOCACHE NOCYcLE;
create SEQUENCE seq_center START WITH 10000 increment by 1 NOCACHE NOCYcLE;
create SEQUENCE seq_address START WITH 10000 increment by 1 NOCACHE NOCYcLE;
create SEQUENCE seq_feedback START WITH 10000 increment by 1 NOCACHE NOCYcLE;
create SEQUENCE seq_skill START WITH 10000 increment by 1 NOCACHE NOCYcLE;
create SEQUENCE seq_role START WITH 10000 increment by 1 NOCACHE NOCYcLE;
create SEQUENCE seq_question START WITH 10000 increment by 1 NOCACHE NOCYcLE;
create SEQUENCE seq_tr_skill START WITH 10000 increment by 1 NOCACHE NOCYcLE;

--drop sequence seq_course;
--drop sequence seq_student;
--drop sequence seq_program;
--drop sequence seq_employee;
--drop sequence seq_center;
--drop sequence seq_address;
--drop sequence seq_feedback;
--drop sequence seq_skill;
--drop sequence seq_role;
--drop sequence seq_question;
alter table trainer_skill add (id number(7));



alter table center add (addressid number(7));
alter table address rename column id to addressid;
alter table address add primary key (addressid);

ALTER TABLE center
ADD FOREIGN KEY (addressid) 
REFERENCES address(addressid);


update center set addressid=10000 where centerid=10000;


