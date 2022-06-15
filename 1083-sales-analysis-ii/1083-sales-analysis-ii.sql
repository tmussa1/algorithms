/* Write your PL/SQL query statement below */
SELECT DISTINCT S1.buyer_id
FROM Sales S1
WHERE S1.product_id = (SELECT product_id FROM Product WHERE product_name= 'S8')
MINUS
SELECT DISTINCT S2.buyer_id
FROM Sales S2
WHERE S2.product_id = (SELECT product_id FROM Product WHERE product_name= 'iPhone');