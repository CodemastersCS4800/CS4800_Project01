package com.javaguides.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//------------------------------------------------------------------------------------
//Restfull API
@RestController
public class WelcomeController {

    @GetMapping ("/welcome")
    public String welcome() {
        return "Welcome to Team Code Masters!!!\n: ";
    }//------------------------




    //------------------------------------------------------------------------------------
//    @GetMapping("/add-url")
//    public String addUrl(@RequestParam String url) {
//        try {
//            // Connect to the URL and parse its HTML content.
//            Document document = Jsoup.connect(url).get();
//
//            // Extract hyperlinks (anchor tags).
//            Elements links = document.select("a[href]");
//
//            // Add hyperlinks to the list.
//            for (Element link : links) {
//                hyperlinks.add(link.attr("href"));
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return "redirect:/";
//    }

    //---------------------------------------------------------------
//    @GetMapping("/")
//    public String home(Model model) {
//        List<String> hyperlinks = new ArrayList<>();
//        hyperlinks.add("https://google.com");
//        hyperlinks.add("https://github.com");
//        // Add hyperlinks to the model for rendering in the template.
//        model.addAttribute("hyperlinks", hyperlinks);
//        StringBuilder linkList = new StringBuilder();
//
//        for (String hyperlink : hyperlinks) {
//            linkList.append(hyperlink).append("<br>"); // Assuming you want to separate them with line breaks.
//        }
//
//        return linkList.toString();
//    }
}//--end WebController


