package com.javaguides.springboot;
import org.springframework.ui.Model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//------------------------------------------------------------------------------------

@RestController
public class WelcomeController {
    private List<String> hyperlinks = new ArrayList<>();

    @GetMapping ("/welcome")
    public String welcome() {
        // Combine all the strings in the hyperlinks list into a single string
        String combinedHyperlinks = String.join(", ", hyperlinks);
        //Returns combined strings
        return "Welcome to Team Code Masters!!!\nHyperlinks: " + combinedHyperlinks;
    }//------------------------


    //------------------------------------------------------------------------------------
    @GetMapping("/add-url")
    public String addUrl(@RequestParam String url) {
        try {
            // Connect to the URL and parse its HTML content.
            Document document = Jsoup.connect(url).get();

            // Extract hyperlinks (anchor tags).
            Elements links = document.select("a[href]");

            // Add hyperlinks to the list.
            for (Element link : links) {
                hyperlinks.add(link.attr("href"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/";
    }

    //---------------------------------------------------------------
    @GetMapping("/")
    public String home(Model model) {
        List<String> hyperlinks = new ArrayList<>();
        hyperlinks.add("https://google.com");
        hyperlinks.add("https://github.com");
        // Add hyperlinks to the model for rendering in the template.
        model.addAttribute("hyperlinks", hyperlinks);
        StringBuilder linkList = new StringBuilder();

        for (String hyperlink : hyperlinks) {
            linkList.append(hyperlink).append("<br>"); // Assuming you want to separate them with line breaks.
        }

        return linkList.toString();
    }
}//--end WebController


