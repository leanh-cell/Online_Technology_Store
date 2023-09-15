CREATE TABLE IF NOT EXISTS `users`
(
    `id`       INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(50) NOT NULL,
    `email`    VARCHAR(100),
    `password` VARCHAR(100) NOT NULL,
    `role`     VARCHAR(10) NOT NULL
    );
-- Chèn dữ liệu vào bảng users
INSERT INTO users ( username, email, password, role)
VALUES
    ( 'user1', 'user1@example.com', '$2a$12$CJm6UGbeLXAM2BasuvunF.w6oerpQJ1KSeIVLeyJyDbIOOXRDAjTK', 'user'),
    ( 'user2', 'user2@example.com', '$2a$12$6AVUVOU8zUqHyg5o2OjRAeDfBdiM3p4EnH89MtATI9Gf6aKRdB5Se', 'user'),
    ( 'admin', 'admin@example.com', '$2a$12$2fu2njqQCiKwjlmYnfiBm.uG9CmYDmJLea0Hbx2EfZQmSrknilw/a', 'admin');

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
INSERT INTO contact_user ( full_name, city, province, town, street, phone_number, user_id, total_order)
VALUES
    ('Le quoc anh', 'Hanoi', 'Hanoi', 'Hai Ba Trung', '123 Street', '1234567890', 1, 5),
    ('nguyen thanh loan', 'Ho Chi Minh', 'Ho Chi Minh', 'District 1', '456 Street', '9876543210', 2, 3);

CREATE TABLE IF NOT EXISTS `cart`
(
    `id`         INT PRIMARY KEY AUTO_INCREMENT,
    `user_id`    INT,
    `product_id` INT,
    `quantity`   INT
);
-- Chèn dữ liệu vào bảng cart
INSERT INTO cart ( user_id, product_id, quantity)
VALUES
    ( 1, 1, 2),
    ( 1, 3, 1),
    ( 2, 2, 3);

CREATE TABLE IF NOT EXISTS `products`
(
    `id`             INT PRIMARY KEY AUTO_INCREMENT,
    `name`           VARCHAR(200),
    `price`          DECIMAL(10,2),
    `description`    VARCHAR(255),
    `image_url`      VARCHAR(500),
    `created_date`   TIMESTAMP,
    `quantity`       int,
    `product_detail_id` Int,
    `category_id`       INT
    );
-- Chèn dữ liệu vào bảng products
INSERT INTO products ( name, price, description, image_url, created_date, quantity, product_detail_id,category_id)
VALUES
    ( 'Product 1', 100.00, 'Description 1', 'image1.jpg', NOW(), 10, 1,1),
    ( 'Product 2', 200.00, 'Description 2', 'image2.jpg', NOW(), 20, 2,2),
    ( 'Product 3', 150.00, 'Description 3', 'image3.jpg', NOW(), 15, 3,3);

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
INSERT INTO product_detail ( cpu, ram, storage, gpu, inch)
VALUES
    ( 'Intel Core i5', 8, '256GB SSD', 'N/A', 15.6),
    ( 'AMD Ryzen 7', 16, '512GB NVMe SSD', 'N/A', 14),
    ( 'Intel Core i7', 16, '1TB HDD', 'NVIDIA GTX 1650', 17);

CREATE TABLE IF NOT EXISTS `category`
(
    `id`   INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(255)
    );
-- Chèn dữ liệu vào bảng category
INSERT INTO category ( name)
VALUES
    ( 'Laptops'),
    ( 'Phones'),
    ( 'Accessories');


CREATE TABLE IF NOT EXISTS `orders`
(
    `id`              INT PRIMARY KEY AUTO_INCREMENT,
    `contact_user`    INT,
    `user_id`         int,
    `order_date`      DATE,
    `total_pay`       DECIMAL(10, 2),
    `payment_method`  int,
    `payment_status`  int,
    `total_cost`      DECIMAL(10, 2),
    `transport_fee`   DECIMAL(10, 2),
    `quantity`        INT,
    `date_receipt`    DATE,
    `order_status`    VARCHAR(50),
    `order_code`      VARCHAR(20) not null
    );
-- Chèn dữ liệu vào bảng orders
INSERT INTO `orders` (`contact_user`, `user_id`, `order_date`, `total_pay`, `payment_method`, `payment_status`, `total_cost`, `transport_fee`, `quantity`, `date_receipt`, `order_status`, `order_code`) VALUES
(1, 1, '2023-09-15', 100.50, 1, 1, 80.00, 20.50, 3, '2023-09-20', 'Processing', 'ORD12345'),
(2, 2, '2023-09-16', 75.25, 2, 1, 60.00, 15.25, 2, '2023-09-21', 'Shipped', 'ORD12346'),
(1, 1, '2023-09-17', 45.75, 1, 0, 40.00, 5.75, 1, '2023-09-22', 'Cancelled', 'ORD12347'),
(1, 1, '2023-09-18', 120.00, 3, 1, 100.00, 20.00, 4, '2023-09-23', 'Delivered', 'ORD12348'),
(1, 1, '2023-09-19', 60.90, 2, 1, 50.00, 10.90, 2, '2023-09-24', 'Shipped', 'ORD12349');


CREATE TABLE IF NOT EXISTS `order_item`
(
    `id`               INT PRIMARY KEY AUTO_INCREMENT,
    `order_id`         int,
    `product_id`       int,
    `quantity`         int
);
INSERT INTO order_item (order_id, product_id, quantity)
VALUES
    (1, 1, 2), -- Đơn đặt hàng có id = 1 chứa sản phẩm có id = 1 với số lượng là 2
    (1, 2, 1), -- Đơn đặt hàng có id = 1 chứa sản phẩm có id = 2 với số lượng là 1
    (2, 3, 3); -- Đơn đặt hàng có id = 2 chứa sản phẩm có id = 3 với số lượng là 3

ALTER TABLE  `order_item`
    ADD FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`);

ALTER TABLE  `order_item`
    ADD FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);

ALTER TABLE  `orders`
    ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `cart`
    ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `cart`
    ADD FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);

ALTER TABLE `orders`
    ADD FOREIGN KEY (`contact_user`) REFERENCES `contact_user` (`id`);

ALTER TABLE `products`
    ADD FOREIGN KEY (`product_detail_id`) REFERENCES `product_detail` (`id`);

ALTER TABLE `products`
    ADD FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);

ALTER TABLE `contact_user`
    ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);
