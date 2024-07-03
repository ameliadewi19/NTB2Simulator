/*
 * Copyright PT LEN INNOVATION TECHNOLOGY
 *
 * THIS SOFTWARE SOURCE CODE AND ANY EXECUTABLE DERIVED THEREOF ARE PROPRIETARY
 * TO PT LEN INNOVATION TECHNOLOGY, AS APPLICABLE, AND SHALL NOT BE USED IN ANY WAY
 * OTHER THAN BEFOREHAND AGREED ON BY PT LEN INNOVATION TECHNOLOGY, NOR BE REPRODUCED
 * OR DISCLOSED TO THIRD PARTIES WITHOUT PRIOR WRITTEN AUTHORIZATION BY
 * PT LEN INNOVATION TECHNOLOGY, AS APPLICABLE.
 */
/**
 * @author Hendra Prawira
 */

/**
 * the class is Main Class
 */

package com.leniot.management.track;
import com.leniot.management.track.adapters.dbconnection.HashMapDb;
import com.leniot.management.track.utils.ThreadStarter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import java.util.HashMap;
import java.util.Map;


@SpringBootApplication
@ComponentScan(basePackages = "com.leniot.management.track")
public class Main {
	private static final Map<String, String> database = new HashMap<>();
	public static void main(String[] args) {
		HashMapDb.makeDatabase(database);
		SpringApplication.run(Main.class, args);
		ThreadStarter.startAllThreads();
	}
}
