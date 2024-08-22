package lk.ijse.gdse.Emded;

import jakarta.persistence.Embeddable;

@Embeddable
public class FullName {
    private String firstName;
    private String lastName;

    public FullName() {
    }

    public FullName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
