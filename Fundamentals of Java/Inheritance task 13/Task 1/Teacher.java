//Задачи на наследование:

/*1. Создать класс Person со свойствами name и iin, геттерами и сеттарами, конструктором и методом toString. Cоздать классы наследники: Student со свойством gpa Teacher со свойством subject В обоих классах переопределить метод toString и вернуть строкой все свойства (в Student свойства студента, в Teacher - учителя)
В функции main создать ArrayList объектов класса Person. Реализовать бесконечное меню с пунктами:
1)Добавить студента
2)Добавить учителя
3)Найти человека - (поиск делать по имени и ИИНу)
4)Вывести последние 10 человек
При выводе любого человека использовать метод toString()
*/

public class Teacher extends Person {
    private String subject;

    public Teacher(String name, int iin, String subject) {
        super(name, iin);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String toString() {
        return "Name: " + getName() + "; " + "Iin: " + getIin() +
                "; " + "Subject: " + subject;
    }
}
