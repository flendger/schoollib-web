-- book_types
INSERT INTO book_types (id, code, name, is_deleted) VALUES (1, 2, 'УЧЕБНИК', 0);
INSERT INTO book_types (id, code, name, is_deleted) VALUES (2, 1, 'ПОСОБИЕ', 0);
INSERT INTO book_types (id, code, name, is_deleted) VALUES (3, 3, 'test', 1);
INSERT INTO book_types (id, code, name, is_deleted) VALUES (4, 4, 'Test_2', 1);

-- location_types
INSERT INTO location_types (id, code, name, is_deleted) VALUES (1, 1, 'Книжное хранилище', 0);
INSERT INTO location_types (id, code, name, is_deleted) VALUES (2, 2, 'Физическое лицо', 0);
INSERT INTO location_types (id, code, name, is_deleted) VALUES (3, 3, 'Школа', 0);

-- owners
INSERT INTO owners (id, code, name, is_deleted) VALUES (2, 1, 'Черкизово', 0);
INSERT INTO owners (id, code, name, is_deleted) VALUES (3, 2, 'Звягино', 0);
INSERT INTO owners (id, code, name, is_deleted) VALUES (4, 3, 'Пушкино', 1);
INSERT INTO owners (id, code, name, is_deleted) VALUES (5, 4, 'tesst', 1);

-- people
INSERT INTO people (id, code, name, telephone, email, address, comment, is_deleted) VALUES (2, 1, 'Иванов Иван Иванович', '+7(925)433-55-65', 'fff@man.ty', 'Нью-йорк', 'что-то тут не так', 0);
INSERT INTO people (id, code, name, telephone, email, address, comment, is_deleted) VALUES (3, 2, 'Петров Петр Петрович', '+7(888)888-88-88', 'bbb@bb.com', 'Madrid', 'other information', 0);
INSERT INTO people (id, code, name, telephone, email, address, comment, is_deleted) VALUES (6, 3, 'Петров Петр Петрович*', '+7(476)734-99-34', '', '', '', 1);

-- publishers
INSERT INTO publishers (id, code, name, is_deleted) VALUES (3, 1, 'ПРОСВЕЩЕНИЕ', 0);
INSERT INTO publishers (id, code, name, is_deleted) VALUES (6, 2, 'ДРОФА', 0);
INSERT INTO publishers (id, code, name, is_deleted) VALUES (8, 3, 'ВЕНТАНА-ГРАФ', 0);
INSERT INTO publishers (id, code, name, is_deleted) VALUES (11, 4, 'РУССКОЕ СЛОВО', 0);

-- subjects
INSERT INTO subjects (id, code, name, is_deleted) VALUES (1, 1, 'Математика', 0);
INSERT INTO subjects (id, code, name, is_deleted) VALUES (2, 2, 'Литература', 0);
INSERT INTO subjects (id, code, name, is_deleted) VALUES (3, 3, 'Русский язык', 0);
INSERT INTO subjects (id, code, name, is_deleted) VALUES (4, 4, 'Чтение', 0);

-- locations
INSERT INTO locations (id, code, name, location_type_id, person_id, is_deleted) VALUES (1, 3, '1Вfdgd*', 1, 3, 0);
INSERT INTO locations (id, code, name, location_type_id, person_id, is_deleted) VALUES (3, 1, '2Б', 1, 3, 0);
INSERT INTO locations (id, code, name, location_type_id, person_id, is_deleted) VALUES (5, 4, 'MX 4', 1, 6, 0);
INSERT INTO locations (id, code, name, location_type_id, person_id, is_deleted) VALUES (6, 5, '1_test_1* ', 3, 2, 0);
INSERT INTO locations (id, code, name, location_type_id, person_id, is_deleted) VALUES (9, 6, 'New location 6', 2, 2, 1);
INSERT INTO locations (id, code, name, location_type_id, person_id, is_deleted) VALUES (10, 2, 'loc_test_1', null, null, 1);
INSERT INTO locations (id, code, name, location_type_id, person_id, is_deleted) VALUES (11, 8, 'test123', null, null, 1);
INSERT INTO locations (id, code, name, location_type_id, person_id, is_deleted) VALUES (12, 9, 'MX 1', 1, 2, 0);
INSERT INTO locations (id, code, name, location_type_id, person_id, is_deleted) VALUES (13, 10, '1А', 3, 2, 0);
INSERT INTO locations (id, code, name, location_type_id, person_id, is_deleted) VALUES (14, 11, '3В', 1, 3, 0);
INSERT INTO locations (id, code, name, location_type_id, person_id, is_deleted) VALUES (15, 12, '2_test_2', 3, 2, 1);
INSERT INTO locations (id, code, name, location_type_id, person_id, is_deleted) VALUES (16, 13, '1_dfssf', 2, null, 1);
INSERT INTO locations (id, code, name, location_type_id, person_id, is_deleted) VALUES (17, 14, '2_zzz', null, null, 1);
INSERT INTO locations (id, code, name, location_type_id, person_id, is_deleted) VALUES (18, 15, '2Г', null, null, 1);
INSERT INTO locations (id, code, name, location_type_id, person_id, is_deleted) VALUES (19, 16, '3Г', null, null, 1);
INSERT INTO locations (id, code, name, location_type_id, person_id, is_deleted) VALUES (20, 17, '3Г', null, null, 1);
INSERT INTO locations (id, code, name, location_type_id, person_id, is_deleted) VALUES (21, 18, '3Г', null, null, 1);
INSERT INTO locations (id, code, name, location_type_id, person_id, is_deleted) VALUES (22, 19, '2Г', null, null, 1);

-- books
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (66, 3, 'ИСТОРИЯ РОССИИ 6 КЛАСС. КОНТУРНЫЕ КАРТЫ', 2, 'ТОРОП В.В', 1.00, 1.00, 1, 2019.0000, 3, 2, 1, 45.10, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (67, 4, 'ИСТОРИЯ РОССИИ 7 КЛАСС. КОНТУРНЫЕ КАРТЫ', 2, 'ТОРОП В.В.', 0.00, 0.00, null, 2020.0000, 3, 2, 1, 45.10, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (68, 5, 'ИСТОРИЯ РОССИИ 8 КЛАСС. КОНТУРНЫЕ КАРТЫ', 2, 'ТОРОП В.В.', 0.00, 0.00, null, 2019.0000, 3, 2, 1, 45.10, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (69, 6, 'ИСТОРИЯ РОССИИ 9 КЛАСС. КОНТУРНЫЕ КАРТЫ', 2, 'ТОРОП В.В.', 0.00, 0.00, null, 2019.0000, 3, 2, 1, 45.10, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (70, 7, 'РУССКИЙ РОДНОЙ ЯЗЫК 2 КЛАСС', 1, 'АЛЕКСАНДРОВА О.М., ВЕРБИЦКАЯ Л.А., БОГДАНОВА С.И., КАЗАКОВА Е.И., КУЗНЕЦОВА М.И., ПЕТЛЕНКО Л.В., РОМАНОВА В.Ю., РЯБИНИНА Л.А., СОКОЛОВА О.В.', 0.00, 0.00, null, 2020.0000, 3, 2, 1, 442.20, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (71, 8, 'РУССКИЙ РОДНОЙ ЯЗЫК 3 КЛАСС', 1, 'АЛЕКСАНДРОВА О.М., ВЕРБИЦКАЯ Л.А., БОГДАНОВ С.И., КАЗАКОВА Е.И., КУЗНЕЦОВА М.И., ПЕТЛЕНКО Л.В., РОМАНОВА В.Ю., РЯБИНИНА Л.А., СОКОЛОВА О.В.', 0.00, 0.00, null, 2020.0000, 3, 2, 1, 442.20, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (72, 9, 'РУССКИЙ РОДНОЙ ЯЗЫК 4 КЛАСС', 1, 'АЛЕКСАНДРОВА О.М., ВЕРБИЦКАЯ Л.А., БОГДАНОВ С.И., КАЗАКОВА Е.И., КУЗНЕЦОВА М.И., ПЕТЛЕНКО Л.В., РОМАНОВА В.Ю., РЯБИНИНА Л.А., СОКОЛОВА О.В.', 0.00, 0.00, null, 2020.0000, 3, 2, 1, 442.20, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (73, 10, 'РУССКИЙ РОДНОЙ ЯЗЫК 5 КЛАСС', 1, 'АЛЕКСАНДРОВА О.М., ЗАГОРОВСКАЯ О.В., БОГДАНОВА С.И., ВЕРБИЦКАЯ Л.А., ГОСТЕВА Ю.Н., ДОБРОТИНА И.', 0.00, 0.00, null, 2020.0000, 3, 2, 1, 443.30, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (74, 11, 'РУССКИЙ РОДНОЙ ЯЗЫК 9 КЛАСС', 1, 'АЛЕКСАНДРОВА О.М., ЗАГОРОВСКАЯ О.В., БОГДАНОВА С.И., ВЕРБИЦКАЯ Л.А., ГОСТЕВА Ю.Н., ДОБРОТИНА И.', 0.00, 0.00, null, 2020.0000, 3, 2, 1, 443.30, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (75, 12, 'РУССКИЙ РОДНОЙ ЯЗЫК 6 КЛАСС', 1, 'АЛЕКСАНДРОВА О.М., ЗАГОРОВСКАЯ О.В., БОГДАНОВА С.И., ВЕРБИЦКАЯ Л.А., ГОСТЕВА Ю.Н., ДОБРОТИНА И., НАРУШЕВИЧ А.Г., КАЗАКОВА Е.И., ВАСИЛЬЕВЫХ И.П.', 0.00, 0.00, null, 2020.0000, 3, 2, 1, 443.30, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (76, 13, 'РУССКИЙ РОДНОЙ ЯЗЫК 7 КЛАСС', 1, 'АЛЕКСАНДРОВА О.М., ЗАГОРОВСКАЯ О.В., БОГДАНОВА С.И., ВЕРБИЦКАЯ Л.А., ГОСТЕВА Ю.Н., ДОБРОТИНА И., НАРУШЕВИЧ А.Г., КАЗАКОВА Е.И., ВАСИЛЬЕВЫХ И.П.', 0.00, 0.00, null, 2020.0000, 3, 2, 1, 443.30, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (77, 14, 'РУССКИЙ РОДНОЙ ЯЗЫК 8 КЛАСС', 1, 'АЛЕКСАНДРОВА О.М., ЗАГОРОВСКАЯ О.В., БОГДАНОВА С.И., ВЕРБИЦКАЯ Л.А., ГОСТЕВА Ю.Н., ДОБРОТИНА И., НАРУШЕВИЧ А.Г., КАЗАКОВА Е.И., ВАСИЛЬЕВЫХ И.П.', 0.00, 0.00, null, 2020.0000, 3, 2, 1, 443.30, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (78, 15, 'ГЕОГРАФИЯ 5-6 КЛАСС', 1, 'АЛЕКСЕЕВ А.И., НИКОЛИНА В.В., ЛИПКИНА Е.К.', 0.00, 0.00, null, 2020.0000, 3, 2, 1, 494.34, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (79, 16, 'ГЕОГРАФИЯ 7 КЛАСС', 1, 'АЛЕКСЕЕВ А.И., НИКОЛИНА В.В., ЛИПКИНА Е.К', 0.00, 0.00, null, 2020.0000, 3, 2, 1, 464.75, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (80, 17, 'ГЕОГРАФИЯ 8 КЛАСС', 1, 'АЛЕКСЕЕВ А.И., НИКОЛИНА В.В., ЛИПКИНА Е.К', 0.00, 0.00, null, 2020.0000, 3, 2, 1, 465.41, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (81, 18, 'ГЕОГРАФИЯ 9 КЛАСС', 1, 'АЛЕКСЕЕВ А.И., НИКОЛИНА В.В., ЛИПКИНА Е.К', 0.00, 0.00, null, 2020.0000, 3, 2, 1, 465.41, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (82, 19, 'ГЕОМЕТРИЯ 10-11 КЛАСС', 1, 'АТАНАСЯН Л.С., БУТУЗОВ В.Ф.,КАДОМЦЕВ С.Б.', 0.00, 0.00, null, 2020.0000, 3, 2, 1, 450.89, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (83, 20, 'ВСЕОБЩАЯ ИСТОРИЯ.НОВЕЙШЕЕ ВРЕМЯ 10 КЛАСС', 1, 'БЕЛОУСОВ Л.С., СМИРНОВ В.П., МЕЙЕР М.С.', 0.00, 0.00, null, 2020.0000, 3, 2, 1, 456.94, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (84, 21, 'ОБЩЕСТВОЗНАНИЕ 11 КЛАСС', 1, 'БОГОЛЮБОВ Л.Н., ГОРОДЕЦКАЯ Н.И., ЛАЗЕБНИКОВА А.Ю.', 0.00, 0.00, null, 2020.0000, 3, 2, 1, 443.19, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (85, 22, 'ОБЩЕСТВОЗНАНИЕ 10 КЛАСС', 1, 'БОГОЛЮБОВ Л.Н., ЛАЗЕБНИКОВА А.Ю., МАТВЕЕВ А.И.', 0.00, 0.00, null, 2020.0000, 3, 2, 1, 443.19, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (86, 23, 'ФИЗИЧЕСКАЯ КУЛЬТУРА 5-7 КЛАССЫ', 1, 'ВИЛЕНСКИЙ М.Я.', 0.00, 0.00, null, 2020.0000, 3, 2, 1, 414.59, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (87, 24, 'ПРОПИСИ 1 КЛАСС Ч.1', 2, 'ГОРЕЦКИЙ В.Г., ФЕДОСОВА Н.А.', 0.00, 0.00, null, 2020.0000, 3, 2, 1, 75.90, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (88, 25, 'ПРОПИСИ 1 КЛАСС Ч.2', 2, 'ГОРЕЦКИЙ В.Г., ФЕДОСОВА Н.А.', 0.00, 0.00, null, 2020.0000, 3, 2, 1, 75.90, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (89, 26, 'ПРОПИСИ 1 КЛАСС Ч.3', 2, 'ГОРЕЦКИЙ В.Г., ФЕДОСОВА Н.А.', 0.00, 0.00, null, 2020.0000, 3, 2, 1, 75.90, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (90, 27, 'ПРОПИСИ 1 КЛАСС Ч.4', 2, 'ГОРЕЦКИЙ В.Г., ФЕДОСОВА Н.А', 0.00, 0.00, null, 2020.0000, 3, 2, 1, 75.90, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (91, 28, 'МАТЕМАТИКА. РАБОЧАЯ ТЕТРАДЬ 1 КЛАСС Ч.1', 2, 'ДОРОФЕЕВ Г.В., МИРАКОВА Т.Н., БУКА Т.Б.', 0.00, 0.00, null, 2019.0000, 3, 2, 1, 148.50, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (92, 29, 'МАТЕМАТИКА. РАБОЧАЯ ТЕТРАДЬ 1 КЛАСС Ч.2', 2, 'ДОРОФЕЕВ Г.В., МИРАКОВА Т.Н., БУКА Т.Б', 0.00, 0.00, null, 2019.0000, 3, 2, 1, 148.50, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (93, 30, 'ТЕХНОЛОГИЯ. 6 КЛАСС', 1, 'КАЗАКЕВИЧ В.М., ПИЧУГИН Г.В., СЕМЕНОВА Г.Ю.', 0.00, 0.00, null, 2020.0000, 3, 2, 1, 356.95, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (94, 31, 'ТЕХНОЛОГИЯ 7 КЛАСС', 1, 'КАЗАКЕВИЧ В.М., ПИЧУГИНА Г.В., СЕМЕНОВА Г.Ю.', 0.00, 0.00, null, 2020.0000, 3, 2, 1, 357.72, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (95, 32, 'ТЕХНОЛОГИЯ 5 КЛАСС', 1, 'КАЗАКЕВИЧ В.М., ПИЧУГИНА Г.В., СЕМЕНОВА Г.Ю.', 0.00, 0.00, null, 2020.0000, 3, 2, 1, 356.95, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (96, 33, 'ТЕХНОЛОГИЯ 8-9 КЛАССЫ', 1, 'КАЗАКЕВИЧ В.М., ПИЧУГИНА Г.В., СЕМЕНОВА Г.Ю.', 0.00, 0.00, null, 2020.0000, 3, 2, 1, 375.65, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (97, 34, 'РУССКИЙ ЯЗЫК 2 КЛАСС Ч.1', 1, 'КАНАКИНА В.П., ГОРЕЦКИЙ В.Г.', 0.00, 0.00, null, 2020.0000, 3, 2, 1, 382.80, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (98, 35, 'РУССКИЙ ЯЗЫК 2 КЛАСС Ч.2', 1, 'КАНАКИНА В.П., ГОРЕЦКИЙ В.Г.', 0.00, 0.00, null, 2020.0000, 3, 2, 1, 382.80, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (99, 36, 'ЛИТЕРАТУРНОЕ ЧТЕНИЕ 2 КЛАСС Ч.1', 1, 'КЛИМАНОВА Л.Ф., ГОРЕЦКИЙ В.Г., ГОЛОВАНОВА М.В.', 0.00, 0.00, null, 2020.0000, 3, 2, 1, 393.80, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (100, 37, 'ЛИТЕРАТУРНОЕ ЧТЕНИЕ 2 КЛАСС Ч.2', 1, 'КЛИМАНОВА Л.Ф., ГОРЕЦКИЙ В.Г., ГОЛОВАНОВА М.В.', 0.00, 0.00, null, 2020.0000, 3, 2, 1, 393.80, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (101, 38, 'ЛИТЕРАТУРА. 10 КЛАСС. Ч.1', 1, 'ЛЕБЕДЕВ Ю.В., РОМАНОВА А.М., СМИРНОВА Л.Н.', 0.00, 0.00, null, 2020.0000, 3, 2, 1, 376.20, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (102, 39, 'ЛИТЕРАТУРА 10 КЛАСС Ч.2', 1, 'ЛЕБЕДЕВ Ю.В., РОМАНОВА А.М., СМИРНОВА Л.Н.', 0.00, 0.00, null, 2020.0000, 3, 2, 1, 376.20, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (103, 40, 'ТЕХНОЛОГИЯ 1 КЛАСС', 1, 'ЛУТЦЕВА Е.А., ЗУЕВА Т.П.', 0.00, 0.00, null, 2020.0000, 3, 2, 1, 365.64, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (104, 41, 'ТЕХНОЛОГИЯ 2 КЛАСС', 1, 'ЛУТЦЕВА Е.А., ЗУЕВА Т.П.', 0.00, 0.00, null, 2020.0000, 3, 2, 1, 389.18, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (105, 42, 'ФИЗИЧЕСКАЯ КУЛЬТУРА 8-9 КЛАССЫ', 1, 'ЛЯХ В.И.', 0.00, 0.00, null, 2020.0000, 3, 2, 1, 415.47, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (106, 43, 'РУССКИЙ РОДНОЙ ЯЗЫК 1 КЛАСС', 1, 'АЛЕКСАНДРОВА О.М., ВЕРБИЦКАЯ Л.А., БОГДАНОВ С.И., КАЗАКОВА Е.И., КУЗНЕЦОВА М.И., ПЕТЛЕНКО Л.В., В.Ю.', 0.00, 0.00, null, 2020.0000, 3, 2, 1, 442.20, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (107, 44, 'БИОЛОГИЯ 8 КЛАСС', 1, 'ПАСЕЧНИК В.В., КАМЕНСКИЙ А.А., ШВЕЦОВ Г.Г.', 0.00, 0.00, null, 2020.0000, 3, 2, 1, 444.07, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (108, 45, 'БИОЛОГИЯ 9 КЛАСС', 1, 'ПАСЕЧНИК В.В., КАМЕНСКИЙ А.А., ШВЕЦОВ Г.Г.', 0.00, 0.00, null, 2020.0000, 3, 2, 1, 444.07, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (109, 46, 'БИОЛОГИЯ 7 КЛАСС', 1, 'ПАСЕЧНИК В.В., СУМАТОХИН С.В., КАЛИНОВА Г.С.', 0.00, 0.00, null, 2020.0000, 3, 2, 1, 444.07, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (110, 47, 'БИОЛОГИЯ 5-6 КЛАССЫ', 1, 'ПАСЕЧНИК В.В., СУМАТОХИН С.В., КАЛИНОВА Г.С.', 0.00, 0.00, null, 2020.0000, 3, 2, 1, 438.02, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (111, 48, 'ОКРУЖАЮЩИЙ МИР 2 КЛАСС Ч.1', 1, 'ПЛЕШАКОВ А.А.', 0.00, 0.00, null, 2020.0000, 3, 2, 1, 365.20, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (112, 49, 'ОКРУЖАЮЩИЙ МИР 2 КЛАСС Ч.2', 1, 'ПЛЕШАКОВ А.А.', 0.00, 0.00, null, 2020.0000, 3, 2, 1, 365.20, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (113, 50, 'ЛИТЕРАТУРА 11 КЛАСС Ч.1', 1, 'МИХАЙЛОВ О.Н., ШАЙТАНОВ И.О., ЧАЛМАЕВ В.А.', 0.00, 0.00, null, 2020.0000, 3, 2, 1, 376.20, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (114, 51, 'ЛИТЕРАТУРА 11 КЛАСС Ч.2', 1, 'МИХАЙЛОВ О.Н., ШАЙТАНОВ И.О., ЧАЛМАЕВ В.А.', 0.00, 0.00, null, 2020.0000, 3, 2, 1, 376.20, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (115, 52, 'ГЕОГРАФИЯ 5 КЛАСС. КОНТУРНЫЕ КАРТЫ.', 2, 'НЕ УКАЗАНО', 0.00, 0.00, null, 2020.0000, 6, 2, 1, 47.00, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (116, 53, 'ГЕОГРАФИЯ 6 КЛАСС. КОНТУРНЫЕ КАРТЫ', 2, 'НЕ УКАЗАНО', 0.00, 0.00, null, 2020.0000, 6, 2, 1, 47.00, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (117, 54, 'ГЕОГРАФИЯ 7 КЛАСС. КОНТУРНЫЕ КАРТЫ', 2, 'НЕ УКАЗАНО', 0.00, 0.00, null, 2020.0000, 6, 2, 1, 47.00, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (118, 55, 'ГЕОГРАФИЯ 8 КЛАСС. КОНТУРНЫЕ КАРТЫ', 2, 'НЕ УКАЗАНО', 0.00, 0.00, null, 2020.0000, 6, 2, 1, 47.00, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (119, 56, 'ГЕОГРАФИЯ 9 КЛАСС. КОНТУРНЫЕ КАРТЫ', 2, 'НЕ УКАЗАНО', 0.00, 0.00, null, 2020.0000, 6, 2, 1, 47.00, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (120, 57, 'АНГЛИЙСКИЙ ЯЗЫК. RAINBOW ENGLISH 2 КЛАСС. РАБОЧАЯ ТЕТРАДЬ', 2, 'АФАНАСЬЕВА О.В., МИХЕЕВА И.В.', 0.00, 0.00, null, 2020.0000, 6, 2, 1, 234.00, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (121, 58, 'ХИМИЯ 8 КЛАСС', 1, 'ЕРЕМИН В.В., ДРОЗДОВ А.А, КУЗЬМЕНКО Н.Е., ЛУНИН В.В', 0.00, 0.00, null, 2020.0000, 6, 2, 1, 452.00, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (122, 59, 'ХИМИЯ 9 КЛАСС', 1, 'ЕРЕМИН В.В., КУЗЬМЕНКО Н.Е., ДРОЗДОВ А.А.', 0.00, 0.00, null, 2020.0000, 6, 2, 1, 452.00, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (123, 60, 'ОБЖ 5-6 КЛАССЫ', 1, 'ВИНОГРАДОВА Н.Ф., СМИРНОВ Д.В., СИДОРЕНКО Л.В., ТАРАНИН А.Б.', 0.00, 0.00, null, 2020.0000, 8, 2, 1, 0.00, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (124, 61, 'РУССКИЙ ЯЗЫК 3 КЛАСС Ч.1', 1, 'ИВАНОВ С.В., ЕВДОКИМОВА А.О.,КУЗНЕЦОВА М.И.', 0.00, 0.00, null, 2020.0000, 8, 2, 1, 0.00, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (125, 62, 'РУССКИЙ ЯЗЫК 3 КЛАСС Ч.2', 1, 'ИВАНОВ С.В., ЕВДОКИМОВА А.О.,КУЗНЕЦОВА М.И.', 0.00, 0.00, null, 2020.0000, 8, 2, 1, 0.00, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (126, 63, 'РУССКИЙ ЯЗЫК 4 КЛАСС Ч.1', 1, 'ИВАНОВ С.В., КУЗНЕЦОВА М.И., ПЕТЛЕНКО Л.В., РОМАНОВА В.Ю.', 0.00, 0.00, null, 2020.0000, 8, 2, 1, 0.00, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (127, 64, 'РУССКИЙ ЯЗЫК 4 КЛАСС Ч.2', 1, 'ИВАНОВ С.В., КУЗНЕЦОВА М.И., ПЕТЛЕНКО Л.В., РОМАНОВА В.Ю.', 0.00, 0.00, null, 2020.0000, 8, 2, 1, 0.00, 0);
INSERT INTO books (id, code, name, book_type_id, author, class_from, class_to, subject_id, year, publisher_id, owner_id, ownership, price, is_deleted) VALUES (128, 65, 'ИСТОРИЯ РОССИИ ДО 1914 ГОДА. 11 КЛАСС', 1, 'КИРИЛЛОВ В.В., БРАВИНА М.А.', 0.00, 0.00, null, 2020.0000, 11, 2, 1, 484.00, 0);

