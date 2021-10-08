package cl.kids.business;

import cl.kids.entities.request.KidRequest;
import cl.kids.entities.responses.KidResponse;

import java.util.List;

public interface KidsBusiness {

    String saveKid(KidRequest kidRequest);
    List<KidResponse> getKids();

}
