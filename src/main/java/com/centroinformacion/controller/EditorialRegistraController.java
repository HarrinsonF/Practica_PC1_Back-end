package com.centroinformacion.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.centroinformacion.entity.Editorial;
import com.centroinformacion.entity.Usuario;
import com.centroinformacion.service.EditorialService;
import com.centroinformacion.util.AppSettings;

@RestController
@RequestMapping("/url/editorial")
@CrossOrigin(AppSettings.URL_CROSS_ORIGIN)
public class EditorialRegistraController {
	
	@Autowired
	private EditorialService editorialservice;
	
	@GetMapping
	public ResponseEntity<List<Editorial>> lista(){
		List<Editorial> lstSalida = editorialservice.listEditorial();
		return ResponseEntity.ok(lstSalida);
	}
	
	@PostMapping
	public ResponseEntity<?> registra(@RequestBody Editorial objedi){
		HashMap<String, Object> salida = new HashMap<>();
		objedi.setFechaRegistro(new Date());
		objedi.setFechaActualizacion(new Date());
		objedi.setEstado(AppSettings.ACTIVO);
		Usuario objUsu = new Usuario();
		objUsu.setIdUsuario(1);
		objedi.setUsuarioRegistro(objUsu);
		objedi.setUsuarioActualiza(objUsu);
		
		Editorial objSalida = editorialservice.insertarEditorial(objedi);
		if (objSalida == null) {
			salida.put("mensaje", "Error en el registro");
		}else {
			salida.put("mensaje", "Registro de Editorial con el ID >>> " + objedi.getIdEditorial()+ "\n" + " >>> Razon: >>> " + objedi.getRazonSocial());
		}
		return ResponseEntity.ok(salida);
	}

}
