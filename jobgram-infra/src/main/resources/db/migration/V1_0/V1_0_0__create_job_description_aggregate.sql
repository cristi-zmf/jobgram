CREATE TABLE "JOB_DESCRIPTION" (
    "ID" VARCHAR2(36 CHAR) PRIMARY KEY,
    "TITLE" VARCHAR2(100 CHAR) NOT NULL,
    "DESCRIPTION" CLOB NOT NULL,
    "VERSION" NUMBER(15) NOT NULL
);