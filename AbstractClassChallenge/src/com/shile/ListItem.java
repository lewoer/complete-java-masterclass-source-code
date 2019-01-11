package com.shile;

/**
 * @Author: ShiLe
 * @Description:
 * @Date: Created in 12:36 2018/12/16
 */
public abstract class ListItem {
    /*声明为protected是因为我们需要能够被具体的子类访问，若是没有访问控制，同一个package
    * 的子类能够访问，而其他package的子类则不能访问*/
    protected ListItem rightLink = null;
    protected ListItem leftLink = null;

    protected Object value;

    public ListItem(Object value) {
        this.value = value;
    }

    abstract ListItem next();
    abstract ListItem setNext(ListItem item);
    abstract ListItem previous();
    abstract ListItem setPrevious(ListItem item);

    abstract int compareTo(ListItem item);

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
