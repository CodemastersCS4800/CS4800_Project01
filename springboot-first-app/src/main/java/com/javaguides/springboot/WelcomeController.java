package com.javaguides.springboot;

import com.google.common.base.Joiner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Map;


@RestController
public class WelcomeController {
    @GetMapping ("/welcome")
    public String welcome(){
        return "Welcome to Team Code Masters!!!";
    }

    @GetMapping ("/list")
    public String displayList(){
    	Map items = ImmutableMap.of("coin", 3, "glass", 4, "pencil", 1);
	String itemsList = Joiner.on(",")
				.withKeyValueSeparator(" -> ")
				.join(items);

        List<String> fruits = Lists.newArrayList("orange", "banana", "kiwi", 
                "mandarin", "date", "quince");
        
	String fruitsList = Joiner.on(", ")
				.join(fruits);
        
	return itemsList + " " + fruitsList;
    }
}
