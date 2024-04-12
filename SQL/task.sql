/*
- Создать таблицы, соответствующие иерархии из вашей диаграммы классов.
- Заполнить таблицы данными о животных, их командах и датами рождения.
*/

CREATE DATABASE humanFriends;

-- SHOW DATABASES;
/*
+--------------------+
| Database           |
+--------------------+
| humanFriends       |
| information_schema |
| mysql              |
| performance_schema |
| sys                |
+--------------------+

5 rows in set (0,00 sec) */

-- USE humanFriends;

CREATE TABLE pets 
(
    id SERIAL PRIMARY KEY, 
    name VARCHAR(20), 
    type VARCHAR(10), 
    birthDate DATE, 
    commands VARCHAR(40)
);

CREATE TABLE packAnimals 
(
    id SERIAL PRIMARY KEY, 
    name VARCHAR(20), 
    type VARCHAR(10), 
    birthDay DATE, 
    commands VARCHAR(40)
);

-- SHOW TABLES;
/*
+------------------------+
| Tables_in_humanFriends |
+------------------------+
| packAnimals            |
| pets                   |
+------------------------+

2 rows in set (0,00 sec)*/

INSERT INTO pets (type)
VALUES
('Dog'),
('Cat'),
('Hamster');

-- SELECT * FROM pets;
/*
+----+---------+
| id | type    |
+----+---------+
|  1 | Dog     |
|  2 | Cat     |
|  3 | Hamster |
+----+---------+
3 rows in set (0,00 sec)
*/

INSERT INTO packAnimals (type)
VALUES
('Horse'),
('Camel'),
('Donkey');

-- SELECT * FROM packAnimals;
/*
+----+--------+
| id | type   |
+----+--------+
|  1 | Horse  |
|  2 | Camel  |
|  3 | Donkey |
+----+--------+
3 rows in set (0,00 sec)
*/

CREATE TABLE dog
(
    id SERIAL PRIMARY KEY, 
    name VARCHAR(20), 
    typeID INT REFERENCES pets(id) ON DELETE CASCADE,  
    birthDate DATE, 
    commands VARCHAR(40)
);

INSERT INTO dog(name, typeID, birthDate, commands)
VALUES
('Fido', 1, '2020-01-01', 'Sit, Stay, Fetch'),
('Buddy', 1, '2018-12-10', 'Sit, Paw, Bark'),
('Bella', 1, '2019-11-11', 'Sit, Stay, Roll');

/*
mysql> SELECT * FROM dog;
+----+-------+--------+------------+------------------+
| id | name  | typeID | birthDate  | commands         |
+----+-------+--------+------------+------------------+
|  1 | Fido  |      1 | 2020-01-01 | Sit, Stay, Fetch |
|  2 | Buddy |      1 | 2018-12-10 | Sit, Paw, Bark   |
|  3 | Bella |      1 | 2019-11-11 | Sit, Stay, Roll  |
+----+-------+--------+------------+------------------+
3 rows in set (0,00 sec)
*/

CREATE TABLE cat 
(
    id SERIAL PRIMARY KEY, 
    name VARCHAR(20), 
    typeID INT REFERENCES pets(id) ON DELETE CASCADE, 
    birthDate DATE, commands VARCHAR(40)
);

INSERT INTO cat (name, typeID, birthDate, commands)
VALUES
('Whiskers', 2, '2019-05-15', 'Sit, Pounce'),
('Smudge', 2, '2020-02-20', 'Sit, Pounce, Scratch'),
('Oliver', 2, '2020-06-30', 'Meow, Scratch, Jump');

/*
mysql> SELECT * FROM cat;
+---+----------+--------+------------+----------------------+
| id | name     | typeID | birthDate  | commands             |
+----+----------+--------+------------+----------------------+
|  1 | Whiskers |      2 | 2019-05-15 | Sit, Pounce          |
|  2 | Smudge   |      2 | 2020-02-20 | Sit, Pounce, Scratch |
|  3 | Oliver   |      2 | 2020-06-30 | Meow, Scratch, Jump  |
+----+----------+--------+------------+----------------------+
3 rows in set (0,00 sec)
*/

CREATE TABLE hamster 
(
    id SERIAL PRIMARY KEY, 
    name VARCHAR(20), 
    typeID INT REFERENCES pets(id) ON DELETE CASCADE, 
    birthDate DATE, 
    commands VARCHAR(40)
);

INSERT INTO hamster (name, typeID, birthDate, commands)
VALUES
('Hammy', 3, '2021-03-10', 'Roll, Hide'),
('Peanut', 3, '2021-08-01', 'Roll, Spin');

/*
mysql> SELECT * FROM hamster;
+----+--------+--------+------------+------------+
| id | name   | typeID | birthDate  | commands   |
+----+--------+--------+------------+------------+
|  1 | Hammy  |      3 | 2021-03-10 | Roll, Hide |
|  2 | Peanut |      3 | 2021-08-01 | Roll, Spin |
+----+--------+--------+------------+------------+
2 rows in set (0,00 sec)
mysql> SHOW TABLES;
+------------------------+
| Tables_in_humanFriends |
+------------------------+
| cat                    |
| dog                    |
| hamster                |
| packAnimals            |
| pets                   |
+------------------------+
5 rows in set (0,00 sec)
*/

CREATE TABLE horse 
(
    id SERIAL PRIMARY KEY, 
    name VARCHAR(20), 
    typeID INT REFERENCES packAnimals(id) ON DELETE CASCADE, 
    birthDate DATE, 
    commands VARCHAR(40)
);

INSERT INTO horse (name, typeID, birthDate, commands)
VALUES
('Thunder', 1, '2015-07-21', 'Trot, Canter, Gallop'),
('Storm', 1, '2014-05-05', 'Trot, Canter'),
('Blaze', 1, '2016-03-29', 'Trot, Jump, Gallop');

/*
mysql> SELECT * FROM horse;
+----+---------+--------+------------+----------------------+
| id | name    | typeID | birthDate  | commands             |
+----+---------+--------+------------+----------------------+
|  1 | Thunder |      1 | 2015-07-21 | Trot, Canter, Gallop |
|  2 | Storm   |      1 | 2014-05-05 | Trot, Canter         |
|  3 | Blaze   |      1 | 2016-03-29 | Trot, Jump, Gallop   |
+----+---------+--------+------------+----------------------+
3 rows in set (0,00 sec)
*/

CREATE TABLE camel 
(
    id SERIAL PRIMARY KEY, 
    name VARCHAR(20), 
    typeID INT REFERENCES packAnimals(id) ON DELETE CASCADE, 
    birthDate DATE, 
    commands VARCHAR(40)
);

INSERT INTO camel (name, typeID, birthDate, commands)
VALUES
('Sandy', 2, '2016-11-03', 'Walk, Carry Load'),
('Dune', 2, '2018-12-12', 'Walk, Sit'),
('Sahara', 2, '2015-08-14', 'Walk, Run');

/*
mysql> SELECT * FROM camel;
+----+--------+--------+------------+------------------+
| id | name   | typeID | birthDate  | commands         |
+----+--------+--------+------------+------------------
|  1 | Sandy  |      2 | 2016-11-03 | Walk, Carry Load |
|  2 | Dune   |      2 | 2018-12-12 | Walk, Sit        |
|  3 | Sahara |      2 | 2015-08-14 | Walk, Run        |
+----+--------+--------+------------+------------------+
3 rows in set (0,00 sec)
*/

CREATE TABLE donkey 
(
    id SERIAL PRIMARY KEY, 
    name VARCHAR(20), 
    typeID INt REFERENCES packAnimals(id) ON DELETE CASCADE, 
    birthDate DATE, 
    commands VARCHAR(40)
);

INSERT INTO donkey (name, typeID, birthDate, commands)
VALUES
('Eeyore', 3, '2017-09-18', 'Walk, Carry Load, Bray'),
('Burro', 3, '2019-01-23', 'Walk, Bray, Kick');

/*
SELECT * FROM donkey;
+----+--------+--------+------------+------------------------+
| id | name   | typeID | birthDate  | commands               |
+----+--------+--------+------------+------------------------+
|  1 | Eeyore |      3 | 2017-09-18 | Walk, Carry Load, Bray |
|  2 | Burro  |      3 | 2019-01-23 | Walk, Bray, Kick       |
+----+--------+--------+------------+------------------------+
2 rows in set (0,00 sec)

mysql> SHOW TABLES;
+------------------------+
| Tables_in_humanFriends |
+------------------------+
| camel                  |
| cat                    |
| dog                    |
| donkey                 |
| hamster                |
| horse                  |
| packAnimals            
| pets                   |
+------------------------+
8 rows in set (0,00 sec)
*/

----------------------------------------------------------------------------------
/*
- Удалить записи о верблюдах и объединить таблицы лошадей и ослов.
*/

/*
mysql> SELECT * FROM packAnimals;
+----+--------+
| id | type   |
+----+--------+
|  1 | Horse  |
|  2 | Camel  |
|  3 | Donkey |
+----+--------+
3 rows in set (0,00 sec)
*/

DELETE FROM packAnimals
WHERE LOWER(type) = 'camel';

/*
mysql> SELECT * FROM packAnimals;
+----+--------+
| id | type   |
+----+--------+
|  1 | Horse  |
|  3 | Donkey |
+----+--------+
2 rows in set (0,00 sec)
*/

SELECT * FROM horse
UNION
SELECT * FROM donkey;

/*
+----+---------+--------+------------+------------------------+
| id | name    | typeID | birthDate  | commands               |
+----+---------+--------+------------+------------------------+
|  1 | Thunder |      1 | 2015-07-21 | Trot, Canter, Gallop   |
|  2 | Storm   |      1 | 2014-05-05 | Trot, Canter           |
|  3 | Blaze   |      1 | 2016-03-29 | Trot, Jump, Gallop     |
|  1 | Eeyore  |      3 | 2017-09-18 | Walk, Carry Load, Bray |
|  2 | Burro   |      3 | 2019-01-23 | Walk, Bray, Kick       |
+----+---------+--------+------------+------------------------+
5 rows in set (0,00 sec)
*/

----------------------------------------------------------------------------------
/*
- Создать новую таблицу для животных в возрасте от 1 до 3 лет 
    и вычислить их возраст с точностью до месяца.
*/

SELECT 
    name, 
    typeID, 
    CONCAT(
        FLOOR(
            DATEDIFF(CURRENT_DATE(), birthDate)/365.25), 
        ' years ', 
        FLOOR(
            (DATEDIFF(CURRENT_DATE(), birthDate) % 365.25) / 30.4375), 
        ' months') age, 
    commands 
FROM dog 
WHERE FLOOR(DATEDIFF(CURRENT_DATE(), birthDate)/365.25 BETWEEN 1 AND 3)

UNION

SELECT 
    name, 
    typeID, 
    CONCAT(
        FLOOR(
            DATEDIFF(CURRENT_DATE(), birthDate)/365.25), 
        ' years ', 
        FLOOR(
            (DATEDIFF(CURRENT_DATE(), birthDate) % 365.25) / 30.4375), 
        ' months') age, 
    commands 
FROM cat 
WHERE FLOOR(DATEDIFF(CURRENT_DATE(), birthDate)/365.25 BETWEEN 1 AND 3)

UNION

SELECT 
    name, 
    typeID, 
    CONCAT(
        FLOOR(
            DATEDIFF(CURRENT_DATE(), birthDate)/365.25), 
        ' years ', 
        FLOOR(
            (DATEDIFF(CURRENT_DATE(), birthDate) % 365.25) / 30.4375), 
        ' months') age, 
    commands 
    FROM hamster 
    WHERE FLOOR(DATEDIFF(CURRENT_DATE(), birthDate)/365.25 BETWEEN 1 AND 3);

/*
+--------+--------+------------------+------------+
| name   | typeID | age              | commands   |
+--------+--------+------------------+------------+
| Peanut |      3 | 2 years 8 months | Roll, Spin |
+--------+--------+------------------+------------+
1 row in set (0,00 sec)
*/

----------------------------------------------------------------------------------
/*
- Объединить все созданные таблицы в одну, 
    сохраняя информацию о принадлежности к исходным таблицам.
*/

SELECT * FROM dog
UNION
SELECT * FROM cat
UNION 
SELECT * FROM hamster;

/*
+----+----------+--------+------------+----------------------+
| id | name     | typeID | birthDate  | commands             |
+----+----------+--------+------------+----------------------+
|  1 | Fido     |      1 | 2020-01-01 | Sit, Stay, Fetch     |
|  2 | Buddy    |      1 | 2018-12-10 | Sit, Paw, Bark       |
|  3 | Bella    |      1 | 2019-11-11 | Sit, Stay, Roll      |
|  1 | Whiskers |      2 | 2019-05-15 | Sit, Pounce          |
|  2 | Smudge   |      2 | 2020-02-20 | Sit, Pounce, Scratch |
|  3 | Oliver   |      2 | 2020-06-30 | Meow, Scratch, Jump  |
|  1 | Hammy    |      3 | 2021-03-10 | Roll, Hide           |
|  2 | Peanut   |      3 | 2021-08-01 | Roll, Spin           |
+----+----------+--------+------------+----------------------+
8 rows in set (0,00 sec)
*/

SELECT * FROM horse
UNION
SELECT * FROM camel
UNION
SELECT * FROM donkey;

/*
+----+---------+--------+------------+------------------------+
| id | name    | typeID | birthDate  | commands               |
+----+---------+--------+------------+------------------------+
|  1 | Thunder |      1 | 2015-07-21 | Trot, Canter, Gallop   |
|  2 | Storm   |      1 | 2014-05-05 | Trot, Canter           |
|  3 | Blaze   |      1 | 2016-03-29 | Trot, Jump, Gallop     |
|  1 | Sandy   |      2 | 2016-11-03 | Walk, Carry Load       |
|  2 | Dune    |      2 | 2018-12-12 | Walk, Sit              |
|  3 | Sahara  |      2 | 2015-08-14 | Walk, Run              |
|  1 | Eeyore  |      3 | 2017-09-18 | Walk, Carry Load, Bray |
|  2 | Burro   |      3 | 2019-01-23 | Walk, Bray, Kick       |
+----+---------+--------+------------+------------------------+
8 rows in set (0,00 sec)
*/