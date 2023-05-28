Feature: time deposit product creation and validation
  As a bank user
  I want to create time deposit product as fixed deposit product,installment deposit product and validate those product and also configure their charge.

  #  Fixed Deposit Product Positive Test

  Scenario: For service validation, user wants to create Fixed Deposit Product where all possible field data will be posted
    When the user makes post call through json file "FDP(AllFieldData)" with positive data to the service "/fixed-deposit-products"
    Then the user should get status code 202

  Scenario: For service validation, user wants to create Fixed Deposit Product where all mandatory field data will be posted
    When the user makes post call through json file "FDP(AllMandatoryFieldData)" with positive data to the service "/fixed-deposit-products"
     Then the user should get status code 202

  Scenario: For service validation, user wants to create Fixed Deposit Product where profit posting period is Monthly
    When the user makes post call through json file "FDP(PPP-Monthly)" with positive data to the service "/fixed-deposit-products"
    Then the user should get status code 202

  Scenario: For service validation, user wants to create Fixed Deposit Product where profit posting period is Quarterly
    When the user makes post call through json file "FDP(PPP-Quarterly)" with positive data to the service "/fixed-deposit-products"
    Then the user should get status code 202

  Scenario: For service validation, user wants to create Mudaraba Fixed Deposit Product where profit posting period is Biannually
    When the user makes post call through json file "FDP(PPP-Biannually)" with positive data to the service "/fixed-deposit-products"
    Then the user should get status code 202

  Scenario: For service validation, user wants to create Mudaraba Fixed Deposit Product where profit posting period is Yearly
    When the user makes post call through json file "FDP(PPP-Yearly)" with positive data to the service "/fixed-deposit-products"
    Then the user should get status code 202

  #  Fixed Deposit Product Negative Test

#  Scenario: For field validation, user wants to create Fixed Deposit Product where all mandatory fields value is null
#    When the user makes post call through json file "FDP(UndefineMandatoryFields)" with negative data to the service "/fixed-deposit-products"
#    Then the user should get status code 400
#
#  Scenario: For field validation, user wants to create Fixed Deposit Product where code is less than 3 and greater than 3
#    When the user makes post call through json file "FDP(CodeLengthCheckLessThanThree)" with negative data to the service "/fixed-deposit-products"
#    Then the user should get status code 400
#
#  Scenario: For field validation, user wants to create Mudaraba Fixed Deposit Product where code is less than 3 and greater than 3
#    When the user makes post call through json file "FDP(CodeLengthCheckGreaterThanThree)" with negative data to the service "/fixed-deposit-products"
#    Then the user should get status code 400
#
#  Scenario: For field validation, user wants to create Mudaraba Fixed Deposit Product where code is less than 3 and greater than 3
#    When the user makes post call through json file "FDP(Name-CodeFormatCheck)" with negative data to the service "/fixed-deposit-products"
#    Then the user should get status code 500
#
#  Scenario: For service validation, user wants to create Mudaraba Fixed Deposit Product where all dependent data has null value
#    When the user makes post call through json file "FDP(DependentDataNullValue)" with negative data to the service "/fixed-deposit-products"
#    Then the user should get status code 500
#
#  Scenario: For service validation, user wants to create Mudaraba Fixed Deposit Product where all checkbox and input-switch are false but posting theirs value
#    When the user makes post call through json file "FDP(DataPostingForFalseCheckBoxAndInputswitch)" with negative data to the service "/fixed-deposit-products"
#    Then the user should get status code 500
#
#  Scenario: For service validation, user wants to create Mudaraba Fixed Deposit Product where two dependent data "Compounding before maturity allowed" and "Withdraw profit before maturity allowed" are true in a time
#    When the user makes post call through json file "FDP(DependentDataMisMatch-MaturityAllowedPolicy)" with negative data to the service "/fixed-deposit-products"
#    Then the user should get status code 500
#
#  Scenario: For service validation, user wants to create Mudaraba Fixed Deposit Product where two dependent data "Quard allowed" and "Withdrawal allowed" are true in a time
#    When the user makes post call through json file "FDP(DependentDataMisMatch-QuardAllowed_with_WithdrawalAllowed)" with negative data to the service "/fixed-deposit-products"
#    Then the user should get status code 500

  #  Fixed Deposit Product Profit Rate Configuration Test

  Scenario: For service validation, user wants to configure profit rate for fixed deposit product
    When post call to config fixed deposit product profit rate through json file "FDP-AllFieldData(ProfitRateConfiguration)" with positive data to the service "/products/""id""/profit-rates"
    Then the user should get status code 201

#  Scenario: For field validation, user wants to configure profit rate where mandatory "Annual Provisional Rate" is undefine
#    When the user makes post call for configuration through json file "FDP-ProductForProfitRate(Undefine-AnnualProvisionalRate)" to the service "/fixed-deposit-products"
#    When post call to config profit rate through json file "FDP-ProfitRate(Undefine-AnnualProvisionalRate)" with negative data to the service "/products/""id""/profit-rates"
#    Then the user should get status code 400
#
#  Scenario: For field validation, user wants to configure profit rate where mandatory Annual Provisional Rate percentage will be check
#    When the user makes post call for configuration through json file "FDP-ProductForProfitRate(AnnualProvisionalRatePercentageCheck)" to the service "/fixed-deposit-products"
#    When post call to config profit rate through json file "FDP-ProfitRate(AnnualProvisionalRatePercentageCheck)" with negative data to the service "/products/""id""/profit-rates"
#    Then the user should get status code 400
#
#  Scenario: For service validation, user wants to configure profit rate where slab-Applicable is false but posting its data
#    When the user makes post call for configuration through json file "FDP-ProductForProfitRate(DataPostingForFalseSlabApplicable)" to the service "/fixed-deposit-products"
#    When post call to config profit rate through json file "FDP-ProfitRate(DataPostingForFalseSlabApplicable)" with negative data to the service "/products/""192""/profit-rates"
#    Then the user should get status code 500
#
#  Scenario: For service validation, user wants to configure profit rate where Slab-Applicable is true and default data will be posted
#    When the user makes post call for configuration through json file "FDP-ProductForProfitRate(DefaultDataPosting)" to the service "/fixed-deposit-products"
#    When post call to config profit rate through json file "FDP-ProfitRate(DefaultDataPosting)" with negative data to the service "/products/""id""/profit-rates"
#    Then the user should get status code 400
#
#  Scenario: For service validation, user wants to configure profit rate where "Amount Range From" is greater than "Amount Range To"
#    When the user makes post call for configuration through json file "FDP-ProductForProfitRate(DependentDataMisMatch-AmountRangeFrom_With_AmountRangeTo)" to the service "/fixed-deposit-products"
#    When post call to config profit rate through json file "FDP-ProfitRate(DependentDataMisMatch-AmountRangeFrom_With_AmountRangeTo)" with negative data to the service "/products/""id""/profit-rates"
#    Then the user should get status code 500

  #  Fixed Deposit Product GL Configuration Test

  Scenario: For service validation, user wants to configure fixed deposit product "General Ledger Mapping" where "General Ledger Type" is "PRODUCT_GL"
    When post call to config fixed deposit product GL through json file "FDP-AllFieldData(GLConfiguration)" with positive data to the service "products/""id""/general-ledgers"
    Then the user should get status code 202

#  Scenario: For service validation, user wants to configure fixed deposit product "General Ledger Mapping" where "General Ledger Type" is undefine
#    When the user makes post call for configuration through json file "FDP-ProductForGeneralLedgerMapping(Undefine-GLType)" to the service "/fixed-deposit-products"
#    When post call to config GL through json file "FDP-GeneralLedgerMapping(Undefine-GLType)" with negative data to the service "products/""id""/general-ledgers"
#    Then the user should get status code 400
#
#  Scenario: For service validation, user wants to configure fixed deposit product "General Ledger Mapping" where "General Ledger Name" is undefine
#    When the user makes post call for configuration through json file "FDP-ProductForGeneralLedgerMapping(Undefine-GLName)" to the service "/fixed-deposit-products"
#    When post call to config GL through json file "FDP-GeneralLedgerMapping(Undefine-GLName)" with negative data to the service "products/""id""/general-ledgers"
#    Then the user should get status code 400
#
#  Scenario: For service validation, user wants to configure fixed deposit product "General Ledger Mapping" where according to General ledger type, General Ledger Name is not authenticated
#    When the user makes post call for configuration through json file "FDP-ProductForGeneralLedgerMapping(unauthenticatedGL)" to the service "/fixed-deposit-products"
#    And post call to config GL through json file "FDP-GeneralLedgerMapping(unauthenticatedGL)" with negative data to the service "products/""id""/general-ledgers"
#    Then the user should get status code 500

  #  Fixed Deposit Product Update Test

  Scenario: For service validation, user wants to update Fixed Deposit Product where "description" will be changed into "Time Deposit Product" to "Fixed Deposit Product"
    When the user makes post call for configuration through json file "FDP-ProductForUpdate(Description)" to the service "/fixed-deposit-products"
    When the user makes put call through json file "FDP-Update(Description)" to the service "/fixed-deposit-products/""id"
    Then the user should get status code 202

  #  Fixed Deposit Product Activation Test

  Scenario: For service validation, user wants to active demand deposit product
    When post call to activate fixed deposit product through json file "FDP-AllFieldData(Activated)" to the service "/fixed-deposit-products/""id""/command"
    Then the user should get status code 202

  #  Installment Deposit Product Positive Test

  Scenario: For service validation, user wants to create Mudaraba Installment Deposit Product where all possible field data will be posted
     When the user makes post call through json file "IDP(AllFieldData)" with positive data to the service "/recurring-deposit-products"
     Then the user should get status code 202

  Scenario: For service validation, user wants to create Mudaraba Installment Deposit Product where all mandatory field data will be posted
    When the user makes post call through json file "IDP(AllMandatoryData)" with positive data to the service "/recurring-deposit-products"
    Then the user should get status code 202

  Scenario: For service validation, user wants to create Mudaraba Installment Deposit Product where profit posting period is Monthly
    When the user makes post call through json file "IDP(PPP-Monthly)" with positive data to the service "/recurring-deposit-products"
    Then the user should get status code 202

  Scenario: For service validation, user wants to create Mudaraba Installment Deposit Product where profit posting period is Quarterly
    When the user makes post call through json file "IDP(PPP-Quarterly)" with positive data to the service "/recurring-deposit-products"
    Then the user should get status code 202

  Scenario: For service validation, user wants to create Mudaraba installment Deposit Product where profit posting period is Biannually
    When the user makes post call through json file "IDP(PPP-Biannually)" with positive data to the service "/recurring-deposit-products"
    Then the user should get status code 202

  Scenario: For service validation, user wants to create Mudaraba Installment Deposit Product where profit posting period is Yearly
    When the user makes post call through json file "IDP(PPP-Yearly)" with positive data to the service "/recurring-deposit-products"
    Then the user should get status code 202

  #  Installment Deposit Product Negative Test

#  Scenario: For field validation, user wants to create Mudaraba Installment Deposit Product where all mandatory fields value is null
#    When the user makes post call through json file "IDP(UndefineMandatoryFields)" with negative data to the service "/recurring-deposit-products"
#    Then the user should get status code 400
#
#  Scenario: For field validation, user wants to create Mudaraba Installment Deposit Product where code is less than 3
#    When the user makes post call through json file "IDP(CodeLengthCheckLessThanThree)" with negative data to the service "/recurring-deposit-products"
#    Then the user should get status code 400
#
#  Scenario: For field validation, user wants to create Mudaraba installment Deposit Product where code is greater than 3
#    When the user makes post call through json file "IDP(CodeLengthCheckGreaterThanThree)" with negative data to the service "/recurring-deposit-products"
#    Then the user should get status code 400
#
#  Scenario: For field validation, user wants to create Mudaraba Installment Deposit Product where name is "NameValidation_123" code is "A_5"
#    When the user makes post call through json file "IDP(Name-CodeFormateCheck)" with negative data to the service "/recurring-deposit-products"
#    Then the user should get status code 400
#
#  Scenario: For service validation, user wants to create Mudaraba Installment Deposit Product where all dependent field has null value
#    When the user makes post call through json file "IDP(DependentDataNullValue)" with negative data to the service "/recurring-deposit-products"
#    Then the user should get status code 500
#
#  Scenario: For service validation, user wants to create Mudaraba Installment Deposit Product where all checkbox and input-switch are false but posting theirs value
#    When the user makes post call through json file "IDP(DataPostingForFalseCheckBoxAndInputswitch)" with negative data to the service "/recurring-deposit-products"
#    Then the user should get status code 500
#
#  Scenario: For service validation, user wants to create Mudaraba Installment Deposit Product where two dependent data "Compounding before maturity allowed" and "Withdraw profit before maturity allowed" are true in a time
#    When the user makes post call through json file "IDP(DependentDataMisMatch-MaturityAllowedPolicy)" with negative data to the service "/recurring-deposit-products"
#    Then the user should get status code 500
#
#  Scenario: For service validation, user wants to create Mudaraba Installment Deposit Product where Minimum deposit Amount is greater than Maximum deposit Amount
#    When the user makes post call through json file "IDP(DependentDataMisMatch-Minimum_with_Maximum)" with negative data to the service "/recurring-deposit-products"
#    Then the user should get status code 500

  #  Installment Deposit Product Profit Rate Configuration Test

  Scenario: For service validation, user wants to configure profit rate where slab applicable is false
    When post call to config installment deposit product profit rate through json file "IDP-AllFieldData(ProfitRateConfiguration)" with positive data to the service "/products/""id""/profit-rates"
    Then the user should get status code 201

#  Scenario: For field validation, user wants to configure profit rate where mandatory "Annual Provisional Rate" is undefine
#    When the user makes post call for configuration through json file "IDP-ProductForProfitRate(Undefine-AnnualProvisionalRate)" to the service "/recurring-deposit-products"
#    And post call to config profit rate through json file "IDP-ProfitRate(Undefine-AnnualProvisionalRate)" with negative data to the service "/products/""id""/profit-rates"
#    Then the user should get status code 400
#
#  Scenario: For field validation, user wants to configure profit rate where mandatory Annual Provisional Rate percentage will be check
#    When the user makes post call for configuration through json file "IDP-ProductForProfitRate(AnnualProvisionalRatePercentageCheck)" to the service "/recurring-deposit-products"
#    And post call to config profit rate through json file "IDP-ProfitRate(AnnualProvisionalRatePercentageCheck)" with negative data to the service "/products/""id""/profit-rates"
#    Then the user should get status code 400
#
#  Scenario: For service validation, user wants to configure profit rate where slab-Applicable is false but posting its data
#    When the user makes post call for configuration through json file "IDP-ProductForProfitRate(DataPostingForFalseSlabApplicable)" to the service "/recurring-deposit-products"
#    And post call to config profit rate through json file "IDP-ProfitRate(DataPostingForFalseSlabApplicable)" with negative data to the service "/products/""id""/profit-rates"
#    Then the user should get status code 500
#
#  Scenario: For service validation, user wants to configure profit rate where Slab-Applicable is true and default data will be posted
#    When the user makes post call for configuration through json file "IDP-ProductForProfitRate(DefaultDataPosting)" to the service "/recurring-deposit-products"
#    And post call to config profit rate through json file "IDP-ProfitRate(DefaultDataPosting)" with negative data to the service "/products/""id""/profit-rates"
#    Then the user should get status code 400
#
#  Scenario: For service validation, user wants to configure profit rate where "Amount Range From" is greater than "Amount Range To"
#    When the user makes post call for configuration through json file "IDP-ProductForProfitRate(DependentDataMisMatch-AmountRangeFrom_With_AmountRangeTo)" to the service "/recurring-deposit-products"
#    And post call to config profit rate through json file "IDP-ProfitRate(DependentDataMisMatch-AmountRangeFrom_With_AmountRangeTo)" with negative data to the service "/products/""id""/profit-rates"
#    Then the user should get status code 500

  #  Installment Deposit Product GL Configuration Test

  Scenario: For service validation, user wants to configure installment deposit product "General Ledger Mapping" where "General Ledger Type" is "PRODUCT_GL"
    When post call to config installment deposit product GL through json file "IDP-AllFieldData(GLConfiguration)" with positive data to the service "products/""id""/general-ledgers"
    Then the user should get status code 202

#  Scenario: For service validation, user wants to configure installment deposit product "General Ledger Mapping" where "General Ledger Type" is undefine
#    When the user makes post call for configuration through json file "IDP-ProductForGeneralLedgerMapping(Undefine-GLType)" to the service "/recurring-deposit-products"
#    And post call to config GL through json file "IDP-GeneralLedgerMapping(Undefine-GLType)" with negative data to the service "products/""id""/general-ledgers"
#    Then the user should get status code 400
#
#  Scenario: For service validation, user wants to configure installment deposit product "General Ledger Mapping" where "General Ledger Name" is undefine
#    When the user makes post call for configuration through json file "IDP-ProductForGeneralLedgerMapping(Undefine-GL)" to the service "/recurring-deposit-products"
#    When post call to config GL through json file "IDP-GeneralLedgerMapping(Undefine-GL)" with negative data to the service "products/""id""/general-ledgers"
#    Then the user should get status code 400
#
#  Scenario: For service validation, user wants to configure installment deposit product "General Ledger Mapping" where according to General ledger type, General Ledger Name is not authenticated
#    When the user makes post call for configuration through json file "IDP-ProductForGeneralLedgerMapping(unauthenticatedGL)" to the service "/recurring-deposit-products"
#    When post call to config GL through json file "IDP-GeneralLedgerMapping(unauthenticatedGL)" with negative data to the service "products/""id""/general-ledgers"
#    Then the user should get status code 500

  #  Installment Deposit Product Activation

  Scenario: For service validation, user wants to active demand deposit product
    When post call to activate installment deposit product through json file "IDP-AllFieldData(Activated)" to the service "/recurring-deposit-products/""id""/command"
    Then the user should get status code 202

  #  Installment Deposit Product Update

  Scenario: For service validation, user wants to update Fixed Deposit Product where "description" will be changed into "Time Deposit Account" to "Fixed Deposit Account"
    When the user makes post call for configuration through json file "IDP-ProductForUpdate(Description)" to the service "/recurring-deposit-products"
    When the user makes put call through json file "IDP-Update(Description)" to the service "/recurring-deposit-products/""id"
    Then the user should get status code 202
