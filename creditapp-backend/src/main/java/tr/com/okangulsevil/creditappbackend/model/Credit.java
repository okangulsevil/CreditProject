package tr.com.okangulsevil.creditappbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import tr.com.okangulsevil.creditappbackend.model.enums.CreditStatus;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "credits")
public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "credit_rating")
    private Integer creditRating;

    @Column(name = "credit_limit")
    private Double creditLimit;

    @Column(name = "credit_status")
    private CreditStatus creditStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    public Credit(Integer creditRating, CreditStatus creditStatus, User user) {
        this.creditRating = creditRating;
        this.creditStatus = creditStatus;
        this.user = user;
    }

    public Credit(Integer creditRating, Double creditLimit, CreditStatus creditStatus, User user) {
        this.creditRating = creditRating;
        this.creditLimit = creditLimit;
        this.creditStatus = creditStatus;
        this.user = user;
    }
}
