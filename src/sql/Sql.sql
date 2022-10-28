-- 1. Create 3 tables
CREATE TABLE `clients` (
    `id` int(10) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `name` varchar(20) NOT NULL,
    `address` varchar(40),
    `phone` char(12)
);
CREATE TABLE `categories` (
    `id` int(10) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `name` varchar(20) NOT NULL
);
CREATE TABLE `orders` (
    `id` int(10) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `client_id` int(10) NOT NULL,
    `category_id` int(10) NOT NULL,
    `time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `price` int(10) NOT NULL DEFAULT 0,
    FOREIGN KEY (`client_id`) REFERENCES `clients` (`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE,
    FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);

-- 2. Insert script
INSERT INTO `clients` (`name`, `address`, `phone`) VALUES
('Иванов И.И.', 'Пушкина 1', '+79181239801'),
('Путин В.В.', 'Красная 1', NULL),
('Стетхем Д.', NULL, NULL),
('Добкин А.', 'Заставская 22', '+79006523441');
INSERT INTO `categories` (`name`) VALUES
('Оборудование'),
('Запчасти'),
('Услуги');
INSERT INTO `orders` (`client_id`, `category_id`, `time`, `price`) VALUES
('2', '3', NOW(), 1000),
('2', '1', NOW() - INTERVAL 1 HOUR, 9999),
('3', '2', NOW() - INTERVAL 1 DAY, 777),
('4', '3', '2022-03-02 09:00:00', 1),
('1', '2', NOW() + INTERVAL 1 HOUR, 0),
('4', '1', '2022-03-02 18:00:00', 5);

-- 3. Update script (by specific parameter)
UPDATE `clients` SET `id` = 5 WHERE `name` = 'Путин В.В.';

-- 4. Delete script (by specific parameter)
DELETE FROM `categories` WHERE `name` = 'Запчасти';

-- 5. Delete script (all)
TRUNCATE `orders`;

-- 6. Get script (with between/in/like)
SELECT * FROM `orders` WHERE `time` BETWEEN NOW() - INTERVAL 3 DAY AND NOW() + INTERVAL 3 DAY;
SELECT * FROM `categories` WHERE `name` IN ('Оборудование', 'Запчасти');
SELECT * FROM `clients` WHERE `phone` LIKE '+79%';

-- 7. Get from all 3 tables (with join)
SELECT * FROM `orders`
INNER JOIN `categories` ON `category_id` = `categories`.`id`
INNER JOIN `clients` ON `client_id` = `clients`.`id` ORDER BY `time`;

-- 8. Get amount in all 3 tables
SELECT COUNT(*) FROM `clients`
UNION
SELECT COUNT(*) FROM `categories`
UNION
SELECT COUNT(*) FROM `orders`

-- 9. Aggregate function (sum)
SELECT `client_id`, SUM(`price`) AS 'Total of all orders' FROM `orders` GROUP BY `client_id`;