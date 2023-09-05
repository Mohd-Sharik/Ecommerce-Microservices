CREATE TABLE TB_OS_DB_ERR
(
ID					NUMBER(30,0) NOT NULL,
REF_CD				VARCHAR2(100),
ERR_CD				VARCHAR2(100),
ERR_MSG				VARCHAR2(4000),
REF_NM				VARCHAR2(100),
CRT_BY				VARCHAR2(50) DEFAULT USER,
CRT_TS				TIMESTAMP(6) DEFAULT SYSTIMESTAMP

);
ALTER TABLE TB_OS_DB_ERR ADD CONSTRAINT OS_DB_ERR_PK PRIMARY KEY(ID);


-- new buisness tables for store data ;ike customers, products, etc.





-- ADDRESS TABLES FOR STORE DATABASE
CREATE TABLE TB_OS_COUNTRY		
(
	ID				NUMBER(38) NOT NULL ,
	NM   			VARCHAR2(50) NOT NULL,
	NUM_CD			NUMBER(5) NOT NULL,--91
	ALPHA_CD_2		VARCHAR2(2) NOT NULL,--IN
	ALPHA_CD_3		VARCHAR2(3) NOT NULL,--IND
	UPD_BY			VARCHAR2(50) DEFAULT USER NOT NULL,		
	UPD_TS			TIMESTAMP (6) DEFAULT SYSTIMESTAMP NOT NULL
); 

ALTER TABLE TB_OS_COUNTRY ADD CONSTRAINT OS_COUNTRY_PK PRIMARY KEY(ID); 



--dml script
CREATE TABLE TB_OS_STATE			
(
	ID				NUMBER(38,0) NOT NULL , 
	COUNTRY_ID 		NUMBER(38) NOT NULL ,
	CD				VARCHAR2(30),
	NM				VARCHAR2(100),
	UPD_BY			VARCHAR2(50) DEFAULT USER NOT NULL,		
	UPD_TS			TIMESTAMP (6) DEFAULT SYSTIMESTAMP NOT NULL
);

ALTER TABLE TB_OS_STATE ADD CONSTRAINT OS_STATE_PK PRIMARY KEY(ID); 
ALTER TABLE TB_OS_STATE ADD CONSTRAINT OS_STATE_OS_COUNTRY_FK FOREIGN KEY (COUNTRY_ID) REFERENCES TB_OS_COUNTRY (ID); 

--dml script
CREATE TABLE TB_OS_CITY			
(
	ID				NUMBER(38,0) NOT NULL , 
	STATE_ID		NUMBER(38,0) NOT NULL ,
	CD          	VARCHAR2(30),
	NM				VARCHAR2(100),
	UPD_BY			VARCHAR2(50) DEFAULT USER NOT NULL,		
	UPD_TS			TIMESTAMP (6) DEFAULT SYSTIMESTAMP NOT NULL
);

ALTER TABLE TB_OS_CITY ADD CONSTRAINT OS_CITY_PK PRIMARY KEY(ID); 
ALTER TABLE TB_OS_CITY ADD CONSTRAINT OS_CITY_OS_STATE_FK FOREIGN KEY (STATE_ID) REFERENCES TB_OS_STATE (ID);

--dml script
CREATE TABLE TB_OS_DELE				
(
	ID				NUMBER(38) NOT NULL , 
	CITY_ID			NUMBER(38) NOT NULL ,
	CD				VARCHAR2(30),
	NM				VARCHAR2(100),
	UPD_BY			VARCHAR2(50) DEFAULT USER NOT NULL,		
	UPD_TS			TIMESTAMP (6) DEFAULT SYSTIMESTAMP NOT NULL
);

ALTER TABLE TB_OS_DELE ADD CONSTRAINT OS_DELE_PK PRIMARY KEY(ID); 
ALTER TABLE TB_OS_DELE ADD CONSTRAINT OS_DELE_OS_CITY_FK FOREIGN KEY (CITY_ID) REFERENCES TB_OS_CITY (ID);

--dml script
CREATE TABLE TB_OS_COLONY			
(
	ID				NUMBER(38,0) NOT NULL , 
	DELEG_ID		NUMBER(38,0) NOT NULL , 	
	CD				VARCHAR2(30),
	NM				VARCHAR2(100),
	UPD_BY			VARCHAR2(50) DEFAULT USER NOT NULL,		
	UPD_TS			TIMESTAMP (6) DEFAULT SYSTIMESTAMP NOT NULL
);

ALTER TABLE TB_OS_COLONY ADD CONSTRAINT OS__COLONY_PK PRIMARY KEY(ID); 
ALTER TABLE TB_OS_COLONY ADD CONSTRAINT OS_COLONY_OS_DELE_FK FOREIGN KEY (DELEG_ID) REFERENCES TB_OS_DELE (ID);

--dml script
CREATE TABLE TB_OS_POSTAL			
(
	ID			NUMBER(38) NOT NULL , 
	COLONY_ID	NUMBER(38) NOT NULL , 		
	CD			VARCHAR2(30) NOT NULL,	
	NM			VARCHAR2(100),
	UPD_BY		VARCHAR2(50) DEFAULT USER NOT NULL,		
	UPD_TS		TIMESTAMP (6) DEFAULT SYSTIMESTAMP NOT NULL
);

ALTER TABLE TB_OS_POSTAL ADD CONSTRAINT OS_POSTAL_PK PRIMARY KEY(ID); 
ALTER TABLE TB_OS_POSTAL ADD CONSTRAINT OS_POSTAL_OS_COLO_FK FOREIGN KEY (COLONY_ID) REFERENCES TB_OS_COLONY (ID); 

CREATE TABLE TB_OS_ADRS
(
	ID					NUMBER(38,0) NOT NULL ,
	HOUSE_NO			VARCHAR2(10),
	STREET_NO			VARCHAR2(100),
	COLO_ID			    NUMBER(38,0) NOT NULL,		--FK
	DELEG_ID		    NUMBER(38,0)NOT NULL,		--FK
	CITY_ID			    NUMBER(38,0)NOT NULL,		--FK
	STATE_ID			NUMBER(38,0)NOT NULL,		--FK
	COUNTRY_ID 			NUMBER(38,0) NOT NULL , 		--FK
	POSTAL_ID			NUMBER(33,0) NOT NULL,           --FK
	ADDR_TYPE			VARCHAR2(20),	--permanent/residencial/office etc
	--ADDR_STS 			VARCHAR2(30),-- NOT NULL,	--(active,inactive)
	CRT_TS			    TIMESTAMP (6) DEFAULT SYSTIMESTAMP NOT NULL,			
	CRT_BY              VARCHAR2(50),
	UPD_TS			    TIMESTAMP (6) ,
	UPD_BY              VARCHAR2(50)

);
ALTER TABLE TB_OS_ADRS ADD CONSTRAINT OS_ADRS_PK PRIMARY KEY(ID);
ALTER TABLE TB_OS_ADRS ADD CONSTRAINT OS_ADRS_OS_COLONY_FK FOREIGN KEY (COLO_ID) REFERENCES TB_OS_COLONY(ID);
ALTER TABLE TB_OS_ADRS ADD CONSTRAINT OS_ADRS_OS_DELE_FK FOREIGN KEY(DELEG_ID) REFERENCES TB_OS_DELE(ID);
ALTER TABLE TB_OS_ADRS ADD CONSTRAINT OS_ADRS_OS_CITY_FK FOREIGN KEY(CITY_ID) REFERENCES TB_OS_CITY(ID);
ALTER TABLE TB_OS_ADRS ADD CONSTRAINT OS_ADRS_OS_STATE_FK FOREIGN KEY(STATE_ID) REFERENCES TB_OS_STATE(ID);
ALTER TABLE TB_OS_ADRS ADD CONSTRAINT OS_ADRS_OS_COUNTRY_FK FOREIGN KEY(COUNTRY_ID) REFERENCES TB_OS_COUNTRY(ID);
ALTER TABLE TB_OS_ADRS ADD CONSTRAINT OS_ADRS_OS_POSTAL_FK FOREIGN KEY(POSTAL_ID) REFERENCES TB_OS_POSTAL(ID);


--ADD CUSTOMERS TABLES FOR STORE CUSTOMERS DETAILS


CREATE TABLE TB_OS_CUSTMR
(
ID					NUMBER(38,0) NOT NULL,
REF_ID				VARCHAR2(50) NOT NULL, -- USERNAME LIKE SRK1, sharik123 etc.
PSWD				VARCHAR2(200) NOT NULL, -- in hash format
FULL_NM				NVARCHAR2(100) NOT NULL,
DSPL_NM				NVARCHAR2(30) NOT NULL,
EMAIL				VARCHAR2(2000),
CNTCT_INFO			NVARCHAR2(50),
CNTCT_NUMBER		VARCHAR2(50),
DSGN				VARCHAR2(50),
LOCATION			NVARCHAR2(50),
FLD_LGN_CNT			NUMBER(15,0) DEFAULT 0,
LST_LGN_TS			TIMESTAMP(6),
EXPR_TS				TIMESTAMP(6),
PSWD_CRT_BY			VARCHAR2(50),
ADDRESS_ID			NUMBER(38,0),
USER_STATE			VARCHAR2(50) ,--NOT NULL,
SESSION_ID			VARCHAR2(50),
LDAP_AUTH			VARCHAR2(50) DEFAULT 'N',
--ENC_KEY_ID			NUMBER(38,0),
SKIP_INACTVN		VARCHAR2(1) DEFAULT 'N',
CRT_TS				TIMESTAMP(6) DEFAULT SYSTIMESTAMP,
CRT_BY				VARCHAR2(50) DEFAULT USER,
UPD_TS				TIMESTAMP(6),
UPD_BY				VARCHAR2(50),
DLT_TS				TIMESTAMP(6),
DLT_BY				VARCHAR2(50)
);

ALTER TABLE TB_OS_CUSTMR ADD CONSTRAINT OS_CUSTMR_PK PRIMARY KEY(ID);
ALTER TABLE TB_OS_CUSTMR ADD CONSTRAINT OS_CUSTMR_UNIQ UNIQUE(REF_ID);
ALTER TABLE TB_OS_CUSTMR ADD CONSTRAINT OS_CUSTMR_CONT_UNIQ UNIQUE(CNTCT_NUMBER);
ALTER TABLE TB_OS_CUSTMR ADD CONSTRAINT OS_CUSTMR_EMAIL_UNIQ UNIQUE(EMAIL);
ALTER TABLE TB_OS_CUSTMR ADD CONSTRAINT OS_CUSTMR_OS_ADRS_FK FOREIGN KEY (ADDRESS_ID) REFERENCES TB_OS_ADRS(ID);
