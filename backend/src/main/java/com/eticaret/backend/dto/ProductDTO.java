package com.eticaret.backend.dto;

public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private double price; // BigDecimal yerine double
    private int stock;
    private boolean bestSeller;
    private boolean newProduct;
    private String createdAt; // LocalDateTime yerine String
    private String image;
    private Long seasonId;
    private String seasonName;

    public ProductDTO(Long id, String name, String description, double price,
                      int stock, boolean bestSeller, boolean newProduct,
                      String createdAt, String image, Long seasonId, String seasonName) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.bestSeller = bestSeller;
        this.newProduct = newProduct;
        this.createdAt = createdAt;
        this.image = image;
        this.seasonId = seasonId;
        this.seasonName = seasonName;
    }

    // Getter ve Setter'lar
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
    public boolean isBestSeller() { return bestSeller; }
    public void setBestSeller(boolean bestSeller) { this.bestSeller = bestSeller; }
    public boolean isNewProduct() { return newProduct; }
    public void setNewProduct(boolean newProduct) { this.newProduct = newProduct; }
    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
    public Long getSeasonId() { return seasonId; }
    public void setSeasonId(Long seasonId) { this.seasonId = seasonId; }
    public String getSeasonName() { return seasonName; }
    public void setSeasonName(String seasonName) { this.seasonName = seasonName; }
}
