// 7.1 Consuming REST endpoints with RestTemplate

RestTemplate rest = new RestTemplate();


@Bean
public RestTemplate restTemplate() {
    return new RestTemplate();
}
