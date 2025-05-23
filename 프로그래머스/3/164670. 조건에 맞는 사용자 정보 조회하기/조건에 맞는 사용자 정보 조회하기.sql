-- 코드를 입력하세요
SELECT   UGU.USER_ID, UGU.NICKNAME, CONCAT(CITY,' ', STREET_ADDRESS1,' ', STREET_ADDRESS2) AS 전체주소, CONCAT(SUBSTRING(UGU.TLNO, 1, 3), '-', SUBSTRING(UGU.TLNO, 4, 4), '-', SUBSTRING(UGU.TLNO, 8, 4)) AS 전화번호
FROM USED_GOODS_USER UGU JOIN USED_GOODS_BOARD UGB ON UGU.USER_ID = UGB.WRITER_ID
GROUP BY UGU.USER_ID
HAVING COUNT(UGB.WRITER_ID) >= 3
ORDER BY UGU.USER_ID DESC;
