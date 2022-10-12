package com.bacon57.baconapi.service;

import com.bacon57.baconapi.model.Additional;

import java.util.List;

public interface AdditionalService {

    Additional saveAdditional(Additional product);

    List<Additional> getAllAdditionals();

    List<Additional> getAllAdditionalsByProductId(Long productId);

    Additional getAdditionalById(long id);

    Additional updateAdditional(Additional product, long id);

    void delete(long id);

}
