package com.tacsio.ativo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@JsonFormat(shape = Shape.STRING)
public enum Tipo {
	ORDINARIA, PREFERENCIAL, COTA
}