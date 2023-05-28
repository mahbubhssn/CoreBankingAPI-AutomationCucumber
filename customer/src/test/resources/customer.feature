Feature: customer information and validation check
  As a bank user
  I want to keep customer's proper information in details
  For that I will add customer info and check each field validation

  Scenario: the user calls auth for token validation
    When the user calls auth for token validation
    Then the user gets authentication for the service

  Scenario: user add single type customer information with all fields data
    When the user makes post call through json file "customerInfoFile(AllFieldData)" to the service "/customers"
    And json file "customerIndividualInfo(AllFieldData)" to the service "/customers/""id""/subjects"
    Then the user should get status code 201

  Scenario: user add single type customer information with gender(female) and resident status(resident)
    When the user makes post call through json file "customerInfoFile(FemaleResident)" to the service "/customers"
    And json file "customerIndividualInfo(FemaleResident)" to the service "/customers/""id""/subjects"
    Then the user should get status code 201

  Scenario: user add single type customer information with marital status(widow) and resident status(non-resident)
    When the user makes post call through json file "customerInfoFile(NonResidentWidow)" to the service "/customers"
    And json file "customerIndividualInfo(NonResidentWidow)" to the service "/customers/""id""/subjects"
    Then the user should get status code 201

  Scenario: user add single type customer information with age(senior)
    When the user makes post call through json file "customerInfoFile(Senior)" to the service "/customers"
    And json file "customerIndividualInfo(Senior)" to the service "/customers/""id""/subjects"
    Then the user should get status code 201

  Scenario: user add single type customer information with age(minor)
    When the user makes post call through json file "customerInfoFile(Minor)" to the service "/customers"
    And json file "customerIndividualInfo(Minor)" to the service "/customers/""id""/subjects"
    Then the user should get status code 201

#  Scenario: user updates single type customer information
#    When the user makes post call through json file "customerInfoFile(Update)" to the service "/customers"
#    And json file "customerIndividualInfo(Update)" to the service "/customers/""id""/subjects"
#    And the user makes put call through json file "updateCustomerIndividualInfo" to the service "/customers/""id""/subjects/""id"
#    Then the user should get status code 201

  Scenario: For field validation, user wants to create customer where the name field value is null
    When the user makes post call through json file "customerInfoFile(NameUndefine)" with negative data to the service "/customers"
    And the name field value is null
    Then the user should get status code 400

  Scenario: For field validation, user wants to create customer where the name format is not alphabetical
    When the user makes post call through json file "customerInfoFile(NameFormatCheck)" with negative data to the service "/customers"
    And the name format is not alphabetical
    Then the user should get status code 400

  Scenario: For field validation, user wants to create customer where the name length is above 50 characters
    When the user makes post call through json file "customerInfoFile(NameLengthCheck)" with negative data to the service "/customers"
    And the name length is above 50 characters
    Then the user should get status code 400

  Scenario: For field validation, user wants to create customer where the customer type is undefined
    When the user makes post call through json file "customerInfoFile(UndefineCustomerType)" with negative data to the service "/customers"
    And the customer type field value is null
    Then the user should get status code 400

  Scenario: For field validation, user wants to create customer where the relationship officer is undefined
    When the user makes post call through json file "customerInfoFile(UndefineRelationshipOfficer)" with negative data to the service "/customers"
    And the relationship officer field value is null
    Then the user should get status code 400

  Scenario: For field validation, user wants to create customer where all the mandatory field value is null
    When the user makes post call through json file "customerInfoFile(MandatoryFieldNullData)" to the service "/customers"
    And makes post call through json file "customerIndividualInfo(MandatoryFieldNullData)" with negative data to the service "/customers/""id""/subjects"
    And all mandatory fields data is null
    Then the user should get status code 400

  Scenario: For field validation, user wants to create customer where all fields data format is invalid
    When the user makes post call through json file "customerInfoFile(FieldDataFormatCheck)" to the service "/customers"
    And makes post call through json file "customerIndividualInfo(FieldDataFormatCheck)" with negative data to the service "/customers/""id""/subjects"
    And all fields data format is invalid
    Then the user should get status code 400

  Scenario: For field validation, user wants to create customer where all fields data length is invalid
    When the user makes post call through json file "customerInfoFile(FieldDataLengthCheck)" to the service "/customers"
    And makes post call through json file "customerIndividualInfo(FieldDataLengthCheck)" with negative data to the service "/customers/""id""/subjects"
    And all fields data length is invalid
    Then the user should get status code 400

  Scenario: For service validation, user wants to create customer where all dependent fields data is null
    When the user makes post call through json file "customerInfoFile(DependentFieldNullData)" to the service "/customers"
    And makes post call through json file "customerIndividualInfo(DependentFieldNullData)" with negative data to the service "/customers/""id""/subjects"
    And all dependent fields data is null
    Then the user should get status code 500

  Scenario: For service validation, user wants to create customer where all independent fields data is null
    When the user makes post call through json file "customerInfoFile(IndependentFieldNullData)" to the service "/customers"
    And makes post call through json file "customerIndividualInfo(IndependentFieldNullData)" with negative data to the service "/customers/""id""/subjects"
    And all the independent fields data is null
    Then the user should get status code 500

  Scenario: user add joint type customer information with two applicants
    When the user makes post call through json file "customerInfoFile(JointFirst-TwoIndividuals)" to the service "/customers"
    And post call through json file "customerIndividualInfo(JointFirst-FirstIndividual)" to the service "/customers/""id""/subjects"
    And post call through json file "customerIndividualInfo(JointFirst-SecondIndividual)" to the service "/customers/""id""/subjects"
    Then the user should get status code 201

  Scenario: user add joint type customer information with three applicants
    When the user makes post call through json file "customerInfoFile(JointSecond-ThreeIndividuals)" to the service "/customers"
    And post call through json file "customerIndividualInfo(JointSecond-FirstIndividual)" to the service "/customers/""id""/subjects"
    And post call through json file "customerIndividualInfo(JointSecond-SecondIndividual)" to the service "/customers/""id""/subjects"
    And post call through json file "customerIndividualInfo(JointSecond-ThirdIndividual)" to the service "/customers/""id""/subjects"
    Then the user should get status code 201

  Scenario: user add joint type customer information with five applicants
    When the user makes post call through json file "customerInfoFile(JointThird-FiveIndividuals)" to the service "/customers"
    And post call through json file "customerIndividualInfo(JointThird-FirstIndividual)" to the service "/customers/""id""/subjects"
    And post call through json file "customerIndividualInfo(JointThird-SecondIndividual)" to the service "/customers/""id""/subjects"
    And post call through json file "customerIndividualInfo(JointThird-ThirdIndividual)" to the service "/customers/""id""/subjects"
    And post call through json file "customerIndividualInfo(JointThird-FourthIndividual)" to the service "/customers/""id""/subjects"
    And post call through json file "customerIndividualInfo(JointThird-FifthIndividual)" to the service "/customers/""id""/subjects"
    Then the user should get status code 201

  Scenario: For field validation, user wants to add an applicant where applicant type is undefined
    When the user makes post call through json file "customerInfoFile(Joint-UndefineApplicantType)" to the service "/customers"
    And makes post call through json file "customerIndividualInfo(Joint-UndefineApplicantType)" with negative data to the service "/customers/""id""/subjects"
    And the applicant type field value is null
    Then the user should get status code 500

  Scenario: For field validation, user wants to add an applicant where applicant type field value is out of boundary
    When the user makes post call through json file "customerInfoFile(Joint-ApplicantTypeOutOfBoundary)" to the service "/customers"
    And makes post call through json file "customerIndividualInfo(Joint-ApplicantTypeOutOfBoundary)" with negative data to the service "/customers/""id""/subjects"
    And the applicant type field value is out of boundary
    Then the user should get status code 500

  Scenario: For field validation, user wants to add an applicant where applicant is out of boundary
    When the user makes post call through json file "customerInfoFile(Joint-ApplicantOutOfBoundary)" to the service "/customers"
    And post call through json file "customerIndividualInfo(JointThird-FirstIndividual)" to the service "/customers/""id""/subjects"
    And post call through json file "customerIndividualInfo(JointThird-SecondIndividual)" to the service "/customers/""id""/subjects"
    And post call through json file "customerIndividualInfo(JointThird-ThirdIndividual)" to the service "/customers/""id""/subjects"
    And post call through json file "customerIndividualInfo(JointThird-FourthIndividual)" to the service "/customers/""id""/subjects"
    And post call through json file "customerIndividualInfo(JointThird-FifthIndividual)" to the service "/customers/""id""/subjects"
    And post call through json file "customerIndividualInfo(Joint-ApplicantOutOfBoundary)" to the service "/customers/""id""/subjects"
    And the applicant is out of boundary
    Then the user should get status code 400

  Scenario: user add organization type customer information and add owners to that organization
    When the user makes post call through json file "customerInfoFile(Organization-Public)" to the service "/customers"
    And json file "customerIndividualInfo(Organization-Public)" to the service "/customers/""id""/subjects"
    And post call through json file "customerIndividualInfo(OwnerFirst)" to the service "/customers/organizations/""id""/owners"
    And post call through json file "customerIndividualInfo(OwnerSecond)" to the service "/customers/organizations/""id""/owners"
    Then the user should get status code 200

#  Scenario: user updates organization type customer information
#    When the user makes post call through json file "customerInfoFile(Update-Org)" to the service "/customers"
#    And json file "customerIndividualInfo(Update-Org)" to the service "/customers/""id""/subjects"
#    And the user makes put call through json file "updateCustomerIndividualInfo(Org)" to the service "/customers/""id""/subjects/""id"
#    Then the user should get status code 201

  Scenario: For field validation, user wants to add organization type customer information where all the mandatory field value is null
    When the user makes post call through json file "customerInfoFile(Org-MandatoryFieldNullData)" to the service "/customers"
    And makes post call through json file "customerIndividualInfo(Org-MandatoryFieldNullData)" with negative data to the service "/customers/""id""/subjects"
    And all mandatory fields data is null
    Then the user should get status code 400

  Scenario: For field validation, user wants to add organization type customer information where all fields data format is invalid
    When the user makes post call through json file "customerInfoFile(Org-FieldDataFormatCheck)" to the service "/customers"
    And makes post call through json file "customerIndividualInfo(Org-FieldDataFormatCheck)" with negative data to the service "/customers/""id""/subjects"
    And all fields data format is invalid
    Then the user should get status code 400

  Scenario: For field validation, user wants to add organization type customer information where all fields data length is invalid
    When the user makes post call through json file "customerInfoFile(Org-FieldDataLengthCheck)" to the service "/customers"
    And makes post call through json file "customerIndividualInfo(Org-FieldDataLengthCheck)" with negative data to the service "/customers/""id""/subjects"
    And all fields data length is invalid
    Then the user should get status code 400

  Scenario: For service validation, user add owners to the organization type customer where the share percentage already covered by other owners
    When the user makes post call through json file "customerInfoFile(Org-OwnerShareOutOfBoundary)" to the service "/customers"
    And json file "customerIndividualInfo(Org-OwnerShareOutOfBoundary)" to the service "/customers/""id""/subjects"
    And makes post call through json file "customerIndividualInfo(OwnerShareOutOfBoundary)" with negative data to the service "/customers/organizations/""id""/owners"
    And the share percentage already covered
    Then the user should get status code 500