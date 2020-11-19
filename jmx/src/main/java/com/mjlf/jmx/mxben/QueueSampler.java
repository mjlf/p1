package com.mjlf.jmx.mxben;

import java.util.Date;
import java.util.Queue; 
 
public class QueueSampler implements QueueSamplerMXBean { 
     
    private Queue<String> queue; 
     
    public QueueSampler(Queue<String> queue) { 
       this.queue = queue; 
    } 
     
    public QueueSample getQueueSample() { 
        synchronized (queue) { 
            return new QueueSample(new Date(), queue.size(), queue.peek()); 
        } 
    }

    @Override
    public void show() {
        System.out.println(this.queue.size());
    }

    public void clearQueue() {
        synchronized (queue) { 
            queue.clear(); 
        } 
    } 
} 