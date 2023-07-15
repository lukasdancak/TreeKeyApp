-- on server database you can change encoding if needed by query:
-- (You can change encoding on the fly without dump/restore).
-- update pg_database set encoding = pg_char_to_encoding('UTF8') where datname = 'database_name'

--query for Getting the encoding of a Postgres database:
-- SELECT pg_encoding_to_char(encoding) FROM pg_database WHERE datname = 'yourdb';

-- basic data
INSERT INTO families(name, description)
VALUES ('Pinaceae', 'Acidaedsadasd jh ug gzguz zu'),
       ('Fagaceae', 'Dfgfg fdg dfg dfg fdg uz zu'),
       ('Aceraceae', 'Ddsadasd hhhuzg zgzguz');

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

INSERT INTO leaf_blade_shapes_nodes(level, name, parent_name)
VALUES (1, 'zlozene', null),
       (1, 'jednoduche', null),
       (2, 'celistve', 'jednoduche'),
       (2, 'delene', 'jednoduche'),
       (2, 'perovito-zlozene', 'zlozene'),
       (2, 'dlanovito-zlozene', 'zlozene'),
       (3, 'lalocnate', 'delene'),
       (3, 'ciarkovity (ihlicovity)', 'celistve'),
       (3, 'elipsovity', 'celistve'),
       (4, 'perovito-lalocnaty', 'lalocnate'),
       (3, 'trojpocetny', 'dlanovito-zlozene');

INSERT INTO leaf_veins_types_nodes(level, name, parent_name)
VALUES (1, 'nahosemennych – otvorena', null),
       (1, 'krytosemennych (dvojklicnolistovych) – uzatvorena', null);


-- trees data
INSERT INTO trees(id, description, latin_name, slovak_name, family_name, habitus_name, leaf_blade_shapes_node_name,
                  leaf_veins_type_name, rhytidome_name)
VALUES (1, 'popis popis 1', 'Picea abies', 'smrek obyčajný', 'Pinaceae', 'strom', 'ciarkovity (ihlicovity)',
        'nahosemennych – otvorena', 'smrekovy'),
       (2, 'popis popis 2', 'Fagus sylvatica', 'buk lesný', 'Fagaceae', 'strom', 'elipsovity',
        'krytosemennych (dvojklicnolistovych) – uzatvorena', 'bukovy'),
       (3, 'popis popis 3', 'Fagus sylvatica', 'buk lesný', 'Fagaceae', 'strom', 'elipsovity',
        'krytosemennych (dvojklicnolistovych) – uzatvorena', 'bukovy');


