ALTER TABLE user_activity DROP FOREIGN KEY fk_user_activity_activity1;
ALTER TABLE activity CHANGE id activity_id INTEGER NOT NULL;
ALTER TABLE user_activity ADD CONSTRAINT fk_user_activity_activity2 FOREIGN KEY (activity_id) REFERENCES activity(activity_id);

ALTER TABLE environment_statistic CHANGE id environment_statistic_id INTEGER NOT NULL;

ALTER TABLE user_meal DROP FOREIGN KEY fk_USER_MEAL_meal1;
ALTER TABLE meal CHANGE id meal_id INTEGER NOT NULL;
ALTER TABLE user_meal ADD CONSTRAINT fk_USER_MEAL_meal1 FOREIGN KEY (meal_id) REFERENCES meal(meal_id);

ALTER TABLE user_meal DROP FOREIGN KEY fk_USER_MEAL_MEAL_TYPE1;
ALTER TABLE meal_type CHANGE id meal_type_id INTEGER NOT NULL;
ALTER TABLE user_meal ADD CONSTRAINT fk_USER_MEAL_MEAL_TYPE1 FOREIGN KEY (meal_type_id) REFERENCES meal_type(meal_type_id);

DROP TABLE user_role;

