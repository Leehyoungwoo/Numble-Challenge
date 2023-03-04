package Numble.NumbleChallenge.domain.order.exception;

public class NotEnoughStockException extends RuntimeException{
    public NotEnoughStockException(String message) {
        super(message);
    }
}
