package com.bacon57.baconapi.repository;

import com.bacon57.baconapi.model.Additional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdditionalRepository extends JpaRepository<Additional, Long> {

    @Query(value = "SELECT i.id as id, i.name as name FROM additionals i, product_additional pi WHERE pi.product_id=:productId GROUP BY i.id", nativeQuery = true)
    List<Additional> findAdditionalsByProductId(@Param("productId") Long productId);

}
