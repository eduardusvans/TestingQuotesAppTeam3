package demo.controller;

import demo.request.LogoutRequest;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UserController {

    private static String url = "https://project-danapprentech-3.herokuapp.com";
    private static String path = "/api/auth";

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
}
