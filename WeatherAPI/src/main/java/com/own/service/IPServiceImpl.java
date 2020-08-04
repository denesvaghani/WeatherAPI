package com.own.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class IPServiceImpl implements IPService {

	private static final Logger logger = LoggerFactory.getLogger(IPServiceImpl.class);

	@Override
	public String getIpOfDevice() throws Exception {

		logger.info(" Process is finding IP Address...");

		URL url = new URL("http://checkip.amazonaws.com");
		BufferedReader bufferReader = new BufferedReader(new InputStreamReader(url.openStream()));
		
		String ipAddress = bufferReader.readLine().trim();

		logger.info(" Ip Address of PC : " + ipAddress);

		return ipAddress;
	}

}
