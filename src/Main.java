import java.io.*;
import java.util.Scanner;
import java.util.NoSuchElementException;
/**
 * Here start point of the program
 */
class Main {
    public static void main(String[] args) throws Exception {
        List l = new List();
        System.out.println("Введите количество элементов");
        Scanner in=new Scanner(System.in);
        while(!in.hasNextInt()) {
            System.out.println("Ошибка. Неверный ввод. Введите число.");
            in.next();
        }
        int n=in.nextInt();
        for (int i=0;i<n;i++)
        {
            System.out.println((i+1)+")");
            int val=in.nextInt();
            l.add_in_back(val);
        }
        System.out.print("Cписок: ");
        System.out.println(l.toString());
        int option;
        int quit=1;
        int y;
        System.out.println("Выберите действие.");
        while(quit!=0)
        {
            System.out.println("____________________________");
            System.out.println("1.Добавить элемент");
            System.out.println("2.Удалить элемент");
            System.out.println("3.Вывод");
            System.out.println("4.Размерность");
            System.out.println("0.Выход");
            System.out.println("____________________________");
            while(!in.hasNextInt()) {
                System.out.println("Ошибка. Неверный ввод. Введите число от 0 до 4.");
                in.next();

            }
            option=in.nextInt();
            if (option==1)
            {
                System.out.println("Значение добавляемого элемента");
                while(!in.hasNextInt()) {
                    System.out.println("Ошибка. Неверный ввод. Введите число.");
                    in.next();
                }
                int data_new_element=in.nextInt();
                System.out.println("1.Добавить в начало");
                System.out.println("2.Добавить в конец");
                System.out.println("3.Добавить в произвольное место");
                while(!in.hasNextInt()) {
                    System.out.println("Ошибка. Неверный ввод. Введите число от 1 до 3.");
                    in.next();
                }
                y=in.nextInt();
                while(y!=1&&y!=2&&y!=3)
                {
                    System.out.println("Ошибка. Неверный ввод. Введите число от 1 до 3.");
                    y=in.nextInt();
                }
                if(y==1) l.add_in_front(data_new_element);
                else if(y==2) l.add_in_back(data_new_element);
                else if(y==3)
                {
                    System.out.println("На какую позицию вы хотите поставить новый элемент?");
                    while(!in.hasNextInt()) {
                        System.out.println("Ошибка. Неверный ввод. Введите число");
                        in.next();
                    }
                    int pos=in.nextInt();
                    while(pos<0||pos> l.getSize())
                    {
                        System.out.println("Ошибка. Выход за границы списка. Повторите ввод.");
                        pos=in.nextInt();
                    }
                    l.add_in_position(pos,data_new_element);
                }
            }
            else if (option==2)
            {
                System.out.println("Позиция удаляемого элемента");
                while(!in.hasNextInt()) {
                    System.out.println("Ошибка. Неверный ввод. Введите число.");
                    in.next();
                }
                int pos=in.nextInt();
                while(pos>l.getSize()-1||pos<0)
                {
                    System.out.println("Ошибка. Выход за границы списка. Повторите ввод.");
                    pos=in.nextInt();
                }
                l.delete_in_position(pos);
            }
            else if (option==3)
            {
                System.out.print("Список: ");
                System.out.println(l.toString());
            }
            else if (option==4)
            {
                int a=l.getSize();
                System.out.print("Размерность:");
                System.out.println(a);
            }
            else if (option==0) quit=0;
            else System.out.println("Ошибка. Неверный ввод. Введите число от 0 до 4.");
        }
    }
}