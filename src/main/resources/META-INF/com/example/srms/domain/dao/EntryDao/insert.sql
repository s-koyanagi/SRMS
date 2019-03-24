INSERT INTO
applicants (seminar_id, name, mail_address, created_at)
SELECT
/* applicant.seminar_id */1,
/* applicant.name */'山田',
/* applicant.mail_address */'tes@test.co.jp',
current_timestamp
FROM
dual
WHERE
NOT EXISTS
(
SELECT
seminar_id
FROM
applicants
WHERE
seminar_id = /* applicant.seminar_id */1
AND name = /* applicant.name */'山田'
AND mail_address = /* applicant.mail_address */'tes@test.co.jp'
)