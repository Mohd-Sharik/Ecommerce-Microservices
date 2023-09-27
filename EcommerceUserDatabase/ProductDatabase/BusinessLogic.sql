
CREATE TABLE TB_OS_CATAGORY
(
	ID			NUMBER(38,0) NOT NULL,
	NAME		VARCHAR2(50),
	DESCR		VARCHAR2(200),
	CRT_TS		TIMESTAMP(6),
	CRT_BY		VARCHAR2(50),
	UPD_TS		TIMESTAMP(6),
	UPD_BY		VARCHAR2(50),
	DLT_TS		TIMESTAMP(6),
	DLT_BY		VARCHAR2(50)
);

ALTER TABLE TB_OS_CATAGORY ADD CONSTRAINT OS_CATAGORY_PK PRIMARY KEY(ID);



CREATE TABLE TB_OS_INVENTORY
(
	ID			NUMBER(38,0) NOT NULL,
	QUANTITY	NUMBER(38,0),
	CRT_TS		TIMESTAMP(6),
	CRT_BY		VARCHAR2(50),
	UPD_TS		TIMESTAMP(6),
	UPD_BY		VARCHAR2(50),
	DLT_TS		TIMESTAMP(6),
	DLT_BY		VARCHAR2(50)
);
ALTER TABLE TB_OS_INVENTORY ADD CONSTRAINT OS_INVENTORY_PK PRIMARY KEY(ID);

CREATE TABLE TB_OS_PRODUCTS
(
	ID				NUMBER(38,0) NOT NULL,
	NAME			VARCHAR2(100),
	DESCR			VARCHAR2(2000),
	PRICE			DECIMAL(38,2),
	CATAGORY_ID	 	NUMBER(38,0),
	INVENTORY_ID 	NUMBER(38,0),
	DISCOUNT_ID		NUMBER(38,0),
	CRT_TS			TIMESTAMP(6),
	CRT_BY			VARCHAR2(50),
	UPD_TS			TIMESTAMP(6),
	UPD_BY			VARCHAR2(50),
	DLT_TS			TIMESTAMP(6),
	DLT_BY			VARCHAR2(50)
	
);
ALTER TABLE TB_OS_PRODUCTS ADD CONSTRAINT OS_PRODUCTS_PK PRIMARY KEY(ID);
ALTER TABLE TB_OS_PRODUCTS ADD CONSTRAINT OS_PRODUCTS_OS_CATAGORY_FK FOREIGN KEY(CATAGORY_ID) REFERENCES TB_OS_CATAGORY(ID);
ALTER TABLE TB_OS_PRODUCTS ADD CONSTRAINT OS_PRODUCTS_OS_INVENTORY_FK FOREIGN KEY(INVENTORY_ID) REFERENCES TB_OS_INVENTORY(ID);
