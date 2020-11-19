package com.mjlf.k8s;

import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.Configuration;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.V1Pod;
import io.kubernetes.client.util.Config;

import java.io.IOException;
import java.util.List;

public class ReadPod {
    public static void main(String[] args) throws IOException, ApiException{
        //建立客户端实例
        ApiClient client = Config.defaultClient();
        //设置k8s集群访问地址
        client.setBasePath("http://192.168.43.27:8080");
        Configuration.setDefaultApiClient(client);

        //核心api
        CoreV1Api api = new CoreV1Api();

        try {
            //获取pod信息
            V1Pod getPod = api.readNamespacedPod("nginx2", "default", "true", false, false);
            System.out.println(getPod);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}