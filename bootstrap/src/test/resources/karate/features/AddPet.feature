Feature: dogs end-point that uses jdbc as part of the test

  Background:
    * url urlBase

  Scenario: Create a new pet
    * set petRequest
      | path          | value                                                     |
      | id            | 10                                                        |
      | name          | 'Shade'                                                   |
      | category.id   | '1'                                                       |
      | category.name | 'black panther'                                           |
      | photoUrls     | ["url1","url2"]                                           |
      | tags          | [{"id": 1,"name":"tagName1"},{"id": 2,"name":"tagName2"}] |
      | status        | "available"                                               |

    Given path 'pet'
    And request petRequest
    When method POST
    Then status 200
    And match response == karate.read('classpath:karate/features/shadeResponse.json')
