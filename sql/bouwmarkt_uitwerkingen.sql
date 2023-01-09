DELETE FROM klant;
DELETE FROM product;
DELETE FROM filiaal;
DELETE FROM transactie;
DELETE FROM aankoop;

INSERT INTO klant (klantnummer)
VALUES (432210);

INSERT INTO klant (klantnummer, naam, adres, woonplaats)
VALUES (432211, 'Kees', 'Kerkstraat 12', 'Groningen'),
	   (432212, 'Pieter', 'Bergpad 5', 'Maastricht');
	   
INSERT INTO filiaal (filiaalnummer, plaats, adres)
VALUES (12, 'Amsterdam', 'Buitenweg 1'),
	   (24, 'Utrecht', 'Atoomweg 41'),
	   (36, 'Groningen', 'Burgerstraat 90');

INSERT INTO product(productnummer, omschrijving, prijs)
VALUES (1, 'Plank', 6.99),
	   (2, 'Spijkers', 2.69),
	   (3, 'Schroeven', 3.35),
	   (4, 'Hamer', 2.99),
	   (5, 'Boormachine', 24.49);
	   
INSERT INTO transactie(transactienummer, datum, tijd, klantnummer, filiaalnummer)
VALUES(12000001, '2022-11-1', '15:45', 432210, 12),
	  (24000001, '2022-12-3', '12:25', 432212, 24),
	  (36000001, '2022-12-6', '10:30', 432211, 36),
	  (36000002, '2022-12-6', '12:30', 432211, 36);
	  
INSERT INTO aankoop(transactienummer, product, aantal)
VALUES(12000001, 1, 5),
	  (12000001, 2, 1),
	  (12000001, 4, 1),
	  (24000001, 1, 12),
	  (24000001, 3, 2),
	  (24000001, 5, 1),
	  (36000001, 1, 2),
	  (36000001, 3, 2);
	   
-- 1 november 15:45, Clara(anoniem) Amsterdam: 5 planken, 1 spijkers, 1 hamer
-- 3 december 12:25, Pieter, 		Utrecht: 12 planken, 2 schroeven, 1 boormachine
-- 6 december 10:30, Kees, 			Groningen: 2 planken
--			  12:30, Kees,			Groningen: 2 schroeven