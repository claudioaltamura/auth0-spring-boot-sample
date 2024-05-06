package de.claudioaltamura.auth0.spring.boot.sample.config;

import lombok.Value;

@Value
public class ErrorMessage {

    String message;

    public static ErrorMessage from(final String message) {
        return new ErrorMessage(message);
    }
}
