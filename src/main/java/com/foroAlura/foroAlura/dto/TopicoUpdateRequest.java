package com.foroAlura.foroAlura.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TopicoUpdateRequest(
        @NotNull Long id,
        @Size(max=200) String titulo,
        @Size(max=200) String mensaje
) {
}
