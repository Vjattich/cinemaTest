INSERT INTO film
VALUES (nextval('film_id_seq'), 'Horror film', 'HORROR', 'Fear', 1);
INSERT INTO film
VALUES (nextval('film_id_seq'), 'Drama film', 'DRAMA', 'Drama', 2);
INSERT INTO film
VALUES (nextval('film_id_seq'), 'Action film', 'ACTION', 'Action', 3);


INSERT INTO session
VALUES (nextval('session_id_seq'), 'MOSCOW', '2019-08-01 18:30:00', 1);
INSERT INTO session
VALUES (nextval('session_id_seq'), 'PERM', '2019-08-01 18:00:00', 1);
INSERT INTO session
VALUES (nextval('session_id_seq'), 'MOSCOW', '2019-08-01 14:30:00', 2);
INSERT INTO session
VALUES (nextval('session_id_seq'), 'PERM', '2019-08-01 14:00:00', 2);
INSERT INTO session
VALUES (nextval('session_id_seq'), 'MOSCOW', '2019-08-01 20:30:00', 3);
INSERT INTO session
VALUES (nextval('session_id_seq'), 'PERM', '2019-08-01 20:00:00', 3);

INSERT INTO ticket
VALUES (nextval('ticket_id_seq'), '@mail.ru', '+7123123123', 1, '2019-08-01 17:30:00', 1);
INSERT INTO ticket
VALUES (nextval('ticket_id_seq'), '@mail.ru', '+7123123123', 2, '2019-08-01 17:31:00', 1);
INSERT INTO ticket
VALUES (nextval('ticket_id_seq'), '@mail.ru', '+7123123121', 3, '2019-08-01 17:33:00', 1);
INSERT INTO ticket
VALUES (nextval('ticket_id_seq'), '@mail.ru', '+71231231251', 1, '2019-08-01 17:40:00', 2);
INSERT INTO ticket
VALUES (nextval('ticket_id_seq'), '@mail.ru', '+71231231251', 2, '2019-08-01 17:41:00', 3);