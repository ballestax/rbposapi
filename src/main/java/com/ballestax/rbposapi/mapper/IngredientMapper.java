package com.ballestax.rbposapi.mapper;

import com.ballestax.rbposapi.dto.IngredientDto;
import com.ballestax.rbposapi.model.Ingredient;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IngredientMapper {

    IngredientMapper INSTANCE = Mappers.getMapper(IngredientMapper.class);

    IngredientDto ingredientToIngredientDto(Ingredient ingredient);

    Ingredient ingredientDtoToIngredient(IngredientDto ingredientDto);

    List<Ingredient> ingredientDtoListToIngredientList(List<IngredientDto> ingredientDtoList);

    List<IngredientDto> ingredientListToIngredientDtoList(List<Ingredient> ingredientList);


}
