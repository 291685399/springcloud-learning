# springcloud-eureka01

**springcloud注册中心eureka入门**

## springcloud注册中心eureka入门关键点
    1、新建工程eureka-provider，controller提供rest服务
    
    2、新建工程eureka-consumer
        (1)、新建RestConfig文件
            @Bean
            public RestTemplate restTemplate() {
                return new RestTemplate();
            }
        (2)、controller中注入RestTemplate
            @Autowired
            private RestTemplate restTemplate;
        (3)、消费eureka-provider提供的服务
            User user = restTemplate.getForObject("http://127.0.0.1:8081/findById", User.class);