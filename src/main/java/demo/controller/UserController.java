package demo.controller;

import demo.request.LoginRequest;
import demo.request.LogoutRequest;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UserController {

    private static String url = "https://project-danapprentech-3.herokuapp.com";
    private static String path = "/api/auth";

    public static Response postLogin(LoginRequest loginRequest) {
        Response response = RestAssured
                .given()
                .baseUri(url)
                .basePath(path)
                .log()
                .all()
                .header("Content-type", "application/json")
                .header("Accept", "*/*")
                .body(loginRequest)
                .post("/signin");

        return response;
    }

    public static Response postLogout(LogoutRequest logoutRequest) {
        Response response = RestAssured
                .given()
                .baseUri(url)
                .basePath(path)
                .log()
                .all()
                .header("Content-type", "application/json")
                .header("Accept", "*/*")
                .body(logoutRequest)
                .post("/signout");

        return response;
    }

    public static Response getOtp(String phoneNumber) {
        Response response = RestAssured
                .given()
                .baseUri(url)
                .basePath(path)
                .log()
                .all()
                .header("Content-type", "application/json")
                .header("Accept", "*/*")
                .get(String.format("/qa-get-otp/+62%s", phoneNumber));

        return response;
    }

    public static Response deleteUser(String phoneNumber) {
        Response response = RestAssured
                .given()
                .baseUri(url)
                .basePath(path)
                .log()
                .all()
                .delete(String.format("/delete-user/+62%s", phoneNumber));

        return response;
    }

    public static Response getToken(String email) {
        Response response = RestAssured
                .given()
                .baseUri(url)
                .basePath(path)
                .log()
                .all()
                .header("Content-type", "application/json")
                .header("Accept", "*/*")
                .get(String.format("/qa-get-token/%s", email));

        return response;
    }

    public static Response getTokenConfirmation(String token) {
        Response response = RestAssured
                .given()
                .baseUri(url)
                .basePath(path)
                .log()
                .all()
                .header("Content-type", "application/json")
                .header("Accept", "*/*")
                .get(String.format("/confirmation-account/%s", token));

        return response;
    }
}
