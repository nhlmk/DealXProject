Feature: Login

  @Case4
  Scenario Outline: Sign in to the website using a username and password
    Given user is on the home page of the application
    And user clicks sign-in link from the top right of the application
    And user enters "<username>", "<password>" in related field
    And user clicks sign-in button
    Then user logs in successfully

    Examples:
      | username                         | password |
      | everythingIsPerfect@evrythng.com | 12345    |

  Scenario Outline: User can not login with invalid data
    Given user is on the home page of the application
    And user clicks sign-in link from the top right of the application
    And user enters "<username>", "<password>" in related field
    And user clicks sign-in button
    Then user sees the error

    Examples:
      | username | password |
      |          |          |
      | a        |          |
      |          | a        |
      | a        | a        |



