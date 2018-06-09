package com.pablocasvar.afirstmvc.repositories;

import com.pablocasvar.afirstmvc.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Pablo on 12/05/2018.
 */
@Repository
public interface IUserRepository extends JpaRepository<UserModel, Integer>{

    List<UserModel> findByNameContainingOrLastnamePContainingOrLastnameMContaining(
        String name,
        String lastnameP,
        String lastNameM
    );
}
