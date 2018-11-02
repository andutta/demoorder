package com.manh.customExternalExt.demoorder.services;

import com.manh.customExternalExt.demoorder.controller.OrderController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Created by andutta on 11/2/18.
 */
@Service
public class OrderService {

    private static final Logger LOGGER  = LoggerFactory.getLogger(OrderController.class);


    public String generateOrderId()
    {
        String methodName = "OrderService.generateOrderId";
        LOGGER.info("Entering Method >>" + methodName);
        String generatedOrderId = null;
        Random randomNo = new Random();

        String orderIdDefaultPrefixValue = "WAL-";
        // derive order id from sequence
        Integer  orderSequenceValue = randomNo.nextInt(500000);

        // generate fixed length string from sequence
        //String paddedOrderSequenceValue = Strings.padStart(orderSequenceValue.toString(), 8, '0');
        LOGGER.debug(methodName, orderSequenceValue);
        generatedOrderId = orderIdDefaultPrefixValue.concat(orderSequenceValue.toString());
        //}
        LOGGER.info("Exit Method << " + methodName + " generatedOrderId : " + generatedOrderId);
        return generatedOrderId;
    }
}
