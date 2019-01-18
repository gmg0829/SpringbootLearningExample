package com.gmg.springboot_docker_java.docker;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.DockerCmdExecFactory;
import com.github.dockerjava.api.command.InspectImageResponse;
import com.github.dockerjava.api.model.Info;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.jaxrs.JerseyDockerCmdExecFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gmg
 * @Title:
 * @Package
 * @Description:
 * @date 2019/1/16  16:52
 */
@RestController
public class IndexController {

    private static final Logger log = LoggerFactory.getLogger(IndexController.class);

    @Value("${docker.io.url}")
    private String url;
    @Value("${docker.io.dockerCertPath}")
    private String dockerCertPath;
    @Value("${docker.io.username}")
    private String username;
    @Value("${docker.io.password}")
    private String password;
    @Value("${docker.io.email}")
    private String email;
    @Value("${docker.io.serverAddress}")
    private String serverAddress;
    @Value("${docker.io.apiVersion}")
    private String apiVersion;
    //	@Value("${docker.io.nodeUrl}")
//	private String nodeUrl;
    @Value("${docker.io.type}")
    private String type;
    @Value("${docker.io.port}")
    private String port;


    public DockerClient getSpecialDockerClientInstance(){
        DockerClientConfig config = DefaultDockerClientConfig
                .createDefaultConfigBuilder()
                .withDockerHost(url)
                .withApiVersion(apiVersion)
                .withDockerCertPath(dockerCertPath)
                .withRegistryUsername(username)
                .withRegistryPassword(password)
                .withRegistryEmail(email)
                .withRegistryUrl(serverAddress)
                .build();
        DockerCmdExecFactory dockerCmdExecFactory = new JerseyDockerCmdExecFactory()
                .withReadTimeout(1000)
                .withConnectTimeout(1000)
                .withMaxTotalConnections(100)
                .withMaxPerRouteConnections(10);
        DockerClient dockerClient = DockerClientBuilder.getInstance(config).withDockerCmdExecFactory(dockerCmdExecFactory).build();
        return dockerClient;
    }

    @RequestMapping("/inspectImage")
    public InspectImageResponse inspectImage(String imageId, String imageName, String imageVersion) {
        DockerClient dockerClient = this.getSpecialDockerClientInstance();
        Info info = dockerClient.infoCmd().exec();
        System.out.println(info);
        InspectImageResponse response = null;
        try {
            response = dockerClient.inspectImageCmd(this.generateRegistryImageName(imageName, imageVersion)).exec();
        }
        catch (Exception e) {
            log.error("error inspect image,message:-"+e.getMessage());
            try {
                response =  dockerClient.inspectImageCmd(imageId).exec();
            }
            catch (Exception e2) {
                log.error("error message."+e.getMessage());
            }
        }
        return response;
    }

    public String generateRegistryImageName(String imageName,String imageVersion){
        return username+"/"+imageName+":"+imageVersion;
    }
}
