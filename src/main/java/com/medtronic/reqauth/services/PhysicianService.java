package com.medtronic.reqauth.services;

import com.medtronic.reqauth.exception.BadRequestException;
import com.medtronic.reqauth.exception.EntityNotFoundException;
import com.medtronic.reqauth.models.Physician;
import com.medtronic.reqauth.repository.PhysicianRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service

public class PhysicianService {

    private final PhysicianRepository physicianRepository;
    //Logger logger = LoggerFactory.getLogger(PhysicianService.class);

    public List<Physician> getAllPhysicians(String nameOfPractice) throws Exception {
        List<Physician> physicians = new ArrayList<>();
        if (nameOfPractice == null)
            physicianRepository.findAll().forEach(physicians::add);
        //else
        //physicianRepository.findByNameOfPractice(nameOfPractice).forEach(physicians::add);
        return physicians;
    }

    public Physician getPhysicianById(Long physicianId) throws Exception {
        Optional<Physician> physicianData = physicianRepository.findById(physicianId);
        if (!physicianData.isPresent()) {
            new EntityNotFoundException("Physician with id " + physicianId + " not found");
        }
        return physicianData.get();
    }

    public Physician create(Physician physician){

        Boolean physicianExists = physicianRepository.selectExistsPhysician(physician.getNpi());
        if (physicianExists) {
            throw new BadRequestException("Physician " +  physician.getNpi() + " already exists");
        }
        try {
            Physician addedPhysician = physicianRepository
                    .save(new Physician(physician.getNpi(), physician.getPtan(), physician.getTin(), physician.getOfficeContact(),
                            physician.getOfficePhone(), physician.getOfficeEmail(), physician.getOfficeFax()));
            return addedPhysician;
        } catch (Exception e) {
            return null;
        }

    }

    public Physician updatePhysician(Physician physician, Long physicianId) throws Exception {
        Optional<Physician> physicianData = physicianRepository.findById(physicianId);
        if (physician == null || physicianId == null) {
            new EntityNotFoundException("Physician with id " + physicianId + " not found");
        }

        Optional<Physician> optionalPhysician = physicianRepository.findById(physicianId);
        if (!physicianData.isPresent()) {
            new EntityNotFoundException("Physician with id " + physicianId + " not found");
        }

        Physician _physician = physicianData.get();
        _physician.setNpi(physician.getNpi());
        _physician.setPtan(physician.getPtan());
        _physician.setTin(physician.getTin());
        _physician.setOfficeContact(physician.getOfficeContact());
        _physician.setOfficeEmail(physician.getOfficeEmail());
        _physician.setOfficePhone(physician.getOfficePhone());
        _physician.setOfficeFax(physician.getOfficeFax());
        physicianRepository.save(_physician);
        return _physician;

    }

    public boolean deleteById(Long tutorialId) {
        if (!physicianRepository.existsById(tutorialId)) {
            throw new EntityNotFoundException("Physician with id " + tutorialId + " does not exists");
        }
        physicianRepository.deleteById(tutorialId);
        return true;
    }

    public boolean deleteAll(){
        try {
            physicianRepository.deleteAll();
            return true;
        } catch (Exception e) {
            throw new EntityNotFoundException("Unable to delete physicians");
        }
    }

}