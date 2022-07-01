# Write your MySQL query statement below
SELECT MIN(ABS(P1.X - P2.X)) AS shortest
FROM Point P1 JOIN Point P2
ON P1.x != P2.x;
