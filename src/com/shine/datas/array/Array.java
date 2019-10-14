package com.shine.datas.array;


/**
 * 动态数组.
 *
 * @author shineYu
 * @date 11:10
 * @Copyright shine_yu@vip.163.com
 */
public class Array<E> {

    private E[] data;
    private Integer size;

    /**
     * 带参构造函数，传入数组的容量构造数组.
     * .
     *
     * @param capacity 容量
     */
    public Array(Integer capacity) {
        data = (E[])new Object[capacity];
        size = 0;
    }

    /**
     * 将传入的数组转换为数组
     *
     * @param arr
     */
    public Array(E[] arr){
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        size = arr.length;
    }

    /**
     * 无参构造函数，默认数组的容量为10.
     */
    public Array() {
        this(10);
    }

    /**
     * 获取数组中的元素个数.
     *
     * @return 个数
     */
    public Integer getSize() {
        return size;
    }

    /**
     * 获取数组中的容量.
     *
     * @return 容量
     */
    public Integer getCapacity() {
        return data.length;
    }

    /**
     * 查询数组是否为空.
     *
     * @return 结果
     */
    public boolean isEnpty() {
        return size == 0;
    }

    /**
     * 向所有元素后添加一个新元素.
     *
     * @param e 新元素
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 向所有元素前添加一个新元素.
     *
     * @param e 新元素
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在第index个位置插入一个新的元素e.
     *
     * @param index
     * @param e
     */
    public void add(Integer index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("添加失败，数组下标必须大于等于0，且小于等于数组个数");
        }
        //动态扩容
        if (size == data.length) {
            resize(2*data.length);
        }
        for (Integer i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 获取index索引位置的元素.
     *
     * @param index 位置下标
     * @return 结果
     */
    public E get(Integer index) {
        if (index<0||index>=size) {
            throw new IllegalArgumentException("查询失败，数组下标必须大于等于0，且小于等于数组个数");
        }
        return data[index];
    }

    /**
     * 修改index索引位置的元素.
     *
     * @param index 位置下标
     */
    public void set(Integer index, E e) {
        if (index<0||index>=size) {
            throw new IllegalArgumentException("查询失败，数组下标必须大于等于0，且小于等于数组个数");
        }
        data[index] = e;
    }

    /**
     * 查找数组中是否存在元素e.
     *
     * @param e 查找的元素
     * @return 结果
     */
    public boolean contains(E e) {
        for (Integer i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中元素e所在的索引，如果不存在元素e，返回-1.
     *
     * @param e 查找的元素
     * @return 结果
     */
    public Integer find(Integer e){
        for (Integer i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 从数组中删除index位置的元素，返回删除的元素.
     *
     * @param index 数组下标
     * @return 被删除的元素
     */
    public E remove(Integer index){
        if (index<0||index>=size) {
            throw new IllegalArgumentException("删除失败，数组下标必须大于等于0，且小于等于数组个数");
        }
        E result = data[index];
        for (Integer i = index+1; i < size; i++) {
            data[i - 1] = data[i];
        }
        //动态缩容
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        size--;
        data[size] = null;
        return result;
    }

    /**
     * 从数组中删除第一个的元素，返回删除的元素.
     *
     * @return 被删除的元素
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 从数组中删除最后一个的元素，返回删除的元素.
     *
     * @return 被删除的元素
     */
    public E removeLast(){
        return remove(size - 1);
    }

    /**
     * 删除数组中的元素e
     *
     * @param e 待删除的元素
     */
    public void removeElement(Integer e) {
        Integer index = find(e);
        if (index!=-1) {
            remove(index);
        }
    }

    public E getLast(){
        return get(size - 1);
    }

    public E getFirst(){
        return get(0);
    }

    /**
     * 数组扩容=>动态数组原理所在.
     *
     * @param newCapacity 新容量
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    /**
     * 交换两位下标元素的位置
     * @param i
     * @param j
     */
    public void swap(int i, int j){
       if (i < 0 || i>= size || j< 0 ||j >= size) {
           throw new IllegalArgumentException("Index is illegal.");
        }else{
           E t = data[i];
           data[i] = data[j];
           data[j] = t;
       }
    }

    /**
     * 重写toString方法.
     *
     * @return 输出结果
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format(
                "Array: size = %d, capacity = %d\n",
                size,
                data.length));
        result.append('[');
        for (Integer i = 0; i < size; i++) {
            result.append(data[i]);
            if (i!=size-1) {
                result.append(',');
            }
        }
        result.append(']');

        return result.toString();
    }

}
