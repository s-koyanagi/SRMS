INSERT INTO
applicants (seminar_id, esq_id, created_at)
SELECT
/* guest.seminar_id */1,
/* guest.esq_id */'lk9999',
current_timestamp
FROM
dual
WHERE
NOT EXISTS
(
SELECT
seminar_id
FROM
guest
WHERE
seminar_id = /* guest.seminar_id */1
AND name = /* guest.esq_id */'lk9999'
)