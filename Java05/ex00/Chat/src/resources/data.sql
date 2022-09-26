INSERT INTO chat_user(login, password) VALUES ('Artur', '123');
INSERT INTO chat_user(login, password) VALUES ('Ivan', 'Hello');
INSERT INTO chat_user(login, password) VALUES ('John', 'World');
INSERT INTO chat_user(login, password) VALUES ('Mike', 'qwerty');
INSERT INTO chat_user(login, password) VALUES ('Alisa', '123qwerty041');

INSERT INTO chat_room(name, owner_id) VALUES ('Java05', 1);
INSERT INTO chat_room(name, owner_id) VALUES ('Test', 2);
INSERT INTO chat_room(name, owner_id) VALUES ('Room', 3);
INSERT INTO chat_room(name, owner_id) VALUES ('Secret', 4);
INSERT INTO chat_room(name, owner_id) VALUES ('Unknown', 5);

INSERT INTO chat_message(author, room, text) VALUES (1, 1, 'First message');
INSERT INTO chat_message(author, room, text) VALUES (2, 1, 'Hello');
INSERT INTO chat_message(author, room, text) VALUES (3, 3, 'Room 3');
INSERT INTO chat_message(author, room, text) VALUES (4, 3, 'Test message from user4');
INSERT INTO chat_message(author, room, text) VALUES (5, 5, 'Empty');