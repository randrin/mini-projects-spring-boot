package com.randrin.pagination.and.sorting.repository;

import com.randrin.pagination.and.sorting.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaginationAndSortingRepository extends JpaRepository<Product, String> {
}
