package com.phonebook.utils;

import com.phonebook.models.Contact;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.testng.annotations.DataProvider;

public class DataProviders {
  @DataProvider
  public Iterator<Object[]> addNewContact() {
    List<Object[]> list = new ArrayList<>();
    list.add(new Object[]{"Oliver", "Kan", "1234567890", "kan@gm.com", "Berlin", "goalkeeper"});
    list.add(new Object[]{"Oliver1", "Kan", "1234567890", "kan@gm.com", "Berlin", "goalkeeper"});
    list.add(new Object[]{"Oliver2", "Kan", "1234567890", "kan@gm.com", "Berlin", "goalkeeper"});

    return list.iterator();
  }
  @DataProvider
  public Iterator<Object[]> addNewContactFromCSV() throws IOException {
    List<Object[]> list = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/contact.csv"));

    String line = reader.readLine();

    while (line != null) {
      String[] split = line.split(",");

      list.add(new Object[]{
          new Contact().setName(split[0]).setLastname(split[1]).setPhone(split[2]).
              setMail(split[3]).setAddress(split[4]).setDescription(split[5])});
      line = reader.readLine();
    }

    return list.iterator();
  }
}
