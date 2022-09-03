import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        final int maxSurnameWords = 7; // максимальное число слов в фамилии
        List<Person> clients = generateClients();
        //ЗАДАЧА №2, Нашей целью будет удалить в списке людей в main тех людей, которые младше 18 лет
        //(если сейчас в демонстрации нет таких людей - добавьте, чтобы их было как минимум 2).
        //Но мы не будем для этого сами проходиться по списку, мы воспользуемся его готовым методом
        //removeIf. Вызовите его у списка и передайте туда предикат (Predicate<Person>), метод
        // которого отвечал бы true тогда и только тогда, когда человеку из его параметра меньше
        // 18 лет. Таким образом список сам пройдётся по своим элементам и оттестирует каждый вашим
        // предикатом, на ком покажет true - тот и будет удалён.
        clients.removeIf(o1 -> o1.getAge() < 18);
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
// А зачем выносить в отдельный метод? Суть лямбд в том чтобы прямо в месте использования и писать реализацию,
// без необходимости писать логику в других местах
/*    public static Predicate<Person> isLessThan18Age() {
        return o1 -> o1.getAge() < 18;
    }*/
}