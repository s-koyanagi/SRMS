UPDATE
seminars
SET
title = /* seminarDTO.title */'第99回 開発技術セミナーのはじまり'
,started_at = /* seminarDTO.startedDateTime*/'2019-01-01 12:34:00'
,closed_at = /* seminarDTO.closedDateTime*/'2019-01-01 13:34:00'
WHERE
seminar_id = /* seminarDTO.seminarId */'1'