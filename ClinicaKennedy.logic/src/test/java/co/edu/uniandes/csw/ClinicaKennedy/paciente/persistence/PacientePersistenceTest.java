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

package co.edu.uniandes.csw.ClinicaKennedy.paciente.persistence;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.*;


import co.edu.uniandes.csw.ClinicaKennedy.paciente.logic.dto.PacientePageDTO;
import co.edu.uniandes.csw.ClinicaKennedy.paciente.logic.dto.PacienteDTO;
import co.edu.uniandes.csw.ClinicaKennedy.paciente.persistence.api.IPacientePersistence;
import co.edu.uniandes.csw.ClinicaKennedy.paciente.persistence.entity.PacienteEntity;
import co.edu.uniandes.csw.ClinicaKennedy.paciente.persistence.converter.PacienteConverter;
import static co.edu.uniandes.csw.ClinicaKennedy.util._TestUtil.*;

@RunWith(Arquillian.class)
public class PacientePersistenceTest {

	public static final String DEPLOY = "Prueba";

	@Deployment
	public static WebArchive createDeployment() {
		return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
				.addPackage(PacientePersistence.class.getPackage())
				.addPackage(PacienteEntity.class.getPackage())
				.addPackage(IPacientePersistence.class.getPackage())
                .addPackage(PacienteDTO.class.getPackage())
                .addPackage(PacienteConverter.class.getPackage())
				.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
	}

	@Inject
	private IPacientePersistence pacientePersistence;

	@PersistenceContext
	private EntityManager em;

	@Inject
	UserTransaction utx;

	@Before
	public void configTest() {
		System.out.println("em: " + em);
		try {
			utx.begin();
			clearData();
			insertData();
			utx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				utx.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	private void clearData() {
		em.createQuery("delete from PacienteEntity").executeUpdate();
	}

	private List<PacienteEntity> data=new ArrayList<PacienteEntity>();

	private void insertData() {
		for(int i=0;i<3;i++){
			PacienteEntity entity=new PacienteEntity();
			entity.setAlturaMetros(generateRandom(Double.class));
			entity.setEdad(generateRandom(Integer.class));
			entity.setName(generateRandom(String.class));
			entity.setPesoKg(generateRandom(Double.class));
			entity.setDocumentoIdentificacion(generateRandom(Long.class));
			em.persist(entity);
			data.add(entity);
		}
	}
	
	@Test
	public void createPacienteTest(){
		PacienteDTO dto=new PacienteDTO();
		dto.setAlturaMetros(generateRandom(Double.class));
		dto.setEdad(generateRandom(Integer.class));
		dto.setName(generateRandom(String.class));
		dto.setPesoKg(generateRandom(Double.class));
		dto.setDocumentoIdentificacion(generateRandom(Long.class));
		
		PacienteDTO result=pacientePersistence.createPaciente(dto);
		
		Assert.assertNotNull(result);
		
		PacienteEntity entity=em.find(PacienteEntity.class, result.getId());
		
		Assert.assertEquals(dto.getAlturaMetros(), entity.getAlturaMetros());
		Assert.assertEquals(dto.getEdad(), entity.getEdad());
		Assert.assertEquals(dto.getName(), entity.getName());
		Assert.assertEquals(dto.getPesoKg(), entity.getPesoKg());
		Assert.assertEquals(dto.getDocumentoIdentificacion(), entity.getDocumentoIdentificacion());
	}
	
	@Test
	public void getPacientesTest(){
		List<PacienteDTO> list=pacientePersistence.getPacientes();
		Assert.assertEquals(list.size(), data.size());
        for(PacienteDTO dto:list){
        	boolean found=false;
            for(PacienteEntity entity:data){
            	if(dto.getId().equals(entity.getId())){
                	found=true;
                }
            }
            Assert.assertTrue(found);
        }
	}
	
	@Test
	public void getPacienteTest(){
		PacienteEntity entity=data.get(0);
		PacienteDTO dto=pacientePersistence.getPaciente(entity.getId());
        Assert.assertNotNull(dto);
		Assert.assertEquals(entity.getAlturaMetros(), dto.getAlturaMetros());
		Assert.assertEquals(entity.getEdad(), dto.getEdad());
		Assert.assertEquals(entity.getName(), dto.getName());
		Assert.assertEquals(entity.getPesoKg(), dto.getPesoKg());
		Assert.assertEquals(entity.getDocumentoIdentificacion(), dto.getDocumentoIdentificacion());
        
	}
	
	@Test
	public void deletePacienteTest(){
		PacienteEntity entity=data.get(0);
		pacientePersistence.deletePaciente(entity.getId());
        PacienteEntity deleted=em.find(PacienteEntity.class, entity.getId());
        Assert.assertNull(deleted);
	}
	
	@Test
	public void updatePacienteTest(){
		PacienteEntity entity=data.get(0);
		
		PacienteDTO dto=new PacienteDTO();
		dto.setId(entity.getId());
		dto.setAlturaMetros(generateRandom(Double.class));
		dto.setEdad(generateRandom(Integer.class));
		dto.setName(generateRandom(String.class));
		dto.setPesoKg(generateRandom(Double.class));
		dto.setDocumentoIdentificacion(generateRandom(Long.class));
		
		
		pacientePersistence.updatePaciente(dto);
		
		
		PacienteEntity resp=em.find(PacienteEntity.class, entity.getId());
		
		Assert.assertEquals(dto.getAlturaMetros(), resp.getAlturaMetros());	
		Assert.assertEquals(dto.getEdad(), resp.getEdad());	
		Assert.assertEquals(dto.getName(), resp.getName());	
		Assert.assertEquals(dto.getPesoKg(), resp.getPesoKg());	
		Assert.assertEquals(dto.getDocumentoIdentificacion(), resp.getDocumentoIdentificacion());	
	}
	
	@Test
	public void getPacientePaginationTest(){
		//Page 1
		PacientePageDTO dto1=pacientePersistence.getPacientes(1,2);
        Assert.assertNotNull(dto1);
        Assert.assertEquals(dto1.getRecords().size(),2);
        Assert.assertEquals(dto1.getTotalRecords().longValue(),3L);
        //Page 2
        PacientePageDTO dto2=pacientePersistence.getPacientes(2,2);
        Assert.assertNotNull(dto2);
        Assert.assertEquals(dto2.getRecords().size(),1);
        Assert.assertEquals(dto2.getTotalRecords().longValue(),3L);
        
        for(PacienteDTO dto:dto1.getRecords()){
        	boolean found=false;	
            for(PacienteEntity entity:data){
            	if(dto.getId().equals(entity.getId())){
                	found=true;
                }
            }
            Assert.assertTrue(found);
        }
        
        for(PacienteDTO dto:dto2.getRecords()){
        	boolean found=false;
            for(PacienteEntity entity:data){
            	if(dto.getId().equals(entity.getId())){
                	found=true;
                }
            }
            Assert.assertTrue(found);
        }
	}
	
}