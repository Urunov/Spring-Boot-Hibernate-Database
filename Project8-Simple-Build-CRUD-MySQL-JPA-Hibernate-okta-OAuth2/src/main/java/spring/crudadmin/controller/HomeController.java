package spring.crudadmin.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import spring.crudadmin.model.UserEvent;
import spring.crudadmin.repository.UserEventRepository;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

/**
 * @Created 05 / 06 / 2020 - 10:45 AM
 * @project SpringCrudAdmin
 * @Author Hamdamboy
 */

@RestController
public class HomeController {

    private final UserEventRepository userEventRepository;

    public HomeController(UserEventRepository userEventRepository) {
        this.userEventRepository = userEventRepository;
    }

    @GetMapping("/")
    public ModelAndView home(@AuthenticationPrincipal OidcUser user){
        String token = user.getIdToken().getTokenValue();

        //Check if first time with this token, if so record new auth event
        List<UserEvent> userEventsForToken = userEventRepository.findByToken(token);
        UserEvent event;
        if(userEventsForToken.size() == 0){
            //add new event

            event = new UserEvent(
                    user.getSubject(), user.getClaims().get("name").toString(),
                    token, Date.from(user.getAuthenticatedAt()), Date.from(user.getIssuedAt())
            );
        } else {
            // edit existing event
            event = userEventsForToken.get(0); // there will only ever be one because we update
            event.setLastViewedAt(Date.from(Instant.now()));
        }

        userEventRepository.save(event);

        List<UserEvent> eventsToShow;

        boolean isAdmin = user.getUserInfo().getClaimAsStringList("group").contains("Admin");
        if(isAdmin) {
            eventsToShow = userEventRepository.findAll();
        } else {
            eventsToShow = userEventRepository.findByUserId(user.getSubject());
        }

        ModelAndView mav = new ModelAndView();
        mav.addObject("user", user.getUserInfo());
        mav.addObject("idToken", user.getIdToken().getTokenValue());
        mav.addObject("userEvents", eventsToShow);
        mav.addObject("isAdmin", isAdmin);
        mav.setViewName("index");
        return mav;
    }

    @GetMapping("/delete/{id}")
    public RedirectView deleteUser(@AuthenticationPrincipal OidcUser user,@PathVariable("id") long id, Model model) {
        UserEvent userEvent = userEventRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid event id; " + id));
        userEventRepository.delete(userEvent);

        return new RedirectView("/");
    }
}
