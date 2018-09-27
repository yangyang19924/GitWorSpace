package com.wu.thrift;

import org.apache.thrift.TException;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * Created by yangyang on 2018/9/27.
 */
public class TestServer {

    public static class CalculatorHandler implements Calculator.Iface {
        @Override
        public void ping() throws TException {
            System.out.println("ping......");
        }

        @Override
        public int add(int num1, int num2) throws TException {
            return num1+num2;
        }

    }

    public static void main(String[] args) throws TTransportException {

        CalculatorHandler handler = new CalculatorHandler();
        Calculator.Processor processor = new Calculator.Processor(handler);

        TServerTransport serverTransport = new TServerSocket(9090);
        TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));

        System.out.println("Starting the simple server...");
        server.serve();

    }
}
