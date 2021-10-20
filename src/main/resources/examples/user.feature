Feature: Test user REST API with karate
 Scenario: Test GET
  Given url '/username/id'
  When method GET
  Then status 200
  And match $ contains  {id: #notnull, username: #notnull}