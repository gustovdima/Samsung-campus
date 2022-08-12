//Задачи на наследование

/*
Создать класс MyRandom, наследующий класс Random. 
В классе MyRandom реализовать метод int nextInt(int from, int to),
который будет генерировать случайное число в пределах от from до to.
В это методе не создавать объект класса Random, а использовать super
*/


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        MyRandom random = new MyRandom();
        while (true) {
            System.out.println("Enter num1: ");
            int num1 = scan.nextInt();
            System.out.println("Enter num2: ");
            int num2 = scan.nextInt();
            System.out.println(random.nextInt(num1, num2));
        }

    }
}
