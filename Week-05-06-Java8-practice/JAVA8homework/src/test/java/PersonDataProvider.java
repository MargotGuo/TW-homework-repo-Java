import entity.Address;
import entity.Email;
import entity.Person;
import entity.Telephone;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PersonDataProvider {

  public static Person providePersonWithNumber1() {

    Address address =
        new Address("1", "China", "Beijing", "Any Street");

    List<Telephone> telephones =
        new ArrayList<>(Arrays.asList(
            new Telephone("1", "+1", "123"),
            new Telephone("1", "+1", "456")));

    List<Email> emails =
        new ArrayList<>(Arrays.asList(
            new Email("1", "2343@gmail.com"),
            new Email("1", "2344@gmail.com")));

    return new Person("1", telephones, address, emails);
  }


  public static Person providePersonWithNumber2() {

    Address address =
        new Address("2", "China", "Beijing", "Any Street");

    List<Telephone> telephones =
        Arrays.asList(
            new Telephone("2", "+1", "123"),
            new Telephone("2", "+1", "456"));

    List<Email> emails =
        Arrays.asList(
            new Email("2", "2343@gmail.com"),
            new Email("2", "2344@gmail.com")
        );

    return new Person("2", telephones, address, emails);
  }
}
