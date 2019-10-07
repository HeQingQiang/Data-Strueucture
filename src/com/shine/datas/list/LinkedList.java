package com.shine.datas.list;

/**
 * 链表.
 *
 * @author shineYu
 * @date 2019/8/12 9:46
 * @Copyright shine_yu@vip.163.com .
 */
public class LinkedList<E> {

    //region 内部Node类

    /**
     * Node节点
     */
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
    //endregion

    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    /**
     * 获取元素个数
     *
     * @return 元素个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 链表是否为空.
     *
     * @return 布尔值
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表的index（0-based）位置添加新的元素e
     *
     * @param index 添加位置
     * @param e     元素
     */
    public void add(int index, E e) {
        if ((index < 0 || index > size)) {
            throw new IllegalArgumentException("Add faild. Illegal index. ");
        }

        Node prev = dummyHead ;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        //Node node = new Node();
        //node.next = prev.next;
        //prev.next = node;

        prev.next = new Node(e, prev.next);

        size++;

    }

    /**
     * 在链表头添加元素.
     *
     * @param e 添加的元素
     */
    public void addFirst(E e) {
        //Node node = new Node(e);
        //node.next = head;
        //head = node;
        add(0, e);
        size++;
    }

    /**
     * 在链表末尾添加新的元素e.
     *
     * @param e 元素
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 获取链表的第index个位置的元素.
     *
     * @param index 元素位置
     * @return 元素
     */
    public E get(int index) {
        if ((index < 0 || index >=size)) {
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * 获取链表头元素.
     *
     * @return 头元素.
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 获取链表尾元素.
     *
     * @return 尾元素.
     */
    public E getLast(){
        return get(size - 1);
    }

    /**
     * 修改链表的第index个位置的元素为e
     *
     * @param index 位置
     * @param e     元素
     */
    public void set(int index, E e) {
        if ((index < 0 || index >=size)) {
            throw new IllegalArgumentException("Set failed. Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 查询链表中是否存在元素e.
     *
     * @param e 查找的元素
     * @return 布尔值
     */
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 从链表中删除index位置的元素，返回删除的元素.
     *
     * @param index 位置
     * @return 元素
     */
    public E remove(int index){
        if ((index < 0 || index >=size)) {
            throw new IllegalArgumentException("Remove failed. Illegal index.");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;
        return retNode.e;
    }

    /**
     * 从链表删除头元素.
     *
     * @return 删除的元素
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 从链表删除尾元素.
     *
     * @return 删除的元素
     */
    public E removeLast(){
        return remove(size - 1);
    }

    /**
     * 从链表中删除元素e.
     *
     * @param e 待删除的元素
     */
    public void removeElement(E e){

        Node prev = dummyHead;
        while(prev.next != null){
            if(prev.next.e.equals(e)) {
                break;
            }
            prev = prev.next;
        }

        if(prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size --;
        }
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        //for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
        //    res.append(res + "->");
        //}
        res.append("NULL");
        return res.toString();
    }

}

