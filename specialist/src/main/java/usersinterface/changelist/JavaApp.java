package usersinterface.changelist;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class JavaApp {

    public static void main(String[] args) {
        ArrayList<Person> oldList = new ArrayList<>();

        oldList.add(new Person("Name1", 20));
        oldList.add(new Person("Name2", 30));

        ObservableList<Person> fxList = FXCollections.observableArrayList(oldList);

        fxList.addListener(new ListChangeListener<Person>() {
            @Override
            public void onChanged(Change<? extends Person> change) {
                while (change.next()) {
                    if (change.wasAdded()) {
                        for (Person person :
                                change.getAddedSubList()) {
                            oldList.add(person);
//                            oldList.add(new Person(person.name, person.age));
                        }
                    } else if (change.wasRemoved()) {
                        for (Person person :
                                change.getRemoved()) {
                            oldList.remove(person);
                        }
                    }
                }
            }
        });

        fxList.add(new Person("Name3", 33));
        fxList.remove(0);
//        fxList.get(1).age++; //not see in oldList

        for (Person person :
                oldList) {
            System.out.println(person);
        }

    }
}

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
