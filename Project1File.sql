create database Ecommerce;
use Ecommerce;

create table supplier
(
    suppId int primary key,
    suppName varchar(50) not null,
    suppCity  varchar(50) not null,
    suppphone varchar(50) not null
);


create table customer
(
   custId int primary key,
   custName varchar(20) not null,
   custCity varchar(10) not null,
   custPhone varchar(30) not null,
   custGender char
);

create table category
(
  catId int primary key,
  catName varchar(20) not null
);

create table product
(
  prodId int primary key,
  prodName varchar(20) not null default 'Dummy',
  prodDesc varchar(60) not null,
  catId int,
  constraint pck1 foreign key(catId) references category(catId)
);


create table supplier_pricing
(
  pricingId int primary key,
  prodId int,
  suppId int,
  suppPrice int default 0,
  constraint spk1 foreign key(prodId) references product(prodId),
   constraint ssk1 foreign key(suppId) references supplier(suppId)
);

create table Orders
(
   ordId int primary key,
   ordAmount int not null,
   ordDate date not null,
   custId int,
   pricingId int,
   constraint ock1 foreign key(custId) references customer(custId),
   constraint opk1 foreign key(pricingId) references supplier_pricing(pricingId)
);

create table Rating
(
  ratId int primary key,
  ordId int,
  ratStars int not null,
  constraint rok1 foreign key(ordId) references orders(ordId)
);


insert into supplier
values
(1, 'RajeshRetails', 'Delhi', '1234567890'),
(2, 'Appario Ltd.', 'Mumbai', '2589631470'),
(3, 'Knome products', 'Banglore', '9785462315'),
(4, 'Bansal Retails', 'Kochi', '8975463285'),
(5, 'Mittal Ltd.', 'Lucknow', '7898456532');

insert into customer
values
(1, 'AAKASH', '9999999999', 'DELHI', 'M'),
(2, 'AMAN', '9785463215', 'NOIDA', 'M'),
(3, 'NEHA', '9999999999', 'MUMBAI', 'F'),
(4, 'MEGHA', '9994562399', 'KOLKATA', 'F'),
(5, 'PULKIT', '7895999999', 'LUCKNOW', 'M');

insert into category
values
(1, 'BOOKS'),
(2, 'GAMES'),
(3, 'GROCERIES'),
(4, 'ELECTRONICS'),
(5, 'CLOTHES');

insert into product
values
(1, 'GTA V', 'Windows 7 and above with i5 processor and 8GB RAM', 2),
(2, 'TSHIRT', 'SIZE-L with Black, Blue and White variations', 5),
(3, 'ROG LAPTOP', 'Windows 10 with 15inch screen, i7 processor, 1TB SSD', 4),
(4, 'OATS', 'Highly Nutritious from Nestle', 3),
(5, 'HARRY POTTER', 'Best Collection of all time by J.K Rowling', 1),
(6, 'MILK', '1L Toned MIlk', 3),
(7, 'Boat Earphones', '1.5Meter long Dolby Atmos', 4),
(8, 'Jeans', 'Stretchable Denim Jeans with various sizes and color', 5),
(9, 'Project IGI', 'compatible with windows 7 and above', 2),
(10, 'Hoodie', 'Black GUCCI for 13 yrs and above', 5),
(11, 'Rich Dad Poor Dad', 'Written by RObert Kiyosaki', 1),
(12, 'Train Your Brain', 'By Shireen Stephen', 1);

insert into supplier_pricing
values
(1, 1, 2, 1500),
(2, 3, 5, 30000),
(3, 5, 1, 3000),
(4, 2, 3, 2500),
(5, 4, 1, 1000),
(6, 12, 2, 780),
(7, 12, 4, 789),
(8, 3, 1, 31000),
(9, 1, 5, 1450),
(10, 4, 2, 999),
(11, 7, 3, 549),
(12, 7, 4, 529),
(13, 6, 2, 105),
(14, 6, 1, 99),
(15, 2, 5, 2999),
(16, 5, 2, 2999);

insert into orders
values
(101, 1500, '2021-10-06', 2, 1),
(102, 1000, '2021-10-12', 3, 5),
(103, 30000, '2021-09-16', 5, 2),
(104, 1500, '2021-10-05', 1, 1),
(105, 3000, '2021-08-16', 4, 3),
(106, 1450, '2021-08-18', 1, 9),
(107, 789, '2021-09-01', 3, 7),
(108, 780, '2021-09-07', 5, 6);

insert into orders
values
(109, 3000, '2021-09-10', 5, 3),
(110, 2500, '2021-09-10', 2, 4),
(111, 1000, '2021-09-15', 4, 5),
(112, 789, '2021-09-16', 4, 7),
(113, 31000, '2021-09-16', 1, 8),
(114, 1000, '2021-09-16', 3, 5),
(115, 3000, '2021-09-16', 5, 3),
(116, 99, '2021-09-17', 2, 14);

insert into rating
values
(1, 101, 4),
(2, 102, 3),
(3, 103, 1),
(4, 104, 2),
(5, 105, 4),
(6, 106, 3),
(7, 107, 4),
(8, 108, 4),
(9, 109, 3),
(10, 110, 5),
(11, 111, 3),
(12, 112, 4),
(13, 113, 2),
(14, 114, 1),
(15, 115, 1),
(16, 116, 0);

select*from supplier;
select*from customer;
select*from category;
select*from product;
select*from supplier_pricing;
select*from rating;

#Query to display the total number of customers based on gender who have placed individual orders of worth at least Rs.3000
SELECT c.custGender, COUNT(DISTINCT c.custID) AS totalCustomers
FROM customer c
JOIN supplier_pricing sp ON c.custID = sp.prodID
WHERE sp.suppPRICE >= 3000
GROUP BY c.custGender
HAVING COUNT(DISTINCT c.custID) > 0;

#Query to display all the orders along with product name ordered by a customer having Customer_Id=2
SELECT o.ordId, p.prodName, o.ordAmount, o.ordDate
FROM Orders o
JOIN product p ON o.pricingId = p.prodId
WHERE o.custId = 2;

#query to display the Supplier details who can supply more than one product.
SELECT s.suppId, s.suppName, s.suppCity, s.suppphone
FROM supplier s
JOIN supplier_pricing sp ON s.suppId = sp.suppId
GROUP BY s.suppId, s.suppName, s.suppCity, s.suppphone
HAVING COUNT(DISTINCT sp.prodId) > 1;

#Query to create a view as lowest_expensive_product and display the least expensive product from each category and print the table
#with category id, name, product name and price of the product.
CREATE VIEW lowest_expensive_product AS
SELECT c.catId, c.catName, p.prodName, sp.suppPrice
FROM category c
JOIN product p ON c.catId = p.catId
JOIN supplier_pricing sp ON p.prodId = sp.prodId
WHERE sp.suppPrice = (
  SELECT MIN(suppPrice)
  FROM supplier_pricing
  WHERE prodId = p.prodId
)
ORDER BY c.catId;
select*from lowest_expensive_product;

#Query to display the Id and Name of the Product ordered after “2021-10-05”
SELECT p.prodId, p.prodName
FROM product p
JOIN supplier_pricing sp ON p.prodId = sp.prodId
JOIN orders o ON sp.pricingId = o.pricingId
WHERE o.ordDate > '2021-10-05';

#query to display customer name and gender whose names start or end with character 'A'.
select custName as 'customer Name', custGender as 'gender' from customer where custName like 'A%' or custName like '%A';

#Query to create a stored procedure to display supplier id, name, Rating(Average rating of all the products sold by every customer) and
#Type_of_Service. For Type_of_Service, If rating =5, print “Excellent Service”,If rating >4 print “Good Service”, If rating >2 print
#“Average Service” else print “Poor Service”. Note that there should be one rating per supplier;

delimiter $$
use Ecommerce $$
CREATE PROCEDURE display_supplier_ratings()
BEGIN
    SELECT s.suppId, s.suppName, AVG(r.ratStars) AS Rating,
        CASE 
            WHEN AVG(r.ratStars) = 5 THEN 'Excellent Service'
            WHEN AVG(r.ratStars) > 4 THEN 'Good Service'
            WHEN AVG(r.ratStars) > 2 THEN 'Average Service'
            ELSE 'Poor Service'
        END AS Type_of_Service
    FROM supplier s
    JOIN supplier_pricing sp ON s.suppId = sp.suppId
    JOIN orders o ON sp.pricingId = o.pricingId
    JOIN rating r ON o.ordId = r.ordId
    GROUP BY s.suppId;
END;
call display_supplier_info;