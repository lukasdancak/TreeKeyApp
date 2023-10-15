-- on server database you can change encoding if needed by query:
-- (You can change encoding on the fly without dump/restore)
-- update pg_database set encoding = pg_char_to_encoding('UTF8') where datname = 'database_name'

--query for Getting the encoding of a Postgres database:
-- SELECT pg_encoding_to_char(encoding) FROM pg_database WHERE datname = 'yourdb';

-- basic data
INSERT INTO families(name, description)
VALUES ('Pinaceae', 'Lorem ipsum'),
       ( 'Fagaceae', 'Lorem ipsum' ),
       ( 'Salicaceae', 'Lorem ipsum' ),
       ( 'Corylaceae', 'Lorem ipsum' ),
       ( 'Tiliaceae', 'Lorem ipsum' ),
       ( 'Betulaceae', 'Lorem ipsum' ),
       ( 'Ulmaceae', 'Lorem ipsum' ),
       ( 'Aceraceae', 'Lorem ipsum' ),
       ( 'Adoxaceae', 'Lorem ipsum' ),
       ( 'Rosaceae', 'Lorem ipsum' ),
       ( 'Sapindaceae', 'Lorem ipsum' ),
       ( 'Fabaceae', 'Lorem ipsum' );

INSERT INTO habituses(name, description)
VALUES ('strom', 'kmen+koruna'),
       ('ker', 'rozkonareny od bazy'),
       ('liana', 'popinava drevina'),
       ('N/A', 'nestanovene, nevyskytuje sa sekundarny typ');


INSERT INTO rhytidomes(name, description)
VALUES ('smrekovy', 'malé jemné šupiny'),
       ('dubovy', 'borka sa trhá pozdĺžnymi puklinami'),
       ('bukovy', 'povrch kmeňa zostáva hladký'),
       ('brezovy',
        'v dôsledku druhotného hrubnutia kmeňa sa borka napína a následne puká a prstencovite (priečne) sa odlupuje v tenkých plátoch'),
       ('platanovy', ' borka, ktorá sa postupne odlupuje v rôzne veľkých plátoch'),
       ('N/A', 'nestanovene, nevyskytuje sa sekundarny typ');

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
       (3, 'kopijovity', 'celistve', '2.1.2'),
       (3, 'elipsovity', 'celistve', '2.1.3'),
       (3, 'vajcovity', 'celistve', '2.1.4'),
       (3, 'deltoidicky', 'celistve', '2.1.5'),
       (3, 'srdcovity', 'celistve', '2.1.6'),
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
INSERT INTO trees(id, description, latin_name, native_species, slovak_name, family_name,  leaf_blade_shapes_node_name,
                  leaf_veins_type_name, primary_habitus_name, secondary_habitus_name, primary_rhytidome_name,  secondary_rhytidome_name )
VALUES (1, 'popis popis 1', 'Picea abies', true, 'smrek obyčajný', 'Pinaceae',  'ciarkovity (ihlicovity)','nahosemennych – otvorena', 'strom',  'N/A', 'smrekovy', 'N/A'),
       (2, 'popis xyz', 'Fagus sylvatica', TRUE, 'buk lesný', 'Fagaceae', 'elipsovity', 'perovita', 'strom', 'N/A', 'bukovy', 'N/A' ),

       (4, 'popis xyz', 'Salix alba', TRUE, 'vŕba biela', 'Salicaceae', 'kopijovity', 'perovita', 'strom', 'N/A', 'dubovy', 'N/A' ),
       (5, 'popis xyz', 'Carpinus betulus', TRUE, 'hrab obyčajný', 'Corylaceae', 'vajcovity', 'perovita', 'strom', 'N/A', 'bukovy', 'N/A' ),
       (6, 'popis xyz', 'Populus nigra', TRUE, 'topoľ čierny', 'Salicaceae', 'deltoidicky', 'perovita', 'strom', 'N/A', 'dubovy', 'N/A' ),
       (7, 'popis xyz', 'Tilia platyphyllos', TRUE, 'lipa veľkolistá', 'Tiliaceae', 'srdcovity', 'perovita', 'strom', 'N/A', 'bukovy', 'dubovy' ),
       (8, 'popis xyz', 'Alnus glutinosa', TRUE, 'jelša lepkavá', 'Betulaceae', 'obrateno-vajcovity', 'perovita', 'strom', 'N/A', 'bukovy', 'dubovy' ),
       (9, 'popis xyz', 'Populus tremula', TRUE, 'topoľ osikový', 'Salicaceae', 'okruhlasty', 'perovita', 'strom', 'N/A', 'bukovy', 'dubovy' ),
       (10, 'popis xyz', 'Corylus avellana ', TRUE, 'lieska obyčajná', 'Corylaceae', 'okruhlasty', 'perovita', 'ker', 'strom', 'bukovy', 'smrekovy' );



