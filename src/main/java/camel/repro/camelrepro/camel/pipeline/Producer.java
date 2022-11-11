package camel.repro.camelrepro.camel.pipeline;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;

import camel.repro.camelrepro.camel.data.DataPacket;


public class Producer extends Thread {
	
	private final ProducerTemplate producerTemplate;
	private final String endpointUri;
	private final Random random;
	
	private boolean produce = true;
	
	public Producer(ProducerTemplate producerTemplate, String endpointUri) {
		super("data producer");
		this.producerTemplate = producerTemplate;
		this.endpointUri = endpointUri;
		this.random = new Random();
	}
	
	@Override
	public void run() {
		try {
			while(produce) {
				Thread.sleep(5_000);
				producerTemplate.sendBody(endpointUri, ExchangePattern.InOnly, createRandomDataPackets());
			}
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	private List<DataPacket> createRandomDataPackets() {
		int count = 500_000;
		ArrayList<DataPacket> dataPackets = new ArrayList<>(count);
		for(int i = 0; i < count; i++) {
			dataPackets.add(createRandomDataPacket());
		}
		return dataPackets;
	}
	
	private DataPacket createRandomDataPacket() {
		DataPacket dataPacket = new DataPacket();
		dataPacket.setAggregationAttribute((byte) random.nextInt(1000));
		return dataPacket;
	}
	
	public void stopProducing() {
		this.produce = false;
	}
}
