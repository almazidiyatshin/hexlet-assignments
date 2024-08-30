package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import io.javalin.http.Context;

public class SessionsController {

    // BEGIN
    public static void root(Context ctx) {
        var name = ctx.sessionAttribute("name");
        var page = new MainPage(name);
        ctx.render("index.jte", model("page", page));
    }

    public static void build(Context ctx) {
        var page = new LoginPage();
        ctx.render("build.jte", model("page", page));
    }

    public static void login(Context ctx) {
        try {
            var name = ctx.formParam("name");
            var user = UsersRepository.findByName(name)
                    .orElseThrow(() -> new RuntimeException("Wrong username or password"));

            var userPassword = user.getPassword();
            var password = ctx.formParam("password");

            if (encrypt(password).equals(userPassword)) {
                ctx.sessionAttribute("name", name);
                ctx.redirect("/");
            } else {
                throw new RuntimeException("Wrong username or password");
            }
        } catch (RuntimeException e) {
            var name = ctx.formParam("name");
            var page = new LoginPage(name, e.getMessage());
            ctx.render("build.jte", model("page", page));
        }
    }

    public static void destroy(Context ctx) {
        ctx.sessionAttribute("name", null);
        ctx.redirect("/");
    }
    // END
}
