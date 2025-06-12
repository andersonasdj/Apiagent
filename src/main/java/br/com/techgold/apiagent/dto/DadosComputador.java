package br.com.techgold.apiagent.dto;

import java.time.LocalDateTime;
import java.util.List;

import br.com.techgold.apiagent.model.Cliente;

public record DadosComputador(
		 String name,
		 String mac,
		 String os,
		 String cpu,
		 String ram,
		 String disk,
		 String platform,
		 String status,
		 String address,
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
		 String osVersion,
		 String osBuildNumber,
		 String osArchitecture,
		 String timeZone,
		 double cpuFrequencyGHz,
		 double cpuTemperatureCelsius,
		 String ramAvailable,
		 String diskAvailable,
		 List<String> ipAddresses,
		 long networkSpeedMbps,
		 long systemUptimeSeconds,
		 Cliente cliente
		
		) {

}
