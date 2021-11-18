# Dynamic structure in configurations passed in environment variables

## Problematic

Usage of a JSON property injected as an environment variable, mapping of this property to a configuration class automatically
by Spring.

### Standard converters not working
https://www.iamjaya.com/2020/04/using-custom-converters-with-configurationProperties-in-spring-boot.html

### Spring properties resolvers lifecycle
https://www.programmersought.com/article/86826398871/


## Solution

The configuration class `Config` contains a `@PostConstruct` method called to make the `String` property to `Object` conversion:

```java
    @PostConstruct
    private void setConfiguration() {
        try {
            this.clientConfigs = ClientConfigurationItem.convert(this.clientConfigsAsString);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
```

## How to run this example

### Unit tests

```shell
mvn clean test
```

### Run the application
The application is using a properties .env file. You can copy the .template file and rename it to `.env.properties`

