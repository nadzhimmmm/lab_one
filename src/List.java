import java.io.*;
import java.util.Scanner;
import java.util.NoSuchElementException;
/**
 * A container class that allows you to store an arbitrary number of objects
 * @author Mokhammad Nadzhim
 * @version 1.0
 *
 *
 */
/**

 */
class List
{
    /** The pointer to the beginning of the list field*/
    List head;
    /** The pointer to the end of the list field*/
    List last;
    /** The field is a pointer to the next item in the list*/
    List next;
    /** Element Value field*/
    int value;
    /** A field that stores the dimension of the list*/
    int Size=0;
    /**
     * Method that removes an item from the list
     * @param data element value
     */
    void delete_element_position(int data)
    {
        List q=this.head;
        if (q==null) return;

        if ((head == last)&&(head.value==data)) {
            head=null;
            last=null;
            Size--;
            return;


        }

        if (q.value==data)
        {
            head=head.next;
            Size--;
            return;
        }
        while (q.next != null) {
            if (q.next.value == data) {

                q.next = q.next.next;
                Size--;
                return;
            }
            q = q.next;
        }
        System.out.println("Такого числа нету");
    }
    /**
     * Method that adds an item to the end of the list
     * @param data the value of the element being added
     */
    void add_in_back(int data)
    {
        List a = new List();
        a.value = data;
        if (last == null)
        {
            head = a;
            last = a;
            Size++;
        } else {
            last.next = a;
            last = a;
            Size++;
        }
    }
    /**
     * The method that displays the list on the screen
     */
    void printList() {
        List q = this.head;
        if (q == null) {
            System.out.println("Список пуст, добавьте в него элементы.");
            return;
        }

        while (q != null) {
            System.out.print(q.value);
            System.out.print(" ");
            q = q.next;
        }
    }
    /**
     * Method of inserting an element in an arbitrary place
     * @param num position of the new item in the list
     * @param value the value of the new element
     */
    public void add(int num, int value)
    {
        List t = this.head;
        int i=0;
        if(num>0 && num<get_Size()) {
            while (t != null) {
                if (i + 1 == num) {
                    List e = new List();
                    e.value = value;
                    e.next = t.next;
                    t.next = e;
                    //t = e;
                    Size++;
                    return;
                }
                t = t.next;
                i++;
            }
        }
        else
        if (num==get_Size())
        {
            add_in_back(value);

            return;
        }
        else
        if (num==0)
        {
            add_in_front(value);
            return;
        }
        else return;

    }
    /**
     * A method that returns the value of an element
     * @param pos index of the returned element
     * @return the value of an int type element
     */
    public int get_element(int pos)
    {
        List q=this.head;
        if (pos<0||pos>get_Size())
            return 0;
        else {
            for (int i = 0; i < get_Size(); i++) {
                if (i == pos) return q.value;
                q = q.next;
            }
        }
        return 0;
    }
    /**
     * Method that gets the dimension of the list
     * @return dimension of an int type list
     * */
    public int get_Size()
    {
        return Size;

    }

    /**
     * Method that adds an item to the top of the list
     * @param value the value of the element being added
     */
    void add_in_front(int value)
    {
        List a = new List();
        a.value = value;

        if(head == null)
        {
            head = a;
            last = a;
            Size++;
        }
        else {
            a.next = head;
            head = a;
            Size++;
        }
    }

    /**
     * Redefined toString method
     * @return list items
     */
    @Override
    public String toString(){
        String result=new String(" ");
        if(get_Size()==0)
        {
            return result;
        }
        for(int i=0;i<get_Size();i++)
        {
            String t=Integer.toString(get_element(i));
            result+=t.toString()+ " ";
        }
        result=result.substring(0,result.length()-1);
        return result;
    }
}
