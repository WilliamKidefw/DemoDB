package com.william.dev.request;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class ClientRequest {

	private String nombre;
	private String apellido;
	private int edad;
	@JsonFormat(pattern = "dd/MM/yyyy",shape = Shape.STRING)
	private LocalDate fechaNacimiento;
}
