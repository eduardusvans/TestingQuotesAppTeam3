package demo.controller;

import demo.request.LoginRequest;
import demo.request.LogoutRequest;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

public class UserController {

//    private static String url = "http://ec2-18-212-183-157.compute-1.amazonaws.com:9703"; // AWS
    private static String url = "https://project-danapprentech-3.herokuapp.com"; // Heroku
    private static String path = "/api";

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
                .post("/auth/signin");

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
                .post("/auth/signout");

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
                .get(String.format("/auth/qa-get-otp/+62%s", phoneNumber));

        return response;
    }

    public static Response deleteUser(String phoneNumber) {
        Response response = RestAssured
                .given()
                .baseUri(url)
                .basePath(path)
                .log()
                .all()
                .delete(String.format("/auth/delete-user/+62%s", phoneNumber));

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
                .get(String.format("/auth/qa-get-token/%s", email));

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
                .get(String.format("/auth/confirmation-account/%s", token));

        return response;
    }

    public static Response getTransactionHistory(String phoneNumber) {
        Response response = RestAssured
                .given()
                .baseUri(url)
                .basePath(path)
                .log()
                .all()
                .header("Content-type", "application/json")
                .header("Accept", "*/*")
                .get(String.format("/transaksi/history/+62%s", phoneNumber));

        return response;
    }
}
