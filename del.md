#DEL key \[key ...\]
>自1.0.0版本可用
时间复杂度:O(N) N是要被删除的keys的数量,当一个要被移除的key持有的值
不是字符串时，这个key单独的时间复杂度是O(M)， M是list, set, sorted set 或 hash
中元素的数量。移除一个仅含有字符串的key的复杂度为O(1)

删除指定的keys，如果key不存在时会被忽略

#返回值
返回整数:删除keys的数量

#示例
    
    redis> SET key1 "Hello"
    "OK"
    redis> SET key2 "World"
    "OK"
    redis> DEL key1 key2 key3
    (integer) 2
    redis>