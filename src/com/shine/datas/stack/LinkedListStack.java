package com.shine.datas.stack;

import com.shine.datas.list.LinkedList;

/**
 * 链表栈实现.
 *
 * @author shineYu
 * @date 2019/8/13 17:20
 * @Copyright shine_yu@vip.163.com .
 */
public class LinkedListStack<E> implements Stack<E> {

    private LinkedList list;

    public LinkedListStack() {
        list = new LinkedList();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return (E)list.removeFirst();
    }

    @Override
    public E peek() {
        return (E)list.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: >");
        res.append(list);
        return res.toString();
    }
}
