#SREM key member \[member ...\]
>自1.0.0可用
时间复杂度:O(N) N是要移除元素的数量

从set中移除指定的成员。指定的members如果不是set的成员会被忽略。如果key不存在，
其会被视为一个空集且此命令返回0
当存储在key中的value值不是set时，会返回一个错误

##返回值
返回整数: 从set中移除的成员的数量，不包括不存在的成员

##历史
* \>= 2.4 接收多个member参数。Redis2.4之前的版本一次调用只能删除一个成员

##示例

    redis> SADD myset "one"
    (integer) 1
    redis> SADD myset "two"
    (integer) 1
    redis> SADD myset "three"
    (integer) 1
    redis> SREM myset "four"
    (integer) 0
    redis> SMEMBERS myset
    1) "three"
    2) "two"
    redis>
    
