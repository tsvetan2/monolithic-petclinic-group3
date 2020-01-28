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
        Map<?, ?> payload = (Map<?, ?>) whatever.getPayload();
        System.out.println("Received <" + payload + ">");
        managementService.saveRevenue(Integer.parseInt((String) payload.get("source_id")), LocalDate.parse((String) payload.get("visit_date")), Long.parseLong((String) payload.get("cost")));
    }

}