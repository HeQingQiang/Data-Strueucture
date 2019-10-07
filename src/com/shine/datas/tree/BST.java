package com.shine.datas.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二分搜索树.
 *
 * @author shineYu
 * @date 2019/10/3 20:31
 * @Copyright shine_yu@vip.163.com .
 */
public class BST<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向二分搜索树添加元素e
     *
     * @param e 待添加元素
     */
    public void add(E e) {
        root = add(root, e);
    }

    /**
     * 向以node为根的二分搜索树添加元素e，递归算法
     *
     * @param node 子树
     * @param e    元素
     * @return Node 返回插入新节点后二分搜索树的根
     */
    private Node add(Node node, E e) {

        if (node == null) {
            size++;
            return new Node(e);
        }

        //如果node.e=e，不做任何处理
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }

        return node;
    }

    /**
     * 看二分搜索树中是否包含元素e
     *
     * @param e 元素e
     * @return 是否包含
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * 看以node为根的二分搜索树中是否包含元素e 递归算法
     *
     * @param node 子树
     * @param e    元素e
     * @return 是否包含
     */
    private boolean contains(Node node, E e) {

        if (node == null) {
            return false;
        }

        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    /**
     * 二分搜索树的前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 前序遍历以node为根的二分搜索树 递归算法
     *
     * @param node
     */
    private void preOrder(Node node) {

        //if (node == null) {
        //    return;
        //}

        if (node != null) {
            System.out.println(node.e);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 中序遍历以node为根的二分搜索树 递归算法
     *
     * @param node 子树
     */
    private void inOrder(Node node) {

        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);

    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    /**
     * 后序遍历以node为根的二分搜索树 递归算法
     *
     * @param node 子树
     */
    private void postOrder(Node node) {

        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);

    }

    /**
     * 二分搜索树层序遍历
     */
    public void levelOrder() {

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node cur = q.remove();
            System.out.println(cur.e);

            if (cur.left != null) {
                q.add(cur.left);
            }
            if (cur.right != null) {
                q.add(cur.right);
            }
        }
    }

    /**
     * 寻找二分搜索树最小元素
     *
     * @return E 最小元素e
     */
    public E minimum() {

        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        //非遍历实现
        //while (root.left != null) {
        //    root = root.left;
        //}
        //
        //return root.e;
        return minimum(root).e;
    }

    /**
     * 返回以node为根的二分搜索树最小值所在的节点
     *
     * @param node 子树
     * @return 最小元素所在节点
     */
    private Node minimum(Node node){
        if (node.left ==null) {
            return node;
        }
        return minimum(node.left);
    }

    /**
     * 寻找二分搜索树最小元素
     *
     * @return E 最小元素e
     */
    public E maximum() {

        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        //非遍历实现
        //while (root.right != null) {
        //    root = root.left;
        //}
        //
        //return root.e;
        return maximum(root).e;
    }

    /**
     * 返回以node为根的二分搜索树最小值所在的节点
     *
     * @param node 子树
     * @return 最小元素所在节点
     */
    private Node maximum(Node node){
        if (node.right ==null) {
            return node;
        }
        return maximum(node.right);
    }

    /**
     * 从二分搜索树中删除最小值所在的节点，返回最小值
     * @return
     */
    public E removeMin(){

        E ret = minimum();
        root = removeMin(root);
        return ret;

    }

    /**
     * 删除已node为跟的二分搜索树的最小节点，返回删除后新的二分搜索树的根
     *
     * @param node 子树
     * @return 新子树
     */
    private Node removeMin(Node node){

        if (node.left ==null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 从二分搜索树中删除最小值所在的节点，返回最小值
     * @return
     */
    public E removeMax(){

        E ret = minimum();
        root = removeMax(root);
        return ret;

    }

    /**
     * 删除已node为跟的二分搜索树的最大节点，返回删除后新的二分搜索树的根
     *
     * @param node 子树
     * @return 新子树
     */
    private Node removeMax(Node node){

        if (node.right ==null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 从二分搜索树中删除元素e的节点
     *
     * @param e 待删除的节点
     */
    public void remove(E e){
        remove(root, e);
    }

    /**
     * 删除掉以node为根的二分搜索树中值为e的节点，递归算法
     * 返回删除节点后的二分搜索树的跟
     *
     * @param node 子树根
     * @param e 删除元素
     * @return 新节点根
     */
    private Node remove(Node node, E e){

        if (node ==null) {
            return null;
        }

        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        }else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        }else{
            //左子树为空
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            //右子树为空
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            //左右子树都不为空，找到比e大的最小节点successor，顶替删除节点的位置
            //左右子树都不为空，找到比e小的最大节点predecessor，顶替删除节点的位置
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    /**
     * 前序遍历打印二叉树的所有元素
     *
     * @param node  子树
     * @param depth 深度
     * @param res   输出
     */
    private void generateBSTString(Node node, int depth, StringBuilder res) {

        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    /**
     * 打印深度
     *
     * @param depth 深度
     * @return 输出
     */
    private String generateDepthString(int depth) {

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("-");
        }
        return res.toString();
    }
}
