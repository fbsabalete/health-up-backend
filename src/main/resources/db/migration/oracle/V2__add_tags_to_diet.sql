CREATE TABLE diet_tag
(
    diet_id NUMBER(38, 0) NOT NULL,
    tag_id  NUMBER(38, 0) NOT NULL
);

ALTER TABLE diet_tag
    ADD CONSTRAINT fk_diet_tag_on_diet FOREIGN KEY (diet_id) REFERENCES diet (id);

ALTER TABLE diet_tag
    ADD CONSTRAINT fk_diet_tag_on_tag FOREIGN KEY (tag_id) REFERENCES tag (id);