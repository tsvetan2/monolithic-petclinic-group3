package org.springframework.samples.petclinic.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Primary
@Service
public class ManagementServiceToggle implements ManagementService {

    @Autowired
    private ManagementServiceLocal local;

    @Autowired
    private ManagementClient remote;

    @Override
    public List<YearlyRevenue> listYearlyRevenue() {
        // TODO ff
        if (false) {
            return remote.listYearlyRevenue();
        }
        return local.listYearlyRevenue();
    }
}
