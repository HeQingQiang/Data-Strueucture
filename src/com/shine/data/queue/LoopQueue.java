package com.shine.data.queue;


/**
 * 循环队列实现.
 *
 * @author shineYu
 * @date 2019/8/10 16:57
 * @Copyright shine_yu@vip.163.com .
 */
public class LoopQueue<E> implements Queue<E> {

    /**数据*/
    private E[] data;
    /**头下标，尾下标*/
    private int front, tail;
    /**数量*/
    private int size;
    /**带容积构造*/
    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity+1];
        front = 0;
        tail = 0;
        size = 0;
    }
    /**无参构造*/
    public LoopQueue() {
        this(10);
    }
    /**获取容积*/
    public int getCapacity(){
        return data.length - 1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        if ((tail+1)%data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    /**
     * 循环队列扩容.
     *
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        E[] newData=(E[])new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        E result = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size ==getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return result;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        return data[front];
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
                "Queue: size = %d, capacity = %d\n",
                size,
               getCapacity()));
        result.append("<<[");
        for (Integer i = front; i != tail; i=(i+1)%data.length) {
            result.append(data[i]);
            if ((i+1)%data.length != tail) {
                result.append(',');
            }
        }
        result.append("]<<");

        return result.toString();
    }
}
