CREATE SEQUENCE diet_allowed_food_seq START WITH 1 INCREMENT BY 1
    GO

CREATE SEQUENCE diet_banned_food_seq START WITH 1 INCREMENT BY 1
    GO

CREATE SEQUENCE diet_benefit_seq START WITH 1 INCREMENT BY 1
    GO

CREATE SEQUENCE diet_menu_meal_seq START WITH 1 INCREMENT BY 1
    GO

CREATE SEQUENCE diet_seq START WITH 1 INCREMENT BY 1
    GO

CREATE SEQUENCE meal_item_seq START WITH 1 INCREMENT BY 1
    GO

CREATE SEQUENCE recipe_ingredient_seq START WITH 1 INCREMENT BY 1
    GO

CREATE SEQUENCE recipe_seq START WITH 1 INCREMENT BY 1
    GO

CREATE SEQUENCE tag_seq START WITH 1 INCREMENT BY 1
    GO

CREATE SEQUENCE workout_muscle_seq START WITH 1 INCREMENT BY 1
    GO

CREATE SEQUENCE workout_seq START WITH 1 INCREMENT BY 1
    GO

CREATE TABLE diet
(
    id          bigint NOT NULL,
    image_url   varchar(255),
    diet_name   varchar(255),
    description varchar(255),
    CONSTRAINT pk_diet PRIMARY KEY (id)
)
    GO

CREATE TABLE diet_allowed_food
(
    id          bigint NOT NULL,
    description varchar(255),
    diet_id     bigint,
    CONSTRAINT pk_diet_allowed_food PRIMARY KEY (id)
)
    GO

CREATE TABLE diet_banned_food
(
    id          bigint NOT NULL,
    description varchar(255),
    diet_id     bigint,
    CONSTRAINT pk_diet_banned_food PRIMARY KEY (id)
)
    GO

CREATE TABLE diet_benefit
(
    id          bigint NOT NULL,
    description varchar(255),
    diet_id     bigint,
    CONSTRAINT pk_diet_benefit PRIMARY KEY (id)
)
    GO

CREATE TABLE diet_menu_meal
(
    id        bigint NOT NULL,
    meal_name varchar(255),
    diet_id   bigint,
    CONSTRAINT pk_diet_menu_meal PRIMARY KEY (id)
)
    GO

CREATE TABLE meal_item
(
    id                bigint NOT NULL,
    description       varchar(255),
    diet_menu_meal_id bigint,
    CONSTRAINT pk_meal_item PRIMARY KEY (id)
)
    GO

CREATE TABLE recipe
(
    id                       bigint NOT NULL,
    image_url                varchar(255),
    recipe_name              varchar(255),
    portion_size_grams       int    NOT NULL,
    total_calories           int    NOT NULL,
    protein_amount_grams     int    NOT NULL,
    fat_amount_grams         int    NOT NULL,
    carbs_amount_grams       int    NOT NULL,
    preparation_instructions varchar(MAX
) ,
    CONSTRAINT pk_recipe PRIMARY KEY (id)
) GO

CREATE TABLE recipe_ingredient
(
    id              bigint NOT NULL,
    amount          varchar(255),
    ingredient_name varchar(255),
    recipe_id       bigint,
    CONSTRAINT pk_recipe_ingredient PRIMARY KEY (id)
)
    GO

CREATE TABLE recipe_tag
(
    recipe_id bigint NOT NULL,
    tag_id    bigint NOT NULL
)
    GO

CREATE TABLE tag
(
    id   bigint NOT NULL,
    name varchar(255),
    CONSTRAINT pk_tag PRIMARY KEY (id)
)
    GO

CREATE TABLE workout
(
    id                 bigint NOT NULL,
    image_url          varchar(255),
    workout_name       varchar(255),
    video_url          varchar(255),
    upper_body_benefit bit,
    lower_body_benefit bit,
    calories           int    NOT NULL,
    repetitions        int    NOT NULL,
    CONSTRAINT pk_workout PRIMARY KEY (id)
)
    GO

CREATE TABLE workout_muscle
(
    id         bigint NOT NULL,
    name       varchar(255),
    workout_id bigint,
    CONSTRAINT pk_workout_muscle PRIMARY KEY (id)
)
    GO

ALTER TABLE diet_allowed_food
    ADD CONSTRAINT FK_DIET_ALLOWED_FOOD_ON_DIET FOREIGN KEY (diet_id) REFERENCES diet (id)
    GO

ALTER TABLE diet_banned_food
    ADD CONSTRAINT FK_DIET_BANNED_FOOD_ON_DIET FOREIGN KEY (diet_id) REFERENCES diet (id)
    GO

ALTER TABLE diet_benefit
    ADD CONSTRAINT FK_DIET_BENEFIT_ON_DIET FOREIGN KEY (diet_id) REFERENCES diet (id)
    GO

ALTER TABLE diet_menu_meal
    ADD CONSTRAINT FK_DIET_MENU_MEAL_ON_DIET FOREIGN KEY (diet_id) REFERENCES diet (id)
    GO

ALTER TABLE meal_item
    ADD CONSTRAINT FK_MEAL_ITEM_ON_DIET_MENU_MEAL FOREIGN KEY (diet_menu_meal_id) REFERENCES diet_menu_meal (id)
    GO

ALTER TABLE recipe_ingredient
    ADD CONSTRAINT FK_RECIPE_INGREDIENT_ON_RECIPE FOREIGN KEY (recipe_id) REFERENCES recipe (id)
    GO

ALTER TABLE workout_muscle
    ADD CONSTRAINT FK_WORKOUT_MUSCLE_ON_WORKOUT FOREIGN KEY (workout_id) REFERENCES workout (id)
    GO

ALTER TABLE recipe_tag
    ADD CONSTRAINT fk_rectag_on_recipe FOREIGN KEY (recipe_id) REFERENCES recipe (id)
    GO

ALTER TABLE recipe_tag
    ADD CONSTRAINT fk_rectag_on_tag FOREIGN KEY (tag_id) REFERENCES tag (id)
    GO