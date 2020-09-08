package com.urunov.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.urunov.graphql.model.Customer;
import com.urunov.graphql.model.Product;
import com.urunov.graphql.repository.CustomerRepository;
import com.urunov.graphql.repository.ProductRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @Author: apple
 * @created on 07/09/2020
 * @Project is OnetoMany
 */
@Component
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    public Mutation(CustomerRepository customerRepository, ProductRepository productRepository) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    public Customer createCustomer(String customerName, String image, String email, int totalOrder, int totalOrderAmount ){

        Customer customer = new Customer();

        customer.setCustomerName(customerName);
        customer.setImage(image);
        customer.setEmail(email);
        customer.setTotalOrder(totalOrder);
        customer.setTotalOrderAmount(totalOrderAmount);

        customerRepository.save(customer);

        return customer;
    }

    public Product createProduct(String productName, String slug, String unit, String description, Float price, Float salePrice, String type, String image, Integer id){

        Product product = new Product();
        product.setProductName(productName);
        product.setSlug(slug);
        product.setUnit(unit);
        product.setDescription(description);
        product.setPrice(price);
        product.setSalePrice(salePrice);
        product.setType(type);
        product.setImage(image);

        product.setCustomer(new Customer(id));

        return product;
    }

    public boolean deleteProduct(int id){
        productRepository.deleteById(id);

        return true;
    }

    public Product updateProduct(Integer id, String productName, String unit, String description, Float price, Float salePrice) throws NotFoundException {

        Optional<Product> productOptional = productRepository.findById(id);

        if(productOptional.isPresent()){
            Product product = productOptional.get();

            if(productName !=null){
               product.setProductName(productName);
            }
            if(unit !=null){
                product.setUnit(unit);
            }
            if(description!=null){
                product.setDescription(description);
            }
            if(price !=0.0){
                product.setPrice(price);
            }

            if(salePrice !=0.0) {
                product.setSalePrice(salePrice);
            }

            productRepository.save(product);
            return product;
        }
        throw new NotFoundException("Not found Tutorial to updated");
    }
}


