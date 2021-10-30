Feature: Testing a userREST API with Karate
  Background:
   * url  'http://localhost:8080/login'

    Scenario: Auth test

      And  form field username = 'admin'
      And  form field password = 'admin'
      When method POST
      Then status 200
      Then  print 'response---', response
    * def accessToken = response.access_token
  Scenario: Testing POST

    Given url 'http://localhost:8080/save'
    And request { username:'adery', password:'123', email:'misha@admin.com',firstName:'Misha',lastName:'Mishalov',telephone:'88'}
    When method POST
    Then status 201
#
#  Scenario: Testing GET (good after successful POST)
#    Given url 'http://localhost:8080/alluser'
#    When method GET
#    Then status 200
#    And match $ contains { id:#notnull, username:'admin', password:#notnull, email:'admin@admin.com',firstName:'Admin',lastName:'Adminov',telephone:'88002005555'}