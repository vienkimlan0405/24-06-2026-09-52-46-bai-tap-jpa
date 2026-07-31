package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Tìm kiếm theo tên có phân trang
    Page<Product> findByNameContainingIgnoreCase(String name, Pageable pageable);
    // Hàm lấy danh sách sản phẩm theo Category ID
    List<Product> findByCategoryId(Long categoryId);
}
