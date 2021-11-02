import java.io.*;
import java.util.Scanner;
import java.util.NoSuchElementException;
/**
 * @author Mokhammad Nadzhim
 * @version 1.0
 *
 *
 */

/**
 * This is a list item class
 */
class ListElement {
    /** The field is a pointer to the next item in the list*/
    public ListElement next;
    /** The field is a pointer to the previous item in the list*/
    /** Element value field*/
    int data;
    public ListElement(int data) {
        this.data = data;
        next = null;
    }


    public ListElement() {
        next=null;
        data=0;
    }
    public ListElement(int data, ListElement next ) {
        this.data = data;

        this.next = next;
    }
}

/**
 * A container class that allows you to store an arbitrary number of objects
 */
class List {
    /**
     * The pointer to the beginning of the list field
     */
    private ListElement head;
    /**
     * The pointer to the end of the list field
     */
    private ListElement tail;
    /**
     * A field that stores the dimension of the list
     */
    private int size = 0;

    /**
     * Сreating a class with null values
     */
    public List() {
        head = tail = null;
        size = 0;
    }

    /**
     * Method that adds an item to the top of the list
     *
     * @param data the value of the element being added
     */
    void add_in_front(int data) {
        ListElement new_element = new ListElement();
        new_element.data = data;

        if (head == null) {
            head = new_element;
            tail = new_element;
            size++;
        } else {
            new_element.next = head;
            head = new_element;
            size++;
        }


    }

    /**
     * Method that adds an item to the end of the list
     *
     * @param data the value of the element being added
     */
    void add_in_back(int data) {
        ListElement new_element = new ListElement();
        new_element.data = data;
        if (tail == null) {
            head = new_element;
            tail = new_element;
            size++;
        } else {
            tail.next = new_element;
            tail = new_element;
            size++;
        }
    }

    /**
     * Еhe method of checking for emptiness
     *
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return head == null;
    }


    /**
     * Method of inserting an element in an arbitrary place
     *
     * @param pos  position of the new item in the list
     * @param data the value of the new element
     * @throws Exception when the index out of range
     */
    public void add_in_position(int pos, int data) throws Exception {
        if (pos > size || pos < 0) {
            throw new Exception("Индекс  введен неверно");
        }
        if (pos == 0) {
            add_in_front(data);
        } else if (pos == size) {
            add_in_back(data);
        } else {
            ListElement t = this.head;
            int i = 0;
            while (t != null) {
                if (i + 1 == pos) {
                    ListElement new_element = new ListElement();
                    new_element.data = data;
                    new_element.next = t.next;
                    t.next = new_element;
                    size++;

                }
                t = t.next;
                i++;
            }
        }

    }

    /**
     * Method that gets the dimension of the list
     *
     * @return dimension of an int type list
     */
    int getSize() {
        return size;
    }

    public void delete_back() throws Exception {
        if (isEmpty()) {
            throw new Exception("Attempt to delete element from empty List");
        } else {
            if (head.next == null) {
                head = tail = null;
            } else {
                ListElement q = this.head;
                ListElement t = this.head;
                while (q.next != null) {
                    t = q;
                    q = q.next;
                }
                t.next = null;
            }
            size--;
        }
    }

    public void delete_first() throws Exception {
        if (isEmpty()) {
            throw new Exception("Attempt to delete element from empty List");
        } else {
            head = head.next;
            size--;
        }
    }

    public void delete_in_position(int index) throws Exception {
        if (index > size - 1) {
            throw new Exception("Out of list index range");
        }

        if (index == 0) {
            delete_first();
        } else if (index == size - 1) {
            delete_back();
        } else {
            ListElement t = this.head;
            int counter = 0;
            while (counter != index - 1) {
                t = t.next;
                counter++;
            }
            t.next = t.next.next;
            size--;
        }
    }
    public int get_element(int pos)
    {
        ListElement q=this.head;
        if (pos>=0&&pos<size) {

            for (int i = 0; i < size; i++) {
                if (i == pos) return q.data;
                q = q.next;
            }
        }
        return 0;

    }




    /**
     * The method that displays the list on the screen
     */
    void printList() {
        ListElement q = this.head;
        if (q == null) {
            System.out.println("Список пуст, добавьте в него элементы.");
            return;
        }

        while (q != null) {
            System.out.print(q.data);
            System.out.print(" ");
            q = q.next;
        }
    }

    /**
     * Redefined toString method
     *
     * @return list items
     */
    @Override
    public String toString() {
        String result = new String(" ");
        if (getSize() == 0) {
            return result;
        }
        for (int i = 0; i < getSize(); i++) {
            String t = null;
            try {
                t = Integer.toString(get_element(i));
            } catch (Exception e) {
                e.printStackTrace();
            }
            result += t.toString() + " ";
        }
        result = result.substring(0, result.length() - 1);
        return result;
    }
    @Override
    public int hashCode()
    {
        int hash = 31 * 3;
        if (!isEmpty()) {
            ListElement t = this.head;
            while (head != null) {
                hash += t.hashCode();
                t = t.next;
            }
        }
        return hash;
    }
}


