-- basic data
INSERT INTO families(name, description)
VALUES ('Pinecae', 'Acidaedsadasd jh ug gzguz zu.'),
       ('Aceraceae', 'Ddsadasd hhhuzg zgzguz.');

INSERT INTO habituses(name, description)
VALUES ('strom', 'kmen+koruna'),
       ('ker', 'rozkonareny od bazy'),
       ('kríček', 'drobný ker'),
       ('poloker', 'nadbazalna cas stonky je bylinnej konzistencie');

INSERT INTO rhytidomes(name, description)
VALUES ('smrekovy', 'malé jemné šupiny'),
       ('dubovy', 'borka sa trhá pozdĺžnymi puklinami'),
       ('bukovy', 'povrch kmeňa zostáva hladký'),
       ('brezovy',
        'v dôsledku druhotného hrubnutia kmeňa sa borka napína a následne puká a prstencovite (priečne) sa odlupuje v tenkých plátoch'),
       ('platanovy', ' borka, ktorá sa postupne odlupuje v rôzne veľkých plátoch');



INSERT INTO category_nodes_shape_of_leaf_blade(level, name, parent_name)
VALUES (1, 'zlozeny list', null),
       (1, 'jednoduchy list', null),
       (2, 'celistvy', 'jednoduchy list'),
       (2, 'deleny', 'jednoduchy list'),
       (2, 'perovito zlozene', 'zlozeny list'),
       (2, 'dlanovito zlozene', 'zlozeny list');
