package plantaagua.plantaagua.region.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import plantaagua.plantaagua.exceptions.ResourceNotFoundException;
import plantaagua.plantaagua.region.entity.Region;
import plantaagua.plantaagua.region.repository.RegionRepository;

@AllArgsConstructor
@Service
public class RegionService {

    private final RegionRepository regionRepository;
    private final ModelMapper mapper;

    public Iterable <Region> findAll(){
        return regionRepository.findAll();
    }

    public Region findById(Integer id){
        return regionRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public Region create(Region region){
        Region region2 = mapper.map(region, Region.class);

        return regionRepository.save(region2);
    }

    public Region update(Integer id, Region region){
        Region regionFromDb = findById(id);
        mapper.map(region, regionFromDb);
        return regionRepository.save(regionFromDb);
    }

    public void delete(Integer id){
        Region regionFromBd = findById(id);
        regionRepository.delete(regionFromBd);
    }


}
