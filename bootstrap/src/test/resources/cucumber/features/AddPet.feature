Feature: Adding a pet

  Scenario: Adding a pet with no tags
    Given the following pet
      | id | name  | category.id | category.name | photoUrls | tags | status    |
      | 10 | shade | 1           | black         | 1,2       |      | available |
    When adding this pet
    Then the pet is added and is same as
      | id | name  | category.id | category.name | photoUrls | tags | status    |
      | 10 | shade | 1           | black         | 1,2       |      | available |

  Scenario: Adding a pet with no tags and status PENDING
    Given the following pet
      | id | name  | category.id | category.name | photoUrls | tags | status    |
      | 10 | shade | 1           | black         | 1,2       |      | pending |
    When adding this pet
    Then the pet is added and is same as
      | id | name  | category.id | category.name | photoUrls | tags | status    |
      | 10 | shade | 1           | black         | 1,2       |      | available |