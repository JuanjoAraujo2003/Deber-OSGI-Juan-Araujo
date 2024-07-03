package com.example.notificationservice;

import com.example.usermanagement.User;
import com.example.usermanagement.UserService;

public class NotificationService {
    private UserService userService;

    public NotificationService(UserService userService) {
        this.userService = userService;
    }

    public void sendNotification(User user) {
        System.out.println("Enviando notificación a " + user.getEmail());
    }
}
