package cl.kids.business;

import cl.kids.data.repository.KidsRepository;
import cl.kids.entities.data.kids.Kids;
import cl.kids.entities.request.KidRequest;
import org.springframework.beans.factory.annotation.Autowired;

public class KidsBusinessImpl implements KidsBusiness {

    @Autowired
    private KidsRepository kidsRepository;

    @Override
    public String saveKid(KidRequest kidRequest) {
        kidsRepository.save(Kids.builder().name(kidRequest.getName()).age(kidRequest.getAge()).build());
        return "OK";
    }

}
