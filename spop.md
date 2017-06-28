#SPOP key \[count\]

>自1.0.0版本可用
时间复杂度:O(1)

从以set形式存储的key中移除并返回一个或多个随机的元素。
此操作与SRANDMEMBER相似，SRANDMEMBER命令从set中返回一个或多个随机的元素但是不会移除他们

count参数从3.2可用

##返回值
返回字符串：移除的元素，或nil当key不存在时

##示例
    
    redis> SADD myset "one"
    (integer) 1
    redis> SADD myset "two"
    (integer) 1
    redis> SADD myset "three"
    (integer) 1
    redis> SPOP myset
    "three"
    redis> SMEMMBERS myset
    1) "one"
    2) "two"
    redis> SADD myset "four"
    (integer) 1
    redis> SADD myset "five"
    (integer) 1
    redis> SADD myset 3
    1) "five"
    2) "two"
    3) "four"
    redis> SMEMBERS myset

##当传入count时行为的说明
如果count大于set元素的数量，此命令将会返回整个set而不是额外的元素