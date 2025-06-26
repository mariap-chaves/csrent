package com.csrent.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.apache.logging.log4j.message.Message;

public class UserDTO {
    @NotBlank(message = "El nombre no puede estar en blanco")
    private String name;
    @Email (message="El correo no es valido")//Da la estructura de un correo
    @NotBlank(message = "El correo no puede estar en blanco")
    private String email;
    //                 Abre el formato.                                       Cierra el formato
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\\\d)(?=.*[!@#$%^&*()]).{8,}$", message = "La contraseña debe contener: Mayusculas, minusculas, signos especiales y numeros") //Formato de la contraseña
    @NotBlank(message = "La contraseña no puede estar en blanco")
    private String password;
    @NotNull(message = "El rol no puede estar en blanco")
    private String rol;
}
