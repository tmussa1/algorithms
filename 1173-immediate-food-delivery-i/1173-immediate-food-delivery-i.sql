# Write your MySQL query statement below


SELECT ROUND(((SELECT COUNT(*)
FROM  Delivery D
WHERE D.order_date = D.customer_pref_delivery_date) / COUNT(*)) * 100, 2) AS immediate_percentage
FROM Delivery;
