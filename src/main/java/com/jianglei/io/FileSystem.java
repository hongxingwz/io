package com.jianglei.io;

import java.io.IOException;
import java.lang.annotation.Native;

/**
 * Created by jianglei on 2017/6/25.
 */
public abstract class FileSystem {

    /**
     *
     * @return  本地文件系统的路径名称分隔符 unix的是'/'
     */
    public abstract char getSeparator();

    /**
     *
     * @return 本地文件系统的路径分隔符
     */
    public abstract char getPathSeparator();

    /**
     * 把给定的路径名转换成正常的形式。如果路径名已经是
     * 正常的形式然后仅仅返回路径名
     */
    public abstract String normalize(String path);

    /**
     * 计算此路径名的前缀长度。路径名必须是正常的形式
     */
    public abstract int prefixLength(String path);

    /**
     * 解析父路径名后的子路径名。
     * 所有的字符必须是正常的形式，返回的结果也必须
     * 是正常的形式
     */
    public abstract String resolve(String parent, String child);


    public abstract String getDefaultParent();

    public abstract String fromURIPath(String path);

    /**
     * 告诉给定的路径名是否是绝对的
     */
    public abstract boolean isAbsolute(File f);

    /**
     *
     */
    public abstract String resolve(File f);

    public abstract String canonicalize(String path) throws IOException;

    @Native public static final int BA_EXISTS = 0x01;

    @Native public static final int BA_REGULAR = 0x02;

    @Native public static final int BA_DIRECTORY = 0x04;

    @Native public static final int BA_HIDDEN = 0x08;

    /**
     *
     * @param f
     * @return
     */
    public abstract int getBooleanAttributes(File f);

    @Native public static final int ACCESS_READ     = 0x04;
    @Native public static final int ACCESS_WRITE    = 0x02;
    @Native public static final int ACCESS_EXECUTE  = 0x01;

    /**
     * 检测由绝对路径名代表的文件或目录是否可以被此进程访问。
     * 第二个参数指定了哪种访问， ACCESS_READ, ACCESS_WRITE, ACCESS_EXECUTE 要被检测
     * 如果访问被拒绝或发生I/O错误，返回false
     */
    public abstract boolean checkAccess(File f, int access);

    /**
     * 基于参数enable, access, oweronly 设置由抽象目录代表的文件或目录的访问权限(拥有者或所有）
     */
    public abstract boolean setPermission(File f, int access, boolean enable, boolean owner);

    /**
     * 返回由抽象路径名代表的文件或目录的最近一次的访问时间，
     * 如果文件不存在或发生了一些I/O错误则会返回0
-     * @param f
     * @return
     */
    public abstract long getLastModifiedTime(File f);

    /**
     * 发bytes的形式返回由抽象路径代表的文件或目录的长度
     * @param f
     * @return
     */
    public abstract long getLength(File f);

    /**
     * 用指定的路径名创建一个新的空的文件。
     * 如果文件创建成功返回true如果文件创建失败或
     * 如果给定的文件或目录已经存在
     * 返回false
     * 如果发生了I/O异常则抛出一个IOException
     */
    public abstract boolean createFileExclusively(String pathname)
            throws IOException;

    /**
     * 删除由指定的抽象路径名代表的文件或目录，
     * 仅当操作成功时返回true
     * @param f
     * @return
     */
    public abstract boolean delete(File f);

    /**
     * 列出由抽象路径名代表的目录的元素
     * 如果成功返回一个字符串数组。
     * 否则返回null
     */
    public abstract String[] list(File f);

    /**
     * 创建一个新的由抽象路径名代表的目录，
     * 仅当此操作成功时返回true
     */
    public abstract boolean createDirectory(File f);

    /**
     * 重命名一个由抽象路径名代表的文件或目录
     * 仅当此操作成功时返回true
     */
    public abstract boolean rename(File f1, File f2);

    /**
     * 设置由抽象路径名代表的文件或目录的最后一次访问时间，
     * 仅当此操作成功时返回true
     */
    public abstract boolean setLastModifiedTime(File f, long time);

    /**
     * 把抽象路径名代表的文件或目录标记为识读，
     * 仅当此操作成功时返回true
     */
    public abstract boolean setReadOnly(File f);

    /**
     * 列出可用的文件系统的根目录
     */
    public abstract File[] listRoots();

    @Native public static final int SPACE_TOTAL     = 0;
    @Native public static final int SPACE_FREE      = 1;
    @Native public static final int SPACE_USABLE    = 2;

    public abstract long getSpace(File f, int t);


    public abstract int compare(File f1, File f2);

    public abstract int hashCode(File f);

    static boolean useCanonCaches       = true;
    static boolean useCanonPrefixCache  = true;

    private static boolean getBooleanProperty(String prop, boolean defaultVal){
        String val = System.getProperty(prop);
        if(val == null) return defaultVal;
        if (val.equalsIgnoreCase("true")) {
            return true;
        } else {
            return false;
        }
    }

    static {
        useCanonCaches = getBooleanProperty("sun.io.useCanonCaches",
                useCanonCaches);

        useCanonPrefixCache = getBooleanProperty("sun.io.useCanonPrefixCache",
                useCanonPrefixCache);
    }


}
