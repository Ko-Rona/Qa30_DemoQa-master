package models;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@ToString

public class StudentEnum {

    String firstName;
    String lastName;
    String email;
    models.Student.Gender gender;
    String mobile;
    Date dateOfBirth;
    String dateOfBDay;
    String subject;
    List<Hobby> hobbies;
    String picture;
    String currentAddress;
    models.Student.State state;
    models.Student.City city;
}
