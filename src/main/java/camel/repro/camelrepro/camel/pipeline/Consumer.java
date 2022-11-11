package camel.repro.camelrepro.camel.pipeline;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Consumer implements Processor {
	private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);
	
	@Override
	public void process(Exchange exchange) throws InterruptedException {
		if(Thread.currentThread().getName().contains("dataPackets")) {
			LOGGER.error("If you see this, the JmsConsumer Thread will be stuck perpetually waiting; Place your Breakpoint here. " +
					"Go up in the Stack trace to 'executeFromQueue' and check the 'back'-Deque: the Runnable in there is the CountDownLatch::countDown call that it is waiting for to happen, but never will happen");
		}
		//We deliberately make our consumer slow to reliably reporduce the issue
		Thread.sleep(5_000);
	}
}
