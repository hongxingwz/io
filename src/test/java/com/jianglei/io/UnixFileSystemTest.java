package com.jianglei.io;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jianglei on 17-6-22.
 */
public class UnixFileSystemTest {

    @Test
    public void testNormalizer(){
        UnixFileSystem uf = new UnixFileSystem();
        String pathname = "/home/jianglei/heiheihei";
        String pathname2 = "../home/jianglei/dfsdfsf";
        String pathname3 = "./home/a/bc/d/ef";
        String pathanme4 = "./home/c/e/df//ff///////fff";
        String pathanme5 = "./home/c/d/e/f/";
        String pathname6 = "";
        String pathname7 = "///////";

        String normalize = uf.normalize(pathname);
        String normalize2 = uf.normalize(pathname2);
        String normalize3 = uf.normalize(pathname3);
        String normalize4 = uf.normalize(pathanme4);
        String normalize5 = uf.normalize(pathanme5);
        String normalize6 = uf.normalize(pathname6);
        String normalize7 = uf.normalize(pathname7);

        Assert.assertEquals("/home/jianglei/heiheihei", normalize);
        Assert.assertEquals("../home/jianglei/dfsdfsf", normalize2);
        Assert.assertEquals("./home/a/bc/d/ef", normalize3);
        Assert.assertEquals("./home/c/e/df/ff/fff", normalize4);
        Assert.assertEquals("./home/c/d/e/f", normalize5);
        Assert.assertEquals("", normalize6);
        Assert.assertEquals("/", normalize7);
    }
}
