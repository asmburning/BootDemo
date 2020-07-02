DROP TABLE IF EXISTS T_BOOK;

CREATE TABLE T_BOOK
(
	id BIGINT(20) NOT NULL COMMENT 'ID',
	book_name VARCHAR(255) NOT NULL COMMENT 'bookName',
	remark VARCHAR(255)  COMMENT 'remark',
	quote VARCHAR(255)  COMMENT 'quote',
	rating VARCHAR(255)  COMMENT 'rating',
	create_time TIMESTAMP WITHOUT TIME ZONE DEFAULT now() COMMENT 'create_time',
	update_time TIMESTAMP WITHOUT TIME ZONE DEFAULT now() COMMENT 'update_time',
	PRIMARY KEY (id)
);