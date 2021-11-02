package com.compushastra.adt;

import java.util.ArrayList;

public class LinkedListImpl implements LinkedList {
    private ListNode header = new ListNode();
    private int currLength = 0;

    public boolean isEmpty() {
        return header.next == null;
    }

    @Override
    public int length() {
//        int count = 0;
//        if (!isEmpty()) {
//            ListNode node = header.next;
//            while (node != null) {
//                ++count;
//                node = node.next;
//            }
//        }
//        return count;
        return currLength;
    }

    @Override
    public void empty() {
        header.next = null;
    }

    @Override
    public void add(Object element) {
        if (isEmpty()) this.header.next = new ListNode(element);
        else {
            ListNode node = header.next;
            while (node.next != null) {
                node = node.next;
            }

            node.next = new ListNode(element);
        }
        ++currLength;
    }

    @Override
    public Object get(int index) throws IndexOutOfBoundsException {
        ListNode node = nodeAt(index);
        if (node != null) return node.element;

        throw new IndexOutOfBoundsException();
    }

    private ListNode nodeAt(int index) {
        if (isEmpty()) throw new IndexOutOfBoundsException();
        int currIndex = 0;
        ListNode node = this.header.next;

        while (currIndex < index && node != null) {
            ++currIndex;
            node = node.next;
        }

        return node;
    }

    @Override
    public void insertAt(int index, Object element) throws IndexOutOfBoundsException {
        if (index > currLength)
            throw new IndexOutOfBoundsException(String.format("Index {} greater than the length {}", index, currLength));

        ListNode newNode = new ListNode(element);

        ListNode node = nodeAt(index == 0 ? index : index - 1);
        if (index == 0) {
            newNode.next = node;
            header.next = newNode;
        } else {
            newNode.next = node.next;
            node.next = newNode;
        }
        ++currLength;
    }

    @Override
    public Object removeAt(int index) throws IndexOutOfBoundsException {
        if (isEmpty() || index == currLength) throw new IndexOutOfBoundsException(index);

        ListNode node = nodeAt(index == 0 ? index : index - 1);
        Object removed = node.element;
        if (index == 0) {
            header.next = node.next;
        } else {
            removed = node.next.element;
            node.next = node.next.next;
        }
        --currLength;
        return removed;
    }

    @Override
    public int remove(Object element) {
        int index = indexOf(element);
        if (index != -1) removeAt(index);
        return index;
    }

    /**
     * Returns -1 if element is not found else returns the index (index starts at 0)
     *
     * @param element
     * @return
     */
    public int indexOf(Object element) {
        ListNode node = header;

        int index = 0;
        while (node.next != null) {
            node = node.next;
            if (node.element.equals(element)) return index;
            ++index;
        }

        return -1;
    }

    @Override
    public String toString() {
        ListNode node = header.next;
        StringBuilder sb = new StringBuilder("LinkedList[");
        while (node != null) {
            sb.append(String.valueOf(node.element)).append(",");
            node = node.next;
        }

        sb.setLength(sb.length() - 1);
        return sb.append("]").toString();
    }
}

class ListNode {
    Object element;
    ListNode next;

    public ListNode() {
        this(null);
    }

    public ListNode(Object element) {
        this(element, null);
    }

    public ListNode(Object element, ListNode next) {
        this.element = element;
        this.next = next;
    }

    @Override
    public String toString() {
        return String.valueOf(element);
    }
}


