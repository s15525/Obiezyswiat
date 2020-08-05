package main.main.Service;

import main.main.Model.Subscription;
import main.main.Repository.SubscriptionRepository;
import main.main.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionService {

    private SubscriptionRepository subscriptionRepository;
    private UserRepository userRepository;

    @Autowired
    public void setSubscriptionRepository(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    public void addSubscription(Subscription subscription){
        subscriptionRepository.save(subscription);
    }

    public void addSubscriptions(List<Subscription> subscriptionList){
        subscriptionList.forEach(subscriptionRepository::save);
    }
}
