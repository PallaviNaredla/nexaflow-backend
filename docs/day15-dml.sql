INSERT INTO users (user_id, name, email, age)
VALUES (1, 'Pallavi', 'pallavi@example.com', 21);

INSERT INTO products
(product_id, product_name, price, available_quantity)
VALUES
    (101, 'Laptop', 75000, 10);

INSERT INTO products
(product_id, product_name, price, available_quantity)
VALUES
    (102, 'Mouse', 500, 50);

INSERT INTO products
(product_id, product_name, price, available_quantity)
VALUES
    (103, 'Keyboard', 1500, 25);

INSERT INTO nf_orders (order_id, user_id)
VALUES (1001, 1);

INSERT INTO order_items
(order_item_id, order_id, product_id, quantity, unit_price)
VALUES
    (1, 1001, 101, 1, 75000);

INSERT INTO order_items
(order_item_id, order_id, product_id, quantity, unit_price)
VALUES
    (2, 1001, 102, 2, 500);


SELECT * FROM users;

SELECT * FROM products;

SELECT * FROM nf_orders;

SELECT * FROM order_items;



SELECT order_id,
       SUM(quantity * unit_price) AS order_total
FROM order_items
GROUP BY order_id;


SELECT product_name, price
FROM products
WHERE price > 1000;


SELECT *
FROM nf_orders
WHERE user_id = 1;




UPDATE products
SET price = 550
WHERE product_id = 102;




SELECT * FROM products
WHERE product_id = 102;



DELETE FROM order_items
WHERE order_item_id = 2;



