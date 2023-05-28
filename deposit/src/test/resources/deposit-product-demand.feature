Feature: demand deposit product creation and validation
  As a bank user
  I want to create demand deposit product and check validation

  Scenario: the user calls auth for token validation
    When the user calls auth for token validation
    Then the user gets authentication for the service

  #  Demand Deposit Product Positive Test

  Scenario: Demand deposit product creation where all input-switch are true and take all possible positive field value
    When the user makes post call through json file "DDP-TrueInputSwitch" with positive data to the service "/demand-deposit-products"
    Then the user should get status code 201

  Scenario: Demand deposit product creation where all input-switch and check-box are true and take all possible positive field value
    When the user makes post call through json file "DDP-TrueInputSwitch(All_Checkbox_True)" with positive data to the service "/demand-deposit-products"
    Then the user should get status code 201

  Scenario: Demand deposit product creation where all input-switch are true and all check-box are false
    When the user makes post call through json file "DDP-TrueInputSwitch(All_Checkbox_False)" with positive data to the service "/demand-deposit-products"
    Then the user should get status code 201

  Scenario: Demand deposit product creation where all input-switch are false
    When the user makes post call through json file "DDP-FalseInputSwitch" with positive data to the service "/demand-deposit-products"
    Then the user should get status code 201

  #  Demand Deposit Product Negative Test

#  Scenario: For field validation, user wants to create demand deposit product account where name is null
#    When the user makes post call through json file "DDP(ProductNameNull)" with negative data to the service "/demand-deposit-products"
#    Then the user should get status code 400
#
#  Scenario: For field validation, user wants to create demand deposit product account where account name consists of special character and numeric value
#    When the user makes post call through json file "DDP(ProductNameFormat)" with negative data to the service "/demand-deposit-products"
#    And account name consists of special characters and numeric values
#    Then the user should get status code 400
#
#  Scenario: For field validation, user wants to create demand deposit product account where name length will be greater than 255 characters
#    When the user makes post call through json file "DDP(ProductNameLength)" with negative data to the service "/demand-deposit-products"
#    Then the user should get status code 500
#
#  Scenario: For max validation data, user wants to create demand deposit product where the account code is above 3 digits
#    When the user makes post call through json file "DDP(ProductCodeLimitExceed)" with negative data to the service "/demand-deposit-products"
#    And the account code is above 3 digits
#    Then the user should get status code 400
#
#  Scenario: For field validation, user wants to create demand deposit product where the account code is null
#    When the user makes post call through json file "DDP(ProductCodeNull)" with negative data to the service "/demand-deposit-products"
#    And the account code is null
#    Then the user should get status code 400
#
#  Scenario: For code duplication data, user wants to create demand deposit product where the account code is same for two products
#    When the user makes post call through json file "DDP(ProductCodeDuplication)" with negative data to the service "/demand-deposit-products"
#    And the account code is same for both accounts
#    Then the user should get status code 500
#
#  Scenario: For field validation, user wants to create demand deposit product where the account code consists of letters,numeric and special characters
#    When the user makes post call through json file "DDP(ProductCodeFormat)" with negative data to the service "/demand-deposit-products"
#    And the account code is not in digits only
#    Then the user should get status code 500
#
#  Scenario: For field validation, user wants to create demand deposit product where "Cheque required" is null but "Cheque prefix required" is true
#    When the user makes post call through json file "DDP(InactiveCheckBoxPosting)" with negative data to the service "/demand-deposit-products"
#    And the account code is not in digits only
#    Then the user should get status code 500
#
#  Scenario: For field validation, user wants to create demand deposit product where Currency" is undefine
#    When the user makes post call through json file "DDP(Undefine-Currency)" with negative data to the service "/demand-deposit-products"
#    And the account code is not in digits only
#    Then the user should get status code 400
#
#  Scenario: For field validation, user wants to create demand deposit product where "Currencies" is undefine
#    When the user makes post call through json file "DDP(Undefine-Currencies)" with negative data to the service "/demand-deposit-products"
#    And the account code is not in digits only
#    Then the user should get status code 500
#
#  Scenario: For field validation, user wants to create demand deposit product where "Days In Year" is undefine
#    When the user makes post call through json file "DDP(Undefine-DaysInYear)" with negative data to the service "/demand-deposit-products"
#    And the account code is not in digits only
#    Then the user should get status code 400
#
#  Scenario: For field validation, user wants to create demand deposit product where "Eligible Customer Type" is undefine
#    When the user makes post call through json file "DDP(Undefine-EligibleCustomerType)" with negative data to the service "/demand-deposit-products"
#    And the account code is not in digits only
#    Then the user should get status code 400
#
#  Scenario: Demand deposit product creation where profit earning criteria input-switch is false but posting its various data
#    When the user makes post call through json file "DDP(DataPostingForClosedPECInputSwitch)" with negative data to the service "/demand-deposit-products"
#    Then the user should get status code 500
#
#  Scenario: For field validation, user wants to create demand deposit product where profit earning criteria is true but "Minimum Balance for Profit Calculation" is undefine
#    When the user makes post call through json file "DDP(Undefine-MinimumBalanceForProfitCalculation)" with negative data to the service "/demand-deposit-products"
#    Then the user should get status code 500
#
#  Scenario: For field validation, user wants to create demand deposit product where profit earning criteria is true but "Minimum Profit To Apply" is undefine
#    When the user makes post call through json file "DDP(Undefine-MinimumProfitToApply)" with negative data to the service "/demand-deposit-products"
#    Then the user should get status code 500
#
#  Scenario: For field validation, user wants to create demand deposit product where "Saving Product Calculation Type" is "Daily" but "Saving Daily Product Calculation Type" is undefine
#    When the user makes post call through json file "DDP(Undefine-SavingDailyProductCalculationType)" with negative data to the service "/demand-deposit-products"
#    Then the user should get status code 500
#
#  Scenario: For field validation, user wants to create demand deposit product where "Saving Product Calculation Type" is "Monthly" but "Saving Monthly Product Calculation Type" is undefine
#    When the user makes post call through json file "DDP(Undefine-SavingMonthlyProductCalculationType)" with negative data to the service "/demand-deposit-products"
#    Then the user should get status code 500
#
#  Scenario: Demand deposit product creation where Transaction Rules' input-switch is false but posting its various data
#    When the user makes post call through json file "DDP(DataPostingForClosedTRInputSwitch)" with negative data to the service "/demand-deposit-products"
#    Then the user should get status code 500
#
#  Scenario: For field validation, user wants to create demand deposit product where "Transaction Rules" is true but "Maximum Number Of Transaction Per Week" is undefine
#    When the user makes post call through json file "DDP(Undefine-MaximumNumberOfTransactionPerWeek)" with negative data to the service "/demand-deposit-products"
#    Then the user should get status code 500
#
#  Scenario: For field validation, user wants to create demand deposit product where "Transaction Rules" is true but "Maximum Number Of Transaction Per Month" is undefine
#    When the user makes post call through json file "DDP(Undefine-MaximumNumberOfTransactionPerMonth)" with negative data to the service "/demand-deposit-products"
#    Then the user should get status code 500
#
#  Scenario: For field validation, user wants to create demand deposit product where "Transaction Rules" is true but "Maximum Transaction Ratio Balance" is undefine
#    When the user makes post call through json file "DDP(Undefine-MaximumTransactionRatioBalance)" with negative data to the service "/demand-deposit-products"
#    Then the user should get status code 500
#
#  Scenario: For field validation, user wants to create demand deposit product where "Transaction Rules" is true but "Maximum Transaction Amount" is undefine
#    When the user makes post call through json file "DDP(Undefine-MaximumTransactionAmount)" with negative data to the service "/demand-deposit-products"
#    Then the user should get status code 500
#
#  Scenario: For service validation, user wants to create demand deposit product where "Transaction Per Week" is "4" and "Transaction Per Month" is "18"
#    When the user makes post call through json file "DDP(DependentDataMisMatch-TPW_With_TPM)" with negative data to the service "/demand-deposit-products"
#    Then the user should get status code 500
#
#  Scenario: Demand deposit product creation where "Enforce Minimum Required Balance" check-box is false but posting "Minimum Balance" field value
#    When the user makes post call through json file "DDP(DataPostingForClosedRequiredBalance)" with negative data to the service "/demand-deposit-products"
#    Then the user should get status code 500
#
#  Scenario: For field validation, user wants to create demand deposit product where "Enforce Minimum Required Balance" is true but "Minimum Balance" is undefine
#    When the user makes post call through json file "DDP(Undefine-MinimumBalance)" with negative data to the service "/demand-deposit-products"
#    Then the user should get status code 500
#
#  Scenario: Demand deposit product creation where "Minimum Required Opening Balance" check-box is false but posting "Initial Deposit" field value
#    When the user makes post call through json file "DDP(DataPostingForClosedOpeningBalance)" with negative data to the service "/demand-deposit-products"
#    Then the user should get status code 500
#
#  Scenario: For field validation, user wants to create demand deposit product where "Minimum Required Opening Balance" is true but "Initial Deposit" is undefine
#    When the user makes post call through json file "DDP(Undefine-InitialDeposit)" with negative data to the service "/demand-deposit-products"
#    Then the user should get status code 500
#
#  Scenario: Demand deposit product creation where "Dormancy Rules" input-switch is false but posting all logical field value
#    When the user makes post call through json file "DDP(DataPostingForClosedDormancyRules)" with negative data to the service "/demand-deposit-products"
#    Then the user should get status code 500
#
#  Scenario: For field validation, user wants to create demand deposit product where "Dormancy Rules" is true but "DaysToInactive" is undefine
#    When the user makes post call through json file "DDP(Undefine-DaysToInactive)" with negative data to the service "/demand-deposit-products"
#    Then the user should get status code 500
#
#  Scenario: For field validation, user wants to create demand deposit product where "Dormancy Rules" is true but "DaysToDormancy" is undefine
#    When the user makes post call through json file "DDP(Undefine-DaysToDormancy)" with negative data to the service "/demand-deposit-products"
#    Then the user should get status code 500
#
#  Scenario: For field validation, user wants to create demand deposit product where "Dormancy Rules" is true but "DaysToEscheat" is undefine
#    When the user makes post call through json file "DDP(Undefine-DaysToEscheat)" with negative data to the service "/demand-deposit-products"
#    Then the user should get status code 500
#
#  Scenario: For service validation, user wants to create demand deposit product where "Dormancy Rules" input-switch is true and it's all field value will be Ascending Order(Inactive<Dormancy<Escheat)
#    When the user makes post call through json file "DDP(DependentDataMisMatch-DormancyRulesAscendancy)" with negative data to the service "/demand-deposit-products"
#    Then the user should get status code 500

  #  Demand Deposit Product Profit Rate Configuration Test

  Scenario: For service validation, user wants to configure profit rate for demand deposit product
    When post call to config demand deposit product profit rate through json file "DDP-TrueInputSwitch(ProfitRateConfiguration)" with positive data to the service "/products/""id""/profit-rates"
    Then the user should get status code 201

#  Scenario: For field validation, user wants to configure profit rate where mandatory "Annual Provisional Rate" is undefine
#    When the user makes post call for configuration through json file "DDP-ProductForProfitRate(Undefine-AnnualProvisionalRate)" to the service "/demand-deposit-products"
#    And post call to config profit rate through json file "DDP-ProfitRate(Undefine-AnnualProvisionalRate)" with negative data to the service "/products/""id""/profit-rates"
#    Then the user should get status code 400
#
#  Scenario: For field validation, user wants to configure profit rate where mandatory Annual Provisional Rate percentage will be check
#    When the user makes post call for configuration through json file "DDP-ProductForProfitRate(AnnualProvisionalRatePercentageCheck)" to the service "/demand-deposit-products"
#    And post call to config profit rate through json file "DDP-ProfitRate(AnnualProvisionalRatePercentageCheck)" with negative data to the service "/products/""id""/profit-rates"
#    Then the user should get status code 400
#
#  Scenario: For service validation, user wants to configure profit rate where slab-Applicable is false but posting its data
#    When the user makes post call for configuration through json file "DDP-ProductForProfitRate(DataPostingForFalseSlabApplicable)" to the service "/demand-deposit-products"
#    And post call to config profit rate through json file "DDP-ProfitRate(DataPostingForFalseSlabApplicable)" with negative data to the service "/products/""id""/profit-rates"
#    Then the user should get status code 500
#
#  Scenario: For service validation, user wants to configure profit rate where Slab-Applicable is true and default data will be posted
#    When the user makes post call for configuration through json file "DDP-ProductForProfitRate(DefaultDataPosting)" to the service "/demand-deposit-products"
#    And post call to config profit rate through json file "DDP-ProfitRate(DefaultDataPosting)" with negative data to the service "/products/""id""/profit-rates"
#    Then the user should get status code 400
#
#  Scenario: For service validation, user wants to configure profit rate where "Amount Range From" is greater than "Amount Range To"
#    When the user makes post call for configuration through json file "DDP-ProductForProfitRate(DependentDataMisMatch-AmountRangeFrom_With_AmountRangeTo)" to the service "/demand-deposit-products"
#    And post call to config profit rate through json file "DDP-ProfitRate(DependentDataMisMatch-AmountRangeFrom_With_AmountRangeTo)" with negative data to the service "/products/""id""/profit-rates"
#    Then the user should get status code 500

  #  Demand Deposit Product Cheque Prefix Configuration Test

  Scenario: For service validation, user wants to configure cheque prefix
    When post call to config cheque prefix through json file "DDP-TrueInputSwitch(ChequePrefixConfiguration)" with positive data to the service "/demand-deposit-products/""id""/cheque-prefixes"
    Then the user should get status code 202

#  Scenario: For field validation, user wants to configure cheque prefix where cheque prefix is null
#    When the user makes post call for configuration through json file "DDP-ProductForChequePrefix(Undefine-ChequePrefix)" to the service "/demand-deposit-products"
#    And post call to config cheque prefix through json file "DDP-ChequePrefix(Undefine-ChequePrefix)" with negative data to the service "/demand-deposit-products/""id""/cheque-prefixes"
#    Then the user should get status code 400
#
#  Scenario: For field validation, user wants to configure cheque prefix where cheque prefix will be greater than 3 characters
#    When the user makes post call for configuration through json file "DDP-ProductForChequePrefix(ChequePrefixLengthCheck)" to the service "/demand-deposit-products"
#    And post call to config cheque prefix through json file "DDP-ChequePrefix(ChequePrefixLengthCheck)" with negative data to the service "/demand-deposit-products/""id""/cheque-prefixes"
#    Then the user should get status code 400
#
#  Scenario: For field validation, user wants to configure cheque prefix where cheque required will false but cheque prefix is defined
#    When the user makes post call for configuration through json file "DDP-ProductForChequePrefix(unauthenticatedChequePrefix)" to the service "/demand-deposit-products"
#    And post call to config cheque prefix through json file "DDP-ChequePrefix(UnauthenticatedChequePrefix)" with negative data to the service "/demand-deposit-products/""id""/cheque-prefixes"
#    Then the user should get status code 500
#
#  Scenario: For field validation, user wants to configure cheque prefix where cheque prefix will consists of letters, numbers and special characters
#    When the user makes post call for configuration through json file "DDP-ProductForChequePrefix(ChequePrefixFormat)" to the service "/demand-deposit-products"
#    When post call to config cheque prefix through json file "DDP-ChequePrefix(ChequePrefixFormat)" with negative data to the service "/demand-deposit-products/""id""/cheque-prefixes"
#    Then the user should get status code 202

  #  Demand Deposit Product Cheque Book Size Configuration Test

  Scenario: For service validation, user wants to configure cheque book size
    When post call to config cheque book size through json file "DDP-TrueInputSwitch(ChequeBookSizeConfiguration)" with positive data to the service "/demand-deposit-products/""101""/cheque-book-sizes"
    Then the user should get status code 202

#  Scenario: For field validation, user wants to configure cheque prefix where cheque book size is null
#    When the user makes post call for configuration through json file "DDP-ProductForChequeBookSize(ChequeBookSizeNull)" to the service "/demand-deposit-products"
#    And post call to config cheque book size through json file "DDP-ChequeBookSize(ChequeBookSizeNull)" with negative data to the service "/demand-deposit-products/""id""/cheque-book-sizes"
#    Then the user should get status code 400
#
#  Scenario: For field validation, user wants to configure cheque prefix where cheque book size is zero
#    When the user makes post call for configuration through json file "DDP-ProductForChequeBookSize(ChequeBookSizeZero)" to the service "/demand-deposit-products"
#    And post call to config cheque book size through json file "DDP-ChequeBookSize(ChequeBookSizeZero)" with negative data to the service "/demand-deposit-products/""id""/cheque-book-sizes"
#    Then the user should get status code 400

  #  Demand Deposit Product GL Configuration Test

  Scenario: For service validation, user wants to configure general ledger mapping
    When post call to config demand deposit product GL through json file "DDP-TrueInputSwitch(GLConfiguration)" with positive data to the service "products/""id""/general-ledgers"
    Then the user should get status code 202

#  Scenario: For service validation, user wants to configure demand deposit product "General Ledger Mapping" where "General Ledger Type" is undefine
#    When the user makes post call for configuration through json file "DDP-ProductForGeneralLedgerMapping(Undefine-GLType)" to the service "/demand-deposit-products"
#    When post call to config GL through json file "DDP-GeneralLedgerMapping(Undefine-GLType)" with negative data to the service "products/""id""/general-ledgers"
#    Then the user should get status code 400
#
#  Scenario: For service validation, user wants to configure demand deposit product "General Ledger Mapping" where "General Ledger Name" is undefine
#    When the user makes post call for configuration through json file "DDP-ProductForGeneralLedgerMapping(Undefine-GL)" to the service "/demand-deposit-products"
#    When post call to config GL through json file "DDP-GeneralLedgerMapping(Undefine-GL)" with negative data to the service "products/""id""/general-ledgers"
#    Then the user should get status code 400
#
#  Scenario: For service validation, user wants to configure demand deposit product "General Ledger Mapping" where according to General ledger type, General Ledger Name is not authenticated
#    When the user makes post call for configuration through json file "DDP-ProductForGeneralLedgerMapping(unauthenticatedGL)" to the service "/demand-deposit-products"
#    When post call to config GL through json file "DDP-GeneralLedgerMapping(unauthenticatedGL)" with negative data to the service "products/""id""/general-ledgers"
#    Then the user should get status code 500

  #  Demand Deposit Product Activation Test

  Scenario: For service validation, user wants to active demand deposit product
    When post call to activate demand deposit product through json file "DDP-TrueInputSwitch(Activated)" to the service "/demand-deposit-products/""id""/command"
    Then the user should get status code 202

  #  Demand Deposit Product Update Test

  Scenario: For service validation, user wants to update demand Deposit Product where "description" will be changed into "DDP" to "Demand deposit account"
    When the user makes post call for configuration through json file "DDP-ProductForUpdate(Description)" to the service "/demand-deposit-products"
    When the user makes put call through json file "DDP-Update(Description)" to the service "/demand-deposit-products/""id"
    Then the user should get status code 202

