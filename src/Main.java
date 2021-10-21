import java.io.*;
import java.util.Scanner;
import java.util.NoSuchElementException;

/**
 * Here start point of the program
 */
class Main {

    public static void main(String[] args) {
        List l = new List();
        System.out.println("Введите количество элементов");
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        for (int i=0;i<n;i++)
        {
            System.out.println((i+1)+")");
            int val=in.nextInt();
            l.add_in_back(val);
        }
        System.out.println(l.toString());
        int option;
        int quit=1;
        int y;
        while(quit!=0)
        {
            System.out.println("1.Добавление");
            System.out.println("2.Удаление");
            System.out.println("3.Вывод");
            System.out.println("0.Выход");
            option=in.nextInt();
            if (option==1)
            {
                System.out.println("Значение добавляемого элемента");
                int data=in.nextInt();
                System.out.println("1.Добавить в начало");
                System.out.println("2.Добавить в конец");
                System.out.println("3.Добавить в произвольное место");

                y=in.nextInt();
                if(y==1) l.add_in_front(data);
                else if(y==2) l.add_in_back(data);
                else if(y==3)
                {
                    System.out.println("На какую позицию вы хотите поставить новый элемент?");
                    int pos=in.nextInt();
                    l.add(pos,data);
                }
            }
            else if (option==2)
            {
                System.out.println("Значение удаляемого элемента");
                int data=in.nextInt();
                l.delete_element_position(data);
            }
            else if (option==3)
            {
                System.out.println(l.toString());
            }
            else if (option==0) quit=0;
            else quit =0;
        }
    }
}