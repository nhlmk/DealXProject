Feature: Search

  @Case1
  Scenario Outline: Navigate to the application and perform a search and verify that the first result matches your search criteria.
    Given user is on the home page of the application
    When user enters below search "<keyword>" and clicks enter
    Then user should see the item related to search "<keyword>" in the first result

    Examples:
      | keyword |
      | Dress   |
      | Blouse  |
      | T-shirt |

  @Case2
  Scenario: Store 3 search criteria in one variable separated by commas. Manipulate the string and store each search criteria in an array and use a loop to perform the search and verify.
    Given user is on the home page of the application
    When user enters search keyword and user see the item related to search keyword in the first result

  @Case3
  Scenario: Repeat TC1 again this time using a data driven approach using an external datafile such as an
  excel spreadsheet or text file.
    Given user is on the home page of the application
    When user enters search keyword from excel file, user sees the item related to search keyword in the first result



