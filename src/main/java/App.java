import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        String layout = "public/templates/layout.vtl";

        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }

        port(port);

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "public/templates/index.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("heros/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "public/templates/hero-form.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/heros", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("heros", Hero.all());
            model.put("template", "public/templates/heros.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());


//        post("/heros", (request,response) -> {
//            Map<String, Object> model = new HashMap<String, Object>();
//            Squad squad = Squad.find(Integer.parseInt(request.queryParams("squadId")));
//            String name = request.queryParams("name");
//            String age= request.queryParams("age");
//            String superpower = request.queryParams("superpower");
//            String weakness = request.queryParams("weakness");
//            Hero newHero = new Hero(name, age, superpower,weakness);
//            squad.addHero(newHero);
//            model.put("squad", squad);
//            model.put("template", "public/templates/squad-heros-success.vtl");
//            return new ModelAndView(model, layout);
//        }, new VelocityTemplateEngine());

        post("/heros", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Squad squad = Squad.find(Integer.parseInt(request.queryParams("squadId")));
            String name = request.queryParams("name");
            String age= request.queryParams("age");
            String superpower = request.queryParams("superpower");
            String weakness = request.queryParams("weakness");
            Hero newHero = new Hero(name, age, superpower,weakness);
            if (Squad.heroAlreadyExists(newHero)) {
                String heroExists = "Hero " + name + " already exists in a squad";
                model.put("heroExists", heroExists);
            }
            else{
                squad.addHero(newHero);
            }
            model.put("squad", squad);
            model.put("template", "public/templates/squad-heros-success.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
        

        get("/squads/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "public/templates/squad-form.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        post("/squads", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            String cause = request.queryParams("cause");
            String max = request.queryParams("max");
            Squad newSquad = new Squad(name, cause, max);
            model.put("template", "public/templates/squad-success.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/squads", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("squads", Squad.all());
            model.put("template", "public/templates/squads.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/squads/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Squad squad = Squad.find(Integer.parseInt(request.params(":id")));
            model.put("squad", squad);
            model.put("template", "public/templates/squad.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("squads/:id/heros/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Squad squad = Squad.find(Integer.parseInt(request.params(":id")));
            model.put("squad", squad);
            model.put("template", "public/templates/squad-heros-form.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

    }
}