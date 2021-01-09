package main.main.Service;

import main.main.Model.User;
import main.main.Model.Subscription;
import main.main.Repository.SubscriptionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final UserService userService;

    public SubscriptionService(SubscriptionRepository subscriptionRepository, UserService userService) {
        this.subscriptionRepository = subscriptionRepository;
        this.userService = userService;
    }

    public void addSubscription(Subscription subscription){
        subscriptionRepository.save(subscription);
    }

    public void addSubscriptions(List<Subscription> subscriptionList){
        if(showALlSubscriptions().isEmpty())
            subscriptionList.forEach(subscriptionRepository::save);
        else
            System.out.println("Subsckrypcje sa w bazie");
    }

    public List<Subscription> showALlSubscriptions(){
        return (List<Subscription>) subscriptionRepository.findAll();
    }

    public Subscription getOneById(Long Id){
        return subscriptionRepository.getById(Id);
    }

    public void assignSubscription(Subscription subscription, String userId, int months){
        System.out.println(subscription.toString());
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusMonths(months);
        User user = userService.getUserById(userId);
        if(subscription.getUsers() == null || !subscription.getUsers().contains(user)){
            Set<User> users = subscription.getUsers();
            Objects.requireNonNull(users).add(user);
            subscription.setUsers(users);
            user.setSubscription(subscription);
            user.setSubscriptionStart(String.valueOf(startDate));
            user.setSubscriptionEnd(String.valueOf(endDate));
            userService.updateUser(user);
            subscriptionRepository.save(subscription);
        }else{
            System.err.println("Posiadasz aktywna subskrypcje "+user.getSubscription().getName()+
                    ", musisz poczekac do jej konca ( "+user.getSubscriptionEnd()+" )"+ "zeby zmienic na inna lub przedluzyc");
        }
    }
}
