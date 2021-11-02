import java.io.*;
import java.util.Scanner;
import java.util.NoSuchElementException;
/**
 * Here start point of the program
 */
class Main {
    public static void main(String[] args) throws Exception {
        List l = new List();
        int option;
        int quit=1;
        int y;
        while(quit!=0)
        {
            System.out.println("____________________________");
            System.out.println("1.Добавление");
            System.out.println("2.Удаление");
            System.out.println("3.Вывод");
            System.out.println("4.Размерность списка");
            System.out.println("0.Выход");
            System.out.println("____________________________");
            Scanner in=new Scanner(System.in);
            option=in.nextInt();
            if (option==1)
            {
                System.out.println("Значение добавляемого элемента");
                int data=in.nextInt();
                System.out.println("1.Добавить в начало");
                System.out.println("2.Добавить в конец");
                System.out.println("3.Добавить в произвольное место");
                y=in.nextInt();
                while(y<1||y>3)
                {
                    System.out.println("Некорректный ввод. Введите число от 1 до 3.");
                    y=in.nextInt();
                }


                if(y==1) l.add_in_front(data);
                else if(y==2) l.add_in_back(data);
                else if(y==3)
                {
                    System.out.println("На какую позицию вы хотите поставить новый элемент?");
                    int pos=in.nextInt();
                    l.add_in_position(pos,data);
                }
            }
            else if (option==2)
            {
                System.out.println("Позиция удаляемого элемента");
                int pos=in.nextInt();
                l.delete_in_position(pos);
            }
            else if (option==3)
            {
                System.out.println(l.toString());
            }
            else if (option==4)
            {
                int a=l.getSize();
                System.out.print("Размерность:");
                System.out.println(a);
            }
            else if (option==0) quit=0;
            else System.out.println("Некорректный ввод. Введите число от 0 до 4.");
        }
    }
}