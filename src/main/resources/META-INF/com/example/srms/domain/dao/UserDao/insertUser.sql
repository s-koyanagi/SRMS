INSERT INTO
users (esq_id, name, created_at)
SELECT
/* user.esq_id */'lk9999',
/* user.name*/'山田 太郎'
current_timestamp
FROM
dual
WHERE
NOT EXISTS
(
SELECT
esq_id
FROM
users
WHERE
esq_id = /* user.esq_id */1
)