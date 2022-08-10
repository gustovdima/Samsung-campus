/*Создать свой класса с несколькими свойствами(переменными).
Свойства сделать private, для них сделать методы get и set.
Так же сделать несколько public методов.
Создать объект этого класса в main с применить все существующие методы
*/

public class Car {
    private String model = "mercedes";
    private String color = "grey";
    private double Fuel = 50.0;
    private int speed = 0;
    private int maxSpeed = 230;

    public void info() {
        System.out.println("model: " + model);
        System.out.println("color: " + color);
        System.out.println("maxSpeed: " + maxSpeed + " км/ч");
        System.out.println("Fuel: " + Fuel + " л");
    }

    public void gas() {
        while (Fuel != 0 && speed != maxSpeed) {
            System.out.println("SPEED: ");
            System.out.println(speed += 30);

            System.out.println("FUEL: ");
            System.out.println(Fuel -= 10.0);
        }
        if (speed == maxSpeed) {
            System.out.println("Максимальная скорость достигнута.");
            System.out.println("Остатое топлива " + Fuel + " л");
        }
        if (Fuel == 0.0) {
            speed = 0;
            System.out.println("Топливо закончилось!");
            System.out.println("speed: " + speed);
        }
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getFuel() {
        return Fuel;
    }

    public void setFuel(double Fuel) {
        this.Fuel = Fuel;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }


    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
