package camel.repro.camelrepro.camel.pipeline;

import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import camel.repro.camelrepro.camel.data.DataPacket;

public class Filter {
	private static final Logger LOGGER = LoggerFactory.getLogger(Filter.class);
	private final ProducerTemplate producerTemplate;
	private final String endpointUri;
	
	public Filter(ProducerTemplate producerTemplate, String endpointUri) {
		this.producerTemplate = producerTemplate;
		this.endpointUri = endpointUri;
	}
	
	
	public void filterData(Exchange exchange) {
		List<DataPacket> dataPackets = exchange.getIn().getBody(List.class);
		if(dataPackets != null && !dataPackets.isEmpty()) {
			LOGGER.info("Received {} DataPackets for Filtering", dataPackets.size());
			for(DataPacket dataPacket: dataPackets) {
				processSingleDataPacket(dataPacket);
			}
		}
	}
	
	private void processSingleDataPacket(DataPacket dataPacket) {
		//Here we could do filtering, ... - instead we will just send everything on unchanged since filtering, ... is not required to reproduce the bug
		producerTemplate.sendBody(endpointUri, ExchangePattern.InOnly, dataPacket);
	}
}
