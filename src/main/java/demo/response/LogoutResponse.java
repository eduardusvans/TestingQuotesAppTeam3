package demo.response;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "token",
        "type",
        "id",
        "username",
        "email",
        "saldo",
        "message",
        "status"
})
public class LogoutResponse {

    @JsonProperty("token")
    private Object token;
    @JsonProperty("type")
    private String type;
    @JsonProperty("id")
    private Long id;
    @JsonProperty("username")
    private String username;
    @JsonProperty("email")
    private String email;
    @JsonProperty("saldo")
    private Object saldo;
    @JsonProperty("message")
    private String message;
    @JsonProperty("status")
    private String status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("token")
    public Object getToken() {
        return token;
    }

    @JsonProperty("token")
    public void setToken(Object token) {
        this.token = token;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("saldo")
    public Object getSaldo() {
        return saldo;
    }

    @JsonProperty("saldo")
    public void setSaldo(Object saldo) {
        this.saldo = saldo;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
