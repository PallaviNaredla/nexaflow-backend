-- NexaFlow Database Design
-- Oracle SQL

CREATE TABLE users (
                       user_id NUMBER PRIMARY KEY,
                       name VARCHAR2(100) NOT NULL,
                       email VARCHAR2(150) UNIQUE NOT NULL,
                       age NUMBER
);

CREATE TABLE products (
                          product_id NUMBER PRIMARY KEY,
                          product_name VARCHAR2(150) NOT NULL,
                          price NUMBER(10,2) NOT NULL,
                          available_quantity NUMBER NOT NULL,
                          CONSTRAINT chk_product_price CHECK (price > 0),
                          CONSTRAINT chk_product_qty CHECK (available_quantity >= 0)
);

CREATE TABLE nf_orders (
                           order_id NUMBER PRIMARY KEY,
                           user_id NUMBER NOT NULL,
                           order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                           CONSTRAINT fk_nf_order_user
                               FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE order_items (
                             order_item_id NUMBER PRIMARY KEY,
                             order_id NUMBER NOT NULL,
                             product_id NUMBER NOT NULL,
                             quantity NUMBER NOT NULL CHECK (quantity > 0),
                             unit_price NUMBER(10,2) NOT NULL CHECK (unit_price > 0),
                             CONSTRAINT fk_item_nf_order
                                 FOREIGN KEY (order_id) REFERENCES nf_orders(order_id),
                             CONSTRAINT fk_item_product
                                 FOREIGN KEY (product_id) REFERENCES products(product_id)
);