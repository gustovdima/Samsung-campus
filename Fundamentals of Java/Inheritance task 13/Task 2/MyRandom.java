//Задачи на наследование

/*
Создать класс MyRandom, наследующий класс Random. 
В классе MyRandom реализовать метод int nextInt(int from, int to),
который будет генерировать случайное число в пределах от from до to.
В это методе не создавать объект класса Random, а использовать super
*/

import java.util.Random;

public class MyRandom extends Random {
    private int from;
    private int to;

    public int nextInt(int from, int to) {
        int random = from + (int) (Math.random() * to);
        return random;
    }


    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }
}
