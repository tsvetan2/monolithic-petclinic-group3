package petclinic.vets;

import java.util.List;

public interface IVetInfo {

    //TODO: Return list of strings for the frontend
    List<Specialty> getSpecialties();

    String getFirstName();

    String getLastName();
}
