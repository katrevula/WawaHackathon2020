drop table [if exists] Mobile_Number;
drop table [if exists] Plans;


CREATE TABLE Mobile_Number (
    id int(10) int NOT NULL,
    request_id varchar(16) NOT NULL,
    plan_ID varchar(10),
    created_On date,
    status varchar(10),
    PRIMARY KEY (id,status)
    FOREIGN KEY (request_id, plan_ID)
);

CREATE TABLE Plans (
    plan_ID int(10) int NOT NULL,
    description varchar(255) NOT NULL,
    plan_Type varchar(10),
    monthly_Cost int(3)
    status varchar(10),
    PRIMARY KEY (plan_ID)
);