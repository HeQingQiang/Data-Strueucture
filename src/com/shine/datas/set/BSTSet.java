package com.shine.datas.set;

import com.shine.datas.tree.BST;

/**
 * 二分搜索树实现集合
 *
 * @author shineYu
 * @date 2019/10/6 15:59
 * @Copyright shine_yu@vip.163.com .
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {

    private BST<E> bst;

    public BSTSet() {
        bst = new BST<>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
