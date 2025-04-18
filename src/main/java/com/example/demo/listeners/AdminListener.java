package com.example.demo.listeners;

import com.example.demo.model.AdminModel;
import com.example.demo.service.AdminService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminListener {

    @Autowired
    private  AdminService adminService;



    @RabbitListener(queues = "admin.request.queue")
    public AdminModel handleAdminRequest(String email) {
        return adminService.findByEmail(email);
    }
}
