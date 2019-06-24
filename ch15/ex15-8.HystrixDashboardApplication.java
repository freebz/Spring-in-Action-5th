@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardApplication {
    public static void main(String[] args) {
	SpringApplication.run(HystrixDashboardApplication.class, args);
    }
}
