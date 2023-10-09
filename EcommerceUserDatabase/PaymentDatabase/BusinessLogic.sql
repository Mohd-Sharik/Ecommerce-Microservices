
CREATE TABLE TB_OS_PAYMENTS
(
	ID					NUMBER(38,0) NOT NULL,
	ORDER_ID			NUMBER(38,0),
	PAYMENT_MODE		VARCHAR2(200),
	REFERENCE_NUM		VARCHAR2(500),
	PAMENT_STATUS		VARCHAR2(500),
	AMOUNT				NUMBER(30,20,
	CRT_TS				TIMESTAMP(6),
	CRT_BY				VARCHAR2(50)
);
ALTER TABLE TB_OS_PAYMENTS ADD CONSTRAINT OS_PAYMENTS_PK PRIMARY KEY(ID);