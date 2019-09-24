package lesson36.service;

import lesson36.controller.HotelController;
import lesson36.controller.RoomController;
import lesson36.model.Session;
import lesson36.model.UserType;
import lesson36.repository.UserRepository;
import lesson36.model.User;

import java.util.ArrayList;
import java.util.Scanner;

public class UserService {
    private UserRepository userRepository = new UserRepository();
    private Session session;


    private void validateUser()throws Exception{
        for(String sU : userRepository.readUsersFromDb()){
            for (String sF : sU.split(",")){
                if(sF.trim().isEmpty())
                    throw new Exception("Exception in method 'validateUser'. Data Base of User is crashed");
            }
        }
    }

    public ArrayList<User> getUsers()throws Exception{
        validateUser();

        ArrayList<User> users = new ArrayList<>();
        ArrayList<String> userFields = new ArrayList<>();
        User user;

        for(String sU : userRepository.readUsersFromDb()){
            for (String sF : sU.split(",")){
                userFields.add(sF.trim());
            }

            user = new User(Long.parseLong(userFields.get(0)),
                    userFields.get(1),
                    userFields.get(2),
                    userFields.get(3),
                    getUserType(userFields.get(4)));
            users.add(user);
            userFields.clear();
        }
        return users;
    }

    private UserType getUserType(String userType)throws Exception{
        UserType[] userTypes = UserType.values();
        for(UserType uT : userTypes){
            if(uT.toString().equals(userType)){
                return uT;
            }
        }
        throw new Exception("Exception in method 'getUserType'. UserType with this: " + userType + " is not exist");
    }

    private void validateNewUser(User user)throws Exception{
        for(User u : getUsers()){
            if(u.equals(user)){
                throw new Exception("Exception in method 'validateNewUser'. This user with ID: " + u.getId() + " is exist already");
            }
        }
    }

    public User registerUser(User user)throws Exception{
        validateNewUser(user);
        return userRepository.registerUser(user);
    }

    public void login(String userName, String password)throws Exception{
        User user = null;

        for(User u : getUsers()){
            if(u.getUserName().equals(userName) && u.getPassword().equals(password)){
                user = u;
                if(session == null){
                    session = new Session();
                    session.setId(user.getId());
                    session.setUserId(user.getId());
                    break;
                }else{
                    throw new Exception("Any User is login in site already!!!");
                }
            }
        }

        if(user == null){
            throw new Exception("Exception in method 'login'. User is not find in DB. You should register!!!");
        }

    }

    public void logout(){
        session = null;
    }
}
