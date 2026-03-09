package com.foroAlura.foroAlura.Controller;


import com.foroAlura.foroAlura.dto.TopicoRequest;
import com.foroAlura.foroAlura.dto.TopicoResponse;
import com.foroAlura.foroAlura.dto.TopicoUpdateRequest;
import com.foroAlura.foroAlura.service.TopicoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/topicos")
public class TopicoController {
    private final TopicoService topicoService;

        @GetMapping
        public ResponseEntity<List<TopicoResponse>> listar(){
            return ResponseEntity.ok(topicoService.listar());
        }
        @PostMapping
        public ResponseEntity<TopicoResponse> crear(@Valid @RequestBody TopicoRequest request){

            return ResponseEntity.status(HttpStatus.CREATED).body(topicoService.crear(request));
        }

        @PutMapping
        public ResponseEntity<TopicoResponse> actualizar(@Valid @RequestBody TopicoUpdateRequest request){
            return ResponseEntity.ok(topicoService.actualizar(request));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> eliminar(@PathVariable Long id){
            topicoService.eliminar(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }


}
