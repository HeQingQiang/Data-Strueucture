package com.shine.datas.map;

/**
 * 二分搜索树实现映射
 *
 * @author shineYu
 * @date 2019/10/6 19:54
 * @Copyright shine_yu@vip.163.com .
 */
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    private Node root;
    private int size;

    private class Node {
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    private Node add(Node node, K key, V value) {

        if (node == null) {
            size++;
            return new Node(key, value);
        }

        //如果node.e=e，不做任何处理
        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }

        return node;
    }

    @Override
    public V remove(K key) {

        Node node = getNode(root, key);
        if (node != null) {
            root = remove(root, key);
            return root.value;
        }

        return null;
    }

    /**
     * 删除掉以node为根的二分搜索树中键为key的节点，递归算法
     * 返回删除节点后的二分搜索树的根
     *
     * @param node 子树根
     * @param key 删除元素
     * @return 新节点根
     */
    private Node remove(Node node, K key){

        if (node ==null) {
            return null;
        }

        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        }else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        }else{
            //左子树为空
            if (node.left == null){
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

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public V get(K key) {

        Node node = getNode(root, key);
        if (node == null) {
            return null;
        }else{
            return node.value;
        }
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException(key + "doesn't exist !");
        }else{
            node.value = newValue;
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private Node getNode(Node node, K key) {

        if (node == null) {
            return null;
        } else {
            if (key.compareTo(node.key) == 0) {
                return node;
            } else if (key.compareTo(node.key) > 0) {
                return getNode(node.right, key);
            } else {
                return getNode(node.left, key);
            }
        }
    }

}