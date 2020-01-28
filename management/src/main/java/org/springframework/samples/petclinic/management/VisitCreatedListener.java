package org.springframework.samples.petclinic.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Map;

@Component
public class VisitCreatedListener {

    @Autowired
    private ManagementService managementService;

    @JmsListener(destination = "visitCreated")
    public void receiveMessage(Message whatever) {
        Map<String, ?> payload = (Map<String, ?>) whatever.getPayload();
        Integer sourceId = (Integer) payload.get("source_id");
        LocalDate visitDate = LocalDate.parse((String) payload.get("visit_date"));
        Integer value = (Integer) payload.get("cost");

        managementService.saveRevenue(sourceId, visitDate, value);
    }

}