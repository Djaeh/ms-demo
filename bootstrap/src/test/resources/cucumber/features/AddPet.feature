Feature: Adding a new pet

  Scenario: Adding a pet with no tags
    Given Arthur has a new pet
      | id | name  | category.id | category.name | photoUrls | tags | status    |
      | 10 | shade | 1           | black         | 1,2       |      | available |
    When Arthur create this pet to the store
    Then the pet is added and is same as
      | id | name  | category.id | category.name | photoUrls | tags | status    |
      | 10 | shade | 1           | black         | 1,2       |      | available |