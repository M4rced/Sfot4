package com.softwareiv.ubico.domain;

import com.softwareiv.ubico.domain.enums.TipoDocumento;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private String id = UUID.randomUUID().toString();

    @Column(name = "nombre")
    @NotNull
    @Size(max = 100)
    private String nombre;

    @Column(name = "primer_apellido")
    @NotNull
    @Size(max = 100)
    private String primerApellido;

    @Column(name = "segundo_apellido")
    @Size(max = 100)
    private String segundoApellido;

    @Column(name = "numero_documento")
    @NotNull
    @Size(max = 20)
    private String numeroDocumento;

    @Column(name = "tipo_documento")
    @NotNull
    @Size(max = 50)
    private TipoDocumento tipoDocumento;

    @Column(name = "correo_electronico")
    @NotNull
    @Size(max = 100)
    @Email
    private String correoElectronico;

    @Column(name = "numero_telefono_movil")
    @NotNull
    @Size(max = 15)
    private String telefonoMovil;

    @Column(name = "password")
    @NotNull
    @Size(min = 8, max = 14)
    private String password;


    public User() {}

    public User(String id, String nombre, String primerApellido, String segundoApellido, String numeroDocumento,
                TipoDocumento tipoDocumento, String correoElectronico, String telefonoMovil, String password) {
        this.id = id;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.numeroDocumento = numeroDocumento;
        this.tipoDocumento = tipoDocumento;
        this.correoElectronico = correoElectronico;
        this.telefonoMovil = telefonoMovil;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public String getPassword() {
        return password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
