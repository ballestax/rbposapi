package com.ballestax.rbposapi.repository;

import com.ballestax.rbposapi.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient,Long> {

    @Query(value = "SELECT A.id, A.name FROM product_ingredient B, ingredients A WHERE B.product_id=:productId AND A.id=B.ingredient_id", nativeQuery = true)
    List<Ingredient> findIngredientByProductId(@Param("productId") Long productId);

}
