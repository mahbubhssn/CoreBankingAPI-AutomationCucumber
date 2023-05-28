Feature: Deposit account creation and validation check
  As a bank user
  I want to create various type deposit account

  Scenario: demand deposit account creation
    Given user makes get call to get demand deposit account number to the service "/products/""productID""/accounts/?branchId=""branchID"
    When the user makes post call to create demand deposit account through json file "depositAccount(DDAccountCreation)" with positive data to the service "/demand-deposit-accounts"
    Then the user should get status code 201

  Scenario: demand deposit account update
    Given the user makes get call to get demand deposit account number to the service "/products/""productID""/accounts/?branchId=""branchID"
    When the user makes post call to create demand deposit account through json file "depositAccount(DDAccountCreation)" with positive data to the service "/demand-deposit-accounts"
    And the user makes put call to update demand deposit account through json file "depositAccount(DDAccountUpdate)" to the service "/demand-deposit-accounts/""id"
    Then the user should get status code 202

  Scenario: For field validation, user wants to create demand deposit account where mandatory fields value is null
    Given the user makes get call to get demand deposit account number to the service "/products/""productID""/accounts/?branchId=""branchID"
    When the user makes post call to create demand deposit account through json file "depositAccount(DDAccountCreation-UndefineMandatoryFields)" with negative data to the service "/demand-deposit-accounts"
    And the mandatory fields value is null
    Then the user should get status code 400

  Scenario: For field validation, user wants to update demand deposit account where mandatory fields value is null
    Given the user makes get call to get demand deposit account number to the service "/products/""productID""/accounts/?branchId=""branchID"
    When the user makes post call to create demand deposit account through json file "depositAccount(DDAccountCreation)" with positive data to the service "/demand-deposit-accounts"
    And the user makes put call to update demand deposit account through json file "depositAccount(DDAccountUpdate-UndefineMandatoryFields)" to the service "/demand-deposit-accounts/""id"
    And the mandatory fields value is null
    Then the user should get status code 500

  Scenario: For field validation, user wants to create demand deposit account where mandatory fields value is in irrelevant format
    Given the user makes get call to get demand deposit account number to the service "/products/""productID""/accounts/?branchId=""branchID"
    When the user makes post call to create demand deposit account through json file "depositAccount(DDAccountCreation-MandatoryFieldsFormatCheck)" with negative data to the service "/demand-deposit-accounts"
    And the mandatory fields value is in irrelevant format
    Then the user should get status code 400

  Scenario: For field validation, user wants to create demand deposit account where currency code field value is irrelevant
    Given the user makes get call to get demand deposit account number to the service "/products/""productID""/accounts/?branchId=""branchID"
    When the user makes post call to create demand deposit account through json file "depositAccount(DDAccountCreation-CurrencyCodeIrrelevant)" with negative data to the service "/demand-deposit-accounts"
    And the currency code field value is irrelevant
    Then the user should get status code 500

  Scenario: For field validation, user wants to create demand deposit account where optional fields format is invalided
    Given the user makes get call to get demand deposit account number to the service "/products/""productID""/accounts/?branchId=""branchID"
    When the user makes post call to create demand deposit account through json file "depositAccount(DDAccountCreation-OptionalFieldsFormatCheck)" with negative data to the service "/demand-deposit-accounts"
    And the optional fields format is invalided
    Then the user should get status code 500

  # Demand Deposit Account Nominee Test

  Scenario: For field validation, user wants to add nominee into the demand deposit account where mandatory fields value is null
    When the user makes post call to add nominee through json file "depositAccount(AddNominee-UndefineMandatoryFields)" with negative data to the service "/nominees"
    And the mandatory fields value is null
    Then the user should get status code 400

  Scenario: For field validation, user wants to add nominee into the demand deposit account where share percentage is out of boundary
    When the user makes post call to add nominee through json file "depositAccount(AddNominee-ShareOutOfBoundary)" with negative data to the service "/nominees"
    And the share percentage is out of boundary
    Then the user should get status code 500

  Scenario: add nominee into the demand deposit account
    When the user makes post call to add nominee through json file "depositAccount(AddNominee)" with positive data to the service "/nominees"
    Then the user should get status code 202

  Scenario: update nominee into the demand deposit account
    When the user makes put call to update nominee through json file "depositAccount(UpdateNominee)" to the service "/nominees/""nomineeID"
    Then the user should get status code 202

  # Demand Deposit Account Transaction profile Test

  Scenario: For field validation, user wants to add transaction profile into the demand deposit account where mandatory fields value is null
    When the user makes post call to add transaction profile through json file "depositAccount(DDAccount-AddTransactionProfile-UndefineMandatoryFields)" with negative data to the service "/demand-deposit-accounts/""id""/transaction-profiles"
    And the mandatory fields value is null
    Then the user should get status code 500

  Scenario: add transaction profile into the demand deposit account
    When the user makes post call to add transaction profile through json file "depositAccount(DDAccount-AddTransactionProfile)" with positive data to the service "/demand-deposit-accounts/""id""/transaction-profiles"
    Then the user should get status code 202

  Scenario: update transaction profile into the demand deposit account
    When the user makes put call to update transaction profile through json file "depositAccount(DDAccount-UpdateTransactionProfile)" to the service "/demand-deposit-accounts/""id""/transaction-profiles"
    Then the user should get status code 202

  # Demand Deposit Account Owner Signature Test

  Scenario: For field validation, user wants to add account owner signature into the demand deposit account where all mandatory fields data are undefined
    Given the user makes get call to get operator information to the service "/accounts/""accountId""/operator-information"
    When the user makes post call to add account owner signature through json file "depositAccount(AccountOwnerSignature-UndefineMandatoryFields)" with negative data to the service "/accounts/""id""/operator-information/""id""/signatories"
    And the mandatory fields value is null
    Then the user should get status code 400

  Scenario: add account owner signature into the demand deposit account
    Given the user makes get call to get operator information to the service "/accounts/""accountId""/operator-information"
    When the user makes post call to add account owner signature through json file "depositAccount(AccountOwnerSignature)" with positive data to the service "/accounts/""id""/operator-information/""id""/signatories"
    Then the user should get status code 201

  Scenario: update account owner signature of the demand deposit account
    Given the user makes get call to get operator information to the service "/accounts/""accountId""/operator-information"
    When the user makes put call to update account owner signature through json file "depositAccount(UpdateAccountOwnerSignature)" to the service "/accounts/""accountID""/operator-information/""operatorID""/signatories/""signatoryID"
    Then the user should get status code 202

  # Demand Deposit Account Nominated Signature Test

  Scenario: For field validation, user wants to add nominated signature into the demand deposit account where all mandatory fields data are undefined
    Given the user makes get call to get operator information to the service "/accounts/""accountId""/operator-information"
    When the user makes post call to add nominated signature through json file "depositAccount(NominatedSignature-UndefineMandatoryFields)" with negative data to the service "/accounts/""id""/operator-information/""id""/signatories"
    And the mandatory fields value is null
    Then the user should get status code 400

  Scenario: add nominated signature into the demand deposit account
    Given the user makes get call to get operator information to the service "/accounts/""accountId""/operator-information"
    When the user makes post call to add nominated signature through json file "depositAccount(NominatedSignature)" with positive data to the service "/accounts/""id""/operator-information/""id""/signatories"
    Then the user should get status code 201

  Scenario: update account nominated signature of the demand deposit account
    Given the user makes get call to get operator information to the service "/accounts/""accountId""/operator-information"
    When the user makes put call to update nominated signature through json file "depositAccount(UpdateNominatedSignature)" to the service "/accounts/""accountID""/operator-information/""operatorID""/signatories/""signatoryID"
    Then the user should get status code 202

  # Demand Deposit Account Activation Test

  Scenario: activate demand deposit account
    When the user makes post call for demand deposit account activation through json file "depositAccount(Activation)" to the service "/demand-deposit-accounts/""id""/commands"
    Then the user should get status code 202

  # Demand Deposit Account Cheque Test

  Scenario: For field validation, user wants to add cheque into the demand deposit account where all mandatory fields data are undefined
    When the user makes post call to add cheque through json file "depositAccount(DDAccount-AddCheque-UndefineMandatoryFields)" with negative data to the service "/demand-deposit-accounts/""accountID""/chequeBooks"
    And the mandatory fields value is null
    Then the user should get status code 500

  Scenario: add cheque into the demand deposit account
    When the user makes post call to add cheque through json file "depositAccount(DDAccount-AddCheque)" with positive data to the service "/demand-deposit-accounts/""accountID""/chequeBooks"
    Then the user should get status code 201

  # Demand Deposit Account KYC Test

  Scenario: add kyc into the demand deposit account
    When the user makes post call to add kyc through json file "depositAccount(DDAccount-AddKYC)" to the service "/kyces"
    Then the user should get status code 202

  Scenario: update kyc of the demand deposit account
    When the user makes put call to update kyc through json file "depositAccount(DDAccount-UpdateKYC)" to the service "/kyces/""kycID"
    Then the user should get status code 202

  # Demand Deposit Account Bank Notice Test

  Scenario: For field validation, user wants to add bank notice into the demand deposit account where all mandatory fields data are undefined
    When the user makes post call to add bank notice through json file "depositAccount(DDAccount-AddBankNotice-UndefineMandatoryFields)" with negative data to the service "/demand-deposit-accounts/""accountID""/notices"
    And the mandatory fields value is null
    Then the user should get status code 400

  Scenario: add bank notice into the demand deposit account
    When the user makes post call to add bank notice through json file "depositAccount(DDAccount-AddBankNotice)" with positive data to the service "/demand-deposit-accounts/""accountID""/notices"
    Then the user should get status code 201

  Scenario: update bank notice into the demand deposit account
    When the user makes put call to update bank notice through json file "depositAccount(DDAccount-UpdateBankNotice)" to the service "/demand-deposit-accounts/""accountID""/notices/""noticeID"
    Then the user should get status code 202

  # Demand Deposit Account Special Instruction Test

  Scenario: add special instruction into the demand deposit account
    When the user makes post call to add special instruction through json file "depositAccount(DDAccount-AddSpecialInstruction)" with positive data to the service "demand-deposit-accounts/""accountID""/instructions"
    Then the user should get status code 201

  Scenario: withdraw special instruction from the demand deposit account
    When the user makes post call to withdraw special instruction through json file "depositAccount(DDAccount-WithdrawSpecialInstruction)" to the service "demand-deposit-accounts/""accountID""/instructions/""instructionID""/command"
    Then the user should get status code 202

  Scenario: For field validation, user wants to add special instruction into the demand deposit account where all mandatory fields data are undefined
    When the user makes post call to add special instruction through json file "depositAccount(DDAccount-AddSpecialInstruction-UndefineMandatoryFields)" with negative data to the service "/demand-deposit-accounts/""accountID""/instructions"
    And the mandatory fields value is null
    Then the user should get status code 500

  # Demand Deposit Account Special Profit Rate Test

  Scenario: For field validation, user wants to add special profit rate into the demand deposit account where all mandatory fields data are undefined
    When the user makes post call to add special profit rate through json file "depositAccount(AddSpecialProfitRate-UndefineMandatoryFields)" with negative data to the service "accounts/""accountID""/special-profit-rates"
    And the mandatory fields value is null
    Then the user should get status code 400

  Scenario: add special profit rate into the demand deposit account
    When the user makes post call to add special profit rate through json file "depositAccount(AddSpecialProfitRate)" with positive data to the service "accounts/""accountID""/special-profit-rates"
    Then the user should get status code 201

  Scenario: update special profit rate into the demand deposit account
    When the user makes put call to update special profit rate through json file "depositAccount(UpdateSpecialProfitRate)" to the service "accounts/""accountID""/special-profit-rates/""id"
    Then the user should get status code 202

  # Demand Deposit Account Minimum Balance Test

  Scenario: update minimum balance into the demand deposit account
    When the user makes put call to update minimum balance through json file "depositAccount(DDAccount-UpdateMinimumBalance)" to the service "/demand-deposit-accounts/""accountID""/balances"
    Then the user should get status code 202

  # Demand Deposit Account Freeze Unfreeze Test

  Scenario: freeze demand deposit account
    When the user makes post call to freeze account through json file "depositAccount(Freeze)" to the service "accounts/""id""/commands"
    Then the user should get status code 202

  Scenario: unfreeze demand deposit account
    When the user makes post call to unfreeze account through json file "depositAccount(Unfreeze)" to the service "accounts/""id""/commands"
    Then the user should get status code 202

  # Fixed Deposit Account Test

  Scenario: fixed deposit account creation
    Given user makes get call to get fixed deposit account number to the service "/products/""productID""/accounts/?branchId=""branchID"
    When the user makes post call to create fixed deposit account through json file "depositAccount(FDAccountCreation)" with positive data to the service "/fixed-deposit-accounts"
    Then the user should get status code 202

  Scenario: fixed deposit account update
    Given the user makes get call to get fixed deposit account number to the service "/products/""productID""/accounts/?branchId=""branchID"
    When the user makes post call to create fixed deposit account through json file "depositAccount(FDAccountCreation)" with positive data to the service "/fixed-deposit-accounts"
    And the user makes put call to update fixed deposit account through json file "depositAccount(FDAccountUpdate)" to the service "/fixed-deposit-accounts/""id"
    Then the user should get status code 202

  Scenario: For field validation, user wants to create fixed deposit account where mandatory fields value is null
    Given the user makes get call to get fixed deposit account number to the service "/products/""productID""/accounts/?branchId=""branchID"
    When the user makes post call to create fixed deposit account through json file "depositAccount(FDAccountCreation-UndefineMandatoryFields)" with negative data to the service "/fixed-deposit-accounts"
    And the mandatory fields value is null
    Then the user should get status code 500

  Scenario: For field validation, user wants to update fixed deposit account where mandatory fields value is null
    Given the user makes get call to get fixed deposit account number to the service "/products/""productID""/accounts/?branchId=""branchID"
    When the user makes post call to create fixed deposit account through json file "depositAccount(FDAccountCreation)" with positive data to the service "/fixed-deposit-accounts"
    When the user makes put call to update fixed deposit account through json file "depositAccount(FDAccountUpdate-UndefineMandatoryFields)" to the service "/fixed-deposit-accounts/""id"
    And the mandatory fields value is null
    Then the user should get status code 500

  Scenario: For field validation, user wants to create fixed deposit account where all fields value is in irrelevant format
    Given the user makes get call to get fixed deposit account number to the service "/products/""productID""/accounts/?branchId=""branchID"
    When the user makes post call to create fixed deposit account through json file "depositAccount(FDAccountCreation-FieldsFormatCheck)" with negative data to the service "/fixed-deposit-accounts"
    And all the fields value is in irrelevant format
    Then the user should get status code 500

  Scenario: For field validation, user wants to create fixed deposit account where currency code field value is irrelevant
    Given the user makes get call to get fixed deposit account number to the service "/products/""productID""/accounts/?branchId=""branchID"
    When the user makes post call to create fixed deposit account through json file "depositAccount(FDAccountCreation-CurrencyCodeIrrelevant)" with negative data to the service "/fixed-deposit-accounts"
    And the currency code field value is irrelevant
    Then the user should get status code 500

  # Fixed Deposit Account Nominee Test

  Scenario: For field validation, user wants to add nominee into the fixed deposit account where mandatory fields value is null
    When the user makes post call to add nominee into fixed deposit account through json file "depositAccount(AddNominee-UndefineMandatoryFields)" with negative data to the service "/nominees"
    And the mandatory fields value is null
    Then the user should get status code 500

  Scenario: For field validation, user wants to add nominee into the fixed deposit account where share percentage is out of boundary
    When the user makes post call to add nominee into fixed deposit account through json file "depositAccount(AddNominee-ShareOutOfBoundary)" with negative data to the service "/nominees"
    And the share percentage is out of boundary
    Then the user should get status code 500

    Scenario: add nominee into the fixed deposit account
    When the user makes post call to add nominee into fixed deposit account through json file "depositAccount(AddNominee)" with positive data to the service "/nominees"
    Then the user should get status code 202

  Scenario: update nominee into the fixed deposit account
    When the user makes put call to update nominee into fixed deposit account through json file "depositAccount(UpdateNominee)" to the service "/nominees/""nomineeID"
    Then the user should get status code 202

  # Fixed Deposit Account Owner Signature Test

  Scenario: For field validation, user wants to add account owner signature into the fixed deposit account where all mandatory fields data are undefined
    Given the user makes get call to get fixed deposit account operator information to the service "/accounts/""accountId""/operator-information"
    When the user makes post call to add fixed deposit account owner signature through json file "depositAccount(AccountOwnerSignature-UndefineMandatoryFields)" with negative data to the service "/accounts/""accountID""/operator-information/""operatorID""/signatories"
    And the mandatory fields value is null
    Then the user should get status code 500

  Scenario: add account owner signature into the fixed deposit account
    Given the user makes get call to get fixed deposit account operator information to the service "/accounts/""accountId""/operator-information"
    When the user makes post call to add fixed deposit account owner signature through json file "depositAccount(AccountOwnerSignature)" with positive data to the service "/accounts/""accountID""/operator-information/""operatorID""/signatories"
    Then the user should get status code 201

  Scenario: update account owner signature of the fixed deposit account
    Given the user makes get call to get fixed deposit account operator information to the service "/accounts/""accountId""/operator-information"
    When the user makes put call to update fixed deposit account owner signature through json file "depositAccount(UpdateAccountOwnerSignature)" to the service "/accounts/""accountID""/operator-information/""operatorID""/signatories/""signatoryID"
    Then the user should get status code 202

  # Fixed Deposit Account Nominated Signature Test

  Scenario: For field validation, user wants to add nominated signature into the fixed deposit account where all mandatory fields data are undefined
    Given the user makes get call to get fixed deposit account operator information to the service "/accounts/""accountId""/operator-information"
    When the user makes post call to add fixed deposit account nominated signature through json file "depositAccount(NominatedSignature-UndefineMandatoryFields)" with negative data to the service "/accounts/""accountID""/operator-information/""operatorID""/signatories"
    And the mandatory fields value is null
    Then the user should get status code 500

  Scenario: add nominated signature into the fixed deposit account
    Given the user makes get call to get fixed deposit account operator information to the service "/accounts/""accountId""/operator-information"
    When the user makes post call to add fixed deposit account nominated signature through json file "depositAccount(NominatedSignature)" with positive data to the service "/accounts/""accountID""/operator-information/""operatorID""/signatories"
    Then the user should get status code 201

  Scenario: update account nominated signature of the fixed deposit account
    Given the user makes get call to get fixed deposit account operator information to the service "/accounts/""accountId""/operator-information"
    When the user makes put call to update fixed deposit account nominated signature through json file "depositAccount(UpdateNominatedSignature)" to the service "/accounts/""accountID""/operator-information/""operatorID""/signatories/""signatoryID"
    Then the user should get status code 202

  # Fixed Deposit Account KYC Test

  Scenario: add kyc into the fixed deposit account
    When the user makes post call to add kyc into fixed deposit account through json file "depositAccount(FDAccount-AddKYC)" to the service "/kyces"
    Then the user should get status code 202

  Scenario: update kyc of the fixed deposit account
    When the user makes put call to update kyc into fixed deposit account through json file "depositAccount(FDAccount-UpdateKYC)" to the service "/kyces/""kycID"
    Then the user should get status code 202

  # Fixed Deposit Account Activation Test

  Scenario: activate fixed deposit account
    When the user makes post call for fixed deposit account activation through json file "depositAccount(Activation)" to the service "/fixed-deposit-accounts/""id""/commands"
    Then the user should get status code 202

  # Fixed Deposit Account Special Profit Rate Test

  Scenario: For field validation, user wants to add special profit rate into the fixed deposit account where all mandatory fields data are undefined
    When the user makes post call to add special profit rate into fixed deposit account through json file "depositAccount(AddSpecialProfitRate-UndefineMandatoryFields)" with negative data to the service "accounts/""accountID""/special-profit-rates"
    And the mandatory fields value is null
    Then the user should get status code 500

  Scenario: add special profit rate into the fixed deposit account
    When the user makes post call to add special profit rate into fixed deposit account through json file "depositAccount(AddSpecialProfitRate)" with positive data to the service "accounts/""accountID""/special-profit-rates"
    Then the user should get status code 201

  Scenario: update special profit rate into the fixed deposit account
    When the user makes put call to update special profit rate into fixed deposit account through json file "depositAccount(UpdateSpecialProfitRate)" to the service "accounts/""accountID""/special-profit-rates/""id"
    Then the user should get status code 202

  # Fixed Deposit Account Withdrawal Advice Test

  Scenario: For field validation, user wants to add withdrawal advice into the fixed deposit account where all the mandatory fields are undefined
    Given the user makes get call to get fixed deposit withdrawal advice reference number to the service "/fixed-deposit-withdrawal-advice/""fixedDepositAccountId""/advice-no"
    When the user makes post call to add withdrawal advice through json file "depositAccount(FDAccount-AddWithdrawalAdvice-UndefineMandatoryFields)" with negative data to the service "fixed-deposit-withdrawal-advice/""id"
    And the mandatory fields value is null
    Then the user should get status code 500

  Scenario: add withdrawal advice into the fixed deposit account
    Given the user makes get call to get fixed deposit withdrawal advice reference number to the service "/fixed-deposit-withdrawal-advice/""fixedDepositAccountId""/advice-no"
    When the user makes post call to add withdrawal advice through json file "depositAccount(FDAccount-AddWithdrawalAdvice)" with positive data to the service "fixed-deposit-withdrawal-advice/""id"
    Then the user should get status code 202

  # Fixed Deposit Account Freeze Unfreeze Test

  Scenario: freeze demand deposit account
    When the user makes post call to freeze account through json file "depositAccount(Freeze)" to the service "accounts/""id""/commands"
    Then the user should get status code 202

  Scenario: unfreeze demand deposit account
    When the user makes post call to unfreeze account through json file "depositAccount(Unfreeze)" to the service "accounts/""id""/commands"
    Then the user should get status code 202

  # Installment Deposit Account Test

  Scenario: installment deposit account creation
    Given user makes get call to get installment deposit account number to the service "/products/""productID""/accounts/?branchId=""branchID"
    When the user makes post call to create installment deposit account through json file "depositAccount(IDAccountCreation)" with positive data to the service "/recurring-deposit-accounts"
    Then the user should get status code 202

  Scenario: installment deposit account update
    Given the user makes get call to get installment deposit account number to the service "/products/""productID""/accounts/?branchId=""branchID"
    When the user makes post call to create installment deposit account through json file "depositAccount(IDAccountCreation)" with positive data to the service "/recurring-deposit-accounts"
    And the user makes put call to update installment deposit account through json file "depositAccount(IDAccountUpdate)" to the service "/recurring-deposit-accounts/""id"
    Then the user should get status code 202

  Scenario: For field validation, user wants to create installment deposit account where mandatory fields value is null
    Given the user makes get call to get installment deposit account number to the service "/products/""productID""/accounts/?branchId=""branchID"
    When the user makes post call to create installment deposit account through json file "depositAccount(IDAccountCreation-UndefineMandatoryFields)" with negative data to the service "/recurring-deposit-accounts"
    And the mandatory fields value is null
    Then the user should get status code 500

  Scenario: For field validation, user wants to update installment deposit account where mandatory fields value is null
    Given the user makes get call to get installment deposit account number to the service "/products/""productID""/accounts/?branchId=""branchID"
    When the user makes post call to create installment deposit account through json file "depositAccount(IDAccountCreation)" with positive data to the service "/recurring-deposit-accounts"
    And the user makes put call to update installment deposit account through json file "depositAccount(IDAccountUpdate-UndefineMandatoryFields)" to the service "/recurring-deposit-accounts/""id"
    And the mandatory fields value is null
    Then the user should get status code 500

  Scenario: For field validation, user wants to create installment deposit account where all fields value is in irrelevant format
    Given the user makes get call to get installment deposit account number to the service "/products/""productID""/accounts/?branchId=""branchID"
    When the user makes post call to create installment deposit account through json file "depositAccount(IDAccountCreation-FieldsFormatCheck)" with negative data to the service "/recurring-deposit-accounts"
    And all the fields value is in irrelevant format
    Then the user should get status code 500

  Scenario: For field validation, user wants to create installment deposit account where currency code field value is irrelevant
    Given the user makes get call to get installment deposit account number to the service "/products/""productID""/accounts/?branchId=""branchID"
    When the user makes post call to create installment deposit account through json file "depositAccount(IDAccountCreation-CurrencyCodeIrrelevant)" with negative data to the service "/recurring-deposit-accounts"
    And the currency code field value is irrelevant
    Then the user should get status code 500

  # Installment Deposit Account Nominee Test

  Scenario: For field validation, user wants to add nominee into the installment deposit account where mandatory fields value is null
    When the user makes post call to add nominee into installment deposit account through json file "depositAccount(AddNominee-UndefineMandatoryFields)" with negative data to the service "/nominees"
    And the mandatory fields value is null
    Then the user should get status code 500

  Scenario: For field validation, user wants to add nominee into the installment deposit account where share percentage is out of boundary
    When the user makes post call to add nominee into installment deposit account through json file "depositAccount(AddNominee-ShareOutOfBoundary)" with negative data to the service "/nominees"
    And the share percentage is out of boundary
    Then the user should get status code 500

  Scenario: add nominee into the installment deposit account
    When the user makes post call to add nominee into installment deposit account through json file "depositAccount(AddNominee)" with positive data to the service "/nominees"
    Then the user should get status code 202

  Scenario: update nominee into the installment deposit account
    When the user makes put call to update nominee into installment deposit account through json file "depositAccount(UpdateNominee)" to the service "/nominees/""nomineeID"
    Then the user should get status code 202

  # Installment Deposit Account Owner Signature Test

  Scenario: For field validation, user wants to add account owner signature into the installment deposit account where all mandatory fields data are undefined
    Given the user makes get call to get installment deposit account operator information to the service "/accounts/""accountId""/operator-information"
    When the user makes post call to add installment deposit account owner signature through json file "depositAccount(AccountOwnerSignature-UndefineMandatoryFields)" with negative data to the service "/accounts/""accountID""/operator-information/""operatorID""/signatories"
    And the mandatory fields value is null
    Then the user should get status code 500

  Scenario: add account owner signature into the installment deposit account
    Given the user makes get call to get installment deposit account operator information to the service "/accounts/""accountId""/operator-information"
    When the user makes post call to add installment deposit account owner signature through json file "depositAccount(AccountOwnerSignature)" with positive data to the service "/accounts/""accountID""/operator-information/""operatorID""/signatories"
    Then the user should get status code 201

  Scenario: update account owner signature of the installment deposit account
    Given the user makes get call to get installment deposit account operator information to the service "/accounts/""accountId""/operator-information"
    When the user makes put call to update installment deposit account owner signature through json file "depositAccount(UpdateAccountOwnerSignature)" to the service "/accounts/""accountID""/operator-information/""operatorID""/signatories/""signatoryID"
    Then the user should get status code 202

  # Installment Deposit Account Nominated Signature Test

  Scenario: For field validation, user wants to add nominated signature into the installment deposit account where all mandatory fields data are undefined
    Given the user makes get call to get installment deposit account operator information to the service "/accounts/""accountId""/operator-information"
    When the user makes post call to add installment deposit account nominated signature through json file "depositAccount(NominatedSignature-UndefineMandatoryFields)" with negative data to the service "/accounts/""accountID""/operator-information/""operatorID""/signatories"
    And the mandatory fields value is null
    Then the user should get status code 500

  Scenario: add nominated signature into the installment deposit account
    Given the user makes get call to get installment deposit account operator information to the service "/accounts/""accountId""/operator-information"
    When the user makes post call to add installment deposit account nominated signature through json file "depositAccount(NominatedSignature)" with positive data to the service "/accounts/""accountID""/operator-information/""operatorID""/signatories"
    Then the user should get status code 201

  Scenario: update account nominated signature of the installment deposit account
    Given the user makes get call to get installment deposit account operator information to the service "/accounts/""accountId""/operator-information"
    When the user makes put call to update installment deposit account nominated signature through json file "depositAccount(UpdateNominatedSignature)" to the service "/accounts/""accountID""/operator-information/""operatorID""/signatories/""signatoryID"
    Then the user should get status code 202

  # Installment Deposit Account KYC Test

  Scenario: add kyc into the installment deposit account
    When the user makes post call to add kyc into installment deposit account through json file "depositAccount(IDAccount-AddKYC)" to the service "/kyces"
    Then the user should get status code 202

  Scenario: update kyc of the installment deposit account
    When the user makes put call to update kyc into installment deposit account through json file "depositAccount(IDAccount-UpdateKYC)" to the service "/kyces/""kycID"
    Then the user should get status code 202
