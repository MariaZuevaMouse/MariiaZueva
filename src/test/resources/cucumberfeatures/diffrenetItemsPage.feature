Feature: Different element page tests
  Scenario: Different element page logs
    Given I open JDI GitHub site
    And I login as user 'Roman Iovlev'
    When I click on 'Service' button in Header
    And I click on 'Different Elements' button in Service dropdown
    And I select 'Water' checkbox
    And I select 'Wind' checkbox
    And I select Selen radio
    And I select Yellow in color dropdown
    Then separate log for Water checkbox in log section with true status
    And separate log for Wind checkbox in log section with true status
    And separate log for Selen radio in log section with true status
    And separate log for Yellow dropdown in log section with true status