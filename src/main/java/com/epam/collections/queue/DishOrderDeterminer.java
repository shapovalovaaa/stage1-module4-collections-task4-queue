package com.epam.collections.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DishOrderDeterminer {
    public List<Integer> determineDishOrder(int numberOfDishes, int everyDishNumberToEat) {
        List<Integer> order = new ArrayList<>();
        LinkedList<Integer> dishes = IntStream.range(1, numberOfDishes + 1).boxed().collect(Collectors.toCollection(LinkedList::new));
        int i = 1;
        while (!dishes.isEmpty()) {
            int dish = dishes.poll();
            if (i % everyDishNumberToEat == 0) {
                order.add(dish);
            } else {
                dishes.add(dish);
            }
            i++;
        }
        return order;
    }
}
