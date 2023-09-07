CREATE TABLE IF NOT EXISTS `users`
(
    `id`       INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(50) NOT NULL,
    `email`    VARCHAR(100),
    `password` VARCHAR(100) NOT NULL,
    `role`     VARCHAR(10) NOT NULL
);
-- Chèn dữ liệu vào bảng users
INSERT INTO users (id, username, email, password, role)
VALUES
    (1, 'user1', 'user1@example.com', '$2a$12$CJm6UGbeLXAM2BasuvunF.w6oerpQJ1KSeIVLeyJyDbIOOXRDAjTK', 'user'),
    (2, 'user2', 'user2@example.com', '$2a$12$6AVUVOU8zUqHyg5o2OjRAeDfBdiM3p4EnH89MtATI9Gf6aKRdB5Se', 'user'),
    (3, 'admin', 'admin@example.com', '$2a$12$2fu2njqQCiKwjlmYnfiBm.uG9CmYDmJLea0Hbx2EfZQmSrknilw/a', 'admin');

CREATE TABLE IF NOT EXISTS `contact_user`
(
    `id`           INT PRIMARY KEY AUTO_INCREMENT,
    `full_name`   VARCHAR(100) NOT NULL,
    `image_url`    VARCHAR(100),
    `city`         VARCHAR(200),
    `province`     VARCHAR(200),
    `town`         VARCHAR(200),
    `street`       VARCHAR(200),
    `phone_number` VARCHAR(20),
    `user_id`      INT,
    `total_order`  int
);
-- Chèn dữ liệu vào bảng contact_user
INSERT INTO contact_user (id, full_name, city, province, town, street, phone_number, user_id, total_order)
VALUES
    (1,'Le quoc anh', 'Hanoi', 'Hanoi', 'Hai Ba Trung', '123 Street', '1234567890', 1, 5),
    (2,'nguyen thanh loan', 'Ho Chi Minh', 'Ho Chi Minh', 'District 1', '456 Street', '9876543210', 2, 3);

CREATE TABLE IF NOT EXISTS `cart`
(
    `id`         INT PRIMARY KEY AUTO_INCREMENT,
    `user_id`    INT,
    `product_id` INT,
    `quantity`   INT
);
-- Chèn dữ liệu vào bảng cart
INSERT INTO cart (id, user_id, product_id, quantity)
VALUES
    (1, 1, 1, 2),
    (2, 1, 3, 1),
    (3, 2, 2, 3);

CREATE TABLE IF NOT EXISTS `products`
(
    `id`             INT PRIMARY KEY AUTO_INCREMENT,
    `name`           VARCHAR(200),
    `price`          DECIMAL(10, 2),
    `description`    VARCHAR(255),
    `image_url`      VARCHAR(200),
    `created_date`   TIMESTAMP,
    `quantity`       int,
    `product_detail_id` Int,
    `cat_id`         int
);
-- Chèn dữ liệu vào bảng products
INSERT INTO products (id, name, price, description, image_url, created_date, quantity, product_detail_id, cat_id)
VALUES
    (1, 'Product 1', 100.00, 'Description 1', 'image1.jpg', NOW(), 10, 1, 1),
    (2, 'Product 2', 200.00, 'Description 2', 'image2.jpg', NOW(), 20, 2, 2),
    (3, 'Product 3', 150.00, 'Description 3', 'image3.jpg', NOW(), 15, 3, 1);

CREATE TABLE IF NOT EXISTS `product_detail`
(
    `id`      INT PRIMARY KEY AUTO_INCREMENT,
    `cpu`     VARCHAR(255),
    `ram`     INT,
    `storage` VARCHAR(255),
    `gpu`     VARCHAR(255),
    `inch`    double
);
-- Chèn dữ liệu vào bảng product_detail
INSERT INTO product_detail (id, cpu, ram, storage, gpu, inch)
VALUES
    (1, 'Intel Core i5', 8, '256GB SSD', 'N/A', 15.6),
    (2, 'AMD Ryzen 7', 16, '512GB NVMe SSD', 'N/A', 14),
    (3, 'Intel Core i7', 16, '1TB HDD', 'NVIDIA GTX 1650', 17);

CREATE TABLE IF NOT EXISTS `category`
(
    `id`   INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(255)
);
-- Chèn dữ liệu vào bảng category
INSERT INTO category (id, name)
VALUES
    (1, 'Laptops'),
    (2, 'Phones'),
    (3, 'Accessories');


CREATE TABLE IF NOT EXISTS `orders`
(
    `id`              INT PRIMARY KEY AUTO_INCREMENT,
    `contact_user`    INT,
    `user_id`         int,
    `order_date`      DATE,
    `total_amount`    DECIMAL(10, 2),
    `total_price`     DECIMAL(10, 2),
    `order_detail_id` int
);
-- Chèn dữ liệu vào bảng orders
INSERT INTO orders (id, contact_user, user_id, order_date, total_amount, total_price, order_detail_id)
VALUES
    (1, 1, 1, '2023-08-31', 3, 450.00, 1),
    (2, 2, 2, '2023-08-30', 2, 400.00, 2);

CREATE TABLE IF NOT EXISTS `order_details`
(
    `id`            INT PRIMARY KEY AUTO_INCREMENT,
    `quantity`      INT,
    `total_price`   DECIMAL(10, 2),
    `delivery_date` DATE,
    `order_status`  VARCHAR(50),
    `product_id`    int
);
-- Chèn dữ liệu vào bảng order_details
INSERT INTO order_details (id, quantity, total_price, delivery_date, order_status, product_id)
VALUES
    (1, 2, 200.00, '2023-09-05', 'Pending', 1),
    (2, 3, 300.00, '2023-09-01', 'Shipped', 2);

CREATE TABLE IF NOT EXISTS `products_category`
(
    `products_category_id` int,
    `category_id`          INT,
    PRIMARY KEY (`products_category_id`, `category_id`)
);
-- Chèn dữ liệu vào bảng products_category
INSERT INTO products_category (products_category_id, category_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 1);

CREATE TABLE IF NOT EXISTS `products_cart`
(
    `products_id`     INT,
    `cart_product_id` INT,
    PRIMARY KEY (`products_id`, `cart_product_id`)
);

-- Chèn dữ liệu vào bảng products_cart
INSERT INTO products_cart (products_id, cart_product_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 3);
ALTER TABLE  `orders`
    ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `products_category`
    ADD FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);

ALTER TABLE `products_category`
    ADD FOREIGN KEY (`products_category_id`) REFERENCES `products` (`id`);

ALTER TABLE `products_cart`
    ADD FOREIGN KEY (`products_id`) REFERENCES `products` (`id`);

ALTER TABLE `products_cart`
    ADD FOREIGN KEY (`cart_product_id`) REFERENCES `cart` (`id`);

ALTER TABLE `orders`
    ADD FOREIGN KEY (`order_detail_id`) REFERENCES `order_details` (`id`);

ALTER TABLE `cart`
    ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `orders`
    ADD FOREIGN KEY (`contact_user`) REFERENCES `contact_user` (`id`);

ALTER TABLE `products`
    ADD FOREIGN KEY (`product_detail_id`) REFERENCES `product_detail` (`id`);

ALTER TABLE `order_details`
    ADD FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);

ALTER TABLE `contact_user`
    ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);
