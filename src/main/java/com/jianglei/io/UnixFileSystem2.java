package com.jianglei.io;

/**
 * Created by jianglei on 2017/6/24.
 */
public class UnixFileSystem2 {

    /**
     * actual normal the pathname
     * @param pathname pathanme to be normalized
     * @param off start
     * @param len pathname length
     * @return normalized pathname
     */
    public String normalize(String pathname, Integer off, Integer len) {
        if (len == 0) {
            return pathname;
        }

        int n = len;
        while (n > 0  && pathname.charAt(n -1) == '/') {
           n--;
        }
        if (n == 0) {
            return "/";
        }

        StringBuilder sb = new StringBuilder(len);
        if (off > 0) {
            sb.append(pathname.substring(0, off));
        }

        char preChar = 0;
        for(int i = off; i < n; i++) {
            char c = pathname.charAt(i);
            if (preChar == '/' && c == '/') {
                continue;
            }

            sb.append(c);
            preChar = c;
        }



        return sb.toString();
    }


    /**
     * check the pathname is normallize
     * The unix normal path is no double slash
     * And the last char is not slash
     * @param pathname
     * @return
     */
    public String normalize(String pathname) {
        int n = pathname.length();
        if (n == 0) {
            return pathname;
        }
        char prevChar = 0;
        for(int i = 0; i < n; i++) {
            char c = pathname.charAt(i);
            if (prevChar == '/' && c == '/') {
                return normalize(pathname, i - 1, n);
            }
            prevChar = c;
        }
        if (pathname.charAt(n - 1) == '/') {
            return normalize(pathname, n - 1, n);
        }
        return pathname;
    }


}
