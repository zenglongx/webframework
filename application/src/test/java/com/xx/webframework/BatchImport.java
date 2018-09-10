package com.xx.webframework;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@Slf4j
public class BatchImport implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(BatchImport.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        //
        log.info(jdbcTemplate.toString());
        jdbcTemplate.execute("DROP TABLE IF EXISTS `customers`");
        jdbcTemplate.execute("CREATE TABLE `customers` (\n" +
                "  `id` INTEGER NOT NULL AUTO_INCREMENT,\n" +
                "  `name` VARCHAR(50) NOT NULL DEFAULT '',\n" +
                "  `sex` TINYINT(1) NOT NULL DEFAULT 0,\n" +
                "  `id_card` CHAR(18) NOT NULL DEFAULT '',\n" +
                "  PRIMARY KEY (`id`)\n" +
                ")");
        int count = 100000000;
        List<Object[]> params = Lists.newArrayList();
        for(int i = 0; i < count;i = i+1000){
            params.clear();
            for(int j = 0; j < 1000; j++){
                Object[] objs = new Object[3];
                objs[0] = randomName();
                objs[1] = randomSex();
                objs[2] = randomIdCard();
                params.add(objs);
            }
            long begintime = System.currentTimeMillis();
            jdbcTemplate.batchUpdate("insert into customers(name,sex,id_card) values (?,?,?)",params);
            log.info("per 1000 cost {} ms",System.currentTimeMillis() - begintime);
        }
    }

    private String randomIdCard() {
        String codeStr = "0123456789x";
        StringBuilder sb = new StringBuilder();
        for (int i =0; i< 18; i++){
            sb.append(codeStr.charAt(new Random().nextInt(11)));
        }
        return sb.toString();
    }

    private byte randomSex() {
        return (byte)(new Random().nextBoolean()?0x01:0x00);
    }

    private String randomName() {
        String codeStr = "abcdefghigklmnopqrstuvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        int num = new Random().nextInt(50);
        if(num < 4){
            num = num+4;
        }
        for (int i =0; i< num; i++){
            sb.append(codeStr.charAt(new Random().nextInt(52)));
        }
        return sb.toString();
    }
}
