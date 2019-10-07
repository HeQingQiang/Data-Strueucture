package com.shine.datas.map;

/**
 * 映射
 *
 * @author shineYu
 * @date 2019/10/6 19:09
 * @Copyright shine_yu@vip.163.com .
 */
public interface Map<K, V> {

    void add(K key, V value);

    V remove(K key);

    boolean contains(K key);

    V get(K key);

    void set(K key, V value);

    int getSize();

    boolean isEmpty();

}
