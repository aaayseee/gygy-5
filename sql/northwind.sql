-- Alias -> Takma ad
Select * from customers c where contact_name LIKE '%a%';


-- Joinler 
Select * from orders o -- başlangıç sol tablodur
inner join customers c -- join demek başka bir tabloya katılmak demektir
on o.customer_id = c.customer_id

-- inner join -- iki tablonun kesiştiği noktayı al demek
-- left join -- sol tablonun tamamını ve kesişimi alır
-- right join -- sağ tablonun tamamını ve kesişimi alır


Select * from orders o
right join customers c
on o.customer_id = c.customer_id
--

Select * from customers c

INSERT INTO customers(customer_id, company_name, contact_name, contact_title, address, city, postal_code,country,phone,fax)
VALUES ('HALIT', 'Deneme', 'Halit Kalaycı', 'Abc','Abc','İstanbul','34788','Türkiye','+90', 'abc')


--

Select * from orders o
inner join employees e
on o.employee_id = e.employee_id

--

Select * from orders o
inner join customers c 
on o.customer_id = c.customer_id
inner join order_details od 
on o.order_id = od.order_id
inner join products p
on od.product_id = p.product_id
where od.quantity > 10
order by c.contact_name

-- Group BY -- gruplandırarak sıralar
Select c.country from customers c
GROUP BY c.country -- group by yapınca select kısmında * yapamazsın group by yaptığın kısmı seçebilirsin

Select c.country, c.city, COUNT(*) from customers c
GROUP BY c.country, c.city

Select c.country, COUNT(*) from customers c
GROUP BY c.country
ORDER BY COUNT(*) DESC -- order by özelliğe yani kolona göre sırayı düzenler 
--

Select * from customers

Select * from shippers
-- 
Select s.company_name, COUNT(*) from shippers s
inner join orders o 
on s.shipper_id = o.ship_via
GROUP BY s.shipper_id, s.company_name

Select s.company_name, COUNT(o.order_id) from shippers s
left join orders o 
on s.shipper_id = o.ship_via
GROUP BY s.shipper_id, s.company_name
HAVING COUNT(o.order_id) > 250 -- group by kullanırken where kelimesi having e dönüşür
ORDER BY COUNT(o.order_id) DESC
--

-- Hangi müşteriler 10'dan fazla sipariş vermiş?
Select c.contact_name, COUNT(*) as total_orders from customers c
JOIN orders o on c.customer_id = o.customer_id -- direkt join yazarsan default inner joindir
GROUP BY c.customer_id , c.contact_name
HAVING COUNT(*) > 10 -- filtreleme seçimden önce çalışır o yüzden burda total_orders kullanamadık
ORDER BY total_orders DESC
--


-- Toplam Cirosu 50k'dan büyük müşteriler

SELECT c.customer_id, c.company_name, SUM(od.unit_price * od.quantity) AS total_revenue FROM customers c
INNER JOIN orders o 
ON c.customer_id = o.customer_id
INNER JOIN order_details od 
ON o.order_id = od.order_id
GROUP BY c.customer_id, c.company_name
HAVING SUM(od.unit_price * od.quantity) > 50000
ORDER BY total_revenue DESC

--

-- Her kategori için en az 5 farklı ürün satan kategoriler

SELECT c.category_id, c.category_name, COUNT(DISTINCT od.product_id) AS product_count FROM categories c
INNER JOIN products p ON c.category_id = p.category_id
INNER JOIN order_details od ON p.product_id = od.product_id
GROUP BY c.category_id, c.category_name
HAVING COUNT(DISTINCT od.product_id) >= 5;

--

-- Çalışan bazlı toplam satış tutarı (birim fiyatı)

SELECT e.employee_id, e.first_name, e.last_name, SUM(od.unit_price * od.quantity) AS total_sales FROM employees e
INNER JOIN orders o 
ON e.employee_id = o.employee_id
INNER JOIN order_details od 
ON o.order_id = od.order_id
GROUP BY e.employee_id, e.first_name, e.last_name
ORDER BY total_sales DESC;
--- 

-- Sayfalama
SELECT * from products p
LIMIT 10 --  tane göster
--
Select * from products p
LIMIT 10 OFFSET 5 -- ilk 5 ini atla 
--

-- 1- Sayfa boyutu? 
-- 2- Aktif sayfa?
-- 1. sayfa, sayfa başı 10 element

-- LIMIT {sayfa_başı_element} OFFSET {(aktif_sayfa-1) * sayfa_başı_element}
Select * from products p
LIMIT 10 OFFSET 0

Select * from products p
LIMIT 10 OFFSET 10