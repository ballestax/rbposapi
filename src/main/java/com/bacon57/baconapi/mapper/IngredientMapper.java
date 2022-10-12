package com.bacon57.baconapi.mapper;

import com.bacon57.baconapi.dto.IngredientDto;
import com.bacon57.baconapi.model.Ingredient;
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
