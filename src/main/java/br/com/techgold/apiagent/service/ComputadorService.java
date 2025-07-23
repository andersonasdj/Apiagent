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
		  	computador.setAntivirus(dto.antivirus());
		  	computador.setAgent_install_date(dto.agentInstallDate());
		  	computador.setAddress(dto.address());
		  	computador.setBitlockerRecoveryKeys(dto.bitlockerRecoveryKeys());
		  	computador.setBiosReleaseDate(dto.biosReleaseDate());
		  	computador.setBiosVendor(dto.biosVendor());
		  	computador.setBiosVersion(dto.biosVersion());
		  	computador.setCliente(cliente);
		  	computador.setCpu(dto.cpu());
		  	computador.setCpuFrequencyGHz(dto.cpuFrequencyGHz());
		  	computador.setDnsServers(dto.dnsServers());
		  	computador.setDisk(dto.disk());
		  	computador.setDiskAvailable(dto.diskAvailable());
		  	computador.setDeviceType(dto.deviceType());
		  	computador.setGateway(dto.gateway());
		  	computador.setGpus(dto.gpus());
		  	computador.setIpAddresses(dto.ipAddresses());
		  	computador.setLast_boot_time(dto.lastBootTime());
		  	computador.setLast_seen(dto.lastSeen());
		  	computador.setManufacturer(dto.manufacturer());
		  	computador.setMac(dto.mac());
		  	computador.setMemorySlots(dto.memorySlots());
		  	computador.setMonitores(dto.monitores());
		    computador.setName(dto.name());
		    computador.setNetworkSpeedMbps(dto.networkSpeedMbps());
		    computador.setOs(dto.os());
		    computador.setOsVersion(dto.osVersion());
		    computador.setOsBuildNumber(dto.osBuildNumber());
		    computador.setOsArchitecture(dto.osArchitecture());
		    computador.setPlatform(dto.platform());
		    computador.setRam(dto.ram());
		    computador.setRamAvailable(dto.ramAvailable());
		    computador.setSerial(dto.serial());
		    computador.setStatus(dto.status());
		    computador.setSystemUptimeSeconds(dto.systemUptimeSeconds());
		    computador.setType(dto.type());
		    computador.setTimeZone(dto.timeZone());
		    computador.setUsername(dto.username());
		    computador.setUuid(dto.uuid());
		    repository.save(computador);
	}
	
	
	public boolean existePorSerial(String serial, String name) {
		return repository.existsBySerialAndName(serial, name);
	}
	
	public boolean existePorUuid(String uuid, String name) {
		return repository.existsByUuidAndName(uuid, name);
	}

	@Transactional
	public void atualizaComputador(DadosComputador dto, Cliente cliente) {
		Computador computador = repository.findBySerial(dto.serial());
		computador.setAntivirus(dto.antivirus());
		computador.setAddress(dto.address());
		computador.setBitlockerRecoveryKeys(dto.bitlockerRecoveryKeys());
		computador.setBiosReleaseDate(dto.biosReleaseDate());
	  	computador.setBiosVendor(dto.biosVendor());
	  	computador.setBiosVersion(dto.biosVersion());
		computador.setCliente(cliente);
		computador.setCpu(dto.cpu());
		computador.setCpuFrequencyGHz(dto.cpuFrequencyGHz());
		computador.setDnsServers(dto.dnsServers());
		computador.setDisk(dto.disk());
		computador.setDiskAvailable(dto.diskAvailable());
		computador.setDeviceType(dto.deviceType());
		computador.setGateway(dto.gateway());
		computador.setGpus(dto.gpus());
		computador.setDeviceType(dto.deviceType());
		computador.setDomain(dto.domain());
		computador.setDevice_name(dto.device_name());
		computador.setIpAddresses(dto.ipAddresses());
		computador.setLast_boot_time(dto.lastBootTime());
		computador.setLast_seen(dto.lastSeen());
		computador.setMac(dto.mac());
		computador.setMemorySlots(dto.memorySlots());
		computador.setMonitores(dto.monitores());
		computador.setManufacturer(dto.manufacturer());
		computador.setName(dto.name());
		computador.setNetworkSpeedMbps(dto.networkSpeedMbps());
		computador.setOs(dto.os());
		computador.setOsVersion(dto.osVersion());
		computador.setOsBuildNumber(dto.osBuildNumber());
		computador.setOsArchitecture(dto.osArchitecture());
		computador.setPlatform(dto.platform());
		computador.setRam(dto.ram());
		computador.setRamAvailable(dto.ramAvailable());
		computador.setStatus(dto.status());
		computador.setSerial(dto.serial());
		computador.setSystemUptimeSeconds(dto.systemUptimeSeconds());
		computador.setTimeZone(dto.timeZone());
	    computador.setType(dto.type());
	    computador.setUsername(dto.username());
	    computador.setUuid(dto.uuid());
	}
	

}
