#SINTERSTORE destination key \[key ..\]
>自1.0.0版本可用
时间复杂度:O(N*M)最坏的情况是N是最小set的基数,M是sets的数量

此命令与SINTER是等价的，但除了返回的结果集，返回的结果集存储在destination中
如果destination已经存在，他会被覆盖

##返回值
返回整数：结果集中元素的数量

##示例
    
    redis> SADD key1 "a"
    (integer) 1
    redis> SADD key1 "b"
    (integer) 1
    redis> SADD key1 "c"
    (integer) 1
    redis> SADD key2 "c"
    (integer) 1
    redis> SADD key2 "d"
    (integer) 1
    redis> SADD key2 "e"
    (integer) 1
    redis> SINTERSTORE key key1 key2
    (integer) 1
    redis> SMEMBERS key
    1) "c"
    redis>