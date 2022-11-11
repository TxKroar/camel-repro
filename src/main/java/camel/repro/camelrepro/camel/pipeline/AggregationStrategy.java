package camel.repro.camelrepro.camel.pipeline;

import org.apache.camel.Body;
import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AbstractListAggregationStrategy;

import camel.repro.camelrepro.camel.data.DataPacket;


public class AggregationStrategy extends AbstractListAggregationStrategy<DataPacket> {
	@Override
	public DataPacket getValue(Exchange exchange) {
		return exchange.getIn().getBody(DataPacket.class);
	}
	
	public String correlate(@Body DataPacket dataPacket) {
		return String.valueOf(dataPacket.getAggregationAttribute());
	}
}
