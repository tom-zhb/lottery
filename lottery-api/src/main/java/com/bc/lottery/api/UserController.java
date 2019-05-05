package com.bc.lottery.api;

import com.bc.lottery.common.core.annotation.TokenAuth;
import com.bc.lottery.common.core.api.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(maxAge = 86400)
@RestController
@RequestMapping(value = "/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @TokenAuth
    @RequestMapping(value = "/login/", method = {RequestMethod.POST})
    public R login(@PathVariable String userName, @PathVariable Long password) {
        return null;
    }

    @PostMapping(value = "/register")
    public R register(@RequestBody RegisterVO registerVO) {
        return null;
    }

    @GetMapping(value = "/classroomInfo/{classroomId}")
    public R getClassroomInfoByRoomId(@PathVariable String classroomId,
                                                    @RequestParam("accountId") final Integer accountId) {
        return null;
    }
}
