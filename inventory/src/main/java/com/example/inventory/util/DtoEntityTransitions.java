package com.example.inventory.util;

import com.example.inventory.business.dto.CategoryDto;
import com.example.inventory.business.dto.ProductDto;
import com.example.inventory.data.entity.Category;
import com.example.inventory.data.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DtoEntityTransitions {
    public static List<ProductDto> productListToDto(List<Product> products){
        return products.stream().map(ProductDto::new).collect(Collectors.toList());
    }
    public static List<CategoryDto> iterableCategoryListToDtoList(Iterable<Category> categoryIterable){
        ArrayList<CategoryDto> categoryList = new ArrayList<>();
        for (Category category:categoryIterable) {
            categoryList.add(new CategoryDto(category));
        }
        return categoryList;
    }
}
