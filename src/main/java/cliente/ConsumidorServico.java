package cliente;

import response.BatalhaResponse;
import response.TurnoResponse;

import javax.annotation.PostConstruct;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ConsumidorServico {
	private String baseUrl = "http://localhost:8080/batalha";
	
	private Client cliente;
	private WebTarget target;
	
	public ConsumidorServico() {
		super();
		init();
	}
	
    protected void init() {
        this.cliente = ClientBuilder.newClient();
        this.target = cliente.target(baseUrl);
    }
	
	public BatalhaResponse criaBatalha(Entity<CreateBattleRequest> request) throws Exception {
		this.target = cliente.target(baseUrl);
		Response resp = target.request(MediaType.APPLICATION_JSON).post(request);
		if(resp.getStatus() != 200) {
			throw new Exception("Falha na comunicação!");
		}
        return resp.readEntity(BatalhaResponse.class);
    }

	public TurnoResponse criaTurno(Entity<CreateTurnRequest> entity, long battle) throws Exception {
		this.target = cliente.target(baseUrl + "/" + battle);
		Response resp = target.request(MediaType.APPLICATION_JSON).post(entity);
		if(resp.getStatus() != 200) {
			throw new Exception("Falha na comunicação!");
		}
        return resp.readEntity(TurnoResponse.class);
	}

	public BatalhaResponse recuperaBatalha(long battle) throws Exception {
		this.target = cliente.target(baseUrl + "/" + battle);
		Response resp = target.request(MediaType.APPLICATION_JSON).get();
		if(resp.getStatus() != 200) {
			throw new Exception("Falha na comunicação!");
		}
        return resp.readEntity(BatalhaResponse.class);
	}
}
