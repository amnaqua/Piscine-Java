INSERT INTO chat_user (login, password) VALUES ('Bob', '000000');
INSERT INTO chat_user (login, password) VALUES ('Billy', '1200000');
INSERT INTO chat_user (login, password) VALUES ('Logan', '000000123');
INSERT INTO chat_user (login, password) VALUES ('Gachi', '000000');
INSERT INTO chat_user (login, password) VALUES ('Andrew', '000000');

INSERT INTO chat_room (name, owner_id) VALUES ('Random', 1);
INSERT INTO chat_room (name, owner_id) VALUES ('General', 2);
INSERT INTO chat_room (name, owner_id) VALUES ('dungeon', 3);
INSERT INTO chat_room (name, owner_id) VALUES ('Lols', 4);
INSERT INTO chat_room (name, owner_id) VALUES ('NMA', 5);

INSERT INTO chat_message (author, room, text, timestamp) VALUES (1, 1, 'kek', '1970-01-01 00:00:01');
INSERT INTO chat_message (author, room, text, timestamp) VALUES (2, 3, 'lmao', '1970-01-01 00:00:01');
INSERT INTO chat_message (author, room, text, timestamp) VALUES (5, 3, '300 bucks', '1970-01-01 00:00:02');
INSERT INTO chat_message (author, room, text, timestamp) VALUES (4, 4, 'RIPPERONI', '1970-01-01 00:00:04');
INSERT INTO chat_message (author, room, text, timestamp) VALUES (5, 5, 'NMA', '1970-01-01 00:00:05');