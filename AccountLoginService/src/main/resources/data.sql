DROP TABLE IF EXISTS USERS;

DROP TABLE IF EXISTS Authorities;

CREATE TABLE USERS ( id INT AUTO_INCREMENT PRIMARY KEY, username VARCHAR(25) NOT NULL, password VARCHAR(25) NOT NULL, enabled boolean NOT NULL, roles VARCHAR(25));  

INSERT INTO USERS (username,password,enabled,roles) VALUES
('Anuj','XXXX','Y','Admin'),
('Ashutosh', 'XXXXX', 'Y','User');


