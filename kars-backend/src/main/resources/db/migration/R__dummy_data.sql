DELETE
FROM books;
DELETE
FROM authors;
INSERT INTO authors (last_name, first_name)
VALUES ('Tolkien', 'J.R.R.'),
       ( 'Lewis', 'C.S'),
       ( 'Sanderson', 'Brandon'),
       ( 'Tom', 'Clancy'),
       ( 'Rowling', 'J.K.'),
       ( 'Martin', 'George R.R.'),
       ( 'Jordan', 'Robert'),
       ( 'Rothfuss', 'Patrick'),
       ( 'Hobb', 'Robin'),
       ( 'Pratchett', 'Terry'),
       ( 'Eddings', 'David'),
       ( 'Feist', 'Raymond E.'),
       ( 'Goodkind', 'Terry'),
       ( 'Brooks', 'Terry'),
       ( 'Salvatore', 'R.A.'),
       ( 'Hickman', 'Tracy'),
       ( 'Weis', 'Margaret'),
       ( 'McCaffrey', 'Anne'),
       ( 'Herbert', 'Frank'),
       ( 'Asimov', 'Isaac'),
       ( 'Heinlein', 'Robert A.'),
       ( 'Clarke', 'Arthur C.'),
       ( 'Bradbury', 'Ray'),
       ( 'Orwell', 'George'),
       ( 'Huxley', 'Aldous');

INSERT INTO books (id, title, description, published_year, author_id)
VALUES (1, 'Sir Gawain & The Green Knight',
        'A modern translation of the Middle English romance from the stories of King Arthur.', 1925, 1),
       (2, 'The Hobbit: or There and Back Again',
        'The bedtime story for his children famously begun on the blank page of an exam script that tells the tale of Bilbo Baggins and the dwarves in their quest to take back the Lonely Mountain from Smaug the dragon.',
        1937, 1),
         (3, 'The Fellowship of the Ring', 'The first part of the Lord of the Rings trilogy, this book introduces the reader to the world of Middle Earth and the characters that inhabit it.', 1954, 1),
         (4, 'The Two Towers', 'The second part of the Lord of the Rings trilogy, this book continues the story of the Fellowship of the Ring as they journey through Middle Earth.', 1954, 1),
         (5, 'The Return of the King', 'The final part of the Lord of the Rings trilogy, this book concludes the story of the Fellowship of the Ring and their quest to destroy the One Ring.', 1955, 1),
         (6, 'The Lion, the Witch and the Wardrobe', 'The first book in the Chronicles of Narnia series, this book tells the story of four siblings who discover a magical world through a wardrobe in their uncle''s house.', 1950, 2),
         (7, 'The Magician''s Nephew', 'The sixth book in the Chronicles of Narnia series, this book tells the story of the creation of Narnia and the adventures of Digory Kirke and Polly Plummer.', 1955, 2)
;