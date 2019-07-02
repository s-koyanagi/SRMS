SELECT
a.esq_id as esq_id
,b.name as name
,a.prior_question as prior_question
,a.created_at as created_at
FROM
guests a
LEFT JOIN
users b
ON
a.esq_id = b.esq_id
WHERE
seminar_id = /* seminarId */'1'
AND a.deleted_at IS NULL