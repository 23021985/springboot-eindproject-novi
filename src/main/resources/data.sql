INSERT INTO users (username, password, enabled, email, first_name, last_name) VALUES ('Hansadmin', '$2a$10$q/rYVLnKiyHpoZv8jD3ce.SB4hbyf0oVOYUZYJyWoT39F/4oGkhta', TRUE, 'hans@debaas.com', 'Hans', 'de Vreugd');
INSERT INTO users (username, password, enabled, email, first_name, last_name) VALUES ('arnie', '$2a$10$q/rYVLnKiyHpoZv8jD3ce.SB4hbyf0oVOYUZYJyWoT39F/4oGkhta', TRUE, 'arnold@counter.com', 'Arnold', 'van Dijk');
INSERT INTO users (username, password, enabled, email, first_name, last_name) VALUES ('stillis', '$2a$10$q/rYVLnKiyHpoZv8jD3ce.SB4hbyf0oVOYUZYJyWoT39F/4oGkhta', TRUE, 'jillis@slaaptnog.com', 'Jillis', 'vd Boom');



INSERT INTO authorities (username, authority) VALUES ('arnie', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('stillis', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('Hansadmin', 'ROLE_ADMIN');