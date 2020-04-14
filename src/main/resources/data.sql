INSERT INTO "CUSTOMER"("CUSTOMER_ID","CREATED_TIMESTAMP","UPDATED_TIMESTAMP","CUSTOMER_NAME")VALUES
(1,sysdate,sysdate,'John'),
(2,sysdate,sysdate,'Mark'),
(3,sysdate,sysdate,'Samantha'),
(4,sysdate,sysdate,'David');

INSERT INTO TRANSACTION (CREATED_TIMESTAMP, ITEM_COST, ITEM_NAME, REWARD_POINTS, TRANSACTION_DATE, UPDATED_TIMESTAMP, CUSTOMER_ID, ID) VALUES 
(sysdate, 192,'Item1' ,234, parsedatetime('06-01-2020 18:47:52.690', 'dd-MM-yyyy hh:mm:ss.SS'), sysdate, 1,  (SELECT NEXT VALUE FOR hibernate_sequence)),
(sysdate, 59,'Item2' ,9, parsedatetime('28-01-2020 18:47:52.690', 'dd-MM-yyyy hh:mm:ss.SS'), sysdate, 1,  (SELECT NEXT VALUE FOR hibernate_sequence)),
(sysdate, 93,'Item3' ,43, parsedatetime('09-01-2020 18:47:52.690', 'dd-MM-yyyy hh:mm:ss.SS'), sysdate, 1,  (SELECT NEXT VALUE FOR hibernate_sequence)),
(sysdate, 112,'Item4' ,74, parsedatetime('27-02-2020 18:47:52.690', 'dd-MM-yyyy hh:mm:ss.SS'), sysdate, 1,  (SELECT NEXT VALUE FOR hibernate_sequence)),
(sysdate, 156,'Item5' ,162, parsedatetime('18-02-2020 18:47:52.690', 'dd-MM-yyyy hh:mm:ss.SS'), sysdate, 1,  (SELECT NEXT VALUE FOR hibernate_sequence)),
(sysdate, 62,'Item6' ,15, parsedatetime('19-02-2020 18:47:52.690', 'dd-MM-yyyy hh:mm:ss.SS'), sysdate, 1,  (SELECT NEXT VALUE FOR hibernate_sequence)),
(sysdate, 95,'Item7' ,45, parsedatetime('22-03-2020 18:47:52.690', 'dd-MM-yyyy hh:mm:ss.SS'), sysdate, 1,  (SELECT NEXT VALUE FOR hibernate_sequence)),
(sysdate, 172,'Item8' ,194, parsedatetime('01-03-2020 18:47:52.690', 'dd-MM-yyyy hh:mm:ss.SS'), sysdate, 1,  (SELECT NEXT VALUE FOR hibernate_sequence)),
(sysdate, 12,'Item9' ,0, parsedatetime('31-03-2020 18:47:52.690', 'dd-MM-yyyy hh:mm:ss.SS'), sysdate, 1,  (SELECT NEXT VALUE FOR hibernate_sequence));
