Create jar application, which will be started through java -jar <application>.jar.

The application should be built by 3 level architecture (dao, service, presentation - console).

The application should read information from file. The separate thread (file generator) should write information to file. The application (client) in separate thread will read info from file.The client should have console menu with variant options.

Please, create model bank,currency,account, person. We need to open account, to assign person and have possibilities to exchange currencies. 

It would be important to have very accurate result of exchange. Filtering, searching, managing of accounts, currencies, clients are mandatory functionality.

As well let's change Bank office functionality to manage with inner functionality: managing accounts, complex data types (currency and amount), validation of input data,

sorting queue and searching internal mechanism. Divide your functionality to services and utils. 

Add your custom exception model. Model should give possibilities to let user know what was the reason of error.

Please don't handle runtime exceptions through exception handling.Please cover functionality by unit tests - dao and services. 