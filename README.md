# BDD_Demo
### Flickr Restful API Bdd Tests

#### Objective:
    -   To test flickr Restful API service using Cucumber framework.

#### Requirements:
    -   Maven
    -   JDK
    -   Flickr apikey(https://www.flickr.com/services/developer/api/)
    
#### How to run:
    - Navigate to src/test/resource/flickr_rest_api.feature. 
    - Update "api_key" with your own.
    - To run tests, use the following command:
     mvn clean test -Dcucumber.options="--tags @flickr_api" -Dtest=BddRunner
