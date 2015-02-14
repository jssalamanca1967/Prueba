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

package co.edu.uniandes.csw.ClinicaKennedy.doctor.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.inject.Inject;

import co.edu.uniandes.csw.ClinicaKennedy.doctor.logic.api.IDoctorLogicService;
import co.edu.uniandes.csw.ClinicaKennedy.doctor.logic.dto.DoctorDTO;
import co.edu.uniandes.csw.ClinicaKennedy.doctor.logic.dto.DoctorPageDTO;
import javax.enterprise.inject.Default;


public abstract class _DoctorService {

	@Default
	protected IDoctorLogicService doctorLogicService;
	
	@POST
	public DoctorDTO createDoctor(DoctorDTO doctor){
		return doctorLogicService.createDoctor(doctor);
	}
	
	@DELETE
	@Path("{id}")
	public void deleteDoctor(@PathParam("id") Long id){
		doctorLogicService.deleteDoctor(id);
	}
	
	@GET
	public DoctorPageDTO getDoctors(@QueryParam("page") Integer page, @QueryParam("maxRecords") Integer maxRecords){
		return doctorLogicService.getDoctors(page, maxRecords);
	}
	
	@GET
	@Path("{id}")
	public DoctorDTO getDoctor(@PathParam("id") Long id){
		return doctorLogicService.getDoctor(id);
	}
	
	@PUT
	public void updateDoctor(@PathParam("id") Long id, DoctorDTO doctor){
		doctorLogicService.updateDoctor(doctor);
	}
	
}