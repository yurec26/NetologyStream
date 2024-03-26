import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4).stream()
                .filter(x->x>0).filter(x->x%2==0).sorted(Comparator.naturalOrder()).toList();
        System.out.println(intList);

        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        List<Person> youth = persons.stream().filter(x->x.getAge()>=18).toList();
        List<Person> war = persons.stream().filter(x->x.getAge()>=18 && x.getAge()<=27).toList();
        List<Person> workMan = persons.stream().filter(x->x.getSex().equals(Sex.MAN))
                .filter(x->x.getAge()>=18 && x.getAge()<=65).filter(x->x.getEducation().equals(Education.HIGHER))
                .sorted(Comparator.comparing(Person::getFamily)).collect(Collectors.toList());

        System.out.println(workMan);




    }
}