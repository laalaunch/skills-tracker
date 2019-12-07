package org.launchcode.skillstracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SkillsController {

    @RequestMapping(value = "/")
    @ResponseBody
    public String main() {
        String html = "<h1>Skills Tracker</h1>" +
                "<h2>We have a few skills we would like to learn. Here is the list!</h2>" +
                "<ol>" +
                "<li>Java</li>" +
                "<li>JavaScript</li>" +
                "<li>CSS</li>";
                return html;
    }

    @RequestMapping(value = "/formSubmit", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String defForm(@RequestParam(defaultValue = "Python") String coder,
    @RequestParam(defaultValue = "Java") String firstChoice,
    @RequestParam(defaultValue = "JavaSScript") String secondChoice,
    @RequestParam(defaultValue = "CSS") String thirdChoice) {

        return "<h1>" + coder + "</h1>\n" +
                "<h3><ol>" +
                "<li>" + firstChoice + "</li>" +
                "<li>" + secondChoice + "</li>" +
                "<li>" + thirdChoice + "</li>" +
                "</ol></h3>";
    }

    @GetMapping("/form")
    @ResponseBody
    public String skillsForm() {
        String languageOptions =
               " <option value=\"Java\">Java</option>\n" +
               " <option value=\"JavaScript\">JavaScript</option>\n" +
               " <option value=\"CSS\">CSS</option>\n";

        String html =
                "<html>" +
                "<body>" +
                "<form  method ='post' action = '/formSubmit'>" +
                "<h2>Name:</h2>" +
                "<input type='text' name='coder' />" +
                "<h3>My Favorite Language</h3>" +
                "<select name = 'firstChoice'>\n" +
                        languageOptions +
                "</select>" +
                "<h3>My Second Choice</h3>" +
                        "<select name = 'secondChoice'>\n" +
                        languageOptions +
                        "</select>"+
                "<h3>My Third Choice</h3>" +
                        "<select name = 'thirdChoice'>\n" +
                        languageOptions +
                        "</select><br>"+
                "<input type='submit' value='Submit' /> " +
                "</form>" +
                "</body>" +
                "</html>";
        return html;
    }

}
