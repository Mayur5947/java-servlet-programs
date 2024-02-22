package model;

public class History {
    private int history_id;
    private int request_id;
    private int technician_id;
    private String date;
    private String comments;
    private int part_id;

    
    
    public int getPart_id() {
		return part_id;
	}

	public void setPart_id(int part_id) {
		this.part_id = part_id;
	}

	public int getHistory_id() {
        return history_id;
    }

    public void setHistory_id(int history_id) {
        this.history_id = history_id;
    }

    public int getRequest_id() {
        return request_id;
    }

    public void setRequest_id(int request_id) {
        this.request_id = request_id;
    }

    public int getTechnician_id() {
        return technician_id;
    }

    public void setTechnician_id(int technician_id) {
        this.technician_id = technician_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
	public String toString() {
		return "History [history_id=" + history_id + ", request_id=" + request_id + ", technician_id=" + technician_id
				+ ", date=" + date + ", comments=" + comments + ", part_id=" + part_id + "]";
	}
}
