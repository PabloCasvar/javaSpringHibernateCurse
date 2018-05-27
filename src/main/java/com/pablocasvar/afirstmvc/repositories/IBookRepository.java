package com.pablocasvar.afirstmvc.repositories;

import com.pablocasvar.afirstmvc.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Pablo on 12/05/2018.
 */
@Repository
public interface IBookRepository extends JpaRepository<BookModel, Integer>{

}
