CREATE TABLE `brand`
(
    `id`   int(11) NOT NULL,
    `name` varchar(50) DEFAULT NULL,
    `img`  longtext    DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `brand`
--

INSERT INTO `brand` (`id`, `name`, `img`)
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
       (14, 'Bàn phím test', 'Nokia42-b_21.jpg'),
       (15, 'Appe Watch', 'Apple7077-b26-220x48.png'),
       (1013, 'test', 'Amhapy banner copy.png');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `category`
--

CREATE TABLE `category`
(
    `category_id`   int(11) NOT NULL,
    `category_name` varchar(50) DEFAULT NULL,
    `category_img`  longtext    DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `category`
--

INSERT INTO `category` (`category_id`, `category_name`, `category_img`)
VALUES (1, 'Điện thoại', 'dien-thoai-doc-quyen-128x128.png'),
       (2, 'Laptop', 'Laptop-129x129.png'),
       (3, 'Máy tính bảng', 'Tablet-128x129.png'),
       (4, 'Chuột', 'chuot-128x129.png'),
       (5, 'Bàn phím', 'ban-phim-128x129.png'),
       (1008, 'Đồng hồ', 'Donghothongminh-128x129.png');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `delivery_address`
--

CREATE TABLE `delivery_address`
(
    `delivery_address_id` int(11) NOT NULL,
    `province`            varchar(50)  DEFAULT NULL,
    `district`            varchar(50)  DEFAULT NULL,
    `country`             varchar(50)  DEFAULT NULL,
    `address_detail`      varchar(255) DEFAULT NULL,
    `is_use`              int(11) DEFAULT NULL,
    `user_id`             varchar(50)  DEFAULT NULL,
    `user_name`           varchar(50)  DEFAULT NULL,
    `user_phone`          varchar(50)  DEFAULT NULL,
    `ward`                varchar(50)  DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `delivery_address`
--

INSERT INTO `delivery_address` (`delivery_address_id`, `province`, `district`, `country`, `address_detail`, `is_use`,
                                `user_id`, `user_name`, `user_phone`, `ward`)
VALUES (1, 'Hanoi', 'Ba Dinh', 'Vietnam', 'Apt 101', 1, 'qanh', 'phuc', '0987654345', NULL),
       (2, 'Ho Chi Minh City', 'District 1', 'Vietnam', 'Apt 202', 1, 'qanh', 'nhi', '0987654345', NULL),
       (3, 'Da Nang', 'Hai Chau', 'Vietnam', 'Apt 303', 1, 'admin', 'anh', '0987654345', NULL);

-- --------------------------------------------------------
--
-- Cấu trúc bảng cho bảng `Orders`
--

CREATE TABLE `Orders`
(
    `Order_id`       int(11) NOT NULL,
    `Order_date`     date         DEFAULT NULL,
    `total`          float        DEFAULT NULL,
    `status`         varchar(1)   DEFAULT NULL,
    `province`       varchar(50)  DEFAULT NULL,
    `district`       varchar(50)  DEFAULT NULL,
    `address_detail` varchar(500) DEFAULT NULL,
    `order_code`     varchar(255) NOT NULL,
    `user_id`        varchar(50)  DEFAULT NULL,
    `ward`           varchar(50)  DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `Orders`
--

INSERT INTO `Orders` (`Order_id`, `Order_date`, `total`, `status`, `province`, `district`, `address_detail`,
                      `order_code`, `user_id`, `ward`)
VALUES (1, '2023-03-10', 28270000, 'N', 'Đắk Nông', 'Đắk R Lấp', 'Đạo Nghĩa', '122wwiei3', 'qanh', 'Đạo Nghĩa'),
       (2, '2023-03-09', 18490000, 'N', 'Đắk Nông', 'Đắk R Lấp', 'Đạo Nghĩa', 'wwww333', 'qanh', 'Đạo Nghĩa'),
       (3, '2023-04-11', 100000000, 'N', 'Đắk Nông', 'Đắk R Lấp', 'Đạo Nghĩa', 'dd2def2', 'qanh', 'Đạo Nghĩa'),
       (4, '2023-04-12', 14190000, 'N', 'Đắk Nông', 'Đắk R Lấp', 'Đạo Nghĩa', 'dg546tg', 'qanh', 'Đạo Nghĩa'),
       (5, '2023-05-08', 14190000, 'N', 'Đắk Nông', 'Đắk R Lấp', 'Đạo Nghĩa', 'dd2def2', 'qanh', 'Đạo Nghĩa'),
       (6, '2023-05-07', 14190000, 'N', 'Đắk Nông', 'Đắk R Lấp', 'Đạo Nghĩa', 'sdsdsd', 'qanh', 'Đạo Nghĩa'),
       (7, '2023-06-12', 38690000, 'H', 'Đắk Nông', 'Đắk R Lấp', 'Đạo Nghĩa', '54gr65', 'qanh', 'Đạo Nghĩa'),
       (8, '2023-06-12', 43900000, 'H', 'Đắk Nông', 'Đắk R Lấp', 'Đạo Nghĩa', 'grgtrhb', 'qanh', 'Đạo Nghĩa'),
       (9, '2023-06-06', 43900000, 'N', 'Đắk Nông', 'Đắk R Lấp', 'Đạo Nghĩa', '756ưcrg', 'qanh', 'Đạo Nghĩa'),
       (10, '2023-06-05', 439000000, 'N', 'Đắk Nông', 'Đắk R Lấp', 'Đạo Nghĩa', '45vu7b', 'qanh', 'Đạo Nghĩa'),
       (11, '2023-07-04', 439000000, 'N', 'Đắk Nông', 'Đắk R Lấp', 'Đạo Nghĩa', '7u6nr5', 'qanh', 'Đạo Nghĩa'),
       (12, '2023-07-13', 28890000, 'N', 'HCM', 'Quận 12', 'Phường 4', '8g9dgdd', 'admin', 'Phường 4'),
       (13, '2023-07-13', 3690000, 'N', 'HCM', 'Quận 12', 'Phường 4', '98gbnfg', 'admin', 'Phường 4'),
       (14, '2023-07-13', 32970000, 'H', 'HCM', 'Quận 12', 'Phường 4', '97s3rn', 'admin', 'Phường 4'),
       (15, '2023-07-13', 2400000, 'H', 'HCM', 'Quận 12', 'Phường 4', '897ydff', 'admin', 'Phường 4'),
       (16, '2023-08-13', 53700000, 'N', 'HCM', 'Quận 12', 'Phường 4', 'oc8b9ff', 'admin', 'Phường 4'),
       (17, '2023-08-13', 24685000, 'H', 'HCM', 'Quận 12', 'Phường 4', '908hfds', 'admin', 'Phường 4'),
       (18, '2023-08-13', 44700000, 'H', 'HCM', 'Quận 12', 'Phường 4', '089shdf', 'admin', 'Phường 4'),
       (19, '2023-08-13', 88885000, 'H', 'HCM', 'Quận 12', 'Phường 4', 'oiv9f7vy', 'admin', 'Phường 4'),
       (20, '2023-09-13', 30390000, 'N', 'HCM', 'Quận 12', 'Phường 4', '97dhfhsj', 'admin', 'Phường 4'),
       (21, '2023-09-02', 3690000, 'N', '', '', '', '203FA', 'qanh', NULL),
       (22, '2023-10-03', 19480000, 'N', '', '', '', 'ILSZ2K5Q', 'qanh', NULL),
       (23, '2023-10-03', 20770000, 'X', '', '', '', 'TE32QQJZ', 'qanh', NULL),
       (24, '2023-10-03', 2400000, 'X', '', '', '', 'IUQZ3H3I', 'qanh', NULL),
       (25, '2023-10-04', 14680000, 'X', '', '', '', '4FVBELJ7', 'qanh', NULL),
       (26, '2023-10-04', 2400000, 'X', '', '', '', '87YIB4TS', 'qanh', NULL),
       (27, '2023-10-04', 3690000, 'N', '', '', '', '8SAE8UCI', 'qanh', NULL),
       (28, '2023-10-04', 2400000, 'H', '', '', '', 'QZ98FHMP', 'qanh', NULL),
       (29, '2023-10-04', 46900000, 'N', '', '', '', 'ILTWSK7U', 'qanh', NULL),
       (30, '2023-10-16', 3690000, 'X', 'Ho Chi Minh City', 'District 1', 'Apt 202', '3BA7VCHC', 'qanh', NULL),
       (31, '2023-10-16', 2400000, 'X', 'Hanoi', 'Ba Dinh', 'Apt 101', 'F8MHBQOY', 'qanh', NULL),
       (32, '2023-10-16', 2400000, 'X', 'Hanoi', 'Ba Dinh', 'Apt 101', '5YFF9WTA', 'qanh', NULL),
       (33, '2023-10-16', 3690000, 'X', 'Ho Chi Minh City', 'District 1', 'Apt 202', 'DV1CQ0VC', 'qanh', NULL),
       (34, '2023-11-16', 10990000, 'N', 'Ho Chi Minh City', 'District 1', 'Apt 202', 'AEUA1SZ6', 'qanh', NULL),
       (35, '2023-12-16', 46900000, 'N', 'Hanoi', 'Ba Dinh', 'Apt 101', '34YBPH8B', 'qanh', NULL),
       (36, '2023-10-30', 97470000, 'N', 'Hanoi', 'Ba Dinh', 'Apt 101', 'Y4QWBK89', 'qanh', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `order_detail`
--

CREATE TABLE `order_detail`
(
    `order_detail_id` int(11) NOT NULL,
    `quantity`        int(11) DEFAULT NULL,
    `price`           float       DEFAULT NULL,
    `total`           float       DEFAULT NULL,
    `product_id`      varchar(50) DEFAULT NULL,
    `Order_id`        int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `order_detail`
--

INSERT INTO `order_detail` (`order_detail_id`, `quantity`, `price`, `total`, `product_id`, `Order_id`)
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
       (7051, 1, 11900000, 11900000, 'DT26', 20),
       (7052, 1, 3690000, 3690000, 'DT07', 21),
       (7053, 1, 10990000, 10990000, 'DT11', 22),
       (7054, 2, 2400000, 4800000, 'DT39', 22),
       (7055, 1, 3690000, 3690000, 'DT07', 22),
       (7056, 1, 10990000, 10990000, 'DT11', 23),
       (7057, 1, 2400000, 2400000, 'DT39', 23),
       (7058, 2, 3690000, 7380000, 'DT07', 23),
       (7059, 1, 2400000, 2400000, 'DT39', 24),
       (7060, 1, 10990000, 10990000, 'DT11', 25),
       (7061, 1, 3690000, 3690000, 'DT07', 25),
       (7062, 1, 2400000, 2400000, 'DT39', 26),
       (7063, 1, 3690000, 3690000, 'DT07', 27),
       (7064, 1, 2400000, 2400000, 'DT39', 28),
       (7065, 1, 46900000, 46900000, 'DT03', 29),
       (7066, 1, 3690000, 3690000, 'DT07', 30),
       (7067, 1, 2400000, 2400000, 'DT39', 31),
       (7068, 1, 2400000, 2400000, 'DT39', 32),
       (7069, 1, 3690000, 3690000, 'DT07', 33),
       (7070, 1, 10990000, 10990000, 'DT11', 34),
       (7071, 1, 46900000, 46900000, 'DT03', 35),
       (7072, 3, 18490000, 55470000, 'DT23', 36),
       (7073, 2, 21000000, 42000000, 'DT05', 36);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product`
--

CREATE TABLE `product`
(
    `product_id`          varchar(50) NOT NULL,
    `product_name`        varchar(50) DEFAULT NULL,
    `product_img`         longtext    DEFAULT NULL,
    `price`               float       DEFAULT NULL,
    `qty`                 int(11) DEFAULT NULL,
    `discount`            float       DEFAULT NULL,
    `sold_quantity`       int(11) DEFAULT NULL,
    `description`         longtext    DEFAULT NULL,
    `category_id`         int(11) DEFAULT NULL,
    `brand_id`            int(11) DEFAULT NULL,
    `time_discount_start` datetime    DEFAULT NULL,
    `time_discount_end`   datetime    DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `product`
--

INSERT INTO `product` (`product_id`, `product_name`, `product_img`, `price`, `qty`, `discount`, `sold_quantity`,
                       `description`, `category_id`, `brand_id`, `time_discount_start`, `time_discount_end`)
VALUES ('DT02', 'Samsung Galaxy S23', 'samsung-galaxy-s23-ultra-thumb-xanh-600x600.jpg', 26000000, 120, 0, 0, '', 1, 1,
        NULL, NULL),
       ('DT03', 'Samsung Galaxy A23', 'samsung-galaxy-a23-cam-thumb-600x600.jpg', 46900000, 118, 0, 0, '', 1, 1, NULL,
        NULL),
       ('DT04', 'Samsung Galaxy S20 FE', 'samsung-galaxy-s20-fan-edition-xanh-la-thumbnew-600x600.png', 9400000, 120, 0,
        0, '', 1, 1, NULL, NULL),
       ('DT05', 'Samsung Galaxy S23+', 'samsung-galaxy-s23-plus-600x600.jpg', 21000000, 118, 0, 2, '', 1, 1, NULL,
        NULL),
       ('DT06', 'Samsung Galaxy Z Fold4', 'samsung-galaxy-z-fold4-kem-256gb-600x600.jpg', 35000000, 120, 0, 0,
        'Samsung Galaxy A24 6GB tiếp tục là mẫu điện thoại tầm trung được nhà Samsung giới thiệu đến thị trường Việt Nam vào tháng 04/2023, máy nổi bật với giá thành rẻ, màn hình Super AMOLED cùng camera 50 MP chụp ảnh sắc nét.',
        1, 1, NULL, NULL),
       ('DT07', 'Samsung Galaxy A04s', 'samsung-galaxy-a04s-thumb-den-600x600.jpg', 3690000, 119, 200000, 1,
        'Samsung Galaxy A24 6GB tiếp tục là mẫu điện thoại tầm trung được nhà Samsung giới thiệu đến thị trường Việt Nam vào tháng 04/2023, máy nổi bật với giá thành rẻ, màn hình Super AMOLED cùng camera 50 MP chụp ảnh sắc nét.',
        1, 1, NULL, NULL),
       ('DT08', 'Samsung Galaxy S22', 'Galaxy-S22-Ultra-Black-600x600.jpg', 23900000, 120, 0, 0,
        'Samsung Galaxy A24 6GB tiếp tục là mẫu điện thoại tầm trung được nhà Samsung giới thiệu đến thị trường Việt Nam vào tháng 04/2023, máy nổi bật với giá thành rẻ, màn hình Super AMOLED cùng camera 50 MP chụp ảnh sắc nét.',
        1, 1, NULL, NULL),
       ('DT10', 'Realme 9 Pro', 'realme-9-pro-thumb-xanh-600x600.jpg', 6590000, 120, 0, 3,
        'Realme 9 Pro 8GB/128GB là mẫu smartphone tầm trung mới ra mắt của Realme với thiết kế hiện đại, cấu hình mạnh mẽ và camera đa dạng, đặc biệt với chế độ chụp đêm Super Nightscape.',
        2, 5, NULL, NULL),
       ('DT11', 'OPPO Reno8 T 5G', 'oppo-reno8t-vang1-thumb-600x600.png', 10990000, 119, 0, 2,
        'Tiếp nối sự thành công rực rỡ đến từ các thế hệ trước đó thì chiếc OPPO Reno8 T 5G 256GB cuối cùng đã được giới thiệu chính thức tại Việt Nam, được định hình là dòng sản phẩm thuộc phân khúc tầm trung với camera 108 MP, con chip Snapdran 695 cùng kiểu dáng thiết kế mặt lưng và màn hình bo cong hết sức nổi bật.',
        1, 3, NULL, NULL),
       ('DT12', 'OPPO Reno8 series', 'oppo-reno8-pro-thumb-xanh-1-600x600.jpg', 17900000, 120, 0, 11,
        'Tiếp nối sự thành công rực rỡ đến từ các thế hệ trước đó thì chiếc OPPO Reno8 T 5G 256GB cuối cùng đã được giới thiệu chính thức tại Việt Nam, được định hình là dòng sản phẩm thuộc phân khúc tầm trung với camera 108 MP, con chip Snapdran 695 cùng kiểu dáng thiết kế mặt lưng và màn hình bo cong hết sức nổi bật.',
        1, 3, NULL, NULL),
       ('DT13', 'OPPO Find X5 Pro 5G', 'oppo-find-x5-pro-den-thumb-600x600.jpg', 19900000, 120, 0, 11,
        'Tiếp nối sự thành công rực rỡ đến từ các thế hệ trước đó thì chiếc OPPO Reno8 T 5G 256GB cuối cùng đã được giới thiệu chính thức tại Việt Nam, được định hình là dòng sản phẩm thuộc phân khúc tầm trung với camera 108 MP, con chip Snapdran 695 cùng kiểu dáng thiết kế mặt lưng và màn hình bo cong hết sức nổi bật.',
        1, 3, NULL, NULL),
       ('DT14', 'OPPO Reno6 Pro 5G', 'oppo-reno6-pro-grey-600x600.jpg', 13900000, 120, 0, 1,
        'Tiếp nối sự thành công rực rỡ đến từ các thế hệ trước đó thì chiếc OPPO Reno8 T 5G 256GB cuối cùng đã được giới thiệu chính thức tại Việt Nam, được định hình là dòng sản phẩm thuộc phân khúc tầm trung với camera 108 MP, con chip Snapdran 695 cùng kiểu dáng thiết kế mặt lưng và màn hình bo cong hết sức nổi bật.',
        1, 3, NULL, NULL),
       ('DT15', 'iPhone 14 Pro Max', 'iphone-14-pro-max-den-thumb-600x600.jpg', 18900000, 120, 0, 1,
        'iPhone 14 Pro Max một siêu phẩm trong giới smartphone được nhà Táo tung ra thị trường vào tháng 09/2022. Máy trang bị con chip Apple A16 Bionic vô cùng mạnh mẽ, đi kèm theo đó là thiết kế hình màn hình mới, hứa hẹn mang lại những trải nghiệm đầy mới mẻ cho người dùng iPhone.',
        1, 2, NULL, NULL),
       ('DT16', 'iPhone 14 Pro', 'iphone-14-pro-vang-thumb-600x600.jpg', 15900000, 120, 0, 11,
        'iPhone 14 Pro Max một siêu phẩm trong giới smartphone được nhà Táo tung ra thị trường vào tháng 09/2022. Máy trang bị con chip Apple A16 Bionic vô cùng mạnh mẽ, đi kèm theo đó là thiết kế hình màn hình mới, hứa hẹn mang lại những trải nghiệm đầy mới mẻ cho người dùng iPhone.',
        1, 2, NULL, NULL),
       ('DT17', 'iPhone 11', 'iphone-xi-den-600x600.jpg', 15900000, 120, 0, 11,
        'iPhone 14 Pro Max một siêu phẩm trong giới smartphone được nhà Táo tung ra thị trường vào tháng 09/2022. Máy trang bị con chip Apple A16 Bionic vô cùng mạnh mẽ, đi kèm theo đó là thiết kế hình màn hình mới, hứa hẹn mang lại những trải nghiệm đầy mới mẻ cho người dùng iPhone.',
        1, 2, NULL, NULL),
       ('DT18', 'iPhone 14', 'iPhone-14-thumb-trang-600x600.jpg', 13900000, 120, 0, 1,
        'iPhone 14 Pro Max một siêu phẩm trong giới smartphone được nhà Táo tung ra thị trường vào tháng 09/2022. Máy trang bị con chip Apple A16 Bionic vô cùng mạnh mẽ, đi kèm theo đó là thiết kế hình màn hình mới, hứa hẹn mang lại những trải nghiệm đầy mới mẻ cho người dùng iPhone.',
        1, 2, NULL, NULL),
       ('DT19', 'iPhone 14 Plus', 'iPhone-14-plus-thumb-den-600x600.jpg', 21900000, 120, 0, 1,
        'iPhone 14 Pro Max một siêu phẩm trong giới smartphone được nhà Táo tung ra thị trường vào tháng 09/2022. Máy trang bị con chip Apple A16 Bionic vô cùng mạnh mẽ, đi kèm theo đó là thiết kế hình màn hình mới, hứa hẹn mang lại những trải nghiệm đầy mới mẻ cho người dùng iPhone.',
        1, 2, NULL, NULL),
       ('DT20', 'Xiaomi Redmi 12C', 'xiaomi-redmi-12c-grey-thumb-600x600.jpg', 21900000, 120, 0, 11,
        'Xiaomi Redmi Note 12 8GB/128GB - ĐỘC QUYỀN là mẫu điện thoại tầm trung vừa được ra mắt tại thị trường Việt Nam, máy thu hút sự chú ý đến từ người dùng nhờ được trang bị con chip Snapdran 685 và camera 50 MP nổi bật trong phân khúc.',
        1, 4, NULL, NULL),
       ('DT200', 'Bàn phím Bluetooth A4tech FBX51C', 'ban-phim-bluetooth-a4tech-fbx51c-thumb-1-600x600.jpg', 720000,
        1000, 0, 0, 'Mo ta', 5, 9, NULL, NULL),
       ('DT21', 'Xiaomi Redmi Note 12', 'xiaomi-redmi-note-12-4g-mono-den-600x600.jpg', 900000, 120, 0, 11,
        'Xiaomi Redmi Note 12 8GB/128GB - ĐỘC QUYỀN là mẫu điện thoại tầm trung vừa được ra mắt tại thị trường Việt Nam, máy thu hút sự chú ý đến từ người dùng nhờ được trang bị con chip Snapdran 685 và camera 50 MP nổi bật trong phân khúc.',
        1, 4, NULL, NULL),
       ('DT22', 'Xiaomi Redmi A1', 'Xiaomi-Redmi-A1-thumb-xanh-duong-600x600.jpg', 200000, 120, 0, 11,
        'Xiaomi Redmi Note 12 8GB/128GB - ĐỘC QUYỀN là mẫu điện thoại tầm trung vừa được ra mắt tại thị trường Việt Nam, máy thu hút sự chú ý đến từ người dùng nhờ được trang bị con chip Snapdran 685 và camera 50 MP nổi bật trong phân khúc.',
        1, 4, NULL, NULL),
       ('DT23', 'MacBook Air M1 2020', 'macbook-air-m1-2020-gray-600x600.jpg', 18490000, 117, 0, 14, 'Mo ta', 2, 5,
        NULL, NULL),
       ('DT24', 'MacBook Air M2', 'apple-macbook-air-m2-2022-bac-600x600.jpg', 27800000, 120, 0, 1, 'Mo ta', 2, 5, NULL,
        NULL),
       ('DT25', 'Asus TUF Gaming F15 FX506LHB', 'asus-tuf-gaming-fx506lhb-i5-hn188w-(54).jpg', 19900000, 120, 0, 1,
        'Mo ta', 2, 6, NULL, NULL),
       ('DT26', 'Asus Vivobook X415EA i3 1115G4 (EK2034W)', 'asus-vivobook-x415ea-i3-ek2034w-thumb-laptop-600x600.jpg',
        11900000, 120, 0, 1, 'Mo ta', 2, 6, NULL, NULL),
       ('DT27', 'Asus VivoBook 15X OLED A1503ZA', 'asus-vivobook-15x-oled-a1503za-i5-l1290w-040722-050332-600x600.jpg',
        20900000, 120, 0, 1, 'Mo ta', 2, 6, NULL, NULL),
       ('DT28', 'Lenovo Yoga Tab 11', 'lenovo-yoga-tab-11-thumb-600x600.jpg', 11900000, 120, 0, 1, 'Mo ta', 3, 7, NULL,
        NULL),
       ('DT29', 'Lenovo Tab M10 (Gen 3)', 'lenovo-tab-m10-gen-3-1-2-600x600.jpg', 4590000, 120, 0, 1, 'Mo ta', 3, 7,
        NULL, NULL),
       ('DT30', 'iPad 9 WiFi', 'iPad-9-wifi-trang-600x600 (1).jpg', 7900000, 120, 0, 1, 'Mo ta', 3, 8, NULL, NULL),
       ('DT31', 'iPad 10 WiFi', 'iPad-gen-10-1-600x600.jpg', 11900000, 120, 0, 11, 'Mo ta', 3, 8, NULL, NULL),
       ('DT32', 'Chuột Không dây Logitech M190', 'chuot-khong-day-logitech-m190-thumb3-600x600.png', 390000, 120, 0, 11,
        'Mo ta', 4, 9, NULL, NULL),
       ('DT33', 'Logitech G102 Gen2 Lightsync', 'chuot-gaming-logitech-g102-gen2-lightsync-01-600x600.jpg', 420000, 120,
        0, 111, 'Mo ta', 4, 9, NULL, NULL),
       ('DT34', 'Chuột Không dây Logitech M185', 'chuot-khong-day-logitech-m185-thumb2-1-600x600.png', 285000, 120, 0,
        1, 'Mo ta', 4, 9, NULL, NULL),
       ('DT35', 'Razer DeathAdder Essential', 'chuot-co-day-gaming-razer-deathadder-essential-thumb-600x600.png',
        750000, 120, 0, 1, 'Mo ta', 4, 10, NULL, NULL),
       ('DT36', 'Xiaomi 13', 'xiaomi-13-thumb-den-600x600.jpg', 18900000, 200, 0, 1, 'Xiaomi', 1, 4, NULL, NULL),
       ('DT37', 'Xiaomi Redmi Note 12 Pro', 'xiaomi-redmi-note-12-pro-5g-momo-1-600x600.jpg', 9000000, 12, 0, 1,
        'Xiaomi', 1, 4, NULL, NULL),
       ('DT38', 'Xiaomi Redmi Note 12 S', 'xiaomi-redmi-note12s-den-thumb-600x600.jpg', 12000000, 12, 0, 1, 'Xiaomi', 1,
        4, NULL, NULL),
       ('DT39', 'Xiaomi Redmi A2+', 'xiaomi-redmi-note-12-plus-xanh-duong-thumb-600x600.jpg', 2400000, 100, 0, 1,
        'Xiaomi', 1, 4, NULL, NULL),
       ('DT40', 'Bàn Phím Cơ Có Dây Gaming', 'ban-phim-co-co-day-gaming-corsair-k63-den-thumb-600x600.png', 1500000000,
        13, 0, 0, '', 5, 10, NULL, NULL),
       ('DT89', 'Đồng hồ thông minh Apple Watch SE', 'apple-watch-se-2022-40-mm-vien-nhom-tn-600x600.jpg', 5500000, 12,
        0, 0,
        'Trong sự kiện Far Out 2022, nhà Táo Khuyết đã mang đến hàng loạt sản phẩm mới trong đó có đồng hồ thông minh Apple Watch SE 2022 GPS 40mm. Mẫu smartwatch giá rẻ mới nhất của Apple này hứa hẹn sẽ khiến cho các iFans đứng ngồi không yên khi sở hữu nhiều tính năng hấp dẫn.',
        1008, 15, NULL, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `Users`
--

CREATE TABLE `Users`
(
    `user_id`   varchar(50) NOT NULL,
    `user_name` varchar(50)  DEFAULT NULL,
    `email`     varchar(50)  DEFAULT NULL,
    `phone`     varchar(50)  DEFAULT NULL,
    `address`   varchar(255) DEFAULT NULL,
    `password`  varchar(255) DEFAULT NULL,
    `role`      bit(1)       DEFAULT NULL,
    `is_Active` bit(1)       DEFAULT NULL,
    `code`      varchar(50)  DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `Users`
--

INSERT INTO `Users` (`user_id`, `user_name`, `email`, `phone`, `address`, `password`, `role`, `is_Active`, `code`)
VALUES ('admin', 'admin1', 'admin@gmail.com', '0987654321', 'quan nhan, ha noi ',
        '$2a$10$FQIsN0DnF6Ln8uDRX/xZ6.KeVvuQVSnOI7foGXlul1eqt6HhKXOTm', b'1', b'0', '0'),
       ('nhi', 'nhi', 'quoc1@gmail.com', '0987654321', 'sssssss',
        '$2a$10$6mgiY0TwgDpk7MElMxUeWeF645sg3xY.eDXAftoiz4fi5vI4WoAaq', b'0', b'0', '0'),
       ('qanh', 'anhr', 'cuongduc1682001@gmail.com', '0987654321', 'cầu giấy ',
        '$2a$10$bOxAP.pq3v4ftm.cPDxuAuFio.1tA1oljhx7ZA5LdoCgQaU0Eb8jO', b'1', b'1', '2nIy54x6hivgeFb8BezxHX558cdX9D'),
       ('qanh123', 'Lê Quốc Anh', 'lea4921@gmail.com', '0987654321', 'cầu giấy',
        '$2a$10$Q/0OgQRX/9ZmQDfzGRrn8./gyMQmu5ygY6BDYMZU/7U2i8LKzs6xu', b'0', b'0', '0');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `brand`
--
ALTER TABLE `brand`
    ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `category`
--
ALTER TABLE `category`
    ADD PRIMARY KEY (`category_id`);

--
-- Chỉ mục cho bảng `delivery_address`
--
ALTER TABLE `delivery_address`
    ADD PRIMARY KEY (`delivery_address_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Chỉ mục cho bảng `Orders`
--
ALTER TABLE `Orders`
    ADD PRIMARY KEY (`Order_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Chỉ mục cho bảng `order_detail`
--
ALTER TABLE `order_detail`
    ADD PRIMARY KEY (`order_detail_id`),
  ADD KEY `product_id` (`product_id`),
  ADD KEY `Order_id` (`Order_id`);

--
-- Chỉ mục cho bảng `product`
--
ALTER TABLE `product`
    ADD PRIMARY KEY (`product_id`),
  ADD KEY `category_id` (`category_id`),
  ADD KEY `brand_id` (`brand_id`);

--
-- Chỉ mục cho bảng `Users`
--
ALTER TABLE `Users`
    ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `brand`
--
ALTER TABLE `brand`
    MODIFY `id` int (11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1014;

--
-- AUTO_INCREMENT cho bảng `category`
--
ALTER TABLE `category`
    MODIFY `category_id` int (11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1009;

--
-- AUTO_INCREMENT cho bảng `delivery_address`
--
ALTER TABLE `delivery_address`
    MODIFY `delivery_address_id` int (11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT cho bảng `order_detail`
--
ALTER TABLE `order_detail`
    MODIFY `order_detail_id` int (11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7074;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `delivery_address`
--
ALTER TABLE `delivery_address`
    ADD CONSTRAINT `delivery_address_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `Users` (`user_id`);

--
-- Các ràng buộc cho bảng `Orders`
--
ALTER TABLE `Orders`
    ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `Users` (`user_id`);

--
-- Các ràng buộc cho bảng `order_detail`
--
ALTER TABLE `order_detail`
    ADD CONSTRAINT `order_detail_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`),
  ADD CONSTRAINT `order_detail_ibfk_2` FOREIGN KEY (`Order_id`) REFERENCES `Orders` (`Order_id`);

--
-- Các ràng buộc cho bảng `product`
--
ALTER TABLE `product`
    ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`),
  ADD CONSTRAINT `product_ibfk_2` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`);
COMMIT;

