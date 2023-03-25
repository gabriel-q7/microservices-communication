package br.com.commicros.productapi.modules.product.repository;

import br.com.commicros.productapi.modules.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
