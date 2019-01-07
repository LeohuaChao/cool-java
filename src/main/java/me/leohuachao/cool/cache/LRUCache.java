package me.leohuachao.cool.cache;

import java.util.HashMap;

/**
 * @author leohuachao
 * @version V1.0
 * @Description: TODO
 * @date 2019/1/2
 */
public class LRUCache<K, V> {

    private HashMap<K, LRUCache.Node> map;

    private Node head;

    private Node tail;

    private int maxSize;

    static class Node<K, V> {
        Node next;
        Node prev;

        K key;
        V value;

        public Node() {

        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private void addNode(Node node) {
        tail.next = node;
        node.prev = tail;
        tail = node;
    }

    private void removeNode(Node node) {
        if (node == tail) {
            tail.prev.next = null;
            tail = tail.prev;
            node.prev = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
        }
    }

    public LRUCache(int maxSize){
        this.maxSize = maxSize;
        map = new HashMap<K, LRUCache.Node>();
        head = new Node();
        tail = head;
    }

    public void put(K k, V v) {

        if (null == k) {
            throw new NullPointerException();
        }

        Node node = map.get(k);

        if (null == node) {
            node = new Node(k, v);
            map.put(k, node);
            addNode(node);

            if (map.size() > maxSize) {
                Node outDate = head.next;
                removeNode(outDate);
                map.remove(outDate.key);
            }
        } else {
            removeNode(node);
            addNode(node);
            node.value = v;
        }

    }

    public V remove(K k) {
        Node<K, V> node = map.remove(k);

        if (null != node) {
            removeNode(node);
            return node.value;
        }

        return null;
    }

    public V get(K k) {
        Node<K, V> node = map.get(k);

        if (null != node) {
            removeNode(node);
            addNode(node);
            return node.value;
        }

        return null;
    }
}
