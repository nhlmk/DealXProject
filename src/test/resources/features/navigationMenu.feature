Feature: Navigation Menu

  @Case6
  Scenario Outline: User can navigate to a certain page through navigation menu
    Given user is on the home page of the application
    When user hovers over different "<menus>" from main navigation menu, user should be able to see "<subcategories>" under the related menus

    Examples:
      | menus   | subcategories  | subcategories   | subcategories  |
      | Women   | Tops           | Dresses         |                |
      | Dresses | Casual Dresses | Evening Dresses | Summer Dresses |
