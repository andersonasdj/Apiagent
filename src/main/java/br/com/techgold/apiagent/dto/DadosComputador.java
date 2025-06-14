package br.com.techgold.apiagent.dto;

import java.time.LocalDateTime;
import java.util.List;

import br.com.techgold.apiagent.model.Cliente;

public record DadosComputador(
		String name,
		String mac,
		String os,
		String osVersion,
		String osBuildNumber,
		String osArchitecture,
		String timeZone,
		String cpu,
		double cpuFrequencyGHz,
		double cpuTemperatureCelsius,
		String ram,
		String ramAvailable,
		List<String> disk,
	    List<String> diskAvailable,
		String platform,
		String status,
		String address,
		List<String> ipAddresses,
		long networkSpeedMbps,
		String type,
		String comment,
		String serial,
		String device_name,
		String manufacturer,
		LocalDateTime lastSeen,
		LocalDateTime agentInstallDate,
		LocalDateTime lastBootTime,
		Long clienteId,
		Long funcionarioId,
		String username,
		long systemUptimeSeconds,
		Cliente cliente,
		List<String> memorySlots,
	    String gateway,
	    List<String> dnsServers,
	    List<String> gpus,
	    String biosVersion,
	    String biosVendor,
	    String biosReleaseDate,
	    int monitores,
	    String uuid,
	    boolean isVirtualMachine,
	    String domain,
	    String deviceType
		
		) {

}
