package co.edu.uptc.Ejercicio1Backend.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uptc.Ejercicio1Backend.models.Person;
import co.edu.uptc.Ejercicio1Backend.services.*;

@RestController
@RequestMapping
public class TestController {

    @GetMapping("/teens")
    public List<Person> showTeens() {
        CvsReadAndOrganizeService cv = new CvsReadAndOrganizeService();
        cv.readCvs();
        return cv.generateListAdolesncence();
    }

    @GetMapping("/adulthood")
    public List<Person> showAdulthood() {
        CvsReadAndOrganizeService cv = new CvsReadAndOrganizeService();
        cv.readCvs();
        return cv.generateListAdulthood();
    }

    @GetMapping("/childhood")
    public List<Person> showChildHood() {
        CvsReadAndOrganizeService cv = new CvsReadAndOrganizeService();
        cv.readCvs();
        return cv.generateListChildhood();
    }

    @GetMapping("earlyChildhood")
    public List<Person> showEarlyChildhood() {
        CvsReadAndOrganizeService cv = new CvsReadAndOrganizeService();
        cv.readCvs();
        return cv.generateListEarlyChildhood();
    }

    @GetMapping("/oldAge")
    public List<Person> showOldAge() {
        CvsReadAndOrganizeService cv = new CvsReadAndOrganizeService();
        cv.readCvs();
        return cv.generateListOldAge();
    }

    @GetMapping("/youth")
    public List<Person> showYouth() {
        CvsReadAndOrganizeService cv = new CvsReadAndOrganizeService();
        cv.readCvs();
        return cv.generateListYouth();
    }
}