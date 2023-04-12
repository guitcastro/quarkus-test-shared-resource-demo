# demo

This repository reproduces [ Mix shared QuarkusTestResource with restrictToAnnotatedClass restart all others QuarkusTestResource #32551 ](https://github.com/quarkusio/quarkus/issues/32551#issuecomment-1504676047)


We have a shared resource `SharedResource` which is used by `ExampleResourceTestA` and `ExampleResourceTestB`. 
We also have an unique resource `UniqueResource` which is also used in the tests `ExampleResourceTestA` and
`ExampleResourceTestB` but using `restrictToAnnotatedClass = true`

`SharedResource` should started only once, but is being stopped and restart between tests executions.

To reproduce simple run:

`./gradlew test`

You can check the output for the logs:

ExampleResourceTestA STANDARD_ERROR  
> 
>    INFO: SharedResource started    
>    INFO: UniqueResource started
> 
> ExampleResourceTestA > testHelloEndpoint() PASSED

ExampleResourceTestB STANDARD_ERROR  
>    INFO: SharedResource stopped  <-- Should not have stopped    
>    INFO: UniqueResource stopped  
> 
>    INFO: SharedResource started   
>    INFO: UniqueResource started
> 
>    INFO: SharedResource stopped  
>    INFO: UniqueResource stopped