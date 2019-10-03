package com.shine.data.tree;

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

    public BST(int size) {
        this.size = size;
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
    public boolean contains(E e){
        return contains(root, e);
    }

    /**
     * 看以node为根的二分搜索树中是否包含元素e 递归算法
     *
     * @param node 子树
     * @param e 元素e
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
    public void preOrder(){
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

        if (node!=null) {
            System.out.println(node.e);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * 中序遍历
     */
    public void inOrder(){
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
    public void postOrder(){
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

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    /**
     * 前序遍历打印二叉树的所有元素
     *
     * @param node 子树
     * @param depth 深度
     * @param res 输出
     */
    private void generateBSTString(Node node, int depth, StringBuilder res){

        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth+1, res);
        generateBSTString(node.right, depth+1, res);
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
