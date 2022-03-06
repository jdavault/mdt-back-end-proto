package com.medtronic.reqauth.controller;

import com.medtronic.reqauth.models.Physician;
import com.medtronic.reqauth.services.PhysicianService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@Api( tags = "Physicians")
@RestController
@RequestMapping(path = "api/v1/physicians")
@RequiredArgsConstructor
@CrossOrigin("*")

public class PhysicianController {

    Logger logger = LoggerFactory.getLogger(PhysicianController.class);
    private final PhysicianService physicianService;

    @GetMapping
    @ApiOperation(value = "This method will retrieve all physicians (or by PracticeName).")
    public ResponseEntity<List<Physician>> getAllPhysicians(@RequestParam(required = false) String nameOfPractice) {
        try {
            List<Physician> physicians = physicianService.getAllPhysicians(nameOfPractice);

            if (physicians.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(physicians, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{physicianId}")
    @ApiOperation(value = "This method will fetch a physician by its physician id.")
    public ResponseEntity<Physician> getPhysicianById(@PathVariable Long physicianId) {
        try{
            Physician physician = physicianService.getPhysicianById(physicianId);
            if (physician != null) {
                return new ResponseEntity<>(physician, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path ="{physicianId}")
    @ApiOperation(value = "This method will update a given physician by id.")
    public ResponseEntity<Physician> updatePhysician(@PathVariable Long physicianId, @RequestBody Physician physician)
    {
        if(physician == null || physicianId == null) {
            return new ResponseEntity("Physician Data and PatientID must not be null", HttpStatus.NOT_FOUND);
        }

        try{
            Physician _physician = physicianService.updatePhysician(physician, physicianId);
            if (physician != null) {
                return new ResponseEntity<>(_physician, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    @ApiOperation(value = "This method will create a new physician.")
    public ResponseEntity<Physician> createPhysician(@RequestBody Physician physician) {
        Physician addedPhysician = physicianService.create(physician);
        if (addedPhysician != null) {
            return new ResponseEntity<>(addedPhysician, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{physicianId}")
    @ApiOperation(value = "This method will delete a physician by id.")
    public ResponseEntity<HttpStatus> deletePhysician(@PathVariable("physicianId") long physicianId) {
        Boolean wasDeleted = physicianService.deleteById(physicianId);
        if (wasDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping
    @ApiOperation(value = "This method will delete ALL physicians (be careful).")
    public ResponseEntity<HttpStatus> deleteAllPhysicians() {
        Boolean wasDeleted = physicianService.deleteAll();
        if (wasDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}