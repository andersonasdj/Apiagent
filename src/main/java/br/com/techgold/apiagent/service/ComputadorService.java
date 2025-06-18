package br.com.techgold.apiagent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.techgold.apiagent.dto.DadosComputador;
import br.com.techgold.apiagent.model.Cliente;
import br.com.techgold.apiagent.model.Computador;
import br.com.techgold.apiagent.repository.ComputadorRepository;
import jakarta.transaction.Transactional;

@Service
public class ComputadorService {
	
	@Autowired
	private ComputadorRepository repository;

	public void cadastrarNovo(DadosComputador dto, Cliente cliente) {
		  Computador computador = new Computador();
		  	computador.setCliente(cliente);
		    computador.setName(dto.name());
		    computador.setOs(dto.os());
		    computador.setCpu(dto.cpu());
		    computador.setRam(dto.ram());
		    computador.setDisk(dto.disk());
		    computador.setMac(dto.mac());
		    computador.setPlatform(dto.platform());
		    computador.setLast_boot_time(dto.lastBootTime());
		    computador.setLast_seen(dto.lastSeen());
		    computador.setStatus(dto.status());
		    computador.setSerial(dto.serial());
		    computador.setType(dto.type());
		    computador.setManufacturer(dto.manufacturer());
		    computador.setAddress(dto.address());
		    computador.setUsername(dto.username());
		    computador.setOsVersion(dto.osVersion());
		    computador.setOsBuildNumber(dto.osBuildNumber());
		    computador.setOsArchitecture(dto.osArchitecture());
		    computador.setTimeZone(dto.timeZone());
		    computador.setCpuFrequencyGHz(dto.cpuFrequencyGHz());
		    computador.setRamAvailable(dto.ramAvailable());
		    computador.setIpAddresses(dto.ipAddresses());
		    computador.setNetworkSpeedMbps(dto.networkSpeedMbps());
		    computador.setSystemUptimeSeconds(dto.systemUptimeSeconds());
		    repository.save(computador);
	}
	
	
	public boolean existePorSerial(String serial, String name) {
		return repository.existsBySerialAndName(serial, name);
	}


	@Transactional
	public void atualizaComputador(DadosComputador dto, Cliente cliente) {
		Computador computador = repository.findBySerial(dto.serial());
		computador.setName(dto.name());
		computador.setMac(dto.mac());
		computador.setOs(dto.os());
		computador.setOsVersion(dto.osVersion());
		computador.setOsBuildNumber(dto.osBuildNumber());
		computador.setOsArchitecture(dto.osArchitecture());
		computador.setTimeZone(dto.timeZone());
		computador.setCpu(dto.cpu());
		computador.setCpuFrequencyGHz(dto.cpuFrequencyGHz());
		computador.setCliente(cliente);
	    computador.setRam(dto.ram());
	    computador.setDisk(dto.disk());
	    computador.setDiskAvailable(dto.diskAvailable());
	    computador.setPlatform(dto.platform());
	    computador.setLast_boot_time(dto.lastBootTime());
	    computador.setLast_seen(dto.lastSeen());
	    computador.setStatus(dto.status());
	    computador.setSerial(dto.serial());
	    computador.setType(dto.type());
	    computador.setManufacturer(dto.manufacturer());
	    computador.setAddress(dto.address());
	    computador.setUsername(dto.username());
	    computador.setRamAvailable(dto.ramAvailable());
	    computador.setIpAddresses(dto.ipAddresses());
	    computador.setNetworkSpeedMbps(dto.networkSpeedMbps());
	    computador.setSystemUptimeSeconds(dto.systemUptimeSeconds());
	    computador.setDomain(dto.domain());
	    computador.setDeviceType(dto.deviceType());
	    computador.setDevice_name(dto.device_name());
	    
	    
	}
	

}
