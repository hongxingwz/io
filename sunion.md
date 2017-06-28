#SUNION key [key...]

>自1.0.0可用
时间复杂度:O(N) N是指定sets所有元素的数量

示给定的所有set成员的并集

举例：

    key1 = {a, b, c, d}
    key2 = {c}
    key3 = {a, c, e}
    SUNION key1, key2, key3 = {a, b, c, d, e}
   
不存在的keys会被视为空集

##返回值
返回数组：列表结果集中所有的成员

##举例
    
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
    redis> SUNION key1 key2
    1) "a"
    2) "c"
    3) "b"
    4) "e"
    5) "d"
    redis>