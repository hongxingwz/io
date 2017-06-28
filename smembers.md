#SMEMBERS key
>自1.0.0版本可用
时间复杂度:O(N) N是set的基数

返回以set形式存储的key中的所有成员
此命令与运行具有一个key参数的SINTER是等价的

##返回值
返回数组:set中的所有元素

##示例
    
    redis> SADD myset "Hello"
    (integer) 1
    redis> SADD myset "World"
    (integer) 1
    redis> SMEMBERS myset
    1) "World"
    2) "Hello"
    redis>