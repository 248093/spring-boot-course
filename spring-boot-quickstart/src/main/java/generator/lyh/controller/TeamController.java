package generator.lyh.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import generator.lyh.poji.Team;

@RestController
@RequestMapping("/team")
@Slf4j
public class TeamController {
    @PostMapping
    public String team(@Validated @RequestBody Team team) {
        log.info("team:{}", team);
        return team.toString();
    }

}
