package com.api.subscription.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.subscription.model.Subscription;
import com.api.subscription.repository.SubscriptionRepository;
import java.util.List;

@Service
public class SubscriptionService {
    @Autowired
    SubscriptionRepository subRepository;

    // CREATE
    public Subscription createSubscription(Subscription sub) {
        return subRepository.save(sub);
    }
    // READ
    public List<Subscription> getSubscription() {
        return subRepository.findAll();
    }

    // READ by ID
    // public List<Employee> getEmployeesbyId(Long empId) {
    //     return empRepository.findById(empId).get();
    // }
    public Subscription getSubscriptionById(Long id) {
        return subRepository.findById(id).get();
     }
    // DELETE
    public void deleteSubscription(Long id) {
        subRepository.deleteById(id);
    }

    // UPDATE
    public Subscription updateSubscription(Long id, Subscription subscriptionDetails) {
        Subscription sub = subRepository.findById(id).get();
        sub.setMobile(subscriptionDetails.getMobile());
        sub.setSubscription(subscriptionDetails.getSubscription());
        sub.setDateTime(subscriptionDetails.getDateTime());
        sub.setExpiry(subscriptionDetails.getExpiry());

        return subRepository.save(sub);
    }
}
