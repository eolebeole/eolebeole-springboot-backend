package eolebeole.bemealmap.domain.restuarant;

import eolebeole.bemealmap.domain.entity.Restaurant;
import eolebeole.bemealmap.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/{restaurantId}")
    public ResponseEntity<Restaurant> getRestaurant(@PathVariable Integer restaurantId) {
        Restaurant restaurant = restaurantService.getRestaurant(restaurantId);
        if (restaurant == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(restaurant);
    }

    @GetMapping
    public ResponseEntity<List<Restaurant>> getAllRestaurant(Integer userId) {
        if (userId == null) {
            User user = User.builder().userId(1).build(); //TODO: 로그인으로 ID값 받기
            userId = user.getUserId();
        }
        List<Restaurant> restaurants = restaurantService.getAllRestaurant(userId);
        return ResponseEntity.status(HttpStatus.OK).body(restaurants);
    }

    @PostMapping
    public void addRestaurant(Restaurant restaurant) throws IOException { restaurantService.addRestaurant(restaurant); }

    @DeleteMapping
    public void deleteRestaurant(Restaurant restaurant) { restaurantService.deleteRestaurant(restaurant); }




}
