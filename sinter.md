#SINTER KEY \[key ...\]
>自1.0.0版本可用
时间复杂度:O(N*M)最坏的情况是N是最小set的基数,M是sets的数量

返回给定的sets的相交的结果集的成员
例如：

    key1 = {a, b, c, d}
    key2 = {c}
    key3 = {a, c, e}
    SINTER key1 key2 key3 = {c}
    
不存在的key被认为是空集。keys中的一个是空集的话，结果集也是空集(因为set与一个空集的交集总是空集)

#返回值
返回数组:列出结果集的成员

#举例
    
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
    redis> SINTER key1 key2
    1) "c"
    redis> 
    