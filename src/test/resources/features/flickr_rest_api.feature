@flickr_api
Feature: Flickr Rest API
  @get_latest_photos
   Scenario Outline: request latest photos
     Given I add following headers:
       | Accept   | application/json        |
     And I add following parameters:
       | format   | json                    |
       | method   | flickr.photos.getRecent |
       | api_key  | <api_key>               |
     And I make a "GET" request
     Then I receive a response code 200

    @production
    Examples:
      |  api_key                            |
      |  <.. INSERT FLICKR API KEY HERE ..> |


  @request_with_bad_key
  Scenario Outline:  request api with apikey error
    Given I add following headers:
      | Accept          | application/json  |

    And I add following parameters:
      | format          | json              |
      | api_key         | <api_key>         |
      | method          | <method>          |
      | nojsoncallback  | 1                 |
    And I make a "GET" request
    Then I verify response contains following text response:
      | <error_message> |


    @production @invalid
    Examples:
      | api_key                             | method                  | error_message                           |
      | invalid_key                         | flickr.photos.getRecent | Invalid API Key (Key has invalid format)|

    @production @suspend
    Examples:
      | api_key                             | method                  | error_message                           |
      |  <.. INSERT FLICKR API KEY HERE ..> | unknown.method          |  "Method \"unknown.method\" not found"  |


  @pagination
  Scenario Outline: Fetch latest photos with pagination defined
    Given I add following headers:
      | Accept          | application/json        |
    And I add following parameters:
      | format          | json                    |
      | nojsoncallback  | 1                       |
      | per_page        | <per_page>              |
      | method          | flickr.photos.getRecent |
      | api_key         | <api_key>               |
    And I make a "GET" request
    Then I receive a response code 200
    Then I verify response contains following json response:
      |  photos.perpage | <per_page>              |

    @production
    Examples:
      |  api_key                            |  per_page    |
      |  <.. INSERT FLICKR API KEY HERE ..> |   1          |

    @production
    Examples:
      |  api_key                            |  per_page    |
      |  <.. INSERT FLICKR API KEY HERE ..> |   5          |

    @production
    Examples:
      |  api_key                            |  per_page    |
      |  <.. INSERT FLICKR API KEY HERE ..> |   100        |