package ih.ifbs.presentation.dto;

import ih.ifbs.domain.Gender;
import org.hibernate.validator.constraints.Range;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class PassengerDTO {

    @NotBlank(message="Name field cannot be left empty!")
    @Size(min=2, max=50, message="Name should consist of minimum of 2 characters or maximum 50 charters")
    private String name;
    @Range(min=0, max=120, message="Invalid age. Please make sure age is between 0 and 120.")
    private int age;
    private Gender gender;
    @NotEmpty
    private String isTransitPassenger;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getIsTransitPassenger() {
        return isTransitPassenger;
    }

    public void setIsTransitPassenger(String isTransitPassenger) {
        this.isTransitPassenger = isTransitPassenger;
    }
}
