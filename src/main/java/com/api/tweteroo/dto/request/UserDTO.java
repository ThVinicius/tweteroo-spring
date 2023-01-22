package com.api.tweteroo.dto.request;

import jakarta.validation.constraints.NotBlank;

public record UserDTO(
        @NotBlank String username,

        @NotBlank String avatar
) {
}
