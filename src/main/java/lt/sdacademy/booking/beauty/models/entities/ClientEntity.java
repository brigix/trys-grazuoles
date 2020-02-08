package lt.sdacademy.booking.beauty.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "client")

public class ClientEntity extends AbstractEntity {

    @Column(name = "telephone_no", nullable = false)
    private Integer telephone_no;

    @OneToOne
    @JoinColumn(name = "person_id", nullable = false)
    private PersonEntity personEntity;

}
