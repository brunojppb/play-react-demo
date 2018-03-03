# --- !Ups

-- Usuario
CREATE TABLE "user" (
  id SERIAL NOT NULL PRIMARY KEY,
  email VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  name VARCHAR(255) NOT NULL DEFAULT '',
  created_at TIMESTAMP NOT NULL,
  updated_at TIMESTAMP NOT NULL
);

CREATE TABLE "todo" (
  id SERIAL NOT NULL PRIMARY KEY,
  user_id INT NOT NULL,
  is_complete BOOLEAN NOT NULL DEFAULT FALSE,
  created_at TIMESTAMP NOT NULL,
  updated_at TIMESTAMP NOT NULL,
  CONSTRAINT todo_user_id_fkey FOREIGN KEY (user_id) REFERENCES "user" (id)
);




# --- !Downs

DROP TABLE "todo";
DROP TABLE "user";

