/* drop database localite; */
/* create database localite; */
use localite;

-- Helper Queries


-- show tables;
-- drop table product;
-- drop table vendor;

-- select * from product;
-- select * from vendor;
-- select * from vendor;

-- Vendors

INSERT INTO `localite`.`vendor` ( `description`, `image_url`, `name`) VALUES ( 'Daily Groceries', 'https://raw.githubusercontent.com/thelocalite/localite-ng/master/src/assets/images/store/more.png', 'More Store');
INSERT INTO `localite`.`vendor` ( `description`, `image_url`, `name`) VALUES ( 'Medicines and health related products', 'https://raw.githubusercontent.com/thelocalite/localite-ng/master/src/assets/images/store/apollo.png', 'Apollo Pharmacy');
INSERT INTO `localite`.`vendor` ( `description`, `image_url`, `name`) VALUES ( 'Household items and groceries', 'https://raw.githubusercontent.com/thelocalite/localite-ng/master/src/assets/images/store/dmart.png', 'D-Mart');
INSERT INTO `localite`.`vendor` ( `description`, `image_url`, `name`) VALUES ( 'Household items and groceries', 'https://raw.githubusercontent.com/thelocalite/localite-ng/master/src/assets/images/store/star.png', 'Star Bazaar');
INSERT INTO `localite`.`vendor` ( `description`, `image_url`, `name`) VALUES ( 'Household items and groceries', 'https://raw.githubusercontent.com/thelocalite/localite-ng/dd7f68c90427853a0c31493eeb8951d36d3e8f4b/src/assets/images/store/smart.png', 'Reliance Smart');

-- Products

INSERT INTO `localite`.`product` ( `brand`, `category`, `description`, `image_url`, `mrp`, `name`) VALUES ( 'Nestle', 'Snacks', 'Masala Noodles 70gm', 'https://raw.githubusercontent.com/thelocalite/localite-ng/1cd2bdb4345c58f002b0e77dbd239704c5f6cf37/src/assets/images/product/maggie-masala.png', '12', 'Maggie Masala Noodles');
INSERT INTO `localite`.`product` ( `brand`, `category`, `description`, `image_url`, `mrp`, `name`) VALUES ( 'Nestle', 'Snacks', 'Chicken Noodles 70gm', 'https://raw.githubusercontent.com/thelocalite/localite-ng/1cd2bdb4345c58f002b0e77dbd239704c5f6cf37/src/assets/images/product/maggie-chicken.png', '15', 'Maggie Chicken Noodles');
INSERT INTO `localite`.`product` ( `brand`, `category`, `description`, `image_url`, `mrp`, `name`) VALUES ( 'Nestle', 'Snacks', 'Veg Atta Noodles 70gm', 'https://raw.githubusercontent.com/thelocalite/localite-ng/1cd2bdb4345c58f002b0e77dbd239704c5f6cf37/src/assets/images/product/maggie-atta.png', '20', 'Maggie Veg Atta Noodles');
INSERT INTO `localite`.`product` ( `brand`, `category`, `description`, `image_url`, `mrp`, `name`) VALUES ( 'Nestle', 'Snacks', 'Oats Noodles 70gm', 'https://raw.githubusercontent.com/thelocalite/localite-ng/1cd2bdb4345c58f002b0e77dbd239704c5f6cf37/src/assets/images/product/maggie-oats.png', '20', 'Maggie Oats Noodles');
INSERT INTO `localite`.`product` ( `brand`, `category`, `description`, `image_url`, `mrp`, `name`) VALUES ( 'Britannia', 'Snacks', 'Cookies Butter 100gm', 'https://raw.githubusercontent.com/thelocalite/localite-ng/1cd2bdb4345c58f002b0e77dbd239704c5f6cf37/src/assets/images/product/cookie-butter.png', '20', 'Good Day Cookies Butter');
INSERT INTO `localite`.`product` ( `brand`, `category`, `description`, `image_url`, `mrp`, `name`) VALUES ( 'Britannia', 'Snacks', 'Cookies Chocolate Chip 100gm', 'https://raw.githubusercontent.com/thelocalite/localite-ng/1cd2bdb4345c58f002b0e77dbd239704c5f6cf37/src/assets/images/product/cookie-choco.png', '25', 'Good Day Cookies Chocolate Chip');
INSERT INTO `localite`.`product` ( `brand`, `category`, `description`, `image_url`, `mrp`, `name`) VALUES ( 'Britannia', 'Snacks', 'Cookies Cashew 100gm', 'https://raw.githubusercontent.com/thelocalite/localite-ng/1cd2bdb4345c58f002b0e77dbd239704c5f6cf37/src/assets/images/product/cookie-cashew.png', '25', 'Good Day Cookies Cashew');
INSERT INTO `localite`.`product` ( `brand`, `category`, `description`, `image_url`, `mrp`, `name`) VALUES ( 'The Coca-Cola Company', 'Beverages', 'Can 330ml', 'https://raw.githubusercontent.com/thelocalite/localite-ng/1cd2bdb4345c58f002b0e77dbd239704c5f6cf37/src/assets/images/product/coke-zero.png', '35', 'Coca Cola Zero');
INSERT INTO `localite`.`product` ( `brand`, `category`, `description`, `image_url`, `mrp`, `name`) VALUES ( 'The Coca-Cola Company', 'Beverages', 'Can 330ml', 'https://raw.githubusercontent.com/thelocalite/localite-ng/1cd2bdb4345c58f002b0e77dbd239704c5f6cf37/src/assets/images/product/coke-diet.png', '35', 'Coca Cola Diet');
INSERT INTO `localite`.`product` ( `brand`, `category`, `description`, `image_url`, `mrp`, `name`) VALUES ( 'The Coca-Cola Company', 'Beverages', 'Can 330ml', 'https://raw.githubusercontent.com/thelocalite/localite-ng/1cd2bdb4345c58f002b0e77dbd239704c5f6cf37/src/assets/images/product/coke-original.png', '35', 'Coca Cola Original');


-- Product_Vendor

INSERT INTO `localite`.`product_vendor` (`vendor_id`, `product_id`, `vendor_specific_price`) VALUES ('1', '1', 23);
INSERT INTO `localite`.`product_vendor` (`vendor_id`, `product_id`, `vendor_specific_price`) VALUES ('1', '2', 23);
INSERT INTO `localite`.`product_vendor` (`vendor_id`, `product_id`, `vendor_specific_price`) VALUES ('1', '3', 23);
INSERT INTO `localite`.`product_vendor` (`vendor_id`, `product_id`, `vendor_specific_price`) VALUES ('1', '4', 23);
INSERT INTO `localite`.`product_vendor` (`vendor_id`, `product_id`, `vendor_specific_price`) VALUES ('2', '5', 23);
INSERT INTO `localite`.`product_vendor` (`vendor_id`, `product_id`, `vendor_specific_price`) VALUES ('2', '6', 23);
INSERT INTO `localite`.`product_vendor` (`vendor_id`, `product_id`, `vendor_specific_price`) VALUES ('2', '7', 23);
INSERT INTO `localite`.`product_vendor` (`vendor_id`, `product_id`, `vendor_specific_price`) VALUES ('3', '8', 23);
INSERT INTO `localite`.`product_vendor` (`vendor_id`, `product_id`, `vendor_specific_price`) VALUES ('3', '9', 23);
INSERT INTO `localite`.`product_vendor` (`vendor_id`, `product_id`, `vendor_specific_price`) VALUES ('3', '10', 23);
INSERT INTO `localite`.`product_vendor` (`vendor_id`, `product_id`, `vendor_specific_price`) VALUES ('4', '1', 23);
INSERT INTO `localite`.`product_vendor` (`vendor_id`, `product_id`, `vendor_specific_price`) VALUES ('5', '2', 23);
INSERT INTO `localite`.`product_vendor` (`vendor_id`, `product_id`, `vendor_specific_price`) VALUES ('4', '3', 23);
INSERT INTO `localite`.`product_vendor` (`vendor_id`, `product_id`, `vendor_specific_price`) VALUES ('5', '4', 23);
INSERT INTO `localite`.`product_vendor` (`vendor_id`, `product_id`, `vendor_specific_price`) VALUES ('4', '5', 23);
INSERT INTO `localite`.`product_vendor` (`vendor_id`, `product_id`, `vendor_specific_price`) VALUES ('5', '6', 23);
INSERT INTO `localite`.`product_vendor` (`vendor_id`, `product_id`, `vendor_specific_price`) VALUES ('4', '7', 23);
INSERT INTO `localite`.`product_vendor` (`vendor_id`, `product_id`, `vendor_specific_price`) VALUES ('5', '8', 23);
INSERT INTO `localite`.`product_vendor` (`vendor_id`, `product_id`, `vendor_specific_price`) VALUES ('4', '9', 23);
INSERT INTO `localite`.`product_vendor` (`vendor_id`, `product_id`, `vendor_specific_price`) VALUES ('5', '10', 23);


-- Service
insert into `localite`.`service` (`service_id`,`description`,`image_url`,`name`) VALUES (default,'Get Plumbers Near You for services at best prices. Book Now! Best Plumbing Services near you','https://raw.githubusercontent.com/thelocalite/localite-ng/master/src/assets/images/services/plumber.jpe','Plumber');
insert into `localite`.`service` (`service_id`,`description`,`image_url`,`name`) VALUES (default,'Get Maid Near You for services at best prices. Book Now! Best Maid Services near you','https://raw.githubusercontent.com/thelocalite/localite-ng/master/src/assets/images/services/maid.jpe','Maid');
insert into `localite`.`service` (`service_id`,`description`,`image_url`,`name`) VALUES (default,'Get Painter  Near You for services at best prices. Book Now! Best Painter  Services near you','https://raw.githubusercontent.com/thelocalite/localite-ng/master/src/assets/images/services/painting.jpe','Painter');
insert into `localite`.`service` (`service_id`,`description`,`image_url`,`name`) VALUES (default,'Get Electrician Near You for services at best prices. Book Now! Best Electrician Services near you','https://raw.githubusercontent.com/thelocalite/localite-ng/master/src/assets/images/services/electrician.jpe','Electrician');
insert into `localite`.`service` (`service_id`,`description`,`image_url`,`name`) VALUES (default,'Get Beautician Near You for services at best prices. Book Now! Best Beautician Services near you','https://raw.githubusercontent.com/thelocalite/localite-ng/master/src/assets/images/services/beautician.jpg','Beautician');
insert into `localite`.`service` (`service_id`,`description`,`image_url`,`name`) VALUES (default,'Get BabySitter Near You for services at best prices. Book Now! Best BabySitter Services near you','https://raw.githubusercontent.com/thelocalite/localite-ng/master/src/assets/images/services/babysitter.jpg','BabySitter');

-- technician
   -- plumber
insert into `localite`.`technician` (`id`,`address`,`contact`,`first_name`,`last_name`,`service_id`) VALUES (default,'pune','789456','sonali','mandloi',1);
insert into `localite`.`technician` (`id`,`address`,`contact`,`first_name`,`last_name`,`service_id`) VALUES (default,'pune','123456','divya','N',1);
insert into `localite`.`technician` (`id`,`address`,`contact`,`first_name`,`last_name`,`service_id`) VALUES (default,'pune','456123','aditya','tadepalli',1);
insert into `localite`.`technician` (`id`,`address`,`contact`,`first_name`,`last_name`,`service_id`) VALUES (default,'pune','753159','venkatesh','ransingh',1);
insert into `localite`.`technician` (`id`,`address`,`contact`,`first_name`,`last_name`,`service_id`) VALUES (default,'pune','125883','tanmay','Bindal',1);

--  maid

insert into `localite`.`technician` (`id`,`address`,`contact`,`first_name`,`last_name`,`service_id`) VALUES (default,'mumbai','789456','sudha','gupta',2);
insert into `localite`.`technician` (`id`,`address`,`contact`,`first_name`,`last_name`,`service_id`) VALUES (default,'pune','123456','jahnvi','vaidhya',2);
insert into `localite`.`technician` (`id`,`address`,`contact`,`first_name`,`last_name`,`service_id`) VALUES (default,'mumbai','456123','aditi','sharma',2);
insert into `localite`.`technician` (`id`,`address`,`contact`,`first_name`,`last_name`,`service_id`) VALUES (default,'pune','753159','riddhi','tripati',2);
insert into `localite`.`technician` (`id`,`address`,`contact`,`first_name`,`last_name`,`service_id`) VALUES (default,'pune','125883','mahima','mangle',2);


 -- painter
 insert into `localite`.`technician` (`id`,`address`,`contact`,`first_name`,`last_name`,`service_id`) VALUES (default,'pune','223456','divya','N',3);
insert into `localite`.`technician` (`id`,`address`,`contact`,`first_name`,`last_name`,`service_id`) VALUES (default,'pune','456123','aditya','tadepalli',3);
insert into `localite`.`technician` (`id`,`address`,`contact`,`first_name`,`last_name`,`service_id`) VALUES (default,'pune','753159','riddhi','tripati',3);
insert into `localite`.`technician` (`id`,`address`,`contact`,`first_name`,`last_name`,`service_id`) VALUES (default,'pune','125883','mahima','mangle',3);
insert into `localite`.`technician` (`id`,`address`,`contact`,`first_name`,`last_name`,`service_id`) VALUES (default,'pune','789456','sonali','mandloi',3);

 -- electrician
 insert into `localite`.`technician` (`id`,`address`,`contact`,`first_name`,`last_name`,`service_id`) VALUES (default,'pune','223456','john','doe',4);
insert into `localite`.`technician` (`id`,`address`,`contact`,`first_name`,`last_name`,`service_id`) VALUES (default,'pune','456123','shubham','joshi',4);
insert into `localite`.`technician` (`id`,`address`,`contact`,`first_name`,`last_name`,`service_id`) VALUES (default,'pune','753159','rahul','verma',4);
insert into `localite`.`technician` (`id`,`address`,`contact`,`first_name`,`last_name`,`service_id`) VALUES (default,'pune','125883','raj','malhotra',4);
insert into `localite`.`technician` (`id`,`address`,`contact`,`first_name`,`last_name`,`service_id`) VALUES (default,'pune','789456','simran','sehgal',4);

-- Beautician
 insert into `localite`.`technician` (`id`,`address`,`contact`,`first_name`,`last_name`,`service_id`) VALUES (default,'pune','223456','divya','N',5);
insert into `localite`.`technician` (`id`,`address`,`contact`,`first_name`,`last_name`,`service_id`) VALUES (default,'pune','456123','nikita','palli',5);
insert into `localite`.`technician` (`id`,`address`,`contact`,`first_name`,`last_name`,`service_id`) VALUES (default,'pune','753159','rahi','wakode',5);
insert into `localite`.`technician` (`id`,`address`,`contact`,`first_name`,`last_name`,`service_id`) VALUES (default,'pune','125883','renu','mangle',5);
insert into `localite`.`technician` (`id`,`address`,`contact`,`first_name`,`last_name`,`service_id`) VALUES (default,'pune','789456','sweeta','ghote',5);

 -- Baby Sitter
 insert into `localite`.`technician` (`id`,`address`,`contact`,`first_name`,`last_name`,`service_id`) VALUES (default,'pune','223456','ankshka','kolte',6);
insert into `localite`.`technician` (`id`,`address`,`contact`,`first_name`,`last_name`,`service_id`) VALUES (default,'pune','456123','ruchi','joshi',6);
insert into `localite`.`technician` (`id`,`address`,`contact`,`first_name`,`last_name`,`service_id`) VALUES (default,'pune','753159','Shripriya','verma',6);
insert into `localite`.`technician` (`id`,`address`,`contact`,`first_name`,`last_name`,`service_id`) VALUES (default,'pune','125883','rakhi','sehgal',6);
insert into `localite`.`technician` (`id`,`address`,`contact`,`first_name`,`last_name`,`service_id`) VALUES (default,'pune','789456','simran','rajput',6);
