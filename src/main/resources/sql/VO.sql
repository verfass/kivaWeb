-- 프로 시저용
SELECT
    COLUMN_NAME,
    '#{'+COLUMN_NAME+'}' AS MYBATIS,
    '['+COLUMN_NAME+']' AS TABLECALL,
    '@'+COLUMN_NAME AS PARAM,
       ISNULL(
    '@'+COLUMN_NAME+' '+DATA_TYPE+'('
        +  RTRIM(CASE CHARACTER_OCTET_LENGTH WHEN -1 THEN 'max' ELSE CAST(CHARACTER_OCTET_LENGTH AS CHAR(10)) END) +
    '),', '@'+COLUMN_NAME+' nvarchar(200)') AS KEYWORD,
    DATA_TYPE,
    'private String '+COLUMN_NAME+';' AS vo,
    '.'+COLUMN_NAME+'('+'entity.get'+COLUMN_NAME+'())' AS vo
FROM INFORMATION_SCHEMA.COLUMNS
WHERE TABLE_NAME ='TB_TrainingHist';

-- 공통코드 사용
-- (SELECT CODE_DESC
--  FROM TB_CommonCd
--  WHERE GRP_CD ='QNA_GB'
--    AND CODE_VAL = Q.QNA_GB) QNA_GB,

-- 자동증가값 추가용
-- IDENTITY (1, 1) NOT NULL,

--- 페이지네이션
WITH PaginationCTE(
                   NUM,
                   ORD_SQ,
                   MEM_SQ,
                   ORD_GB,
                   ORD_CNT,
                   ORD_MONEY,
                   DISCT_MONEY,
                   ORD_ST,
                   ORD_REG_DT,
                   ORD_MEM_NM,
                   PAY_MEM_NM,
                   ORD_PH,
                   ORD_TEL)
         AS
         (
             SELECT ROW_NUMBER() OVER (ORDER BY ORD_SQ) AS Num,
                    ORD_SQ,
                    MEM_SQ,
                    ORD_GB,
                    ORD_CNT,
                    ORD_MONEY,
                    DISCT_MONEY,
                    ORD_ST,
                    ORD_REG_DT,
                    ORD_MEM_NM,
                    PAY_MEM_NM,
                    ORD_PH,
                    ORD_TEL
             FROM TB_Order
             WHERE MEM_SQ = 3
         )
SELECT
    *,
    (SELECT COUNT(*) FROM PaginationCTE) AS TotalCount
FROM PaginationCTE
ORDER BY NUM DESC
OFFSET (#{currentPage} - 1) * #{pageSize} ROW
FETCH NEXT #{pageSize} ROW ONLY;



SELECT FORMAT(99999999, '#,#');


TRUNCATE TABLE TB_Agency;