--- https://leetcode.com/problems/second-highest-salary/

--- Way 1
SELECT MAX(Salary) as SecondHighestSalary
FROM Employee
WHERE Salary < (SELECT MAX(Salary)
                FROM Employee);

--- Way 2
SELECT
    IFNULL(
        (SELECT DISTINCT Salary
         FROM Employee
         ORDER BY Salary DESC
         LIMIT 1, 1),
    NULL) AS SecondHighestSalary;