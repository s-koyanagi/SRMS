INSERT INTO users(id,name,password,created_at)
VALUES('lk9999','山田太郎','$2a$10$5ltUX/.ogJRHrbwn9hG2sOd8Y1krWn8mhYWbBnpCYSSjSCIoTdAke',current_timestamp);
INSERT INTO seminars(title,overview,started_at,closed_at,created_at,accepting_flag,version)
VALUES('第99回 開発技術セミナー 〜SpringBoot特集〜',
       '今年1発目となる第17回 開発技術セミナーの開催日程が決まりましたので、ご案内いたします！！<br><br>今回テーマを決めるにあたり、<br><br>ロシア出張の報告もしたいし、、、<br>機械学習を活用した実証実験も絶対おもしろいし、、、<br>実案件でのブロックチェーンの話も興味深いし、、、<br><br>という感じで、お届けしたい(おもしろい)内容がたくさんありまして、<br>悩んだ結果、もう今回は特別に3テーマをぎゅっと盛り込みます！！<br><br>ITエンジニアとしては、興味を惹く内容ばかりだと思いますので、<br>是非足を運んでいただけると幸いです。',
       '2019-01-01 12:34:00',
       '2019-01-01 14:34:00',
       current_timestamp,
       1,
       1);
INSERT INTO speakers(seminar_id,name,theme,started_at,closed_at,created_at)
VALUES(1,
       '小柳匠平',
       '誰もが知らない私の世界',
       '18:15:00',
       '18:45:00',
       current_timestamp);