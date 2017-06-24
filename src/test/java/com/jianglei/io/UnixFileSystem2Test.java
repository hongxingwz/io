package com.jianglei.io;

import static org.junit.Assert.*;
import org.junit.Test;


/**
 * Created by jianglei on 2017/6/24.
 */
public class UnixFileSystem2Test {

    @Test
    public void testNormalize(){
        UnixFileSystem2 us = new UnixFileSystem2();

        //test the empty pathname
        String pathname = "";
        String normalize = us.normalize(pathname);
        assertEquals(pathname, normalize);

        //test the normal pathname
        String pathname1 = "./a/b/c/d/e/f";
        String normalize1 = us.normalize(pathname1);
        assertEquals(pathname1, normalize1);

        String pathname2 = "/a/b/c/d/e";
        String normalize2 = us.normalize(pathname2);
        assertEquals(pathname2, normalize2);

        String pathname3 = "../a/b/c/d/e/f";
        String normalize3 = us.normalize(pathname3);
        assertEquals(pathname3, normalize3);

        //test the not normal pathname
        String pathname4 = "./a/////b/c/d/e/f/eeee";
        String normalize4 = us.normalize(pathname4);
        assertEquals("./a/b/c/d/e/f/eeee", normalize4);

        String pathname5 = "//////////";
        String normalize5 = us.normalize(pathname5);
        assertEquals("/", normalize5);

        String pathname6 = "./a/b/c/";
        String normalize6 = us.normalize(pathname6);
        assertEquals(pathname6.substring(0, pathname6.length() -1), normalize6);

    }

}
