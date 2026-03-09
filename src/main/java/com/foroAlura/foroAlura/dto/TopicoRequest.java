package com.foroAlura.foroAlura.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TopicoRequest(
        @NotBlank @Size(max =200) String titulo,
        @NotBlank @Size(max =1000) String mensaje

) {

}
