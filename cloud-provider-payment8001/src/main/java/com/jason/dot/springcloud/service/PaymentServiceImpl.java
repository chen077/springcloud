package com.jason.dot.springcloud.service;

import com.jason.dot.springcloud.dao.PaymentDAO;
import com.jason.dot.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    //@resource allows you to specify a name of injected bean
    //@autowire allows you to mark it as non-mandatory
    @Resource
    private PaymentDAO paymentDAO;
    @Override
    public int create(Payment payment) {
        return paymentDAO.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDAO.getPaymentById(id);
    }
}
