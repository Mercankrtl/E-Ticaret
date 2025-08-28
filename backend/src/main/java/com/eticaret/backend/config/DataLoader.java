package com.eticaret.backend.config;

import com.eticaret.backend.model.Product;
import com.eticaret.backend.model.Category;
import com.eticaret.backend.model.Gender;
import com.eticaret.backend.repository.ProductRepository;
import com.eticaret.backend.repository.CategoryRepository;
import com.eticaret.backend.repository.GenderRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final GenderRepository genderRepository;

    public DataLoader(ProductRepository productRepository,
                      CategoryRepository categoryRepository,
                      GenderRepository genderRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.genderRepository = genderRepository;
    }

    @Override
    public void run(String... args) {
        ObjectMapper mapper = new ObjectMapper();

        try (InputStream inputStream = new ClassPathResource("products.json").getInputStream()) {

            List<ProductJson> productsJson = mapper.readValue(inputStream, new TypeReference<List<ProductJson>>() {});

            for (ProductJson pJson : productsJson) {
                try {
                    // Gender
                    Gender gender = genderRepository.findByName(pJson.getGender())
                            .orElseGet(() -> genderRepository.save(new Gender(pJson.getGender())));

                    // Product
                    Product product = new Product();
                    product.setName(pJson.getName());
                    product.setDescription(pJson.getDescription());
                    product.setPrice(BigDecimal.valueOf(pJson.getPrice()));
                    product.setStock(pJson.getStock_quantity());
                    product.setBestSeller(pJson.isIs_best_seller());
                    product.setNewProduct(pJson.isIs_new());
                    product.setGender(gender);
                    product.setImage(pJson.getImage());

                    // Categories
                    if (pJson.getCategories() != null) {
                        for (String catName : pJson.getCategories()) {
                            Category category = categoryRepository.findByName(catName)
                                    .orElseGet(() -> categoryRepository.save(new Category(catName)));
                            product.getCategories().add(category);
                        }
                    }

                    productRepository.save(product);

                } catch (Exception e) {
                    System.err.println("Error saving product: " + pJson.getName());
                    e.printStackTrace();
                }
            }

            System.out.println("Products loaded from JSON!");

        } catch (Exception e) {
            System.err.println("Error reading products.json");
            e.printStackTrace();
        }
    }

    private static class ProductJson {
        private String name;
        private double price;
        private String description;
        private int stock_quantity;
        private boolean is_best_seller;
        private boolean is_new;
        private String gender;
        private List<String> categories;
        private String image;

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public double getPrice() { return price; }
        public void setPrice(double price) { this.price = price; }
        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }
        public int getStock_quantity() { return stock_quantity; }
        public void setStock_quantity(int stock_quantity) { this.stock_quantity = stock_quantity; }
        public boolean isIs_best_seller() { return is_best_seller; }
        public void setIs_best_seller(boolean is_best_seller) { this.is_best_seller = is_best_seller; }
        public boolean isIs_new() { return is_new; }
        public void setIs_new(boolean is_new) { this.is_new = is_new; }
        public String getGender() { return gender; }
        public void setGender(String gender) { this.gender = gender; }
        public List<String> getCategories() { return categories; }
        public void setCategories(List<String> categories) { this.categories = categories; }
        public String getImage() { return image; }
        public void setImage(String image) { this.image = image; }
    }
}
