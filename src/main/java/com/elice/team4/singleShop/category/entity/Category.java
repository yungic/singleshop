package com.elice.team4.singleShop.category.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String categoryName;

    @Column(nullable = false, length = 100)
    private String categoryContent;

    @CreatedDate
    @Column(nullable = false, updatable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    // TODO: Product 다대일 관계 필드 선언
//    @OneToMany(mappedBy = "product")
//    final private List<Product> products = new ArrayList<>();

    public Category(String categoryName, String categoryContent) {
        this.categoryName = categoryName;
        this.categoryContent = categoryContent;
    }

    public void update(Category updatedCategory) {
        if (updatedCategory.getCategoryName() != null) {
            this.categoryName = updatedCategory.getCategoryName();
        }
        if (updatedCategory.getCategoryContent() != null) {
            this.categoryContent = updatedCategory.getCategoryContent();
        }
    }
}
