package com.sphong.resttemplate.demo.controller;

import com.sphong.resttemplate.demo.dto.UserDto;
import com.sphong.resttemplate.demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private OrderService orderService;

    @GetMapping("/order/{menu}")
    public UserDto getUserHasMenu(@PathVariable("menu") String menu) {
        return orderService.getUserHasMenu(menu);
    }
}
