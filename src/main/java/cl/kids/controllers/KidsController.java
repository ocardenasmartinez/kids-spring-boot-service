package cl.kids.controllers;

import cl.kids.business.KidsBusiness;
import cl.kids.entities.request.KidRequest;
import cl.kids.entities.responses.KidResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KidsController {

    @Autowired
    private KidsBusiness kidsBusiness;

    @PostMapping(path= "/insert", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> insertKid(@RequestBody KidRequest kidRequest) {
        return new ResponseEntity<>(kidsBusiness.saveKid(kidRequest), HttpStatus.OK);
    }

    @GetMapping(path = "/get", produces = "application/json")
    public ResponseEntity<List<KidResponse>> getKids() {
        return new ResponseEntity<>(kidsBusiness.getKids(), HttpStatus.OK);
    }

}
