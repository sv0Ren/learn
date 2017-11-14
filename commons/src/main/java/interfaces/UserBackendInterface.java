package interfaces;

import models.User;
import java.util.List;

public interface UserBackendInterface {
    /**
     * @PostMapping()
     * @RequestBody user
     * @return
     */
    public void create(User user);

    /**
     * @DeleteMapping()
     * @@RequestBody user
     */
    public void delete(User user);

    /**
     * @DeleteMapping(value="/{userId}")
     * @PathVariable userId
     */
    public void delete(String userId);

    /**
     * @PutMapping
     * @RequestBody newUser
     */
    public void update(User newUser);

    /**
     * @GetMapping(value="/{typ}")
     * @PathVariable typ
     * @RequestBody identifier
     * @return
     */
    public User get( String typ, String identifier);

    /**
     * @GetMapping(value="/id/{userId}")
     * @PathVariable userId
     * @return
     */
    public User get(String userId);

    /**
     * @GetMapping(value={"/{typ}/{identifier}/"})
     * @PathVariable typ
     * @PathVariable identifier
     * @return
     */
    public User getByIdentifier(String typ, String identifier);

    /**
     * @GetMapping(value="")
     * @return
     */
    public List<User> getAll();
}
