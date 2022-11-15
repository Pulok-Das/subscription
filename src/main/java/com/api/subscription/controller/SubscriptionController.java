package com.api.subscription.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.subscription.model.Subscription;
import com.api.subscription.service.SubscriptionService;

@RestController
@RequestMapping("/")

public class SubscriptionController {
    @Autowired
    SubscriptionService subService;

    @RequestMapping(value = "/subscription", method = RequestMethod.POST)
    public Subscription createSubscription(@RequestBody Subscription sub) {
        return subService.createSubscription(sub);
    }

    @RequestMapping(value = "/subscription", method = RequestMethod.GET)
    public List<Subscription> readSubscription() {
        return subService.getSubscription();
    }

    @RequestMapping(value = "/subscription/{subId}", method = RequestMethod.GET)
    public Subscription readSubscriptionById(@PathVariable(value = "subId") Long subId) {
        return subService.getSubscriptionById(subId);
    }

    @RequestMapping(value = "/subscription/{subId}", method = RequestMethod.PUT)
    public Subscription readSubscription(@PathVariable(value = "subId") Long id, @RequestBody Subscription subDetails) {
        return subService.updateSubscription(id, subDetails);
    }

    @RequestMapping(value = "/subscription/{subId}", method = RequestMethod.DELETE)
    public void deleteSubscription(@PathVariable(value = "subId") Long id) {
        subService.deleteSubscription(id);
    }
}
