package lt.sdacademy.booking.beauty.converters;

import org.springframework.stereotype.Component;

import java.util.List;

import lt.sdacademy.booking.beauty.models.dto.ServiceDTO;
import lt.sdacademy.booking.beauty.models.entities.ServiceEntity;

import static java.util.stream.Collectors.toList;

@Component
public class ServiceConverter {

    public List<ServiceDTO> serviceListConvert(List<ServiceEntity> serviceEntityList) {
    return serviceEntityList.stream().map(this::serviceConvert)
                .collect(toList());
    }

    public ServiceDTO serviceConvert(ServiceEntity serviceEntity){
        ServiceDTO serviceDTO = new ServiceDTO(serviceEntity.getTitle(), serviceEntity.getPrice());
        return serviceDTO;
    }

}
