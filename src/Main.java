import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Person> clients = generateClients();
        Collections.sort(clients, new SurnameCalculate().reversed());
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