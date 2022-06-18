# Write your MySQL query statement below
SELECT DISTINCT C1.seat_id
FROM Cinema C1 JOIN Cinema C2 ON ABS(C1.seat_id - C2.Seat_id) = 1
WHERE C1.free = 1 AND C2.free = 1 
ORDER BY C1.seat_id ASC;
