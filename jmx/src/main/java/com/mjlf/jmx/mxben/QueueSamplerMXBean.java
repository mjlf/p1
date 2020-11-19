package com.mjlf.jmx.mxben;

public interface QueueSamplerMXBean {
    public QueueSample getQueueSample(); 
    public void clearQueue();
    public void show();
} 