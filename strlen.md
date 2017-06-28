#STRLEN key
>自2.2.0可用
时间复杂度:O(1)

返回以string形式存储的key的长度。当key持有一个非string类型时，会返回一个错误

##返回值
返回整数:string的长度，或0当key不存在时

##示例
    
    redis> SET mykey "Hello world"
    "OK"
    redis> STRLEN mykey
    (integer) 11
    redis> STRLEN nonexisting
    (integer) 0
    redis>