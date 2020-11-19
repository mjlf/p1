package com.mjlf.skywalking.service;

import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.AvailabilityState;
import org.springframework.boot.availability.LivenessState;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class LivenessStateExporter implements AvailabilityState {

    @EventListener
    public void onStateChange(AvailabilityChangeEvent<LivenessState> event) {
        switch (event.getState()) {
            case CORRECT:
                System.out.println("3");
                break;
            case BROKEN:
                System.out.println("4");
                break;
        }
    }
}