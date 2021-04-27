package personal.springframework.controllers;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import personal.springframework.SpringJokeApp.services.JokeService;

@Controller
public class JokeController {

    private final JokeService jokeService;

    // @Autowired But we dont need this at this moment, because we use only one constructor in this class so Spring
    // automatically do dependency injection for us.
    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @RequestMapping({"/", ""})
    public String showJoke (Model model) {

        model.addAttribute("joke", jokeService.getJoke());

        return "index";
    }
}
