CREATE SEQUENCE diet_allowed_food_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE diet_banned_food_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE diet_benefit_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE diet_menu_meal_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE diet_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE meal_item_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE recipe_ingredient_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE recipe_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE tag_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE workout_muscle_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE workout_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE diet
(
    id          NUMBER(38, 0) NOT NULL,
    image_url   VARCHAR2(255),
    diet_name   VARCHAR2(255),
    description VARCHAR2(255),
    CONSTRAINT pk_diet PRIMARY KEY (id)
);

CREATE TABLE diet_allowed_food
(
    id          NUMBER(38, 0) NOT NULL,
    description VARCHAR2(255),
    diet_id     NUMBER(38, 0),
    CONSTRAINT pk_diet_allowed_food PRIMARY KEY (id)
);

CREATE TABLE diet_banned_food
(
    id          NUMBER(38, 0) NOT NULL,
    description VARCHAR2(255),
    diet_id     NUMBER(38, 0),
    CONSTRAINT pk_diet_banned_food PRIMARY KEY (id)
);

CREATE TABLE diet_benefit
(
    id          NUMBER(38, 0) NOT NULL,
    description VARCHAR2(255),
    diet_id     NUMBER(38, 0),
    CONSTRAINT pk_diet_benefit PRIMARY KEY (id)
);

CREATE TABLE diet_menu_meal
(
    id        NUMBER(38, 0) NOT NULL,
    meal_name VARCHAR2(255),
    diet_id   NUMBER(38, 0),
    CONSTRAINT pk_diet_menu_meal PRIMARY KEY (id)
);

CREATE TABLE meal_item
(
    id                NUMBER(38, 0) NOT NULL,
    description       VARCHAR2(255),
    diet_menu_meal_id NUMBER(38, 0),
    CONSTRAINT pk_meal_item PRIMARY KEY (id)
);

CREATE TABLE recipe
(
    id                       NUMBER(38, 0) NOT NULL,
    image_url                VARCHAR2(255),
    recipe_name              VARCHAR2(255),
    portion_size_grams       INTEGER NOT NULL,
    total_calories           INTEGER NOT NULL,
    protein_amount_grams     INTEGER NOT NULL,
    fat_amount_grams         INTEGER NOT NULL,
    carbs_amount_grams       INTEGER NOT NULL,
    preparation_instructions CLOB,
    CONSTRAINT pk_recipe PRIMARY KEY (id)
);

CREATE TABLE recipe_ingredient
(
    id              NUMBER(38, 0) NOT NULL,
    amount          VARCHAR2(255),
    ingredient_name VARCHAR2(255),
    recipe_id       NUMBER(38, 0),
    CONSTRAINT pk_recipe_ingredient PRIMARY KEY (id)
);

CREATE TABLE recipe_tag
(
    recipe_id NUMBER(38, 0) NOT NULL,
    tag_id    NUMBER(38, 0) NOT NULL
);

CREATE TABLE tag
(
    id   NUMBER(38, 0) NOT NULL,
    name VARCHAR2(255),
    CONSTRAINT pk_tag PRIMARY KEY (id)
);

CREATE TABLE workout
(
    id                 NUMBER(38, 0) NOT NULL,
    image_url          VARCHAR2(255),
    workout_name       VARCHAR2(255),
    video_url          VARCHAR2(255),
    upper_body_benefit NUMBER(1),
    lower_body_benefit NUMBER(1),
    calories           INTEGER NOT NULL,
    repetitions        INTEGER NOT NULL,
    CONSTRAINT pk_workout PRIMARY KEY (id)
);

CREATE TABLE workout_muscle
(
    id         NUMBER(38, 0) NOT NULL,
    name       VARCHAR2(255),
    workout_id NUMBER(38, 0),
    CONSTRAINT pk_workout_muscle PRIMARY KEY (id)
);

ALTER TABLE diet_allowed_food
    ADD CONSTRAINT FK_DIET_ALLOWED_FOOD_ON_DIET FOREIGN KEY (diet_id) REFERENCES diet (id);

ALTER TABLE diet_banned_food
    ADD CONSTRAINT FK_DIET_BANNED_FOOD_ON_DIET FOREIGN KEY (diet_id) REFERENCES diet (id);

ALTER TABLE diet_benefit
    ADD CONSTRAINT FK_DIET_BENEFIT_ON_DIET FOREIGN KEY (diet_id) REFERENCES diet (id);

ALTER TABLE diet_menu_meal
    ADD CONSTRAINT FK_DIET_MENU_MEAL_ON_DIET FOREIGN KEY (diet_id) REFERENCES diet (id);

ALTER TABLE meal_item
    ADD CONSTRAINT FK_MEAL_ITEM_ON_DIET_MENU_MEAL FOREIGN KEY (diet_menu_meal_id) REFERENCES diet_menu_meal (id);

ALTER TABLE recipe_ingredient
    ADD CONSTRAINT FK_RECIPE_INGREDIENT_ON_RECIPE FOREIGN KEY (recipe_id) REFERENCES recipe (id);

ALTER TABLE workout_muscle
    ADD CONSTRAINT FK_WORKOUT_MUSCLE_ON_WORKOUT FOREIGN KEY (workout_id) REFERENCES workout (id);

ALTER TABLE recipe_tag
    ADD CONSTRAINT fk_rectag_on_recipe FOREIGN KEY (recipe_id) REFERENCES recipe (id);

ALTER TABLE recipe_tag
    ADD CONSTRAINT fk_rectag_on_tag FOREIGN KEY (tag_id) REFERENCES tag (id);