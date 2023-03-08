package eolebeole.bemealmap.domain.restuarant;

import eolebeole.bemealmap.domain.entity.Restaurant;
import eolebeole.bemealmap.domain.entity.User;
import eolebeole.bemealmap.domain.place.PlaceService;
import eolebeole.bemealmap.domain.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private PlaceService placeService;

    public List<Restaurant> getAllRestaurant(Integer userId) {
        return restaurantRepository.findAll().stream().filter(
                restaurant -> restaurant.getUserId() == userId).collect(Collectors.toList());
    }

    public Restaurant getRestaurant(int restaurantId) {
        return restaurantRepository.findById(restaurantId).orElse(null);
    }

    public void addRestaurant(Restaurant restaurant) throws IOException {
        System.out.println(restaurant);
        if(restaurant.getRestaurantId() > 0) {
            throw new IllegalArgumentException(restaurant.toString());
        }
        assert restaurant.getPlaceId() > 0;
        assert placeService.getPlace(restaurant.getPlaceId()) != null;
        restaurantRepository.save(restaurant);
    }

    public void deleteRestaurant(Restaurant restaurant) {
        restaurantRepository.delete(restaurant);
    }

}
