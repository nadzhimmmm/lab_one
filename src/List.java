import javax.swing.*;
import java.util.Objects;
/**
 * @author Mokhammad Nadzhim
 * @version 1.0
 */
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
     * Creating a class with null values
     */
    public List()
    {
        head = tail = null;
        size = 0;
    }

    /**
     * Method that adds an item to the top of the list
     *
     * @param data the value of the element being added
     */
    void add_in_front(int data)
    {
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
    void add_in_back(int data)
    {
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
     * The method of checking for emptiness
     *
     * @return true if empty, false otherwise
     */
    public boolean isEmpty()
    {
        return head == null;
    }


    /**
     * Method of inserting an element in an arbitrary place
     *
     * @param pos  position of the new item in the list
     * @param data the value of the new element
     * @throws Exception when the index out of range
     */
    public void add_in_position(int pos, int data) throws Exception
    {
        if (pos > size || pos < 0) {
            throw new Exception("The index is entered incorrectly");
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

    /**
     * Deleting the last item in the list
     * @throws  Exception when there's an attempt to delete Node from empty list
     */
    public void delete_last() throws Exception {
        if (isEmpty()) {
            throw new Exception("Attempt to delete an item from an empty list");
        } else {
            if (head.next == null) {
                head = tail = null;
            } else {
                ListElement q = this.head;
                ListElement new_last_elem = this.head;
                while (q.next != null) {
                    new_last_elem= q;
                    q = q.next;
                }
                new_last_elem.next = null;
                tail=new_last_elem;
            }
            size--;
        }
    }

    /**
     * Deleting the first item in the list
     * @throws Exception when there's an attempt to delete Node from empty list
     */
    public void delete_first() throws Exception {
        if (isEmpty()) {
            throw new Exception("Attempt to delete an item from an empty list");
        } else {
            head = head.next;
            size--;
        }
    }

    /**
     * Deleting an item by position
     * @param pos index of the item being deleted
     * @throws Exception attempt to delete an element with an invalid index
     */
    public void delete_in_position(int pos) throws Exception {
        if (pos > size) {
            throw new Exception("Delete an element with an invalid index");
        }
        if (pos == 0) {
            delete_first();
        } else if (pos == size-1) {
            delete_last();
        } else {
            ListElement t = this.head;
            int counter = 0;
            while (counter != pos - 1) {
                t = t.next;
                counter++;
            }
            t.next = t.next.next;
            size--;
        }
    }


    /**
     * The method that displays the list on the screen
     */
    void printList() {
        ListElement q = this.head;
        if (q == null) {
            System.out.println("The list is empty, add items to it.");
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
     * @return list items
     */
    @Override
    public String toString() {
        String result = new String(" ");
        if (getSize() == 0) {
            return "Список пуст.";
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

    /**
     * Overriding the equals method
     * @param o the object being compared
     * @return true if equal, false if not equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        List list = (List) o;
        return size == list.size && Objects.equals(head, list.head) && Objects.equals(tail, list.tail);
    }

    /**
     * Overriding of hashCode method from Object class because we override equals
     * @return hash of instance
     */
    @Override
    public int hashCode() {
        return Objects.hash(head, tail, size);
    }

    /**
     * Returns the data of last Node from the list
     * @return Data from Node
     * @throws Exception  when list is empty
     */
    public int back() throws Exception {
        if (tail != null) {
            return tail.data;
        } else {
            throw new Exception("Nothing to get from empty list");
        }
    }

    /**
     * Returns the data of first Node from the list
     * @return Data from Node
     * @throws Exception  when list is empty
     */
    public int front() throws Exception {
        if (head != null) {
            return head.data;
        } else {
            throw new Exception("Nothing to get from empty List");
        }
    }

    /**
     * Method for getting the value of an element by index
     * @param pos element index
     * @return element value
     * @throws Exception Out of index range
     */
    public int get_element(int pos) throws Exception
    {
        if (pos>= size||pos<0)
            throw new Exception("Out of index range");
        else {
            ListElement q = this.head;
            if (pos >= 0 && pos < size) {
                for (int i = 0; i < size; i++) {
                    if (i == pos) return q.data;
                    q = q.next;
                }
            }
        }
        return 0;
    }
}


