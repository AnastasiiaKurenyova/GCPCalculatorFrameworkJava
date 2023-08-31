Feature: Calculate price for GCP Services
  As a common user
  I want to calculate GCP price
  So that I input different values to the calculator form

  Background: User is navigated to GCP Calculator page
    Given I navigated to GCP Calculator page


  @Smoke
  Scenario Outline: Calculate price for Compute Engine service using only required fields
    Given Compute Engine service is checked on Service Tab
    When I fill Number of instances field with <instances>
    And I click Add to Estimate button
    Then I should get the total estimated cost <total estimated cost>$ on Estimation page with <last added module>

    Examples:
      | instances | total estimated cost | last added module |
      | 1         | 48.92                | Compute Engine    |


  @Regression
  Scenario Outline: Calculate price for GKE Standard service using only required fields
    Given GKE Standard service is checked on Service Tab
    When I fill Total number of nodes in Node Pool field with <nodes>
    And I click Add to Estimate button
    Then I should get the total estimated cost <total estimated cost>$ on Estimation page with <last added module>

    Examples:
      | nodes | total estimated cost | last added module |
      | 6     | 145.63               | Compute Engine    |


  @Regression
  Scenario Outline: Calculate price for Compute Engine and GKE Standard service using only required fields
    Given Compute Engine service is checked on Service Tab
    When I fill Number of instances field with <instances>
    And I click Add to Estimate button
    And I navigate to GKE Standard service on Service Tab
    And I fill Total number of nodes in Node Pool field with <nodes>
    And I click Add to Estimate button
    Then I should get the total estimated cost <total estimated cost>$ on Estimation page with <last added module>

    Examples:
      | instances | nodes | total estimated cost | last added module |
      | 1         | 6     | 194.55               | GKE Standard      |


  @Regression
  Scenario Outline: Calculate price for Compute Engine service
    Given Compute Engine service is checked on Service Tab
    When I fill fields for Compute Engine service to proceed with parameters:
      | instances   | osSoftware   | provisioningModel   | machineFamily   | series   | machineType   | bootDiskSize   |
      | <instances> | <osSoftware> | <provisioningModel> | <machineFamily> | <series> | <machineType> | <bootDiskSize> |
    And I click Add to Estimate button
    Then I should get the total estimated cost <total estimated cost>$ on Estimation page with <last added module>

    Examples:
      | instances | osSoftware  | provisioningModel | machineFamily | series | machineType   | bootDiskSize | total estimated cost | last added module |
      | 1         | PAID_UBUNTU | REGULAR           | GENERAL       | E2     | e2-micro      | 500          | 57.42                | Compute Engine    |
      | 2         | FREE_DEBIAN | SPOT              | COMPUTE       | C2     | c2-standard-8 | 1000         | 255.34               | Compute Engine    |
