INSERT INTO
guests (seminar_id, esq_id, prior_question, created_at)
SELECT
/* guest.seminarId */1,
/* guest.esqId */'lk9999',
/* guest.priorQuestion */'質問はありません',
current_timestamp
FROM
dual
WHERE
NOT EXISTS
(
SELECT
seminar_id
FROM
guests
WHERE
seminar_id = /* guest.seminarId */1
AND esq_id = /* guest.esqId */'lk9999'
)