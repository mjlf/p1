package com.mjlf.skywalking.service;

import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.LivenessState;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class LocalCacheVerifier {

    private final ApplicationEventPublisher eventPublisher;

    public LocalCacheVerifier(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void checkLocalCache() {
        try {
            //...
            throw new Exception("abc");
        }
        catch (Exception ex) {
            AvailabilityChangeEvent.publish(this.eventPublisher, ex, ReadinessState.REFUSING_TRAFFIC);
        }
    }

}