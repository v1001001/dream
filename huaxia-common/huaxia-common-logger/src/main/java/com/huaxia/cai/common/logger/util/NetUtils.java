package com.huaxia.cai.common.logger.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.regex.Pattern;

/**
 * 网络ip
 * @author leizhicheng
 *
 */
public class NetUtils {


	private static final Pattern IP_PATTERN = Pattern.compile("\\d{1,3}(\\.\\d{1,3}){3,5}$");

	/**
	 * 本机ip
	 * @return
	 */
	public static String getLocalIP() {
		InetAddress localAddress = getLocalAddress0();
		return localAddress == null ? "127.0.0.1" : localAddress.getHostAddress();
	}

	/**
	 * 有效ip校验
	 * 
	 * @param address
	 * @return
	 */
	private static boolean isValidAddress(InetAddress address) {

		if (address == null || address.isLoopbackAddress())
			return false;
		String ip = address.getHostAddress();

		if (ip != null && !ip.startsWith("0.0") && !"127.0.0.1".equals(ip) && IP_PATTERN.matcher(ip).matches()) {
			return true;
		}

		return false;
	}

	/**
	 * 本机网络信息
	 * @return
	 */
	private static InetAddress getLocalAddress0() {

		// host文件信息
		InetAddress localAddress = null;
		try {
			localAddress = InetAddress.getLocalHost();
			if (isValidAddress(localAddress)) {
				
				return localAddress;
			}
		} catch (Exception e) {
		}
		
		//第一块网卡信息
		try {
			Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
			if (interfaces != null) {
				while (interfaces.hasMoreElements()) {

					NetworkInterface network = interfaces.nextElement();
					Enumeration<InetAddress> addresses = network.getInetAddresses();
					if (addresses != null) {
						while (addresses.hasMoreElements()) {
							InetAddress address = addresses.nextElement();
							if (isValidAddress(address)) {
								return address;
							}
						}
					}
				}

			}
		} catch (Exception e) {
		}
		
		return localAddress;
	}
	

}
