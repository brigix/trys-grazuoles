package lt.sdacademy.booking.beauty.models.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ServiceDTO {
    private String serviceTitle;
    private BigDecimal price;
}
