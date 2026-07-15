package com.library.libraryapp.model.user;

import jakarta.validation.constraints.NotBlank;

public record Address(
        @NotBlank(message = "Street cannot be empty")
        String street,

        @NotBlank(message = "City cannot be empty")
        String city,

        @NotBlank(message = "Country cannot be empty")
        String country
) {}