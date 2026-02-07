package csd230.lab1.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cart_entity")
public class CartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "cart_products",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<BookEntity> products = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    // Constructors
    public CartEntity() {
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<BookEntity> getProducts() {
        return products;
    }

    public void setProducts(List<BookEntity> products) {
        this.products = products;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    // Helper method to add a product
    public void addProduct(BookEntity book) {
        if (!products.contains(book)) {
            products.add(book);
        }
    }

    // Calculate total
    public double getTotal() {
        return products.stream()
                .mapToDouble(BookEntity::getPrice)
                .sum();
    }
}