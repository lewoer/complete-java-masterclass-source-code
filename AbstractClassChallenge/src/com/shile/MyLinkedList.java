package com.shile;

/**
 * @Author: ShiLe
 * @Description:
 * @Date: Created in 15:26 2018/12/16
 */
public class MyLinkedList implements NodeList {

    private ListItem root = null;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if (this.root == null) {
            // the list is empty,so this item becomes the head of the list
            this.root = newItem;
            return true;
        }
        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparison = (currentItem.compareTo(newItem));
            if (comparison < 0) {
                // newItem is greater,move right is possible
                if (currentItem.next() != null) {
                    currentItem = currentItem.next();
                } else {
                    // there is no next, so insert at end of list
                    // 因为setnext和setprebious返回引用一样，可以简化代码
                    currentItem.setNext(newItem).setPrevious(currentItem);
                    return true;
                }
            } else if (comparison > 0) {
                // newItem is less,insert before
                if (currentItem.previous() != null) {
                    // 一个链表的插入，形成一个圈
                    currentItem.previous().setNext(newItem).setPrevious(currentItem.previous());
                    newItem.setNext(currentItem).setPrevious(newItem);
                } else {
                    // the node with previous is root
                    newItem.setNext(this.root).setPrevious(newItem);
                    this.root = newItem;  // newitem与root的交换
                }
                return true;
            } else {
                // equal
                System.out.println(newItem.getValue() + " is already present, not added");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if (item != null) {
            System.out.println("Deleting item " + item.getValue());
        }

        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparison = currentItem.compareTo(item);
            if (comparison == 0) {
                // find the item to delete
                if (currentItem == this.root) {
                    this.root = currentItem.next();
                } else {
                    currentItem.previous().setNext(currentItem.next());
                    if (currentItem.next() != null) {
                        currentItem.next().setPrevious(currentItem.previous());
                    }
                }
                return true;
            } else if (comparison < 0) {
                // 我们还没有遍历到
                currentItem = currentItem.next();
            } else {
                // item is not in the list
                return false;
            }
        }

        // we have reach the end of the list
        // without find the item to delete
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if (root == null) {
            System.out.println("The list is empty");
        } else {
            while (root != null) {
                System.out.println(root.getValue());
                root = root.next();
            }
        }
//        if (root != null) {
//            // 一个良好二叉搜索树有billions of record and nodes,最大depth为63
//            // 一般在一个很大的数据库里
//            System.out.println(root.getValue());
//            traverse(root.next());
//            // 9,000,000,000,000,000,000 nodes

    }

}
