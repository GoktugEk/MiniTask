package com.example.MiniTask;


public class MappedPackageObject{
    private long id;
    private String  createdAt;
    private String lastUpdatedAt;
    private int collectionDuration;
    private int deliveryDuration;
    private int eta;
    private int leadTime;
    private boolean orderInTime;



    public MappedPackageObject() {
        this.id = Long.parseLong(null);
        this.orderInTime = Boolean.parseBoolean(null);
        this.leadTime = Integer.parseInt(null);
        this.eta = Integer.parseInt(null);
        this.deliveryDuration = Integer.parseInt(null);
        this.collectionDuration = Integer.parseInt(null);
        this.lastUpdatedAt = null;
        this.createdAt = null;
    }

    public MappedPackageObject(long id) {
        this.id = id;
        this.orderInTime = Boolean.parseBoolean(null);
        this.leadTime = Integer.parseInt(null);
        this.eta = Integer.parseInt(null);
        this.deliveryDuration = Integer.parseInt(null);
        this.collectionDuration = Integer.parseInt(null);
        this.lastUpdatedAt = null;
        this.createdAt = null;
    }

    public MappedPackageObject(long id, String createdAt, String lastUpdatedAt, int collectionDuration, int deliveryDuration, int eta, int leadTime, boolean orderInTime){
        this.id = id;
        this.orderInTime = orderInTime;
        this.leadTime = leadTime;
        this.eta = eta;
        this.deliveryDuration = deliveryDuration;
        this.collectionDuration = collectionDuration;
        this.lastUpdatedAt = lastUpdatedAt;
        this.createdAt = createdAt;

    }

    public int getCollectionDuration() {
        return collectionDuration;
    }

    public int getDeliveryDuration() {
        return deliveryDuration;
    }

    public int getEta() {
        return eta;
    }

    public int getLeadTime() {
        return leadTime;
    }

    public long getId() {
        return id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setCollectionDuration(int collectionDuration) {
        this.collectionDuration = collectionDuration;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setDeliveryDuration(int deliveryDuration) {
        this.deliveryDuration = deliveryDuration;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLastUpdatedAt(String lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

    public void setLeadTime(int leadTime) {
        this.leadTime = leadTime;
    }

    public void setOrderInTime(boolean orderInTime) {
        this.orderInTime = orderInTime;
    }

}



