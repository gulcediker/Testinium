import groovy.transform.PropertyOptions;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static io.restassured.RestAssured.given;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TrelloTest {
    private static String boardId;
    private static String listId;
    private static String cardId1;
    private static String cardId2;


    @Test()
    @Order(1)
    public void BoardCreateTest(){
        JSONObject body = new JSONObject();
        body.put("name","Test Board");
        body.put("key", "6f9195d50c60a364055636490e022506");
        body.put("token","ATTA60fe51b173063041a01caad56706e8d67d52e0a149332df6ef3da1f767aa469a5CDEDBEF");

        Response response = given()
                .when()
                        .contentType(ContentType.JSON)
                                .body(body.toString())
                                        .post("https://api.trello.com/1/boards/");

         boardId = response.path("id").toString();
        System.out.println(boardId);
        response.prettyPrint();

    }
    @Test
    @Order(2)
    public void ListCreate() {

        JSONObject body = new JSONObject();
        body.put("name","This is List");
        body.put("idBoard",boardId);
        body.put("key", "6f9195d50c60a364055636490e022506");
        body.put("token","ATTA60fe51b173063041a01caad56706e8d67d52e0a149332df6ef3da1f767aa469a5CDEDBEF");

        Response response = given()
                .when()
                .contentType(ContentType.JSON)
                .body(body.toString())
                .post("https://api.trello.com/1/lists");
        response.prettyPrint();

        listId = response.path("id").toString();

    }


    @Test
    @Order(3)
    public void CardCreateTest() {

        JSONObject body = new JSONObject();
        body.put("name","This is Card");
        body.put("idList",listId);
        body.put("key", "6f9195d50c60a364055636490e022506");
        body.put("token","ATTA60fe51b173063041a01caad56706e8d67d52e0a149332df6ef3da1f767aa469a5CDEDBEF");

        Response response = given()
                .when()
                .contentType(ContentType.JSON)
                .body(body.toString())
                .post("https://api.trello.com/1/cards");
        response.prettyPrint();
        cardId1 = response.path("id");

    }
    @Test
    @Order(4)
    public void CardCreateTest2() {
        JSONObject body = new JSONObject();
        body.put("name","This is Card2");
        body.put("idList",listId);
        body.put("key", "6f9195d50c60a364055636490e022506");
        body.put("token","ATTA60fe51b173063041a01caad56706e8d67d52e0a149332df6ef3da1f767aa469a5CDEDBEF");

        Response response = given()
                .when()
                .contentType(ContentType.JSON)
                .body(body.toString())
                .post("https://api.trello.com/1/cards");
        response.prettyPrint();

        cardId2 = response.path("id");

    }
    @Test
    @Order(5)
    public void CardUpdateTest(){
        JSONObject body = new JSONObject();
        body.put("name","Update a Card");
      //  body.put("id", cardId1);
        body.put("key", "6f9195d50c60a364055636490e022506");
        body.put("token","ATTA60fe51b173063041a01caad56706e8d67d52e0a149332df6ef3da1f767aa469a5CDEDBEF");

        Response response = given()
                .when()
                .contentType(ContentType.JSON)
                .body(body.toString())
                .pathParams("id", cardId1)
                .put("https://api.trello.com/1/cards/{id}");
        response.prettyPrint();
    }

    @Test
    @Order(6)
    public void DeleteCard(){
        JSONObject body = new JSONObject();
        body.put("key", "6f9195d50c60a364055636490e022506");
        body.put("token","ATTA60fe51b173063041a01caad56706e8d67d52e0a149332df6ef3da1f767aa469a5CDEDBEF");
               Response response = given()
                .when()
                .contentType(ContentType.JSON)
                .body(body.toString())
                .pathParams("id", cardId1)
                .delete("https://api.trello.com/1/cards/{id}");
        response.prettyPrint();
    }

    @Test
    @Order(7)
    public void DeleteCard2(){
        JSONObject body = new JSONObject();
        body.put("key", "6f9195d50c60a364055636490e022506");
        body.put("token","ATTA60fe51b173063041a01caad56706e8d67d52e0a149332df6ef3da1f767aa469a5CDEDBEF");
               Response response = given()
                .when()
                .contentType(ContentType.JSON)
                .body(body.toString())
                .pathParams("id", cardId2)
                .delete("https://api.trello.com/1/cards/{id}");
        response.prettyPrint();
    }

    @Test
    @Order(8)
    public void DeleteBoard(){
        JSONObject body = new JSONObject();
        body.put("key", "6f9195d50c60a364055636490e022506");
        body.put("token","ATTA60fe51b173063041a01caad56706e8d67d52e0a149332df6ef3da1f767aa469a5CDEDBEF");
            Response response = given()
                .when()
                .contentType(ContentType.JSON)
                .body(body.toString())
                .pathParams("id", boardId)
                .delete("https://api.trello.com/1/boards/{id}");
        response.prettyPrint();
    }

}
