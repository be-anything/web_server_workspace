create table student(
    id number,
    name varchar2(100),
    constraints pk_student_id primary key(id)
);
create sequence seq_student_id;

select * from student;
--drop table student;

insert into student values(seq_student_id.nextval, '怨좏삙吏�');
insert into student values(seq_student_id.nextval, '源�紐낆�');
insert into student values(seq_student_id.nextval, '源��젙�슚');
insert into student values(seq_student_id.nextval, '�꽦誘쇱�');
insert into student values(seq_student_id.nextval, '�삤�듅�쁽');
insert into student values(seq_student_id.nextval, '�삤�슦吏�');
insert into student values(seq_student_id.nextval, '�쑀�젙�샇');
insert into student values(seq_student_id.nextval, '�씠誘쇱젙');
insert into student values(seq_student_id.nextval, '�씠�옱以�');
insert into student values(seq_student_id.nextval, '�엫珥덉엫');
insert into student values(seq_student_id.nextval, '�젙�듅踰�');
insert into student values(seq_student_id.nextval, '�젙�슜以�');
insert into student values(seq_student_id.nextval, '�젙吏꾩슦');
insert into student values(seq_student_id.nextval, '泥쒕Т吏�');
insert into student values(seq_student_id.nextval, '�븳蹂닿꼍');
insert into student values(seq_student_id.nextval, '�븳�듅�썕');
insert into student values(seq_student_id.nextval, '�븳以��씗');

commit;

-- celeb�뀒�씠釉�
create table celeb (
    id number,
    name varchar2(100) not null,
    profile varchar2(200) default 'default.png',
    type varchar2(50),
    constraints pk_celeb primary key(id),
    constraints ck_celeb check(type in ('ACTOR', 'SINGER', 'MODEL', 'ENTERTAINER', 'COMEDIAN'))
);

create sequence seq_celeb_id;

commit;


















