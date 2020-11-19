package com.mjlf.k8s;

import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.Configuration;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.*;
import io.kubernetes.client.util.Config;

import java.io.IOException;
import java.util.List;

public class Example {
    public static void main(String[] args) throws IOException, ApiException{
        ApiClient client = Config.defaultClient();
        //设置k8s访问地址
        client.setBasePath("http://192.168.43.27:8080");
        Configuration.setDefaultApiClient(client);

        CoreV1Api api = new CoreV1Api();

        try {
            //获取原有Pod信息
            V1Pod getPod = api.readNamespacedPod("nginx2", "default", "true", false, false);

            String namespace = "default";

            //更新配置信息和去掉无用配置
            //设置新pod状态
            getPod.setStatus(null);

            //设置新元数据信息
            getPod.getMetadata().setName("nginx3");
            getPod.getMetadata().setResourceVersion(null);
            getPod.getMetadata().setCreationTimestamp(null);
            getPod.getMetadata().setSelfLink(null);
            getPod.getMetadata().setUid(null);

            //设置信息spec信息
            List<V1Container> containers = getPod.getSpec().getContainers();
            containers.forEach(v1Container -> {
                v1Container.setName("nginx3");
                v1Container.setResources(null);
                v1Container.setImagePullPolicy(null);
                v1Container.setTerminationMessagePath(null);
                v1Container.setTerminationMessagePolicy(null);
                v1Container.setVolumeMounts(null);
            });
            getPod.setSpec(null);

            V1PodSpec spec = new V1PodSpec();
            spec.setContainers(containers);
            getPod.setSpec(spec);

            //开始创建信息的pod
            V1Pod pod = api.createNamespacedPod(namespace, getPod, "true", null, null);
            System.out.println(pod);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}