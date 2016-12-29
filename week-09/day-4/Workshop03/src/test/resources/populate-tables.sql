INSERT INTO customers (name) values ('Marcio');  --id=1
INSERT INTO customers (name) values ('Jonas');   --id=2
INSERT INTO customers (name) values ('Laura');   --id=3
INSERT INTO customers (name) values ('Scarlet'); --id=4
INSERT INTO customers (name) values ('Bishop');  --id=5

INSERT INTO phone_numbers (value) values ('123456');  --id=1
INSERT INTO phone_numbers (value) values ('898765');  --id=2
INSERT INTO phone_numbers (value) values ('333333');  --id=3
INSERT INTO phone_numbers (value) values ('555555');  --id=4
INSERT INTO phone_numbers (value) values ('777777');  --id=5
INSERT INTO phone_numbers (value) values ('888888');  --id=6

INSERT INTO customers_phones (customers_id, phone_numbers_id) values (1,1);
INSERT INTO customers_phones (customers_id, phone_numbers_id) values (1,4);
INSERT INTO customers_phones (customers_id, phone_numbers_id) values (3,1);
INSERT INTO customers_phones (customers_id, phone_numbers_id) values (3,6);

INSERT INTO products (name) values ('Java Book');  --id=1
INSERT INTO products (name) values ('Baby Pram');  --id=2
INSERT INTO products (name) values ('Ice Cream');  --id=3
INSERT INTO products (name) values ('Pop Corn');   --id=4
INSERT INTO products (name) values ('Mazda 3');    --id=5

INSERT INTO orders (created_at, customer_id) values (NOW(), 2);

INSERT INTO items (order_id, product_id, quantity) values (1,1,5);
INSERT INTO items (order_id, product_id, quantity) values (1,2,3);
INSERT INTO items (order_id, product_id, quantity) values (1,5,2);