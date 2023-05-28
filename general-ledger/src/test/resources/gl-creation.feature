Feature: general ledger accounts creation
  As a bank user
  I want to create various types GL (asset, liability, income, expense)
  So that we will get a complete GL life cycle of bank

  Scenario: the user calls auth for token validation
    When the user calls auth for token validation
    Then the user gets authentication for the service
#
#  Scenario: user creates various type asset GL with all possible permutation and combination by using all positive data
#    When the user makes post call through json file "gl-config(AssetType)" to the service "/general-ledger-accounts"
#    Then the user should get status code 202
#
#  Scenario: user creates various type liability GL with all possible permutation and combination by using all positive data
#    When the user makes post call through json file "gl-config(LiabilityType)" to the service "/general-ledger-accounts"
#    Then the user should get status code 202
#
#  Scenario: user creates various type income GL with all possible permutation and combination by using all positive data
#     When the user makes post call through json file "gl-config(IncomeType)" to the service "/general-ledger-accounts"
#     Then the user should get status code 202
#
#  Scenario: user creates various type expenditure GL with all possible permutation and combination by using all positive data
#    When the user makes post call through json file "gl-config(ExpenditureType)" to the service "/general-ledger-accounts"
#    Then the user should get status code 202
#
#  Scenario: user creates different levels of liability GL by using all positive data
#    When the user makes post call through json file "gl-config(MultiLayer)" to the service "/general-ledger-accounts"
#    Then the user should get status code 202
#
#  Scenario: For max validation data, user wants to create liability GL where the gl account code is above 10 digits
#    When the user makes post call through json file "gl-config(AccountCodeLimitExceed)" to the service "/general-ledger-accounts"
#    And the account code is above 10 digits
#    Then the user should get status code 500
#
  Scenario: For field validation, user wants to create liability GL where the gl account code is null
    When the user makes post call through json file "gl-config(AccountCodeNull)" to the service "/general-ledger-accounts"
    And the account code is null
    Then the user should get status code 500
#
#  Scenario: For code duplication data, user wants to create two different liability GL where the gl account code is same for both
#    When the user makes post call through json file "gl-config(AccountCodeDuplication)" to the service "/general-ledger-accounts"
#    And the account code is same for both accounts
#    Then the user should get status code 500
#
#  Scenario: For field validation, user wants to create liability GL where the gl account code is not numeric
#    When the user makes post call through json file "gl-config(AccountCodeFormat)" to the service "/general-ledger-accounts"
#    And the account code is not in digits only
#    Then the user should get status code 500
#
#  Scenario: For field validation, user wants to create liability GL where the gl account name is above 100 characters
#    When the user makes post call through json file "gl-config(AccountNameLength)" to the service "/general-ledger-accounts"
#    And the account name is above 100 characters
#    Then the user should get status code 500
#
#  Scenario: For field validation, user wants to create liability GL where the gl account name is null
#    When the user makes post call through json file "gl-config(AccountNameNull)" to the service "/general-ledger-accounts"
#    And the account name is null
#    Then the user should get status code 500
#
#  Scenario: For field validation, user wants to create liability GL where the gl account name is in varchar
#    When the user makes post call through json file "gl-config(AccountNameFormat)" to the service "/general-ledger-accounts"
#    And the account name is in varchar
#    Then the user should get status code 202
#
#  Scenario: For field validation, user wants to create liability GL where the gl account type is undefined
#    When the user makes post call through json file "gl-config(UndefineType)" to the service "/general-ledger-accounts"
#    And the account type is null
#    Then the user should get status code 500
#
#  Scenario: For field validation, user wants to create liability GL where the gl account sub type is undefined
#    When the user makes post call through json file "gl-config(UndefineSubType)" to the service "/general-ledger-accounts"
#    And the account sub type is null
#    Then the user should get status code 500
#
#  Scenario: For field validation, user wants to create liability GL where the gl account status is undefined
#    When the user makes post call through json file "gl-config(UndefineStatus)" to the service "/general-ledger-accounts"
#    And the account status is null
#    Then the user should get status code 500
#
#  Scenario: For field validation, user wants to create liability GL where the gl transaction scope / branch restriction is undefined
#    When the user makes post call through json file "gl-config(UndefineTransactionScope)" to the service "/general-ledger-accounts"
#    And the transaction scope / branch restriction is null
#    Then the user should get status code 500
#
#  Scenario: For field validation, user wants to create liability GL where transaction scope is specific but branches are undefined
#    When the user makes post call through json file "gl-config(UndefineBranches)" to the service "/general-ledger-accounts"
#    And the transaction scope is Specific Branch
#    But the branches are undefine
#    Then the user should get status code 500
#
#  Scenario: For field validation, user wants to create liability GL where the gl currency type is undefined
#    When the user makes post call through json file "gl-config(UndefineCurrencyType)" to the service "/general-ledger-accounts"
#    And the currency type is null
#    Then the user should get status code 500
#
#  Scenario: For checking validation, user wants to create liability GL where the currency type is specific but the currencies are undefined
#    When the user makes post call through json file "gl-config(UndefineCurrencies)" to the service "/general-ledger-accounts"
#    And the currency type is specific currencies
#    But the currencies are undefined
#    Then the user should get status code 500
#
#  Scenario: For checking active/inactive data, user wants to create liability GL where direct posting is false but credit and debit is true
#    When the user makes post call through json file "gl-config(InactiveCheckboxPosting)" to the service "/general-ledger-accounts"
#    And send direct posting as false but credit and debit as true
#    Then the user should get status code 500
#
#  Scenario: user update asset GL Test with EUR as currency
#    When the user makes put call through json file "gl-accountUpdate" to the service "/general-ledger-accounts/16"
#    Then the user should get status code 204