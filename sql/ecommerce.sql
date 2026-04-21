-- SQL -> Structured Query Language --
-- Yapılandırılmış Sorgu Dili --


-- DDL --
-- Data Definition Language --
-- Verinin tanımıyla ilgili olan kodlardır --
-- Tablo oluşturma, tablo güncelleme, kolon ekleme, kolonun tipini belirleme, FK belirleme vb. --

CREATE DATABASE eticaret;

CREATE TABLE users(
	-- isim tür(SINIR) özel-durumlar
	id SERIAL PRIMARY KEY, --SERIAL: otomatik artan numara demektir postgreSQL'e özeldir
	name VARCHAR(100) NOT NULL,  -- varsayılan olarak her metinsel alan nullabledir
	surname VARCHAR(100) NOT NULL,
	email VARCHAR(100) UNIQUE NOT NULL,
	password VARCHAR(100) NOT NULL,
	register_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP 
);

CREATE TABLE carts(
	id SERIAL PRIMARY KEY,
	user_id INTEGER UNIQUE NOT NULL, -- SERIAL'ı başka yerde tanımlarken INTEGER kullanılır
	-- FOREIGN KEY (bu_tablo_FK) REFERENCES (diğer_tablo)(diğer_tablo_PK)
	FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Yeni eklenen alanlar daima ya DEFAULT ya da NULLABLE olur.
ALTER TABLE users ADD COLUMN gsm VARCHAR(20); -- Tablo var, kolon yok

ALTER TABLE users ALTER COLUMN gsm SET NOT NULL; -- Tablo var, kolon var
-- Eklerken daha önce veriler olduğu için not null ayarlayamayız ama daha sonra düzenlerken yapabiliriz


-- DML --
-- Data Manipulation Language --
-- Veri silmek, güncellemek, yeni veri eklemek, veriyi sorgulamak vb. --

-- Insert 
INSERT INTO users(name, surname, email, password, gsm) 
VALUES ('Ayşe','Ulaşlı','ayse@gmail.com', 'ayse27*', '+90');
--

-- UPDATE
Update users SET gsm = '+90535', surname = 'Abc'
WHERE id = 1; --sorgu
--

-- UPDATE ve DELETE'de sorgu vermeden çalıştırırsan tüm veriyi etkiler

-- DELETE -> Bağlı olduğum bir FK varsa o PK'lı veri silinemez! önce bağlı veriler silinmeli
DELETE FROM users 
where id = 1;
--

-- SELECT [istenilen_kolonlar] FROM [tablo_adı]
SELECT * FROM users;
-- * -> ALL columns
Select id,name from users;

Select * from users WHERE name='Ayşe';

-- Asc -> Ascending (küçükten büyüğe , a-z)
-- Desc -> Descending (büyükten küçüğe , z-a)
Select * from users ORDER BY register_date desc;

ALTER TABLE users ADD COLUMN age int;

UPDATE users set age=25 where id = 1

Select * from users ORDER BY age asc;

Select * from users ORDER BY name desc;

-- Aggregate Func.
-- Bir tablodaki veri sayısını
SELECT COUNT(*) from users
-- Bir kolondaki min değeri al
SELECT MIN(age) from users
-- Bir kolondaki max değeri al
SELECT MAX(age) from users
-- Bir kolondaki ortala değeri al
SELECT AVG(age) from users
-- Bir kolondaki tüm değerli topla
SELECT SUM(age) from users

-- Kalıp
-- Sembol 1 -> % -> Burdan sonra,önce kaç harf, hangi harf olduğunu umursamıyorum..

-- Hi ile başlayan isimler
Select * from users WHERE name LIKE 'Hi%'

-- İçinde "i" geçen isimler
Select * from users WHERE name LIKE '%i%'

-- "t" ile biten isimler
Select * from users WHERE name LIKE '%t'


-- Sembol 2 -> _ -> Burdan sonra,önce sadece "hangi" harf olduğunu umursamıyorum..
  
-- Sondan bir önceki harfi "a" olan isimler.
Select * from users WHERE name LIKE '%a_'

---

Select * from users WHERE LOWER(name) LIKE LOWER('%AL%')


Select * from users WHERE name ILIKE '%AL%'