package lt.sdacademy.booking.beauty.services;

import org.springframework.stereotype.Service;

import java.util.List;

import lt.sdacademy.booking.beauty.converters.ServiceConverter;
import lt.sdacademy.booking.beauty.models.dto.ServiceDTO;
import lt.sdacademy.booking.beauty.models.entities.ServiceEntity;
import lt.sdacademy.booking.beauty.repositories.ServiceRepository;

@Service
public class BookingService {
    private final ServiceRepository serviceRepository;
    private final ServiceConverter serviceConverter;

    public BookingService(ServiceRepository serviceRepository, ServiceConverter serviceConverter) {
        this.serviceRepository = serviceRepository;
        this.serviceConverter = serviceConverter;
    }

    public List<ServiceDTO> getAll(){
        List<ServiceEntity> serviceEntityList = serviceRepository.findAll();
        List<ServiceDTO> serviceDTOList = serviceConverter.serviceListConvert(serviceEntityList);
        return serviceDTOList;
    }

    public ServiceDTO getOneById(Integer id){
        ServiceEntity serviceEntity = serviceRepository.findOneById(id);
        ServiceDTO serviceDTO = serviceConverter.serviceConvert(serviceEntity);
        return serviceDTO;
    }
}
