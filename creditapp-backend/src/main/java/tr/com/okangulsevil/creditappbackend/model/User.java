package tr.com.okangulsevil.creditappbackend.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "identity_number")
    private String identityNumber;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "salary")
    private Double salary;

    @OneToMany(mappedBy = "user")
    private List<Credit> credits = new ArrayList<>();


    public User(String firstName, String lastName, String identityNumber, String phoneNumber, Double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.identityNumber = identityNumber;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
    }
}
