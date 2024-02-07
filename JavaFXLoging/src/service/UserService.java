package service;

import entity.UserEntity;
import repository.UserRepository;

public class UserService {

    UserRepository userRepository = new UserRepository();

    public Integer saveUser(UserEntity entity){
        Integer id = userRepository.saveUser(entity);
        return id;
    }
    
    public boolean authonticationUser(UserEntity entity){
        Boolean bool = userRepository.authonticationUser(entity);
 /*       if(bool){
            findUser(entity.getPassword());
        }*/
        return bool;
    }

    public UserEntity findUser(String password) {
        UserEntity entity = userRepository.getUser(password);
        return entity;
    }
}
