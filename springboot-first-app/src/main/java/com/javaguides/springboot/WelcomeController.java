package com.javaguides.springboot;

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
	printItems();
        return "Welcome to Team Code Masters!!!";
    }

    public void printItems(){
    	 Map items = ImmutableMap.of("coin", 3, "glass", 4, "pencil", 1);

        items.entrySet()
                .stream()
                .forEach(System.out::println);
        
        List<String> fruits = Lists.newArrayList("orange", "banana", "kiwi", 
                "mandarin", "date", "quince");
        
        for (String fruit: fruits) {
            System.out.println(fruit);
        }
    }
}
