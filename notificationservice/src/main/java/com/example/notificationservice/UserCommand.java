package com.example.notificationservice;

import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.lifecycle.Service;
import org.apache.karaf.shell.api.action.Action;
import org.apache.karaf.shell.api.action.Argument;
import com.example.usermanagement.User;
import com.example.usermanagement.UserService;

@Command(scope = "user", name = "add", description = "Add a new user")
@Service
public class UserCommand implements Action {

    @Argument(index = 0, name = "id", description = "User ID", required = true, multiValued = false)
    private String id;

    @Argument(index = 1, name = "name", description = "User name", required = true, multiValued = false)
    private String name;

    @Argument(index = 2, name = "email", description = "User email", required = true, multiValued = false)
    private String email;

    private UserService userService = new UserService();
    private NotificationService notificationService = new NotificationService(userService);

    @Override
    public Object execute() throws Exception {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setEmail(email);
        userService.addUser(user);
        notificationService.sendNotification(user);
        return null;
    }
}
