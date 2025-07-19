package com.fotile.grpc.invoker.endpoint;


import com.fotile.grpc.invoker.service.GreeterUserServiceImpl;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/hello")
@RestController
public class HelloController {

    private final GreeterUserServiceImpl greeterUserService;

    public HelloController(GreeterUserServiceImpl greeterUserService) {
        this.greeterUserService = greeterUserService;
    }

    @GetMapping("/user/name/{id}")
    public String userName(@PathVariable("id")Long id){
        return greeterUserService.sayBlockHello(id);
    }


}
