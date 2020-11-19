package com.mjlf.jmx.entity;

import javax.management.*;
 
public class Hello 
        extends NotificationBroadcasterSupport implements HelloMBean { 
 
    public void sayHello() { 
        System.out.println("hello, world"); 
    } 
 
    public int add(int x, int y) { 
        return x + y; 
    } 
 
    public String getName() { 
        return this.name; 
    } 
 
    public int getCacheSize() { 
        return this.cacheSize; 
    } 
 
    public synchronized void setCacheSize(int size) { 
        int oldSize = this.cacheSize; 
        this.cacheSize = size; 
 
        System.out.println("Cache size now " + this.cacheSize); 
 
        Notification n = 
            new AttributeChangeNotification(this, 
                                            sequenceNumber++, 
                                            System.currentTimeMillis(), 
                                            "CacheSize changed", 
                                            "CacheSize", 
                                            "int", 
                                            oldSize, 
                                            this.cacheSize); 
 
        sendNotification(n); 
    } 
 
    @Override 
    public MBeanNotificationInfo[] getNotificationInfo() { 
        String[] types = new String[] { 
            AttributeChangeNotification.ATTRIBUTE_CHANGE 
        }; 
        String name = AttributeChangeNotification.class.getName(); 
        String description = "An attribute of this MBean has changed"; 
        MBeanNotificationInfo info = 
            new MBeanNotificationInfo(types, name, description); 
        return new MBeanNotificationInfo[] {info}; 
    }

    public synchronized void setName(String name){
        String oldName = this.name;
        this.name = name;
        Notification n = new AttributeChangeNotification(this,
                sequenceNumber ++,
                System.currentTimeMillis(),
                "name change",
                "name",
                "java.lang.String",
                oldName,
                this.name);
        sendNotification(n);
    }
 
    private  String name = "Reginald";
    private int cacheSize = DEFAULT_CACHE_SIZE; 
    private static final int DEFAULT_CACHE_SIZE = 200; 
 
    private long sequenceNumber = 1; 
} 