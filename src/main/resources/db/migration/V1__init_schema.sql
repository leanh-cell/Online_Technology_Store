CREATE TABLE IF NOT EXISTS `Users`
(
    `user_id`   varchar(50) PRIMARY KEY,
    `user_name` varchar(50),
    `email`     varchar(50),
    `phone`     varchar(50),
    `address`   varchar(255),
    `password`  varchar(255),
    `role`      bit,
    `is_Active` bit,
    `code`      varchar(50)
);
INSERT INTO Users (user_id, user_name, email, phone, address, password, role, is_Active, code)
VALUES ('123', 'Văn Quang', 'test@gmail.com', '0346363860', '129 Lý Thường Kiệt Phường 4',
        '$2a$12$FwaWiZpQCLD9qpxpil81UuRmFG.J3pia9umymAUe.nw0jOHLFVNpC', 1, 0, ''),
       ('admin1', 'Nguyễn Văn AD', 'PhanLeThanhPhuc2010@gmail.com', '09090909209', '129 Lý Thường Kiệt Phường 4',
        '$2a$12$FwaWiZpQCLD9qpxpil81UuRmFG.J3pia9umymAUe.nw0jOHLFVNpC', 0, 0, ''),
       ('phucdzx1', 'Thành Phúc1', 'phanphuc20102003@gmail.com', '0346363860', '129 Lý Thường Kiệt Phường 4',
        '$2a$12$FwaWiZpQCLD9qpxpil81UuRmFG.J3pia9umymAUe.nw0jOHLFVNpC', 1, 0, 'sGbg0CuWpgKefmOJ6tTimjVhxXhQBZ'),
       ('test1', 'Nguyễn Văn A', 'ptlp2010@gmail.com', '0346363890', '129 Lý Thường Kiệt',
        '$2a$12$FwaWiZpQCLD9qpxpil81UuRmFG.J3pia9umymAUe.nw0jOHLFVNpC', 0, 0, '0');

CREATE TABLE IF NOT EXISTS `delivery_address`
(
    `delivery_address_id` int PRIMARY KEY AUTO_INCREMENT,
    `province`            varchar(50),
    `district`            varchar(50),
    `country`             varchar(50),
    `apartment`           varchar(50),
    `isUse`               bit,
    `user_id`             varchar(50)
);

CREATE TABLE IF NOT EXISTS `category`
(
    `category_id`   int PRIMARY KEY AUTO_INCREMENT,
    `category_name` varchar(50),
    `category_img`  LONGTEXT
);
INSERT INTO category (category_id, category_name, category_img)
VALUES (1, 'Điện thoại', 'dien-thoai-doc-quyen-128x128.png'),
       (2, 'Laptop', 'Laptop-129x129.png'),
       (3, 'Máy tính bảng', 'Tablet-128x129.png'),
       (4, 'Chuột', 'chuot-128x129.png'),
       (5, 'Bàn phím', 'ban-phim-128x129.png'),
       (1008, 'Đồng hồ', 'Donghothongminh-128x129.png');

CREATE TABLE IF NOT EXISTS `brand`
(
    `id`   int PRIMARY KEY AUTO_INCREMENT,
    `name` varchar(50),
    `img`  LONGTEXT
);
INSERT INTO brand (id, name, img)
VALUES (1, 'SamSung', 'samsungnew-220x48-1.png'),
       (2, 'Iphone', 'lo-iphone-220x48.png'),
       (3, 'Oppo', 'OPPO42-b_5.jpg'),
       (4, 'Xiaomi', 'lo-xiaomi-220x48-5.png'),
       (5, 'MacBook', 'lo-macbook-149x40.png'),
       (6, 'Asus', 'lo-asus-149x40.png'),
       (7, 'Levono', 'Lenovo522-b_6.jpg'),
       (8, 'IPad', 'iPad-(Apple)522-b_4.jpg'),
       (9, 'Logitech', 'lologitech.png'),
       (10, 'Razer', 'razer.png'),
       (11, 'Nokia', 'Nokia42-b_21.jpg'),
       (12, 'SamSung1', 'samsungnew-220x48-1.png'),
       (13, 'SamSung', 'samsungnew-220x48-1.png'),
       (14, 'Bàn phímtest', 'default-avatar.png'),
       (1011, 'Bàn phím test', 'Nokia42-b_21.jpg'),
       (1012, 'Appe Watch', 'Apple7077-b26-220x48.png');

CREATE TABLE IF NOT EXISTS `product`
(
    `product_id`    varchar(50) PRIMARY KEY,
    `product_name`  varchar(50),
    `product_img`   LONGTEXT,
    `price`         float,
    `qty`           int,
    `discount`      float,
    `sold_quantity` int,
    `description`   LONGTEXT,
    `category_id`   int,
    `brand_id`      int
);
INSERT INTO product (product_id, product_name, product_img, price, qty, discount, description, category_id, brand_id,
                     sold_quantity)
VALUES ('DT01', 'Xiaomi note 15', 'xiaomi-redmi-note12s-den-thumb-600x600.jpg', 9990000, 1005, 0,
        'Xiaomi Redmi Note 12 8GB/128GB - ĐỘC QUYỀN là mẫu điện thoại tầm trung vừa được ra mắt tại thị trường Việt Nam, máy thu hút sự chú ý đến từ người dùng nhờ được trang bị con chip Snapdran 685 và camera 50 MP nổi bật trong phân khúc.',
        1, 4, 0),
       ('DT02', 'Samsung Galaxy S23', 'samsung-galaxy-s23-ultra-thumb-xanh-600x600.jpg', 26000000, 120, 0,
        'Samsung Galaxy A24 6GB tiếp tục là mẫu điện thoại tầm trung được nhà Samsung giới thiệu đến thị trường Việt Nam vào tháng 04/2023, máy nổi bật với giá thành rẻ, màn hình Super AMOLED cùng camera 50 MP chụp ảnh sắc nét.',
        1, 1, 12),
       ('DT03', 'Samsung Galaxy A23', 'samsung-galaxy-a23-cam-thumb-600x600.jpg', 46900000, 120, 0,
        'Samsung Galaxy A24 6GB tiếp tục là mẫu điện thoại tầm trung được nhà Samsung giới thiệu đến thị trường Việt Nam vào tháng 04/2023, máy nổi bật với giá thành rẻ, màn hình Super AMOLED cùng camera 50 MP chụp ảnh sắc nét.',
        1, 1, 12),
       ('DT04', 'Samsung Galaxy S20 FE', 'samsung-galaxy-s20-fan-edition-xanh-la-thumbnew-600x600.png', 9400000, 120, 0,
        'Samsung Galaxy A24 6GB tiếp tục là mẫu điện thoại tầm trung được nhà Samsung giới thiệu đến thị trường Việt Nam vào tháng 04/2023, máy nổi bật với giá thành rẻ, màn hình Super AMOLED cùng camera 50 MP chụp ảnh sắc nét.',
        1, 1, 1),
       ('DT05', 'Samsung Galaxy S23+', 'samsung-galaxy-s23-plus-600x600.jpg', 21000000, 120, 0,
        'Samsung Galaxy A24 6GB tiếp tục là mẫu điện thoại tầm trung được nhà Samsung giới thiệu đến thị trường Việt Nam vào tháng 04/2023, máy nổi bật với giá thành rẻ, màn hình Super AMOLED cùng camera 50 MP chụp ảnh sắc nét.',
        1, 1, 2),
       ('DT06', 'Samsung Galaxy Z Fold4', 'samsung-galaxy-z-fold4-kem-256gb-600x600.jpg', 35000000, 120, 0,
        'Samsung Galaxy A24 6GB tiếp tục là mẫu điện thoại tầm trung được nhà Samsung giới thiệu đến thị trường Việt Nam vào tháng 04/2023, máy nổi bật với giá thành rẻ, màn hình Super AMOLED cùng camera 50 MP chụp ảnh sắc nét.',
        1, 1, 1),
       ('DT07', 'Samsung Galaxy A04s', 'samsung-galaxy-a04s-thumb-den-600x600.jpg', 3690000, 120, 0,
        'Samsung Galaxy A24 6GB tiếp tục là mẫu điện thoại tầm trung được nhà Samsung giới thiệu đến thị trường Việt Nam vào tháng 04/2023, máy nổi bật với giá thành rẻ, màn hình Super AMOLED cùng camera 50 MP chụp ảnh sắc nét.',
        1, 1, 1),
       ('DT08', 'Samsung Galaxy S22', 'Galaxy-S22-Ultra-Black-600x600.jpg', 23900000, 120, 0,
        'Samsung Galaxy A24 6GB tiếp tục là mẫu điện thoại tầm trung được nhà Samsung giới thiệu đến thị trường Việt Nam vào tháng 04/2023, máy nổi bật với giá thành rẻ, màn hình Super AMOLED cùng camera 50 MP chụp ảnh sắc nét.',
        1, 1, 0),
       ('DT09', 'Xiaomi Mi 12', 'xiaomi-mi-12-thumb-xanh-la-600x600.jpg', 28000000, 120, 0,
        'Xiaomi Mi 12 12GB/256GB - Đẳng cấp là một mẫu flagship của Xiaomi với cấu hình khủng khiếp: Snapdragon 895, camera 108MP, màn hình AMOLED 2K.',
        1, 4, 10),
       ('DT10', 'Realme 9 Pro', 'realme-9-pro-thumb-xanh-600x600.jpg', 6590000, 120, 0,
        'Realme 9 Pro 8GB/128GB là mẫu smartphone tầm trung mới ra mắt của Realme với thiết kế hiện đại, cấu hình mạnh mẽ và camera đa dạng, đặc biệt với chế độ chụp đêm Super Nightscape.',
        2, 5, 3),
       ('DT11', 'OPPO Reno8 T 5G', 'oppo-reno8t-vang1-thumb-600x600.png', 10990000, 120, 0,
        'Tiếp nối sự thành công rực rỡ đến từ các thế hệ trước đó thì chiếc OPPO Reno8 T 5G 256GB cuối cùng đã được giới thiệu chính thức tại Việt Nam, được định hình là dòng sản phẩm thuộc phân khúc tầm trung với camera 108 MP, con chip Snapdran 695 cùng kiểu dáng thiết kế mặt lưng và màn hình bo cong hết sức nổi bật.',
        1, 3, 1),
       ('DT12', 'OPPO Reno8 series', 'oppo-reno8-pro-thumb-xanh-1-600x600.jpg', 17900000, 120, 0,
        'Tiếp nối sự thành công rực rỡ đến từ các thế hệ trước đó thì chiếc OPPO Reno8 T 5G 256GB cuối cùng đã được giới thiệu chính thức tại Việt Nam, được định hình là dòng sản phẩm thuộc phân khúc tầm trung với camera 108 MP, con chip Snapdran 695 cùng kiểu dáng thiết kế mặt lưng và màn hình bo cong hết sức nổi bật.',
        1, 3, 11),
       ('DT13', 'OPPO Find X5 Pro 5G', 'oppo-find-x5-pro-den-thumb-600x600.jpg', 19900000, 120, 0,
        'Tiếp nối sự thành công rực rỡ đến từ các thế hệ trước đó thì chiếc OPPO Reno8 T 5G 256GB cuối cùng đã được giới thiệu chính thức tại Việt Nam, được định hình là dòng sản phẩm thuộc phân khúc tầm trung với camera 108 MP, con chip Snapdran 695 cùng kiểu dáng thiết kế mặt lưng và màn hình bo cong hết sức nổi bật.',
        1, 3, 11),
       ('DT14', 'OPPO Reno6 Pro 5G', 'oppo-reno6-pro-grey-600x600.jpg', 13900000, 120, 0,
        'Tiếp nối sự thành công rực rỡ đến từ các thế hệ trước đó thì chiếc OPPO Reno8 T 5G 256GB cuối cùng đã được giới thiệu chính thức tại Việt Nam, được định hình là dòng sản phẩm thuộc phân khúc tầm trung với camera 108 MP, con chip Snapdran 695 cùng kiểu dáng thiết kế mặt lưng và màn hình bo cong hết sức nổi bật.',
        1, 3, 1),
       ('DT15', 'iPhone 14 Pro Max', 'iphone-14-pro-max-den-thumb-600x600.jpg', 18900000, 120, 0,
        'iPhone 14 Pro Max một siêu phẩm trong giới smartphone được nhà Táo tung ra thị trường vào tháng 09/2022. Máy trang bị con chip Apple A16 Bionic vô cùng mạnh mẽ, đi kèm theo đó là thiết kế hình màn hình mới, hứa hẹn mang lại những trải nghiệm đầy mới mẻ cho người dùng iPhone.',
        1, 2, 1),
       ('DT16', 'iPhone 14 Pro', 'iphone-14-pro-vang-thumb-600x600.jpg', 15900000, 120, 0,
        'iPhone 14 Pro Max một siêu phẩm trong giới smartphone được nhà Táo tung ra thị trường vào tháng 09/2022. Máy trang bị con chip Apple A16 Bionic vô cùng mạnh mẽ, đi kèm theo đó là thiết kế hình màn hình mới, hứa hẹn mang lại những trải nghiệm đầy mới mẻ cho người dùng iPhone.',
        1, 2, 11),
       ('DT17', 'iPhone 11', 'iphone-xi-den-600x600.jpg', 15900000, 120, 0,
        'iPhone 14 Pro Max một siêu phẩm trong giới smartphone được nhà Táo tung ra thị trường vào tháng 09/2022. Máy trang bị con chip Apple A16 Bionic vô cùng mạnh mẽ, đi kèm theo đó là thiết kế hình màn hình mới, hứa hẹn mang lại những trải nghiệm đầy mới mẻ cho người dùng iPhone.',
        1, 2, 11),
       ('DT18', 'iPhone 14', 'iPhone-14-thumb-trang-600x600.jpg', 13900000, 120, 0,
        'iPhone 14 Pro Max một siêu phẩm trong giới smartphone được nhà Táo tung ra thị trường vào tháng 09/2022. Máy trang bị con chip Apple A16 Bionic vô cùng mạnh mẽ, đi kèm theo đó là thiết kế hình màn hình mới, hứa hẹn mang lại những trải nghiệm đầy mới mẻ cho người dùng iPhone.',
        1, 2, 1),
       ('DT19', 'iPhone 14 Plus', 'iPhone-14-plus-thumb-den-600x600.jpg', 21900000, 120, 0,
        'iPhone 14 Pro Max một siêu phẩm trong giới smartphone được nhà Táo tung ra thị trường vào tháng 09/2022. Máy trang bị con chip Apple A16 Bionic vô cùng mạnh mẽ, đi kèm theo đó là thiết kế hình màn hình mới, hứa hẹn mang lại những trải nghiệm đầy mới mẻ cho người dùng iPhone.',
        1, 2, 1),
       ('DT20', 'Xiaomi Redmi 12C', 'xiaomi-redmi-12c-grey-thumb-600x600.jpg', 21900000, 120, 0,
        'Xiaomi Redmi Note 12 8GB/128GB - ĐỘC QUYỀN là mẫu điện thoại tầm trung vừa được ra mắt tại thị trường Việt Nam, máy thu hút sự chú ý đến từ người dùng nhờ được trang bị con chip Snapdran 685 và camera 50 MP nổi bật trong phân khúc.',
        1, 4, 11),
       ('DT200', 'Bàn phím Bluetooth A4tech FBX51C', 'ban-phim-bluetooth-a4tech-fbx51c-thumb-1-600x600.jpg', 720000,
        1000, 0, 'Mo ta', 5, 9, 0),
       ('DT21', 'Xiaomi Redmi Note 12', 'xiaomi-redmi-note-12-4g-mono-den-600x600.jpg', 900000, 120, 0,
        'Xiaomi Redmi Note 12 8GB/128GB - ĐỘC QUYỀN là mẫu điện thoại tầm trung vừa được ra mắt tại thị trường Việt Nam, máy thu hút sự chú ý đến từ người dùng nhờ được trang bị con chip Snapdran 685 và camera 50 MP nổi bật trong phân khúc.',
        1, 4, 11),
       ('DT22', 'Xiaomi Redmi A1', 'Xiaomi-Redmi-A1-thumb-xanh-duong-600x600.jpg', 200000, 120, 0,
        'Xiaomi Redmi Note 12 8GB/128GB - ĐỘC QUYỀN là mẫu điện thoại tầm trung vừa được ra mắt tại thị trường Việt Nam, máy thu hút sự chú ý đến từ người dùng nhờ được trang bị con chip Snapdran 685 và camera 50 MP nổi bật trong phân khúc.',
        1, 4, 11),
       ('DT23', 'MacBook Air M1 2020', 'macbook-air-m1-2020-gray-600x600.jpg', 18490000, 120, 0, 'Mo ta', 2, 5, 11),
       ('DT24', 'MacBook Air M2', 'apple-macbook-air-m2-2022-bac-600x600.jpg', 27800000, 120, 0, 'Mo ta', 2, 5, 1),
       ('DT25', 'Asus TUF Gaming F15 FX506LHB', 'asus-tuf-gaming-fx506lhb-i5-hn188w-(54).jpg', 19900000, 120, 0,
        'Mo ta', 2, 6, 1),
       ('DT26', 'Asus Vivobook X415EA i3 1115G4 (EK2034W)', 'asus-vivobook-x415ea-i3-ek2034w-thumb-laptop-600x600.jpg',
        11900000, 120, 0, 'Mo ta', 2, 6, 1),
       ('DT27', 'Asus VivoBook 15X OLED A1503ZA', 'asus-vivobook-15x-oled-a1503za-i5-l1290w-040722-050332-600x600.jpg',
        20900000, 120, 0, 'Mo ta', 2, 6, 1),
       ('DT28', 'Lenovo Yoga Tab 11', 'lenovo-yoga-tab-11-thumb-600x600.jpg', 11900000, 120, 0, 'Mo ta', 3, 7, 1),
       ('DT29', 'Lenovo Tab M10 (Gen 3)', 'lenovo-tab-m10-gen-3-1-2-600x600.jpg', 4590000, 120, 0, 'Mo ta', 3, 7, 1),
       ('DT30', 'iPad 9 WiFi', 'iPad-9-wifi-trang-600x600 (1).jpg', 7900000, 120, 0, 'Mo ta', 3, 8, 1),
       ('DT31', 'iPad 10 WiFi', 'iPad-gen-10-1-600x600.jpg', 11900000, 120, 0, 'Mo ta', 3, 8, 11),
       ('DT32', 'Chuột Không dây Logitech M190', 'chuot-khong-day-logitech-m190-thumb3-600x600.png', 390000, 120, 0,
        'Mo ta', 4, 9, 11),
       ('DT33', 'Logitech G102 Gen2 Lightsync', 'chuot-gaming-logitech-g102-gen2-lightsync-01-600x600.jpg', 420000, 120,
        0, 'Mo ta', 4, 9, 111),
       ('DT34', 'Chuột Không dây Logitech M185', 'chuot-khong-day-logitech-m185-thumb2-1-600x600.png', 285000, 120, 0,
        'Mo ta', 4, 9, 1),
       ('DT35', 'Razer DeathAdder Essential', 'chuot-co-day-gaming-razer-deathadder-essential-thumb-600x600.png',
        750000, 120, 0, 'Mo ta', 4, 10, 1),
       ('DT36', 'Xiaomi 13', 'xiaomi-13-thumb-den-600x600.jpg', 18900000, 200, 0, 'Xiaomi', 1, 4, 1),
       ('DT37', 'Xiaomi Redmi Note 12 Pro', 'xiaomi-redmi-note-12-pro-5g-momo-1-600x600.jpg', 9000000, 12, 0, 'Xiaomi',
        1, 4, 1),
       ('DT38', 'Xiaomi Redmi Note 12 S', 'xiaomi-redmi-note12s-den-thumb-600x600.jpg', 12000000, 12, 0, 'Xiaomi', 1, 4,
        1),
       ('DT39', 'Xiaomi Redmi A2+', 'xiaomi-redmi-note-12-plus-xanh-duong-thumb-600x600.jpg', 2400000, 100, 0, 'Xiaomi',
        1, 4, 1),
       ('DT40', 'Bàn Phím Cơ Có Dây Gaming', 'ban-phim-co-co-day-gaming-corsair-k63-den-thumb-600x600.png', 1500000000,
        13, 0, '', 5, 10, 0),
       ('DT60', 'iPhone 14 Plus', 'iPhone-14-plus-thumb-xanh-1-600x600.jpg', 19900000, 123, 0, 'Iphone', 1, 2, 0),
       ('DT89', 'Đồng hồ thông minh Apple Watch SE', 'apple-watch-se-2022-40-mm-vien-nhom-tn-600x600.jpg', 5500000, 12,
        0,
        'Trong sự kiện Far Out 2022, nhà Táo Khuyết đã mang đến hàng loạt sản phẩm mới trong đó có đồng hồ thông minh Apple Watch SE 2022 GPS 40mm. Mẫu smartwatch giá rẻ mới nhất của Apple này hứa hẹn sẽ khiến cho các iFans đứng ngồi không yên khi sở hữu nhiều tính năng hấp dẫn.',
        1008, 1012, 0);


CREATE TABLE IF NOT EXISTS `Orders`
(
    `Order_id`   int PRIMARY KEY,
    `Order_date` date,
    `total`      float,
    `status`     varchar(1),
    `province`   varchar(50),
    `district`   varchar(50),
    `ward`       varchar(50),
    `user_id`    varchar(50)
);
INSERT INTO Orders (Order_id, Order_date, total, status, province, district, ward, user_id)
VALUES (1, CAST('2023-06-10' AS Date), 28270000, 'N', 'Đắk Nông', 'Đắk R Lấp', 'Đạo Nghĩa', 'phucdzx1'),
       (2, CAST('2023-06-09' AS Date), 18490000, 'X', 'Đắk Nông', '', 'Đạo Nghĩa', 'phucdzx1'),
       (3, CAST('2023-06-11' AS Date), 100000000, 'N', '', 'Đắk R Lấp', 'Đạo Nghĩa', 'phucdzx1'),
       (4, CAST('2023-06-12' AS Date), 14190000, 'N', 'Đắk Nông', 'Đắk R Lấp', 'Đạo Nghĩa', 'test1'),
       (5, CAST('2023-06-08' AS Date), 14190000, 'N', 'Đắk Nông', 'Đắk R Lấp', 'Đạo Nghĩa', 'test1'),
       (6, CAST('2023-06-07' AS Date), 14190000, 'N', 'Đắk Nông', 'Đắk R Lấp', 'Đạo Nghĩa', 'test1'),
       (7, CAST('2023-06-12' AS Date), 38690000, 'H', 'Đắk Nông', 'Đắk R Lấp', 'Đạo Nghĩa', 'phucdzx1'),
       (8, CAST('2023-06-12' AS Date), 43900000, 'H', 'Đắk Nông', 'Đắk R Lấp', 'Đạo Nghĩa', 'phucdzx1'),
       (9, CAST('2023-06-06' AS Date), 43900000, 'N', 'Đắk Nông', 'Đắk R Lấp', 'Đạo Nghĩa', 'phucdzx1'),
       (10, CAST('2023-06-05' AS Date), 439000000, 'N', 'Đắk Nông', 'Đắk R Lấp', 'Đạo Nghĩa', 'phucdzx1'),
       (11, CAST('2023-06-04' AS Date), 439000000, 'N', 'Đắk Nông', 'Đắk R Lấp', 'Đạo Nghĩa', 'phucdzx1'),
       (12, CAST('2023-06-13' AS Date), 28890000, 'N', 'HCM', 'Quận 12', 'Phường 4', 'phucdzx1'),
       (13, CAST('2023-06-13' AS Date), 3690000, 'N', 'HCM', 'Quận 12', 'Phường 4', 'phucdzx1'),
       (14, CAST('2023-06-13' AS Date), 32970000, 'H', 'HCM', 'Quận 12', 'Phường 4', 'phucdzx1'),
       (15, CAST('2023-06-13' AS Date), 2400000, 'H', 'HCM', 'Quận 12', '', 'phucdzx1'),
       (16, CAST('2023-06-13' AS Date), 53700000, 'N', 'HCM', 'Quận 12', 'Phường 4', 'phucdzx1'),
       (17, CAST('2023-06-13' AS Date), 24685000, 'X', 'HCM', 'Quận 12', 'Phường 4', '123'),
       (18, CAST('2023-06-13' AS Date), 44700000, 'X', 'HCM', 'Quận 12', 'Phường 4', '123'),
       (19, CAST('2023-06-13' AS Date), 88885000, 'X', 'HCM', 'Quận 12', 'Phường 4', 'admin1'),
       (20, CAST('2023-06-13' AS Date), 30390000, 'N', 'HCM', 'Quận 12', 'Phường 4', 'phucdzx1');

CREATE TABLE IF NOT EXISTS `order_detail`
(
    `order_detail_id` int PRIMARY KEY AUTO_INCREMENT,
    `quantity`        int,
    `price`           float,
    `total`           float,
    `product_id`      varchar(50),
    `Order_id`        int
);
INSERT INTO order_detail (order_detail_id, quantity, price, total, product_id, Order_id)
VALUES (5034, 1, 18490000, 18490000, 'DT23', 1),
       (5035, 1, 2400000, 2400000, 'DT39', 1),
       (5036, 2, 3690000, 7380000, 'DT07', 1),
       (5037, 1, 18490000, 18490000, 'DT23', 2),
       (5038, 1, 3690000, 3690000, 'DT07', 3),
       (5039, 4, 2400000, 9600000, 'DT39', 4),
       (5040, 1, 4590000, 4590000, 'DT29', 4),
       (6034, 1, 35000000, 35000000, 'DT06', 7),
       (6035, 1, 3690000, 3690000, 'DT07', 7),
       (6036, 1, 26000000, 26000000, 'DT02', 8),
       (6037, 1, 17900000, 17900000, 'DT10', 8),
       (7034, 1, 10990000, 10990000, 'DT11', 12),
       (7035, 1, 17900000, 17900000, 'DT12', 12),
       (7036, 1, 3690000, 3690000, 'DT07', 13),
       (7037, 3, 10990000, 32970000, 'DT11', 14),
       (7038, 1, 2400000, 2400000, 'DT39', 15),
       (7039, 3, 17900000, 53700000, 'DT10', 16),
       (7040, 1, 285000, 285000, 'DT34', 17),
       (7041, 1, 5500000, 5500000, 'DT89', 17),
       (7042, 1, 18900000, 18900000, 'DT36', 17),
       (7043, 2, 11900000, 23800000, 'DT26', 18),
       (7044, 1, 20900000, 20900000, 'DT27', 18),
       (7047, 1, 285000, 285000, 'DT34', 19),
       (7048, 1, 46900000, 46900000, 'DT03', 19),
       (7049, 3, 13900000, 41700000, 'DT18', 19),
       (7050, 1, 18490000, 18490000, 'DT23', 20),
       (7051, 1, 11900000, 11900000, 'DT26', 20);


ALTER TABLE `delivery_address`
    ADD FOREIGN KEY (`user_id`) REFERENCES `Users` (`user_id`);

ALTER TABLE `product`
    ADD FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`);

ALTER TABLE `product`
    ADD FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`);

ALTER TABLE `Orders`
    ADD FOREIGN KEY (`user_id`) REFERENCES `Users` (`user_id`);

ALTER TABLE `order_detail`
    ADD FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`);

ALTER TABLE `order_detail`
    ADD FOREIGN KEY (`Order_id`) REFERENCES `Orders` (`Order_id`);
