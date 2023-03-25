INSERT INTO CATEGORY VALUES (1000, 'Comic Books'), (1001, 'Movies'), (1002, 'Books');
INSERT INTO SUPPLIER VALUES (1000 , 'Panini Comics'), (1001 , 'Amazon');

INSERT INTO PRODUCT (ID, NAME, FK_SUPPLIER, FK_CATEGORY, QUANTITY_AVAILABLE) VALUES (1000, 'Crise nas Infinitas Terras', 1000, 1000, 10),(1001, 'Interestelar', 1001, 1001, 5),(1002, 'Harry Potter 1', 1001, 1002, 3);
