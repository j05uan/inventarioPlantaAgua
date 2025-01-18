package plantaagua.plantaagua.coutry.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import plantaagua.plantaagua.coutry.entity.Country;
import plantaagua.plantaagua.coutry.repository.CountryRepository;
import plantaagua.plantaagua.exceptions.ResourceNotFoundException;

@AllArgsConstructor
@Service
public class CountryService {

    private final CountryRepository countryRepository;
    private final ModelMapper mapper;

    public Iterable<Country> findAll(){
        return countryRepository.findAll();
    }

    public Country findById(Integer id){
        return countryRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public Country create(Country country){
        Country country2 = mapper.map(country, Country.class);
        return countryRepository.save(country2);
    }

    public Country update(Integer id, Country country){
        Country coutryFromDb = findById(id);
        mapper.map(country,coutryFromDb );
        return countryRepository.save(coutryFromDb);
    }

    public void delete(Integer id){
        Country countryFromDb = findById(id);
        countryRepository.delete(countryFromDb);
    }


}
