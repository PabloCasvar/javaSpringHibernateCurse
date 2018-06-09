package com.pablocasvar.afirstmvc.repositories;

import com.pablocasvar.afirstmvc.model.LoanModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Pablo on 02/06/2018.
 */
@Repository
public interface ILoanRepository extends JpaRepository<LoanModel, Integer> {

}
