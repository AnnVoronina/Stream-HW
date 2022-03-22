import java.util.*;
import java.util.stream.Collectors;

public class Main {


//    Из коллеции объектов Person необходимо:
//
//    Найти количество несовершеннолетних (т.е. людей младше 18 лет).
//    Получить список фамилий призывников (т.е. мужчин от 18 и до 27 лет).
//    Получить отсортированный по фамилии список потенциально работоспособных людей с высшим образованием в выборке (т.е. людей с высшим образованием от 18 до 60 лет для женщин и до 65 лет для мужчин).

    public static void main(String[] args) {

//        List<Person> persons = new ArrayList<>();
//        persons.add(new Person("Alex", Sex.MAN, Education.HIGHER, "L", 19));
//        persons.add(new Person("Alex2", Sex.MAN, Education.HIGHER, "Ll", 17));
//        persons.add(new Person("Alex", Sex.MAN, Education.HIGHER, "M", 25));
//        persons.add(new Person("Alexa", Sex.WOMAN, Education.ELEMENTARY, "K", 29));
//        persons.add(new Person("Vanya", Sex.MAN, Education.HIGHER, "P", 70));
//        persons.add(new Person("Kira", Sex.WOMAN, Education.FURTHER, "N", 61));
//        persons.add(new Person("Artem", Sex.MAN, Education.HIGHER, "T", 61));
//        persons.add(new Person("Aleftina", Sex.WOMAN, Education.SECONDARY, "Z", 39));

        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );}
            Long countYoungerEighteen = persons.stream().filter(p -> p.getAge() < 18).count();
            System.out.println("Список фамилий призывников:");
            persons.stream().
                    filter(p -> (p.getSex().equals(Sex.MAN) && p.getAge() > 18 && p.getAge() < 27)).
                    forEach(p -> System.out.println(p.getLastNane()));
            List<Person> worker = persons.stream().filter(p -> p.getEducation().equals(Education.HIGHER) || p.getEducation().equals(Education.FURTHER)).
                    filter(p -> (p.getSex().equals(Sex.WOMAN) && p.getAge() > 18 && p.getAge() < 60) ||
                            (p.getSex().equals(Sex.MAN) && p.getAge() > 18 && p.getAge() < 65)).
                    sorted(Comparator.comparing(Person::getLastNane)).collect(Collectors.toList());
            System.out.println("количество несовершеннолетних:");
            System.out.println(countYoungerEighteen);
            System.out.println("отсортированный по фамилии список потенциально работоспособных людей с высшим образованием в выборке");
            System.out.println(worker);
        }
    }
