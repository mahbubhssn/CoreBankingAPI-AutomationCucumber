package com.mislbd.ababil.integration.test;
import com.mislbd.ababil.integration.test.auth.AuthToken;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import static org.junit.Assert.assertEquals;

/**
 * Created by sanjoy on 10/28/18.
 */

public class NGStepDefsIntegrationTest extends CucumberIntegrationTest {

    private final AuthToken authToken;
    private int responseCode;
    private String errorCode;
    private String accountNumber;
    private String referenceNumber;
    private String contentValue;
    private String operatorId;
    private final IntegrationTestApplication integrationTestApplication;
    private Logger LOG = LoggerFactory.getLogger("NGStepDefsIntegrationTest");

    public NGStepDefsIntegrationTest(AuthToken authToken, IntegrationTestApplication integrationTestApplication) {
        this.authToken = authToken;
        this.integrationTestApplication = integrationTestApplication;
    }

    /* Service Authentication */

    @When("^the user calls auth for token validation$")
    public void the_user_calls_auth_for_token_validation() throws Throwable {
        authToken.doAuth();
    }

    @Then("^the user gets authentication for the service$")
    public void the_user_gets_authentication_for_the_service() throws Throwable {}

    /* Demand Deposit Product */

    @When("^the user makes post call through json file \"([^\"]*)\" with positive data to the service \"([^\"]*)\"$")
    public void the_user_makes_post_call_through_json_file_with_positive_data_to_the_service(String jsonFileName, String restPath) throws Throwable {
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        contentValue = response.getBody().get("content").toString();
        integrationTestApplication.data(contentValue,response.getBody().toString());
        integrationTestApplication.run();
        LOG.info("Response: {}", response.getBody());
    }

    @When("^the user makes post call through json file \"([^\"]*)\" with negative data to the service \"([^\"]*)\"$")
    public void the_user_makes_post_call_through_json_file_with_negative_data_to_the_service(String jsonFileName, String restPath) throws Throwable {
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    @When("^the user makes put call through json file \"([^\"]*)\" to the service \"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_put_call_through_json_file_to_the_service(String jsonFileName, String preRestPath, String id) throws Throwable {
        id = contentValue;
        updateJSON("id",id,jsonFileName);
        String restPath = preRestPath+id;
        ResponseEntity<JSONObject> response = executePut(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    /* Demand Deposit Product Configuration */

    @When("^the user makes post call for configuration through json file \"([^\"]*)\" to the service \"([^\"]*)\"$")
    public void the_user_makes_post_call_for_configuration_through_json_file_to_the_service(String jsonFileName, String restPath) throws Throwable {
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        contentValue = response.getBody().get("content").toString();
        LOG.info("Response: {}", response.getBody());
    }

    /* Deposit Product Profit Rate */

    @When("^post call to config demand deposit product profit rate through json file \"([^\"]*)\" with positive data to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void post_call_to_config_demand_deposit_product_profit_rate_through_json_file_with_positive_data_to_the_service(String jsonFileName, String preRestPath, String demandDepositProductID, String postRestPath) throws Throwable {
        demandDepositProductID = Integer.toString(getID(2));
        updateJSON("productId",demandDepositProductID,jsonFileName);
        updateDateTime(jsonFileName,"fromDate","endDate");
        String restPath = preRestPath+demandDepositProductID+postRestPath;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    @When("^post call to config fixed deposit product profit rate through json file \"([^\"]*)\" with positive data to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void post_call_to_config_fixed_deposit_product_profit_rate_through_json_file_with_positive_data_to_the_service(String jsonFileName, String preRestPath, String fixedDepositProductID, String postRestPath) throws Throwable {
        fixedDepositProductID = Integer.toString(getID(6));
        updateJSON("productId",fixedDepositProductID,jsonFileName);
        updateDateTime(jsonFileName,"fromDate","endDate");
        String restPath = preRestPath+fixedDepositProductID+postRestPath;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    @When("^post call to config installment deposit product profit rate through json file \"([^\"]*)\" with positive data to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void post_call_to_config_installment_deposit_product_profit_rate_through_json_file_with_positive_data_to_the_service(String jsonFileName, String preRestPath, String demandDepositProductID, String postRestPath) throws Throwable {
        demandDepositProductID = Integer.toString(getID(12));
        updateJSON("productId",demandDepositProductID,jsonFileName);
        updateDateTime(jsonFileName,"fromDate","endDate");
        String restPath = preRestPath+demandDepositProductID+postRestPath;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    @When("^post call to config profit rate through json file \"([^\"]*)\" with negative data to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void post_call_to_config_profit_rate_through_json_file_with_negative_data_to_the_service(String jsonFileName, String preRestPath, String id, String postRestPath) throws Throwable {
        id = contentValue;
        updateJSON("productId",id,jsonFileName);
        updateDateTime(jsonFileName,"fromDate","endDate");
        String restPath = preRestPath+id+postRestPath;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    /* Demand Deposit Product Cheque Prefix  */

    @When("^post call to config cheque prefix through json file \"([^\"]*)\" with positive data to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void post_call_to_config_cheque_prefix_through_json_file_with_positive_data_to_the_service(String jsonFileName, String preRestPath, String productID, String postRestPath) throws Throwable {
        productID = Integer.toString(getID(2));
        updateJSON("demandDepositProductId",productID,jsonFileName);
        String restPath = preRestPath+productID+postRestPath;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    @When("^post call to config cheque prefix through json file \"([^\"]*)\" with negative data to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void post_call_to_config_cheque_prefix_through_json_file_with_negative_data_to_the_service(String jsonFileName, String preRestPath, String id, String postRestPath) throws Throwable {
        id = contentValue;
        updateJSON("demandDepositProductId",id,jsonFileName);
        String restPath = preRestPath+id+postRestPath;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    /* Demand Deposit Product Cheque Book Size  */

    @When("^post call to config cheque book size through json file \"([^\"]*)\" with positive data to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void post_call_to_config_cheque_book_size_through_json_file_with_positive_data_to_the_service(String jsonFileName, String preRestPath, String productID, String postRestPath) throws Throwable {
        productID = Integer.toString(getID(2));
        updateJSON("demandDepositProductId",productID,jsonFileName);
        String restPath = preRestPath+productID+postRestPath;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    @When("^post call to config cheque book size through json file \"([^\"]*)\" with negative data to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void post_call_to_config_cheque_book_size_through_json_file_with_negative_data_to_the_service(String jsonFileName, String preRestPath, String id, String postRestPath) throws Throwable {
        updateJSON("demandDepositProductId",contentValue,jsonFileName);
        id = contentValue;
        String restPath = preRestPath+id+postRestPath;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    /* Deposit Product GL configuration  */

    @When("^post call to config demand deposit product GL through json file \"([^\"]*)\" with positive data to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void post_call_to_config_demand_deposit_product_GL_through_json_file_with_positive_data_to_the_service(String jsonFileName, String preRestPath, String productID, String postRestPath) throws Throwable {
        productID = Integer.toString(getID(2));
        updateJSON("productId",productID,jsonFileName);
        String restPath = preRestPath+productID+postRestPath;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    @When("^post call to config fixed deposit product GL through json file \"([^\"]*)\" with positive data to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void post_call_to_config_fixed_deposit_product_GL_through_json_file_with_positive_data_to_the_service(String jsonFileName, String preRestPath, String productID, String postRestPath) throws Throwable {
        productID = Integer.toString(getID(6));
        updateJSON("productId",productID,jsonFileName);
        String restPath = preRestPath+productID+postRestPath;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    @When("^post call to config installment deposit product GL through json file \"([^\"]*)\" with positive data to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void post_call_to_config_installment_deposit_product_GL_through_json_file_with_positive_data_to_the_service(String jsonFileName, String preRestPath, String productID, String postRestPath) throws Throwable {
        productID = Integer.toString(getID(12));
        updateJSON("productId",productID,jsonFileName);
        String restPath = preRestPath+productID+postRestPath;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    @When("^post call to config GL through json file \"([^\"]*)\" with negative data to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void post_call_to_config_GL_through_json_file_with_negative_data_to_the_service(String jsonFileName, String preRestPath, String id, String postRestPath) throws Throwable {
        id = contentValue;
        updateJSON("productId",id,jsonFileName);
        String restPath = preRestPath+id+postRestPath;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    /* Deposit Product Activation */

    @When("^post call to activate demand deposit product through json file \"([^\"]*)\" to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void post_call_to_activate_demand_deposit_product_through_json_file_to_the_service(String jsonFileName, String preRestPath, String id, String postRestPath) throws Throwable {
        String restPath = preRestPath+Integer.toString(getID(2))+postRestPath;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    @When("^post call to activate fixed deposit product through json file \"([^\"]*)\" to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void post_call_to_activate_fixed_deposit_product_through_json_file_to_the_service(String jsonFileName, String preRestPath, String id, String postRestPath) throws Throwable {
        String restPath = preRestPath+Integer.toString(getID(6))+postRestPath;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    @When("^post call to activate installment deposit product through json file \"([^\"]*)\" to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void post_call_to_activate_installment_deposit_product_through_json_file_to_the_service(String jsonFileName, String preRestPath, String id, String postRestPath) throws Throwable {
        String restPath = preRestPath+Integer.toString(getID(12))+postRestPath;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    /* Demand Deposit Account Number */

    @Given("^user makes get call to get demand deposit account number to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void user_makes_get_call_to_get_demand_deposit_account_number_to_the_service(String preRestPath, String productID, String postRestPath, String branchID) throws Throwable {
        productID = Integer.toString(getID(2));
        branchID = Integer.toString(7);
        String url = preRestPath+productID+postRestPath+branchID;
        ResponseEntity<String> response = (ResponseEntity<String>) executeGet(url,String.class);
        responseCode = response.getStatusCodeValue();
        accountNumber = response.getBody().replaceAll("[^0-9]+","");
        integrationTestApplication.data(accountNumber,response.getBody().toString());
        integrationTestApplication.run();
    }

    @Given("^the user makes get call to get demand deposit account number to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_get_call_to_get_demand_deposit_account_number_to_the_service(String preRestPath, String productID, String postRestPath, String branchID) throws Throwable {
        productID = Integer.toString(getID(2));
        branchID = Integer.toString(7);
        String url = preRestPath+productID+postRestPath+branchID;
        ResponseEntity<String> response = (ResponseEntity<String>) executeGet(url,String.class);
        responseCode = response.getStatusCodeValue();
        accountNumber = response.getBody().replaceAll("[^0-9]+","");
        LOG.info("Response: {}", response.getBody());
    }

    /* Demand Deposit Account */

    @When("^the user makes post call to create demand deposit account through json file \"([^\"]*)\" with positive data to the service \"([^\"]*)\"$")
    public void the_user_makes_post_call_to_create_account_through_json_file_with_positive_data_to_the_service(String jsonFileName, String restPath) throws Throwable {
        updateAccount(Integer.toString(getID(2)),accountNumber,jsonFileName);
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        contentValue = response.getBody().get("content").toString();
        integrationTestApplication.data(contentValue,response.getBody().toString());
        integrationTestApplication.run();
        LOG.info("Response: {}", response.getBody());
    }

    @When("^the user makes post call to create demand deposit account through json file \"([^\"]*)\" with negative data to the service \"([^\"]*)\"$")
    public void the_user_makes_post_call_to_create_account_through_json_file_with_negative_data_to_the_service(String jsonFileName, String restPath) throws Throwable {
        updateAccount(Integer.toString(getID(2)),accountNumber,jsonFileName);
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    @When("^the user makes put call to update demand deposit account through json file \"([^\"]*)\" to the service \"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_put_call_to_update_account_through_json_file_to_the_service(String jsonFileName, String preRestPath, String id) throws Throwable {
        updateAccount(Integer.toString(getID(2)),accountNumber,jsonFileName);
        id = contentValue;
        updateJSON("id",id,jsonFileName);
        String restPath = preRestPath+id;
        ResponseEntity<JSONObject> response = executePut(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    /* Demand Deposit Account Nominee */

    @When("^the user makes post call to add nominee through json file \"([^\"]*)\" with positive data to the service \"([^\"]*)\"$")
    public void the_user_makes_post_call_to_add_nominee_through_json_file_with_positive_data_to_the_service(String jsonFileName, String restPath) throws Throwable {
        updateJSON("accountId",Integer.toString(getID(19)),jsonFileName);
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        contentValue = response.getBody().get("content").toString();
        integrationTestApplication.data(contentValue,response.getBody().toString());
        integrationTestApplication.run();
        LOG.info("Response: {}", response.getBody());
    }

    @When("^the user makes post call to add nominee through json file \"([^\"]*)\" with negative data to the service \"([^\"]*)\"$")
    public void the_user_makes_post_call_to_add_nominee_through_json_file_with_negative_data_to_the_service(String jsonFileName, String restPath) throws Throwable {
        updateJSON("accountId",Integer.toString(getID(19)),jsonFileName);
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    @When("^the user makes put call to update nominee through json file \"([^\"]*)\" to the service \"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_put_call_to_update_nominee_through_json_file_to_the_service(String jsonFileName, String preRestPath, String id) throws Throwable {
        id = Integer.toString(getID(22));
        updateJSON("id",id,jsonFileName);
        updateJSON("accountId",Integer.toString(getID(19)),jsonFileName);
        String restPath = preRestPath+id;
        ResponseEntity<JSONObject> response = executePut(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    /* Demand Deposit Account Transaction Profile */

    @When("^the user makes post call to add transaction profile through json file \"([^\"]*)\" with positive data to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_post_call_to_add_transaction_profile_through_json_file_with_positive_data_to_the_service(String jsonFileName, String preRestPath, String accountID, String postRestPath) throws Throwable {
        accountID = Integer.toString(getID(19));
        updateDDAccountId(accountID,jsonFileName);
        String restPath = preRestPath+accountID+postRestPath;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        contentValue = response.getBody().get("content").toString();
        integrationTestApplication.data(contentValue,response.getBody().toString());
        integrationTestApplication.run();
        LOG.info("Response: {}", response.getBody());
    }

    @When("^the user makes post call to add transaction profile through json file \"([^\"]*)\" with negative data to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_post_call_to_add_transaction_profile_through_json_file_with_negative_data_to_the_service(String jsonFileName, String preRestPath, String accountID, String postRestPath) throws Throwable {
        accountID = Integer.toString(getID(19));
        updateDDAccountId(accountID,jsonFileName);
        String restPath = preRestPath+accountID+postRestPath;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    @When("^the user makes put call to update transaction profile through json file \"([^\"]*)\" to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_put_call_to_update_transaction_profile_through_json_file_to_the_service(String jsonFileName, String preRestPath, String accountID, String postRestPath) throws Throwable {
        accountID = Integer.toString(getID(19));
        updateDDAccountId(accountID,jsonFileName);
        String restPath = preRestPath+accountID+postRestPath;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    /* Demand Deposit Account Owner Signature */

    @Given("^the user makes get call to get operator information to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_get_call_to_get_operator_information_to_the_service(String preRestPath, String accountId, String postRestPath) throws Throwable {
        accountId = Integer.toString(getID(19));
        String restPath = preRestPath+accountId+postRestPath;
        ResponseEntity<JSONObject> response = (ResponseEntity<JSONObject>) executeGet(restPath,JSONObject.class);
        responseCode = response.getStatusCodeValue();
        operatorId = response.getBody().get("id").toString();
        LOG.info("Response: {}", response.getBody());
    }

    @When("^the user makes post call to add account owner signature through json file \"([^\"]*)\" with positive data to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_post_call_to_add_account_owner_signature_through_json_file_with_positive_data_to_the_service(String jsonFileName, String preRestPath, String accountID, String path, String operatorID, String postRestPath) throws Throwable {
        operatorID = operatorId;
        accountID = Integer.toString(getID(19));
        updateDateTime(jsonFileName,"dateFrom","dateTo");
        updateJSON("accountOperatorInformationId",operatorID,jsonFileName);
        String restPath = preRestPath+accountID+path+operatorID+postRestPath;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        contentValue = response.getBody().get("content").toString();
        integrationTestApplication.data(contentValue,response.getBody().toString());
        integrationTestApplication.run();
        LOG.info("Response: {}", response.getBody());
    }

    @When("^the user makes post call to add account owner signature through json file \"([^\"]*)\" with negative data to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_post_call_to_add_account_owner_signature_through_json_file_with_negative_data_to_the_service(String jsonFileName, String preRestPath, String accountID, String path, String operatorID, String postRestPath) throws Throwable {
        operatorID = operatorId;
        accountID = Integer.toString(getID(19));
        updateDateTime(jsonFileName,"dateFrom","dateTo");
        updateJSON("accountOperatorInformationId",operatorID,jsonFileName);
        String restPath = preRestPath+accountID+path+operatorID+postRestPath;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    @When("^the user makes put call to update account owner signature through json file \"([^\"]*)\" to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_post_call_to_update_account_owner_signature_through_json_file_to_the_service(String jsonFileName, String preRestPath, String accountID, String path, String operatorID, String postRestPath, String signatoryID) throws Throwable {
        operatorID = operatorId;
        accountID = Integer.toString(getID(19));
        signatoryID = Integer.toString(getID(24));
        updateDateTime(jsonFileName,"dateFrom","dateTo");
        updateJSON("accountOperatorInformationId",operatorID,jsonFileName);
        updateJSON("id",accountID,jsonFileName);
        String restPath = preRestPath+accountID+path+operatorID+postRestPath+signatoryID;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    /* Demand Deposit Account Nominated Signature */

    @When("^the user makes post call to add nominated signature through json file \"([^\"]*)\" with positive data to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_post_call_to_add_nominated_signature_through_json_file_with_positive_data_to_the_service(String jsonFileName, String preRestPath, String accountID, String path, String operatorID, String postRestPath) throws Throwable {
        operatorID = operatorId;
        accountID = Integer.toString(getID(19));
        updateDateTime(jsonFileName,"dateFrom","dateTo");
        updateJSON("accountOperatorInformationId",operatorID,jsonFileName);
        String restPath = preRestPath+accountID+path+operatorID+postRestPath;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        contentValue = response.getBody().get("content").toString();
        integrationTestApplication.data(contentValue,response.getBody().toString());
        integrationTestApplication.run();
        LOG.info("Response: {}", response.getBody());
    }

    @When("^the user makes post call to add nominated signature through json file \"([^\"]*)\" with negative data to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_post_call_to_add_nominated_signature_through_json_file_with_negative_data_to_the_service(String jsonFileName, String preRestPath, String accountID, String path, String operatorID, String postRestPath) throws Throwable {
        operatorID = operatorId;
        accountID = Integer.toString(getID(19));
        updateDateTime(jsonFileName,"dateFrom","dateTo");
        updateJSON("accountOperatorInformationId",operatorID,jsonFileName);
        String restPath = preRestPath+accountID+path+operatorID+postRestPath;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    @When("^the user makes put call to update nominated signature through json file \"([^\"]*)\" to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_post_call_to_update_nominated_signature_through_json_file_to_the_service(String jsonFileName, String preRestPath, String accountID, String path, String operatorID, String postRestPath, String signatoryID) throws Throwable {
        operatorID = operatorId;
        accountID = Integer.toString(getID(19));
        signatoryID = Integer.toString(getID(25));
        updateDateTime(jsonFileName,"dateFrom","dateTo");
        updateJSON("accountOperatorInformationId",operatorID,jsonFileName);
        updateJSON("id",accountID,jsonFileName);
        String restPath = preRestPath+accountID+path+operatorID+postRestPath+signatoryID;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    /* Demand Deposit Account Activation */

    @When("^the user makes post call for demand deposit account activation through json file \"([^\"]*)\" to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_post_call_for_demand_deposit_account_activation_through_json_file_to_the_service(String jsonFileName, String preRestPath, String accountID, String postRestPath) throws Throwable {
        accountID = Integer.toString(getID(19));
        updateJSON("accountId",accountID,jsonFileName);
        String restPath = preRestPath+accountID+postRestPath;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    /* Demand Deposit Account Cheque */

    @When("^the user makes post call to add cheque through json file \"([^\"]*)\" with positive data to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_post_call_to_add_cheque_through_json_file_with_positive_data_to_the_service(String jsonFileName, String preRestPath, String accountID, String postRestPath) throws Throwable {
        accountID = Integer.toString(getID(19));
        updateJSON("accountId",accountID,jsonFileName);
        String restPath = preRestPath+accountID+postRestPath;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    @When("^the user makes post call to add cheque through json file \"([^\"]*)\" with negative data to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_post_call_to_add_cheque_through_json_file_with_negative_data_to_the_service(String jsonFileName, String preRestPath, String accountID, String postRestPath) throws Throwable {
        accountID = Integer.toString(getID(19));
        updateJSON("accountId",accountID,jsonFileName);
        String restPath = preRestPath+accountID+postRestPath;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    /* Demand Deposit Account KYC */

    @When("^the user makes post call to add kyc through json file \"([^\"]*)\" to the service \"([^\"]*)\"$")
    public void the_user_makes_post_call_to_add_kyc_through_json_file_to_the_service(String jsonFileName, String restPath) throws Throwable {
        updateJSON("accountNumber", "\""+Integer.toString(getID(18))+"\"",jsonFileName);
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        contentValue = response.getBody().get("content").toString();
        integrationTestApplication.data(contentValue,response.getBody().toString());
        integrationTestApplication.run();
        LOG.info("Response: {}", response.getBody());
    }

    @When("^the user makes put call to update kyc through json file \"([^\"]*)\" to the service \"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_put_call_to_update_kyc_through_json_file_to_the_service(String jsonFileName, String path, String kycID) throws Throwable {
        kycID = Integer.toString(getID(26));
        updateJSON("id",kycID,jsonFileName);
        updateJSON("accountNumber", "\""+Integer.toString(getID(18))+"\"",jsonFileName);
        String restPath = path+kycID;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    /* Demand Deposit Account Bank Notice */

    @When("^the user makes post call to add bank notice through json file \"([^\"]*)\" with positive data to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_post_call_to_add_bank_notice_through_json_file_with_positive_data_to_the_service(String jsonFileName, String preRestPath, String accountID, String postRestPath) throws Throwable {
        accountID = Integer.toString(getID(19));
        updateDate(jsonFileName, "startDate","expireDate");
        updateJSON("demandDepositAccountId",accountID,jsonFileName);
        String restPath = preRestPath+accountID+postRestPath;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        contentValue = response.getBody().get("content").toString();
        integrationTestApplication.data(contentValue,response.getBody().toString());
        integrationTestApplication.run();
        LOG.info("Response: {}", response.getBody());
    }

    @When("^the user makes post call to add bank notice through json file \"([^\"]*)\" with negative data to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_post_call_to_add_bank_notice_through_json_file_with_negative_data_to_the_service(String jsonFileName, String preRestPath, String accountID, String postRestPath) throws Throwable {
        accountID = Integer.toString(getID(19));
        updateDate(jsonFileName, "startDate","expireDate");
        updateJSON("demandDepositAccountId",accountID,jsonFileName);
        String restPath = preRestPath+accountID+postRestPath;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    @When("^the user makes put call to update bank notice through json file \"([^\"]*)\" to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_put_call_to_update_bank_notice_through_json_file_to_the_service(String jsonFileName, String preRestPath, String accountID, String postRestPath, String noticeID) throws Throwable {
        accountID = Integer.toString(getID(19));
        noticeID = Integer.toString(getID(27));
        updateDate(jsonFileName, "startDate","expireDate");
        updateJSON("demandDepositAccountId",accountID,jsonFileName);
        String restPath = preRestPath+accountID+postRestPath+noticeID;
        ResponseEntity<JSONObject> response = executePut(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    /* Demand Deposit Account Special Instruction */

    @When("^the user makes post call to add special instruction through json file \"([^\"]*)\" with positive data to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_post_call_to_add_special_instruction_through_json_file_with_positive_data_to_the_service(String jsonFileName, String preRestPath, String accountID, String postRestPath) throws Throwable {
        accountID = Integer.toString(getID(19));
        updateJSON("demandDepositAccountId",accountID,jsonFileName);
        String restPath = preRestPath+accountID+postRestPath;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        contentValue = response.getBody().get("content").toString();
        integrationTestApplication.data(contentValue,response.getBody().toString());
        integrationTestApplication.run();
        LOG.info("Response: {}", response.getBody());
    }

    @When("^the user makes post call to withdraw special instruction through json file \"([^\"]*)\" to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_post_call_to_withdraw_special_instruction_through_json_file_to_the_service(String jsonFileName, String preRestPath, String accountID, String path, String noticeID, String postRestPath) throws Throwable {
        accountID = Integer.toString(getID(19));
        noticeID = Integer.toString(getID(28));
        String restPath = preRestPath+accountID+path+noticeID+postRestPath;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    @When("^the user makes post call to add special instruction through json file \"([^\"]*)\" with negative data to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_post_call_to_add_special_instruction_through_json_file_with_negative_data_to_the_service(String jsonFileName, String preRestPath, String accountID, String postRestPath) throws Throwable {
        accountID = Integer.toString(getID(19));
        updateJSON("demandDepositAccountId",accountID,jsonFileName);
        String restPath = preRestPath+accountID+postRestPath;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    /* Demand Deposit Account Special Profit Rate */

    @When("^the user makes post call to add special profit rate through json file \"([^\"]*)\" with positive data to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_post_call_to_add_special_profit_rate_through_json_file_with_positive_data_to_the_service(String jsonFileName, String preRestPath, String accountID, String postRestPath) throws Throwable {
        accountID = Integer.toString(getID(19));
        updateJSON("accountId",accountID,jsonFileName);
        String restPath = preRestPath+accountID+postRestPath;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        contentValue = response.getBody().get("content").toString();
        integrationTestApplication.data(contentValue,response.getBody().toString());
        integrationTestApplication.run();
        LOG.info("Response: {}", response.getBody());
    }

    @When("^the user makes post call to add special profit rate through json file \"([^\"]*)\" with negative data to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_post_call_to_add_special_profit_rate_through_json_file_with_negative_data_to_the_service(String jsonFileName, String preRestPath, String accountID, String postRestPath) throws Throwable {
        accountID = Integer.toString(getID(19));
        updateJSON("accountId",accountID,jsonFileName);
        String restPath = preRestPath+accountID+postRestPath;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    @When("^the user makes put call to update special profit rate through json file \"([^\"]*)\" to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_put_call_to_update_special_profit_rate_through_json_file_to_the_service(String jsonFileName, String preRestPath, String accountID, String postRestPath, String id) throws Throwable {
        accountID = Integer.toString(getID(19));
        id = Integer.toString(getID(29));
        updateJSON("accountId",accountID,jsonFileName);
        updateJSON("id",id,jsonFileName);
        String restPath = preRestPath+accountID+postRestPath+id;
        ResponseEntity<JSONObject> response = executePut(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    /* Demand Deposit Account Minimum Balance */

    @When("^the user makes put call to update minimum balance through json file \"([^\"]*)\" to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_put_call_to_update_minimum_balance_through_json_file_to_the_service(String jsonFileName, String preRestPath, String accountID, String postRestPath) throws Throwable {
        accountID = Integer.toString(getID(19));
        String restPath = preRestPath+accountID+postRestPath;
        ResponseEntity<JSONObject> response = executePut(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    /* Demand Deposit Account Freeze Unfreeze */

    @When("^the user makes post call to freeze account through json file \"([^\"]*)\" to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_post_call_to_freeze_account_through_json_file_to_the_service(String jsonFileName, String preRestPath, String accountID, String postRestPath) throws Throwable {
        accountID = Integer.toString(getID(19));
        String restPath = preRestPath+accountID+postRestPath;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    @When("^the user makes post call to unfreeze account through json file \"([^\"]*)\" to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_post_call_to_unfreeze_account_through_json_file_to_the_service(String jsonFileName, String preRestPath, String accountID, String postRestPath) throws Throwable {
        accountID = Integer.toString(getID(19));
        String restPath = preRestPath+accountID+postRestPath;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    /* Fixed Deposit Account Number */

    @Given("^user makes get call to get fixed deposit account number to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void user_makes_get_call_to_get_fixed_deposit_account_number_to_the_service(String preRestPath, String productID, String postRestPath, String branchID) throws Throwable {
        productID = Integer.toString(getID(6));
        branchID = Integer.toString(7);
        String url = preRestPath+productID+postRestPath+branchID;
        ResponseEntity<String> response = (ResponseEntity<String>) executeGet(url,String.class);
        responseCode = response.getStatusCodeValue();
        accountNumber = response.getBody().replaceAll("[^0-9]+","");
        integrationTestApplication.data(accountNumber,response.getBody().toString());
        integrationTestApplication.run();
        LOG.info("Response: {}", response.getBody());
    }

    @Given("^the user makes get call to get fixed deposit account number to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_get_call_to_get_fixed_deposit_account_number_to_the_service(String preRestPath, String productID, String postRestPath, String branchID) throws Throwable {
        productID = Integer.toString(getID(6));
        branchID = Integer.toString(7);
        String url = preRestPath+productID+postRestPath+branchID;
        ResponseEntity<String> response = (ResponseEntity<String>) executeGet(url,String.class);
        responseCode = response.getStatusCodeValue();
        accountNumber = response.getBody().replaceAll("[^0-9]+","");
        LOG.info("Response: {}", response.getBody());
    }

    /* Fixed Deposit Account */

    @When("^the user makes post call to create fixed deposit account through json file \"([^\"]*)\" with positive data to the service \"([^\"]*)\"$")
    public void the_user_makes_post_call_to_create_fixed_deposit_account_through_json_file_with_positive_data_to_the_service(String jsonFileName, String restPath) throws Throwable {
        updateAccount(Integer.toString(getID(6)),accountNumber,jsonFileName);
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        contentValue = response.getBody().get("content").toString();
        integrationTestApplication.data(contentValue,response.getBody().toString());
        integrationTestApplication.run();
        LOG.info("Response: {}", response.getBody());
    }

    @When("^the user makes post call to create fixed deposit account through json file \"([^\"]*)\" with negative data to the service \"([^\"]*)\"$")
    public void the_user_makes_post_call_to_create_fixed_deposit_account_through_json_file_with_negative_data_to_the_service(String jsonFileName, String restPath) throws Throwable {
        updateAccount(Integer.toString(getID(6)),accountNumber,jsonFileName);
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    @When("^the user makes put call to update fixed deposit account through json file \"([^\"]*)\" to the service \"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_put_call_to_update_fixed_deposit_account_through_json_file_to_the_service(String jsonFileName, String preRestPath, String id) throws Throwable {
        updateAccount(Integer.toString(getID(6)),accountNumber,jsonFileName);
        id = contentValue;
        updateJSON("id",id,jsonFileName);
        String restPath = preRestPath+id;
        ResponseEntity<JSONObject> response = executePut(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    /* Fixed Deposit Account Nominee */

    @When("^the user makes post call to add nominee into fixed deposit account through json file \"([^\"]*)\" with positive data to the service \"([^\"]*)\"$")
    public void the_user_makes_post_call_to_add_nominee_into_fixed_deposit_account_through_json_file_with_positive_data_to_the_service(String jsonFileName, String restPath) throws Throwable {
        updateJSON("accountId",Integer.toString(getID(31)),jsonFileName);
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        contentValue = response.getBody().get("content").toString();
        integrationTestApplication.data(contentValue,response.getBody().toString());
        integrationTestApplication.run();
        LOG.info("Response: {}", response.getBody());
    }

    @When("^the user makes post call to add nominee into fixed deposit account through json file \"([^\"]*)\" with negative data to the service \"([^\"]*)\"$")
    public void the_user_makes_post_call_to_add_nominee_into_fixed_deposit_account_through_json_file_with_negative_data_to_the_service(String jsonFileName, String restPath) throws Throwable {
        updateJSON("accountId",Integer.toString(getID(31)),jsonFileName);
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    @When("^the user makes put call to update nominee into fixed deposit account through json file \"([^\"]*)\" to the service \"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_put_call_to_update_nominee_into_fixed_deposit_account_through_json_file_to_the_service(String jsonFileName, String preRestPath, String nomineeID) throws Throwable {
        nomineeID = Integer.toString(getID(34));
        updateJSON("id",nomineeID,jsonFileName);
        updateJSON("accountId",Integer.toString(getID(31)),jsonFileName);
        String restPath = preRestPath+nomineeID;
        ResponseEntity<JSONObject> response = executePut(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    /* Fixed Deposit Account Owner Signature */

    @Given("^the user makes get call to get fixed deposit account operator information to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_get_call_to_get_fixed_deposit_account_operator_information_to_the_service(String preRestPath, String accountId, String postRestPath) throws Throwable {
        accountId = Integer.toString(getID(31));
        String restPath = preRestPath+accountId+postRestPath;
        ResponseEntity<JSONObject> response = (ResponseEntity<JSONObject>) executeGet(restPath,JSONObject.class);
        responseCode = response.getStatusCodeValue();
        operatorId = response.getBody().get("id").toString();
    }

    @When("^the user makes post call to add fixed deposit account owner signature through json file \"([^\"]*)\" with positive data to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_post_call_to_add_fixed_deposit_account_owner_signature_through_json_file_with_positive_data_to_the_service(String jsonFileName, String preRestPath, String accountID, String path, String operatorID, String postRestPath) throws Throwable {
        operatorID = operatorId;
        accountID = Integer.toString(getID(31));
        updateDateTime(jsonFileName,"dateFrom","dateTo");
        updateJSON("accountOperatorInformationId",operatorID,jsonFileName);
        String restPath = preRestPath+accountID+path+operatorID+postRestPath;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        contentValue = response.getBody().get("content").toString();
        integrationTestApplication.data(contentValue,response.getBody().toString());
        integrationTestApplication.run();
        LOG.info("Response: {}", response.getBody());
    }

    @When("^the user makes post call to add fixed deposit account owner signature through json file \"([^\"]*)\" with negative data to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_post_call_to_add_fixed_deposit_account_owner_signature_through_json_file_with_negative_data_to_the_service(String jsonFileName, String preRestPath, String accountID, String path, String operatorID, String postRestPath) throws Throwable {
        operatorID = operatorId;
        accountID = Integer.toString(getID(31));
        updateDateTime(jsonFileName,"dateFrom","dateTo");
        updateJSON("accountOperatorInformationId",operatorID,jsonFileName);
        String restPath = preRestPath+accountID+path+operatorID+postRestPath;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    @When("^the user makes put call to update fixed deposit account owner signature through json file \"([^\"]*)\" to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_post_call_to_update_fixed_deposit_account_owner_signature_through_json_file_to_the_service(String jsonFileName, String preRestPath, String accountID, String path, String operatorID, String postRestPath, String signatoryID) throws Throwable {
        operatorID = operatorId;
        accountID = Integer.toString(getID(31));
        signatoryID = Integer.toString(getID(35));
        updateDateTime(jsonFileName,"dateFrom","dateTo");
        updateJSON("accountOperatorInformationId",operatorID,jsonFileName);
        updateJSON("id",accountID,jsonFileName);
        String restPath = preRestPath+accountID+path+operatorID+postRestPath+signatoryID;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    /* Fixed Deposit Account Nominated Signature */

    @When("^the user makes post call to add fixed deposit account nominated signature through json file \"([^\"]*)\" with positive data to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_post_call_to_add_fixed_deposit_account_nominated_signature_through_json_file_with_positive_data_to_the_service(String jsonFileName, String preRestPath, String accountID, String path, String operatorID, String postRestPath) throws Throwable {
        operatorID = operatorId;
        accountID = Integer.toString(getID(19));
        updateDateTime(jsonFileName,"dateFrom","dateTo");
        updateJSON("accountOperatorInformationId",operatorID,jsonFileName);
        String restPath = preRestPath+accountID+path+operatorID+postRestPath;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        contentValue = response.getBody().get("content").toString();
        integrationTestApplication.data(contentValue,response.getBody().toString());
        integrationTestApplication.run();
        LOG.info("Response: {}", response.getBody());
    }

    @When("^the user makes post call to add fixed deposit account nominated signature through json file \"([^\"]*)\" with negative data to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_post_call_to_add_fixed_deposit_account_nominated_signature_through_json_file_with_negative_data_to_the_service(String jsonFileName, String preRestPath, String accountID, String path, String operatorID, String postRestPath) throws Throwable {
        operatorID = operatorId;
        accountID = Integer.toString(getID(19));
        updateDateTime(jsonFileName,"dateFrom","dateTo");
        updateJSON("accountOperatorInformationId",operatorID,jsonFileName);
        String restPath = preRestPath+accountID+path+operatorID+postRestPath;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    @When("^the user makes put call to update fixed deposit account nominated signature through json file \"([^\"]*)\" to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_post_call_to_update_fixed_deposit_account_nominated_signature_through_json_file_to_the_service(String jsonFileName, String preRestPath, String accountID, String path, String operatorID, String postRestPath, String signatoryID) throws Throwable {
        operatorID = operatorId;
        accountID = Integer.toString(getID(19));
        signatoryID = Integer.toString(getID(36));
        updateDateTime(jsonFileName,"dateFrom","dateTo");
        updateJSON("accountOperatorInformationId",operatorID,jsonFileName);
        updateJSON("id",accountID,jsonFileName);
        String restPath = preRestPath+accountID+path+operatorID+postRestPath+signatoryID;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    /* Fixed Deposit Account KYC */

    @When("^the user makes post call to add kyc into fixed deposit account through json file \"([^\"]*)\" to the service \"([^\"]*)\"$")
    public void the_user_makes_post_call_to_add_kyc_into_fixed_deposit_account_through_json_file_to_the_service(String jsonFileName, String restPath) throws Throwable {
        updateJSON("accountNumber", "\""+Integer.toString(getID(30))+"\"",jsonFileName);
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        contentValue = response.getBody().get("content").toString();
        integrationTestApplication.data(contentValue,response.getBody().toString());
        integrationTestApplication.run();
        LOG.info("Response: {}", response.getBody());
    }

    @When("^the user makes put call to update kyc into fixed deposit account through json file \"([^\"]*)\" to the service \"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_put_call_to_update_kyc_into_fixed_deposit_account_through_json_file_to_the_service(String jsonFileName, String path, String kycID) throws Throwable {
        kycID = Integer.toString(getID(37));
        updateJSON("id",kycID,jsonFileName);
        updateJSON("accountNumber", "\""+Integer.toString(getID(30))+"\"",jsonFileName);
        String restPath = path+kycID;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    /* Fixed Deposit Account Activation */

    @When("^the user makes post call for fixed deposit account activation through json file \"([^\"]*)\" to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_post_call_for_fixed_deposit_account_activation_through_json_file_to_the_service(String jsonFileName, String preRestPath, String accountID, String postRestPath) throws Throwable {
        accountID = Integer.toString(getID(31));
        updateJSON("accountId",accountID,jsonFileName);
        String restPath = preRestPath+accountID+postRestPath;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    /* Fixed Deposit Account Special Profit Rate */

    @When("^the user makes post call to add special profit rate into fixed deposit account through json file \"([^\"]*)\" with positive data to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_post_call_to_add_special_profit_rate_into_fixed_deposit_account_through_json_file_with_positive_data_to_the_service(String jsonFileName, String preRestPath, String accountID, String postRestPath) throws Throwable {
        accountID = Integer.toString(getID(31));
        updateJSON("accountId",accountID,jsonFileName);
        String restPath = preRestPath+accountID+postRestPath;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        contentValue = response.getBody().get("content").toString();
        integrationTestApplication.data(contentValue,response.getBody().toString());
        integrationTestApplication.run();
        LOG.info("Response: {}", response.getBody());
    }

    @When("^the user makes post call to add special profit rate into fixed deposit account through json file \"([^\"]*)\" with negative data to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_post_call_to_add_special_profit_rate_into_fixed_deposit_account_through_json_file_with_negative_data_to_the_service(String jsonFileName, String preRestPath, String accountID, String postRestPath) throws Throwable {
        accountID = Integer.toString(getID(31));
        updateJSON("accountId",accountID,jsonFileName);
        String restPath = preRestPath+accountID+postRestPath;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    @When("^the user makes put call to update special profit rate into fixed deposit account through json file \"([^\"]*)\" to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_put_call_to_update_special_profit_rate_into_fixed_deposit_account_through_json_file_to_the_service(String jsonFileName, String preRestPath, String accountID, String postRestPath, String id) throws Throwable {
        accountID = Integer.toString(getID(31));
        id = Integer.toString(getID(29));
        updateJSON("accountId",accountID,jsonFileName);
        updateJSON("id",id,jsonFileName);
        String restPath = preRestPath+accountID+postRestPath+id;
        ResponseEntity<JSONObject> response = executePut(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    /* Fixed Deposit Account Withdrawal Advice */

    @Given("^the user makes get call to get fixed deposit withdrawal advice reference number to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_get_call_to_get_demand_deposit_account_number_to_the_service(String preRestPath, String accountID, String postRestPath) throws Throwable {
        accountID = Integer.toString(getID(31));
        String url = preRestPath+accountID+postRestPath;
        ResponseEntity<String> response = (ResponseEntity<String>) executeGet(url,String.class);
        responseCode = response.getStatusCodeValue();
        referenceNumber = response.getBody().replace("\"","");
        LOG.info("Response: {}", response.getBody());
    }

    @When("^the user makes post call to add withdrawal advice through json file \"([^\"]*)\" with negative data to the service \"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_post_call_to_add_withdrawal_advice_with_negative_data_through_json_file_to_the_service(String jsonFileName, String path, String fixedDepositAccountID) throws Throwable {
        fixedDepositAccountID = Integer.toString(getID(31));
        updateJSON("fixedDepositAccount",fixedDepositAccountID,jsonFileName);
        String restPath = path+fixedDepositAccountID;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    @When("^the user makes post call to add withdrawal advice through json file \"([^\"]*)\" with positive data to the service \"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_post_call_to_add_withdrawal_advice_with_positive_data_through_json_file_to_the_service(String jsonFileName, String path, String fixedDepositAccountID) throws Throwable {
        fixedDepositAccountID = Integer.toString(getID(31));
        updateJSON("fixedDepositAccount","\""+fixedDepositAccountID+"\"",jsonFileName);
        updateJSON("depositAccountId",Integer.toString(getID(19)),jsonFileName);
        updateJSON("referenceNumber","\""+referenceNumber+"\"",jsonFileName);
        updateDateAndTime("expiryDate",jsonFileName);
        String restPath = path+fixedDepositAccountID;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    /* Installment Deposit Account Number */

    @Given("^user makes get call to get installment deposit account number to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void user_makes_get_call_to_get_installment_deposit_account_number_to_the_service(String preRestPath, String productID, String postRestPath, String branchID) throws Throwable {
        productID = Integer.toString(getID(12));
        branchID = Integer.toString(7);
        String url = preRestPath+productID+postRestPath+branchID;
        ResponseEntity<String> response = (ResponseEntity<String>) executeGet(url,String.class);
        responseCode = response.getStatusCodeValue();
        accountNumber = response.getBody().replaceAll("[^0-9]+","");
        integrationTestApplication.data(accountNumber,response.getBody().toString());
        integrationTestApplication.run();
        LOG.info("Response: {}", response.getBody());
    }

    @Given("^the user makes get call to get installment deposit account number to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_get_call_to_get_installment_deposit_account_number_to_the_service(String preRestPath, String productID, String postRestPath, String branchID) throws Throwable {
        productID = Integer.toString(getID(12));
        branchID = Integer.toString(7);
        String url = preRestPath+productID+postRestPath+branchID;
        ResponseEntity<String> response = (ResponseEntity<String>) executeGet(url,String.class);
        responseCode = response.getStatusCodeValue();
        accountNumber = response.getBody().replaceAll("[^0-9]+","");
        LOG.info("Response: {}", response.getBody());
    }

    /* Installment Deposit Account */

    @When("^the user makes post call to create installment deposit account through json file \"([^\"]*)\" with positive data to the service \"([^\"]*)\"$")
    public void the_user_makes_post_call_to_create_installment_deposit_account_through_json_file_with_positive_data_to_the_service(String jsonFileName, String restPath) throws Throwable {
        updateAccount(Integer.toString(getID(12)),accountNumber,jsonFileName);
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        contentValue = response.getBody().get("content").toString();
        integrationTestApplication.data(contentValue,response.getBody().toString());
        integrationTestApplication.run();
        LOG.info("Response: {}", response.getBody());
    }

    @When("^the user makes post call to create installment deposit account through json file \"([^\"]*)\" with negative data to the service \"([^\"]*)\"$")
    public void the_user_makes_post_call_to_create_installment_deposit_account_through_json_file_with_negative_data_to_the_service(String jsonFileName, String restPath) throws Throwable {
        updateAccount(Integer.toString(getID(12)),accountNumber,jsonFileName);
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    @When("^the user makes put call to update installment deposit account through json file \"([^\"]*)\" to the service \"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_put_call_to_update_installment_deposit_account_through_json_file_to_the_service(String jsonFileName, String preRestPath, String id) throws Throwable {
        updateAccount(Integer.toString(getID(12)),accountNumber,jsonFileName);
        id = contentValue;
        updateJSON("id",id,jsonFileName);
        String restPath = preRestPath+id;
        ResponseEntity<JSONObject> response = executePut(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    /* Installment Deposit Account Nominee */

    @When("^the user makes post call to add nominee into installment deposit account through json file \"([^\"]*)\" with positive data to the service \"([^\"]*)\"$")
    public void the_user_makes_post_call_to_add_nominee_into_installment_deposit_account_through_json_file_with_positive_data_to_the_service(String jsonFileName, String restPath) throws Throwable {
        updateJSON("accountId",Integer.toString(getID(40)),jsonFileName);
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        contentValue = response.getBody().get("content").toString();
        integrationTestApplication.data(contentValue,response.getBody().toString());
        integrationTestApplication.run();
        LOG.info("Response: {}", response.getBody());
    }

    @When("^the user makes post call to add nominee into installment deposit account through json file \"([^\"]*)\" with negative data to the service \"([^\"]*)\"$")
    public void the_user_makes_post_call_to_add_nominee_into_installment_deposit_account_through_json_file_with_negative_data_to_the_service(String jsonFileName, String restPath) throws Throwable {
        updateJSON("accountId",Integer.toString(getID(40)),jsonFileName);
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    @When("^the user makes put call to update nominee into installment deposit account through json file \"([^\"]*)\" to the service \"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_put_call_to_update_nominee_into_installment_deposit_account_through_json_file_to_the_service(String jsonFileName, String preRestPath, String nomineeID) throws Throwable {
        nomineeID = Integer.toString(getID(43));
        updateJSON("id",nomineeID,jsonFileName);
        updateJSON("accountId",Integer.toString(getID(31)),jsonFileName);
        String restPath = preRestPath+nomineeID;
        ResponseEntity<JSONObject> response = executePut(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    /* Installment Deposit Account Owner Signature */

    @Given("^the user makes get call to get installment deposit account operator information to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_get_call_to_get_installment_deposit_account_operator_information_to_the_service(String preRestPath, String accountId, String postRestPath) throws Throwable {
        accountId = Integer.toString(getID(40));
        String restPath = preRestPath+accountId+postRestPath;
        ResponseEntity<JSONObject> response = (ResponseEntity<JSONObject>) executeGet(restPath,JSONObject.class);
        responseCode = response.getStatusCodeValue();
        operatorId = response.getBody().get("id").toString();
        LOG.info("Response: {}", response.getBody());
    }

    @When("^the user makes post call to add installment deposit account owner signature through json file \"([^\"]*)\" with positive data to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_post_call_to_add_installment_deposit_account_owner_signature_through_json_file_with_positive_data_to_the_service(String jsonFileName, String preRestPath, String accountID, String path, String operatorID, String postRestPath) throws Throwable {
        operatorID = operatorId;
        accountID = Integer.toString(getID(40));
        updateDateTime(jsonFileName,"dateFrom","dateTo");
        updateJSON("accountOperatorInformationId",operatorID,jsonFileName);
        String restPath = preRestPath+accountID+path+operatorID+postRestPath;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        contentValue = response.getBody().get("content").toString();
        integrationTestApplication.data(contentValue,response.getBody().toString());
        integrationTestApplication.run();
        LOG.info("Response: {}", response.getBody());
    }

    @When("^the user makes post call to add installment deposit account owner signature through json file \"([^\"]*)\" with negative data to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_post_call_to_add_installment_deposit_account_owner_signature_through_json_file_with_negative_data_to_the_service(String jsonFileName, String preRestPath, String accountID, String path, String operatorID, String postRestPath) throws Throwable {
        operatorID = operatorId;
        accountID = Integer.toString(getID(40));
        updateDateTime(jsonFileName,"dateFrom","dateTo");
        updateJSON("accountOperatorInformationId",operatorID,jsonFileName);
        String restPath = preRestPath+accountID+path+operatorID+postRestPath;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    @When("^the user makes put call to update installment deposit account owner signature through json file \"([^\"]*)\" to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_post_call_to_update_installment_deposit_account_owner_signature_through_json_file_to_the_service(String jsonFileName, String preRestPath, String accountID, String path, String operatorID, String postRestPath, String signatoryID) throws Throwable {
        operatorID = operatorId;
        accountID = Integer.toString(getID(40));
        signatoryID = Integer.toString(getID(44));
        updateDateTime(jsonFileName,"dateFrom","dateTo");
        updateJSON("accountOperatorInformationId",operatorID,jsonFileName);
        updateJSON("id",accountID,jsonFileName);
        String restPath = preRestPath+accountID+path+operatorID+postRestPath+signatoryID;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    /* Installment Deposit Account Nominated Signature */

    @When("^the user makes post call to add installment deposit account nominated signature through json file \"([^\"]*)\" with positive data to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_post_call_to_add_installment_deposit_account_nominated_signature_through_json_file_with_positive_data_to_the_service(String jsonFileName, String preRestPath, String accountID, String path, String operatorID, String postRestPath) throws Throwable {
        operatorID = operatorId;
        accountID = Integer.toString(getID(40));
        updateDateTime(jsonFileName,"dateFrom","dateTo");
        updateJSON("accountOperatorInformationId",operatorID,jsonFileName);
        String restPath = preRestPath+accountID+path+operatorID+postRestPath;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        contentValue = response.getBody().get("content").toString();
        integrationTestApplication.data(contentValue,response.getBody().toString());
        integrationTestApplication.run();
        LOG.info("Response: {}", response.getBody());
    }

    @When("^the user makes post call to add installment deposit account nominated signature through json file \"([^\"]*)\" with negative data to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_post_call_to_add_installment_deposit_account_nominated_signature_through_json_file_with_negative_data_to_the_service(String jsonFileName, String preRestPath, String accountID, String path, String operatorID, String postRestPath) throws Throwable {
        operatorID = operatorId;
        accountID = Integer.toString(getID(40));
        updateDateTime(jsonFileName,"dateFrom","dateTo");
        updateJSON("accountOperatorInformationId",operatorID,jsonFileName);
        String restPath = preRestPath+accountID+path+operatorID+postRestPath;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    @When("^the user makes put call to update installment deposit account nominated signature through json file \"([^\"]*)\" to the service \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_post_call_to_update_installment_deposit_account_nominated_signature_through_json_file_to_the_service(String jsonFileName, String preRestPath, String accountID, String path, String operatorID, String postRestPath, String signatoryID) throws Throwable {
        operatorID = operatorId;
        accountID = Integer.toString(getID(40));
        signatoryID = Integer.toString(getID(45));
        updateDateTime(jsonFileName,"dateFrom","dateTo");
        updateJSON("accountOperatorInformationId",operatorID,jsonFileName);
        updateJSON("id",accountID,jsonFileName);
        String restPath = preRestPath+accountID+path+operatorID+postRestPath+signatoryID;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    /* Installment Deposit Account KYC */

    @When("^the user makes post call to add kyc into installment deposit account through json file \"([^\"]*)\" to the service \"([^\"]*)\"$")
    public void the_user_makes_post_call_to_add_kyc_into_installment_deposit_account_through_json_file_to_the_service(String jsonFileName, String restPath) throws Throwable {
        updateJSON("accountNumber", "\""+Integer.toString(getID(39))+"\"",jsonFileName);
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        contentValue = response.getBody().get("content").toString();
        integrationTestApplication.data(contentValue,response.getBody().toString());
        integrationTestApplication.run();
        LOG.info("Response: {}", response.getBody());
    }

    @When("^the user makes put call to update kyc into installment deposit account through json file \"([^\"]*)\" to the service \"([^\"]*)\"\"([^\"]*)\"$")
    public void the_user_makes_put_call_to_update_kyc_into_installment_deposit_account_through_json_file_to_the_service(String jsonFileName, String path, String kycID) throws Throwable {
        kycID = Integer.toString(getID(46));
        updateJSON("id",kycID,jsonFileName);
        updateJSON("accountNumber", "\""+Integer.toString(getID(18))+"\"",jsonFileName);
        String restPath = path+kycID;
        ResponseEntity<JSONObject> response = executePost(jsonFileName, restPath);
        responseCode = response.getStatusCodeValue();
        LOG.info("Response: {}", response.getBody());
    }

    /* Status Code */

    @Then("^the user should get status code (\\d+)$")
    public void the_user_should_get_status_code(int expected) throws Throwable {
        assertEquals(expected,responseCode);
    }

    @When("^account name consists of special characters and numeric values$")
    public void account_name_consists_of_special_characters_and_numeric_values() throws Throwable {}

    @When("^the account code is above (\\d+) digits$")
    public void the_account_code_is_above_digits(int arg1) throws Throwable {}

    @When("^the account code is null$")
    public void the_account_code_is_null() throws Throwable {}

    @When("^the account code is same for both accounts$")
    public void the_account_code_is_same_for_both_accounts() throws Throwable {}

    @When("^the account code is not in digits only$")
    public void the_account_code_is_not_in_digits_only() throws Throwable {}

    @When("^the mandatory fields value is null$")
    public void the_mandatory_fields_value_is_null() throws Throwable {}

    @When("^the mandatory fields value is in irrelevant format$")
    public void the_mandatory_fields_value_is_in_irrelevant_format() throws Throwable {}

    @When("^the currency code field value is irrelevant$")
    public void the_currency_code_field_value_is_irrelevant() throws Throwable {}

    @When("^the optional fields format is invalided$")
    public void the_optional_fields_format_is_invalided() throws Throwable {}

    @When("^the share percentage is out of boundary$")
    public void the_share_percentage_is_out_of_boundary() throws Throwable {}

    @When("^all the fields value is in irrelevant format$")
    public void all_the_fields_value_is_in_irrelevant_format() throws Throwable {}


}
