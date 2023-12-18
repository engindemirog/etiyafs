package com.etiya.rentacar.business.abstracts;

import com.etiya.rentacar.business.dtos.requests.brands.CreateBrandRequest;
import com.etiya.rentacar.business.dtos.requests.brands.UpdateBrandRequest;
import com.etiya.rentacar.business.dtos.responses.brands.CreatedBrandResponse;
import com.etiya.rentacar.business.dtos.responses.brands.DeletedBrandResponse;
import com.etiya.rentacar.business.dtos.responses.brands.GetAllBrandResponse;
import com.etiya.rentacar.business.dtos.responses.brands.UpdatedBrandResponse;
import com.etiya.rentacar.entities.concretes.Brand;

import java.util.List;

public interface BrandService {
    CreatedBrandResponse add(CreateBrandRequest request);
    UpdatedBrandResponse update(UpdateBrandRequest request);
    DeletedBrandResponse delete(int id);
    List<GetAllBrandResponse> getAll();
}
