SELECT YEAR, MONTH, CUSTOMERID, TOTAL_MONTHLY_ORDER_VALUE FROM (
    SELECT TO_CHAR(ORDERS.ORDERDATE, 'YYYY') AS YEAR, TO_CHAR(ORDERS.ORDERDATE, 'fmMM') AS MONTH, ORDERS.CUSTOMERID, SUM(OD.UNITPRICE * OD.QUANTITY) AS TOTAL_MONTHLY_ORDER_VALUE,
        RANK() OVER(
            PARTITION BY TO_CHAR(ORDERS.ORDERDATE, 'YYYY'), TO_CHAR(ORDERS.ORDERDATE, 'fmMM')
            ORDER BY SUM(OD.UNITPRICE * OD.QUANTITY) DESC
            )
    FROM ORDERS
        INNER JOIN ORDER_DETAILS OD ON ORDERS.ORDERID = OD.ORDERID
        GROUP BY YEAR, MONTH, ORDERS.CUSTOMERID
        ORDER BY YEAR, MONTH) AS RESULT
WHERE RESULT.RANK = 1;