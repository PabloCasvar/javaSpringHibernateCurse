package com.pablocasvar.afirstmvc.services;

import com.pablocasvar.afirstmvc.model.UserModel;
import com.pablocasvar.afirstmvc.repositories.IUserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Created by Pablo on 12/05/2018.
 */

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;

    public List<UserModel> findAll(){
        return this.userRepository.findAll();
    }

    public UserModel register(UserModel newUser){
        return this.userRepository.save(newUser);
    }

    public UserModel findById(Integer id){
        Optional<UserModel> found = this.userRepository.findById(id);

        try{
            return found.get();
        }catch(NoSuchElementException e){
            System.out.println("No se enconró el elemento");
        }

        return null;
    }

    public UserModel edit(UserModel userModel){
        return this.userRepository.save(userModel);
    }

    public boolean delete(Integer idToDelete){
        this.userRepository.deleteById(idToDelete);
        return true;
    }

    public List<UserModel> search(
        String name,
        String lastnameP,
        String lastnameM
    ){
        return this.userRepository.findByNameContainingOrLastnamePContainingOrLastnameMContaining(
            name.length() > 0 ? name : " ",
            lastnameP.length() > 0 ? lastnameP : " ",
            lastnameM.length() > 0 ? lastnameM : " "
        );
    }

}
