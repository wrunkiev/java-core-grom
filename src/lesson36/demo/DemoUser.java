package lesson36.demo;

import lesson36.controller.UserController;
import lesson36.model.User;
import lesson36.model.UserType;
import lesson36.repository.UserRepository;

public class DemoUser {
    public static void main(String[] args)throws Exception {
        UserController userController = new UserController();
        User user1 = new User(userController.genIdUser(), "Gleb", "pasword", "Ukraine", UserType.ADMIN);
        User user2 = new User(userController.genIdUser(), "Serg", "pas", "Ukraine", UserType.ADMIN);
        userController.login(user1.getUserName(), user1.getPassword());
        userController.logout();
        userController.login(user2.getUserName(), user2.getPassword());





    }
}
