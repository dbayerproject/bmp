Feature: Testing a category REST API with Karate
  Background: Testing logging in FormLogin with csrf
    Given url 'http://localhost:8080/login'
    * def testUrl1 = 'http://localhost:8080/save'
    * def testUrl2 = 'http://localhost:8080/user/1'
    * def testUrl3 = 'http://localhost:8080/delete/1'
    Given url 'http://localhost:8080/login'
    When method GET
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

  Scenario: Testing Save user

    Given url testUrl1
    And request { username:'adery', password:'123', email:'misha@admin.com',firstName:'Misha',lastName:'Mishalov',telephone:'88'}
    When method POST
    Then status 201

  Scenario: Testing Get User
    Given header X-XSRF-TOKEN = token.value

    Given url testUrl2
    When method GET
    Then status 200
    And match $ contains { id:#notnull, username:'adery', password:#notnull, email:'misha@admin.com',firstName:'Misha',lastName:'Mishalov',telephone:'88'}

  Scenario: Testing DELETE user

    Given url testUrl3
    Given header X-XSRF-TOKEN = token.value
    When method DELETE
    Then status 200