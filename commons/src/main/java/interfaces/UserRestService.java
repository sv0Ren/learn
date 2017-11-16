package interfaces;

import to.User;
import java.util.List;

public interface UserRestService extends RestService<User> {

    /**
     * @PostMapping()
     * @RequestBody user
     * @return
     */
    @Override
    void post(User user);

    /**
     * @DeleteMapping(value="/{identifier}/")
     * @PathVariable identifier
     */
    @Override
    void delete(String identifier);

    /**
     * @PutMapping
     * @RequestBody User
     */
    @Override
    void put(User user);

    /**
     * @GetMapping(value="/{identifier}/")
     * @PathVariable identifier
     * @return
     */
    @Override
    User get(String identifier);

    /**
     * @GetMapping(value="")
     * @return
     */
    @Override
    List<User> get();
}
