package com.shine.datas.set;

/**
 * 集合接口
 *
 * @author shineYu
 * @date 2019/10/6 15:57
 * @Copyright shine_yu@vip.163.com .
 */
public interface Set<E> {

    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int getSize();

    boolean isEmpty();

}
