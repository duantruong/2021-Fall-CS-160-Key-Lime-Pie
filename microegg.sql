create database if not exists microegg;

use microegg;

create table Users (
userId INT NOT NULL AUTO_INCREMENT primary key,
fname varchar(100) not null,
lname varchar(100) not null,
gender varchar(10) not null,
mobile int not null
);

create table Login_Credentials (
emailId varchar(50) not null primary key,
password varchar(200) not null,
userId Int not null,
FOREIGN KEY (userId) REFERENCES Users(userId)
);

create table address(
addressId INT NOT NULL AUTO_INCREMENT primary key,
buildingNo varchar(10) not null,
street1 varchar(100) not null,
street2 varchar(100) not null,
city varchar(100) not null,
province varchar(100) not null,
zip int not null,
userId Int not null,
FOREIGN KEY (userId) REFERENCES Users(userId)
);


create table Product (
productId INT NOT NULL AUTO_INCREMENT primary key,
productType varchar(100) not null
);

create table cards(
cardId INT NOT NULL AUTO_INCREMENT primary key,
cardHolderName varchar(100) not null,
cardNumber INT not null,
expirationDate Date not null,
userId INT not null,
FOREIGN KEY (userId) REFERENCES Users(userId)
);

create table cart(
cartId INT NOT NULL AUTO_INCREMENT primary key,
userId INT not null,
FOREIGN KEY (userId) REFERENCES Users(userId)
);

create table computerCases (
productId INT NOT NULL PRIMARY KEY,
make VARCHAR(100) NOT NULL,
productName VARCHAR(100) NOT NULL,
SIZE VARCHAR(100) NOT NULL,
productDescription VARCHAR(200),
PRICE INT  NOT NULL,
AVAILABLEQUANTITY int NOT NULL,
FOREIGN KEY (productId) REFERENCES Product(productId)
);

create table MotherBoard (
productId INT NOT NULL PRIMARY KEY,
make VARCHAR(100) NOT NULL,
productName VARCHAR(100) NOT NULL,
chipSet VARCHAR(100) NOT NULL,
SIZE VARCHAR(100) NOT NULL,
productDescription VARCHAR(200),
PRICE INT  NOT NULL,
AVAILABLEQUANTITY int NOT NULL,
FOREIGN KEY (productId) REFERENCES Product(productId)
);

create table GRAPHICCARD (
productId INT NOT NULL PRIMARY KEY,
make VARCHAR(100) NOT NULL,
productName VARCHAR(100) NOT NULL,
chipSet VARCHAR(100) NOT NULL,
MODEL VARCHAR(100) NOT NULL,
productDescription VARCHAR(200),
PRICE INT  NOT NULL,
AVAILABLEQUANTITY int NOT NULL,
FOREIGN KEY (productId) REFERENCES Product(productId)
);

create table PROCESSORS (
productId INT NOT NULL PRIMARY KEY,
make VARCHAR(100) NOT NULL,
productName VARCHAR(100) NOT NULL,
CORES VARCHAR(100) NOT NULL,
MODEL VARCHAR(100) NOT NULL,
productDescription VARCHAR(200),
PRICE INT  NOT NULL,
AVAILABLEQUANTITY int NOT NULL,
FOREIGN KEY (productId) REFERENCES Product(productId)
);

create table RAM (
productId INT NOT NULL PRIMARY KEY,
make VARCHAR(100) NOT NULL,
productName VARCHAR(100) NOT NULL,
SIZE INT NOT NULL,
SPEED INT NOT NULL,
productDescription VARCHAR(200),
PRICE INT  NOT NULL,
AVAILABLEQUANTITY int NOT NULL,
FOREIGN KEY (productId) REFERENCES Product(productId)
);

create table COOLING (
productId INT NOT NULL PRIMARY KEY,
make VARCHAR(100) NOT NULL,
productName VARCHAR(100) NOT NULL,
productDescription VARCHAR(200),
PRICE INT  NOT NULL,
AVAILABLEQUANTITY int NOT NULL,
FOREIGN KEY (productId) REFERENCES Product(productId)
);

create table STORAGES (
productId INT NOT NULL PRIMARY KEY,
make VARCHAR(100) NOT NULL,
productName VARCHAR(100) NOT NULL,
productDescription VARCHAR(200),
SIZE VARCHAR(100),
MODEL VARCHAR(100),
PRICE INT  NOT NULL,
AVAILABLEQUANTITY int NOT NULL,
FOREIGN KEY (productId) REFERENCES Product(productId)
);

create table POWERSUPPLY (
productId INT NOT NULL PRIMARY KEY,
make VARCHAR(100) NOT NULL,
productName VARCHAR(100) NOT NULL,
productDescription VARCHAR(200) NOT NULL,
WATTAGE INT NOT NULL,
RATING VARCHAR(100) NOT NULL,
PRICE INT  NOT NULL,
AVAILABLEQUANTITY int NOT NULL,
FOREIGN KEY (productId) REFERENCES Product(productId)
);

create table Cart_Products(
cartId INT NOT NULL AUTO_INCREMENT,
productId INT not null,
quantity INT not null,
FOREIGN KEY (productId) REFERENCES Product(productId),
PRIMARY KEY(cartId,productId)
);

create table Orders(
orderId INT NOT NULL AUTO_INCREMENT primary key,
orderDate DATE not null,
userId INT not null,
addressId INT not null,
FOREIGN KEY (userId) REFERENCES Users(userId),
FOREIGN KEY (addressId) REFERENCES Address(addressId)
);

create table Orders_Products(
orderId INT not null AUTO_INCREMENT,
productId INT not null,
quantity INT not null,
totalAmount INT not null,
FOREIGN KEY (orderId) REFERENCES Orders(orderId),
FOREIGN KEY (productId) REFERENCES Product(productId),
PRIMARY KEY(orderId,productId)
);

create table Transactions(
transactionId INT NOT NULL AUTO_INCREMENT primary key,
paymentMode varchar(100) not null,
cardId INT not null,
totalAmount INT not null,
transactionDate Date not null,
FOREIGN KEY (cardId) REFERENCES Cards(cardId)
);

INSERT INTO PRODUCT(productType) VALUES('COMPUTERCASES');
INSERT INTO PRODUCT(productType) VALUES('COMPUTERCASES');
INSERT INTO PRODUCT(productType) VALUES('COMPUTERCASES');
INSERT INTO PRODUCT(productType) VALUES('COMPUTERCASES');
INSERT INTO PRODUCT(productType) VALUES('COMPUTERCASES');
insert into COMPUTERCASES(productId,make,productName,productDescription,SIZE,PRICE,AVAILABLEQUANTITY) values(1,'FRONTECH','Frontech Computer Case Cabinet','The Frontech cabinet ATX Cabinet is full of features that make your new system perform with real muscle.','LARGE',100,50);
insert into COMPUTERCASES(productId,make,productName,productDescription,SIZE,PRICE,AVAILABLEQUANTITY) values(2,'DEEPCOOL','DEEPCOOL MATREXX 40 Mid-Tower','The DEEPCOOL cabinet ATX Cabinet is full of features that make your new system perform with real muscle.','MEDIUM',110,50);
insert into COMPUTERCASES(productId,make,productName,productDescription,SIZE,PRICE,AVAILABLEQUANTITY) values(3,'ANT','Ant Esports ICE-130AG Mid Tower','The Ant cabinet ATX Cabinet is full of features that make your new system perform with real muscle.','SMALL',120,50);
insert into COMPUTERCASES(productId,make,productName,productDescription,SIZE,PRICE,AVAILABLEQUANTITY) values(4,'CORSAIR','Corsair Carbide SPEC-05 Mid-Tower Gaming Case','The Corsair cabinet ATX Cabinet is full of features that make your new system perform with real muscle.','LARGE',130,50);
insert into COMPUTERCASES(productId,make,productName,productDescription,SIZE,PRICE,AVAILABLEQUANTITY) values(5,'ANT','Ant Esports ICE-200TG Mid Tower','The ANT cabinet ATX Cabinet is full of features that make your new system perform with real muscle.','SMALL',140,50);

INSERT INTO PRODUCT(productType) VALUES('MOTHERBOARD');
INSERT INTO PRODUCT(productType) VALUES('MOTHERBOARD');
INSERT INTO PRODUCT(productType) VALUES('MOTHERBOARD');
INSERT INTO PRODUCT(productType) VALUES('MOTHERBOARD');
INSERT INTO PRODUCT(productType) VALUES('MOTHERBOARD');
-- productId INT NOT NULL PRIMARY KEY,
-- make VARCHAR(100) NOT NULL,
-- productName VARCHAR(100) NOT NULL,
-- chipSet VARCHAR(100) NOT NULL,
-- SIZE VARCHAR(100) NOT NULL,
-- productDescription VARCHAR(200),
-- PRICE INT  NOT NULL,
-- AVAILABLEQUANTITY int NOT NULL,
-- insert into COMPUTERCASES(productId,make,productName,productDescription,SIZE,CHIPSET,PRICE,AVAILABLEQUANTITY) values(6,'GIGABYTE','GIGABYTE H310M S2 Motherboard','GIGABYTE H310M S2 Motherboard.','MEDIUM',110,50);

-- insert into product(productName,productDescription,price,manufacturer,categoryId) values('','GIGABYTE H310M S2 Motherboard.',100,'GigaByte',2);
-- insert into product(productName,productDescription,price,manufacturer,categoryId) values('ASUS EX-A320M-GAMING Motherboard','ASUS EX-A320M-GAMING Motherboard.',110,'Asus',2);
-- insert into product(productName,productDescription,price,manufacturer,categoryId) values('MSI B550M PRO-VDH WIFI Micro-ATX AM4 Gaming Motherboard','MSI B550M PRO-VDH WIFI Micro-ATX AM4 Gaming Motherboard.',200,'MSI',2);
-- insert into product(productName,productDescription,price,manufacturer,categoryId) values('MSI B450M PRO-VDH MAX Mini-ATX AM4 Gaming Motherboard','MSI B450M PRO-VDH MAX Mini-ATX AM4 Gaming Motherboard.',130,'Corsair',2);
-- insert into product(productName,productDescription,price,manufacturer,categoryId) values('ASUS ROG Strix Z490-F Gaming Motherboard','ASUS ROG Strix Z490-F Gaming Motherboard.',400,'Ant',2);

-- insert into product(productName,productDescription,price,manufacturer,categoryId) values('ASUS NVIDIA GeForce GT 730 2 GB GDDR5 Graphics Card','ASUS NVIDIA GeForce GT 730 2 GB GDDR5 Graphics Card.',100,'Asus',3);
-- insert into product(productName,productDescription,price,manufacturer,categoryId) values('MSI Graphic card','MSI NVIDIA GT 710 2GD3H LP I 64 bit I PCI Express 2.0 x16 (uses x8) 2 GB DDR3 Graphics Card.',140,'MSI',3);
-- insert into product(productName,productDescription,price,manufacturer,categoryId) values('ZOTAC Graphic Card','ZOTAC NVIDIA GeForce GT 710 2 GB DDR3 Graphics Card  (Black).',200,'ZOTAC',3);
-- insert into product(productName,productDescription,price,manufacturer,categoryId) values('GIGABYTE Graphic Card','GIGABYTE NVIDIA GV-N710D3-2GL REV2.0 2 GB DDR3 Graphics Card.',180,'GIGABYTE',3);
-- insert into product(productName,productDescription,price,manufacturer,categoryId) values('ASUS Graphic Card','ASUS NVIDIA NVIDIA GeForce GT 710 2 GB GDDR5 Graphics Card.',90,'Asus',3);

-- insert into product(productName,productDescription,price,manufacturer,categoryId) values('Amd Ryzen 5 5600G 3.9','Amd Ryzen 5 5600G 3.9 GHz Upto 4.4 GHz AM4 Socket 6 Cores 12 Threads 3 kB L2 16 kB L3 Desktop Processor .',400,'AMD',4);
-- insert into product(productName,productDescription,price,manufacturer,categoryId) values('Amd Athlon 3000G','Amd Athlon 3000G with Radeon Vega 3 3.5 GHz AM4 Socket 2 Cores 4 Threads 1 MB L2 4 MB L3 Desktop Processor  (Silver).',180,'AMD',4);
-- insert into product(productName,productDescription,price,manufacturer,categoryId) values('Intel Core i3-3240','Intel Core i3-3240 3.4 GHz LGA 1155 Socket 2 Cores 4 Threads 3 MB Smart Cache Desktop Processor  (Silver).',150,'Intel',4);
-- insert into product(productName,productDescription,price,manufacturer,categoryId) values('Intel I3-10100F','Intel I3-10100F LGA1200 3.6 GHz Upto 4.3 GHz LGA 1200 Socket 4 Cores 8 Threads 6 MB Smart Cache Desktop Processor .',220,'Intel',4);
-- insert into product(productName,productDescription,price,manufacturer,categoryId) values('Intel Pentium Gold G6400','Intel Pentium Gold G6400 4 GHz LGA 1200 Socket 2 Cores 4 Threads 4 MB Smart Cache Desktop Processor.',190,'Intel',4);

-- insert into product(productName,productDescription,price,manufacturer,categoryId) values('Crucial Basic RAM DDR4 4 GB','Crucial Basic RAM DDR4 4 GB.',25,'Crucial',5);
-- insert into product(productName,productDescription,price,manufacturer,categoryId) values('Simtronics PC-6400 DDR2 2 GB','simtronics PC-6400 DDR2 2 GB.',35,'Simtronics',5);
-- insert into product(productName,productDescription,price,manufacturer,categoryId) values('ADATA XPG DDR4 8 GB','ADATA XPG DDR4 8 GB.',45,'ADATA',5);
-- insert into product(productName,productDescription,price,manufacturer,categoryId) values('KINGSTON OEM DDR2 2 GB','KINGSTON OEM DDR2 2 GB.',55,'Kingston',5);
-- insert into product(productName,productDescription,price,manufacturer,categoryId) values('SAMSUNG 1333 MHz DDR3 4 GB','SAMSUNG 1333 MHz DDR3 4 GB.',65,'Samsung',5);

-- insert into product(productName,productDescription,price,manufacturer,categoryId) values('SilverStone PF240 ARGB 240mm All in One Liquid Cooler ','SilverStone PF240 ARGB 240mm All in One Liquid Cooler.',125,'SilverStone',6);
-- insert into product(productName,productDescription,price,manufacturer,categoryId) values('CORSAIR iCUE H115i ELITE CAPELLIX 280mm RGB Liquid CPU Cooler','CORSAIR iCUE H115i ELITE CAPELLIX 280mm RGB Liquid CPU Cooler.',135,'CORSAIR',6);
-- insert into product(productName,productDescription,price,manufacturer,categoryId) values('CORSAIR iCUE H100i Pro XT Liquid Cooler Cooler','CORSAIR iCUE H100i Pro XT Liquid Cooler Cooler.',145,'CORSAIR',6);
-- insert into product(productName,productDescription,price,manufacturer,categoryId) values('CORSAIR Hydro CW-9060024-WW All-in-One Liquid CPU Cooler Cooler','CORSAIR Hydro CW-9060024-WW All-in-One Liquid CPU Cooler Cooler.',155,'CORSAIR',6);
-- insert into product(productName,productDescription,price,manufacturer,categoryId) values('SilverStone PF120-ARGB Permafrost Cooler','SilverStone PF120-ARGB Permafrost Cooler.',165,'SilverStone',6);

-- insert into product(productName,productDescription,price,manufacturer,categoryId) values('SanDisk Pendrive','SanDisk Ultra Luxe USB 3.1 128 GB Pen Drive.',25,'SanDisk',7);
-- insert into product(productName,productDescription,price,manufacturer,categoryId) values('SanDisk Pendrive','SanDisk SDIX70N-128G-GN6NE 128 GB Pen Drive.',35,'SanDisk',7);
-- insert into product(productName,productDescription,price,manufacturer,categoryId) values('Samsung External Hard disk','SAMSUNG T5 500 GB.',85,'Samsung',7);
-- insert into product(productName,productDescription,price,manufacturer,categoryId) values('SanDisk External hard disk','SanDisk 1 TB super fast external hard disk .',155,'SanDisk',7);
-- insert into product(productName,productDescription,price,manufacturer,categoryId) values('Seagate 1 TB External Solid State Drive','Seagate 1 TB External Solid State Drive.',300,'Seagate',7);

-- insert into product(productName,productDescription,price,manufacturer,categoryId) values('Logitech Gaming Mouse','Logitech G102 Light Sync Wired Optical Gaming Mouse.',25,'SanDisk',8);
-- insert into product(productName,productDescription,price,manufacturer,categoryId) values('HP Gaming Mouse','HP G200 Wired Optical Gaming Mouse.',25,'SanDisk',8);
-- insert into product(productName,productDescription,price,manufacturer,categoryId) values('Zebronics Gaming Mouse','ZEBRONICS Zeb-Clash Wired Optical Gaming Mouse.',15,'Samsung',8);
-- insert into product(productName,productDescription,price,manufacturer,categoryId) values('HP Gaming Mouse','HP M260 Wired Optical Gaming Mouse.',25,'HP',8);
-- insert into product(productName,productDescription,price,manufacturer,categoryId) values('HP Gaming Mouse','HP M100 Wired Optical Gaming Mouse.',10,'HP',8);

-- insert into product(productName,productDescription,price,manufacturer,categoryId) values('Acer Gaming Monitor','Acer 23.6 inch Full HD LED Backlit TN Panel Gaming Monitor.',125,'Acer',9);
-- insert into product(productName,productDescription,price,manufacturer,categoryId) values('MSI Gaming Monitor','MSI 23.6 inch Curved Full HD VA Panel Gaming Monitor.',125,'MSI',9);
-- insert into product(productName,productDescription,price,manufacturer,categoryId) values('Dell Gaming Monitor','DELL 24 Inch Curved Full HD LED Backlit VA Panel Gaming Monitor.',115,'DELL',9);
-- insert into product(productName,productDescription,price,manufacturer,categoryId) values('LG Gaming Monitor','LG 24 Inch Curved Full HD LED Backlit VA Panel Gaming Monitor.',125,'LG',9);
-- insert into product(productName,productDescription,price,manufacturer,categoryId) values('Acer Gaming Monitor','LG 27 inch Full HD LED Backlit IPS Panel Height Adjustable Gaming Monitor.',110,'Acer',9);

-- insert into product(productName,productDescription,price,manufacturer,categoryId) values('Artis PSU','Artis VIP500 GOLD Super Silent Power Supply 500 Watts PSU.',125,'Artis',10);
-- insert into product(productName,productDescription,price,manufacturer,categoryId) values('Artis PSU','Artis VIP 400R Plus 400 Watts PSU.',125,'Artis',10);
-- insert into product(productName,productDescription,price,manufacturer,categoryId) values('Frontech PSU','Frontech PS-0004 SMPS 450 Watts PSU.',115,'Frontech',10);
-- insert into product(productName,productDescription,price,manufacturer,categoryId) values('Zebronics PSU','ZEBRONICS ZEB 450 450 Watts PSU.',125,'Zebronics',10);
-- insert into product(productName,productDescription,price,manufacturer,categoryId) values('Crosair PSU','CORSAIR CV650 650 Watts PSU.',110,'Corsair',10);
