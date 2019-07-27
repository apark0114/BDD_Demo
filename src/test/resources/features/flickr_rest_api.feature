@flickr_api
Feature: Flickr Rest API
  @get_latest_photos
   Scenario Outline: request latest photos
     Given I add following headers:
       | Accept   | application/json |
     And I add following parameters:
       | format   | json                    |
       | method   | flickr.photos.getRecent |
       | api_key  | <api_key>               |
     And I make a "GET" request
     Then I receive a response code 200

    @preprod
    Examples:
      |  api_key        |
      |  preprod_key    |

    @production
    Examples:
      |  api_key        |
      |  production key |


  @request_with_bad_key
  Scenario Outline:  request api with apikey error
    Given I add following headers:
      | Accept   | application/json |
    And I add following parameters:
      | format   | json             |
      | api_key  | <api_key>        |
    And I make a "GET" request
    Then I receive a response code 403
    Then I verify response contains following json response:
      | message  | <error_message>  |
      | stat     | fail             |

    @production @invalid
    Examples:
      | api_key         | error_message                             |
      | invalid_key     | Invalid API Key (Key has invalid format)  |

    @production @suspend
    Examples:
      | api_key         | error_message                             |
      | suspended_key   | Invalid API Key (Key has been suspended)  |


  @pagination
  Scenario Outline: Fetch latest photos with pagination defined
    Given I add following headers:
      | Accept   | application/json |
    And I add following parameters:
      | format   | json                    |
      | per_page | <per_page>              |
      | method   | flickr.photos.getRecent |
      | api_key  | <api_key>               |
    And I make a "GET" request
    Then I receive a response code 200
    Then I verify response contains following json response:
      |  photos.perpage | <per_page>       |

    @production
    Examples:
      |  api_key        |  per_page     |
      |  production key |   0           |

    @production
    Examples:
      |  api_key        |  per_page     |
      |  production key |   5           |

    @production
    Examples:
      |  api_key        |  per_page     |
      |  production key |   1000        |