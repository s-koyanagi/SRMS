INSERT INTO
users (esq_id, name, password,created_at)
SELECT
/* user.esqId */'lk9999',
/* user.fullName */'山田 太郎',
/* user.password */'password',
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
esq_id = /* user.esqId */1
)