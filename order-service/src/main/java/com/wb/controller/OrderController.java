package com.wb.controller;

import com.wb.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: r.cheng
 * @Date: 2020/3/1 15:20
 * @Description:
 * @Version: 1.0
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/buy/{id}")
    public Product buy(@PathVariable Long id) {
        // 发送请求
        // 使用Ribbon，可以直接使用服务名称进行调用
        Product product = restTemplate.getForObject("http://localhost:9001/product/get/" + id, Product.class);
        return product;
    }


}
