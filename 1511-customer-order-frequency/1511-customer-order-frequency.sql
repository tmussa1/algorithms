# Write your MySQL query statement below
SELECT customer_id, name
FROM Customers JOIN (SELECT C.customer_id AS CUST_ID, MONTH(O.order_date) MONTH_VAL, SUM(O.quantity * P.price) AS AMOUNT
FROM Orders O JOIN Product P
ON O.product_id = P.product_id
JOIN Customers C ON C.customer_id = O.customer_id
WHERE MONTH(O.order_date) = 6 OR MONTH(O.order_date) = 7 
GROUP BY C.customer_id, MONTH(O.order_date)
HAVING AMOUNT >= 100) OC
ON OC.CUST_ID = customer_id
GROUP BY customer_id
HAVING COUNT(*) = 2;
