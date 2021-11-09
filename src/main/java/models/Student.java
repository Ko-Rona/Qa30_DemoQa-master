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
    String dateOfBDay;
    String subject;
    boolean sportsHobie;
    boolean readingHobie;
    boolean musicHobie;
    String hobie;
    String picture;
    String currentAddress;
    State state;
    City city;

    public enum Gender {
        MALE,
        FEMALE,
        OTHER;
    }

    public enum State {
        NCR,
        UttarPradesh,
        Haryana,
        Rajasthan;
    }

    public enum City {
        Delhi,
        Gurgaon,
        Noida,
        Agra,
        Lucknow,
        Merrut,
        Karnal,
        Panipat,
        Jaipur,
        Jaiselmer;
    }
}


