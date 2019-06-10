UPDATE
guests
SET
deleted_at = current_timestamp
WHERE
seminar_id = /* guest.seminarId */1
AND esq_id = /* guest.esqId */'lk9999'
AND deleted_at IS NULL