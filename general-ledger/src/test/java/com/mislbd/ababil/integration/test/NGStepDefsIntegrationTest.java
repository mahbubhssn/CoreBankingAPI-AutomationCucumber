package com.mislbd.ababil.integration.test;

import com.mislbd.ababil.integration.test.auth.AuthToken;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;
import static org.junit.Assert.assertEquals;

/**
 * Created by sanjoy on 10/28/18.
 */

public class NGStepDefsIntegrationTest extends CucumberIntegrationTest {

   private final AuthToken authToken;
   private int responseCode;
   private String errorCode;
   private String contentValue;
   private String completeRestPath;

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
        System.out.println(response.getBody());
    }

    @When("^json file \"([^\"]*)\" to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void json_file_to_the_service(String jsonFileName, String preRestPath, String id, String postRestPath) throws Throwable {
        updateJSON(contentValue,jsonFileName);
        id = contentValue;
        completeRestPath = preRestPath+id+postRestPath;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, completeRestPath);
        responseCode = response.getStatusCodeValue();
        //contentValue = response.getBody().get("content").toString();
        System.out.println(response.getBody());
    }

//    @When("^the user makes post call through json file \"([^\"]*)\" to the service \"([^\"]*)\"$")
//    public void the_user_makes_post_call_through_json_file_to_the_service(String jsonFileName, String restPath) throws Throwable {
//        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
//        responseCode = response.getStatusCodeValue();
//        System.out.println(response.getBody());
////        if(responseCode == 500){
////            System.out.println(response.getBody());
////            Gson gson=new Gson();
////            ApiError error=gson.fromJson(response.getBody().toString(),ApiError.class);
////            System.out.println(error.getCode());
////        }
//    }


    @When("^the user makes put call through json file \"([^\"]*)\" to the service \"([^\"]*)\"$")
    public void the_user_makes_put_call_through_json_file_to_the_service(String jsonFileName, String restPath) throws Throwable {
        ResponseEntity<JSONObject> response = executePut(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        System.out.println(response.getBody());
    }

    @Then("^the user should get status code (\\d+)$")
    public void the_user_should_get_status_code(int expected) throws Throwable {
        assertEquals(expected,responseCode);
    }

    @When("^the account code is above (\\d+) digits$")
    public void the_account_code_is_above_digits(int arg1) throws Throwable {}

    @When("^the account code is null$")
    public void the_account_code_is_null() throws Throwable {}

    @When("^the account code is same for both accounts$")
    public void the_account_code_is_same_for_both_accounts() throws Throwable {}

    @When("^the account code is not in digits only$")
    public void the_account_code_is_not_in_digits_only() throws Throwable {}

    @When("^the account name is above (\\d+) characters$")
    public void the_account_name_is_above_characters(int arg1) throws Throwable {}

    @When("^the account name is null$")
    public void the_account_name_is_null() throws Throwable {}

    @When("^the account name is in varchar$")
    public void the_account_name_is_in_varchar() throws Throwable {}

    @When("^the account type is null$")
    public void the_account_type_is_null() throws Throwable {}

    @When("^the account sub type is null$")
    public void the_account_sub_type_is_null() throws Throwable {}

    @When("^the account status is null$")
    public void the_account_status_is_null() throws Throwable {}

    @When("^the transaction scope / branch restriction is null$")
    public void the_transaction_scope_branch_restriction_is_null() throws Throwable {}

    @When("^the transaction scope is Specific Branch$")
    public void the_transaction_scope_is_Specific_Branch() throws Throwable {}

    @When("^the branches are undefine$")
    public void the_branches_are_undefine() throws Throwable {}

    @When("^the currency type is null$")
    public void the_currency_type_is_null() throws Throwable {}

    @When("^the currency type is specific currencies$")
    public void the_currency_type_is_specific_currencies() throws Throwable {}

    @When("^the currencies are undefined$")
    public void the_currencies_are_undefined() throws Throwable {}

    @When("^send direct posting as false but credit and debit as true$")
    public void send_direct_posting_as_false_but_credit_and_debit_as_true() throws Throwable {}

    @When("^the effective date field value is null$")
    public void the_effective_date_field_value_is_null() throws Throwable {}

    @When("^the effective date field value is past date$")
    public void the_effective_date_field_value_is_past_date() throws Throwable {}

    @When("^the income GL account is null$")
    public void the_income_GL_account_is_null() throws Throwable {}

    @When("^the expense GL account is null$")
    public void the_expense_GL_account_is_null() throws Throwable {}

    @When("^the lending rate field value is null$")
    public void the_lending_rate_field_value_is_null() throws Throwable {}

    @When("^GL negative balance allowed is false$")
    public void gl_negative_balance_allowed_is_false() throws Throwable {}

    @When("^the lending rate field value is negative$")
    public void the_lending_rate_field_value_is_negative() throws Throwable {}

    @When("^the borrowing rate field value is null$")
    public void the_borrowing_rate_field_value_is_null() throws Throwable {}

    @When("^the borrowing rate field value is negative$")
    public void the_borrowing_rate_field_value_is_negative() throws Throwable {}

    @When("^the amount range from field value is null$")
    public void the_amount_range_from_field_value_is_null() throws Throwable {}

    @When("^the amount range from field value is negative$")
    public void the_amount_range_from_field_value_is_negative() throws Throwable {}

    @When("^the amount range to field value is null$")
    public void the_amount_range_to_field_value_is_null() throws Throwable {}

    @When("^the amount range to field value is negative$")
    public void the_amount_range_to_field_value_is_negative() throws Throwable {}

    @When("^the branch field value is null$")
    public void the_branch_field_value_is_null() throws Throwable {}

    @When("^the balance limit field value is null$")
    public void the_balance_limit_field_value_is_null() throws Throwable {}

    @When("^the balance limit field value is negative$")
    public void the_balance_limit_field_value_is_negative() throws Throwable {}

    @When("^monthly limit required field value is true$")
    public void monthly_limit_required_field_value_is_true() throws Throwable {}

    @When("^monthly limit field value is null$")
    public void monthly_limit_field_value_is_null() throws Throwable {}

    @When("^monthly limit field value is negative$")
    public void monthly_limit_field_value_is_negative() throws Throwable {}

    @When("^monthly limit required field value is false$")
    public void monthly_limit_required_field_value_is_false() throws Throwable {}

    @When("^monthly limit field value is defined$")
    public void monthly_limit_field_value_is_defined() throws Throwable {}

    @When("^the name field value is null$")
    public void the_name_field_value_is_null() throws Throwable {}

    @When("^the currency code field value is null$")
    public void the_currency_code_field_value_is_null() throws Throwable {}

    @When("^the code field value is null$")
    public void the_code_field_value_is_null() throws Throwable {}


}
