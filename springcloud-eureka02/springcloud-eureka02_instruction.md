# springcloud-eureka02

**springcloud注册中心eureka的使用**

## springcloud注册中心eureka的使用关键点
    1、新建工程eureka-server，作为eureka注册中心
        (1)、在启动类上添加注解用于开启eureka server功能
            @EnableEurekaServer
        (2)、配置服务的名称
            spring.application.name=eureka-server
        (3)、配置是否注册自己的信息到EurekaServer，默认是true
            eureka.client.register-with-eureka=false
        (4)、配置是否拉取其它服务的信息，默认是true
              eureka.client.fetch-registry=false
        (5)、配置EurekaServer的地址，现在是自己的地址，如果是集群，需要加上其它Server的地址。
            eureka.client.service-url.defaultZone:http://127.0.0.1:${server.port}/eureka
    
    2、新建工程eureka-provider，controller提供rest服务
        (1)、在pom.xml文件中添加依赖
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
            </dependency>
        (2)、<properties>中添加springcloud的版本
            <spring-cloud.version>Finchley.SR1</spring-cloud.version>
        (3)、配置服务的名称
            spring.application.name=eureka-provider
        (4)、配置eurekaserver的地址
            eureka.client.service-url.defaultZone=http://127.0.0.1:10000/eureka
        (5)、配置当调用getHostname获取实例的hostname时，返回ip而不是host名称
            eureka.instance.prefer-ip-address=true
        (6)、配置指定自己的ip信息，不指定的话会自己寻找
            eureka.instance.ip-address=127.0.0.1
        (7)、在启动类上添加注解用于开启eureka client功能
            @EnableDiscoveryClient
    
    3、新建工程eureka-consumer，消费provider提供的服务
        (1)、在pom.xml文件中添加依赖
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
            </dependency>
        (2)、<properties>中添加springcloud的版本
            <spring-cloud.version>Finchley.SR1</spring-cloud.version>
        (3)、配置服务的名称
            spring.application.name=eureka-consumer
        (4)、配置eurekaserver的地址
            eureka.client.service-url.defaultZone=http://127.0.0.1:10000/eureka
        (5)、配置当调用getHostname获取实例的hostname时，返回ip而不是host名称
            eureka.instance.prefer-ip-address=true
        (6)、新建RestConfig文件
            @Bean
            public RestTemplate restTemplate() {
                return new RestTemplate();
            }
        (7)、controller中注入RestTemplate
            @Autowired
            private DiscoveryClient discoveryClient;
        (8)、从注册中心中获取提供者的信息
            List<ServiceInstance> instances = discoveryClient.getInstances("eureka-provider");
            ServiceInstance instance = instances.get(0);
        (9)、消费eureka-provider提供的服务
            String baseUrl = "http://" + instance.getHost() + ":" + instance.getPort();
            User user = restTemplate.getForObject(baseUrl + "/findById/" + id, User.class);
        (10)、在启动类上添加注解用于开启eureka client功能
            @EnableDiscoveryClient