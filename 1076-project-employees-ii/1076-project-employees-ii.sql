# Write your MySQL query statement below
SELECT project_id
FROM Project
GROUP BY project_id
HAVING COUNT(project_id) = (SELECT COUNT(P.project_id) AS p_count FROM Project P GROUP BY P.project_id ORDER BY p_count DESC LIMIT 1);
