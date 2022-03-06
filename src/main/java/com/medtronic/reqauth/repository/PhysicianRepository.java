package com.medtronic.reqauth.repository;

import java.util.List;
import com.medtronic.reqauth.models.Physician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PhysicianRepository extends JpaRepository<Physician, Long> {

    //JPQL
    @Query("" +
            "SELECT CASE WHEN COUNT(s) > 0 THEN " +
            "TRUE ELSE FALSE END " +
            "FROM Physician s " +
            "WHERE s.npi = ?1"
    )
    Boolean selectExistsPhysician(String npi);

}