package com.github.wkennedy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.context.config.annotation.EnableContextCredentials;
import org.springframework.cloud.aws.context.config.annotation.EnableContextRegion;
import org.springframework.cloud.aws.jdbc.config.annotation.EnableRdsInstance;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories
//@EnableRdsInstance(databaseName="HWRegistrationSchema", dbInstanceIdentifier="HWRegistrationDB", username="hwadmin",password="hw123456")
//@EnableContextCredentials(accessKey="AKIAJEU4OB6S5EAQZZHA", secretKey="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")
//@EnableContextRegion(region="us-west-2")
public class HwregistrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(HwregistrationApplication.class, args);
    }
}
