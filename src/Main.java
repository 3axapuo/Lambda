import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final int maxSurnameWords = 7; // максимальное число слов в фамилии
        List<Person> clients = generateClients();

        //ЗАДАЧА №1, Удалите класс компаратора и в методе main замените объект этого удалённого класса
        //на лямбду с той же логикой. Т.е. по сути мы дадим имплементацию компаратору на лету с помощью лямбды.
        //Если вы делали вторую задачу, то параметра не будет (их у лямбд не бывает) - вместо этого просто
        //используйте напрямую в коде лямбды то значение, которое раньше передавали в конструктор компаратора.
        clients.sort((o1, o2) -> {
            int lengthSurnameWordsPerson_1 = o1.getSurname().split(" ").length;
            int lengthSurnameWordsPerson_2 = o2.getSurname().split(" ").length;
            int lengthDifferenceOfWords = lengthSurnameWordsPerson_1 - lengthSurnameWordsPerson_2;

            if ((lengthSurnameWordsPerson_1 >= maxSurnameWords &&
                    lengthSurnameWordsPerson_2 >= maxSurnameWords)
                    || lengthDifferenceOfWords == 0) {
                if (o1.getAge() > o2.getAge()) lengthDifferenceOfWords = 1;
                if (o1.getAge() < o2.getAge()) lengthDifferenceOfWords = -1;
            }
            return lengthDifferenceOfWords;
        });
        System.out.println(clients);
    }
    public static List<Person> generateClients() {
        List<Person> clients = new ArrayList<>();
        clients.add(new Person("Билл", "Гейтс", 5));
        clients.add(new Person("Макс", "Стародубский Ромодановский Пивоваренный Сыроед", 20));
        clients.add(new Person("Джефф", "Безос", 10));
        clients.add(new Person("Джастин", "Таннер Петерсен", 30));
        clients.add(new Person("Петр", "Михайловский Данилевский", 25));
        clients.add(new Person("!Роберт", "Тэппан Моррис", 15));
        clients.add(new Person("!Геральд", "Муррэй Моррис", 40));
        clients.add(new Person("Пикассо", "Пабло Диего Хозе Франциско де Паула Хуан", 35));
        return clients;
    }
}