#SUNIONSTORE destnation key [key ...]

>自1.0.0可用
时间复杂度：O(N) N是所有给定sets成员的数量

此命令与SUNION等价，但除了返回结果集，此命令将其存储在了destination
如果destination已经存在，其会被覆盖

##返回值
返回整数: 结果集中元素的数量

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
    redis> SUNIONSTORE key key1 key2
    (integer) 5
    redis> SMEMBERS key
    1）"a"
    2) "c"
    3) "b"
    4) "e"
    5) "d"
    redis>