/* Write your PL/SQL query statement below */
SELECT P.product_id, P.product_name
FROM Product P JOIN Sales S ON P.product_id = S.product_id
WHERE S.sale_date >= '2019-01-01' AND S.sale_date <= '2019-03-31'
MINUS
SELECT P.product_id, P.product_name
FROM Product P JOIN Sales S ON P.product_id = S.product_id
WHERE S.sale_date < '2019-01-01' OR S.sale_date > '2019-03-31';

