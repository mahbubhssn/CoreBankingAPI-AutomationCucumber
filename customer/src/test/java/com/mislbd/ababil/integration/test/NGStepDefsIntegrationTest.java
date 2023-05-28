package com.mislbd.ababil.integration.test;

import com.mislbd.ababil.integration.test.auth.AuthToken;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import static org.junit.Assert.assertEquals;

/**
 * Created by sanjoy on 10/28/18.
 */

public class NGStepDefsIntegrationTest extends CucumberIntegrationTest {

    private Logger LOG = LoggerFactory.getLogger("NGStepDefsIntegrationTest");
    private final AuthToken authToken;
    private int responseCode;
    private String errorCode;
    private String contentValue;
    String completeRestPath = null;

    public NGStepDefsIntegrationTest(AuthToken authToken) {
        this.authToken = authToken;
    }

    @When("^the user calls auth for token validation$")
    public void the_user_calls_auth_for_token_validation() throws Throwable {
        authToken.doAuth();
    }

    @Then("^the user gets authentication for the service$")
    public void the_user_gets_authentication_for_the_service() throws Throwable {}

    @When("^the user makes post call through json file \"([^\"]*)\" to the service \"([^\"]*)\"$")
    public void the_user_makes_post_call_through_json_file_to_the_service(String jsonFileName, String restPath) throws Throwable {
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        contentValue = response.getBody().get("content").toString();
        LOG.info("Response Body: {}", response.getBody());
    }

    @When("^the user makes post call through json file \"([^\"]*)\" with negative data to the service \"([^\"]*)\"$")
    public void the_user_makes_post_call_through_json_file_with_negative_data_to_the_service(String jsonFileName, String restPath) throws Throwable {
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response Body: {}", response.getBody());
    }

    @When("^json file \"([^\"]*)\" to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void json_file_to_the_service(String jsonFileName, String preRestPath, String id, String postRestPath) throws Throwable {
        id = contentValue;
        completeRestPath = preRestPath+id+postRestPath;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, completeRestPath);
        responseCode = response.getStatusCodeValue();
        contentValue = response.getBody().get("content").toString();
        LOG.info("Response Body: {}", response.getBody());
    }

    @When("^makes post call through json file \"([^\"]*)\" with negative data to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void makes_post_call_through_json_file_with_negative_data_to_the_service(String jsonFileName, String preRestPath, String id, String postRestPath) throws Throwable {
        //updateJSON(contentValue,jsonFileName);
        id = contentValue;
        completeRestPath = preRestPath+id+postRestPath;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, completeRestPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response Body: {}", response.getBody());
    }

    @When("^post call through json file \"([^\"]*)\" to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void post_call_through_json_file_to_the_service(String jsonFileName, String preRestPath, String id, String postRestPath) throws Throwable {
        id = contentValue;
        String restPath = preRestPath+id+postRestPath;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response Body: {}", response.getBody());
    }

    @When("^the user makes put call through json file \"([^\"]*)\" to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_put_call_through_json_file_to_the_service(String jsonFileName, String preRestPath, String preRestPathId, String postRestPath, String postRestPathId) throws Throwable {
//        contentValue = "795";
        updateJSON(contentValue, jsonFileName);
        updateUUID(getUUID(contentValue),jsonFileName);
        postRestPathId = contentValue;
        String restPath = completeRestPath+"/"+postRestPathId;
        ResponseEntity<JSONObject> response = executePut(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response Body: {}", response.getBody());
    }

    @Then("^the user should get status code (\\d+)$")
    public void the_user_should_get_status_code(int expected) throws Throwable {
        assertEquals(expected,responseCode);
    }

    @When("^the name field value is null$")
    public void the_name_field_value_is_null() throws Throwable {}

    @When("^the name format is not alphabetical$")
    public void the_name_format_is_not_alphabetical() throws Throwable {}

    @When("^the name length is above 50 characters$")
    public void the_name_length_is_above_50_characters() throws Throwable {}

    @When("^the customer type field value is null$")
    public void the_customer_type_field_value_is_null() throws Throwable {}

    @When("^the relationship officer field value is null$")
    public void the_relationship_officer_field_value_is_null() throws Throwable {}

    @When("^all mandatory fields data is null$")
    public void all_the_mandatory_fields_data_is_null() throws Throwable {}

    @When("^all fields data format is invalid$")
    public void all_the_field_data_format_is_invalid() throws Throwable {}

    @When("^all fields data length is invalid$")
    public void all_the_field_data_length_is_invalid() throws Throwable {}

    @When("^all dependent fields data is null$")
    public void all_the_dependent_fields_data_is_null() throws Throwable {}

    @When("^all the independent fields data is null$")
    public void all_the_independent_fields_data_is_null() throws Throwable {}

    @When("^the applicant type field value is null$")
    public void the_applicant_type_field_value_is_null() throws Throwable {}

    @When("^the applicant is out of boundary$")
    public void the_applicant_is_out_of_boundary() throws Throwable {}

    @When("^the applicant type field value is out of boundary$")
    public void the_applicant_type_field_value_is_out_of_boundary() throws Throwable {}

    @When("^the share percentage already covered$")
    public void the_share_percentage_already_covered() throws Throwable {}

}
