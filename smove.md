#SMOVE source destination member
>自1.0.0可用
时间复杂度:O(1)

从源set中的member移动到destination.此操作是原子的。对于其他客户端来说，在指定的片刻
元素将会是source或是destination的成员

如果源set不存在或不包含指定的元素，不会执行任何操作且返回0。否则元素会从源set中移除
并且添加到目标的set中。当指定的元素已经存在于目标set中，仅会把其从源set中移除

##返回值
返回整数，具有如下形式
* 1 如果元素被移动
* 2 0 如果元素不是源set中的成员且不会执行任何操作

##示例
    
    redis> SADD myset "one"
    (integer) 1
    redis> SADD myset "two"
    (integer) 1
    redis> SADD motherset "three"
    (integer) 1
    redis> SMEMBERS myset
    1) "one"
    2) "two"
    redis>