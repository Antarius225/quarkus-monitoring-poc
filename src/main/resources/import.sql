INSERT INTO ApplicationType (id, name) VALUES (1, 'ZSmart');
INSERT INTO monitoring (status, application_id, id, timestamp, message) VALUES ('DOWN', 1, 1, '2024-01-01 00:00:00', 'Everything is bad');
INSERT INTO monitoring (status, application_id, id, timestamp, message) VALUES ('UP', 1, 2, '2024-01-01 00:00:05', 'Everything is fine');
INSERT INTO monitoring (status, application_id, id, timestamp, message) VALUES ('UP', 1, 3, '2024-01-01 00:00:10', 'Everything is fine');
INSERT INTO monitoring (status, application_id, id, timestamp, message) VALUES ('DOWN', 1, 4, '2024-01-01 00:00:15', 'Everything is bad');


-- RESET SEQUENCE OF MONITORING TABLE
SELECT setval('monitoring_seq', (SELECT MAX(id) FROM monitoring)+1);