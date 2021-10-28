Feature: Testing Api product controller
  Background: Testing logging in FormLogin with csrf

    * def testUrl = 'http://localhost:8080/product'
    Given url 'http://localhost:8080/login'

    When method Get
    * def token = responseCookies['XSRF-TOKEN']
    * print token.value
    Given header X-XSRF-TOKEN = token.value
    Given url 'http://localhost:8080/login'
    Given form field username = 'admin'
    Given form field password = 'admin'

    When method POST
    * def token = responseCookies['XSRF-TOKEN']
    * print token.value
    Given header X-XSRF-TOKEN = token.value

  Scenario: Testing POSTFirst
    Given url testUrl
    And request {name: 'Milk', description: 'Milk', sku:'CoolMilk', price: 250}
    When method POST
    Then status 200

  Scenario: Testing GET (good after successful POST)
    Given url testUrl
    When method GET
    Then status 200
    And match $ contains { id:#notnull , name:Milk , desc:Milk, sku:CoolMilk, price:250.0}

  Scenario: Testing PUT in first in list
    Given url testUrl
    When method GET
    Then status 200
    And def testId = response[0].id

    Given header X-XSRF-TOKEN = token.value
    Given url testUrl+'/'+testId
    And request { name: 'Milk2', description: 'sweet Milk2', sku:'CoolMilk2', price: 350}
    When method PUT
    Then status 200
    And match $ contains { id:#(testId) ,name: 'Milk2', description: 'sweet Milk2', sku:'CoolMilk2', price: 350}

  Scenario: Testing DELETE first in list
    Given url testUrl
    When method GET
    Then status 200

    Given header X-XSRF-TOKEN = token.value
    Given url testUrl+'/'+response[0].id
    When method DELETE
    Then status 200