package io.ziogd;

import static io.micronaut.http.MediaType.APPLICATION_JSON;

import io.micronaut.http.annotation.*;
import java.util.List;
import java.util.UUID;

@Controller("/users")
public class UsersController {
    @Get(uri="/", produces=APPLICATION_JSON)
    public List<User> getAll() {
        final var user1 = new User(UUID.randomUUID().toString(), "Gary Ascuy", 22);
        final var user2 = new User(UUID.randomUUID().toString(), "Gory Yucsa", 66);
        return List.of(user1, user2);
    }

    @Get(uri="/{sid}", produces=APPLICATION_JSON)
    public User getBy(final String sid) {
        return new User(sid, "Gory Yucsa", 66);
    }

    @Post(uri="/", consumes=APPLICATION_JSON, produces=APPLICATION_JSON)
    public User create(@Body final User user) {
        final var sid = UUID.randomUUID().toString();
        return new User(sid, user.getName(), user.getAge());
    }

    @Put(uri="/{sid}", consumes=APPLICATION_JSON, produces=APPLICATION_JSON)
    public User update(final String sid, @Body final User user) {
        return new User(sid, user.getName(), user.getAge());
    }

    @Delete(uri="/{sid}", produces=APPLICATION_JSON)
    public User delete(final String sid) {
        return new User(sid, "Gory Yucsa", 66);
    }
}