-- basic data
INSERT INTO families(name, description)
VALUES ('Pinecae', 'Acidaedsadasd jh ug gzguz zu.'),
       ('Aceraceae', 'Ddsadasd hhhuzg zgzguz.');

INSERT INTO habituses(name, description)
VALUES ('strom', 'kmen+koruna'),
       ('ker', 'rozkonareny od bazy'),
       ('kricek', 'drobny ker'),
       ('poloker', 'nadbazalna cas stonky je bylinnej konzistencie');

INSERT INTO rhytidomes(name, description)
VALUES ('smrekovy', 'malé jemné šupiny'),
       ('dubovy', 'borka sa trhá pozdĺžnymi puklinami'),
       ('bukovy', 'povrch kmeňa zostáva hladký'),
       ('brezovy',
        'v dôsledku druhotného hrubnutia kmeňa sa borka napína a následne puká a prstencovite (priečne) sa odlupuje v tenkých plátoch'),
       ('platanovy', ' borka, ktorá sa postupne odlupuje v rôzne veľkých plátoch');



INSERT INTO leaf_blade_shapes_category_nodes(level, name, parent_name)
VALUES (1, 'zlozene', null),
       (1, 'jednoduche', null),
       (2, 'celistve', 'jednoduche'),
       (2, 'delene', 'jednoduche'),
       (2, 'perovito-zlozene', 'zlozene'),
       (2, 'dlanovito-zlozene', 'zlozene'),
       (3, 'lalocnate', 'delene');


INSERT INTO leaf_blade_shapes(name, description, category_node_name)
VALUES ('ciarkovity (ihlicovity)', 'bla bla bla', 'celistve'),
       ('elipsovity', 'bla bla bla', 'celistve'),
       ('perovito-lalocnaty', 'bla uhuubla bla', 'lalocnate'),
       ('trojpocetny', 'buhila uhuubla bla', 'dlanovito-zlozene');



INSERT INTO leaf_veins_types_category_nodes(level, name, parent_name)
VALUES (1, 'nahosemennych – otvorena', null),
       (1, 'krytosemennych (dvojklicnolistovych) – uzatvorena', null);


