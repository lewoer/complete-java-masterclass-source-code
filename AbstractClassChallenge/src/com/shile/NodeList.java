package com.shile;

/**
 * @Author: ShiLe
 * @Description: 节点，root相当于head头节点
 * @Date: Created in 15:18 2018/12/16
 */
public interface NodeList {
    ListItem getRoot();
    boolean addItem(ListItem item);
    boolean removeItem(ListItem item);
    void traverse(ListItem root);
}
