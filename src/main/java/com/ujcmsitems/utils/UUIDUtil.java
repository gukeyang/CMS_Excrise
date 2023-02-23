package com.ujcmsitems.utils;
import java.net.InetAddress;
import java.util.UUID;
/**
 * uuid工具类
 * Created by charlin on 2017/9/9.
 */
public class UUIDUtil {
  private String sep = "";
  private static int IP = 0;
  private static short counter = (short) 0;
  private static int JVM = (int) (System.currentTimeMillis() >>> 8);
  static {
    try {
      IP = toInt(InetAddress.getLocalHost().getAddress());
    } catch (Exception e) {
    }
  }
  private static UUIDUtil instance = new UUIDUtil();
  public static UUIDUtil getInstance() {
    return instance;
  }
  /**
   * byte转int
   *
   * @param bytes
   * @return
   */
  public static int toInt(byte[] bytes) {
    int result = 0;
    for (int i = 0; i < 4; i++) {
      result = (result << 8) - Byte.MIN_VALUE + (int) bytes[i];
    }
    return result;
  }
  protected String format(int intval) {
    String formatted = Integer.toHexString(intval);
    StringBuffer buf = new StringBuffer("00000000");
    buf.replace(8 - formatted.length(), 8, formatted);
    return buf.toString();
  }
  protected String format(short shortval) {
    String formatted = Integer.toHexString(shortval);
    StringBuffer buf = new StringBuffer("0000");
    buf.replace(4 - formatted.length(), 4, formatted);
    return buf.toString();
  }
  protected int getJVM() {
    return JVM;
  }
  protected synchronized short getCount() {
    if (counter < 0) {
      counter = 0;
    }
    return counter++;
  }
  protected int getIP() {
    return IP;
  }
  protected short getHiTime() {
    return (short) (System.currentTimeMillis() >>> 32);
  }
  protected int getLoTime() {
    return (int) System.currentTimeMillis();
  }
  public String generate() {
    return new StringBuffer(36).append(format(getIP())).append(sep).append(
        format(getJVM())).append(sep).append(format(getHiTime()))
        .append(sep).append(format(getLoTime())).append(sep).append(
            format(getCount())).toString();
  }
  // 得到一个序号
  public static String getUUID() {
    String s = UUID.randomUUID().toString();
    return s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24);
  }
  /**
   * 一次得到多个序号
   *
   * @param number int 需要获得的序号数量
   * @return String[] 序号数组
   */
  public static String[] getUUID(int number) {
    if (number < 1) {
      return null;
    }
    String[] ss = new String[number];
    for (int i = 0; i < ss.length; i++) {
      ss[i] = getUUID();
    }
    return ss;
  }
}