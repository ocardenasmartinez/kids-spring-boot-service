package cl.kids.controllers;

import cl.kids.business.KidsBusiness;
import cl.kids.entities.request.KidRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KidsController {

    @Autowired
    private KidsBusiness kidsBusiness;

    @PostMapping(path= "/insert", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> insertKid(@RequestBody KidRequest kidRequest) {
        return new ResponseEntity<>(kidsBusiness.saveKid(kidRequest), HttpStatus.OK);
    }



}
