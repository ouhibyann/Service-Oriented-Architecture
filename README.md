#OUHIB_TP_SOA

This project is a webapp microservices project with the following components :
- "ms-membership", allowing to register, update, select and delete a client thanks to an API with JSON format request.
- "ms-basket", allowing to  create, update, delete and select a cart link to an id-client with JSON format request.
- "ms-product", a service providing a mock and get a product or a list of product - only the select method is implemented,
 because it is used by ms-basket to get a list of products in which one can select to add to its cart.
The 'ms-basket' and 'ms-membership' are both API and require a JWT token authentication to execute requests.

#Docker generate and run

TODO: Describe the installation process

#Curl API with Postman

Packages will be provided - external - with the project to test the all the services via Postman.

#Running Tests

There are no tests to be run yet.

#Git

  * Create your feature branch: `git checkout -b my-new-feature` 
  * Commit your changes: `git commit -am 'Add some feature'` 
  * Push to the branch: `git push origin my-new-feature`
