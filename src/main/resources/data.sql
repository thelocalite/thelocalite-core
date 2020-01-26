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
INSERT INTO `localite`.`product` ( `brand`, `category`, `description`, `image_url`, `mrp`, `name`) VALUES ( 'The Coca-Cola Company', 'Beverages', 'Can 330ml', 'https://raw.githubusercontent.com/thelocalite/localite-ng/1cd2bdb4345c58f002b0e77dbd239704c5f6cf37/src/assets/images/product/coke-zero.png', '35', 'Coca Cola Zero');
INSERT INTO `localite`.`product` ( `brand`, `category`, `description`, `image_url`, `mrp`, `name`) VALUES ( 'The Coca-Cola Company', 'Beverages', 'Can 330ml', 'https://raw.githubusercontent.com/thelocalite/localite-ng/1cd2bdb4345c58f002b0e77dbd239704c5f6cf37/src/assets/images/product/coke-diet.png', '35', 'Coca Cola Diet');
INSERT INTO `localite`.`product` ( `brand`, `category`, `description`, `image_url`, `mrp`, `name`) VALUES ( 'The Coca-Cola Company', 'Beverages', 'Can 330ml', 'https://raw.githubusercontent.com/thelocalite/localite-ng/1cd2bdb4345c58f002b0e77dbd239704c5f6cf37/src/assets/images/product/coke-original.png', '35', 'Coca Cola Original');
INSERT INTO `localite`.`product` ( `brand`, `category`, `description`, `image_url`, `mrp`, `name`) VALUES ( 'Nestle', 'Snacks', 'Veg Atta Noodles 70gm', 'https://raw.githubusercontent.com/thelocalite/localite-ng/1cd2bdb4345c58f002b0e77dbd239704c5f6cf37/src/assets/images/product/maggie-atta.png', '20', 'Maggie Veg Atta Noodles');
INSERT INTO `localite`.`product` ( `brand`, `category`, `description`, `image_url`, `mrp`, `name`) VALUES ( 'Nestle', 'Snacks', 'Oats Noodles 70gm', 'https://raw.githubusercontent.com/thelocalite/localite-ng/1cd2bdb4345c58f002b0e77dbd239704c5f6cf37/src/assets/images/product/maggie-oats.png', '20', 'Maggie Oats Noodles');
INSERT INTO `localite`.`product` ( `brand`, `category`, `description`, `image_url`, `mrp`, `name`) VALUES ( 'Britannia', 'Snacks', 'Cookies Butter 100gm', 'https://raw.githubusercontent.com/thelocalite/localite-ng/1cd2bdb4345c58f002b0e77dbd239704c5f6cf37/src/assets/images/product/cookie-butter.png', '20', 'Good Day Cookies Butter');
INSERT INTO `localite`.`product` ( `brand`, `category`, `description`, `image_url`, `mrp`, `name`) VALUES ( 'Britannia', 'Snacks', 'Cookies Chocolate Chip 100gm', 'https://raw.githubusercontent.com/thelocalite/localite-ng/1cd2bdb4345c58f002b0e77dbd239704c5f6cf37/src/assets/images/product/cookie-choco.png', '25', 'Good Day Cookies Chocolate Chip');
INSERT INTO `localite`.`product` ( `brand`, `category`, `description`, `image_url`, `mrp`, `name`) VALUES ( 'Britannia', 'Snacks', 'Cookies Cashew 100gm', 'https://raw.githubusercontent.com/thelocalite/localite-ng/1cd2bdb4345c58f002b0e77dbd239704c5f6cf37/src/assets/images/product/cookie-cashew.png', '25', 'Good Day Cookies Cashew');

-- Vendor

-- INSERT INTO `localite`.`vendor` (`specific_price`,  `id`) VALUES ('10', '1', '1');
-- INSERT INTO `localite`.`vendor` (`specific_price`,  `id`) VALUES ('11', '2', '1');
-- INSERT INTO `localite`.`vendor` (`specific_price`,  `id`) VALUES ('30', '3', '1');
-- INSERT INTO `localite`.`vendor` ( `id`) VALUES ('4', '1');
-- INSERT INTO `localite`.`vendor` (`specific_price`,  `id`) VALUES ('32', '5', '1');
-- INSERT INTO `localite`.`vendor` ( `id`) VALUES ('6', '2');
-- INSERT INTO `localite`.`vendor` ( `id`) VALUES ('7', '2');
-- INSERT INTO `localite`.`vendor` ( `id`) VALUES ('8', '2');
-- INSERT INTO `localite`.`vendor` ( `id`) VALUES ('9', '2');
-- INSERT INTO `localite`.`vendor` ( `id`) VALUES ('10', '2');
-- INSERT INTO `localite`.`vendor` (`specific_price`,  `id`) VALUES ('11', '1', '3');
-- INSERT INTO `localite`.`vendor` ( `id`) VALUES ('3', '3');
-- INSERT INTO `localite`.`vendor` ( `id`) VALUES ('5', '3');
-- INSERT INTO `localite`.`vendor` (`specific_price`,  `id`) VALUES ('12', '7', '3');
-- INSERT INTO `localite`.`vendor` (`specific_price`,  `id`) VALUES ('15', '9', '3');
-- INSERT INTO `localite`.`vendor` (`specific_price`,  `id`) VALUES ('12', '2', '4');
-- INSERT INTO `localite`.`vendor` ( `id`) VALUES ('4', '4');
-- INSERT INTO `localite`.`vendor` ( `id`) VALUES ('6', '4');
-- INSERT INTO `localite`.`vendor` ( `id`) VALUES ('8', '4');
-- INSERT INTO `localite`.`vendor` ( `id`) VALUES ('10', '4');
-- INSERT INTO `localite`.`vendor` ( `id`) VALUES ('1', '5');
-- INSERT INTO `localite`.`vendor` (`specific_price`,  `id`) VALUES ('12', '2', '5');
-- INSERT INTO `localite`.`vendor` ( `id`) VALUES ('3', '5');
-- INSERT INTO `localite`.`vendor` (`specific_price`,  `id`) VALUES ('30', '4', '5');
-- INSERT INTO `localite`.`vendor` ( `id`) VALUES ('5', '5');
-- INSERT INTO `localite`.`vendor` ( `id`) VALUES ('6', '5');
-- INSERT INTO `localite`.`vendor` ( `id`) VALUES ('7', '5');
-- INSERT INTO `localite`.`vendor` ( `id`) VALUES ('8', '5');
-- INSERT INTO `localite`.`vendor` ( `id`) VALUES ('9', '5');
-- INSERT INTO `localite`.`vendor` ( `id`) VALUES ('10', '5');
