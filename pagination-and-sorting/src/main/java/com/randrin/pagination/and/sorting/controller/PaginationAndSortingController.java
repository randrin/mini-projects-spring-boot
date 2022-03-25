package com.randrin.pagination.and.sorting.controller;

import com.randrin.pagination.and.sorting.dto.ApiResponse;
import com.randrin.pagination.and.sorting.entity.Product;
import com.randrin.pagination.and.sorting.service.PaginationAndSortingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PaginationAndSortingController {

    @Autowired
    private PaginationAndSortingService paginationAndSortingService;

    @GetMapping
    public ApiResponse<List<Product>> getAllProducts() {
        List<Product> products = paginationAndSortingService.findAllProducts();
        return new ApiResponse<>(products.size(), products);
    }

    @GetMapping("/{field}")
    private ApiResponse<List<Product>> getProductsWithSort(@PathVariable String field) {
        List<Product> allProducts = paginationAndSortingService.findProductsWithSorting(field);
        return new ApiResponse<>(allProducts.size(), allProducts);
    }

    @GetMapping("/pagination")
    private ApiResponse<Page<Product>> getProductsWithPagination(@RequestParam int offset, @RequestParam int pageSize) {
        Page<Product> productsWithPagination = paginationAndSortingService.findProductsWithPagination(offset, pageSize);
        return new ApiResponse<>(productsWithPagination.getSize(), productsWithPagination);
    }

    @GetMapping("/paginationAndSort/{field}")
    private ApiResponse<Page<Product>> getProductsWithPaginationAndSort(@RequestParam int offset, @RequestParam int pageSize, @PathVariable String field) {
        Page<Product> productsWithPagination = paginationAndSortingService.findProductsWithPaginationAndSorting(offset, pageSize, field);
        return new ApiResponse<>(productsWithPagination.getSize(), productsWithPagination);
    }
}
