package com.catshop.catshop.config;

import com.catshop.catshop.entity.ProductType;
import com.catshop.catshop.repository.ProductTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ProductTypeSeeder implements CommandLineRunner {
    private  final ProductTypeRepository productTypeRepository;

    @Override
    public void run(String... args) throws Exception {
        List<String> defaultTypes = List.of("Cat","Food","Cage","Cleaning");

        for (String typeName : defaultTypes){
            if(!productTypeRepository.existsByTypeName(typeName)){
                ProductType type = ProductType.builder().typeName(typeName).build();
                productTypeRepository.save(type);
                System.out.println("Inserted default type: " + typeName);
            }
            else {
                System.out.println("Type already exists: " + typeName);
            }
        }
    }
}
