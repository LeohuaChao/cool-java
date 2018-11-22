package me.leohuachao.cool.algorithm.tree;

import java.util.*;

/**
 * @author leohuachao
 * @version V1.0
 * @Description: TODO
 * @date 2018/11/21
 */
public class TreeDemo {

    static class Node {
        public char value;
        public Node left;
        public Node right;

        public Node(char value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * 前序遍历--递归实现
     * @param root
     */
    public static void preOrder0(Node root) {
        if (null != root) {
            System.out.println(root.value);
            preOrder0(root.left);
            preOrder0(root.right);
        }
    }

    /**
     * 前序遍历
     * 非递归实现
     * @param root
     */
    public static void preOrder1(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        Node poped = null;
        Node node = root;

        while (null != node || !stack.isEmpty()) {

            if (null == node) {
                node = stack.pop();
            }

            System.out.println(node.value);

            if (null != node.right) {
                stack.push(node.right);
            }

            node = null == node.left ? null : node.left;
        }
    }

    /**
     * 中序遍历
     *
     * @param root
     */
    public static void inOrder0(Node root) {
        if (null != root) {
            inOrder0(root.left);
            System.out.println(root.value);
            inOrder0(root.right);
        }
    }

    /**
     * 中序遍历
     * 非递归实现
     * @param root
     */
    public static void inOrder1(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        Node node = root;

        while (null != node || !stack.isEmpty()) {

            if (node == null) {
                node = stack.peek();
            }

            if (node != stack.peek() && null != node.left) {
                stack.push(node);
                node = node.left;
                continue;
            }

            if (node == stack.peek()) {
                stack.pop();
            }

            System.out.println(node.value);

            node = null == node.right ? null : node.right;
        }
    }

    /**
     * 后序遍历
     * 递归实现
     * @param root
     */
    public static void postOrder(Node root) {
        if (null == root) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.value);
    }

    /**
     * 后序遍历
     * 非递归实现
     * @param root
     */
    public static void postOrder1(Node root) {
    }

    public static void main(String args[]) {

        Node x = new Node('g');
        Node y = new Node('e');

        Node a = new Node('d');

        a.right = y;

        Node b = new Node('f');
        b.left = x;
        Node c = new Node('b');
        c.left = a;
        c.right = b;


        Node g = new Node('c');

        Node root = new Node('a');
        root.left = c;
        root.right = g;

        postOrder(root);

    }

}
