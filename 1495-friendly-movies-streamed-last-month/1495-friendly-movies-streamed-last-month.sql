# Write your MySQL query statement below
SELECT DISTINCT C.title
FROM Content C JOIN TVProgram P ON  C.content_id = P.content_id
WHERE C.kids_content = 'Y'
AND C.content_type = 'Movies'
AND P.program_date >= '2020-06-01' AND P.program_date <= '2020-06-30';
