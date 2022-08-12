//Задачи на наследование:

/*1. Создать класс Person со свойствами name и iin, геттерами и сеттарами, конструктором и методом toString. Cоздать классы наследники: Student со свойством gpa Teacher со свойством subject В обоих классах переопределить метод toString и вернуть строкой все свойства (в Student свойства студента, в Teacher - учителя)
В функции main создать ArrayList объектов класса Person. Реализовать бесконечное меню с пунктами:
1)Добавить студента
2)Добавить учителя
3)Найти человека - (поиск делать по имени и ИИНу)
4)Вывести последние 10 человек
При выводе любого человека использовать метод toString()
*/


public class Person {
    private String name;
    private int iin;

    public Person(String name, int iin) {
        this.name = name;
        this.iin = iin;
    }

    public String toString() {
        return "Name: " + name + "" + "Iin: " +
                iin + " ";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIin() {
        return iin;
    }

    public void setIin(int iin) {
        this.iin = iin;
    }
}
