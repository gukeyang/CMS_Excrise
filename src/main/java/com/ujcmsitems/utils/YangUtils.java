package com.ujcmsitems.utils;


import com.ujcmsitems.core.domain.Notice;
import org.junit.Test;

import java.util.*;

@SuppressWarnings("all")
public class YangUtils {

    public static String getUUID32() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * (获取指定长度uuid)
     */
    public static String getUUID(int len) {
        if (len <= 0) {
            return null;
        }
        String uuid = getUUID32();
        //    System.out.println(uuid);
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < len; i++) {
            str.append(uuid.charAt(i));
        }
        return str.toString();
    }

    @Test
    public void test() {
//        System.out.println("密码："+ com.credit.util.IDutils.getUUID(12));
//        System.out.println("密码："+ com.credit.util.IDutils.getUUID(16));
//        System.out.println("密码："+ com.credit.util.IDutils.getUUID(24));
    }

    public static Map queryPages(List<Notice> userList, int pages, int num) {
        Map<String, List> map = new HashMap<>();
        if (userList.size() > num) {
            List<Notice> listIn = new LinkedList<>();//用来存放分页后获取的数据
            int count = userList.size();//集合中数据总数量
            int totalPages;
            int total;
            if (count % num == 0) {
                totalPages = count / num;
            } else {
                total = count / num;
                totalPages = total + 1;
            }
            List<Integer> list2 = new LinkedList<>();
            list2.add(totalPages);
            map.put("totalPages", list2);
            int thePage = (pages - 1) * num;
            //使用listIn来存放分页查询数据
            for (int i = thePage; i < thePage + num && i < userList.size(); i++) {
                listIn.add(userList.get(i));
            }
            map.put("data", listIn);
            List<Integer> listCounts = new LinkedList<>();
            listCounts.add(userList.size());
            map.put("totals", listCounts);
            return map;
        } else {
            List<Integer> integerList = new LinkedList<>();
            integerList.add(userList.size());
            map.put("totals", integerList);
            map.put("data", userList);
            List<Integer> list2 = new LinkedList<>();
            list2.add(1);
            map.put("totalPages", list2);
            return map;
        }
    }
}