package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@Builder
@ToString

public class Student {
    String firstName;
    String lastName;
    String email;
    Gender gender;
    String mobile;
    Date dateOfBirth;
    String[] subjects;
    boolean sportsHobie;
    boolean readingHobie;
    boolean musicHobie;
    String picture;
    String currentAddress;
    String state;
    String city;

    public enum Gender {
        MALE,
        FEMALE,
        OTHER;
    }
}


