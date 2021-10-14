Feature: Testing a category REST API with Karate
  Background:
    * def newUrl = 'http://localhost:8080/categories'

  Scenario: Testing POST
    Given url newUrl
    And request { name: 'John Smith' , description: 'John Smith1'}
    When method POST
    Then status 201

  Scenario: Testing GET (good after successful POST)
    Given url newUrl
    When method GET
    Then status 200
    And match $ contains { id:#notnull , name: #notnull , description: #notnull}

  Scenario: Testing PUT in first in list

    Given url newUrl
    When method GET
    Then status 200
    And def testId = response[0].id

    Given url newUrl+'/'+testId
    And request { name: 'John Smith2' , description: 'John Smith2'}
    When method PUT
    Then status 200
    And match $ contains { id:#(testId) , name: 'John Smith2' , description: 'John Smith2'}

  Scenario: Testing DELETE first in list
    Given url newUrl
    When method GET
    Then status 200

    Given url newUrl+'/'+response[0].id
    When method DELETE
    Then status 200

