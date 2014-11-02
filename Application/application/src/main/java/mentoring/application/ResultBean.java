package mentoring.application;

public class ResultBean {

    private String message;
    
    public ResultBean() {
        this.message = new String();
    }
    
    public ResultBean(String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
