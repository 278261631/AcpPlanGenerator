package com.interstellarexploration.remoteobs.asputil.test.testport;


import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class TestPortScan {
	public static void main(String[] args) {
        PortScanDemo portScanDemo = new PortScanDemo();

        //方式1
//         portScanDemo.scanLargePorts("baidu.com", 20, 10000, 5,800);
//         portScanDemo.scanLargePorts("192.168.1.104", 1, 10000, 100,1000);
 
        //方式2
        Set<Integer> portSet = new LinkedHashSet<Integer>();
        Integer[] ports = new Integer[] { 21, 22, 23, 25, 26, 69, 80, 110, 143,
                443, 465, 995, 1080, 1158, 1433, 1521, 2100, 3128, 3306, 3389,
                7001, 8080, 9080, 9090,43958,5348,8081,8870,8850,8872,8830,8810,8860,8831,8812,9022,9021,61616,};
        portSet.addAll(Arrays.asList(ports));
//        portScanDemo.scanLargePorts("", portSet, 1, 800);
        portScanDemo.scanLargePorts("192.168.1.104", portSet, 1, 100);
 
    }
}