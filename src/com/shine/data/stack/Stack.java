package com.shine.data.stack;

/**
 * 栈接口.
 *
 * @author shineYu
 * @date 2019/8/6 22:40
 * @Copyright shine_yu@vip.163.com .
 */
public interface Stack<E> {

    /**获取栈数量*/
    int getSize();
    /**栈是否为空*/
    boolean isEmpty();
    /**添加栈顶元素*/
    void push(E e);
    /**取出栈顶元素*/
    E pop();
    /**查看栈顶*/
    E peek();

}
