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
make VARCHAR(50) NOT NULL,
productName VARCHAR(200) NOT NULL,
SIZE VARCHAR(100) NOT NULL,
productDescription VARCHAR(5000),
PRICE INT  NOT NULL,
AVAILABLEQUANTITY int NOT NULL,
FOREIGN KEY (productId) REFERENCES Product(productId)
);

create table MotherBoard (
productId INT NOT NULL PRIMARY KEY,
make VARCHAR(50) NOT NULL,
productName VARCHAR(200) NOT NULL,
chipSet VARCHAR(100) NOT NULL,
SIZE VARCHAR(100) NOT NULL,
productDescription VARCHAR(5000),
PRICE INT  NOT NULL,
AVAILABLEQUANTITY int NOT NULL,
FOREIGN KEY (productId) REFERENCES Product(productId)
);

create table GRAPHICCARD (
productId INT NOT NULL PRIMARY KEY,
make VARCHAR(50) NOT NULL,
productName VARCHAR(200) NOT NULL,
chipSet VARCHAR(100) NOT NULL,
MODEL VARCHAR(100) NOT NULL,
productDescription VARCHAR(5000),
PRICE INT  NOT NULL,
AVAILABLEQUANTITY int NOT NULL,
FOREIGN KEY (productId) REFERENCES Product(productId)
);

create table PROCESSORS (
productId INT NOT NULL PRIMARY KEY,
make VARCHAR(50) NOT NULL,
productName VARCHAR(200) NOT NULL,
CORES VARCHAR(100) NOT NULL,
MODEL VARCHAR(100) NOT NULL,
productDescription VARCHAR(5000),
PRICE INT  NOT NULL,
AVAILABLEQUANTITY int NOT NULL,
FOREIGN KEY (productId) REFERENCES Product(productId)
);

create table RAM (
productId INT NOT NULL PRIMARY KEY,
make VARCHAR(50) NOT NULL,
productName VARCHAR(200) NOT NULL,
SIZE INT NOT NULL,
SPEED INT NOT NULL,
productDescription VARCHAR(5000),
PRICE INT  NOT NULL,
AVAILABLEQUANTITY int NOT NULL,
FOREIGN KEY (productId) REFERENCES Product(productId)
);

create table COOLING (
productId INT NOT NULL PRIMARY KEY,
make VARCHAR(50) NOT NULL,
productName VARCHAR(200) NOT NULL,
productDescription VARCHAR(5000),
PRICE INT  NOT NULL,
AVAILABLEQUANTITY int NOT NULL,
FOREIGN KEY (productId) REFERENCES Product(productId)
);

create table STORAGES (
productId INT NOT NULL PRIMARY KEY,
make VARCHAR(50) NOT NULL,
productName VARCHAR(200) NOT NULL,
productDescription VARCHAR(5000),
SIZE VARCHAR(100),
MODEL VARCHAR(100),
PRICE INT  NOT NULL,
AVAILABLEQUANTITY int NOT NULL,
FOREIGN KEY (productId) REFERENCES Product(productId)
);

create table POWERSUPPLY (
productId INT NOT NULL PRIMARY KEY,
make VARCHAR(50) NOT NULL,
productName VARCHAR(200) NOT NULL,
productDescription VARCHAR(5000) NOT NULL,
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
insert into COMPUTERCASES(productId,make,productName,productDescription,SIZE,PRICE,AVAILABLEQUANTITY) values(
	1,'FRONTECH','Frontech Computer Case Cabinet',
	'The Frontech cabinet ATX Cabinet is full of features that make your new system perform with real muscle.','LARGE',100,50);
insert into COMPUTERCASES(productId,make,productName,productDescription,SIZE,PRICE,AVAILABLEQUANTITY) values(
	2,'DEEPCOOL','DEEPCOOL MATREXX 40 Mid-Tower',
	'The DEEPCOOL cabinet ATX Cabinet is full of features that make your new system perform with real muscle.','MEDIUM',110,50);
insert into COMPUTERCASES(productId,make,productName,productDescription,SIZE,PRICE,AVAILABLEQUANTITY) values(
	3,'ANT','Ant Esports ICE-130AG Mid Tower',
	'The Ant cabinet ATX Cabinet is full of features that make your new system perform with real muscle.','SMALL',120,50);
insert into COMPUTERCASES(productId,make,productName,productDescription,SIZE,PRICE,AVAILABLEQUANTITY) values(
	4,'CORSAIR','Corsair Carbide SPEC-05 Mid-Tower Gaming Case',
	'The Corsair cabinet ATX Cabinet is full of features that make your new system perform with real muscle.','LARGE',130,50);
insert into COMPUTERCASES(productId,make,productName,productDescription,SIZE,PRICE,AVAILABLEQUANTITY) values(
	5,'ANT','Ant Esports ICE-200TG Mid Tower',
	'The ANT cabinet ATX Cabinet is full of features that make your new system perform with real muscle.','SMALL',140,50);

INSERT INTO PRODUCT(productType) VALUES('MOTHERBOARD');
INSERT INTO PRODUCT(productType) VALUES('MOTHERBOARD');
INSERT INTO PRODUCT(productType) VALUES('MOTHERBOARD');
INSERT INTO PRODUCT(productType) VALUES('MOTHERBOARD');
INSERT INTO PRODUCT(productType) VALUES('MOTHERBOARD');
insert into MOTHERBOARD(productId,make,productName,chipSet,SIZE,productDescription,PRICE,AVAILABLEQUANTITY) values(
	6,'MSI','MSI B450 TOMAHAWK MAX II AM4 AMD B450 SATA 6Gb/s ATX AMD Motherboard','AMD','ATX',
	'AMD B450 motherboard comes packed with Heavy-plated Gaming Heat Sinks.
	Supports 1st, 2nd and 3rd Gen AMD Ryzen / Ryzen with Radeon Vega Graphics and 2nd Gen AMD Ryzen with Radeon Graphics/Athlon with Radeon Vega Graphics Desktop Processors for Socket AM4. 
	For AMD Ryzen Gen3 (R5/R7/R9): Supports DDR4 4133/ 4000/ 3466/ 3200/ 3066/ 3000/ 2933/ 2800/ 2667 MHz by A-XMP OC MODE. 
	For AMD Other CPU: Supports DDR4 3466/ 3200/ 3066/ 3000/ 2933/ 2800/ 2667 MHz by A-XMP OC MODE. 
	Supports DDR4 2667/ 2400/ 2133/ 1866 MHz by JEDEC',110,50);
insert into MOTHERBOARD(productId,make,productName,chipSet,SIZE,productDescription,PRICE,AVAILABLEQUANTITY) values(
	7,'ASRock','ASRock B550 Phantom Gaming-ITX/ax AM4 AMD B550 SATA 6Gb/s Mini ITX AMD Motherboard','AMD','Mini-ITX',
	'BIOS update might require for AMD Zen 3 Ryzen 5000 series CPU. AMD B550. 
	Supports AMD Ryzen 5000 Series/4000 G-Series/3000 Series Processors. DDR4 5400(OC)+/5300(OC)/5200(OC)/5100(OC)/5000(OC)/4933(OC)/4866(OC)/4800(OC)/4733(OC)/4666(OC)/4600(OC)/4533(OC)/4466(OC)/4400(OC)/4333(OC)/4266(OC)/4200(OC)/4133(OC)/4000(OC)/3866(OC)/3800(OC)/3733(OC)/3600(OC)/3466(OC)/3200/2933/2667/2400/2133(AMD Ryzen series APUs (Renoir)). 
	DDR4 5100(OC)+/5000(OC)/4933(OC)/4866(OC)/4800(OC)/4733(OC)/4666(OC)/4600(OC)/4533(OC)/4466(OC)/4400(OC)/4333(OC)/4266(OC)/4200(OC)/4133(OC)/4000(OC)/3866(OC)/3800(OC)/3733(OC)/3600(OC)/3466(OC)/3200/2933/2667/2400/2133 (AMD Ryzen series CPUs (Matisse))',150,50);
insert into MOTHERBOARD(productId,make,productName,chipSet,SIZE,productDescription,PRICE,AVAILABLEQUANTITY) values(
	8,'GIGABYTE','GIGABYTE Z690 AERO G DDR4 LGA 1700 Intel Z690 ATX Motherboard with DDR4, Quad M.2, PCIe 5.0, USB 3.2 Gen2X2 Type-C, WiFi 6, Intel 2.5 GbE LAN','INTEL','ATX',
	'Intel Z690. Intel LGA 1700 Socket: Supports 12th Gen Intel Core Series Processors. 
	Comprehensive Thermal Design: Advanced Thermal Architecture, Enlarged Thermal Guards. 
	Next Gen Connectivity: PCIe 5.0, VisionLINK I/O, Quad NVMe PCIe 4.0 x4 M.2, SuperSpeed USB 3.2 Gen 2x2 Type-C. 
	Fast Networking: WiFi 6 802.11ax, Intel 2.5 GbE LAN, BT5. 
	Fine Tuning Features: RGB FUSION 2.0, Supports Addressable LED & RGB LED Strips, Smart Fan 6, Q-Flash Plus Update BIOS without installing, CPU, Memory, and GPU. 
	Dedicated LGA1700 mounting bracket is required',290,50);
insert into MOTHERBOARD(productId,make,productName,chipSet,SIZE,productDescription,PRICE,AVAILABLEQUANTITY) values(
	9,'ASUS','ASUS Prime Z690-A LGA 1700 Intel 12th ATX Motherboard- 16+1 DrMOS, PCIe 5.0, DDR5, 4x M.2, Intel 2.5 Gb LAN, USB 3.2 Gen 2 Front Panel Type-C, Thunderbolt 4, Aura Sync RGB Lighting','INTEL','ATX',
	'Intel LGA 1700 socket: Ready for 12th Gen Intel Core processors and Windows 11, support PCIe 5.0 and DDR5. 
	AI Motherboard : AI overclocking, AI cooling and Two-way AI noise cancellation. 
	Enhanced Power Solution: 16+1 DrMOS, ProCool sockets, alloy chokes and durable capacitors for stable power delivery. 
	Next-gen connectivity: DDR5 memory, PCIe 5.0, Intel 2.5 Gb Ethernet, USB 3.2 Gen2x2 Type-C, front panel USB 3.2 Gen 2 Type-C, Thunderbolt 4 header support. 
	Boosted Memory Performance: Careful routing of traces and vias, plus ground layer optimizations to preserve signal integrity for improved memory overclocking with ASUS OptiMem II. 
	New Prime Aesthetics: New ID design, sliver scheme, ASUS-exclusive Aura Sync RGB lighting, including RGB headers and Gen 2 addressable headers. 
	All ASUS Z690 Motherboards designed with dual mounting holes compatible with both Intel LGA1700 and LGA1200 cooling brackets.',300,50);
insert into MOTHERBOARD(productId,make,productName,chipSet,SIZE,productDescription,PRICE,AVAILABLEQUANTITY) values(
	10,'GIGABYTE','GIGABYTE Z690 AORUS MASTER LGA 1700 Intel Z690 EATX Motherboard with DDR5, 5x M.2, PCIe 5.0, USB 3.2 Gen2X2 Type-C, Intel WiFi 6E, AQUANTIA 10GbE LAN','INTEL','ATX',
	'Intel Z690. Intel LGA 1700 Socket: Supports 12th Gen Intel Core Series Processors. DDR5 Compatible: Dual Channel Non-ECC Unbuffered DDR5.
	Commanding Power Design: 19+1+2 Phases Direct VRM Design with 105A Power Stage with Tantalum Polymer Capacitors. Cutting-Edge Thermal Design: Thermal Reactive Armor with NanoCarbon Fins-Array III, Heatsink. 
	Direct Touch Heatpipe II, NanoCarbon Baseplate, Thermal Guards XTREME. 5 x Ultra-Fast NVMe PCIe 4.0/3.0 x4 M.2 with Thermal Guards. AQUANTIA 10GbE BASE-T LAN. 
	Intel WIFI 6E 802.11ax 2T2R & BT5 with AORUS Antenna. Audio Solution with ESS Sabre ES9118 125dB on Rear Audio. Fine Tuning Features: RGB FUSION 2.0, Supports Addressable LED & RGB LED Strips, Smart Fan 6, Q-Flash Plus Update BIOS without installing, CPU, Memory, and GPU. 
	Dedicated LGA1700 mounting bracket is required',470,50);

INSERT INTO PRODUCT(productType) VALUES('GRAPHICCARD');
INSERT INTO PRODUCT(productType) VALUES('GRAPHICCARD');
INSERT INTO PRODUCT(productType) VALUES('GRAPHICCARD');
INSERT INTO PRODUCT(productType) VALUES('GRAPHICCARD');
INSERT INTO PRODUCT(productType) VALUES('GRAPHICCARD');
insert into GRAPHICCARD(productId,make,productName,chipSet,MODEL,productDescription,PRICE,AVAILABLEQUANTITY) values(
	11,'ASUS','ASUS TUF Gaming NVIDIA GeForce RTX 3080 V2 OC Edition Graphics Card (PCIe 4.0, 10GB GDDR6X, LHR, HDMI 2.1, DisplayPort 1.4a, Dual Ball Fan Bearings, Military-grade Certification, GPU Tweak II)',
	'NVIDIA','3080','10GB 320-Bit GDDR6X. Core Clock 1440 MHz. Boost Clock OC Mode: 1815 MHz. Gaming Mode (Default): 1785 MHz. 2 x HDMI 2.1 3 x DisplayPort 1.4a. 
	8704 CUDA Cores. PCI Express 4.0 x16.',1580,20);
insert into GRAPHICCARD(productId,make,productName,chipSet,MODEL,productDescription,PRICE,AVAILABLEQUANTITY) values(
	12,'GIGABYTE','GIGABYTE Gaming OC GeForce RTX 3060 12GB GDDR6 PCI Express 4.0 ATX Video Card GV-N3060GAMING OC-12GD (rev. 2.0) (LHR)',
	'NVIDIA','3060','12GB 192-Bit GDDR6. Boost Clock 1837 MHz. 2 x HDMI 2.1 2 x DisplayPort 1.4a. 3584 CUDA Cores. PCI Express 4.0',850,20);
insert into GRAPHICCARD(productId,make,productName,chipSet,MODEL,productDescription,PRICE,AVAILABLEQUANTITY) values(
	13,'MSI','MSI Gaming GeForce RTX 3080 10GB GDDR6X PCI Express 4.0 ATX Video Card RTX 3080 GAMING Z TRIO 10G LHR',
	'NVIDIA','3080','10GB 320-Bit GDDR6X. Boost Clock 1830 MHz. 1 x HDMI 2.1 3 x DisplayPort 1.4a. 8704 CUDA Cores. PCI Express 4.0 x16. 
	This GeForce RTX 3080 graphics card with LHR (lite hash rate) delivers 43 MH/s ETH hash rate (estimate).',1535,20);
insert into GRAPHICCARD(productId,make,productName,chipSet,MODEL,productDescription,PRICE,AVAILABLEQUANTITY) values(
	14,'ASRock','ASRock OC Formula Radeon RX 6900 XT 16GB GDDR6 PCI Express 4.0 ATX Video Card RX6900XT OCF 16G',
	'AMD','6900','16GB Memory 256-Bit GDDR6. Max Reoslution of 7680 x 4320. Core Clock 2125 MHz. Boost Clock 2475 MHz. 
	1 x HDMI 2.1 VRR 3 x DisplayPort 1.4 with DSC. 5120 Stream Processors. PCI Express 4.0',1600,20);
insert into GRAPHICCARD(productId,make,productName,chipSet,MODEL,productDescription,PRICE,AVAILABLEQUANTITY) values(
	15,'Yeston','Yeston Radeon RX6800XT 16GB D6 GDDR6 256bit 7nm Desktop computer PC Video Graphics Cards support PCI-Express 4.0 2*DP+1*HDMI-compatible +1*Type c RGB light effect Fragrant graphics card',
	'AMD','6800','Core code and process: Navi 21 / 7nm. Unified shaders: 4608. Core frequency/Video frequency:2065-2310MHz(core game/acceleration frequency) / 16GHz (video frequency). 
	Video memory capacity and specification: 16G/ 256bit /GDDR6. Infinity Cache: 128MB. 3D features: full DirectX 12 / Ray tracing. OS feature: Win10 64. 
	Radiator:3 Fans + ARGB synchronization. Other features: AMD liquidvr ™ Technology, AMD freesync ™ Technology 2 ™ VR Ready. Bus interface: PCI Express 4.0. 
	Output interface: DP (1.4 with DSC) * 2 + HDMI-compatible (2.1 VRR and FRL) + Type-C. External power supply: 8 + 8 pin (Power supply above 750W)',1530,20);

-- INSERT INTO PRODUCT(productType) VALUES('PROCESSORS');
-- INSERT INTO PRODUCT(productType) VALUES('PROCESSORS');
-- INSERT INTO PRODUCT(productType) VALUES('PROCESSORS');
-- INSERT INTO PRODUCT(productType) VALUES('PROCESSORS');
-- INSERT INTO PRODUCT(productType) VALUES('PROCESSORS');

-- INSERT INTO PRODUCT(productType) VALUES('RAM');
-- INSERT INTO PRODUCT(productType) VALUES('RAM');
-- INSERT INTO PRODUCT(productType) VALUES('RAM');
-- INSERT INTO PRODUCT(productType) VALUES('RAM');
-- INSERT INTO PRODUCT(productType) VALUES('RAM');

-- INSERT INTO PRODUCT(productType) VALUES('COOLING');
-- INSERT INTO PRODUCT(productType) VALUES('COOLING');
-- INSERT INTO PRODUCT(productType) VALUES('COOLING');
-- INSERT INTO PRODUCT(productType) VALUES('COOLING');
-- INSERT INTO PRODUCT(productType) VALUES('COOLING');

-- INSERT INTO PRODUCT(productType) VALUES('STORAGES');
-- INSERT INTO PRODUCT(productType) VALUES('STORAGES');
-- INSERT INTO PRODUCT(productType) VALUES('STORAGES');
-- INSERT INTO PRODUCT(productType) VALUES('STORAGES');
-- INSERT INTO PRODUCT(productType) VALUES('STORAGES');

-- INSERT INTO PRODUCT(productType) VALUES('POWERSUPPLY');
-- INSERT INTO PRODUCT(productType) VALUES('POWERSUPPLY');
-- INSERT INTO PRODUCT(productType) VALUES('POWERSUPPLY');
-- INSERT INTO PRODUCT(productType) VALUES('POWERSUPPLY');
-- INSERT INTO PRODUCT(productType) VALUES('POWERSUPPLY');