package com.example.demo.Service;

import com.example.demo.DTO.Products;
import com.example.demo.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceImpl {

    @Autowired
    ProductRepo productRepo;

   /* List<Products> productList = new ArrayList<>(List.of(
            new Products(1, "Laptop", 65000),
            new Products(2, "Mobile", 25000),
            new Products(3, "Headphones", 3000),
            new Products(4, "Keyboard", 1500)
    ));*/


    public List<Products> getProducts() {

        return  productRepo.findAll();
       // return productList;
    }

    // Get product by ID
    public Products getProductById(int id) {
      /*  for (Products product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }*/

      //  return productList.stream().filter(p -> p.getId() == id).findFirst().get();

        return productRepo.findById(id).orElse(new Products());

    }

    // Add product
    public String addProduct(Products product) {
        /*productList.add(product);
        return "Product added successfully";*/

        productRepo.save(product);
        return "prodcut added";
    }

    public String updateProduct(Products products)
    {

        productRepo.save(products);

        /*int index = 0;

        for(Products pd : productList)
        {
            if(pd.getId() == products.getId())
            {
                break;
            }

            index++;
        }

        productList.set(index,products);*/

        return "product update";



    }


    public String deleteProduct(int  id) {

        /*int index = 0;

        for(Products pd : productList)
        {
            if(pd.getId() == products.getId())
            {
                break;
            }

            index++;
        }

        productList.remove(productList.get(index));

        return "product deleted";*/

          productRepo.deleteById(id);
          return "product deleted";


    }
}
