package cn.yang.store;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

@EnableJpaAuditing//时间自动更新需要
@SpringBootApplication
public class Mystore01Application extends WebMvcConfigurerAdapter {
	public static void main(String[] args) {
		SpringApplication.run(Mystore01Application.class, args);
	}
	@Override
	public void  configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
		/*
        1.需要先定义一个convert转换消息的对象；
        2.添加fastjson的配置信息，比如是否要格式化返回的json数据
        3.在convert中添加配置信息
        4.将convert添加到converters中
         */
        //1.定义一个convert转换消息对象
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		//2.添加fastjson的配置信息，比如是否要格式化返回json数据
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		
		fastConverter.setFastJsonConfig(fastJsonConfig);
		converters.add(fastConverter);
	}
}
