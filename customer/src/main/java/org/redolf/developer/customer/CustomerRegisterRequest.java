package org.redolf.developer.customer;

public record CustomerRegisterRequest(
        String firstName,
        String lastName,
        String email) {
}
