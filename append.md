#APPEND key value
>自2.0.0版本可用
时间复杂度:O(1)

如果key已经存在并且是字符串，此命令在string的结尾追加value。如果
key不存在，将会创建并设置一个空的字符串，因此在这种特殊情境下APPEND与
SET相似

##返回值
返回整数：在追回操作之后字符串的长度

##示例
    redis> EXISTS mykey
    (integer) 0
    redis> APPEND mykey "Hello"
    (integer) 5
    redis> APPEND mykey " World"
    (integer) 11
    redis> GET mykey
    "Hello World"
    redis>