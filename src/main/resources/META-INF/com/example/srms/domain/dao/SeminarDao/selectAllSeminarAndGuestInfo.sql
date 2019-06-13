SELECT
b.seminar_id
,b.title
,b.overview TEXT
,b.started_at
,b.closed_at
,b.created_at
,b.updated_at
,b.deleted_at
,b.accepting_flag
,b.version
,COUNT(a.guest_id) AS number_of_guest
FROM
guests a
LEFT JOIN
seminars b
ON
a.seminar_id = b.seminar_id
AND b.deleted_at IS NULL
WHERE
a.deleted_at IS NULL
GROUP BY
b.seminar_id
,b.title
,b.overview TEXT
,b.started_at
,b.closed_at
,b.created_at
,b.updated_at
,b.deleted_at
,b.accepting_flag
,b.version