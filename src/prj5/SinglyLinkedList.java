/**
 * 
 */
package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Basic implementation of the linked list class
 * 
 * @author Ryan Bui (ryantb)
 * @author Sean Le (sean2022)
 * @author Christina Tran (christinatran)
 * 
 * @version 2019.11.27
 * 
 * @param <T> the generic type
 *
 */
public class SinglyLinkedList<T> {

    /**
     * fields
     */
    private Node<T> head;
    private int size;

    /**
     * constructor for SinglyLinkedList<T>
     */
    public SinglyLinkedList() {
        head = null;
        size = 0;
    }
    
    /**
     * gets the size of the list
     * 
     * @return the size of the list
     */
    public int size() {
        return size;
    }

    /**
     * checks if the list is empty
     * 
     * @return true if the list is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * adds an object to a specific position in the list
     * 
     * @precondition obj can't be null
     * @param index where to add the object
     * @param obj   the object being added
     * @throws IndexOutOfBoundsException if index is less than zero or greater than
     *                                   than the size
     * @throws IllegalArgumentException if the object is null
     */
    public void add(int index, T obj) {
        // checks if the object is null
        if (obj == null) {
            throw new IllegalArgumentException("Object is null");
        }
        
        // checks if the index is out of bounds
        if ((index < 0) || (index > size())) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        
        Node<T> current = head;
        
        // if the list is empty, add it to head
        if (isEmpty()) {
            head = new Node<T>(obj);
        }
        
        // all other cases
        else {
            // index 0 is the head, so replace head
            // and push other elements
            if (index == 0) {
                Node<T> newNode = new Node<T>(obj);
                newNode.setNext(head);
                head = newNode;
            } // end if
            
            else {
                int currentIndex = 0;
                while (current != null) {
                    if ((currentIndex + 1) == index) {
                        Node<T> nextNext = current.next;
                        Node<T> newNode = new Node<T>(obj);
                        current.setNext(newNode);
                        newNode.setNext(nextNext);
                        return;
                    } //end if 
                    
                    current = current.next;
                    currentIndex++;
                } // end while
            } // end else for index != 0
        } // end else of other cases
        size++;
    } // end add method
    
    /**
     * adding to the end of the list
     * 
     * @precondition obj cannot be nul
     * @param obj the object to add
     * @throws IllegalArgumentException if obj is null
     */
    public void add(T obj) {
        // check if the object is null
        if (obj == null) {
            throw new IllegalArgumentException("Object is null");
        }
        
        Node<T> current = head;
        
        // empty list case
        if (isEmpty()) {
            head = new Node<T>(obj);
        }
        
        // other cases
        else {
            while (current.next != null) {
                current = current.next;
            } // end while method
            current.setNext(new Node<T>(obj));
        } //end else other cases
        size++;
    } // end add method (1 param)
    
    /**
     * Removes the head of the list
     * 
     * @param obj the object to remove
     * @return true if remove was successful
     */
    public boolean remove(T obj) {
        Node<T> current = head;
        
        // if obj is the same as the head
        if ((null != head) && (obj.equals(current.data))) {
            head = head.next;
            size--;
            return true;
        }
        
        // account for 2+ size
        while (size() >= 2 && (current.next != null)) {
            if ((obj.equals(current.next.data))) {
                if (current.next.next != null) {
                    current.setNext(current.next.next);
                }
                else if (current.next.next == null) {
                    current.setNext(null);
                }
                size--;
                return true;
            } // end if obj equals next node
            current = current.next;
        } // end while loop
        
        return false;
    }
    
    /**
     * Removes the object at the given position
     *
     * @param index the position of the object
     * @return true if the removal was successful
     * @throws IndexOutOfBoundsException if there is not an element at the index
     */
    public boolean remove(int index) {
        // if the index is invalid
        if (index < 0 || head == null || index > size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        if (index == 0) {
            head = head.next;
            size--;
            return true;
        } else {
            Node<T> current = head;
            int currentIndex = 0;

            while (current.next != null) {
                if ((currentIndex + 1) == index) {
                    Node<T> newNext = current.next.next;
                    current.setNext(newNext);
                    size--;
                    return true;
                }
                current = current.next;
                currentIndex++;
            }

            // if the element was never found, this also handles empty case
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
    }

    /**
     * Gets the object at the given position
     *
     * @param index where the object is located
     * @return The object at the given position
     * @throws IndexOutOfBoundsException if no node at the given index
     */
    public T get(int index) {
        Node<T> current = head;
        int currentIndex = 0;
        T data = null;
        while (current != null) {
            if (currentIndex == index) {
                data = current.data;
            }
            currentIndex++;
            current = current.next;
        }

        // check if the data was null...
        if (data == null) {
            // ... if so throw an exception
            throw new IndexOutOfBoundsException("Index exceeds the size.");
        }
        return data;
    }

    /**
     * Checks if the list contains the given object
     *
     * @param obj the object to check for
     * @return true if it contains the object
     */
    public boolean contains(T obj) {
        Node<T> current = head;
        while (current != null) {
            if (obj.equals(current.data)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    /**
     * Removes all of the elements from the list
     */
    public void clear() {
        // make sure we don't call clear on an empty list
        if (head != null) {
            head.setNext(null);
            head = null;
            size = 0;
        }

    }

    /**
     * Gets the last time the given object is in the list
     *
     * @param obj the object to look for
     * @return the last position of it. -1 If it is not in the list
     */
    public int lastIndexOf(T obj) {
        int lastIndex = -1;
        Node<T> current = head;
        int currentIndex = 0;
        while (current != null) {
            if (obj.equals(current.data)) {
                lastIndex = currentIndex;
            }
            currentIndex++;
            current = current.next;

        }
        return lastIndex;
    }

    /**
     * Returns a string representation of the list If a list contains A, B, and
     * C, the following should be returned "{A, B, C}" (Without the quotations)
     *
     * @return a string representing the list
     */
    @Override
    public String toString() {
        String result = "{";

        Node<T> current = head;
        while (current != null) {
            result += "" + current.data.toString();
            current = current.next;
            if (current != null) {
                result += ", ";
            }
        }
        result += "}";
        return result;
    }

    /**
     * Returns true if both lists have the exact same contents in the exact same
     * order
     *
     * @return a boolean of whether two lists have the same contents, item per
     *         item and in the same order
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() == obj.getClass()) {
            @SuppressWarnings("unchecked")
            SinglyLinkedList<T> other = ((SinglyLinkedList<T>) obj);
            if (other.size() == this.size()) {
                Node<T> current = head;
                Node<T> otherCurrent = other.head;
                while (current != null) {
                    if (!current.getData().equals(otherCurrent.getData())) {
                        return false;
                    }
                    current = current.next();
                    otherCurrent = otherCurrent.next();
                }
                return true;
            }
        }

        return false;
    }
    
    public Iterator<T> iterator() {
        return new ListIterator<T>();
    }
    
    /**
     * Iterator implementation
     * 
     * @author Ryan Bui (ryantb)
     * @author Sean Le (sean2022)
     * @author Christina Tran (christinatran)
     *
     * @version 2019.11.27
     * 
     * @param <T> generic type
     */
    @SuppressWarnings("hiding")
    private class ListIterator<T> implements Iterator<T> {
        /**
         * fields
         */
        private Node<T> node;
        
        /**
         * constructor for ListIterator
         */
        @SuppressWarnings("unchecked")
        public ListIterator() {
            if (isEmpty()) {
                node = null;
            }

            else {
                node = (Node<T>) head;
            }
        }

        @Override
        public boolean hasNext() {
            if (isEmpty()) {
                return false;
            }
            
            return node.next() != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
                
            }
            Node<T> temp = node;
            node = node.next();
            return temp.getData();
        }
        
    }

    /**
     * Node implementation
     * 
     * @author Ryan Bui
     * @author Sean Le (sean2022)
     * @author Christina Tran (christinatran)
     * @version 2019.11.27
     *
     * @param <T>
     */
    static class Node<T> {
        /**
         * fields for nodes
         */
        private T data;
        private Node<T> next;

        /**
         * constructor
         * 
         * @param data the data to put in the node
         */
        public Node(T d) {
            data = d;
        }

        /**
         * sets the next node
         * 
         * @param n the next node
         */
        public void setNext(Node<T> n) {
            next = n;
        }

        /**
         * get the next node GETTER METHOD
         * 
         * @return the next node
         */
        public Node<T> next() {
            return next;
        }

        /**
         * gets the data of the node
         * 
         * @return the data of the current node
         */
        public T getData() {
            return data;
        }
    } // end node class
}
