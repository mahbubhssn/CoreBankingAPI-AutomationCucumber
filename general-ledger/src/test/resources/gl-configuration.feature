#Feature: general ledger accounts configuration
#  As a bank user
#  I want to configure gl account profit rate, limit, subsidiary ledger
#
#  Scenario: the user calls auth for token validation
#    When the user calls auth for token validation
#    Then the user gets authentication for the service
#
#  Scenario: Profit Rate Configuration for Internal type GL
#    When the user makes post call through json file "gl-config(ProfitRate)" to the service "/general-ledger-accounts"
##    And json file "gl-profitRateConfig" to the service "/general-ledger-accounts/""id""/profit-rates"
#    Then the user should get status code 202
#
#  Scenario: User update Profit Rate
#    When the user makes put call through json file "gl-profitRateUpdate" to the service "/general-ledger-accounts/1268/profit-rates/84"
#    Then the user should get status code 202
#
#  Scenario: For field validation, user wants to configure profit rate where effective date field value is null
#    When the user makes post call through json file "gl-profitRateConfig(UndefineEffectiveDate)" to the service "/general-ledger-accounts/1268/profit-rates"
#    And the effective date field value is null
#    Then the user should get status code 400
#
#  Scenario: For field validation, user wants to update profit rate where effective date field value is null
#    When the user makes put call through json file "gl-profitRateUpdate(UndefineEffectiveDate)" to the service "/general-ledger-accounts/1268/profit-rates/84"
#    And the effective date field value is null
#    Then the user should get status code 400
#
#  Scenario: For field validation, user wants to configure profit rate where effective date field value is past date
#    When the user makes post call through json file "gl-profitRateConfig(PastEffectiveDate)" to the service "/general-ledger-accounts/1268/profit-rates"
#    And the effective date field value is past date
#    Then the user should get status code 500
#
#  Scenario: For field validation, user wants to configure profit rate where income GL account is undefined
#    When the user makes post call through json file "gl-profitRateConfig(UndefineIncomeGL)" to the service "/general-ledger-accounts/1268/profit-rates"
#    And the income GL account is null
#    Then the user should get status code 400
#
#  Scenario: For field validation, user wants to update profit rate where income GL account is undefined
#    When the user makes put call through json file "gl-profitRateUpdate(UndefineIncomeGL)" to the service "/general-ledger-accounts/1268/profit-rates/85"
#    And the income GL account is null
#    Then the user should get status code 400
#
#  Scenario: For field validation, user wants to configure profit rate where expense GL account is undefined
#    When the user makes post call through json file "gl-profitRateConfig(UndefineExpenseGL)" to the service "/general-ledger-accounts/1268/profit-rates"
#    And the expense GL account is null
#    Then the user should get status code 400
#
#  Scenario: For field validation, user wants to update profit rate where expense GL account is undefined
#    When the user makes put call through json file "gl-profitRateUpdate(UndefineExpenseGL)" to the service "/general-ledger-accounts/1268/profit-rates/85"
#    And the expense GL account is null
#    Then the user should get status code 400
#
#  Scenario: For field validation, user wants to configure profit rate where lending rate field value is undefined
#    When the user makes post call through json file "gl-profitRateConfig(UndefineLendingRate)" to the service "/general-ledger-accounts/1268/profit-rates"
#    And the lending rate field value is null
#    Then the user should get status code 500
#
#  Scenario: For field validation, user wants to configure profit rate where GL negative balance allowed is false but lending rate field value is negative
#    When the user makes post call through json file "gl-profitRateConfig(NegativeLendingRate)" to the service "/general-ledger-accounts/1268/profit-rates"
#    And GL negative balance allowed is false
#    But the lending rate field value is negative
#    Then the user should get status code 500
#
#  Scenario: For field validation, user wants to configure profit rate where borrowing rate field value is undefined
#    When the user makes post call through json file "gl-profitRateConfig(UndefineBorrowingRate)" to the service "/general-ledger-accounts/1268/profit-rates"
#    And the borrowing rate field value is null
#    Then the user should get status code 500
#
#  Scenario: For field validation, user wants to configure profit rate where GL negative balance allowed is false but borrowing rate field value is negative
#    When the user makes post call through json file "gl-profitRateConfig(NegativeBorrowingRate)" to the service "/general-ledger-accounts/1268/profit-rates"
#    And GL negative balance allowed is false
#    But the borrowing rate field value is negative
#    Then the user should get status code 500
#
#  Scenario: For field validation, user wants to configure profit rate where amount range from field value is undefined
#    When the user makes post call through json file "gl-profitRateConfig(UndefineAmountRangeFrom)" to the service "/general-ledger-accounts/1268/profit-rates"
#    And the amount range from field value is null
#    Then the user should get status code 500
#
#    Scenario: For field validation, user wants to update profit rate where amount range from field value is undefined
#    When the user makes put call through json file "gl-profitRateUpdate(UndefineAmountRangeFrom)" to the service "/general-ledger-accounts/1268/profit-rates/85"
#    And the amount range from field value is null
#    Then the user should get status code 500
#
#  Scenario: For field validation, user wants to configure profit rate where amount range from field value is negative
#    When the user makes post call through json file "gl-profitRateConfig(NegativeAmountRangeFrom)" to the service "/general-ledger-accounts/1268/profit-rates"
#    And the amount range from field value is negative
#    Then the user should get status code 500
#
#  Scenario: For field validation, user wants to update profit rate where amount range from field value is negative
#    When the user makes put call through json file "gl-profitRateUpdate(NegativeAmountRangeFrom)" to the service "/general-ledger-accounts/1268/profit-rates/85"
#    And the amount range from field value is negative
#    Then the user should get status code 500
#
#  Scenario: For field validation, user wants to configure profit rate where amount range to field value is undefined
#    When the user makes post call through json file "gl-profitRateConfig(UndefineAmountRangeTo)" to the service "/general-ledger-accounts/1268/profit-rates"
#    And the amount range to field value is null
#    Then the user should get status code 500
#
#  Scenario: For field validation, user wants to configure profit rate where amount range to field value is negative
#    When the user makes post call through json file "gl-profitRateConfig(NegativeAmountRangeTo)" to the service "/general-ledger-accounts/1268/profit-rates"
#    And the amount range to field value is negative
#    Then the user should get status code 500
#
#  Scenario: Limit Configuration for Internal type GL
#    When the user makes post call through json file "gl-limitConfig" to the service "/general-ledger-accounts/1268/limits"
#    Then the user should get status code 202
#
#  Scenario: user update Limit
#    When the user makes put call through json file "gl-limitUpdate" to the service "/general-ledger-accounts/1268/limits"
#    Then the user should get status code 202
#
#  Scenario: For field validation, user wants to configure Limit where branch is undefined
#    When the user makes post call through json file "gl-limitConfig(UndefineBranch)" to the service "/general-ledger-accounts/1269/limits"
#    And the branch field value is null
#    Then the user should get status code 500
#
#  Scenario: For field validation, user wants to configure Limit where balance limit is undefined
#    When the user makes post call through json file "gl-limitConfig(UndefineBalanceLimit)" to the service "/general-ledger-accounts/1269/limits"
#    And the balance limit field value is null
#    Then the user should get status code 500
#
#  Scenario: For field validation, user wants to configure Limit where balance limit field data is negative
#    When the user makes post call through json file "gl-limitConfig(NegativeBalanceLimit)" to the service "/general-ledger-accounts/1269/limits"
#    And the balance limit field value is negative
#    Then the user should get status code 500
#
#  Scenario: For field validation, user wants to configure Limit where monthly limit required is true but monthly limit is undefined
#    When the user makes post call through json file "gl-limitConfig(UndefineMonthlyLimit)" to the service "/general-ledger-accounts/347/limits"
#    And monthly limit required field value is true
#    But monthly limit field value is null
#    Then the user should get status code 500
#
#  Scenario: For field validation, user wants to update Limit where monthly limit required is true but monthly limit is undefined
#    When the user makes put call through json file "gl-limitUpdate(UndefineMonthlyLimit)" to the service "/general-ledger-accounts/347/limits"
#    And monthly limit required field value is true
#    But monthly limit field value is null
#    Then the user should get status code 500
#
#  Scenario: For field validation, user wants to configure Limit where monthly limit required is true but monthly limit field data is negative
#    When the user makes post call through json file "gl-limitConfig(NegativeMonthlyLimit)" to the service "/general-ledger-accounts/350/limits"
#    And monthly limit required field value is true
#    But monthly limit field value is negative
#    Then the user should get status code 500
#
#  Scenario: For field validation, user wants to configure Limit where monthly limit required is true but monthly limit is undefined
#    When the user makes post call through json file "gl-limitConfig(UnauthenticMonthlyLimit)" to the service "/general-ledger-accounts/348/limits"
#    And monthly limit required field value is false
#    But monthly limit field value is defined
#    Then the user should get status code 500
#
#  Scenario: Subsidiary Ledger configuration for Income type GL
#    When the user makes post call through json file "subsidiaryLedgerConfig" to the service "/subsidiary-ledgers"
#    Then the user should get status code 201
#
#  Scenario: User update Subsidiary Ledger
#    When the user makes put call through json file "subsidiaryLedgerUpdate" to the service "/subsidiary-ledgers/297"
#    Then the user should get status code 204
#
#  Scenario: For field validation, user wants to config Subsidiary Ledger where name field is undefine
#    When the user makes post call through json file "subsidiaryLedgerConfig(UndefineName)" to the service "/subsidiary-ledgers"
#    And the name field value is null
#    Then the user should get status code 500
#
#  Scenario: For field validation, user wants to config Subsidiary Ledger where branch field is undefine
#    When the user makes post call through json file "subsidiaryLedgerConfig(UndefineBranch)" to the service "/subsidiary-ledgers"
#    And the branch field value is null
#    Then the user should get status code 500
#
#  Scenario: For field validation, user wants to update Subsidiary Ledger where branch field is undefine
#    When the user makes put call through json file "subsidiaryLedgerUpdate(UndefineBranch)" to the service "/subsidiary-ledgers/297"
#    And the branch field value is null
#    Then the user should get status code 500
#
#  Scenario: For field validation, user wants to config Subsidiary Ledger where currency code field is undefine
#    When the user makes post call through json file "subsidiaryLedgerConfig(UndefineCurrencyCode)" to the service "/subsidiary-ledgers"
#    And the currency code field value is null
#    Then the user should get status code 500
#
#  Scenario: For field validation, user wants to update Subsidiary Ledger where code field is undefine
#    When the user makes put call through json file "subsidiaryLedgerUpdate(UndefineCode)" to the service "/subsidiary-ledgers/297"
#    And the code field value is null
#    Then the user should get status code 500