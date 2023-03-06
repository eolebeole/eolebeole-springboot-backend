package eolebeole.bemealmap.domain.restuarant;

import eolebeole.bemealmap.domain.entity.Restaurant;
import eolebeole.bemealmap.domain.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<Restaurant> getAllRestaurant(Integer userId) {
        return restaurantRepository.findAll().stream().filter(
                restaurant -> restaurant.getUserId() == userId).collect(Collectors.toList());
    }


    public void addRestaurant(Restaurant restaurant) {
        if(restaurant.getRestaurantId() > 0) {
            throw new IllegalArgumentException(restaurant.toString());
        }
        restaurantRepository.save(restaurant);
    }

    public void deleteRestaurant(Restaurant restaurant) {
        restaurantRepository.delete(restaurant);
    }

}
