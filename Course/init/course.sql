USE course;

DROP TABLE IF EXISTS role;
CREATE TABLE role (
  id INT(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  role VARCHAR(50) NOT NULL COMMENT 'Роль',
  PRIMARY KEY (id),
  UNIQUE INDEX UK_role (role)
)
ENGINE = INNODB
AUTO_INCREMENT = 3
AVG_ROW_LENGTH = 8192
CHARACTER SET utf8
COLLATE utf8_general_ci
COMMENT = 'Роль';

DROP TABLE IF EXISTS user;
CREATE TABLE user (
  id INT(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  username VARCHAR(255) NOT NULL COMMENT 'Имя пользователя',
  password VARCHAR(255) NOT NULL COMMENT 'Пароль',
  expire DATE NOT NULL COMMENT 'Срок доступа пользователя',
  PRIMARY KEY (id)
)
ENGINE = INNODB
AUTO_INCREMENT = 19
AVG_ROW_LENGTH = 1092
CHARACTER SET utf8
COLLATE utf8_general_ci
COMMENT = 'Пользователь';

DROP TABLE IF EXISTS student;
CREATE TABLE student (
  id INT(11) NOT NULL COMMENT 'id, id_user',
  surname VARCHAR(255) NOT NULL COMMENT 'Фамилия',
  name VARCHAR(50) NOT NULL COMMENT 'Имя',
  patronymic VARCHAR(50) DEFAULT NULL COMMENT 'Отчество',
  bdate DATE NOT NULL COMMENT 'Дата рождения',
  student_number INT(11) NOT NULL COMMENT '№ зачетки',
  group_number INT(11) NOT NULL COMMENT '№ группы',
  PRIMARY KEY (id),
  CONSTRAINT FK_student_user_id FOREIGN KEY (id)
    REFERENCES user(id) ON DELETE RESTRICT ON UPDATE RESTRICT
)
ENGINE = INNODB
AVG_ROW_LENGTH = 1820
CHARACTER SET utf8
COLLATE utf8_general_ci
COMMENT = 'Студент';

DROP TABLE IF EXISTS teacher;
CREATE TABLE teacher (
  id INT(11) NOT NULL COMMENT 'id, id_user',
  surname VARCHAR(255) DEFAULT NULL COMMENT 'Фамилия',
  name VARCHAR(50) DEFAULT NULL COMMENT 'Имя',
  patronymic VARCHAR(50) NOT NULL COMMENT 'Отчество',
  bdate DATE NOT NULL COMMENT 'Дата рождения',
  post VARCHAR(255) NOT NULL COMMENT 'Должность',
  PRIMARY KEY (id),
  CONSTRAINT FK_teacher_user_id FOREIGN KEY (id)
    REFERENCES user(id) ON DELETE RESTRICT ON UPDATE RESTRICT
)
ENGINE = INNODB
AVG_ROW_LENGTH = 2730
CHARACTER SET utf8
COLLATE utf8_general_ci
COMMENT = 'Преподаватель';

DROP TABLE IF EXISTS user_role;
CREATE TABLE user_role (
  id_user INT(11) NOT NULL,
  id_role INT(11) NOT NULL,
  PRIMARY KEY (id_user, id_role),
  CONSTRAINT FK_role_id FOREIGN KEY (id_role)
    REFERENCES role(id) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT FK_user_id FOREIGN KEY (id_user)
    REFERENCES user(id) ON DELETE RESTRICT ON UPDATE RESTRICT
)
ENGINE = INNODB
AVG_ROW_LENGTH = 1092
CHARACTER SET utf8
COLLATE utf8_general_ci
COMMENT = 'user_role relation';

DROP TABLE IF EXISTS course;
CREATE TABLE course (
  id INT(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  name VARCHAR(50) NOT NULL COMMENT 'Название курса',
  start_date DATE NOT NULL COMMENT 'Начало',
  end_date DATE NOT NULL COMMENT 'Окончание',
  id_teacher INT(11) DEFAULT NULL COMMENT 'Id преподавателя',
  PRIMARY KEY (id),
  UNIQUE INDEX UK_course_id_teacher (id_teacher),
  CONSTRAINT FK_course_teacher_id FOREIGN KEY (id_teacher)
    REFERENCES teacher(id) ON DELETE RESTRICT ON UPDATE RESTRICT
)
ENGINE = INNODB
AUTO_INCREMENT = 11
AVG_ROW_LENGTH = 2730
CHARACTER SET utf8
COLLATE utf8_general_ci
COMMENT = 'Курс';

DROP TABLE IF EXISTS mark;
CREATE TABLE mark (
  id_course INT(11) NOT NULL COMMENT 'id курса',
  id_student INT(11) NOT NULL DEFAULT 0 COMMENT 'id студента',
  mark_value INT(11) DEFAULT NULL COMMENT 'оценка',
  review VARCHAR(255) DEFAULT NULL COMMENT 'отзыв',
  PRIMARY KEY (id_course, id_student),
  CONSTRAINT FK_rel_course_student_course_id FOREIGN KEY (id_course)
    REFERENCES course(id) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT FK_rel_course_student_student_id FOREIGN KEY (id_student)
    REFERENCES student(id) ON DELETE RESTRICT ON UPDATE RESTRICT
)
ENGINE = INNODB
AVG_ROW_LENGTH = 2340
CHARACTER SET utf8
COLLATE utf8_general_ci
COMMENT = 'Связь курсов со студентами, оценка и отзыв студента';

INSERT INTO role VALUES
(1, 'Преподаватель'),
(2, 'Студент');

INSERT INTO user VALUES
(1, 'aliev', '6b86b273ff34fce19d6b804eff5a3f5747ada4eaa22f1d49c01e52ddb7875b4b', '2022-08-26'),
(2, 'lunev', '6b86b273ff34fce19d6b804eff5a3f5747ada4eaa22f1d49c01e52ddb7875b4b', '2030-08-30'),
(3, 'arbuzov', '6b86b273ff34fce19d6b804eff5a3f5747ada4eaa22f1d49c01e52ddb7875b4b', '2022-01-01'),
(4, 'remnev', '6b86b273ff34fce19d6b804eff5a3f5747ada4eaa22f1d49c01e52ddb7875b4b', '2022-06-15'),
(5, 'kutuzov', '6b86b273ff34fce19d6b804eff5a3f5747ada4eaa22f1d49c01e52ddb7875b4b', '2021-12-02'),
(6, 'lebedev', '6b86b273ff34fce19d6b804eff5a3f5747ada4eaa22f1d49c01e52ddb7875b4b', '2022-07-14'),
(7, 'abramov', '6b86b273ff34fce19d6b804eff5a3f5747ada4eaa22f1d49c01e52ddb7875b4b', '2022-08-27'),
(8, 'sidorov', '6b86b273ff34fce19d6b804eff5a3f5747ada4eaa22f1d49c01e52ddb7875b4b', '2022-08-27'),
(9, 'petrov', '6b86b273ff34fce19d6b804eff5a3f5747ada4eaa22f1d49c01e52ddb7875b4b', '2022-08-27'),
(10, 'naumov', '6b86b273ff34fce19d6b804eff5a3f5747ada4eaa22f1d49c01e52ddb7875b4b', '2022-08-27'),
(11, 'kirov', '6b86b273ff34fce19d6b804eff5a3f5747ada4eaa22f1d49c01e52ddb7875b4b', '2022-08-27'),
(12, 'lisov', '6b86b273ff34fce19d6b804eff5a3f5747ada4eaa22f1d49c01e52ddb7875b4b', '2022-08-27'),
(13, 'kleev', '6b86b273ff34fce19d6b804eff5a3f5747ada4eaa22f1d49c01e52ddb7875b4b', '2022-08-27'),
(14, 'antonov', '6b86b273ff34fce19d6b804eff5a3f5747ada4eaa22f1d49c01e52ddb7875b4b', '2022-08-27'),
(15, 'lapov', '6b86b273ff34fce19d6b804eff5a3f5747ada4eaa22f1d49c01e52ddb7875b4b', '2022-08-27'),
(16, 'kitov', '6b86b273ff34fce19d6b804eff5a3f5747ada4eaa22f1d49c01e52ddb7875b4b', '2022-09-25'),
(17, 'rukov', '6b86b273ff34fce19d6b804eff5a3f5747ada4eaa22f1d49c01e52ddb7875b4b', '2022-09-24'),
(18, 'anikeev', '6b86b273ff34fce19d6b804eff5a3f5747ada4eaa22f1d49c01e52ddb7875b4b', '2022-02-10');

INSERT INTO student VALUES
(7, 'Абрамов', 'Олег', 'Юрьевич', '2001-01-02', 202100001, 3502),
(8, 'Сидоров', 'Артем', 'Олегович', '2000-08-15', 202100002, 3401),
(9, 'Петров', 'Антон', 'Сергеевич', '2002-12-12', 202100003, 4501),
(10, 'Наумов', 'Сергей', 'Андреевич', '1999-07-14', 202100004, 4501),
(11, 'Киров', 'Дмитрий', 'Николаевич', '1999-06-06', 202100005, 3501),
(12, 'Лисов', 'Игорь', 'Эдуардович', '2000-08-27', 202100006, 3501),
(13, 'Клеев', 'Эдуард', 'Витальевич', '1997-05-03', 202100007, 3401),
(14, 'Антонов', 'Виктор', 'Петрович', '2001-04-04', 202100008, 3403),
(15, 'Лапов', 'Виталий', 'Леонидович', '2003-07-29', 202100009, 3502);

INSERT INTO teacher VALUES
(1, 'Алиев', 'Руслан', 'Георгиевич', '1975-03-15', 'Старший преподаватель'),
(2, 'Лунев', 'Федор', 'Матвеевич', '1979-01-17', 'Доцент'),
(3, 'Арбузов', 'Илья', 'Викторович', '1983-05-23', 'Преподаватель'),
(4, 'Ремнев', 'Семен', 'Александрович', '1985-12-14', 'Старший преподаватель'),
(5, 'Кутузов', 'Дмитрий', 'Алексеевич', '1978-08-23', 'Доцент'),
(6, 'Лебедев', 'Антон', 'Сергеевич', '1971-09-03', 'Профессор'),
(16, 'Китов', 'Роман', 'Александрович', '1976-12-04', 'Профессор'),
(17, 'Руков', 'Игорь', 'Сергеевич', '1978-01-15', 'Доцент'),
(18, 'Аникеев', 'Алексей', 'Петрович', '1971-02-20', 'Преподаватель');

INSERT INTO user_role VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 1),
(6, 1),
(16, 1),
(17, 1),
(18, 1),
(7, 2),
(8, 2),
(9, 2),
(10, 2),
(11, 2),
(12, 2),
(13, 2),
(14, 2),
(15, 2);

INSERT INTO course VALUES
(1, 'Алгебра', '2021-08-01', '2021-09-07', 2),
(2, 'Физика', '2021-09-20', '2021-10-31', 3),
(3, 'Геометрия', '2021-08-11', '2021-09-13', 1),
(4, 'История Беларуси', '2021-09-20', '2021-12-31', 4),
(5, 'Философия', '2021-09-01', '2021-09-15', 5),
(6, 'Астрономия', '2021-09-20', '2021-09-26', 6),
(8, 'Химия', '2021-09-25', '2021-10-28', 16),
(9, 'Английский язык', '2021-09-29', '2021-12-31', 17),
(10, 'География', '2021-09-20', '2021-12-31', 18);

INSERT INTO mark VALUES
(1, 9, 6, NULL),
(1, 14, NULL, NULL),
(2, 8, NULL, NULL),
(2, 10, NULL, NULL),
(3, 7, 5, 'отзыв для Абрамова'),
(3, 8, NULL, NULL),
(3, 11, NULL, NULL),
(4, 9, NULL, NULL),
(4, 11, NULL, NULL),
(4, 15, NULL, NULL),
(5, 7, NULL, NULL),
(5, 11, NULL, NULL),
(6, 13, NULL, NULL),
(8, 8, NULL, NULL),
(8, 9, NULL, NULL),
(9, 7, NULL, NULL),
(9, 12, NULL, NULL);
