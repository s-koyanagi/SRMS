SELECT
a.seminar_id
,a.title
,a.overview
,a.started_at
,a.closed_at
,a.created_at
,a.updated_at
,a.deleted_at
,a.accepting_flag
,a.version
,coalesce(b.number_of_guest,0) as number_of_guest
FROM
seminars a
LEFT JOIN
(SELECT
seminar_id
,count(*) as number_of_guest
FROM
guests
WHERE
deleted_at is null
GROUP BY
seminar_id) b
ON
a.seminar_id=b.seminar_id
WHERE
a.deleted_at is null