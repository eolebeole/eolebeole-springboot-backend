package eolebeole.bemealmap.domain.restuarant;

import eolebeole.bemealmap.domain.entity.Restaurant;
import eolebeole.bemealmap.domain.entity.User;
import eolebeole.bemealmap.domain.user.TokenService;
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

    @Autowired
    private TokenService tokenService;

    @GetMapping("/{restaurantId}")
    public ResponseEntity<Restaurant> getRestaurant(@PathVariable Integer restaurantId) {
        Restaurant restaurant = restaurantService.getRestaurant(restaurantId);
        if (restaurant == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(restaurant);
    }

    @GetMapping
    public ResponseEntity<List<Restaurant>> getAllRestaurant(@RequestHeader("Authorization") String authHeader, Integer userId) {
        if (userId == null) { // ?userId 가 없을 때만 자기가 등록한 식당들을 보여준다.
            User user = tokenService.verifyAuthHeader(authHeader); // TokenRepository에서 토큰 검사
            if (user == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
            userId = user.getUserId();
        }
        List<Restaurant> restaurants = restaurantService.getAllRestaurant(userId);
        return ResponseEntity.status(HttpStatus.OK).body(restaurants);
    }

    @PostMapping
    public ResponseEntity<Restaurant> addRestaurant(@RequestHeader("Authorization") String authHeader, Restaurant restaurant) throws IOException {
        User user = tokenService.verifyAuthHeader(authHeader);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        restaurant.setUserId(user.getUserId());
        return ResponseEntity.status(HttpStatus.OK).body(restaurantService.addRestaurant(restaurant));
    }

    @DeleteMapping
    public void deleteRestaurant(Restaurant restaurant) { restaurantService.deleteRestaurant(restaurant); }




}
