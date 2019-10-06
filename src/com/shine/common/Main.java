package com.shine.common;

import com.shine.data.array.Array;
import com.shine.data.list.LinkedList;
import com.shine.data.queue.ArrayQueue;
import com.shine.data.queue.LinkedListQueue;
import com.shine.data.queue.LoopQueue;
import com.shine.data.queue.Queue;
import com.shine.data.stack.ArrayStack;
import com.shine.data.stack.LinkedListStack;
import com.shine.data.stack.Stack;
import com.shine.data.tree.BST;

import java.util.ArrayList;
import java.util.Random;


/**
 * 测试方法.
 *
 * @author shineYu
 * @date 2019/8/1 11:54
 * @Copyright shine_yu@vip.163.com .
 */
public class Main<E> {

    public static void main(String[] args) {

        //region 二分搜索树
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            bst.add(num);
        }

        //bst.preOrder();
        //System.out.println();
        //
        //bst.inOrder();
        //System.out.println();
        //
        //bst.postOrder();
        //System.out.println();


        //bst.levelOrder();
        //System.out.println(bst.maximum());

        //int n = 1000;
        //Random random = new Random();
        //for (int i = 0; i < n; i++) {
        //    bst.add(random.nextInt(10000));
        //}
        //
        //ArrayList<Integer> lists = new ArrayList<>();
        //while (!bst.isEmpty()) {
        //    lists.add(bst.removeMin());
        //}
        //System.out.println(lists);


        System.out.println(bst.toString());
        bst.remove(6);
        System.out.println(bst.toString());

        //endregion

        //region 队列链表比较
        int count = 10000000;
        //findSecondMax();
        //stackTest();
        //arrayQueueTest();
        //loopQueueTest();
        //linkedListQueueTest();
        //ArrayQueue<Integer> arrayQueue = new ArrayQueue();
        //double time1 = queueTest(arrayQueue, count);
        //System.out.println("ArrayQueue, time:" + time1 + " s");

        //LoopQueue<Integer> loopQueue = new LoopQueue();
        //double time2 = queueTest(loopQueue, count);
        //System.out.println("LoopQueue, time:" + time2 + " s");
        //
        //LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue();
        //double time3 = queueTest(linkedListQueue, count);
        //System.out.println("LinkedListQueue, time:" + time3 + " s");
        //ArrayStack<Integer> arrayStack = new ArrayStack<>();
        //double arrayStackTime = stackTest(arrayStack, count);
        //System.out.println("ArrayStack, time: " + arrayStackTime + " s.");
        //
        //
        //LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        //double linkedListStackTime = stackTest(linkedListStack, count);
        //System.out.println("LinkedListStack, time: " + linkedListStackTime + " s.");
        //linkedListTest();
        //linkedListStackTest();
        //endregion

    }

    //region 查找数组中的第二大元素.
    /**
     * 查找数组中的第二大元素.
     *
     */
    public static void findSecondMax(){
        Integer firstMax = 0;
        Integer secondMax = 0;
        Array<Integer> array = new Array<>();

        for (int i = 0; i < 20; i++) {
            array.addLast((int)((Math.random()*9+1)*100000));
        }

        System.out.println(array);


        for (int i = 0; i < array.getSize(); i++) {
            if (array.get(i)>firstMax) {
                firstMax = array.get(i);
            }else if (array.get(i)>secondMax){
                secondMax = array.get(i);
            }else{
                continue;
            }
        }


        System.out.println(String.format("最大值：%d，第二大值：%d", firstMax, secondMax));

    }
    //endregion

    //region 栈测试

    /**
     * 栈测试.
     */
    public static void stackTest(){
        ArrayStack stack = new ArrayStack();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
    //endregion

    //region 数组队列测试

    /**
     * 数组队列测试.
     */
    public static void arrayQueueTest(){
        ArrayQueue queue = new ArrayQueue();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            if (i%3==2) {
                queue.dequeue();
                System.out.println(queue);
            }
            System.out.println(queue);
        }
    }
    //endregion

    //region 循环队列测试

    /**
     * 循环队列测试
     */
    public static void loopQueueTest(){
        LoopQueue queue = new LoopQueue();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            if (i%3==2) {
                queue.dequeue();
                System.out.println(queue);
            }
            System.out.println(queue);
        }
    }
    //endregion

    //region 数组队列测试

    /**
     * 数组队列测试.
     */
    public static void linkedListQueueTest(){
        LinkedListQueue<Integer> queue = new LinkedListQueue();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            if (i%3==2) {
                queue.dequeue();
                System.out.println(queue);
            }
            System.out.println(queue);
        }
    }
    //endregion

    //region 队列比较

    /**
     * 测试队列.
     *
     * @param queue 队列
     * @param count 数量
     * @return 花费时间
     */
    public static double queueTest(Queue<Integer> queue, int count) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < count; i++) {
            queue.dequeue();
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }
    //endregion

    //region 链表测试

    /**
     * 链表测试.
     */
    public static void linkedListTest(){
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(2,666);
        System.out.println(linkedList);
    }
    //endregion

    //region 栈比较

    /**
     * 测试队列.
     *
     * @param stack 栈
     * @param count 数量
     * @return 花费时间
     */
    public static double stackTest(Stack<Integer> stack, int count) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < count; i++) {
            stack.pop();
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }
    //endregion

    //region 链表测试

    /**
     * 链表栈测试.
     */
    public static void linkedListStackTest(){
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
    //endregion

}
