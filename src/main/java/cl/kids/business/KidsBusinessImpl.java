package cl.kids.business;

import cl.kids.data.repository.KidsRepository;
import cl.kids.entities.data.kids.Kids;
import cl.kids.entities.request.KidRequest;
import cl.kids.entities.responses.KidResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class KidsBusinessImpl implements KidsBusiness {

    @Autowired
    private KidsRepository kidsRepository;

    @Override
    public String saveKid(KidRequest kidRequest) {
        kidsRepository.save(Kids.builder().name(kidRequest.getName()).age(kidRequest.getAge()).build());
        return "OK";
    }

    @Override
    public List<KidResponse> getKids() {
        List<KidResponse> listKids = new ArrayList<>();
        Iterator kidsIterator = kidsRepository.findAll().iterator();
        while (kidsIterator.hasNext()){
            Kids kids = (Kids) kidsIterator.next();
            KidResponse kidResponse = new KidResponse();
            kidResponse.setAge(kids.getAge());
            kidResponse.setName(kids.getName());
            listKids.add(kidResponse);
        }
        return listKids;
    }

}
