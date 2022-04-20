package petclinic.vets;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class VetService {
    private final VetRepository vets;

    public VetService(VetRepository vets){
        this.vets = vets;
    }

    public Collection<IVetInfo> allVets() {

         return this.vets.findAll()
                         .stream()
                         .map(IVetInfo.class::cast)
                         .collect(Collectors.toList());
    }
}
