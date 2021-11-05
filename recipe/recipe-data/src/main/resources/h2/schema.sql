DROP TABLE if EXISTS TBL_USERS, TBL_RECIPES, TBL_PLANMEALS, TBL_FAVORITES;

CREATE TABLE TBL_USERS (
                           userId LONG AUTO_INCREMENT PRIMARY KEY,
                           firstname VARCHAR(250) NOT NULL,
                           lastname VARCHAR(250) NOT NULL,
                           username VARCHAR(250) NOT NULL,
                           password VARCHAR(250) NOT NULL
);

CREATE TABLE TBL_RECIPES (
                             recipeId LONG AUTO_INCREMENT PRIMARY KEY,
                             name VARCHAR(250) NOT NULL,
                             userId LONG, CONSTRAINT fk_userId_recipe FOREIGN KEY(userId) REFERENCES TBL_USERS(userId),
                             equipments VARCHAR(250) NOT NULL,
                             ingredients VARCHAR(250) NOT NULL,
                             description VARCHAR(250) NOT NULL,
                             instruction VARCHAR(250) NOT NULL,
                             time VARCHAR(250) NOT NULL,
                             date DATE NOT NULL,
                             type VARCHAR(250) NOT NULL,
                             status BIT NOT NULL
);

CREATE TABLE TBL_PLANMEALS (
                               planmealId LONG AUTO_INCREMENT PRIMARY KEY,
                               date DATE NOT NULL,
                               userId LONG, CONSTRAINT fk_userId_planmeal FOREIGN KEY(userId) REFERENCES TBL_USERS(userId),
                               recipeId LONG, CONSTRAINT fk_recipeId_planmeal FOREIGN KEY(recipeId) REFERENCES TBL_RECIPES(recipeId)
);

CREATE TABLE TBL_FAVORITES (
                               favoriteId LONG AUTO_INCREMENT PRIMARY KEY,
                               userId LONG, CONSTRAINT fk_userId_favorite FOREIGN KEY(userId) REFERENCES TBL_USERS(userId),
                               recipeId LONG, CONSTRAINT fk_recipeId_favorite FOREIGN KEY(recipeId) REFERENCES TBL_RECIPES(recipeId)
)