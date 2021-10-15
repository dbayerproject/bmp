Feature: Testing a category REST API with Karate
  Background:Testing Logging in FormLogin with csrf
    * def testUrl = 'http://localhost:8080/categories'
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

  Scenario: Testing POST
    Given url testUrl
    And request { name: 'John Smith' , description: 'John Smith1'}
    When method POST
    Then status 201

  Scenario: Testing GET (good after successful POST)
    Given url testUrl
    When method GET
    Then status 200
    And match $ contains { id:#notnull , name: #notnull , description: #notnull}

  Scenario: Testing PUT in first in list
    Given url testUrl
    When method GET
    Then status 200
    And def testId = response[0].id

    Given header X-XSRF-TOKEN = token.value
    Given url testUrl+'/'+testId
    And request { name: 'John Smith2' , description: 'John Smith2'}
    When method PUT
    Then status 200
    And match $ contains { id:#(testId) , name: 'John Smith2' , description: 'John Smith2'}

  Scenario: Testing DELETE first in list
    Given url testUrl
    When method GET
    Then status 200

    Given header X-XSRF-TOKEN = token.value
    Given url testUrl+'/'+response[0].id
    When method DELETE
    Then status 200

#  Scenario: Testing Logging in FormLogin with csrf
#    Given url 'http://localhost:8080/login'
#    When method GET
#    * def token = responseCookies['XSRF-TOKEN']
#    * print token.value
#    Given header X-XSRF-TOKEN = token.value
#    Given url 'http://localhost:8080/login'
#    Given form field username = 'admin'
#    Given form field password = 'admin'
#    When method POST
#
#    * def token = responseCookies['XSRF-TOKEN']
#    * print token.value
#    Given header X-XSRF-TOKEN = token.value
#    Given url 'http://localhost:8080/categories'
#    And request { name: 'John Smith3' , description: 'John Smith3'}
#    When method POST
#    And print response


#  Scenario: Testing Logging in FormLogin without csrf
#    Given form field username = 'admin'
#    Given form field password = 'admin'
#    Given url 'http://localhost:8080/login'
#    When method POST
##    Then print responseHeaders
##    And def token =  responseHeaders['Set-Cookie']
#
#    Given url testUrl
#    And request { name: 'John Smith' , description: 'John Smith1'}
#    When method POST
#    Then status 201

#  Scenario: Testing Logging in Basic Auth
#    Given header Authorization = 'Basic YWRtaW46YWRtaW4='
#    Given url testUrl
#    When method GET
#    Then print responseHeaders
#    And def token =  responseHeaders['Set-Cookie']
#
#    Given url testUrl
#    And request { name: 'John Smith' , description: 'John Smith1'}
#    When method POST
#    Then status 201


      

