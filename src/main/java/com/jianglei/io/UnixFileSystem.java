package com.jianglei.io;

/**
 * Created by jianglei on 17-6-22.
 */
public class UnixFileSystem {

    /**
     * 一个正常的UNIX路径不包含重复的斜线，且不以斜线结尾
     * 正常的路径名有可能是空字符串
     *
     * 正常化指定的路径名，路径名的长度是len, 以给定的off的开始,
     * 在off之前的字符都被认为是正常的
     * @param pathname 待标准化的路径名
     * @param len  路径名的长度
     * @param off  要标准化的起始位置
     * @return 标准化的路径名
     */
    public String normalize(String pathname, int len, int off) {
        if (len == 0) {
            return pathname;
        }
        int n = len;
        while ((n > 0) && (pathname.charAt(n - 1) == '/')) {
            n--;
        }
        if (n == 0) {
            return "/";
        }
        StringBuffer sb = new StringBuffer(pathname.length());
        if(off > 0){
            sb.append(pathname.substring(0, off));
        }
        char preChar = 0;
        for(int i = off; i < n; i++) {
            char c = pathname.charAt(i);
            if((preChar == '/') && (c == '/')){
                continue;
            }
            sb.append(c);
            preChar = c;
        }

        return sb.toString();
    }

    /**
     * 检查给定的路径名是否是标准的，如果不是，调用真正的标准化方法使需要标准化的路径部分标准
     * 通过这种方法，我们仅遍历整个路径一次就可以了
     * 标准的路径：
     *  1. ""
     *  2. "/home/jianglei"
     *  3. "./home/a/b/c/e"
     *
     * 不标准的路径
     *  1. "a/b//c/e" -> "a/b/c/e"
     *  2. "///////"  -> "/"
     *  3. "b/c/d/"   -> "b/c/e"
     * @param pathname 待检测的路径名
     * @return 标准化的路径名
     */
    public String normalize(String pathname) {
        int n = pathname.length();
        char preChar = 0;
        for(int i = 0; i < n; i++){
            char c = pathname.charAt(i);
            if(preChar == '/' && c == '/'){
                return normalize(pathname, n, i - 1);
            }
            preChar = c;
        }

        if (preChar == '/') {
            return normalize(pathname, n, n - 1);
        }

        return pathname;
    }


}
