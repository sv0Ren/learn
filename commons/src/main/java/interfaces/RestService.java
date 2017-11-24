package interfaces;

import java.util.List;

public interface RestService <T> {

    /**
     * Create an Object
     * @PostMapping()
     * @RequestBody Object
     * @return
     */
    void post(T object);

    /**
     * Delete an Object by identifier
     * @DeleteMapping(value="/{identifier}/")
     * @PathVariable identifier
     */
    void delete(String identifier);

    /**
     * Create or Update an Object
     * @PutMapping
     * @RequestBody Object
     */
    void put(T object);

    /**
     * Get an Object by identifier
     * @GetMapping(value="/{identifier}/")
     * @PathVariable identifier
     * @return
     */
     T get(String identifier);

    /**
     * Get all Objects
     * @GetMapping(value="")
     * @return
     */
    List<T> get();
}
