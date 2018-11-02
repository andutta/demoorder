package com.manh.customExternalExt.demoorder.controller;

import com.manh.customExternalExt.demoorder.services.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by andutta on 11/2/18.
 */

@RestController
@RequestMapping("/external/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    private static final Logger LOGGER  = LoggerFactory.getLogger(OrderController.class);

    @PostMapping(path="generateOrderId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> generateOrderId()
    {
        String methodName = "OrderController.generateOrderId";
        LOGGER.info("Entering >> " + methodName);
        String generatedOrderId = orderService.generateOrderId();
        Map<String, String> wrapper = new HashMap<>();
        wrapper.put("value", generatedOrderId);
        LOGGER.info("Exiting Method <<" + methodName + wrapper);
        return wrapper;
    }
}
