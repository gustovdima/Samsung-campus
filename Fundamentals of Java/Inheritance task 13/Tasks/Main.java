//Задачи на наследование:

/*1. Создать класс Person со свойствами name и iin, геттерами и сеттарами, конструктором и методом toString. Cоздать классы наследники: Student со свойством gpa Teacher со свойством subject В обоих классах переопределить метод toString и вернуть строкой все свойства (в Student свойства студента, в Teacher - учителя)

В функции main создать ArrayList объектов класса Person. Реализовать бесконечное меню с пунктами:

1)Добавить студента
2)Добавить учителя
3)Найти человека - (поиск делать по имени и ИИНу)
4)Вывести последние 10 человек
При выводе любого человека использовать метод toString()
*/

import java.lang.reflect.Executable;import java.util.ArrayList;import java.util.Scanner;

public class Main {
    public static final int STUDENT = 1;
    public static final int TEACHER = 2;
    public static final int GET_PERSON = 3;
    public static final int LIST_10_PERSON = 4;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Person> people = new ArrayList<>();


        while (true) {
            int num = 0;
            try {
                System.out.println("1.addStudent: 2.addTecher: 3.getPerson: 4.list10Person: ");
                num = Integer.parseInt(scan.next());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            if (num == STUDENT) {
                try {
                    System.out.println("Enter name: ");
                    String name = scan.next();
                    System.out.println("Enter iin: ");
                    int iin = Integer.parseInt(scan.next());
                    System.out.println("Enter gpa: ");
                    double gpa = scan.nextDouble();

                    Student student = new Student(name, iin, gpa);
                    people.add(student);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (num == TEACHER) {
                try {
                    System.out.println("Enter name: ");
                    String name = scan.next();
                    System.out.println("Enter iin: ");
                    int iin = Integer.parseInt(scan.next());
                    System.out.println("Enter subject: ");
                    String subject = scan.next();

                    Teacher teacher = new Teacher(name, iin, subject);
                    people.add(teacher);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (num == GET_PERSON) {
                try {
                    System.out.println("Enter name: ");
                    String name = scan.next();
                    System.out.println("Enter iin: ");
                    int iin = Integer.parseInt(scan.next());

                    boolean found = false;
                    for (Person p : people) {
                        if (p.getName().contains(name) && p.getIin() == iin) {
                            found = true;
                            System.out.println(p.toString());
                        }
                    }
                    if (!found) {
                        System.out.println("not found!");
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (num == LIST_10_PERSON) {
                int count = 10;
                if (people.size() < 10) {
                    count = people.size();
                } else if (people.size() > 10) {
                    people.remove(0);
                }
                for (int i = count; i > 0; i--) {
                    System.out.println(people.get(i - 1).toString());
                }
            } else if (num > 4) {
                System.out.println("В меню всего 4 пункта!");
            }
        }
    }

