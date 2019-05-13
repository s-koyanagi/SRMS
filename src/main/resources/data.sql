INSERT INTO users(esq_id,name,password,created_at)
VALUES('lk9999','山田太郎','$2a$10$5ltUX/.ogJRHrbwn9hG2sOd8Y1krWn8mhYWbBnpCYSSjSCIoTdAke',current_timestamp);
INSERT INTO seminars(title,overview,started_at,closed_at,created_at,accepting_flag,version)
VALUES('第99回 開発技術セミナー 〜SpringBoot特集〜',
       E'今年1発目となる第17回 開発技術セミナーの開催日程が決まりましたので、ご案内いたします！！\r\n\r\n今回テーマを決めるにあたり、\r\n\r\nロシア出張の報告もしたいし、、、\r\n機械学習を活用した実証実験も絶対おもしろいし、、、\r\n実案件でのブロックチェーンの話も興味深いし、、、\r\n\r\nという感じで、お届けしたい(おもしろい)内容がたくさんありまして、\r\n悩んだ結果、もう今回は特別に3テーマをぎゅっと盛り込みます！！\r\n\r\nITエンジニアとしては、興味を惹く内容ばかりだと思いますので、\r\n是非足を運んでいただけると幸いです。',
       '2019-01-01 12:34:00',
       '2019-01-01 14:34:00',
       current_timestamp,
       1,
       1);
INSERT INTO speakers(seminar_id,name,theme,started_at,closed_at,created_at)
VALUES(1,'香川 真司','はじめに','18:00:00','18:05:00',current_timestamp)
,(1,'大久保 嘉人','SpringBootとバイタルエリアの攻防','18:05:00','18:35:00',current_timestamp)
,(1,'パウロ ディバラ','Vue.jsで鍛えるプレースキック精度','18:35:00','19:05:00',current_timestamp)
,(1,'香川 真司','おわりに','19:05:00','19:10:00',current_timestamp);