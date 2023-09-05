package co.com.neoris.users.domain.exceptions.generic;


import org.springframework.http.HttpStatus;

public class GenericException extends Exception {

    private String code;
    private String description;

    private HttpStatus statusCode;

    public GenericException(String code, String description, HttpStatus statusCode){
        super(new StringBuilder().append("{\"code\"").append(code).append(", \"description\"").append(description).append("}").toString());
        this.code=code;
        this.description=description;
        this.statusCode=statusCode;
    }

    @Override
    public String toString() {
        return "GenericException{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }
}
