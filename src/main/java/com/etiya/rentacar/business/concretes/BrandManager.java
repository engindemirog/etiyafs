package com.etiya.rentacar.business.concretes;

import com.etiya.rentacar.business.abstracts.BrandService;
import com.etiya.rentacar.business.dtos.requests.brands.CreateBrandRequest;
import com.etiya.rentacar.business.dtos.responses.brands.CreatedBrandResponse;
import com.etiya.rentacar.dataaccess.abstracts.BrandRepository;
import com.etiya.rentacar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BrandManager implements BrandService {
    BrandRepository brandRepository;
    @Override
    public CreatedBrandResponse add(CreateBrandRequest request) {

        //business rules
        Brand brand = new Brand();
        brand.setName(request.getName());

        Brand createdBrand =  brandRepository.save(brand);

        CreatedBrandResponse createdBrandResponse = new CreatedBrandResponse();
        createdBrandResponse.setId(createdBrand.getId());
        createdBrandResponse.setName(createdBrand.getName());

        return createdBrandResponse;
    }
}
