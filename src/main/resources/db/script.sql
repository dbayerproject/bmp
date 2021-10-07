create table if not exists USER
(
    ID          INT auto_increment,
    USER_NAME   VARCHAR,
    PASSWORD    TEXT,
    EMAIL       VARCHAR,
    FIRST_NAME  VARCHAR,
    LAST_NAME   VARCHAR,
    TELEPHONE   INT,
    CREATED_AT  TIMESTAMP,
    MODIFIED_AT TIMESTAMP,
    constraint USER_PK
        primary key (ID)
);

create table if not exists SHOPPING_SESSION
(
    ID          INT auto_increment,
    USER_ID     INT,
    TOTAL       DECIMAL,
    CREATED_AT  TIMESTAMP,
    MODIFIED_AT TIMESTAMP,
    constraint SHOPPING_SESSION_PK
        primary key (ID),
    constraint SHOPPING_SESSION_USER_ID_FK
        foreign key (USER_ID) references USER (ID)
);

create table if not exists USER_ADDRESS
(
    ID            INT auto_increment,
    USER_ID       INT,
    ADDRESS_LINE1 VARCHAR,
    ADDRESS_LINE2 VARCHAR,
    CITY          VARCHAR,
    POSTAL_CODE   VARCHAR,
    COUNTRY       VARCHAR,
    constraint USER_ADDRESS_PK
        primary key (ID),
    constraint USER_ADDRESS_USER_ID_FK
        foreign key (USER_ID) references USER (ID)
);

create table if not exists USER_PAYMENT
(
    ID           INT auto_increment,
    USER_ID      INT,
    PAYMENT_TYPE VARCHAR,
    PROVIDER     VARCHAR,
    ACCOUNT_NO   INT,
    EXPIRY       TIMESTAMP,
    constraint USER_PAYMENT_PK
        primary key (ID),
    constraint USER_PAYMENT_USER_ID_FK
        foreign key (USER_ID) references USER (ID)
);

create table if not exists PAYMENT_DETAILS
(
    ID          INT auto_increment,
    ORDER_ID    INT,
    AMOUNT      INT,
    PROVIDER    VARCHAR,
    STATUS      VARCHAR,
    CREATED_AT  TIMESTAMP,
    MODIFIED_AT TIMESTAMP,
    constraint PAYMENT_DETAILS_PK
        primary key (ID)
);

create table if not exists ORDER_DETAILS
(
    ID          INT auto_increment,
    USER_ID     INT,
    TOTAL       DECIMAL,
    PAYMENT_ID  INT,
    CREATED_AT  TIMESTAMP,
    MODIFIED_AT TIMESTAMP,
    constraint ORDER_DETAILS_PK
        primary key (ID),
    constraint ORDER_DETAILS_PAYMENT_DETAILS_ID_FK
        foreign key (PAYMENT_ID) references PAYMENT_DETAILS (ID),
    constraint ORDER_DETAILS_USER_ID_FK
        foreign key (USER_ID) references USER (ID)
);

create table if not exists PRODUCT_INVENTORY
(
    ID          INT auto_increment,
    QUANTITY    INT,
    CREATED_AT  TIMESTAMP,
    MODIFIED_AT TIMESTAMP,
    DELETED_AT  TIMESTAMP,
    constraint PRODUCT_INVENTORY_PK
        primary key (ID)
);

create table if not exists DISCOUNT
(
    ID               INT auto_increment,
    NAME             VARCHAR,
    DESC             TEXT,
    DISCOUNT_PERCENT DECIMAL,
    ACTIVE           BOOLEAN,
    CREATED_AT       TIMESTAMP,
    MODIFIED_AT      TIMESTAMP,
    DELETED_AT       TIMESTAMP,
    constraint DISCOUNT_PK
        primary key (ID)
);

create table if not exists PRODUCT_CATEGORY
(
    ID          INT auto_increment,
    NAME        VARCHAR,
    DESC        TEXT,
    CREATED_AT  TIMESTAMP,
    MODIFIED_AT TIMESTAMP,
    DELETED_AT  TIMESTAMP,
    constraint PRODUCT_CATEGORY_PK
        primary key (ID)
);

create table if not exists PRODUCT
(
    ID           INT auto_increment,
    NAME         VARCHAR,
    DESC         TEXT,
    SKU          VARCHAR,
    CATEGORY_ID  INT,
    INVENTORY_ID INT,
    CREATED_AT   TIMESTAMP,
    MODIFIED_AT  TIMESTAMP,
    DELETED_AT   TIMESTAMP,
    DISCOUNT_ID  INT,
    PRICE        DECIMAL,
    constraint PRODUCT_PK
        primary key (ID),
    constraint PRODUCT_DISCOUNT_ID_FK
        foreign key (DISCOUNT_ID) references DISCOUNT (ID),
    constraint PRODUCT_PRODUCT_CATEGORY_ID_FK
        foreign key (CATEGORY_ID) references PRODUCT_CATEGORY (ID),
    constraint PRODUCT_PRODUCT_INVENTORY_ID_FK
        foreign key (INVENTORY_ID) references PRODUCT_INVENTORY (ID)
);

create table if not exists ORDER_ITEMS
(
    ID          INT auto_increment,
    ORDER_ID    INT,
    PRODUCT_ID  INT,
    QUANTITY    INT,
    CREATED_ID  TIMESTAMP,
    MODIFIED_AT TIMESTAMP,
    constraint ORDER_ITEMS_PK
        primary key (ID),
    constraint ORDER_ITEMS_ORDER_DETAILS_ID_FK
        foreign key (ORDER_ID) references ORDER_DETAILS (ID),
    constraint ORDER_ITEMS_PRODUCT_ID_FK
        foreign key (PRODUCT_ID) references PRODUCT (ID)
);

create table if not exists ROLE
(
    ID            INT NOT NULL PRIMARY KEY ,
    ROLE          VARCHAR NOT NULL
);
insert into ROLE values
                     (1, 'ROLE_OWNER'),
                     (2, 'ROLE_ADMIN'),
                     (3, 'ROLE_MANAGER'),
                     (4, 'ROLE_ACCOUNTANT'),
                     (5, 'ROLE_CLIENT');

create table if not exists USER_ROLE
(
    USERID      INT NOT NULL,
    ROLEID      INT NOT NULL,
    PRIMARY KEY (USERID, ROLEID),
    FOREIGN KEY (USERID) REFERENCES USER(ID),
    FOREIGN KEY (ROLEID) REFERENCES ROLE (ID)
    );


