#SISMEMBER key member
>自1.0.0可用
时间复杂度:O(1)

返回member是否是以set形式存储的key的成员

##返回值
返回整数，一般形式如下：
* 1 如果元素是set中的成员
* 0 如果元素不是set中的成员，或如果key不存在


##示例
    
    redis> SADD myset "one"
    (integer) 1
    redis> SISMEMBER myset "one"
    (integer) 1
    redis> SISMEMBER MYSET "two"
    (integer) 0
    redis>