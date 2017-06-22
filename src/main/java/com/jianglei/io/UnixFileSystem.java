package com.jianglei.io;

/**
 * Created by jianglei on 17-6-22.
 */
public class UnixFileSystem {

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
