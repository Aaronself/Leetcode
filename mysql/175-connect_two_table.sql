# Write your MySQL query statement below
SELECT a.FirstName, a.LastName, b.City, b.State
From Person a LEFT JOIN Address b
ON a.PersonID = b.PersonID