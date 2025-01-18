package plantaagua.plantaagua.city.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import plantaagua.plantaagua.city.entity.City;
import plantaagua.plantaagua.city.repository.CityRepository;
import plantaagua.plantaagua.exceptions.ResourceNotFoundException;

@AllArgsConstructor
@Service
public class CityService {

    private final CityRepository cityRepository;
    private final ModelMapper mapper;

    public Iterable<City> findAll(){
        return cityRepository.findAll();
    }

    public City findById(Integer id){
        return cityRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public City create(City city){
        City city2 = mapper.map(city, City.class);
        return cityRepository.save(city2);
    }

    public City update(Integer id, City city){
        City cityFromDb = findById(id);
        mapper.map(city, cityFromDb);
        return cityRepository.save(cityFromDb);
    }

    public void delete(Integer id){
        City cityFromDb = findById(id);
        cityRepository.delete(cityFromDb);
    }

}
