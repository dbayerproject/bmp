Feature: Testing Api product controller
  Background: Testing logging in FormLogin with csrf
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

  Scenario: Testing Save user

    Given url 'http://localhost:8080/save'
    And request { username:'adery', password:'123', email:'misha@admin.com',firstName:'Misha',lastName:'Mishalov',telephone:'88'}
    When method POST
    Then status 201

  Scenario: Testing Get User

    Given url 'http://localhost:8080/user/1'
    When method GET
    Then status 200
    And match $ contains { id:#notnull, username:'adery', password:#notnull, email:'misha@admin.com',firstName:'Misha',lastName:'Mishalov',telephone:'88'}

  Scenario: Testing DELETE user
    And def testId = response[0].id
    Given url testUrl = 'http://localhost:8080/delete/1'
    Given header X-XSRF-TOKEN = token.value
    When method DELETE
    Then status 200