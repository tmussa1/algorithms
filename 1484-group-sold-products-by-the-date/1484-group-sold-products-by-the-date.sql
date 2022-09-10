# Write your MySQL query statement below
SELECT sell_date, COUNT(DISTINCT(PRODUCT)) AS num_sold, GROUP_CONCAT(DISTINCT(PRODUCT) ORDER BY PRODUCT) AS products
FROM Activities
GROUP BY sell_date
ORDER BY sell_date;

