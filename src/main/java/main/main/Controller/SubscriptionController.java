package main.main.Controller;

import main.main.Model.Subscription;
import main.main.Service.SubscriptionService;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/subscription")
public class SubscriptionController {
    private final SubscriptionService subscriptionService;
    private String userId;

    public SubscriptionController (SubscriptionService subscriptionService){
        this.subscriptionService = subscriptionService;
    }

    @GetMapping("/allSubscriptions")
    public String home(Model model, HttpServletRequest request){
        KeycloakAuthenticationToken principal = (KeycloakAuthenticationToken) request.getUserPrincipal();
        System.out.println(principal.getAccount().getKeycloakSecurityContext().getIdToken().getSubject()+ " ---ID");
        userId = principal.getAccount().getKeycloakSecurityContext().getIdToken().getSubject();

        List<Subscription> subscriptionList = new ArrayList<>();
        subscriptionList.add(new Subscription("Standard", "max 5 pracownikow", 30f));
        subscriptionList.add(new Subscription("Premium", "max 20 pracownikow", 80f));
        subscriptionList.add(new Subscription("Unlimited", "nielimitowana liczba pracownikow", 120f));

        subscriptionService.addSubscriptions(subscriptionList);
        model.addAttribute("subscriptionList", subscriptionService.showALlSubscriptions());
        return "subscription";
    }

    @GetMapping("/assignSubscription")
    public String assignSubscription(Long Id){
        subscriptionService.assignSubscription(subscriptionService.getOneById(Id), userId, 1);
        return "redirect:/home";
    }
}
