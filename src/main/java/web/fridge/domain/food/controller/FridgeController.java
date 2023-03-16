package web.fridge.domain.food.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.fridge.domain.food.service.FridgeService;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/fridge", produces = "application/json; charset=utf8")
public class FridgeController {
    private final FridgeService fridgeService;
}
