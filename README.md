Description
Someone needs help, we have intercepted a list of encrypted coordinates from the death star, in
order to reestablish the peace in the interplanetary system Stratio needs you to find out the targets
positions.

This project is built with [zio-http](https://github.com/dream11/zio-http) for http server and [scalatest](https://www.scalatest.org/) for testing.
# Tests
## scalatests
You can check the simple test flow [here](src/test/scala/com/stratio/sw/StratioWarDecryptionSpec.scala).
## Integration test
You can test the project with this postman using [this postman collection](/Stratio%20War.postman_collection.json)

# Disclaimer
may you can see some Options instead of Either, I know it could be better, 
but for the sake of proof of concept i choose to use Try(something).toOption
