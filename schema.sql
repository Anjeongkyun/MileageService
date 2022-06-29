CREATE TABLE `tb_event` (
                            `event_id` bigint(20) NOT NULL AUTO_INCREMENT,
                            `type` varchar(255) DEFAULT NULL,
                            `action` varchar(255) DEFAULT NULL,
                            `review_id` varchar(255) DEFAULT NULL,
                            `content` varchar(255) DEFAULT NULL,
                            `point` bigint(20) DEFAULT NULL,
                            `photo` varchar(255) DEFAULT NULL,
                            `user_id` varchar(255) DEFAULT NULL,
                            `place_id` varchar(255) DEFAULT NULL,
                            `created_at` datetime DEFAULT NULL,
                            `updated_at` datetime DEFAULT NULL,
                            PRIMARY KEY (`event_id`),
                            KEY `event_FK_1` (`place_id`),
                            KEY `tb_event_FK` (`review_id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `tb_review` (
                             `review_id` varchar(255) NOT NULL,
                             `content` int(11) DEFAULT NULL,
                             `photo` int(11) DEFAULT NULL,
                             `created_at` datetime DEFAULT NULL,
                             `updated_at` datetime DEFAULT NULL,
                             PRIMARY KEY (`review_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `tb_point` (
                            `point_id` varchar(255) NOT NULL,
                            `point` bigint(20) DEFAULT NULL,
                            `created_at` datetime DEFAULT NULL,
                            `updated_at` datetime DEFAULT NULL,
                            PRIMARY KEY (`point_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `tb_place` (
                            `review_id` varchar(255) DEFAULT NULL,
                            `id` varchar(255) NOT NULL,
                            `created_at` datetime DEFAULT NULL,
                            `updated_at` datetime DEFAULT NULL,
                            PRIMARY KEY (`id`),
                            KEY `tb_place_FK` (`review_id`),
                            CONSTRAINT `tb_place_FK` FOREIGN KEY (`review_id`) REFERENCES `tb_review` (`review_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `tb_place_history` (
                                    `user_id` varchar(255) NOT NULL,
                                    `history_id` bigint(20) NOT NULL AUTO_INCREMENT,
                                    `review_id` varchar(255) DEFAULT NULL,
                                    `place_id` varchar(255) DEFAULT NULL,
                                    `created_at` datetime DEFAULT NULL,
                                    `updated_at` datetime DEFAULT NULL,
                                    PRIMARY KEY (`history_id`),
                                    KEY `tb_place_history_FK` (`place_id`),
                                    KEY `tb_place_history_FK_1` (`review_id`),
                                    CONSTRAINT `tb_place_history_FK` FOREIGN KEY (`place_id`) REFERENCES `tb_place` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `tb_point_history` (
                                    `history_id` bigint(20) NOT NULL AUTO_INCREMENT,
                                    `created_at` datetime(6) DEFAULT NULL,
                                    `updated_at` datetime(6) DEFAULT NULL,
                                    `event_id` bigint(20) NOT NULL,
                                    `point_id` varchar(255) NOT NULL,
                                    PRIMARY KEY (`history_id`),
                                    KEY `tb_point_history_FK` (`event_id`),
                                    KEY `tb_point_history_FK_1` (`point_id`),
                                    CONSTRAINT `tb_point_history_FK` FOREIGN KEY (`event_id`) REFERENCES `tb_event` (`event_id`),
                                    CONSTRAINT `tb_point_history_FK_1` FOREIGN KEY (`point_id`) REFERENCES `tb_point` (`point_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;