package com.shine.datas.queue;

/**
 * 队列接口
 *
 * @author shineYu
 * @date 2019/8/6 23:47
 * @Copyright shine_yu@vip.163.com .
 */
public interface Queue<E> {
    /**获取队列元素个数*/
    int getSize();
    /**队列是否为空*/
    boolean isEmpty();
    /**入队*/
    void enqueue(E e);
    /**出队*/
    E dequeue();
    /**获取队首元素*/
    E getFront();

}
