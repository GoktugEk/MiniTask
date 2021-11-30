package com.example.MiniTask;

public class Data {
    long id;
    String arrival_for_delivery_at;
    String arrival_for_pickup_at;
    String cancel_reason;
    int cancelled;
    long customer_id;
    double origin_latitude;
    double origin_longitude;
    double destination_latitude;
    double destination_longitude;
    long order_id;
    String additional_order_ids;
    long pre_eta;
    int eta;
    int eta_for_prep;
    int eta_on_road;
    String previous_status;
    String status;
    String store_id;
    String origin_address_id;
    String type;
    String waiting_for_assignment_at;
    String assigned_at;
    String in_delivery_at;
    String completed_at;
    String created_at;
    String last_updated_at;
    double latitude_on_status_change;
    double longitude_on_status_change;
    String user_id;
    String region_id;
    int notified;
    String notified_at;
    int collected;
    String collected_at;
    String cancelled_at;
    String picked_up_at;
    int reassigned;
    int notify_count;
    int delay_notify_count;
    int cancel_notified;
    String cancel_notified_at;
    int assignment_trial_count;
    int cant_deliver;
    int company_id;
    String embedded_container_info;
    int estimated_collection_time;
    double volume;
    long volume_v2;
    int weight;
    String delivery_date;
    int pos_device_needed;
    int outside_polygon;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getArrival_for_delivery_at() {
        return arrival_for_delivery_at;
    }

    public void setArrival_for_delivery_at(String arrival_for_delivery_at) {
        this.arrival_for_delivery_at = arrival_for_delivery_at;
    }

    public String getArrival_for_pickup_at() {
        return arrival_for_pickup_at;
    }

    public void setArrival_for_pickup_at(String arrival_for_pickup_at) {
        this.arrival_for_pickup_at = arrival_for_pickup_at;
    }

    public String getCancel_reason() {
        return cancel_reason;
    }

    public void setCancel_reason(String cancel_reason) {
        this.cancel_reason = cancel_reason;
    }

    public int getCancelled() {
        return cancelled;
    }

    public void setCancelled(int cancelled) {
        this.cancelled = cancelled;
    }

    public long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }

    public double getOrigin_latitude() {
        return origin_latitude;
    }

    public void setOrigin_latitude(double origin_latitude) {
        this.origin_latitude = origin_latitude;
    }

    public double getOrigin_longitude() {
        return origin_longitude;
    }

    public void setOrigin_longitude(double origin_longitude) {
        this.origin_longitude = origin_longitude;
    }

    public double getDestination_latitude() {
        return destination_latitude;
    }

    public void setDestination_latitude(double destination_latitude) {
        this.destination_latitude = destination_latitude;
    }

    public double getDestination_longitude() {
        return destination_longitude;
    }

    public void setDestination_longitude(double destination_longitude) {
        this.destination_longitude = destination_longitude;
    }

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public String getAdditional_order_ids() {
        return additional_order_ids;
    }

    public void setAdditional_order_ids(String additional_order_ids) {
        this.additional_order_ids = additional_order_ids;
    }

    public long getPre_eta() {
        return pre_eta;
    }

    public void setPre_eta(long pre_eta) {
        this.pre_eta = pre_eta;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public int getEta_for_prep() {
        return eta_for_prep;
    }

    public void setEta_for_prep(int eta_for_prep) {
        this.eta_for_prep = eta_for_prep;
    }

    public int getEta_on_road() {
        return eta_on_road;
    }

    public void setEta_on_road(int eta_on_road) {
        this.eta_on_road = eta_on_road;
    }

    public String getPrevious_status() {
        return previous_status;
    }

    public void setPrevious_status(String previous_status) {
        this.previous_status = previous_status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStore_id() {
        return store_id;
    }

    public void setStore_id(String store_id) {
        this.store_id = store_id;
    }

    public String getOrigin_address_id() {
        return origin_address_id;
    }

    public void setOrigin_address_id(String origin_address_id) {
        this.origin_address_id = origin_address_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWaiting_for_assignment_at() {
        return waiting_for_assignment_at;
    }

    public void setWaiting_for_assignment_at(String waiting_for_assignment_at) {
        this.waiting_for_assignment_at = waiting_for_assignment_at;
    }

    public String getAssigned_at() {
        return assigned_at;
    }

    public void setAssigned_at(String assigned_at) {
        this.assigned_at = assigned_at;
    }

    public String getIn_delivery_at() {
        return in_delivery_at;
    }

    public void setIn_delivery_at(String in_delivery_at) {
        this.in_delivery_at = in_delivery_at;
    }

    public String getCompleted_at() {
        return completed_at;
    }

    public void setCompleted_at(String completed_at) {
        this.completed_at = completed_at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getLast_updated_at() {
        return last_updated_at;
    }

    public void setLast_updated_at(String last_updated_at) {
        this.last_updated_at = last_updated_at;
    }

    public double getLatitude_on_status_change() {
        return latitude_on_status_change;
    }

    public void setLatitude_on_status_change(double latitude_on_status_change) {
        this.latitude_on_status_change = latitude_on_status_change;
    }

    public double getLongitude_on_status_change() {
        return longitude_on_status_change;
    }

    public void setLongitude_on_status_change(double longitude_on_status_change) {
        this.longitude_on_status_change = longitude_on_status_change;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getRegion_id() {
        return region_id;
    }

    public void setRegion_id(String region_id) {
        this.region_id = region_id;
    }

    public int getNotified() {
        return notified;
    }

    public void setNotified(int notified) {
        this.notified = notified;
    }

    public String getNotified_at() {
        return notified_at;
    }

    public void setNotified_at(String notified_at) {
        this.notified_at = notified_at;
    }

    public int getCollected() {
        return collected;
    }

    public void setCollected(int collected) {
        this.collected = collected;
    }

    public String getCollected_at() {
        return collected_at;
    }

    public void setCollected_at(String collected_at) {
        this.collected_at = collected_at;
    }

    public String getCancelled_at() {
        return cancelled_at;
    }

    public void setCancelled_at(String cancelled_at) {
        this.cancelled_at = cancelled_at;
    }

    public String getPicked_up_at() {
        return picked_up_at;
    }

    public void setPicked_up_at(String picked_up_at) {
        this.picked_up_at = picked_up_at;
    }

    public int getReassigned() {
        return reassigned;
    }

    public void setReassigned(int reassigned) {
        this.reassigned = reassigned;
    }

    public int getNotify_count() {
        return notify_count;
    }

    public void setNotify_count(int notify_count) {
        this.notify_count = notify_count;
    }

    public int getDelay_notify_count() {
        return delay_notify_count;
    }

    public void setDelay_notify_count(int delay_notify_count) {
        this.delay_notify_count = delay_notify_count;
    }

    public int getCancel_notified() {
        return cancel_notified;
    }

    public void setCancel_notified(int cancel_notified) {
        this.cancel_notified = cancel_notified;
    }

    public String getCancel_notified_at() {
        return cancel_notified_at;
    }

    public void setCancel_notified_at(String cancel_notified_at) {
        this.cancel_notified_at = cancel_notified_at;
    }

    public int getAssignment_trial_count() {
        return assignment_trial_count;
    }

    public void setAssignment_trial_count(int assignment_trial_count) {
        this.assignment_trial_count = assignment_trial_count;
    }

    public int getCant_deliver() {
        return cant_deliver;
    }

    public void setCant_deliver(int cant_deliver) {
        this.cant_deliver = cant_deliver;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public String getEmbedded_container_info() {
        return embedded_container_info;
    }

    public void setEmbedded_container_info(String embedded_container_info) {
        this.embedded_container_info = embedded_container_info;
    }

    public int getEstimated_collection_time() {
        return estimated_collection_time;
    }

    public void setEstimated_collection_time(int estimated_collection_time) {
        this.estimated_collection_time = estimated_collection_time;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public long getVolume_v2() {
        return volume_v2;
    }

    public void setVolume_v2(long volume_v2) {
        this.volume_v2 = volume_v2;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(String delivery_date) {
        this.delivery_date = delivery_date;
    }

    public int getPos_device_needed() {
        return pos_device_needed;
    }

    public void setPos_device_needed(int pos_device_needed) {
        this.pos_device_needed = pos_device_needed;
    }

    public int getOutside_polygon() {
        return outside_polygon;
    }

    public void setOutside_polygon(int outside_polygon) {
        this.outside_polygon = outside_polygon;
    }
}
