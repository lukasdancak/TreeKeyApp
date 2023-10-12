-- on server database you can change encoding if needed by query:
-- (You can change encoding on the fly without dump/restore)
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
       ('liana', 'popinava drevina');

INSERT INTO rhytidomes(name, description)
VALUES ('smrekovy', 'malé jemné šupiny'),
       ('dubovy', 'borka sa trhá pozdĺžnymi puklinami'),
       ('bukovy', 'povrch kmeňa zostáva hladký'),
       ('brezovy',
        'v dôsledku druhotného hrubnutia kmeňa sa borka napína a následne puká a prstencovite (priečne) sa odlupuje v tenkých plátoch'),
       ('platanovy', ' borka, ktorá sa postupne odlupuje v rôzne veľkých plátoch');

INSERT INTO leaf_blade_shapes_nodes(level, name, parent_name, prefix)
VALUES (1, 'zlozene', null, '1'),

       (2, 'perovito-zlozene', 'zlozene', '1.1'),
       (3, 'neparno-perovito-zlozeny', 'perovito-zlozene', '1.1.1'),
       (3, 'parno-perovito-zlozeny', 'perovito-zlozene', '1.1.2'),


       (2, 'dlanovito-zlozene', 'zlozene', '1.2'),
       (3, 'trojpocetny', 'dlanovito-zlozene', '1.2.1'),
       (3, 'patpocetny', 'dlanovito-zlozene', '1.2.2'),
       (3, 'sedempocetny', 'dlanovito-zlozene', '1.2.3'),

       (1, 'jednoduche', null, '2'),
       (2, 'celistve', 'jednoduche', '2.1'),
       (3, 'ciarkovity (ihlicovity)', 'celistve', '2.1.1'),
       (3, 'kopijovitý', 'celistve', '2.1.2'),
       (3, 'elipsovity', 'celistve', '2.1.3'),
       (3, 'vajcovitý', 'celistve', '2.1.4'),
       (3, 'deltoidicky', 'celistve', '2.1.5'),
       (3, 'srdcovitý', 'celistve', '2.1.6'),
       (3, 'obrateno-vajcovity', 'celistve', '2.1.7'),
       (3, 'okruhlasty', 'celistve', '2.1.8'),
       (3, 'nesumerny', 'celistve', '2.1.9'),

       (2, 'delene', 'jednoduche', '2.2'),

       (3, 'lalocnate', 'delene', '2.2.1'),
       (4, 'perovito-lalocnaty', 'lalocnate', '2.2.1.1'),
       (4, 'dlanovito-lalocnaty', 'lalocnate', '2.2.1.2'),

       (3, 'zarezove', 'delene', '2.2.2'),
       (4, 'perovito-zarezovy', 'zarezove', '2.2.2.1'),
       (4, 'dlanovito-zarezovy', 'zarezove', '2.2.2.2'),

       (3, 'dielne', 'delene', '2.2.3'),
       (4, 'perovito-dielny', 'dielne', '2.2.3.1'),
       (4, 'dlanovito-dielny', 'dielne', '2.2.3.2');


INSERT INTO leaf_veins_types_nodes(level, name, parent_name)
VALUES (1, 'nahosemennych – otvorena', null),
            (2, 's-jednou-zilou', 'nahosemennych – otvorena'),
            (2, 's-dvomi-zilami', 'nahosemennych – otvorena'),
            (2, 'vejarovita', 'nahosemennych – otvorena'),

       (1, 'krytosemennych (dvojklicnolistovych) – uzatvorena', null),
            (2, 'perovita', 'krytosemennych (dvojklicnolistovych) – uzatvorena'),
            (2, 'dlanovita', 'krytosemennych (dvojklicnolistovych) – uzatvorena');


-- trees data
INSERT INTO trees(id, description, latin_name, slovak_name, family_name,  leaf_blade_shapes_node_name,
                  leaf_veins_type_name, native_species)
VALUES (1, 'popis popis 1', 'Picea abies', 'smrek obyčajný', 'Pinaceae',  'ciarkovity (ihlicovity)',
        'nahosemennych – otvorena', true),
       (2, 'popis popis 2', 'Fagus sylvatica', 'buk lesný', 'Fagaceae',  'elipsovity',
        'krytosemennych (dvojklicnolistovych) – uzatvorena', true),
       (3, 'popis popis 3', 'Fagus sylvatica', 'buk lesný', 'Fagaceae',  'elipsovity',
        'krytosemennych (dvojklicnolistovych) – uzatvorena', true);


