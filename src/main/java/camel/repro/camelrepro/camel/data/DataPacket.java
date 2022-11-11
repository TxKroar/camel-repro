package camel.repro.camelrepro.camel.data;

import java.io.Serializable;


public class DataPacket implements Serializable {
	private int aggregationAttribute;
	
	
	public int getAggregationAttribute() {
		return aggregationAttribute;
	}
	
	public void setAggregationAttribute(int aggregationAttribute) {
		this.aggregationAttribute = aggregationAttribute;
	}
	
	@Override
	public String toString() {
		return "DataPacket{" +
				"aggregationAttribute=" + aggregationAttribute +
				'}';
	}
}
