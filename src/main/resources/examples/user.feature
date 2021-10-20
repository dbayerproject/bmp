Feature: Test user REST API with karate
 Background: testing login form
  * def testUrl = 'http://localhost:8080/'
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

 Scenario: Test GET
  Given url '/username/id'
  When method GET
  Then status 200
  And match $ contains  {id: #notnull, username: #notnull}
  
  Scenario: Test PUT
   Given url "/updateUsername/id"
   When method GET
   Then status 200
   And def testId = response[0].id
   Given header X-XSRF-TOKEN = token.value
   Given url testUrl + '/' + testId
   And request { name: 'Username1'}
   When method PUT
   Then status 200
   And match $ contains { id:#(testId) , name: 'Username1}

   