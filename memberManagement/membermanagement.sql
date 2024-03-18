CREATE TABLE MEMBER(

MEMBER_NO CHAR(10) PRIMARY KEY,
MEMBER_ID VARCHAR2(30) NOT NULL,
MEMBER_PW VARCHAR2(30) NOT NULL,
MEMBER_NAME VARCHAR2(15) NOT NULL

);

CREATE TABLE GRADE(

GRADE_CODE CHAR(2) PRIMARY KEY,
GRADE_NAME VARCHAR2(20) NOT NULL

);

INSERT INTO GRADE (GRADE_CODE, GRADE_NAME) VALUES ('10', '일반회원');

ALTER TABLE MEMBER ADD GRADE_NAME VARCHAR2(20) NOT NULL;

SELECT * FROM MEMBER;

INSERT INTO MEMBER 
VALUES ('01', 'user01', 'pw01', '김샘플', '일반회원');
INSERT INTO MEMBER 
VALUES ('02', 'user02', 'pw02', '최샘플', '우수회원');
INSERT INTO MEMBER 
VALUES ('03', 'user03', 'pw03', '박샘플', '특별회원');

INSERT INTO GRADE
VALUES ('M1', '일반회원');
INSERT INTO GRADE g 
VALUES ('M2', '우수회원');
INSERT INTO GRADE g 
VALUES ('M3', '특별회원');

SELECT * FROM MEMBER;
SELECT * FROM GRADE;

SELECT MEMBER_NO, MEMBER_NAME, GRADE_NAME
FROM MEMBER
ORDER BY MEMBER_NO ;

COMMIT;

SELECT MEMBER_NO, MEMBER_NAME, GRADE_NAME
FROM MEMBER
ORDER BY MEMBER_NO ;

COMMIT;

SELECT MEMBER_NO, MEMBER_NAME, GRADE_NAME
FROM MEMBER
ORDER BY MEMBER_NO ;

INSERT INTO MEMBER(MEMBER_NO, MEMBER_NAME, GRADE_NAME)
VALUES(1, 2, 3);

ALTER TABLE MEMBER MODIFY (MEMBER_PW NULL); 
ALTER TABLE MEMBER MODIFY (MEMBER_ID NULL); 

ALTER TABLE MEMBER DROP COLUMN MEMBER_ID;
ALTER TABLE MEMBER DROP COLUMN MEMBER_PW;

DELETE FROM "MEMBER" 
WHERE MEMBER_NO = '01';

COMMIT;
ROLLBACK;