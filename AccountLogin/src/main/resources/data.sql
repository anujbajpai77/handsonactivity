
INSERT INTO USER (user_id,password, email, enabled, username) VALUES
(1,'$2y$12$zdzZgDKO5PloEwYB4Flgke926fWmIINjgarm6mZxKP/o/Ai7UP/.2', 'anuj@mail.com', 1,'Anuj'),
(2,'$2y$12$pqabslBi8cRdLqqZXHgZo.BygKh/LBeHC5iwr5hcp4nJxkob89jPa', 'ashutosh@gmail.com',1,'Ashutosh'),
(3,'$2y$12$DkwbgUwtE8pLJS9jDLS.s.DD3u6OXAcY7OxyOHt8f2ZxsBAlfpIeW', 'param@gmail.com',1,'Param');

INSERT INTO ROLE (role_id,role) VALUES 
(1,'ROLE_ADMIN'),
(2,'ROLE_USER');

INSERT INTO USER_ROLE (user_id, role_id) VALUES
(1, 1),
(1, 2),
(2, 2),
(3, 2);

INSERT INTO PRODUCT (product_id,name, description, quantity, price) VALUES
(1,'APPLETON', 'Grounding Bushing With Bronze', 1, 35.75),
(2,'HOFFMAN AHE12X10X4', 'Pull Box With Knockout', 5, 34.50),
(3,'Sylvania', 'Fluorescent Lamp', 3, 1500.00),
(4,'AJC', 'Wheelchair Battery', 40, 1000.00),
(5,'Hubbell HBL2741', 'Wiring Device-Kellems Twist', 80, 450.45),
(6,'Fasteners And Fittings ', 'STEEL S.A.E. WASHERS', 800, 1.762),
(7,'Weidmuller Inc.', 'FEED THROUGH TERMINAL,W-SERIES SGL TIER', 700, 45000.00),
(8,'General Cable Canada Ltd', 'CAT5E 4PR UNSH ARMORED FT4', 500, 300.00),
(9,'STEP STAKE SS-1 2 WIRE COROSTAKE', 'Recommended for corrugated', 1000, 500.00);
