package com.programacionNCapas.SReynaProgramacionNCapas.RestController;

import com.programacionNCapas.SReynaProgramacionNCapas.DAOJPA.UsuarioDAOJPAImplementation;
import com.programacionNCapas.SReynaProgramacionNCapas.JPA.Result;
import com.programacionNCapas.SReynaProgramacionNCapas.JPA.UsuarioJPA;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Usuario Controller", description = "Operaciones CRUD para la gestión de usuarios")
@RestController
@RequestMapping("api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioDAOJPAImplementation usuarioDAOJPAImplementation;

    /**
     * Obtiene todos los usuarios de la base de datos
     * @return 
     */
    @Operation(summary = "Obtener todos los usuarios", description = "Devuelve la lista completa de usuarios")
    @ApiResponse(responseCode = "200", description = "Lista obtenida correctamente")
    @GetMapping
    public ResponseEntity GetAll() {
        Result result = usuarioDAOJPAImplementation.GetAll();
        return ResponseEntity.status(result.status).body(result);
    }

    /**
     * Obtiene un usuario por su ID
     * @param IdUsuario
     * @return 
     */
    @Operation(summary = "Obtener un usuario por ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Usuario encontrado"),
        @ApiResponse(responseCode = "400", description = "Usuario no encontrado")
    })
    @GetMapping("/{IdUsuario}")
    public ResponseEntity GetOne(
            @Parameter(description = "ID del usuario a buscar") 
            @PathVariable int IdUsuario) {
        Result result = usuarioDAOJPAImplementation.GetOne(IdUsuario);
        return ResponseEntity.status(result.status).body(result);
    }

    /**
     * Agrega un nuevo usuario
     * @param usuario
     * @return 
     */
    @Operation(summary = "Agregar un nuevo usuario")
    @ApiResponse(responseCode = "200", description = "Usuario creado correctamente")
    @PostMapping()
    public ResponseEntity Add(
            @Parameter(description = "Usuario con los datos necesarios") 
            @RequestBody UsuarioJPA usuario) {
        Result result = usuarioDAOJPAImplementation.Add(usuario);
        return ResponseEntity.status(result.status).body(result);
    }

    /**
     * Actualiza un usuario existente
     * @param IdUsuario
     * @param usuario
     * @return 
     */
    @Operation(summary = "Actualizar usuario", description = "Modifica los datos de un usuario existente")
    @PutMapping("/{IdUsuario}")
    public ResponseEntity Update(
            @Parameter(description = "ID del usuario a actualizar") 
            @PathVariable int IdUsuario,
            @RequestBody UsuarioJPA usuario) {
        usuario.setIdUser(IdUsuario);
        Result result = usuarioDAOJPAImplementation.Update(usuario);
        return ResponseEntity.status(result.status).body(result);
    }

    /**
     * Elimina un usuario físicamente
     * @param IdUsuario
     * @return 
     */
    @Operation(summary = "Eliminar usuario físicamente", description = "Elimina un registro de usuario en la base de datos")
    @DeleteMapping("/{IdUsuario}")
    public ResponseEntity Delete(
            @Parameter(description = "ID del usuario a eliminar") 
            @PathVariable int IdUsuario) {
        Result result = usuarioDAOJPAImplementation.Delete(IdUsuario);
        return ResponseEntity.status(result.status).body(result);
    }

    /**
     * Desactiva un usuario (eliminación lógica)
     * @param IdUsuario
     * @return 
     */
    @Operation(summary = "Eliminar usuario lógicamente", description = "Cambia el estatus del usuario en lugar de borrarlo")
    @PatchMapping("/estatus/{IdUsuario}")
    public ResponseEntity LogicalDelete(
            @Parameter(description = "ID del usuario a desactivar") 
            @PathVariable int IdUsuario) {
        Result result = usuarioDAOJPAImplementation.LogicalDelete(IdUsuario);
        return ResponseEntity.status(result.status).body(result);
    }
}
