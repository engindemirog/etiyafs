package com.etiya.rentacar.business.concretes;

import com.etiya.rentacar.business.abstracts.BrandService;
import com.etiya.rentacar.business.dtos.requests.brands.CreateBrandRequest;
import com.etiya.rentacar.business.dtos.requests.brands.UpdateBrandRequest;
import com.etiya.rentacar.business.dtos.responses.brands.CreatedBrandResponse;
import com.etiya.rentacar.business.dtos.responses.brands.DeletedBrandResponse;
import com.etiya.rentacar.business.dtos.responses.brands.GetAllBrandResponse;
import com.etiya.rentacar.business.dtos.responses.brands.UpdatedBrandResponse;
import com.etiya.rentacar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentacar.dataaccess.abstracts.BrandRepository;
import com.etiya.rentacar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class BrandManager implements BrandService {
    BrandRepository brandRepository;
    ModelMapperService modelMapperService;
    @Override
    public CreatedBrandResponse add(CreateBrandRequest request) {

        //business rules

        Brand brand = modelMapperService.forRequest().map(request,Brand.class);

        Brand createdBrand =  brandRepository.save(brand);

        CreatedBrandResponse createdBrandResponse =
                modelMapperService.forResponse().map(createdBrand,CreatedBrandResponse.class);

        return createdBrandResponse;
    }

    @Override
    public UpdatedBrandResponse update(UpdateBrandRequest request) {
        Brand brand = modelMapperService.forRequest().map(request,Brand.class);

        Brand updatedBrand =  brandRepository.save(brand);

        UpdatedBrandResponse updatedBrandResponse =
                modelMapperService.forResponse().map(updatedBrand,UpdatedBrandResponse.class);

        return updatedBrandResponse;
    }

    @Override
    public DeletedBrandResponse delete(int id) {
        Brand brandToDelete = new Brand();
        brandToDelete.setId(id);

        brandRepository.delete(brandToDelete);

        DeletedBrandResponse response = new DeletedBrandResponse();
        response.setId(id);

        return response;
    }

    @Override
    public List<GetAllBrandResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();

        List<GetAllBrandResponse> result = brands.stream()
                .map(brand -> this.modelMapperService.forResponse()
                        .map(brand,GetAllBrandResponse.class)).collect(Collectors.toList());

        return result;
    }
}
