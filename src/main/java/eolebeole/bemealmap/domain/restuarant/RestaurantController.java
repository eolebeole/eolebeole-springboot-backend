package eolebeole.bemealmap.domain.restuarant;

import eolebeole.bemealmap.domain.entity.Restaurant;
import eolebeole.bemealmap.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<Restaurant>> getRestaurant(@PathVariable Integer userId) {
        User user = User.builder().userId(1).build(); //TODO: 로그인으로 ID값 받기
        List<Restaurant> restaurant = restaurantService.getAllRestaurant(user.getUserId());
        if (restaurant == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(restaurant);
    }

//    @PostMapping
//    public void addRestaurant(Restaurant restaurant) { RestaurantService.addRestaurant(restaurant); }

//    @DeleteMapping
//    public void deleteRestaurant(Restaurant restaurant) { RestaurantService.deleteRestaurant(restaurant); }




}
