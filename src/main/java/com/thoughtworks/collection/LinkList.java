package com.thoughtworks.collection;

public class LinkList<T> implements SingleLink<T>{
    class Node{
        private T val;
        private Node next;

        public Node(T val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    private Node head;//指向链表头节点的引用变量
    private Node tail;//指向链表尾节点的引用变量
    int size;//链表中当前总节点数

    // 生成链表对象是一个空表
    public LinkList() {
        head = null;
        tail = null;
    }

    //生成链表对象时有一个头节点 （有参构造器）
    public LinkList (T data)
    {
        head = new Node(data,null);//指定一个头节点的数据域值为data,不指向其他节点
        tail = head;
        size++;
    }



    @Override
    public T getHeaderData() {
        Node node = head;
        return node.val;
    }

    @Override
    public T getTailData() {
        Node node = head;
        while(node.next!=null){
            node = node.next;
        }
        return node.val;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean deleteFirst() {
        Node node = head;
        if(node != null){
            head = head.next;
            return true;
        }else{
            return false;
        }

    }

    @Override
    public boolean deleteLast() {
        int count=0;
        Node current = head;
        while (current !=null && count != size()-2){
            current = current.next;
            count++;
        }
        Node deleteNode = current.next;
        current.next = deleteNode.next;
        deleteNode.next=null;
        return true;
    }

    @Override
    public void addHeadPointer(T item) {
        head = new Node(item,head);
        if(tail == null){
            tail = head;
        }
    }

    @Override
    public void addTailPointer(T item) {
        if(head==null){
            head = new Node(item,null);
            tail = head;
        }else{
            Node newNode = new Node(item,null);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public T getNode(int index) {
        if(index<0 || index > size-1){
            return null;
        }else{
            int count = 0;
            Node curr = head;
            while (curr != null && count!=index-1){
                curr = curr.next;
                count++;
            }
            return curr.val;
        }
    }
}
