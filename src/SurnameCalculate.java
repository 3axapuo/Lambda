import java.util.Comparator;

public class SurnameCalculate implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        int lengthSurnameWordsPerson_1 = o1.getSurname().split(" ").length;
        int lengthSurnameWordsPerson_2 = o2.getSurname().split(" ").length;
        int lengthDifferenceOfWords = lengthSurnameWordsPerson_1 - lengthSurnameWordsPerson_2;

        if (lengthDifferenceOfWords == 0) {
            if (o1.getAge() > o2.getAge()) lengthDifferenceOfWords = 1;
            if (o1.getAge() < o2.getAge()) lengthDifferenceOfWords = -1;
        }
        return lengthDifferenceOfWords;
    }
}