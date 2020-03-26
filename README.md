# OUHIB_SOA

This project is a webapp microservices project with the following components :
- "ms-membership", allowing to register, update, select and delete a client thanks to an API with JSON format request.
- "ms-basket", allowing to  create, update, delete and select a cart link to an id-client with JSON format request.
- "ms-product", a service providing a mock and get a product or a list of product - only the select method is implemented,
 because it is used by ms-basket to get a list of products in which one can select to add to its cart.
The 'ms-basket' and 'ms-membership' are both API and require a JWT token authentication to execute requests.

For each micro-services, you will find a Dockerfile to run them in separated container; also each services is provided with a Class diagram.
A component diagram is also available for a better understanding of the whole application.

# Docker build and run

    * ms-basket : 
        docker build -t ms-basket .
        docker run -d -p 9090:8090 ms-basket 
    * ms-membership :
        docker build -t ms-membership
        docker run -d -p 9070:8070 ms-membership
    * ms-product :
        docker build -t ms-product
        docker run -d -p 9060:8060 ms-product

# Curl API with Postman

Packages will be provided - external - with the project to test the all the services via Postman.
Warning !!! The provided requests are written with my own docker deamon IP address (192.168.99.100), you should replace it with your own IP address.

# Running Tests

There are no tests to be run yet.

# Git

  * Create your feature branch: `git checkout -b my-new-feature` 
  * Commit your changes: `git commit -am 'Add some feature'` 
  * Push to the branch: `git push origin my-new-feature`
