package com.shine.datas.heap;

import com.shine.datas.array.Array;

/**
 * 最大堆
 *
 * @author shineYu
 * @date 2019/10/7 23:26
 * @Copyright shine_yu@vip.163.com .
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEnpty();
    }

    /**
     * 返回节点所在的父亲节点
     *
     * @param index 节点所在索引
     * @return 父亲节点索引
     */
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index 0 doesn't have parent.");
        }
        return (index - 1) / 2;
    }

    /**
     * 返回节点所在的左孩子节点
     *
     * @param index 节点所在索引
     * @return 左孩子节点索引
     */
    private int leftChild(int index){
        return index * 2 + 1;
    }

    /**
     * 返回节点所在的右孩子节点
     *
     * @param index 节点所在索引
     * @return 右孩子节点索引
     */
    private int rightChild(int index){
        return index * 2 + 2;
    }

    /**
     * 向堆中添加元素
     *
     * @param e 元素
     */
    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    /**
     * 上浮siftUp
     *
     * @param k 当前节点索引
     */
    private void siftUp(int k){

        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {

            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    /**
     * 向堆中取出最大元素
     *
     * @return E 最大元素
     */
    public E extractMax(){

        E ret = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    /**
     * 下沉siftDown
     *
     * @param k 当前节点索引
     */
    private void siftDown(int k) {

        while (leftChild(k) < data.getSize()) {

            int j = leftChild(k);
            if ((j+1)<data.getSize()&&data.get(j+1).compareTo(data.get(j))>0) {
                //data[j]是leftChild和rightChild中的最大值
                j = rightChild(k);
            }
            if (data.get(k).compareTo(data.get(j))>=0) {
                break;
            }else{
                data.swap(k, j);
                k = j;
            }
        }
    }

    /**
     * 看堆中最大元素
     *
     * @return 最大元素
     */
    public E findMax(){
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("Can't findMax when heap is empty.");
        }
        return data.get(0);
    }
}
