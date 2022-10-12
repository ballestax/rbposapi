package com.bacon57.baconapi.service.impl;

import com.bacon57.baconapi.model.Additional;
import com.bacon57.baconapi.repository.AdditionalRepository;
import com.bacon57.baconapi.service.AdditionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdditionalServiceImpl implements AdditionalService {

    @Autowired
    private AdditionalRepository additionalRepository;

    @Override
    public Additional saveAdditional(Additional product) {
        return null;
    }

    @Override
    public List<Additional> getAllAdditionals() {
        return null;
    }

    @Override
    public List<Additional> getAllAdditionalsByProductId(Long productId) {
        return additionalRepository.findAdditionalsByProductId(productId);
    }

    @Override
    public Additional getAdditionalById(long id) {
        return null;
    }

    @Override
    public Additional updateAdditional(Additional product, long id) {
        return null;
    }

    @Override
    public void delete(long id) {

    }
}
