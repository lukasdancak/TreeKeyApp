INSERT INTO families(name, description)
VALUES ('Pinecae', 'Acidaedsadasd'),
       ('Acerace', 'edsadasd');

INSERT INTO habituses(name, description)
VALUES ('strom', 'kmen+koruna'),
       ('ker', 'rozkonareny od bazy'),
       ('kricek', 'drobny ker'),
       ('poloker', 'nadbazalna cas stonky je bylinnej konzistencie');


INSERT INTO category_nodes_shape_of_leaf_blade(id, level, name, parent_id)
VALUES (1, 1, 'zlozeny list', null),
       (2, 1, 'jednoduchy list', null),
       (3, 2, 'celistvy', 2),
       (4, 2, 'deleny', 2),
       (5, 2, 'perovito zlozene', 1),
       (6, 2, 'dlanovito zlozene', 1);
