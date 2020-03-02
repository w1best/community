package wl.onelei.test.tolk;

        import org.mybatis.spring.annotation.MapperScan;
        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("wl.onelei.test.tolk.mapper")
public class TolkApplication {

    public static void main(String[] args) {
        SpringApplication.run(TolkApplication.class, args);
    }

}
