
# -----------------------------------------------------------------------
# CommonParms_COP
# -----------------------------------------------------------------------
SET FOREIGN_KEY_CHECKS = 0;
drop table if exists CommonParms_COP;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE CommonParms_COP
(
		            COP_Id BIGINT NOT NULL AUTO_INCREMENT,
		            COP_Description MEDIUMTEXT,
		            COP_Dummy VARCHAR (50),
    PRIMARY KEY(COP_Id)
);

# -----------------------------------------------------------------------
# Currency_CUR
# -----------------------------------------------------------------------
SET FOREIGN_KEY_CHECKS = 0;
drop table if exists Currency_CUR;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE Currency_CUR
(
		            CUR_Client VARCHAR (5) NOT NULL,
		            CUR_CurrencyCode CHAR (3) NOT NULL,
		            CUR_ExchangeRate DECIMAL (10,4),
		            CUR_OrderValueUSD DECIMAL (10,2),
		            CUR_OrderAmountAverage DECIMAL (10,2),
		            CUR_Client_RelatedTo VARCHAR (5),
		            CUR_CurrencyCode_RelatedTo CHAR (3),
    PRIMARY KEY(CUR_Client,CUR_CurrencyCode),
    INDEX Currency_CUR_ALT1 (CUR_Client_RelatedTo, CUR_CurrencyCode_RelatedTo)
);

# -----------------------------------------------------------------------
# EmiR_Z_RFU
# -----------------------------------------------------------------------
SET FOREIGN_KEY_CHECKS = 0;
drop table if exists EmiR_Z_RFU;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE EmiR_Z_RFU
(
		            RFU_RFURSN BIGINT NOT NULL AUTO_INCREMENT,
		            RFU_ARTAL_FROM BIGINT,
		            RFU_PERIOD_FROM BIGINT,
		            RFU_KT2_FROM VARCHAR (8),
		            RFU_KT2_TOM VARCHAR (8),
		            RFU_NIVA_FROM VARCHAR (1),
		            RFU_SUMMERA_UNIVA BIT NOT NULL,
		            RFU_RAPPID VARCHAR (8),
		            RFU_UTDATA VARCHAR (50),
		            RFU_RGHRSN BIGINT,
		            RFU_BOLNR VARCHAR (6),
		            RFU_BESKRIVNING VARCHAR (70),
		            RFU_RAPPORTID VARCHAR (50),
		            RFU_DATETIME DATETIME,
    PRIMARY KEY(RFU_RFURSN)
);

# -----------------------------------------------------------------------
# OBJ
# -----------------------------------------------------------------------
SET FOREIGN_KEY_CHECKS = 0;
drop table if exists OBJ;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE OBJ
(
		            OBJ_OBJNR VARCHAR (15) NOT NULL,
		            OBJ_BOSOK1_OMR VARCHAR (6),
		            OBJ_BOSOK2_OMR VARCHAR (6),
    PRIMARY KEY(OBJ_OBJNR)
);

# -----------------------------------------------------------------------
# OMR
# -----------------------------------------------------------------------
SET FOREIGN_KEY_CHECKS = 0;
drop table if exists OMR;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE OMR
(
		            OMR_OMR VARCHAR (6) NOT NULL,
		            OMR_BESK VARCHAR (50),
		            OMR_INGIOMR VARCHAR (6),
    PRIMARY KEY(OMR_OMR),
    INDEX OMR_ALT_INGIOMR (OMR_INGIOMR)
);

# -----------------------------------------------------------------------
# OMR1
# -----------------------------------------------------------------------
SET FOREIGN_KEY_CHECKS = 0;
drop table if exists OMR1;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE OMR1
(
		            OMR1_OMR VARCHAR (6) NOT NULL,
		            OMR1_BESK VARCHAR (50),
		            OMR1_INGIOMR VARCHAR (6),
    PRIMARY KEY(OMR1_OMR),
    INDEX OMR1_ALT_INGIOMR (OMR1_INGIOMR)
);

# -----------------------------------------------------------------------
# OrderBacklogPerMonth_OBT
# -----------------------------------------------------------------------
SET FOREIGN_KEY_CHECKS = 0;
drop table if exists OrderBacklogPerMonth_OBT;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE OrderBacklogPerMonth_OBT
(
		            OBT_Client VARCHAR (5) NOT NULL,
		            OBT_Month CHAR (3) NOT NULL,
		            OBT_OrderValueUSD DECIMAL (10,2),
    PRIMARY KEY(OBT_Client,OBT_Month)
);

# -----------------------------------------------------------------------
# OrderItem_ORD
# -----------------------------------------------------------------------
SET FOREIGN_KEY_CHECKS = 0;
drop table if exists OrderItem_ORD;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE OrderItem_ORD
(
		            ORD_Client VARCHAR (5),
		            ORD_OrderId BIGINT NOT NULL AUTO_INCREMENT,
		            ORD_Month CHAR (3),
		            ORD_CurrencyCode CHAR (3),
		            ORD_AmountInLocalCurrency DECIMAL (10,2),
		            ORD_AmountInUSD DECIMAL (10,2),
		            ORD_ExchangeRate DECIMAL (10,4),
		            ORD_Approved VARCHAR (3),
    PRIMARY KEY(ORD_OrderId)
);

# -----------------------------------------------------------------------
# User_USR
# -----------------------------------------------------------------------
SET FOREIGN_KEY_CHECKS = 0;
drop table if exists User_USR;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE User_USR
(
		            USR_Rsn BIGINT NOT NULL,
		            USR_Login VARCHAR (50),
		            USR_Password VARCHAR (50),
		            USR_Role VARCHAR (50),
    PRIMARY KEY(USR_Rsn)
);

# -----------------------------------------------------------------------
# Z_YesNo
# -----------------------------------------------------------------------
SET FOREIGN_KEY_CHECKS = 0;
drop table if exists Z_YesNo;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE Z_YesNo
(
		            Stored VARCHAR (3) NOT NULL,
		            Displayed VARCHAR (3),
    PRIMARY KEY(Stored)
);
