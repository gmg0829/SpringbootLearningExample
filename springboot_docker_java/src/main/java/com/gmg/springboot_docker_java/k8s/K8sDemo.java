package com.gmg.springboot_docker_java.k8s;

import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;

/**
 * @author gmg
 * @Title:
 * @Package
 * @Description:
 * @date 2019/1/18  10:43
 */
public class K8sDemo {

    public static void createNamespace() {
        KubernetesClient kubernetesClient=K8sDemo.getKubernetesClient();
        Namespace namespace=new Namespace();
        kubernetesClient.namespaces().create();

    }

    public static void createPod() {
        KubernetesClient kubernetesClient=K8sDemo.getKubernetesClient();
        Pod pod=new Pod();
        kubernetesClient.pods().create();

    }
    public static  KubernetesClient getKubernetesClient(){
        KubernetesClient kubernetesClient=new DefaultKubernetesClient("");
        return kubernetesClient;
    }
}
