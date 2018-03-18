package uo.asw.iniManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import uo.asw.dbManagement.model.Agente;
import uo.asw.inciManager.repository.AgenteRespository;

@Service
public class AgenteService {

	@Autowired 
	private AgenteRespository agenteRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	/**
	 * Me devuelve el agente buscado con el usuario, contrasenia y kindCode
	 * @param user 
	 * @param password 
	 * @param kindCode
	 * @return El agente que buscamos
	 */	
	public Agente getAgente(String user, String password, String kindCode) {
		return agenteRepository.findeAgentByUserPassKind(user, password, kindCode);
	}
	
	
	//Este metodo es solo para añadir a los agentes de prueba que se crear en InsertSampleDataService
	public void addAgente(Agente agent) {
		agent.setContrasena(bCryptPasswordEncoder.encode(agent.getContrasena()));
		agenteRepository.save(agent);
	}

	public Agente getAgentByNombre(String nombre) {
		return agenteRepository.findByNombre(nombre);
	}

	public Agente getAgenteById(Long id_agente) {
		return agenteRepository.findOne(id_agente);
	}
}
