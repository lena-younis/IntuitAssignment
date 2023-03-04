# IntuitAssignment
Payment System Craft Demonstration

US - As a customer, I need to pay other Intuit customers for various services or products I buy from
them.

in this repository we have 2 services / maven projects 

paymentSystem : 
  desined a service containing 5 endpoints ,
    - CreatePayment - for creating a payment object and publishing it on kafka topic 
    - GetPaymentMethods - for retrieving all available payment methods
    - GetPayees - for retrieving all available payees
    - GetPayee - for retrieving payee details with specified id in path
    - GetPaymentMethod - for retrieving paymentMethodDetails with specified id in path
    
riskEngine : 
  an engine listening on kafka topic for payment notification, once received analyses the payment and calclated 
  the risk and updates status of payment as accepted/rejected.

//** running the app **//
for running this app please download repo as zip and extract. open paymentSystem and riskEngive in seperately windows (used 2 intellij windows),
download kafka if not presrent at https://kafka.apache.org/quickstart , and follow first commands in link to run the service locally , once kafka is
running; run the 2 applications by running the springBootApplication class (SpringbootRiskEngineApplication / SpringbootPaymentSystemApplication)
once service is up hit the service with http requests from postman using the provided collection




    
    
    
  
