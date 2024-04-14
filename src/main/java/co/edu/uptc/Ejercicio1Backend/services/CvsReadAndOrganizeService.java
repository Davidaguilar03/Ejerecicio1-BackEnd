package co.edu.uptc.Ejercicio1Backend.services;

import co.edu.uptc.Ejercicio1Backend.models.*;
import lombok.Getter;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;


@Getter
public class CvsReadAndOrganizeService {

  private PropiertiesService p = new PropiertiesService();
  private FileService f = new FileService(p.getValue("ListCvsPath"));
  private List<Person> persons = new ArrayList<>();

  public void readCvs() {
    f.open('r');
    List<String> peopleData = f.read();
    for (int i = 1; i < peopleData.size(); i++) {
      String[] data = peopleData.get(i).split(p.getValue("dataSeparator"));
      String index = data[0];
      String userId = data[1];
      String firstName = data[2];
      String lastName = data[3];
      String sex = data[4];
      String email = data[5];
      String phone = data[6];
      LocalDate dateOfBirth = stringToLocalDate(data[7]);
      String jobTitle = data[8];
      int age = generateAge(dateOfBirth);
      Person auxPerson = new Person(
        index,
        userId,
        firstName,
        lastName,
        sex,
        email,
        phone,
        dateOfBirth,
        jobTitle,
        age
      );
      persons.add(auxPerson);
    }
    f.close();
  }

  private LocalDate stringToLocalDate(String stringDate) {
    String[] dateData = stringDate.split(p.getValue("dateSeparator"));
    int year = Integer.parseInt(dateData[0]);
    int month = Integer.parseInt(dateData[1]);
    int dayOfMonth = Integer.parseInt(dateData[2]);
    LocalDate dateOfBirth = LocalDate.of(year, month, dayOfMonth);
    return dateOfBirth;
  }

  private int generateAge(LocalDate dateOfBirth) {
    LocalDate actualDate = LocalDate.now();
    Period period = Period.between(dateOfBirth, actualDate);
    int age = period.getYears();
    return age;
  }

  public List<Person> generateListAdolesncence() {
    List<Person> adolesncence = new ArrayList<>();
    for (Person person : persons) {
      if (person.getAge() > 12 && person.getAge() < 18) {
       adolesncence.add(person);
      }
    }
    return adolesncence;
  }

  public List<Person> generateListAdulthood() {
    List<Person> adulthood = new ArrayList<>();
    for (Person person : persons) {
      if (person.getAge() > 27 && person.getAge() < 59) {
       adulthood.add(person);
      }
    }
    return adulthood;
  }

  public List<Person> generateListChildhood() {
    List<Person> childhood = new ArrayList<>();
    for (Person person : persons) {
      if (person.getAge() > 6 && person.getAge() < 11) {
       childhood.add(person);
      }
    }
    return childhood;
  }

  public List<Person> generateListEarlyChildhood() {
    List<Person> earlyChildhood = new ArrayList<>();
    for (Person person : persons) {
      if (person.getAge() > 0 && person.getAge() < 5) {
       earlyChildhood.add(person);
      }
    }
    return earlyChildhood;
  }

  public List<Person> generateListOldAge() {
    List<Person> oldAge = new ArrayList<>();
    for (Person person : persons) {
      if (person.getAge() > 60) {
       oldAge.add(person);
      }
    }
    return oldAge;
  }

  public List<Person> generateListYouth() {
    List<Person> youth = new ArrayList<>();
    for (Person person : persons) {
      if (person.getAge() > 14 && person.getAge() < 26) {
       youth.add(person);
      }
    }
    return youth;
  }

}
