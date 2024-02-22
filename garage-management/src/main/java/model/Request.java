package model;

public class Request {
    private int request_id;
    private int bike_id;
    private String description;
    private String status;


    public int getRequest_id() {
        return request_id;
    }

    public void setRequest_id(int request_id) {
        this.request_id = request_id;
    }

    public int getBike_id() {
        return bike_id;
    }

    public void setBike_id(int bike_id) {
        this.bike_id = bike_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Request{" +
                "request_id=" + request_id +
                ", bike_id=" + bike_id +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
