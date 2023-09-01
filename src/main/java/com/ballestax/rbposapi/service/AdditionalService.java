package com.ballestax.rbposapi.service;

import com.ballestax.rbposapi.model.Additional;

import java.util.List;

public interface AdditionalService {

    Additional saveAdditional(Additional product);

    List<Additional> getAllAdditionals();

    List<Additional> getAllAdditionalsByProductId(Long productId);

    Additional getAdditionalById(long id);

    Additional updateAdditional(Additional product, long id);

    void delete(long id);

}
