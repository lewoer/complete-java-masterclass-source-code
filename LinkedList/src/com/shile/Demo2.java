package com.shile;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Demo2 {
    public static void main(String[] args) {
        List<String> a = new LinkedList<String>();
        a.add("Amy");
        a.add("Carl");
        a.add("Reica");

        List<String> b = new LinkedList<String>();
        b.add("Bob");
        b.add("Doug");
        b.add("Frances");
        b.add("Gloria");

        // 把b归并进a

        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();

        while (bIter.hasNext()) {
            if (aIter.hasNext()) {
                aIter.next();
            } else {
                aIter.add(bIter.next());
            }
        }
        System.out.println(a);

        // 从b中每隔2个值删除
        bIter = b.iterator();
        while (bIter.hasNext()) {
            bIter.next();   // 返回这个迭代中的下一个元素,跳过这个值
            if (bIter.hasNext()) {
                bIter.next();
                bIter.remove();
            }
        }
        System.out.println(b);

        // 从a中删除b中所有的元素
        a.removeAll(b);
        System.out.println(a);

    }
}
