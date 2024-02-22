package model;

public class Bike {
    private int bike_id;
    private int customer_id;
    private String make;
    private String model;
    private String color;
    private String number_plate;
    private int year;

    
    
    public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public int getBike_id() {
        return bike_id;
    }

    public void setBike_id(int bike_id) {
        this.bike_id = bike_id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNumber_plate() {
        return number_plate;
    }

    public void setNumber_plate(String number_plate) {
        this.number_plate = number_plate;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
	public String toString() {
		return "Bike [bike_id=" + bike_id + ", customer_id=" + customer_id + ", make=" + make + ", model=" + model
				+ ", color=" + color + ", number_plate=" + number_plate + ", year=" + year + "]";
	}
}
