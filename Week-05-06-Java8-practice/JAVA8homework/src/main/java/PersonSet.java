import entity.Address;
import entity.Email;
import entity.MasterNumber;
import entity.Person;
import entity.Telephone;
import jdk.nashorn.internal.ir.CallNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonSet {
  private List<MasterNumber> masterNumbers;

  private List<Address> addresses;

  private List<Telephone> telephones;

  private List<Email> emails;

  public PersonSet(List<MasterNumber> masterNumbers,
                   List<Telephone> telephones,
                   List<Address> addresses,
                   List<Email> emails) {
    this.masterNumbers = masterNumbers;
    this.addresses = addresses;
    this.telephones = telephones;
    this.emails = emails;
  }

  public Stream<Person> groupToPeople() {
    // TODO: group the data to Stream<Person>
    // Can use Collectors.groupingBy method
    // Can add helper method
    Map<String, List<Address>> addressMap = addresses.stream().collect(Collectors.groupingBy(Address::getMasterNumber));
    Map<String, List<Telephone>> telephoneMap = telephones.stream().collect(Collectors.groupingBy(Telephone::getMasterNumber));
    Map<String, List<Email>> emailMap = emails.stream().collect(Collectors.groupingBy(Email::getMasterNumber));

    return masterNumbers.stream().map(masterNumber -> {
      String id = masterNumber.getNumber();
      List<Telephone> matchedTelephone = Optional.ofNullable(telephoneMap.get(id)).orElse(new ArrayList<>());
      List<Email> matchedEmail = Optional.ofNullable(emailMap.get(id)).orElse(new ArrayList<>());
      Address matchedAddress = Optional.ofNullable(addressMap.get(id)).map(address -> address.get(0)).orElse(null);
      return new Person(id, matchedTelephone, matchedAddress, matchedEmail);
    });
  }

  public List<Address> getAddresses() {
    return addresses;
  }

  public List<Telephone> getTelephones() {
    return telephones;
  }

  public List<Email> getEmails() {
    return emails;
  }

  public void setMasterNumbers(List<MasterNumber> masterNumbers) {
    this.masterNumbers = masterNumbers;
  }

  public void setAddresses(List<Address> addresses) {
    this.addresses = addresses;
  }

  public void setEmails(List<Email> emails) {
    this.emails = emails;
  }

  public void setTelephones(List<Telephone> telephones) {
    this.telephones = telephones;
  }
}
