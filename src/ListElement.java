import java.io.*;
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.util.Objects;
/**
 * @author Mokhammad Nadzhim
 * @version 1.0
 */

/**
 * This is a list item class
 */
class ListElement {

    /** The field is a pointer to the next item in the list*/
    public ListElement next;

    /** Element value field*/
    int data;

    /**
     * Creates an element with the entered data
     * @param data element value
     */
    public ListElement(int data)
    {
        this.data = data;
        next = null;
    }

    /**
     * Сreates an empty element
     */
    public ListElement()
    {
        data=0;
        next=null;
    }

    /**
     * Creates an element with the entered data and a pointer to the next element
     * @param data element value
     * @param next pointer to the next element
     */
    public ListElement(int data, ListElement next )
    {
        this.data = data;
        this.next = next;
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
        ListElement that = (ListElement) o;
        return data == that.data && Objects.equals(next, that.next);
    }

    /**
     * Overriding of hashCode method from Object class because we override equals
     * @return hash of instance
     */
    @Override
    public int hashCode() {
        return Objects.hash(next, data);
    }
}



