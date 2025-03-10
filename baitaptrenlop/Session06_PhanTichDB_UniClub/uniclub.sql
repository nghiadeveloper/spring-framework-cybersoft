CREATE DATABASE bt_buoi_38_uniclub;
USE bt_buoi_38_uniclub;


-- Bảng Color
CREATE TABLE Color (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL
);

-- Bảng Size
CREATE TABLE Size (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL
);

-- Bảng Brand
CREATE TABLE Brand (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL
);

-- Bảng Product
CREATE TABLE Product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    rate_id INT,
    description TEXT,
    sizes VARCHAR(255),
    original_price DECIMAL(10,2),
    images TEXT,
    sku VARCHAR(50),
    additional_information TEXT,
    quantity INT NOT NULL,
    favourite BOOLEAN DEFAULT FALSE,
    stock_status ENUM('in_stock', 'out_of_stock', 'pre_order') NOT NULL DEFAULT 'in_stock',
    brand_id INT
);

-- Bảng Product_detail
CREATE TABLE Product_detail (
    id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT NOT NULL,
    color_id INT NOT NULL,
    size_id INT NOT NULL,
    quantity INT NOT NULL
);

-- Bảng Tag
CREATE TABLE Tag (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL
);

-- Bảng Product_Tag
CREATE TABLE Product_Tag (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tag_id INT NOT NULL,
    product_id INT NOT NULL
);

-- Bảng Category
CREATE TABLE Category (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL
);

-- Bảng Product_Category
CREATE TABLE Product_Category (
    id INT AUTO_INCREMENT PRIMARY KEY,
    category_id INT NOT NULL,
    product_id INT NOT NULL
);

-- Bảng Review
CREATE TABLE Review (
    id INT AUTO_INCREMENT PRIMARY KEY,
    score INT CHECK (score BETWEEN 1 AND 5),
    image TEXT,
    user_id INT NOT NULL,
    email VARCHAR(255) NOT NULL,
    description TEXT,
    product_id INT NOT NULL
);


-- Bảng Address
CREATE TABLE Address (
    id INT AUTO_INCREMENT PRIMARY KEY,
    zip_code VARCHAR(20),
    street_name VARCHAR(255),
    appartments VARCHAR(255),
    city VARCHAR(100),
    state VARCHAR(100),
    country VARCHAR(100)
);

-- Bảng Role
CREATE TABLE Role (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

-- Bảng User
CREATE TABLE User (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    fullname VARCHAR(255),
    phone VARCHAR(20),
    role_id INT
);

-- Bảng Order
CREATE TABLE `Order` (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    company_name VARCHAR(255),
    address_id INT NOT NULL,
    email VARCHAR(255),
    phone VARCHAR(20),
    note TEXT,
    total DECIMAL(10,2) NOT NULL,
    payment_type VARCHAR(50),
    sub_total DECIMAL(10,2),
    payment_status VARCHAR(50)
);

-- Bảng Order_Product
CREATE TABLE Order_Product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    product_detail_id INT NOT NULL,
    order_id INT NOT NULL,
    quantity INT NOT NULL
);

-- Bảng Blog
CREATE TABLE Blog (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    cover TEXT,
    content TEXT NOT NULL,
    tags TEXT,
    id_role INT,
    author_id INT NOT NULL,
    summary TEXT
);

-- Bảng Comment_group
CREATE TABLE Comment_group (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    email VARCHAR(255),
    message TEXT,
    blog_id INT NOT NULL
);

-- Bảng Comment
CREATE TABLE Comment (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    email VARCHAR(255),
    message TEXT,
    comment_group_id INT NOT NULL
);

-- Bảng Tags
CREATE TABLE Tags (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL
);

-- Bảng Blog_Tag
CREATE TABLE Blog_Tag (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tag_id INT NOT NULL,
    blog_id INT NOT NULL
);

-- Thêm khóa ngoại
ALTER TABLE User ADD CONSTRAINT FK_User_Role FOREIGN KEY (role_id) REFERENCES Role(id) ON DELETE SET NULL;

ALTER TABLE `Order` ADD CONSTRAINT FK_Order_User FOREIGN KEY (user_id) REFERENCES User(id) ON DELETE CASCADE;
ALTER TABLE `Order` ADD CONSTRAINT FK_Order_Address FOREIGN KEY (address_id) REFERENCES Address(id) ON DELETE CASCADE;

ALTER TABLE Order_Product 
ADD CONSTRAINT FK_OrderProduct_ProductDetail FOREIGN KEY (product_detail_id) REFERENCES Product_detail(id) ON DELETE CASCADE,
ADD CONSTRAINT FK_OrderProduct_Order FOREIGN KEY (order_id) REFERENCES `Order`(id) ON DELETE CASCADE;

ALTER TABLE Blog ADD CONSTRAINT FK_Blog_User FOREIGN KEY (author_id) REFERENCES User(id) ON DELETE CASCADE;


ALTER TABLE Comment_group ADD CONSTRAINT FK_CommentGroup_User FOREIGN KEY (user_id) REFERENCES User(id) ON DELETE CASCADE;
ALTER TABLE Comment_group ADD CONSTRAINT FK_CommentGroup_Blog FOREIGN KEY (blog_id) REFERENCES Blog(id) ON DELETE CASCADE;

ALTER TABLE Comment ADD CONSTRAINT FK_Comment_User FOREIGN KEY (user_id) REFERENCES User(id) ON DELETE CASCADE;
ALTER TABLE Comment ADD CONSTRAINT FK_Comment_Group FOREIGN KEY (comment_group_id) REFERENCES Comment_group(id) ON DELETE CASCADE;

ALTER TABLE Blog_Tag ADD CONSTRAINT FK_BlogTag_Blog FOREIGN KEY (blog_id) REFERENCES Blog(id) ON DELETE CASCADE;
ALTER TABLE Blog_Tag ADD CONSTRAINT FK_BlogTag_Tag FOREIGN KEY (tag_id) REFERENCES Tags(id) ON DELETE CASCADE;


ALTER TABLE Product ADD CONSTRAINT FK_Product_Brand FOREIGN KEY (brand_id) REFERENCES Brand(id) ON DELETE SET NULL;

ALTER TABLE Product_detail ADD CONSTRAINT FK_ProductDetail_Product FOREIGN KEY (product_id) REFERENCES Product(id) ON DELETE CASCADE;
ALTER TABLE Product_detail ADD CONSTRAINT FK_ProductDetail_Color FOREIGN KEY (color_id) REFERENCES Color(id) ON DELETE CASCADE;
ALTER TABLE Product_detail ADD CONSTRAINT FK_ProductDetail_Size FOREIGN KEY (size_id) REFERENCES Size(id) ON DELETE CASCADE;

ALTER TABLE Product_Tag ADD CONSTRAINT FK_ProductTag_Tag FOREIGN KEY (tag_id) REFERENCES Tag(id) ON DELETE CASCADE;
ALTER TABLE Product_Tag ADD CONSTRAINT FK_ProductTag_Product FOREIGN KEY (product_id) REFERENCES Product(id) ON DELETE CASCADE;

ALTER TABLE Product_Category ADD CONSTRAINT FK_ProductCategory_Category FOREIGN KEY (category_id) REFERENCES Category(id) ON DELETE CASCADE;
ALTER TABLE Product_Category ADD CONSTRAINT FK_ProductCategory_Product FOREIGN KEY (product_id) REFERENCES Product(id) ON DELETE CASCADE;

ALTER TABLE Review ADD CONSTRAINT FK_Review_Product FOREIGN KEY (product_id) REFERENCES Product(id) ON DELETE CASCADE;
