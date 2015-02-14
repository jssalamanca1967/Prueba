/* ========================================================================
 * Copyright 2014 ClinicaKennedy
 *
 * Licensed under the MIT, The MIT License (MIT)
 * Copyright (c) 2014 ClinicaKennedy

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 * ========================================================================


Source generated by CrudMaker version 1.0.0.201411201032

*/

package co.edu.uniandes.csw.ClinicaKennedy.reporte.logic.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
public abstract class _ReporteDTO {

	

	private String actividadFisica;
	

	private String alimentacion;
	

	private String fechaPublicacion;
	

	private String gravedad;
	

	private Long id;
	

	private String name;
	

	private String localizacionDolor;
	

	private String patronDeSueno;



	public String getActividadFisica() {
		return actividadFisica;
	}
 
	public void setActividadFisica(String actividadfisica) {
		this.actividadFisica = actividadfisica;
	}


	public String getAlimentacion() {
		return alimentacion;
	}
 
	public void setAlimentacion(String alimentacion) {
		this.alimentacion = alimentacion;
	}


	public String getFechaPublicacion() {
		return fechaPublicacion;
	}
 
	public void setFechaPublicacion(String fechapublicacion) {
		this.fechaPublicacion = fechapublicacion;
	}


	public String getGravedad() {
		return gravedad;
	}
 
	public void setGravedad(String gravedad) {
		this.gravedad = gravedad;
	}


	public Long getId() {
		return id;
	}
 
	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}


	public String getLocalizacionDolor() {
		return localizacionDolor;
	}
 
	public void setLocalizacionDolor(String localizaciondolor) {
		this.localizacionDolor = localizaciondolor;
	}


	public String getPatronDeSueno() {
		return patronDeSueno;
	}
 
	public void setPatronDeSueno(String patrondesueno) {
		this.patronDeSueno = patrondesueno;
	}
	
}