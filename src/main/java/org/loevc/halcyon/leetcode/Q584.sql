select name from Customer where referee_id != 2 or referee_id is null;

-- 在 SQL 中，NULL 表示“未知”或“缺失”，任何与 NULL 进行直接比较（包括 =、!=、<>、> 等）的结果都不是 TRUE，而是 UNKNOWN。
--
-- WHERE 子句只接受结果为 TRUE 的行，UNKNOWN 和 FALSE 都会被过滤掉。