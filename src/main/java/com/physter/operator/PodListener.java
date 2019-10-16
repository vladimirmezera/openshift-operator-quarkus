package com.physter.operator;

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.util.List;

/**
 *
 */
public class PodListener {

    @Inject
    private KubernetesClient client;

    void onStartup(@Observes StartupEvent _ev) {
        List<Pod> podList = client.pods().list().getItems();
        System.out.println("Found " + podList.size() + " Pods:");
        for (Pod pod : podList) {
            System.out.println(" * " + pod.getMetadata().getName());
        }
    }
}
