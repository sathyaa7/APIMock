import com.google.gson.Gson;

import static io.restassured.RestAssured.given;

public class API {
    public static void main(String[] args) {
        String url = "";
        System.out.println(given().when().get(url).getBody().asString());
        Pojo pojo = new Pojo();
        pojo.setUserId(11);
        pojo.setId(101);
        pojo.setTitle("SSFHSJ");
        pojo.setBody("DJSDJ");
        given().contentType("application/json").body(new Gson().toJson(pojo)).
                when().post(url).
                then().assertThat().statusCode(201);
        given().contentType("application/json").body(new Gson().toJson(pojo)).
                when().put(url + "/1").
                then().assertThat().statusCode(200);
        Pojo pojoNew = new Pojo();
        pojoNew.setTitle("JDFJFDJ");
        given().contentType("application/json").body(new Gson().toJson(pojoNew)).
                when().patch(url + "/2").
                then().assertThat().statusCode(200);
        given().when().delete(url + "/2").then().assertThat().statusCode(200);
        System.out.println("Basic checks");


    }
}
