package org.speculatingwook.shopping;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class OrderProcessingService {
    private List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
    }

    // 주문 총액이 특정 금액 이상인 주문들을 찾습니다.
    public List<Order> findHighValueOrders(double minTotal) {
        return null;
    }

    // 각 고객별 총 주문 금액을 계산합니다.
    public Map<String, Double> calculateTotalOrderValuePerCustomer() {
        return null;
    }

    // 가장 많이 주문된 제품을 찾습니다.
    // 일단 제대로 된 값이 나올 수 있도록 streamAPI를 사용해서 작성해보자. 이 코드에서 발생할 수 있는 문제가 있을까?
    public Product findMostOrderedProduct() {
        return null;
    }

    // 특정 기간 동안의 일일 매출을 계산합니다.
    public Map<LocalDate, Double> calculateDailySales(LocalDate startDate, LocalDate endDate) {
        return null;
    }

    // 주문 상태를 업데이트합니다.
    public void updateOrderStatus(String orderId, UnaryOperator<String> statusUpdater) {

    }

    // 조건에 맞는 주문들의 특정 정보를 추출합니다.
    public <T> List<T> extractOrderInfo(Predicate<Order> filter, Function<Order, T> infoExtractor) {
        return null;
    }

    // 각 카테고리별 판매 수량을 계산합니다.
    public Map<String, Long> countSalesByCategory() {
        return null;
    }

    // 주어진 기간 동안 가장 많은 매출을 올린 고객을 찾습니다.
    // 질문: String은 이 함수에서 사용하기 좋은 타입인가? 만약 아니라면 어떻게 바꾸는 게 더 좋을까?
    public String findTopCustomer(LocalDate startDate, LocalDate endDate) {
        return null;
    }

    // 모든 주문에 대해 주어진 작업을 수행합니다.
    public void processOrders(Consumer<Order> orderProcessor) {
        orders.forEach(orderProcessor);
    }

    // 주문들을 특정 기준으로 정렬합니다.
    public List<Order> sortOrders(Comparator<Order> orderComparator) {
        return null;
    }
}