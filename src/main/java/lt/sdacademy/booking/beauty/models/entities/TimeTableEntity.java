package lt.sdacademy.booking.beauty.models.entities;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "timetable")
public class TimeTableEntity extends AbstractEntity {

    @Column(name = "booked_time")
    private LocalDateTime bookedTime;

}
