INSERT INTO TBL_RECIPES (recipeId, name,userId, equipments, ingredients, description, instruction, time, date, type, status)
    VALUES (1, 'Kent', 1, 'none', 'none', 'duma', '....', '10.00', '2019-03-04', 'breakfast', 1)


INSERT INTO TBL_USERS (userId, firstname, lastname, username, password) VALUES (1, 'YP', 'Yoo', 'yyp', '1023')

CREATE TABLE user
(
    id        BIGINT       NOT NULL,
    firstname VARCHAR(255) NULL,
    lastname  VARCHAR(255) NULL,
    username  VARCHAR(255) NULL,
    password  VARCHAR(255) NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);