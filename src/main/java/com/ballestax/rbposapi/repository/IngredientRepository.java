package com.ballestax.rbposapi.repository;

import com.ballestax.rbposapi.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient,Long> {

    @Query(value = "SELECT i.id as id, i.name as name FROM ingredients i, product_ingredient pi WHERE pi.product_id=:productId GROUP BY i.id", nativeQuery = true)
    List<Ingredient> findIngredientByProductId(@Param("productId") Long productId);

}
