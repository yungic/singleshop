package com.elice.team4.singleShop.product.controller;

import com.elice.team4.singleShop.product.domain.Product;
import com.elice.team4.singleShop.product.dto.ProductDto;
import com.elice.team4.singleShop.product.mapper.ProductMapper;
import com.elice.team4.singleShop.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ProductApiController {
    private final ProductService productService;

    @PostMapping("/api/seller/new")
    public String create(@ModelAttribute ProductDto productDto) {
        productService.saveProduct(productDto); // ProductDto를 직접 전달
        return "redirect:/";
    }
}
