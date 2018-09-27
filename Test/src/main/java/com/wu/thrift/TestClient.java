package com.wu.thrift;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 * Created by yangyang on 2018/9/27.
 */
public class TestClient {
    public static void main(String[] args) throws TException {

        TTransport tTransport = new TSocket("localhost",9090);
        tTransport.open();
        TProtocol protocol = new TBinaryProtocol(tTransport);
        Calculator.Client client = new Calculator.Client(protocol);

        client.ping();
        int re = client.add(3,2);
        System.out.println(re);

        tTransport.close();
    }
}
