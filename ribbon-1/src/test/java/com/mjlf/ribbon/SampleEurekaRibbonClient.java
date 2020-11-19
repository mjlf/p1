package com.mjlf.ribbon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.netflix.appinfo.DataCenterInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
import com.netflix.appinfo.ApplicationInfoManager;
import com.netflix.appinfo.InstanceInfo.InstanceStatus;
import com.netflix.appinfo.MyDataCenterInstanceConfig;
import com.netflix.client.ClientFactory;
import com.netflix.discovery.DefaultEurekaClientConfig;
import com.netflix.discovery.DiscoveryManager;
import com.netflix.loadbalancer.DynamicServerListLoadBalancer;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.Server;
 
/**
 * Sample Eureka client that discovers the service using Eureka and sends
 * requests.
 *
 * @author Karthik Ranganathan
 *
 */
public class SampleEurekaRibbonClient {
	private static final Logger logger = LoggerFactory
			.getLogger(SampleEurekaRibbonClient.class);
 
	public void sendRequestToServiceUsingEureka() {
		// Register with Eureka
		DiscoveryManager.getInstance().initComponent(
				new MyDataCenterInstanceConfig(),
				new DefaultEurekaClientConfig());
		ApplicationInfoManager.getInstance().setInstanceStatus(
				InstanceStatus.UP);
		// get LoadBalancer instance from configuration, properties file
		DynamicServerListLoadBalancer lb = (DynamicServerListLoadBalancer) ClientFactory.getNamedLoadBalancer("ECF");
		// show all servers in the list
		List<Server> list = lb.getServerList(true);
		Iterator<Server> it = list.iterator();
		while (it.hasNext()) {
			Server server = it.next();
			logger.debug("application service host:" + server.getHost() + ";port=" + server.getPort());
		}
		// use RandomRule 's RandomRule algorithm to get a random server from lb 's server list
		RandomRule randomRule = new RandomRule();
		Server randomAlgorithmServer = randomRule.choose(lb, null);
		logger.debug("random algorithm server host:" + randomAlgorithmServer.getHost() + ";port:" + randomAlgorithmServer.getPort());
		// communicate with the server
		Socket s = new Socket();
		try {
			s.connect(new InetSocketAddress(randomAlgorithmServer.getHost(), randomAlgorithmServer.getPort()));
		} catch (IOException e) {
			logger.error("Could not connect to the server :"
					+ randomAlgorithmServer.getHost() + " at port " + randomAlgorithmServer.getPort());
		}
		try {
			logger.debug("Connected to server. Sending a sample request");
			PrintStream out = new PrintStream(s.getOutputStream());
			out.println("Sample request " + new Date());
			String str = null;
			logger.debug("Waiting for server response..");
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					s.getInputStream()));
			str = rd.readLine();
			if (str != null) {
				logger.debug("Received response from server. Communication all fine using Eureka :");
				logger.debug("Exiting the client. Demo over..");
			}
			rd.close();
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}
		this.unRegisterWithEureka();
	}
 
	public void unRegisterWithEureka() {
		// Un register from eureka.
		DiscoveryManager.getInstance().shutdownComponent();
	}
 
	public static void main(String[] args) {
		SampleEurekaRibbonClient sampleEurekaRibbonClient = new SampleEurekaRibbonClient();
		sampleEurekaRibbonClient.sendRequestToServiceUsingEureka();
 
	}
}